package net.orcacreation.murakami;

class Info {

    private static final int NO_RESOURCE_PROVIDED = -1;
    private static final int NO_IMAGE_PROVIDED = -2;
    private final String mInfoName;
    private final String mInfoDescription;
    private int mImageResourceId;
    private int mResourceId;


    Info(String infoName, String infoDescription, int imageResourceId, int resourceId) {
        mInfoName = infoName;
        mInfoDescription = infoDescription;
        mImageResourceId = NO_IMAGE_PROVIDED;
        mImageResourceId = imageResourceId;
        mResourceId = NO_RESOURCE_PROVIDED;
        mResourceId = resourceId;
    }


    public String getmInfoName() {
        return mInfoName;
    }

    public String getmInfoDescription() {
        return mInfoDescription;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    //For Book - no link

    public int getmResourceId() {
        return mResourceId;
    }

    //For Places, Song and Ref - with link

    public boolean hasResource() {
        return mResourceId != NO_RESOURCE_PROVIDED;
    }

    // Provision for info that does not have image

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
