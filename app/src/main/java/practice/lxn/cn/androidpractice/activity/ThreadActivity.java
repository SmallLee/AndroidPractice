package practice.lxn.cn.androidpractice.activity;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import practice.lxn.cn.androidpractice.R;

public class ThreadActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{
    private static final String TAG = "ThreadActivity";
    public static final int LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        getLoaderManager().initLoader(LOADER_ID,null,this);
    }

    public void post(View view) {

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new DownLoadTask(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        Toast.makeText(this, "finish", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onLoadFinished: " + data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
