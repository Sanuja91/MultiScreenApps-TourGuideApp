package com.example.android.tourguideapp;

// Custom Class to hold details of each attraction
public class Attraction {

    // String Value for Attraction Name
    private String mAttractionName;

    // String Value for Attraction Address
    private String mAttractionAddress;

    // String Value for Attraction Telephone Number
    private String mAttractionTelephone;

    // String Value for Business Hours
    private String mBusinessHours;

    // Int Value for Image Resource ID
    private int mImageResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;



    // Constructs a new Attraction with the values for Attraction Name, Attraction Address, Attraction Telephone Number, Attraction Open Business Hours and Image Resource ID
    public Attraction(String attractionName, String attractionAddress, String attractionTelephone, String businessHours, int imageResourceId){
        mAttractionName = attractionName;
        mAttractionAddress = attractionAddress;
        mAttractionTelephone = attractionTelephone;
        mBusinessHours = businessHours;
        mImageResourceId = imageResourceId;
    }

    // Returns Attraction's Name
    public String getAttractionName(){
        return mAttractionName;
    }

    // Returns Attraction's Address
    public String getAttractionAddress(){
        return mAttractionAddress;
    }

    // Returns Attraction's Telephone Number
    public String getAttractionTelephone(){
        return mAttractionTelephone;
    }

    // Returns Attraction's Open Business Hours
    public String getBusinessHours(){
        return mBusinessHours;
    }

    // Returns Attraction's Image Resource ID
    public int getImageResourceId(){
        return mImageResourceId;
    }

    // States whether the attraction has an Image
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;

    }

}




