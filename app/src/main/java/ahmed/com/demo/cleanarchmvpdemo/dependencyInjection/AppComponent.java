package ahmed.com.demo.cleanarchmvpdemo.dependencyInjection;

import javax.inject.Singleton;

import ahmed.com.demo.cleanarchmvpdemo.application.App;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCaseImp;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.RepositoryImp;
import ahmed.com.demo.cleanarchmvpdemo.presentationLayer.MainActivity;
import ahmed.com.demo.cleanarchmvpdemo.presentationLayer.Presenter;
import dagger.Component;

/**
 * Created by Ahmed Nabil on 10/21/2016.
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    void inject(App mApp);
    void inject(RepositoryImp repositoryImp);
    void inject(UseCaseImp useCaseImp);
    void inject(Presenter presenter);
    void inject(MainActivity mainActivity);


}
