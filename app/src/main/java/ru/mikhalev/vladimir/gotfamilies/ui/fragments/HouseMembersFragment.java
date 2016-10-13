package ru.mikhalev.vladimir.gotfamilies.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.data.managers.DataManager;
import ru.mikhalev.vladimir.gotfamilies.data.storage.Character;
import ru.mikhalev.vladimir.gotfamilies.ui.adapters.CharactersAdapter;
import ru.mikhalev.vladimir.gotfamilies.utils.AppConfig;
import ru.mikhalev.vladimir.gotfamilies.utils.ConstantManager;

public class HouseMembersFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_HOUSE_ID = "house_id";
    private static final String TAG = ConstantManager.TAG_PREFIX + "HouseMembersFragment";

    public HouseMembersFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HouseMembersFragment newInstance(int houseId) {

        HouseMembersFragment fragment = new HouseMembersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_HOUSE_ID, houseId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_families, container, false);


        ListView listView = (ListView) rootView.findViewById(R.id.characters_list);

        int houseId = getArguments().getInt(ARG_HOUSE_ID);

        List<Character> characters = DataManager.getInstance().getCharactersForHouse(houseId);

        listView.setAdapter(new CharactersAdapter(characters, houseId));
        return rootView;
    }
}
