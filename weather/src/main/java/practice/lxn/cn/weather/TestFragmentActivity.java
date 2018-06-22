package practice.lxn.cn.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import fragment.FragmentOne;
import fragment.FragmentTwo;

public class TestFragmentActivity extends AppCompatActivity {
    private Fragment mCurrentFragment;

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        mCurrentFragment = fragmentOne;
    }

    public void one(View view) {
        switchFragment(fragmentOne).commit();
    }

    public void two(View view) {
        switchFragment(fragmentTwo).commit();
    }


    public FragmentTransaction switchFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.fl_container,fragment)
                    .hide(mCurrentFragment).show(fragment);
            Toast.makeText(this, "未添加", Toast.LENGTH_SHORT).show();
        } else {
            fragmentTransaction
                    .hide(mCurrentFragment).show(fragment);
            Toast.makeText(this, "已添加", Toast.LENGTH_SHORT).show();
        }
        mCurrentFragment = fragment;
        return fragmentTransaction;
    }

}
