package ru.mikhalev.vladimir.gotfamilies.ui.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.data.managers.DataManager;
import ru.mikhalev.vladimir.gotfamilies.data.storage.CharacterDao;
import ru.mikhalev.vladimir.gotfamilies.data.storage.HouseDao;
import ru.mikhalev.vladimir.gotfamilies.utils.ConstantManager;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = ConstantManager.TAG_PREFIX + "BaseActivity";
    protected ProgressDialog mProgressDialog;
    protected HouseDao mHouseDao;
    protected CharacterDao mCharacterDao;
    protected DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataManager = DataManager.getInstance();
        mHouseDao = mDataManager.getDaoSession().getHouseDao();
        mCharacterDao = mDataManager.getDaoSession().getCharacterDao();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, R.layout.progress_splash);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        } else {
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        }
    }

    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    public void showError(String message, Exception error) {
        showToast(message);
        Log.e(TAG, String.valueOf(error));
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
