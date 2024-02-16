package com.example.comp;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.launcher.ARouter;

public class HomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    Fragment mHomeTabFragment;

    Fragment mGameTabFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RadioGroup rg_tab = findViewById(R.id.tabs);
        rg_tab.setOnCheckedChangeListener(this);

        initDefaultFragment();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        hideAllFragments();
        switch (checkedId) {
            case R.id.main_tab_home:
                replaceFragment(0);
                break;
            case R.id.main_tab_game:
                replaceFragment(1);
                break;
        }
    }

    private void initDefaultFragment(){
        if (mHomeTabFragment == null) {
            mHomeTabFragment = (Fragment) ARouter.getInstance().build("/home/homeFragment").navigation();
        }
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fragment, mHomeTabFragment, "home");
        transaction.commit();
    }

    private void replaceFragment(int position) {
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mHomeTabFragment == null) {
                    mHomeTabFragment = (Fragment) ARouter.getInstance().build("/home/homeFragment").navigation();
                    transaction.add(R.id.container_fragment, mHomeTabFragment, "home");
                }
                transaction.show(mHomeTabFragment);
                break;
            case 1:
                if (mGameTabFragment == null) {
                    mGameTabFragment = (Fragment) ARouter.getInstance().build("/game/gameFragment").navigation();
                    transaction.add(R.id.container_fragment, mGameTabFragment, "game");
                }
                transaction.show(mGameTabFragment);
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideAllFragments() {
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        if (mHomeTabFragment != null) {
            transaction.hide(mHomeTabFragment);
        }
        if (mGameTabFragment != null) {
            transaction.hide(mGameTabFragment);
        }
        transaction.commitAllowingStateLoss();
    }
}
