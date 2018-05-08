package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import practice.lxn.cn.androidpractice.R;

/**
 *
 */

public class WaveView extends View {

    private static final String TAG = "WaveView";

    private int waveColor;

    private int waveCount;

    private Paint paint;

    private int centerX;

    private int centerY;

    private float radius; // 最外圆半径，即最大半径

    private float innerRadius; // 最内圆的半径，即最小半径

    private float[] waveDegreeArr;

    private boolean isRunning = false;

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttrs(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(waveColor);
        paint.setStyle(Paint.Style.FILL);
        waveDegreeArr = new float[waveCount];
    }

    private void readAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WaveView);
        waveColor = typedArray.getColor(R.styleable.WaveView_waveColor, 0x262A32);
        waveCount = typedArray.getInt(R.styleable.WaveView_waveCount, 1);
        typedArray.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        radius = Math.min(w, h) / 2f;
        innerRadius = 80;
        for (int i = 0; i < waveCount; i++) {
            waveDegreeArr[i] = innerRadius + (radius - innerRadius) / waveCount * i;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.UNSPECIFIED || widthMode == MeasureSpec.AT_MOST) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(dp2Px(80), MeasureSpec.EXACTLY);
        }
        if (heightMode == MeasureSpec.UNSPECIFIED || heightMode == MeasureSpec.AT_MOST) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(dp2Px(80), MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (isRunning) {
            drawWave(canvas);
            drawCenterCircle(canvas);
        }
    }

    private void drawCenterCircle(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, innerRadius, paint);
    }

    private void drawWave(Canvas canvas) {
        for (int i = 0; i < waveCount; i++) {
            paint.setAlpha((int) (255 - 255 * waveDegreeArr[i] / radius));
            canvas.drawCircle(centerX, centerY, waveDegreeArr[i], paint);
        }
        for (int i = 0; i < waveDegreeArr.length; i++) {
            if ((waveDegreeArr[i] += 4) > radius) {
                waveDegreeArr[i] = innerRadius;
            }
        }
        if (isRunning) {
            postInvalidateDelayed(20);
        }
    }

    private int dp2Px(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }

    public void startAnim(){
        isRunning = true;
        invalidate();
    }

    public void stopAnim(){
        isRunning = false;
        setVisibility(GONE);
    }
}
