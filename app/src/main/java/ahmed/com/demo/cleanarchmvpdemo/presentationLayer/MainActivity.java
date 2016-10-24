package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import javax.inject.Inject;

import ahmed.com.demo.cleanarchmvpdemo.R;
import ahmed.com.demo.cleanarchmvpdemo.application.App;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;
import ahmed.com.demo.cleanarchmvpdemo.presentationLayer.Presenter.ViewCallback;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * View class in MVP(Model View Presenter) pattern..in presentation layer
 * [Clean Architecture]
 */
public class MainActivity extends AppCompatActivity implements ViewCallback {

//    UseCase useCase;
    //    Repository repository;
    @Inject
    Presenter presenter;

    //    UseCaseImp useCase;

    MyArrayAdapter myArrayAdapter;

    @InjectView(R.id.fab)
    FloatingActionButton fab;

    @InjectView(R.id.listview)
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        App.getAppComponent().inject(this);



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ArrayList<FlowerEntity> flowerEntities) {
        /* Do something */
        myArrayAdapter = new MyArrayAdapter(this, R.layout.list_item, flowerEntities);
        listView.setAdapter(myArrayAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String error) {
        /* Do something */
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.fab)
    void fabClick() {
        presenter.onClickEvent();
    }


    //call back success
    @Override
    public void fabClickCallbackSuccess(ArrayList<FlowerEntity> flowerEntities) {
        EventBus.getDefault().post(flowerEntities);

    }

    //callback failure
    @Override
    public void fabClickCallbackFailure(String error) {
        EventBus.getDefault().post(error);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
