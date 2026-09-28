package com.agontuk.RNFusedLocation;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes3.dex */
public class LocationManagerProvider implements LocationProvider {

    /* renamed from: a, reason: collision with root package name */
    public final LocationManager f14055a;

    /* renamed from: b, reason: collision with root package name */
    public final RNFusedLocationModule f14056b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14057c = false;

    /* renamed from: d, reason: collision with root package name */
    public final LocationListener f14058d = new LocationListener() { // from class: com.agontuk.RNFusedLocation.LocationManagerProvider.1
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            LocationManagerProvider locationManagerProvider = LocationManagerProvider.this;
            locationManagerProvider.f14056b.onLocationChange(locationManagerProvider, location);
            if (locationManagerProvider.f14057c) {
                locationManagerProvider.f14059e.removeCallbacks(locationManagerProvider.f14060f);
                locationManagerProvider.c();
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            LocationManagerProvider locationManagerProvider = LocationManagerProvider.this;
            locationManagerProvider.f14056b.onLocationError(locationManagerProvider, LocationError.POSITION_UNAVAILABLE, null);
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i2, Bundle bundle) {
            if (i2 == 2) {
                return;
            }
            onProviderDisabled(str);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public final Handler f14059e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f14060f = new Runnable() { // from class: com.agontuk.RNFusedLocation.LocationManagerProvider.2
        @Override // java.lang.Runnable
        public final void run() {
            LocationManagerProvider locationManagerProvider = LocationManagerProvider.this;
            locationManagerProvider.f14056b.onLocationError(locationManagerProvider, LocationError.TIMEOUT, null);
            locationManagerProvider.c();
        }
    };

    /* renamed from: com.agontuk.RNFusedLocation.LocationManagerProvider$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14063a;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            f14063a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14063a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14063a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14063a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LocationManagerProvider(ReactApplicationContext reactApplicationContext, RNFusedLocationModule rNFusedLocationModule) {
        this.f14056b = rNFusedLocationModule;
        this.f14055a = (LocationManager) reactApplicationContext.getSystemService("location");
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final boolean a(int i2, int i3) {
        return false;
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final void b(LocationOptions locationOptions) {
        this.f14057c = false;
        String strE = e(locationOptions.f14064a);
        if (strE == null) {
            this.f14056b.onLocationError(this, LocationError.POSITION_UNAVAILABLE, null);
        } else {
            f(strE, locationOptions.f14065b, locationOptions.f14067d, locationOptions.f14068e);
        }
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final void c() {
        this.f14055a.removeUpdates(this.f14058d);
    }

    @Override // com.agontuk.RNFusedLocation.LocationProvider
    public final void d(LocationOptions locationOptions) {
        this.f14057c = true;
        String strE = e(locationOptions.f14064a);
        RNFusedLocationModule rNFusedLocationModule = this.f14056b;
        if (strE == null) {
            rNFusedLocationModule.onLocationError(this, LocationError.POSITION_UNAVAILABLE, null);
            return;
        }
        Location lastKnownLocation = this.f14055a.getLastKnownLocation(strE);
        if (lastKnownLocation == null || (SystemClock.elapsedRealtimeNanos() - lastKnownLocation.getElapsedRealtimeNanos()) / 1000000 >= locationOptions.f14069f) {
            f(strE, locationOptions.f14065b, 0.0f, locationOptions.f14068e);
        } else {
            Log.i(RNFusedLocationModule.TAG, "returning cached location.");
            rNFusedLocationModule.onLocationChange(this, lastKnownLocation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(com.agontuk.RNFusedLocation.LocationAccuracy r6) {
        /*
            r5 = this;
            int r0 = r6.ordinal()
            r1 = 0
            r2 = 1
            r3 = 3
            if (r0 == 0) goto L2e
            r4 = 2
            if (r0 == r2) goto L2b
            if (r0 == r4) goto L28
            if (r0 != r3) goto L14
            r6 = r1
            r3 = r6
        L12:
            r4 = r3
            goto L30
        L14:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected value: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L28:
            r3 = r2
            r6 = r4
            goto L12
        L2b:
            r6 = r4
            r3 = r6
            goto L30
        L2e:
            r6 = r2
            goto L12
        L30:
            android.location.Criteria r0 = new android.location.Criteria
            r0.<init>()
            r0.setAccuracy(r6)
            r0.setBearingAccuracy(r3)
            r0.setHorizontalAccuracy(r3)
            r0.setPowerRequirement(r4)
            r0.setSpeedAccuracy(r3)
            r0.setVerticalAccuracy(r3)
            android.location.LocationManager r6 = r5.f14055a
            java.lang.String r0 = r6.getBestProvider(r0, r2)
            if (r0 != 0) goto L62
            java.util.List r6 = r6.getProviders(r2)
            int r0 = r6.size()
            if (r0 <= 0) goto L60
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r6 = (java.lang.String) r6
            return r6
        L60:
            r6 = 0
            return r6
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.agontuk.RNFusedLocation.LocationManagerProvider.e(com.agontuk.RNFusedLocation.LocationAccuracy):java.lang.String");
    }

    public final void f(String str, long j2, float f2, long j3) {
        this.f14055a.requestLocationUpdates(str, j2, f2, this.f14058d, Looper.getMainLooper());
        if (!this.f14057c || j3 <= 0 || j3 == Long.MAX_VALUE) {
            return;
        }
        this.f14059e.postDelayed(this.f14060f, j3);
    }
}
