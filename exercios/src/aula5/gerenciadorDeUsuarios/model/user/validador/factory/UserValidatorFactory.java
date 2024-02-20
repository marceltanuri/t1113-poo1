package aula5.strategy.model.user.validador.factory;

import aula5.strategy.exception.LocalizadorDeValidadoresException;
import aula5.strategy.model.user.validador.UserValidator;
import aula5.strategy.util.Constants;
import aula5.strategy.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserValidatorFactory {
    private static UserValidatorFactory instance;
    private final Properties properties;

    private UserValidatorFactory() throws LocalizadorDeValidadoresException {
        properties = new Properties();
        try (InputStream input = UserValidatorFactory.class.getResourceAsStream(Constants.ARQUIVO_PROPRIEDADES_PATH)) {
            if (input == null) {
                throw new LocalizadorDeValidadoresException("Arquivo de propriedades não encontrado");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new LocalizadorDeValidadoresException("Erro ao carregar arquivo de propriedades", e);
        }
    }


    public static synchronized UserValidatorFactory getInstance() throws LocalizadorDeValidadoresException {
        if (instance == null) {
            instance = new UserValidatorFactory();
        }
        return instance;
    }

    public List<UserValidator> getImplementations() throws LocalizadorDeValidadoresException {
        List<UserValidator> implementations = new ArrayList<>();

        String validatorImplPackage = PropertiesUtil.getInstance().getProperty("usuario.validator.impl.package");
        String implClassNames = properties.getProperty("usuario.validadores");
        if (implClassNames != null && !implClassNames.isEmpty()) {
            String[] classNames = implClassNames.split(",");
            for (String className : classNames) {
                try {
                    Class<?> clazz = Class.forName(validatorImplPackage + "." + className.trim());
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    Object obj = constructor.newInstance();
                    if (obj instanceof UserValidator) {
                        implementations.add((UserValidator) obj);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    throw new LocalizadorDeValidadoresException("Erro ao instanciar validador de usuario", e);
                }
            }
        }

        return implementations;
    }
}
