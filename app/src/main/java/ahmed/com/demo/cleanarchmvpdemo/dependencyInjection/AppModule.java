package ahmed.com.demo.cleanarchmvpdemo.dependencyInjection;

import javax.inject.Named;
import javax.inject.Singleton;

import ahmed.com.demo.cleanarchmvpdemo.application.App;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.Repository;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCase;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCaseImp;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.RepositoryImp;
import ahmed.com.demo.cleanarchmvpdemo.presentationLayer.MainActivity;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ahmed.com.demo.cleanarchmvpdemo.businessLayer.Repository.*;

/**
 * Created by Ahmed Nabil on 10/21/2016.
 */

@Module
public class AppModule {

    App mApp;

    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Singleton
    @Provides
    public App provideApp() {
        return mApp;
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl("http://services.hanselandpetal.com").
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new RepositoryImp();
    }


    @Provides
    @Named("event")
    public UseCase provideUseCase() {
//        return new UseCaseImp();
        return new UseCaseImp();
    }


//    @Provides
//    public UseCaseImp provideUseCaseImp() {
//        return new UseCaseImp();
//    }


    @Provides
    @Named("callback")
    public DataCallback provideDataCallback() {
        return new UseCaseImp();
    }

    @Singleton
    @Provides
    public MainActivity provideMainActivity() {
        return new MainActivity();
    }
}
