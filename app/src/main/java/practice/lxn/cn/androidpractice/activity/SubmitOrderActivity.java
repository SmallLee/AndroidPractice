package practice.lxn.cn.androidpractice.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import practice.lxn.cn.androidpractice.R;
import practice.lxn.cn.androidpractice.common.DrivingRouteOverlay2;
import practice.lxn.cn.androidpractice.common.SimpleGetRouteResultListener;
import practice.lxn.cn.androidpractice.util.MapViewUtils;

public class SubmitOrderActivity extends AppCompatActivity {
    //叶青大厦地址 出发地
    public static final double startLat = 40.018607;
    public static final double startLng = 116.476262;
    //    116.47404540936678
    public static final double startLat1 = 40.014925656306474;
    public static final double startLng1 = 116.47404540936678;
    private static final int accuracyCircleFillColor = 0xAAFFFF88;
    private static final int accuracyCircleStrokeColor = 0xAA00FF00;
    //    中国建设银行40.00979541551603，116.47439942200612
    public static final double startLat2 = 40.00979541551603;
    public static final double startLng2 = 116.47439942200612;
    private boolean mIsZoomed =false;
    //望京地铁站地址 目的地
    public static final double endLat = 40.00498076646401;
    public static final double endtLng = 116.47468564730775;
    RoutePlanSearch mSearch;
    BaiduMap mBaidumap;
    private DrivingRouteOverlay2 routeOverlY;
    PlanNode startNode = PlanNode.withLocation(new LatLng(startLat, startLng));
    PlanNode endNode = PlanNode.withLocation(new LatLng(endLat, endtLng));
    int count = 0;
    private TextView tvInfo;
    private Overlay carOverly;
    private BitmapDescriptor descriptor;
    private InfoWindow infoWindow;
    private View infoView;
    private SpannableString currentInfo;
    private LatLng mLatLng;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);
        mapView = (MapView) findViewById(R.id.mapView);
        mBaidumap = mapView.getMap();
        mSearch = RoutePlanSearch.newInstance();
        descriptor = BitmapDescriptorFactory.fromResource(R.drawable.icon_map_sq_car);
        MarkerOptions options = new MarkerOptions()
                .icon(descriptor)
                .position(new LatLng(startLat, startLng))
                .title("汽车");
        carOverly = mBaidumap.addOverlay(options);
        routeOverlY = new DrivingRouteOverlay2(mBaidumap);
        initMarkers();
        mSearch.setOnGetRoutePlanResultListener(new SimpleGetRouteResultListener() {

            @Override
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
                if (drivingRouteResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    DrivingRouteLine drivingRouteLine = drivingRouteResult.getRouteLines().get(0);
                    int distance = drivingRouteLine.getDistance();
                    int duration = drivingRouteLine.getDuration();
                    currentInfo = getDrivngInfo(distance,duration);
                    tvInfo.setText(getTextDistance());
                    routeOverlY.setData(drivingRouteLine);
                    routeOverlY.addToMap();
                    infoWindow = new InfoWindow(infoView,mLatLng,-60);
                    mBaidumap.hideInfoWindow();
                    mBaidumap.showInfoWindow(infoWindow);
                }
            }
        });
        mBaidumap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {
            }

            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
                mBaidumap.hideInfoWindow();
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {
                mBaidumap.showInfoWindow(infoWindow);
            }
        });
    }


    public void initMarkers() {
        infoView = LayoutInflater.from(this).inflate(R.layout.info_window_layout,null);
        tvInfo = infoView.findViewById(R.id.tv_route);
        infoWindow = new InfoWindow(infoView,new LatLng(startLat,startLng),-60);
        //上车图标和位置信息
        BitmapDescriptor upCarIcon = BitmapDescriptorFactory.fromResource(R.drawable.map_sign_up);
        MarkerOptions upCarOptions = new MarkerOptions()
                .icon(upCarIcon).position(new LatLng(startLat, startLng));
        TextOptions startOp = new TextOptions().text("叶青大厦")
                .typeface(Typeface.DEFAULT)
                .fontSize(50)
                .position(new LatLng(startLat, startLng));
        //下车图标
        BitmapDescriptor downCarIcon = BitmapDescriptorFactory.fromResource(R.drawable.map_sign_down);
        MarkerOptions downCarOptions = new MarkerOptions()
                .icon(downCarIcon).position(new LatLng(endLat, endtLng));
        TextOptions endtOp = new TextOptions().text("望京地铁站")
                .typeface(Typeface.SANS_SERIF)
                .fontSize(40)
                .position(new LatLng(endLat, endtLng));
        mBaidumap.addOverlay(upCarOptions);
        mBaidumap.addOverlay(startOp);
        mBaidumap.addOverlay(downCarOptions);
        mBaidumap.addOverlay(endtOp);
        //设置气泡信息
        tvInfo.setText("叶青大厦");
        mBaidumap.showInfoWindow(infoWindow);
    }


    //规划路线1
    public void routeplan(View view) {
        mLatLng = new LatLng(startLat,startLng);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String result = format.format(new Date(System.currentTimeMillis()));
        Toast.makeText(this, result+"", Toast.LENGTH_SHORT).show();
        PlanNode startNode = PlanNode.withLocation(mLatLng);
        PlanNode endNode = PlanNode.withLocation(new LatLng(endLat, endtLng));
        MarkerOptions options = new MarkerOptions()
                .icon(descriptor)
                .position(mLatLng)
                .title("汽车");
        carOverly.remove();

        carOverly = mBaidumap.addOverlay(options);
        routeOverlY = new DrivingRouteOverlay2(mBaidumap);
        mSearch.drivingSearch(new DrivingRoutePlanOption().from(startNode).to(endNode));
        List<LatLng> latLng = new ArrayList<>();
        latLng.add(mLatLng);
        latLng.add(new LatLng(endLat,endtLng));
        MapViewUtils.scaleByPoints(mapView,latLng,null,null,false);
    }
    //规划路线1
    public void routeplan2(View view) {
        mLatLng = new LatLng(startLat1,startLng1);
        MarkerOptions options = new MarkerOptions()
                .icon(descriptor)
                .position(mLatLng)
                .title("汽车");
        carOverly.remove();
        carOverly = mBaidumap.addOverlay(options);
        PlanNode startNode = PlanNode.withLocation(mLatLng);
        PlanNode endNode = PlanNode.withLocation(new LatLng(endLat, endtLng));
        mSearch.drivingSearch(new DrivingRoutePlanOption().from(startNode).to(endNode));
    }
    //规划路线1
    public void routeplan3(View view) {
        mLatLng = new LatLng(startLat2, startLng2);
        MarkerOptions options = new MarkerOptions()
                .icon(descriptor)
                .position(mLatLng)
                .title("汽车");
        carOverly.remove();
        carOverly = mBaidumap.addOverlay(options);
        PlanNode startNode = PlanNode.withLocation(mLatLng);
        PlanNode endNode = PlanNode.withLocation(new LatLng(endLat, endtLng));
        mSearch.drivingSearch(new DrivingRoutePlanOption().from(startNode).to(endNode));
    }

    public void clearRoute(View view) {
        routeOverlY.removeFromMap();
    }

    public SpannableString getDrivngInfo(int distance,int duration){
        String distanceStr  = String.format(Locale.getDefault(),"%.1f",(float)distance/1000) + "公里 ";
        String timeStr = String.valueOf(Math.round((float)duration/60));
        String text  = "距您" + distanceStr + "预计" + timeStr + "分钟到达";
        SpannableString sb = new SpannableString(text);
        sb.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)),2,distanceStr.length() - 1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue)),distanceStr.length() + 4,distanceStr.length() + 4 + timeStr.length(),Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        return sb;
    }

    public String getTextDistance(){
        long currentTime = System.currentTimeMillis();
        //十分钟内上车
        long timeLimit = currentTime + 10 * 60 * 1000;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm",Locale.getDefault());
        String result = format.format(new Date(timeLimit));
        return String.format(Locale.getDefault(),"%s",result);
    }
}
