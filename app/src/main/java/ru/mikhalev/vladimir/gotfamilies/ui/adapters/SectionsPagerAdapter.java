package ru.mikhalev.vladimir.gotfamilies.ui.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ru.mikhalev.vladimir.gotfamilies.data.managers.DataManager;
import ru.mikhalev.vladimir.gotfamilies.data.storage.House;
import ru.mikhalev.vladimir.gotfamilies.ui.fragments.HouseMembersFragment;
import ru.mikhalev.vladimir.gotfamilies.utils.AppConfig;
import ru.mikhalev.vladimir.gotfamilies.utils.ConstantManager;
import ru.mikhalev.vladimir.gotfamilies.utils.Helper;

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = ConstantManager.TAG_PREFIX + "SectionsPagerAdapter";

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return HouseMembersFragment.newInstance(AppConfig.HOUSE_IDS.get(position));
    }

    @Override
    public int getCount() {
        return 3;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        House house = DataManager.getInstance().getHouseFromDB(AppConfig.HOUSE_IDS.get(position));
        return Helper.getShortHouseName(house.getName()).toUpperCase();
    }
}
