package ru.mikhalev.vladimir.gotfamilies.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.data.storage.Character;
import ru.mikhalev.vladimir.gotfamilies.data.storage.House;
import ru.mikhalev.vladimir.gotfamilies.utils.AppConfig;
import ru.mikhalev.vladimir.gotfamilies.utils.ConstantManager;
import ru.mikhalev.vladimir.gotfamilies.utils.CustomGlideModule;

public class CharacterActivity extends BaseActivity {

    private static final String TAG = ConstantManager.TAG_PREFIX + "CharacterActivity";
    private Character mCharacter;
    private House mHouse;

    @BindViews({R.id.words_txt, R.id.born_txt, R.id.died_txt, R.id.titles_txt, R.id.aliases_txt})
    List<TextView> mTextViews;

    @BindViews({R.id.words_layout, R.id.born_layout, R.id.died_layout, R.id.titles_layout, R.id.aliases_layout})
    List<LinearLayout> mTextLayouts;

    @BindViews({R.id.father_btn, R.id.mother_btn})
    List<Button> mButtons;

    @BindViews({R.id.father_layout, R.id.mother_layout})
    List<LinearLayout> mButtonLayouts;

    @BindView(R.id.house_img) ImageView mHouseImageView;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.coordinator_layout) CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        ButterKnife.bind(this);

        int characterId;
        if (savedInstanceState == null) {
            characterId = getIntent().getIntExtra(ConstantManager.CHARACTER_ID, 0);
        } else {
            characterId = savedInstanceState.getInt(ConstantManager.CHARACTER_ID, 0);
        }

        mCharacter = mDataManager.getCharacterFromDB(characterId);
        mHouse = mDataManager.getHouseFromDB(mCharacter.getHouseId());

        showDiedSnackBar();
        setupToolbar();

        List<String> textValues = generateTextValues(mCharacter);
        List<Integer> buttonValues = generateButtonValues(mCharacter);

        for (int i = 0; i < mTextViews.size(); i++) {
            setupTextView(mTextViews.get(i), mTextLayouts.get(i), textValues.get(i));
        }

        for (int i = 0; i < mButtons.size(); i++) {
            setupButton(mButtons.get(i), mButtonLayouts.get(i), buttonValues.get(i));
        }

        int imageRes = AppConfig.houseImageRes.get(AppConfig.houseIds.indexOf(mHouse.getId()));
        CustomGlideModule.setImage(this, imageRes, mHouseImageView);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(ConstantManager.CHARACTER_ID, mCharacter.getId());

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(mCharacter.getName());
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private List<String> generateTextValues(Character character) {
        List<String> result = new ArrayList<>();
        result.add(mHouse.getWords());
        result.add(mCharacter.getBorn());
        result.add(mCharacter.getDied());
        result.add(mCharacter.getTitles());
        result.add(mCharacter.getAliases());
        return result;
    }

    private List<Integer> generateButtonValues(Character character) {
        List<Integer> result = new ArrayList<>();
        result.add(mCharacter.getFatherId());
        result.add(mCharacter.getMotherId());
        return result;
    }

    private void setupTextView(TextView textView, LinearLayout linearLayout, String value) {
        if (value.isEmpty()) {
            linearLayout.setVisibility(View.GONE);
        } else {
            textView.setText(value);
        }
    }

    private void setupButton(Button button, LinearLayout linearLayout, final Integer id) {
        if (id == 0) {
            linearLayout.setVisibility(View.GONE);
        } else {
            final Character parent = mDataManager.getCharacterFromDB(id);
            button.setText(parent.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCharacter = parent;
                    recreate();
                }
            });
        }
    }

    private void showDiedSnackBar() {
        if (!mCharacter.getDied().isEmpty() && !mCharacter.getSeasons().isEmpty()) {
            String[] seasons = mCharacter.getSeasons().split(" ");
            String message = String.format(getString(R.string.msg_died), seasons[seasons.length - 1]);
            Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
        }
    }
}
