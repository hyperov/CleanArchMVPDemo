package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */


import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCase;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;

/**
 * Presenter class in MVP(Model View Presenter) pattern..in presentation layer
 * [Clean Architecture]
 */
public class Presenter implements UseCase.UseCaseCallback {
    //
    private UseCase useCase;
    private MainActivity mainActivity;

    public Presenter(UseCase useCase) {
        this.useCase = useCase;
        mainActivity = new MainActivity();
//        this.mainActivity=mainActivity;
    }


    public void onClickEvent() {
//        ((UseCase) useCaseImp).fabClickEvent();
        useCase.fabClickEvent();

    }

    //callback success
    @Override
    public void getDataSuccess(ArrayList<FlowerEntity> flowerEntities) {
        ((ViewCallback) mainActivity).fabClickCallbackSuccess(flowerEntities);
        
    }

    //callback failure
    @Override
    public void getDataFailure(String error) {
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
