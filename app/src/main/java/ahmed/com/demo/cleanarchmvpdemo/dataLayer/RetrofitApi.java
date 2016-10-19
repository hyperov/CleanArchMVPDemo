package ahmed.com.demo.cleanarchmvpdemo.dataLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit Interface has methods for post,delete..etc
 * each method is an api call with targeted URL
 * all url's are added to base url
 */
public interface RetrofitApi {

    /**
     * method to get flower Entity as Array list from url
     * @return
     */
    @GET("/feeds/flowers.json")
    Call<ArrayList<FlowerEntity>> getFlowers();
}
