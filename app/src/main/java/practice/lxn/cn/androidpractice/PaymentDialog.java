package practice.lxn.cn.androidpractice;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import practice.lxn.cn.androidpractice.common.Action1;

/**
 *
 */

public class PaymentDialog extends Dialog {
    public PaymentDialog(@NonNull Context context) {
        this(context,R.style.ActionSheetDialogStyle);
    }

    public static void start(Context context, double money, Action1<Integer> callBack){
        PaymentDialog paymentDialog = new PaymentDialog(context);
        paymentDialog.show();
    }

    private PaymentDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_payment, null);
        setContentView(contentView);
        Window window = getWindow();
        if (window != null) {
            //dialog从底部弹出
            window.setGravity(Gravity.BOTTOM);
            //设置Dialog和屏幕之间的间隔
            window.getDecorView().setPadding(50,0,50,50);
            Point point = new Point();
            Display display = getWindow().getWindowManager().getDefaultDisplay();
            display.getSize(point);
            setCanceledOnTouchOutside(false);//点击Dialog外部不能关闭
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = point.x;//dialog宽度为屏幕宽度
            window.setAttributes(lp);
        }
    }
    public void showPaymentDialog(){
        show();
    }
}
