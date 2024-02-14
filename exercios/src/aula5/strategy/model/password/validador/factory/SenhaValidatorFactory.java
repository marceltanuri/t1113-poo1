package aula5.strategy.model.password.validador.factory;

import aula5.strategy.exception.LocalizadorDeValidadoresException;
import aula5.strategy.model.password.validador.SenhaValidator;
import aula5.strategy.util.PropertiesUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SenhaValidatorFactory {
    private static SenhaValidatorFactory instance;

    private SenhaValidatorFactory() {

    }


    public static synchronized SenhaValidatorFactory getInstance() throws LocalizadorDeValidadoresException {
        if (instance == null) {
            instance = new SenhaValidatorFactory();
        }
        return instance;
    }

    public List<SenhaValidator> getImplementations() throws LocalizadorDeValidadoresException {
        List<SenhaValidator> implementations = new ArrayList<>();

        String pacoteValidadores = PropertiesUtil.getInstance().getProperty("usuario.validator.password.impl.package");
        String classNamesProperty = PropertiesUtil.getInstance().getProperty("usuario.senha.validadores");

        if (classNamesProperty != null && !classNamesProperty.isEmpty()) {
            String[] classNames = classNamesProperty.split(",");
            for (String className : classNames) {
                try {
                    Class<?> clazz = Class.forName(pacoteValidadores+ "."+ className.trim());
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    Object obj = constructor.newInstance();
                    if (obj instanceof SenhaValidator) {
                        implementations.add((SenhaValidator) obj);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    throw new LocalizadorDeValidadoresException("Erro ao instanciar validador de senha", e);
                }
            }
        }

        return implementations;
    }
}
