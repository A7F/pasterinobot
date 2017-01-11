package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Localisation
 * @date 25/01/15
 */
public class LocalisationService {
    private static LocalisationService instance = null;
    private final HashMap<String, String> supportedLanguages = new HashMap<>();

    private ResourceBundle english;
    private ResourceBundle italian;

    private class CustomClassLoader extends ClassLoader {
        public CustomClassLoader(ClassLoader parent) {
            super(parent);

        }

        @Override
        public InputStream getResourceAsStream(String name) {
            InputStream utf8in = getParent().getResourceAsStream(name);
            
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            byte[] buf = new byte[8000];
            int bytesread = 0;
            
            try {
                while((bytesread = utf8in.read(buf)) != -1){
                    bao.write(buf,0,bytesread);
                }
                
                byte[] data = bao.toByteArray();
                ByteArrayInputStream bin = new ByteArrayInputStream(data);
                System.out.println(bin.available());
                return bin;
                
            } catch (IOException ex) {
                ex.toString();
            } 
            return null;
        }
    }

    /**
     * Singleton
     * @return Instance of localisation service
     */
    public static LocalisationService getInstance() {
        if (instance == null) {
            synchronized (LocalisationService.class) {
                if (instance == null) {
                    instance = new LocalisationService();
                }
            }
        }
        return instance;
    }

    /**
     * Private constructor due to singleton
     */
    private LocalisationService() {
        CustomClassLoader loader = new CustomClassLoader(Thread.currentThread().getContextClassLoader());
        english = ResourceBundle.getBundle("localisation.strings", new Locale("en", "US"), loader);
        supportedLanguages.put("en", "English");
        italian = ResourceBundle.getBundle("localisation.strings", new Locale("it", "IT"), loader);
        supportedLanguages.put("it", "Italiano");
    }

    /**
     * Get a string in default language (en)
     * @param key key of the resource to fetch
     * @return fetched string or error message otherwise
     */
    public String getString(String key) {
        String result;
        try {
            result = english.getString(key);
        } catch (MissingResourceException e) {
            System.out.println("not found key...  "+key);
            result = "String not found";
        }

        return result;
    }

    /**
     * Get a string in default language
     * @param key key of the resource to fetch from localisations
     * @param language code key for language (such as "EN" for english)
     * @return fetched string or error message otherwise
     */
    public String getString(String key, String language) {
        String result;
        try {
            switch (language.toLowerCase()) {
                case "en":
                    result = english.getString(key);
                    break;
                case "it":
                    result = italian.getString(key);
                    break;
                default:
                    result = english.getString(key);
                    break;
            }
        } catch (MissingResourceException e) {
            result = english.getString(key);
        }

        return result;
    }

    public HashMap<String, String> getSupportedLanguages() {
        return supportedLanguages;
    }

    public String getLanguageCodeByName(String language) {
        return supportedLanguages.entrySet().stream().filter(x -> x.getValue().equals(language)).findFirst().get().getKey();
    }
}
