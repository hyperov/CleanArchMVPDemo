package ahmed.com.demo.cleanarchmvpdemo.application;

import android.app.Application;

import ahmed.com.demo.cleanarchmvpdemo.dependencyInjection.AppComponent;
import ahmed.com.demo.cleanarchmvpdemo.dependencyInjection.AppModule;
import ahmed.com.demo.cleanarchmvpdemo.dependencyInjection.DaggerAppComponent;

/**
 * Created by Ahmed Nabil on 10/21/2016.
 */

public class App extends Application {

    public static AppComponent getAppComponent() {

        return appComponent;

    }

   static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }


}
