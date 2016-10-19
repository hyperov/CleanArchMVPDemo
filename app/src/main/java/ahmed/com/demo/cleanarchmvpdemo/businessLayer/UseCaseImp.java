package ahmed.com.demo.cleanarchmvpdemo.businessLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.RepositoryImp;

/**
 * Use Case Implementation
 * includes methods that provide the needed action for every useCase
 * [Clean Architecture]
 */
public class UseCaseImp implements UseCase,Repository.DataCallback {

    RepositoryImp repositoryImp = new RepositoryImp();

    @Override
    public void fabClickEvent() {
        repositoryImp.getRetrofitApi();
    }

    @Override
    public void fetchData() {

    }

    @Override
    public void getRetrofitCallback(ArrayList<FlowerEntity> flowerEntities, Boolean isSuccess,String error) {
        if(flowerEntities!=null &&isSuccess){

        }else{

        }
    }
}
