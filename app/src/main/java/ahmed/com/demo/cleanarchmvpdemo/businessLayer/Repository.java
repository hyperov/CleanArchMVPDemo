package ahmed.com.demo.cleanarchmvpdemo.businessLayer;

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

/* Follows the repository pattern
 * used as interactor or mediator between businessLayer and Data Layer.
 * contains methods that *fetch data whether from server or some place else.
 * this methods are used to send events back and front through layers of App.
 * from Business to data and vice versa.
 * [Clean Architecture]
 */
public interface Repository {

    void getRetrofitApi();


     interface DataCallback {

        void getRetrofitCallback(ArrayList<FlowerEntity> flowerEntities, Boolean isSuccess,String error);
    }

}
