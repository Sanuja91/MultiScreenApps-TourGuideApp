package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter{

    //Resource ID for the background color of this list of words
    private int mColorResourceId;

    /**
     * Create a new {@link AttractionAdapter} object
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in respect of
     * @param attractions     is the list of (@link Attraction)s to be displayed.
     * @param colorResourceId is the Resource ID for the background of the object
     */
    public AttractionAdapter(Activity context, ArrayList<com.example.android.tourguideapp.Attraction> attractions, int colorResourceId) {
        //  Here, we initialize the Array Adapter's internal storage for the context and the list.
        super(context,0,attractions);

        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The AdapterView position that is requesting a view
     * @param convertView The recycled view to populate
     * @param parent      The parent ViewGroup that is used for inflation
     * @return            The View for the position in the AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Attraction} object located at this position in the list
        com.example.android.tourguideapp.Attraction currentAttraction = (Attraction) getItem(position);

        //  Find the TextView in the list_item.xml layout with the ID nameTextView
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nameTextView);
        //  Get the Attraction's Name from the current Attraction object and set this text on the new ListView
        nameTextView.setText(currentAttraction.getAttractionName());

        //  Find the TextView in the list_item.xml layout with the ID addressTextView
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.addressTextView);
        //  Get the Attraction's Address from the current Attraction object and set this text on the new ListView
        addressTextView.setText(currentAttraction.getAttractionAddress());

        //  Find the TextView in the list_item.xml layout with the ID telephoneTextView
        TextView telephoneTextView = (TextView) listItemView.findViewById(R.id.telephoneTextView);
        //  Get the Attraction's Telephone Number from the current Attraction object and set this text on the new ListView
        telephoneTextView.setText(currentAttraction.getAttractionTelephone());

        //  Find the TextView in the list_item.xml layout with the ID businessHoursTextView
        TextView businessHoursTextView = (TextView) listItemView.findViewById(R.id.businessHoursTextView);
        //  Get the Attraction's Business Hours from the current Attraction object and set this text on the new ListView
        businessHoursTextView.setText(currentAttraction.getBusinessHours());

        // Find the ImageView in the list_item.xml with the ID imageResource
        ImageView imageView = (ImageView) listItemView.findViewById((R.id.imageView));
        if (currentAttraction.hasImage()) {
            // Set the ImageView to the image resource specified in the current Attraction

            Picasso.with(getContext()).load(currentAttraction.getImageResourceId()).into(imageView);

            //Make sure the View is visible, because if recycled View was previously hidden it will still be hidden
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set Visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme colors for the list item
        View textContainer = listItemView.findViewById(R.id.textContainer);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
