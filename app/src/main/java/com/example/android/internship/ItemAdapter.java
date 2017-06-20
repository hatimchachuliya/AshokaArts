package com.example.android.internship;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.resource;

/**
 * Created by hatim on 6/6/2017.
 */

public class ItemAdapter extends ArrayAdapter<Items> {
    public ItemAdapter(Activity context,ArrayList<Items> itemObject) {
        super(context,0,itemObject);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridview=convertView;
        if(gridview==null)
        {
            gridview = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_layout, parent, false);
        }

        Items currentItems = getItem(position);

        TextView nameTextView = null;
        if (gridview != null) {
            nameTextView = (TextView) gridview.findViewById(R.id.product_name);
        }
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentItems.getItemName());

        ImageView iconView = null;
        if (gridview != null) {
            iconView = (ImageView) gridview.findViewById(R.id.product_images);

        }
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentItems.getImageId());


        return gridview;
    }
}
