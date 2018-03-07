package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 *
 */

public class CustomView extends ViewGroup {
    //当前的位置
    private int mCurrentPosition = 0;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //是否允许保存
        setSaveEnabled(false);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        //获取一个Parcelable对象
        Parcelable parcelable = super.onSaveInstanceState();
        SaveState savaState = new SaveState(parcelable);
        savaState.mCurrentPosition = mCurrentPosition;
        return savaState;
    }

    static class SaveState extends BaseSavedState {
        private int mCurrentPosition;

        //获取数据
        SaveState(Parcel source) {
            super(source);
            mCurrentPosition = source.readInt();
        }

        //创建对象
        SaveState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(mCurrentPosition);
        }

        public static Creator<SaveState> CREATETOR = new Creator<SaveState>() {
            @Override
            public SaveState createFromParcel(Parcel source) {
                return new SaveState(source);
            }

            @Override
            public SaveState[] newArray(int size) {
                return new SaveState[size];
            }
        };
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SaveState saveState = (SaveState) state;
        super.onRestoreInstanceState(saveState.getSuperState());
        setCurrentItem(saveState.mCurrentPosition);
    }


    public void setCurrentItem(int position) {
        this.mCurrentPosition = position;
    }
}


