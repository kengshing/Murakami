package net.orcacreation.murakami;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info("Dance, Dance, Dance", "wu, wu, wu", R.drawable.img_dance_dance_dance));
        infos.add(new Info("The Wind Up Bird Chronicle", "Fa Tiao Niao nian Dai Lu", R.drawable.img_the_wind_up_bird_chronicle));
        infos.add(new Info("Kafka On The Shore", "An Bian De Ka Fu Ka", R.drawable.img_kafka_on_the_shore));

        InfoAdaptor itemAdaptor = new InfoAdaptor(getActivity(), R.layout.info_list_item, infos, R.color.category_book);
        ListView listView = rootView.findViewById(R.id.info_list);
        listView.setAdapter(itemAdaptor);

        return rootView;
    }
}
