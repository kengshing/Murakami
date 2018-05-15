package net.orcacreation.murakami;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        infos.add(new Info("Pinball, 1973", "Novel, 1980",
                R.drawable.img_pinball_1973, R.string.web_pinball_1973));
        infos.add(new Info("Hard Boiled Wonderland And The End Of The World", "Novel, 1985",
                R.drawable.img_hard_boiled_wonderland_and_the_end_of_the_world, R.string.web_hard_boiled_wonderland_and_the_end_of_the_world));
        infos.add(new Info("Dance, Dance, Dance", "Novel, 1988",
                R.drawable.img_dance_dance_dance, R.string.web_dance_dance_dance));
        infos.add(new Info("South Of Border, West Of Sun", "Novel, 1992",
                R.drawable.img_south_of_the_border_west_of_the_sun, R.string.web_south_of_border_west_of_sun));
        infos.add(new Info("The Wind Up Bird Chronicle", "Novel, 1994-1995",
                R.drawable.img_the_wind_up_bird_chronicle, R.string.web_the_wind_up_bird_chronicle));
        infos.add(new Info("Sputnik Sweetheart", "Novel, 1999",
                R.drawable.img_sputnik_sweetheart, R.string.web_sputnik_sweetheart));
        infos.add(new Info("Kafka On The Shore", "Novel, 2002",
                R.drawable.img_kafka_on_the_shore, R.string.web_kafka_on_the_shore));
        infos.add(new Info("After Dark", "Novel, 2004",
                R.drawable.img_afterdark, R.string.web_afterdark));
        infos.add(new Info("1Q84", "Novel, 2011",
                R.drawable.img_1q84, R.string.web_1q84));
        infos.add(new Info("Killing Commendatore", "Novel, 2017",
                R.drawable.img_killing_commendatore, R.string.web_killing_commendatore));

        InfoAdaptor itemAdaptor = new InfoAdaptor(getActivity(), R.layout.info_list_item, infos, R.color.category_book);
        ListView listView = rootView.findViewById(R.id.info_list);
        listView.setAdapter(itemAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info info = infos.get(position);

                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                Uri webpage = Uri.parse(getString(info.getmResourceId()));
                webIntent.setData(webpage);
                if (webIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        return rootView;
    }
}
