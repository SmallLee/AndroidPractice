package practice.lxn.cn.testapp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockCanaryActivity extends AppCompatActivity {
    public static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_canary);
    }

    public void click(final View view) {
        testBlock();
    }

    public void testBlock(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writeByFileOutputStream() {
        FileOutputStream fop = null;
        File file;
        String content = "This is the text content";
        try {
            file = new File(PATH + "/testStrictMode2.txt");
            if (!file.exists()) {
                System.out.println("==============" + file.getAbsolutePath());
                boolean success = file.createNewFile();
                Toast.makeText(this, success + "", Toast.LENGTH_SHORT).show();
            }
            Thread.sleep(10000);
            fop = new FileOutputStream(file);
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
