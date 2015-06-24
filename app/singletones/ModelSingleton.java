package singletones;

import controllers.Application;
import ua.intor.api.IntorModelBasicAPI;
import ua.intor.api.IntorModelBasicAPIImpl;
import ua.intor.exceptions.LoadingSystemParametersFailedException;

/**
 * Created by sancho on 17.06.15.
 */
public class ModelSingleton {
    private static ModelSingleton instance = new ModelSingleton();
    private IntorModelBasicAPI modelApi = null;

    private ModelSingleton() {
        try {
            modelApi = IntorModelBasicAPIImpl.getAPIImpl();
        } catch (LoadingSystemParametersFailedException e) {
            System.out.println("0005");
        }
    }

    public static ModelSingleton getInstance() {
        return instance;
    }

    public IntorModelBasicAPI getApi() {
        return modelApi;
    }
}
