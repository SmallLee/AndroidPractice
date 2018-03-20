package practice.lxn.cn.androidpractice.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import practice.lxn.cn.androidpractice.R;

/**
 * 拍照并且压缩图片
 */
public class FourThActivity extends AppCompatActivity {

    private File file;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_th);
        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void start(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = new File(Environment.getExternalStorageDirectory(),"myimg");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        long fileName = System.currentTimeMillis();
        file = new File(dir,fileName + ".jpg");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //指定拍照后图片保存地址
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == 1) {
            String filePath = file.getAbsolutePath();
            //解析原始图片，比较大
            Bitmap bitmap = BitmapFactory.decodeFile(filePath);
            //获取压缩后的图片，采样率
            Bitmap smallBitmap = getSmallBitmap(file, 500, 500);
            imageView.setImageBitmap(bitmap);
        }
    }

    public Bitmap getSmallBitmap(File file,int reqWidth,int reqHeight){
        String filePath = file.getAbsolutePath();
        BitmapFactory.Options options = new BitmapFactory.Options();
        //只是解析尺寸信息，不加载到内存中
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath,options);//此时返回bitmap为null
        //计算采样率
        options.inSampleSize = caculateInSampleSize(options,reqWidth,reqHeight);
        //真正去加载图片
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
        try {
            //质量压缩，压缩图片到本地，只改变存储在磁盘上的大小，bitmap的大小不会变，质量压缩不会改变像素
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
            bitmap.compress(Bitmap.CompressFormat.JPEG,80,bos);
            return bitmap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算采用率
     */
    public int caculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;
        int inSampleSize = 1;
        if (outWidth > reqWidth || outHeight > reqHeight) {
            int widthRatio = Math.round((float) outWidth/(float) reqWidth);
            int heightRatio = Math.round((float) outHeight/(float) reqHeight);
            //返回比例小的一个
            inSampleSize = widthRatio < heightRatio ? widthRatio : heightRatio;
        }
        return inSampleSize;
    }
    public Bitmap crossBitmap(Bitmap bitmap,String filePath){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //质量压缩，100表示不压缩，把压缩后的数据保存到bos中
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
        int quality = 100;
        //循环判断压缩后的图片大小是否大于100kb,大于继续压缩
        while(bos.toByteArray().length/1024 > 100) {
            bos.reset();//清空bos
            quality -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG,quality,bos);
        }
        //压缩好写到文件中
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(bos.toByteArray());
            fos.flush();
            fos.close();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
