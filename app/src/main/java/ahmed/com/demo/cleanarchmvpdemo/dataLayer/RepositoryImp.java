package ahmed.com.demo.cleanarchmvpdemo.dataLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

import android.util.Log;

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.businessLayer.Repository;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCaseImp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Repository implementation follows the repository pattern
 * includes methods that provide the app with data
 * whether from api or sqlite..etc
 * [Clean Architecture]
 */
public class RepositoryImp implements Repository {

    private UseCaseImp useCaseImp;

    private static final String RETROFIT_TAG = "Retrofit";

    private ArrayList<FlowerEntity> flowerEntities;
    private String responseError = "";


    public void getRetrofitApi() {

        useCaseImp = new UseCaseImp(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://services.hanselandpetal.com").
                addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

        Call<ArrayList<FlowerEntity>> call = retrofitApi.getFlowers();
        call.enqueue(new Callback<ArrayList<FlowerEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<FlowerEntity>> call, Response<ArrayList<FlowerEntity>> response) {
                if (response.isSuccessful()) {
                    flowerEntities = response.body();
                    useCaseImp.getRetrofitCallback(flowerEntities, true, "success");

                } else { // error in retrieving response
                    responseError = response.errorBody().toString();
                    useCaseImp.getRetrofitCallback(flowerEntities, false, responseError);
                    Log.d(RETROFIT_TAG, "onResponse: " + responseError);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FlowerEntity>> call, Throwable t) {
                Log.e(RETROFIT_TAG, "onFailure: " + t.getMessage(), t);
                useCaseImp.getRetrofitCallback(flowerEntities, false, t.getMessage());
            }
        });
        //TODO
        //define if this method require return type or not
    }


}
