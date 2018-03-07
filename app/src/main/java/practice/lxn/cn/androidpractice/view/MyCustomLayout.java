package practice.lxn.cn.androidpractice.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.LinearLayout;

/**
 *
 */

public class MyCustomLayout extends LinearLayout {
    public MyCustomLayout(Context context) {
        this(context, null);
    }

    public MyCustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSaveEnabled(true);//允许View保存自己的状态
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        //存储父类状态
        Parcelable parcelable = super.onSaveInstanceState();
        SaveState saveState = new SaveState(parcelable);
        saveState.childrenState = new SparseArray<>();
        //存储每个子View的状态到独立的SparseArray中
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).saveHierarchyState(saveState.childrenState);
        }
        return saveState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SaveState saveState = (SaveState) state;
        //恢复父类状态
        super.onRestoreInstanceState(saveState.getSuperState());
        //从容器中恢复每个ziView状态
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).restoreHierarchyState(saveState.childrenState);
        }
    }

    /**
     * 重写dispatchSaveInstanceState方法，在ViewGroup中这个方法是保存自己以及子View的状态
     * 这里我们已经手动保存了子View的状态，所以不需要再去保存
     * 我们调用dispatchFreezeSelfOnly只保存自己的状态
     */
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /**
     * dispatchRestoreInstanceState，在ViewGroup中这个方法是恢复自己以及子View的状态
     * 这里我们已经手动恢复了子View的状态，所以不需要再去恢复
     * 我们调用dispatchThawSelfOnly只保存自己的状态
     */
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    static class SaveState extends BaseSavedState {
        private SparseArray childrenState;

        SaveState(Parcel source) {
            super(source);

        }

        SaveState(Parcel source, ClassLoader loader) {
            super(source);
            childrenState = source.readSparseArray(loader);
        }

        SaveState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeSparseArray(childrenState);
        }

        public static final ClassLoaderCreator<SaveState> CREATOR = new ClassLoaderCreator<SaveState>() {
            @Override
            public SaveState createFromParcel(Parcel source, ClassLoader loader) {
                return new SaveState(source, loader);
            }

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
}
