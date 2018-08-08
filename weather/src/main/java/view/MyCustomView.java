package view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/7/2
 */
public class MyCustomView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    private SurfaceHolder mHolder;
    private boolean mIsDrawing = false;
    private Canvas mCanvas;

    public MyCustomView(Context context) {
        this(context,null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        // SurfaceView创建的时候启动一个线程
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while (mIsDrawing) {
            draw();
        }
    }

    public void draw() {
        // 锁定画布
        mCanvas = mHolder.lockCanvas();
        // 将绘图内容提交到Canvas
        mHolder.unlockCanvasAndPost(mCanvas);
        postInvalidate();
    }
}

/*
* SurfaceView和View的区别
*1.SurfaceView允许在其他线程更新UI,而View只能在UI线程更新
*2.Surfaceview是在底层的View,其他View在上面
*3.执行效率比View高
* 4.在绘图时使用了双缓冲机制，View没有
* */
