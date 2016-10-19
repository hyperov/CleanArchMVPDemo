package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;

/**
 * Created by Ahmed Nabil on 10/19/2016.
 */

/**
 * Model class in MVP(Model View Presenter) pattern..in presentation layer
 * [Clean Architecture]
 */
public class MyArrayAdapter extends ArrayAdapter<FlowerEntity> {

    private ArrayList<FlowerEntity> flowerEntityArrayList;
    private Context context;


    public MyArrayAdapter(Context context, int resource, ArrayList<FlowerEntity> objects) {
        super(context, resource, objects);
        this.context = context;
        this.flowerEntityArrayList = objects;
    }


    @Nullable
    @Override
    public FlowerEntity getItem(int position) {
        return flowerEntityArrayList.get(position);
    }

    @Override
    public int getCount() {
        return flowerEntityArrayList.size();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO
        //add list item layout and bind views
        return super.getView(position, convertView, parent);
    }
}
