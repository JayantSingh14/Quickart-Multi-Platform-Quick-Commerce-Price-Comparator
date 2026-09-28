package com.rnmaps.maps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.appsflyer.AdRevenueScheme;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = MapModule.NAME)
/* loaded from: classes.dex */
public class MapModule extends ReactContextBaseJavaModule {
    public static final String NAME = "AirMapModule";
    private static final String SNAPSHOT_FORMAT_JPG = "jpg";
    private static final String SNAPSHOT_FORMAT_PNG = "png";
    private static final String SNAPSHOT_RESULT_BASE64 = "base64";
    private static final String SNAPSHOT_RESULT_FILE = "file";

    public MapModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$coordinateForPoint$4(Point point, Promise promise, MapView mapView) {
        LatLng latLngA = mapView.f46620b.f().a(point);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("latitude", latLngA.f38475a);
        writableNativeMap.putDouble("longitude", latLngA.f38476b);
        promise.resolve(writableNativeMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getAddressFromCoordinates$2(ReadableMap readableMap, Promise promise, ReactApplicationContext reactApplicationContext, MapView mapView) throws IOException {
        List<Address> fromLocation;
        if (readableMap == null || !readableMap.hasKey("latitude") || !readableMap.hasKey("longitude")) {
            promise.reject("Invalid coordinate format");
            return null;
        }
        try {
            fromLocation = new Geocoder(reactApplicationContext).getFromLocation(readableMap.getDouble("latitude"), readableMap.getDouble("longitude"), 1);
        } catch (IOException unused) {
            promise.reject("Can not get address location");
        }
        if (fromLocation.isEmpty()) {
            promise.reject("Can not get address location");
            return null;
        }
        Address address = fromLocation.get(0);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(CLConstants.FIELD_PAY_INFO_NAME, address.getFeatureName());
        writableNativeMap.putString("locality", address.getLocality());
        writableNativeMap.putString("thoroughfare", address.getThoroughfare());
        writableNativeMap.putString("subThoroughfare", address.getSubThoroughfare());
        writableNativeMap.putString("subLocality", address.getSubLocality());
        writableNativeMap.putString("administrativeArea", address.getAdminArea());
        writableNativeMap.putString("subAdministrativeArea", address.getSubAdminArea());
        writableNativeMap.putString("postalCode", address.getPostalCode());
        writableNativeMap.putString("countryCode", address.getCountryCode());
        writableNativeMap.putString(AdRevenueScheme.COUNTRY, address.getCountryName());
        promise.resolve(writableNativeMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getCamera$1(Promise promise, MapView mapView) {
        CameraPosition cameraPositionD = mapView.f46620b.d();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("latitude", cameraPositionD.f38435a.f38475a);
        writableNativeMap.putDouble("longitude", cameraPositionD.f38435a.f38476b);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putMap("center", writableNativeMap);
        writableNativeMap2.putDouble("heading", cameraPositionD.f38438d);
        writableNativeMap2.putDouble("zoom", cameraPositionD.f38436b);
        writableNativeMap2.putDouble("pitch", cameraPositionD.f38437c);
        promise.resolve(writableNativeMap2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$getMapBoundaries$5(Promise promise, MapView mapView) {
        double[][] mapBoundaries = mapView.getMapBoundaries();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap2.putDouble("longitude", mapBoundaries[0][0]);
        writableNativeMap2.putDouble("latitude", mapBoundaries[0][1]);
        writableNativeMap3.putDouble("longitude", mapBoundaries[1][0]);
        writableNativeMap3.putDouble("latitude", mapBoundaries[1][1]);
        writableNativeMap.putMap("northEast", writableNativeMap2);
        writableNativeMap.putMap("southWest", writableNativeMap3);
        promise.resolve(writableNativeMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$pointForCoordinate$3(LatLng latLng, double d2, Promise promise, MapView mapView) {
        Point pointC = mapView.f46620b.f().c(latLng);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("x", pointC.x / d2);
        writableNativeMap.putDouble("y", pointC.y / d2);
        promise.resolve(writableNativeMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$takeSnapshot$0(final Promise promise, final Integer num, final Integer num2, final String str, final String str2, final ReactApplicationContext reactApplicationContext, final Bitmap.CompressFormat compressFormat, final double d2, MapView mapView) {
        mapView.f46620b.L(new GoogleMap.SnapshotReadyCallback() { // from class: com.rnmaps.maps.MapModule.1
            @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
            public final void a(Bitmap bitmap) throws IOException {
                Promise promise2 = promise;
                if (bitmap == null) {
                    promise2.reject("Failed to generate bitmap, snapshot = null");
                    return;
                }
                Integer num3 = num;
                if (num3.intValue() != 0) {
                    Integer num4 = num2;
                    if (num4.intValue() != 0 && (num3.intValue() != bitmap.getWidth() || num4.intValue() != bitmap.getHeight())) {
                        bitmap = Bitmap.createScaledBitmap(bitmap, num3.intValue(), num4.intValue(), true);
                    }
                }
                String str3 = str;
                boolean zEquals = str3.equals("file");
                double d3 = d2;
                Bitmap.CompressFormat compressFormat2 = compressFormat;
                if (!zEquals) {
                    if (str3.equals(MapModule.SNAPSHOT_RESULT_BASE64)) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(compressFormat2, (int) (d3 * 100.0d), byteArrayOutputStream);
                        MapModule.closeQuietly(byteArrayOutputStream);
                        promise2.resolve(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                        return;
                    }
                    return;
                }
                try {
                    File fileCreateTempFile = File.createTempFile("AirMapSnapshot", CLConstants.DOT_SALT_DELIMETER + str2, reactApplicationContext.getCacheDir());
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    bitmap.compress(compressFormat2, (int) (d3 * 100.0d), fileOutputStream);
                    MapModule.closeQuietly(fileOutputStream);
                    promise2.resolve(Uri.fromFile(fileCreateTempFile).toString());
                } catch (Exception e2) {
                    promise2.reject(e2);
                }
            }
        });
        return null;
    }

    @ReactMethod
    public void coordinateForPoint(int i2, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d2 = reactApplicationContext.getResources().getDisplayMetrics().density;
        new MapUIBlock(i2, promise, reactApplicationContext, new b(0, new Point(readableMap.hasKey("x") ? (int) (readableMap.getDouble("x") * d2) : 0, readableMap.hasKey("y") ? (int) (readableMap.getDouble("y") * d2) : 0), promise)).a();
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    @ReactMethod
    public void getAddressFromCoordinates(int i2, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        new MapUIBlock(i2, promise, reactApplicationContext, new a(readableMap, promise, reactApplicationContext, 0)).a();
    }

    @ReactMethod
    public void getCamera(int i2, Promise promise) {
        new MapUIBlock(i2, promise, getReactApplicationContext(), new d(1, promise)).a();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("legalNotice", "This license information is displayed in Settings > Google > Open Source on any device running Google Play services.");
        return map;
    }

    @ReactMethod
    public void getMapBoundaries(int i2, Promise promise) {
        new MapUIBlock(i2, promise, getReactApplicationContext(), new d(0, promise)).a();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void pointForCoordinate(int i2, ReadableMap readableMap, final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final double d2 = reactApplicationContext.getResources().getDisplayMetrics().density;
        final LatLng latLng = new LatLng(readableMap.hasKey("latitude") ? readableMap.getDouble("latitude") : 0.0d, readableMap.hasKey("longitude") ? readableMap.getDouble("longitude") : 0.0d);
        new MapUIBlock(i2, promise, reactApplicationContext, new Function() { // from class: com.rnmaps.maps.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MapModule.lambda$pointForCoordinate$3(latLng, d2, promise, (MapView) obj);
            }
        }).a();
    }

    @ReactMethod
    public void takeSnapshot(int i2, ReadableMap readableMap, final Promise promise) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final String string = readableMap.hasKey("format") ? readableMap.getString("format") : SNAPSHOT_FORMAT_PNG;
        final Bitmap.CompressFormat compressFormat = string.equals(SNAPSHOT_FORMAT_PNG) ? Bitmap.CompressFormat.PNG : string.equals(SNAPSHOT_FORMAT_JPG) ? Bitmap.CompressFormat.JPEG : null;
        final double d2 = readableMap.hasKey("quality") ? readableMap.getDouble("quality") : 1.0d;
        DisplayMetrics displayMetrics = reactApplicationContext.getResources().getDisplayMetrics();
        final Integer numValueOf = Integer.valueOf(readableMap.hasKey(Snapshot.WIDTH) ? (int) (readableMap.getDouble(Snapshot.WIDTH) * displayMetrics.density) : 0);
        final Integer numValueOf2 = Integer.valueOf(readableMap.hasKey(Snapshot.HEIGHT) ? (int) (readableMap.getDouble(Snapshot.HEIGHT) * displayMetrics.density) : 0);
        final String string2 = readableMap.hasKey("result") ? readableMap.getString("result") : "file";
        new MapUIBlock(i2, promise, reactApplicationContext, new Function() { // from class: com.rnmaps.maps.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                MapModule mapModule = this.f46680a;
                Integer num = numValueOf;
                Integer num2 = numValueOf2;
                String str = string;
                ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
                Bitmap.CompressFormat compressFormat2 = compressFormat;
                return mapModule.lambda$takeSnapshot$0(promise, num, num2, string2, str, reactApplicationContext2, compressFormat2, d2, (MapView) obj);
            }
        }).a();
    }
}
