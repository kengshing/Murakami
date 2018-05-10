package net.orcacreation.murakami;

class Info {

    private static final int NO_RESOURCE_PROVIDED = -1;
    private static final int RESOURCE_SONG = 1;
    private static final int RESOURCE_LOCATION = 2;
    private static final int RESOURCE_WEBSITE = 3;
    private static final int NO_IMAGE_PROVIDED = -2;
    private final String mInfoName;
    private final String mInfoDescription;
    private int mImageResourceId;
    private int mResourceId = NO_RESOURCE_PROVIDED;
    private int mResourceType;


    Info(String infoName, String infoDescription, int imageResourceId) {
        mInfoName = infoName;
        mInfoDescription = infoDescription;
        mImageResourceId = NO_IMAGE_PROVIDED;
        mImageResourceId = imageResourceId;
    }

    Info(String infoName, String infoDescription, int imageResourceId, int resourceId, int resourceType) {
        mInfoName = infoName;
        mInfoDescription = infoDescription;
        mImageResourceId = NO_IMAGE_PROVIDED;
        mImageResourceId = imageResourceId;
        mResourceId = resourceId;
        mResourceType = resourceType;
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

    // Provision for info that does not ahve image

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmResourceType() {
        return mResourceType;
    }

    @Override
    public String toString() {
        return "Info{" +
                "mInfoName='" + mInfoName + '\'' +
                ", mInfoDescription='" + mInfoDescription + '\'' +
                ", mImageResourceId='" + mImageResourceId +
                ", mResourceId='" + mResourceId +
                '}';
    }
}
