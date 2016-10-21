package ahmed.com.demo.cleanarchmvpdemo.businessLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.RepositoryImp;
import ahmed.com.demo.cleanarchmvpdemo.presentationLayer.Presenter;

/**
 * Use Case Implementation
 * includes methods that provide the needed action for every useCase
 * [Clean Architecture]
 */
public class UseCaseImp implements UseCase, Repository.DataCallback {

    RepositoryImp repositoryImp;
    Presenter presenter ;

    public UseCaseImp(RepositoryImp repositoryImp){
        this.repositoryImp=repositoryImp;
        this.presenter=new Presenter(this);
    }

    @Override
    public void fabClickEvent() {
        repositoryImp.getRetrofitApi();
    }

    //for future upgrade
    @Override
    public void fetchData() {

    }

    @Override
    public void getRetrofitCallback(ArrayList<FlowerEntity> flowerEntities, Boolean isSuccess, String error) {
        if (flowerEntities != null && isSuccess) {
            presenter.getDataSuccess(flowerEntities);
        } else {
            presenter.getDataFailure(error);
        }
    }
}
