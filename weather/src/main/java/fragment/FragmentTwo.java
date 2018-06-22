package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import practice.lxn.cn.weather.R;

/**
 * 描述：
 *
 * @author Create by zxy on 2028/6/22
 * @see
 * @since
 * @deprecated
 */
public class FragmentTwo extends Fragment {
    private static final String TAG = "Fragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach2: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate2: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_two, container,false);
        Log.d(TAG, "onCreateView2: ");
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart2: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume2: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause2: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop2: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView2: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach2: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged2: " + hidden);
    }
}
