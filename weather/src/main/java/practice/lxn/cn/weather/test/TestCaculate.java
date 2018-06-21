package practice.lxn.cn.weather.test;

import android.content.Context;
import android.widget.Toast;

/**
 * 描述：
 *
 * @author Create by zxy on 2018/6/21
 */
public class TestCaculate {
   public int a = 10;
   public int b = 0;
   
   public void caculate(Context context) {
       Toast.makeText(context, "结果" + a / b, Toast.LENGTH_SHORT).show();
   }
}
