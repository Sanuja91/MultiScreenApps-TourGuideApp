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
public class HistoricalFragment extends Fragment {


    public HistoricalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        // Create a list of attractions
        final ArrayList<Attraction> attractions = new ArrayList<com.example.android.tourguideapp.Attraction>();
        attractions.add(new com.example.android.tourguideapp.Attraction("Heladiv Tea Club", "Dutch Hospital", "011 5 753377", "10AM - 1AM", R.drawable.heladiv_tea_club));
        attractions.add(new com.example.android.tourguideapp.Attraction("Kama Colombo", "31 Horton Pl, Colombo 7", "011 2 339118", "24 Hours", R.drawable.kama_colombo));
        attractions.add(new com.example.android.tourguideapp.Attraction("Silk", "41 Maitland Cresent, Colombo 7", "072 648 4517", "24 Hours", R.drawable.silk_colombo));
        attractions.add(new com.example.android.tourguideapp.Attraction("Rhythm and Blues", "R A De Mel Mawatha, Colombo 7", "077 777 7017", "8PM - 3AM", R.drawable.r_n_b));
        attractions.add(new com.example.android.tourguideapp.Attraction("Floor by O", "Maitland Cres, Colombo 7", "011 2 674299", "8PM - 3AM", R.drawable.floor_by_o));
        attractions.add(new com.example.android.tourguideapp.Attraction("Shore by O", "College Avenue, Dehiwala-Mount Lavinia", "011 4 389428", "24 Hours", R.drawable.shore_by_o));
        attractions.add(new com.example.android.tourguideapp.Attraction("ON 14 Roof Top Bar & Lounge", "14th Floor - OZO Colombo, Colombo 4", "011 2 555570", "11AM–2AM", R.drawable.on_14));


        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s. The
        // adapter knows how to create list items for each item in the list.
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_historical);

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
