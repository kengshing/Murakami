package net.orcacreation.murakami;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {


    public PlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info("Islay, Scotland", "If Our Language Is Whisky", R.drawable.img_islay, R.string.location_islay));
        infos.add(new Info("Athos, Greece", "Rain, Burning Sun", R.drawable.img_athos, R.string.location_athos));
        infos.add(new Info("Sydney, Australia", "Sydney!", R.drawable.img_sydney, R.string.location_sydney));
        infos.add(new Info("Rome, Italy", "The Distant Drum", R.drawable.img_rome, R.string.location_rome));

        InfoAdaptor itemAdaptor = new InfoAdaptor(getActivity(), R.layout.info_list_item, infos, R.color.category_place);
        ListView listView = rootView.findViewById(R.id.info_list);
        listView.setAdapter(itemAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info info = infos.get(position);

                Intent locationIntent = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse(getString(info.getmResourceId()));
                locationIntent.setData(geoLocation);
                if (locationIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(locationIntent);
                }
            }
        });
        return rootView;
    }
}
