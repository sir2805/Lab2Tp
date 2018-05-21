package by.nc.school.dev.example.spring.data.service;

import java.util.ResourceBundle;

class AppStringsServiceImpl implements AppStringsService {

    final static private String STRINGS_BUNDLE = "app-strings";

    protected ResourceBundle bundle;

    private AppStringsServiceImpl() {
        // TODO add multilingual support based on user profile
        bundle = ResourceBundle.getBundle(STRINGS_BUNDLE);
    }

    @Override
    public String getString(String key) {
        return bundle.getString(key);
    }

    @Override
    public String getString(String key, Object... substitution) {
        return String.format(bundle.getString(key), substitution);
    }
}
