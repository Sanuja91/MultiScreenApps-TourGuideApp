package com.example.android.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Create a list of attractions
        final ArrayList<Attraction> attractions = new ArrayList<com.example.android.tourguideapp.Attraction>();
        attractions.add(new com.example.android.tourguideapp.Attraction("Cinnamon Grand Colombo", "Colombo", "011 2 437437", "24 Hours", R.drawable.cinnamon_grand));
        attractions.add(new com.example.android.tourguideapp.Attraction("Cinnamon Lakeside", "Sir Chittampalam A Gardiner Mawatha, Colombo", "011 2 491000", "24 Hours", R.drawable.cinnamon_lakeside));
        attractions.add(new com.example.android.tourguideapp.Attraction("Cinnamon Red Colombo", "59 Ananda Coomaraswamy Mawatha, Colombo 3", "011 2 674299", "24 Hours", R.drawable.cinnamon_red));
        attractions.add(new com.example.android.tourguideapp.Attraction("OZO Colombo", "36-38 Clifford Pl, Colombo 4", "011 2 555570", "24 Hours", R.drawable.ozo_colombo));
        attractions.add(new com.example.android.tourguideapp.Attraction("Renuka City Hotel", "328 Galle Road, Colombo 3", "011 2 446622", "24 Hours", R.drawable.renuka_city_hotel));
        attractions.add(new com.example.android.tourguideapp.Attraction("Taj Samudra", "25 Galle Face Center Rd, Colombo", "011 4 389428", "24 Hours", R.drawable.taj_samurda));
        attractions.add(new com.example.android.tourguideapp.Attraction("The Kingsbury Hotel", "Janadhipathi Mawatha, Colombo", "011 2 421221", "24 Hours", R.drawable.kingsbury));


        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s. The
        // adapter knows how to create list items for each item in the list.
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_hotel);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // attraction_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Attraction} object at the given position the user clicked on
                com.example.android.tourguideapp.Attraction attraction = attractions.get(position);

                // Get the {@link Attraction} name at the given position the user clicked on
                String attractionName = attraction.getAttractionName();

                // Creates an Intent that will load location of the selected attraction on Google Maps
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + attractionName);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        return rootView;

    }

}