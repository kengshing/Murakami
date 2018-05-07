package net.orcacreation.murakami;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class InfoAdaptor extends ArrayAdapter {
    private final int mColorResourceId;

    InfoAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<Info> infos, int colorResourceId) {
        super(context, 0, infos);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.info_list_item, parent, false);
        }

        final Info currentInfo = (Info) getItem(position);

        TextView infoTextView = listView.findViewById(R.id.info_text_view);
        infoTextView.setText(currentInfo.getmInfoName());

        TextView descriptionTextView = listView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentInfo.getmInfoDescription());

        View textLayout = listView.findViewById(R.id.text_layout);
        int textLayoutColor = ContextCompat.getColor(getContext(), mColorResourceId);
        textLayout.setBackgroundColor(textLayoutColor);

        ImageView imageView = listView.findViewById(R.id.info_image_view);
        if (currentInfo.hasImage()) {
            imageView.setImageResource(currentInfo.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listView;
    }
}
