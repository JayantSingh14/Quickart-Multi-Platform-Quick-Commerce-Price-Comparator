package com.zeptoconsumerapp.FusedLocation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.apiprefetch.factory.ApiPrefetchModule;
import com.zeptoconsumerapp.apiprefetch.factory.ApiPrefetchModuleFactory;
import com.zeptoconsumerapp.apiprefetch.homepage.HomePageOptions;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class FusedLocationModule implements ActivityEventListener, LocationChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f47428a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f47429b;

    public static class PendingLocationRequest {
    }

    public FusedLocationModule(Context context) {
        this.f47429b = context;
    }

    public final void a(final String str, final WritableMap writableMap) {
        try {
            ReactInstanceManager reactInstanceManagerF = ((ReactApplication) this.f47429b.getApplicationContext()).a().f();
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) reactInstanceManagerF.f();
            if (reactApplicationContext != null) {
                Utils.j(reactApplicationContext, str, writableMap);
            } else {
                reactInstanceManagerF.s.add(new ReactInstanceManager.ReactInstanceEventListener() { // from class: com.zeptoconsumerapp.FusedLocation.FusedLocationModule.1
                    @Override // com.facebook.react.ReactInstanceEventListener
                    public final void a(ReactApplicationContext reactApplicationContext2) {
                        Utils.j(reactApplicationContext2, str, writableMap);
                    }
                });
            }
        } catch (Exception e2) {
            Utils.i(e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099 A[PHI: r7
      0x0099: PHI (r7v4 com.zeptoconsumerapp.FusedLocation.LocationAccuracy) = 
      (r7v1 com.zeptoconsumerapp.FusedLocation.LocationAccuracy)
      (r7v2 com.zeptoconsumerapp.FusedLocation.LocationAccuracy)
      (r7v3 com.zeptoconsumerapp.FusedLocation.LocationAccuracy)
      (r7v1 com.zeptoconsumerapp.FusedLocation.LocationAccuracy)
     binds: [B:47:0x0092, B:52:0x009e, B:51:0x009b, B:48:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.facebook.react.bridge.WritableMap r23) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.FusedLocation.FusedLocationModule.b(com.facebook.react.bridge.WritableMap):void");
    }

    public final void c(LocationProvider locationProvider, Location location) {
        if (Utils.d(this.f47429b).booleanValue()) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            if (latitude > 0.0d && longitude > 0.0d) {
                ApiPrefetchModule apiPrefetchModule = ApiPrefetchModule.f47585a;
                ApiPrefetchModuleFactory.b(new HomePageOptions(ApiPrefetchModuleFactory.a(), Double.valueOf(latitude), Double.valueOf(longitude), true)).b();
            }
        }
        if (locationProvider.equals(null)) {
            return;
        }
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
        FusedLocationNativeModule.setCachedLocation(writableMapCreateMap);
        HashMap map = this.f47428a;
        if (((PendingLocationRequest) map.get(locationProvider)) != null) {
            a("USER_LOCATION_RECEIVED", writableMapCreateMap);
            map.remove(locationProvider);
        }
    }

    public final void d(LocationProvider locationProvider, LocationError locationError, String str) {
        if (str == null) {
            int iOrdinal = locationError.ordinal();
            str = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "Internal error occurred" : "Location settings are not satisfied." : "Google play service is not available." : "Location request timed out." : "No location provider available." : "Location permission not granted.";
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("code", locationError.f47459a);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, str);
        if (locationProvider.equals(null)) {
            return;
        }
        HashMap map = this.f47428a;
        if (((PendingLocationRequest) map.get(locationProvider)) != null) {
            a("USER_LOCATION_FAILED", writableMapCreateMap);
            map.remove(locationProvider);
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        Iterator it = this.f47428a.keySet().iterator();
        while (it.hasNext() && !((LocationProvider) it.next()).a(i2, i3)) {
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onNewIntent(Intent intent) {
    }
}
