package practice.lxn.cn.androidpractice.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import practice.lxn.cn.androidpractice.PaymentDialog;
import practice.lxn.cn.androidpractice.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }
    public void pay(View view) {
        PaymentDialog paymentDialog = new PaymentDialog(this);
        paymentDialog.showPaymentDialog();
    }
}
