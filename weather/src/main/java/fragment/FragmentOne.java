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
 * @author Create by zxy on 2018/6/22
 * @see
 * @since
 * @deprecated
 */
public class FragmentOne extends Fragment {
    private static final String TAG = "Fragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach1: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate1: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_one, container,false);
        Log.d(TAG, "onCreateView1: ");
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart1: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume1: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause1: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop1: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView1: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy1: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach1: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged1: " + hidden);
    }
}
