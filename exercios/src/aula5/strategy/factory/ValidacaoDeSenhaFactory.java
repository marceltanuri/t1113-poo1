package aula5.strategy.factory;

import aula5.strategy.exception.LocalizadorDeValidadoresException;
import aula5.strategy.model.ValidadorDeSenha;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ValidacaoDeSenhaFactory {
    private static ValidacaoDeSenhaFactory instance;
    private final Properties properties;

    private ValidacaoDeSenhaFactory(String propertiesFile) throws LocalizadorDeValidadoresException {
        properties = new Properties();
        try (InputStream input = ValidacaoDeSenhaFactory.class.getResourceAsStream("/aula5/strategy/"+propertiesFile)) {
            if (input == null) {
                throw new LocalizadorDeValidadoresException("Arquivo de propriedades não encontrado");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new LocalizadorDeValidadoresException("Erro ao carregar arquivo de propriedades", e);
        }
    }


    public static synchronized ValidacaoDeSenhaFactory getInstance(String propertiesFileName) throws LocalizadorDeValidadoresException {
        if (instance == null) {
            instance = new ValidacaoDeSenhaFactory(propertiesFileName);
        }
        return instance;
    }

    public List<ValidadorDeSenha> getImplementations() throws LocalizadorDeValidadoresException {
        List<ValidadorDeSenha> implementations = new ArrayList<>();

        String classNamesProperty = properties.getProperty("usuario.senha.validadores");
        if (classNamesProperty != null && !classNamesProperty.isEmpty()) {
            String[] classNames = classNamesProperty.split(",");
            for (String className : classNames) {
                try {
                    Class<?> clazz = Class.forName(className.trim());
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    Object obj = constructor.newInstance();
                    if (obj instanceof ValidadorDeSenha) {
                        implementations.add((ValidadorDeSenha) obj);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    throw new LocalizadorDeValidadoresException("Erro ao instanciar validador de senha", e);
                }
            }
        }

        return implementations;
    }
}
