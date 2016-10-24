package ahmed.com.demo.cleanarchmvpdemo.businessLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

import java.util.ArrayList;

import javax.inject.Inject;

import ahmed.com.demo.cleanarchmvpdemo.application.App;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;
import ahmed.com.demo.cleanarchmvpdemo.presentationLayer.Presenter;
import dagger.Lazy;

/**
 * Use Case Implementation
 * includes methods that provide the needed action for every useCase
 * [Clean Architecture]
 */
public class UseCaseImp implements UseCase, Repository.DataCallback {


    @Inject
    Repository repository;

    //callback
    @Inject
    Lazy<Presenter> presenter;


//    @Inject
    public UseCaseImp() {
        App.getAppComponent().inject(this);


    }

    @Override
    public void fabClickEvent() {
        repository.getRetrofitApi();
    }

    //for future upgrade
    @Override
    public void fetchData() {

    }

    @Override
    public void getRetrofitCallback(ArrayList<FlowerEntity> flowerEntities, Boolean isSuccess, String error) {
//        presenter = new Presenter();
        if (flowerEntities != null && isSuccess) {
            presenter.get().getDataSuccess(flowerEntities);
        } else {
            presenter.get().getDataFailure(error);
        }
    }
}
