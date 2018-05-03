package net.orcacreation.murakami;

class Info {

    private static final int NO_RESOURCE_PROVIDED = -1;
    private final String mInfoName;
    private final String mInfoDescription;
    private int mImageResourceId;
    private int mResourceId = NO_RESOURCE_PROVIDED;


    Info(String infoName, String infoDescription, int imageResourceId) {
        mInfoName = infoName;
        mInfoDescription = infoDescription;
        mImageResourceId = imageResourceId;
    }

    Info(String infoName, String infoDescription, int imageResourceId, int resourceId) {
        mInfoName = infoName;
        mInfoDescription = infoDescription;
        mImageResourceId = imageResourceId;
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