package practice.lxn.cn.androidpractice.common;

import android.content.Context;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * 定位管理
 */

public class LocationManager {
    private static LocationManager mInstance;
    private LocationClient mLocationClient;
    private LocationClientOption option;
    private static Context mContext;
    public static LocationManager getInstance(Context context) {
        mContext = context;
        if (mInstance == null) {
            mInstance = new LocationManager();
        }
        return mInstance;
    }

    //初始化设置
    public void init(Context context) {
        mLocationClient = new LocationClient(context);
        option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setIsNeedAddress(true);//是否需要地址信息
        option.setCoorType("bd09ll"); // 返回百度经纬度坐标系
        option.setScanSpan(30000);//发起请求定位间隔，默认0，大于1000ms才有效，这里指定30秒定位一次
        mLocationClient.setLocOption(option);
        mLocationClient.registerLocationListener(new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                //此处可以发送定位成功的消息
                int locType = bdLocation.getLocType();
                Toast.makeText(mContext, locType+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //设置定位间隔
    public void setScanSpan(int scanSpan) {
        option.setScanSpan(scanSpan);
        mLocationClient.setLocOption(option);
    }

    public LocationClient getLocationClient() {
        return mLocationClient;
    }
}
