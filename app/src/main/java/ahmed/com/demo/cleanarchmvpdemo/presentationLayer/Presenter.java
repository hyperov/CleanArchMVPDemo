package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */


import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCase;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCaseImp;

/**
 * Presenter class in MVP(Model View Presenter) pattern..in presentation layer
 * [Clean Architecture]
 */
public class Presenter implements MainActivity.ViewEvent,UseCase.UseCaseCallback {
    UseCaseImp useCaseImp = new UseCaseImp();

    @Override
    public void onClickEvent() {
        useCaseImp.fabClickEvent();
    }

    //callback success
    @Override
    public void getDataSuccess() {

    }

    //callback failure
    @Override
    public void getDataFailure() {

    }

    /**
     * callbacks from business layer
     */
    public interface ViewCallback {

    }


}
