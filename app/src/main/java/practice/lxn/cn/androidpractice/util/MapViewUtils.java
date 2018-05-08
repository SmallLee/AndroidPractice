package practice.lxn.cn.androidpractice.util;

import android.location.Location;
import android.location.LocationManager;

import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

import java.util.List;

import practice.lxn.cn.androidpractice.common.Size;

public class MapViewUtils {
    public static final String LAST_MAP_SCALE_LEVEL = "LAST_MAP_SCALE_LEVEL";

    public static final String LAST_MAP_CENTER_LAT = "LAST_MAP_CENTER_LAT";

    public static final String LAST_MAP_CENTER_LON = "LAST_MAP_CENTER_LON";


    public static void scaleByPoints(final MapView mapView, List<LatLng> points, LatLng center, Size size, Boolean animate) {
        if (points == null || points.size() == 0) {
            return;
        }

        if (points.size() == 1) {
            moveToPoint(mapView, points.get(0), animate);
            return;
        }

        int width, height;
        if (size != null) {
            width = size.width;
            height = size.height;
        } else {
            width = 720;
            height = mapView.getHeight();
        }
        width -= SizeUtils.dp2px(mapView.getContext(), 144);
        height -= SizeUtils.dp2px(mapView.getContext(), 68);

        MapStatusUpdate u = MapStatusUpdateFactory.newLatLngBounds(getBounds(points, center), width, height);
//        if (animate) {
//            mapView.getMap().animateMapStatus(u);
//        } else {
            mapView.getMap().setMapStatus(u);
//        }
    }

    public static void moveToPoint(MapView mapView, LatLng point, Boolean animate) {
        if (point != null) {
            MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(point);
//            if (animate) {
//                mapView.getMap().animateMapStatus(u);
//            }
//            else
//            {
                mapView.getMap().setMapStatus(u);
//            }
        }
    }


    private static LatLngBounds getBounds(List<LatLng> points, LatLng center) {
        if (points == null || points.size() == 0) {
            return null;
        }

        LatLng first = points.get(0);

        double minLon = first.longitude;
        double maxLon = first.longitude;
        double minLat = first.latitude;
        double maxLat = first.latitude;

        // 计算所有司机的范围
        for (LatLng point : points) {
            double lon = point.longitude;
            double lat = point.latitude;
            if (minLon > lon) {
                minLon = lon;
            }
            if (maxLon < lon) {
                maxLon = lon;
            }
            if (minLat > lat) {
                minLat = lat;
            }
            if (maxLat < lat) {
                maxLat = lat;
            }
        }

        if (center != null) {
            double halfLat = Math.max(Math.abs(maxLat - center.latitude), Math.abs(minLat - center.latitude));
            double halfLon = Math.max(Math.abs(maxLon - center.longitude), Math.abs(minLon - center.longitude));

            maxLat = center.latitude + halfLat;
            minLat = center.latitude - halfLat;
            maxLon = center.longitude + halfLon;
            minLon = center.longitude - halfLon;
        }
        // 144, 68
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new LatLng(minLat, minLon)); // southwest
        builder.include(new LatLng(maxLat, maxLon)); // northeast
        LatLngBounds bounds = builder.build();
        return bounds;
    }


    public static double getDistance(LatLng point1, LatLng point2) {
        Location location1 = new Location(LocationManager.GPS_PROVIDER);
        location1.setLatitude(point1.latitude);
        location1.setLongitude(point1.longitude);

        Location location2 = new Location(LocationManager.GPS_PROVIDER);
        location2.setLatitude(point2.latitude);
        location2.setLongitude(point2.longitude);

        return location1.distanceTo(location2);
    }

}
