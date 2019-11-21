package com.accenture.horse1.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.RatingBar;
import android.content.Context;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import com.accenture.horse1.R;
import com.accenture.horse1.model.Item;


public class MyAdapter extends ArrayAdapter<Item> {

    int resource;
    List<Item> items;

    public MyAdapter(Context context, int _resource, List<Item> items) {
        super(context, _resource, items);
        resource = _resource;
        this.items = items;

    }

    @Override
    public View getView(int position,  View convertView, ViewGroup container) {



        if (convertView == null) {
            // Inflate a new view if this is not an update.
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater) getContext().getSystemService(inflater);
            convertView = li.inflate(resource, container, false);
        }

        ImageView imageView = convertView.findViewById(R.id.item_image);
        imageView.setImageResource(items.get(position).getImageName());

        TextView text = convertView.findViewById(R.id.item_name);
        text.setText(items.get(position).getName());

//        TextView t2=convertView.findViewById(R.id.item_name);
//        t2.setText(items.get(position).getBreed_name());

        TextView t3=convertView.findViewById(R.id.item_breed);
        t3.setText(items.get(position).getBreed_name());

        RatingBar t4=  convertView.findViewById(R.id.ratingBar);
        t4.setRating(items.get(position).getRating());

        return convertView;

        // TODO Retrieve values to display from the
        // classInstance variable.

        // TODO Get references to the Views to populate from the layout.
        // TODO Populate the Views with object property values.


    }

}
