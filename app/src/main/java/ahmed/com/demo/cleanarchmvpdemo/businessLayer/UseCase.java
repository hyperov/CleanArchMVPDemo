package ahmed.com.demo.cleanarchmvpdemo.businessLayer;

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

/*
 * used as interactor or mediator between businessLayer and Presentation Layer.
 * contains methods that represent use cases ex: button click or fetch data.
 * this methods are used to send events back and front through layers of App.
 * from presentation to data and vice versa.
 * [Clean Architecture]
 */
public interface UseCase {

    /**
     * in that demo app ..i'll not fetch data in beginning of application
     * but only when user click fab
     * so use case of sending events will only be fabclick
     * fetchdata event not required
     */

    //click fab
    //presentation to data layer
    void fabClickEvent();

    interface UseCaseCallback {

        /**
         * data to presentation layer
         * recieve data if success response
         */
        void getDataSuccess(ArrayList<FlowerEntity> flowerEntities);

        /**
         * data to presentation layer
         * receive failure message
         */
        void getDataFailure(String error);
    }


    /**
     * for future upgrades
     */
    //presentation to data layer
    void fetchData();
}
