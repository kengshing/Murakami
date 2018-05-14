package net.orcacreation.murakami;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class CatagoryAdaptor extends FragmentPagerAdapter {

    private final Context mContext;

    public CatagoryAdaptor(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BookFragment();
            case 1:
                return new SongFragment();
            default:
                return new LocationFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_books);
            case 1:
                return mContext.getString(R.string.category_songs);
            default:
                return mContext.getString(R.string.category_places);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
