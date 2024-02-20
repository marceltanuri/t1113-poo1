package aula5.strategy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static PropertiesUtil instance;
    private Properties properties;

    private PropertiesUtil() {
        properties = new Properties();
        try (InputStream input = PropertiesUtil.class.getResourceAsStream(Constants.ARQUIVO_PROPRIEDADES_PATH)) {
            if (input == null) {
                throw new RuntimeException("Arquivo de propriedades não encontrado");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de propriedades", e);
        }
    }

    public static synchronized PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
