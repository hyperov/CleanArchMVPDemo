package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import ahmed.com.demo.cleanarchmvpdemo.R;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.Repository;
import ahmed.com.demo.cleanarchmvpdemo.businessLayer.UseCase;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * View class in MVP(Model View Presenter) pattern..in presentation layer
 * [Clean Architecture]
 */
public class MainActivity extends AppCompatActivity {


    UseCase useCase;
    Repository repository;


    @InjectView(R.id.fab)
    FloatingActionButton fab;

    @InjectView(R.id.listview)
    ListView listView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //
        presenter = new Presenter();


    }

    @OnClick(R.id.fab)
    void fabClick() {
        presenter.onClickEvent();
    }

    /**
     * events from presentation layer
     */
    public interface ViewEvent {

        void onClickEvent();
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
