package ahmed.com.demo.cleanarchmvpdemo.presentationLayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ahmed.com.demo.cleanarchmvpdemo.R;
import ahmed.com.demo.cleanarchmvpdemo.dataLayer.FlowerEntity;
import butterknife.ButterKnife;
import butterknife.InjectView;

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
    private int resource;


    public MyArrayAdapter(Context context, int resource, ArrayList<FlowerEntity> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource=resource;
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
    public View getView(int position, View convertView,ViewGroup parent) {

        View view;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        //populate views
        viewHolder.name.setText(flowerEntityArrayList.get(position).getName());
        Picasso.with(context).
                load("http://services.hanselandpetal.com/photos/"+
                        flowerEntityArrayList.get(position).getPhoto()).placeholder(R.mipmap.ic_launcher).into(viewHolder.img);

        //add list item layout and bind views
        return view;
    }


    class ViewHolder {
        @InjectView(R.id.img)
        ImageView img;
        @InjectView(R.id.name)
        TextView name;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
