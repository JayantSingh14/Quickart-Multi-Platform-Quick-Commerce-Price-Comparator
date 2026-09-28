package com.agontuk.RNFusedLocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.GoogleApiAvailability;

/* loaded from: classes3.dex */
public class LocationUtils {

    /* renamed from: com.agontuk.RNFusedLocation.LocationUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14073a;

        static {
            int[] iArr = new int[LocationError.values().length];
            f14073a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14073a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14073a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14073a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14073a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14073a[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static WritableMap a(LocationError locationError, String str) {
        if (str == null) {
            int iOrdinal = locationError.ordinal();
            str = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "Internal error occurred" : "Location settings are not satisfied." : "Google play service is not available." : "Location request timed out." : "No location provider available." : "Location permission not granted.";
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("code", locationError.f14054a);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str);
        return writableMapCreateMap;
    }

    public static boolean b(ReactApplicationContext reactApplicationContext) {
        return ContextCompat.a(reactApplicationContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.a(reactApplicationContext, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean c(ReactApplicationContext reactApplicationContext) {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(reactApplicationContext);
        return iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 18;
    }

    public static boolean d(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            return i2 >= 28 ? locationManager.isLocationEnabled() : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public static WritableMap e(Location location) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("latitude", location.getLatitude());
        writableMapCreateMap2.putDouble("longitude", location.getLongitude());
        writableMapCreateMap2.putDouble("altitude", location.getAltitude());
        writableMapCreateMap2.putDouble("accuracy", location.getAccuracy());
        writableMapCreateMap2.putDouble("heading", location.getBearing());
        writableMapCreateMap2.putDouble("speed", location.getSpeed());
        if (Build.VERSION.SDK_INT >= 26) {
            writableMapCreateMap2.putDouble("altitudeAccuracy", location.getVerticalAccuracyMeters());
        }
        writableMapCreateMap.putMap("coords", writableMapCreateMap2);
        writableMapCreateMap.putString("provider", location.getProvider());
        writableMapCreateMap.putDouble("timestamp", location.getTime());
        writableMapCreateMap.putBoolean("mocked", location.isFromMockProvider());
        return writableMapCreateMap;
    }
}
