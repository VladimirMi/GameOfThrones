package ru.mikhalev.vladimir.gotfamilies.ui.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.ui.adapters.SectionsPagerAdapter;
import ru.mikhalev.vladimir.gotfamilies.utils.AppConfig;
import ru.mikhalev.vladimir.gotfamilies.utils.ConstantManager;

public class FamiliesActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = ConstantManager.TAG_PREFIX + "FamiliesActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.navigation_drawer) DrawerLayout mNavigationDrawer;
    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.container) ViewPager mViewPager;
    @BindView(R.id.tabs) TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_families);
        ButterKnife.bind(this);

        setupToolbar();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(this);
        mTabLayout.setupWithViewPager(mViewPager);

        setupDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.fio));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawer() {
        List<String> housesNames = new ArrayList<>();
        for (Integer houseId : AppConfig.HOUSE_IDS) {
            housesNames.add(mDataManager.getHouseFromDB(houseId).getName());
        }

        Menu drawerMenu = mNavigationView.getMenu();
        for (int i = 0; i < 3; i++) {
            MenuItem house1 = drawerMenu.getItem(i);
            house1.setTitle(housesNames.get(i));
        }

        drawerMenu.getItem(0).setChecked(true);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mNavigationDrawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.house1_menu:
                        mViewPager.setCurrentItem(0);
                        return true;
                    case R.id.house2_menu:
                        mViewPager.setCurrentItem(1);
                        return true;
                    case R.id.house3_menu:
                        mViewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mNavigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
