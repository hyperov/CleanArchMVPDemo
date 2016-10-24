package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */


import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import ahmed.com.demo.cleanarchmvpdemo.application.App;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCase;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;
import dagger.Lazy;

/**
 * Presenter class in MVP(Model View Presenter) pattern..in presentation layer
 * [Clean Architecture]
 */
public class Presenter implements UseCase.UseCaseCallback {
    //
    @Inject
    @Named("event")
    Lazy<UseCase> useCase;

    @Inject
    MainActivity mainActivity;

    @Inject
    public Presenter() {
        App.getAppComponent().inject(this);
//        this.mainActivity=mainActivity;
    }


    public void onClickEvent() {
//        ((UseCase) useCase).fabClickEvent();
        useCase.get().fabClickEvent();

    }

    //callback success
    @Override
    public void getDataSuccess(ArrayList<FlowerEntity> flowerEntities) {
//        mainActivity = new MainActivity();
        ((ViewCallback) mainActivity).fabClickCallbackSuccess(flowerEntities);

    }

    //callback failure
    @Override
    public void getDataFailure(String error) {
//        mainActivity = new MainActivity();
        ((ViewCallback) mainActivity).fabClickCallbackFailure(error);
    }

    /**
     * callbacks from business layer
     */
    interface ViewCallback {

        void fabClickCallbackSuccess(ArrayList<FlowerEntity> flowerEntities);

        void fabClickCallbackFailure(String error);

    }


}
