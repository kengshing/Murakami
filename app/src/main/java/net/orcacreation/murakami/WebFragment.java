package net.orcacreation.murakami;

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
public class WebFragment extends Fragment {


    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info("Official Site", "http://www.harukimurakami.com", R.drawable.img_official_site, R.string.web_official));
        infos.add(new Info("Wikipedia", "https://en.wikipedia.org/wiki/Haruki_Murakami", R.drawable.img_wiki, R.string.web_wiki));
        infos.add(new Info("The New Yorker", "https://www.newyorker.com/contributors/haruki-murakami", R.drawable.img_the_new_yorker, R.string.web_newyorker));

        InfoAdaptor itemAdaptor = new InfoAdaptor(getActivity(), R.layout.info_list_item, infos, R.color.category_web);
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
