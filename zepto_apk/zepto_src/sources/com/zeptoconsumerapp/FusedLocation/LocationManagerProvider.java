package com.zeptoconsumerapp.FusedLocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class LocationManagerProvider implements LocationProvider {

    /* renamed from: a, reason: collision with root package name */
    public final LocationManager f47460a;

    /* renamed from: b, reason: collision with root package name */
    public final FusedLocationModule f47461b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47462c = false;

    /* renamed from: d, reason: collision with root package name */
    public final LocationListener f47463d = new LocationListener() { // from class: com.zeptoconsumerapp.FusedLocation.LocationManagerProvider.1
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            LocationManagerProvider locationManagerProvider = LocationManagerProvider.this;
            locationManagerProvider.f47461b.c(locationManagerProvider, location);
            if (locationManagerProvider.f47462c) {
                locationManagerProvider.f47464e.removeCallbacks(locationManagerProvider.f47465f);
                locationManagerProvider.f47460a.removeUpdates(locationManagerProvider.f47463d);
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            LocationManagerProvider locationManagerProvider = LocationManagerProvider.this;
            locationManagerProvider.f47461b.d(locationManagerProvider, LocationError.POSITION_UNAVAILABLE, null);
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
    public final Handler f47464e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f47465f = new Runnable() { // from class: com.zeptoconsumerapp.FusedLocation.LocationManagerProvider.2
        @Override // java.lang.Runnable
        public final void run() {
            LocationManagerProvider locationManagerProvider = LocationManagerProvider.this;
            locationManagerProvider.f47461b.d(locationManagerProvider, LocationError.TIMEOUT, null);
            locationManagerProvider.f47460a.removeUpdates(locationManagerProvider.f47463d);
        }
    };

    /* renamed from: com.zeptoconsumerapp.FusedLocation.LocationManagerProvider$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47468a;

        static {
            int[] iArr = new int[LocationAccuracy.values().length];
            f47468a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47468a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47468a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47468a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LocationManagerProvider(Context context, FusedLocationModule fusedLocationModule) {
        this.f47461b = fusedLocationModule;
        this.f47460a = (LocationManager) context.getSystemService("location");
    }

    @Override // com.zeptoconsumerapp.FusedLocation.LocationProvider
    public final boolean a(int i2, int i3) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[PHI: r2
      0x0065: PHI (r2v3 java.lang.String) = (r2v2 java.lang.String), (r2v14 java.lang.String) binds: [B:16:0x0052, B:19:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    @Override // com.zeptoconsumerapp.FusedLocation.LocationProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.zeptoconsumerapp.FusedLocation.LocationOptions r13) {
        /*
            r12 = this;
            r0 = 1
            r12.f47462c = r0
            com.zeptoconsumerapp.FusedLocation.LocationAccuracy r1 = r13.f47469a
            int r2 = r1.ordinal()
            r3 = 0
            r4 = 3
            if (r2 == 0) goto L32
            r5 = 2
            if (r2 == r0) goto L2f
            if (r2 == r5) goto L2c
            if (r2 != r4) goto L18
            r1 = r3
            r4 = r1
        L16:
            r5 = r4
            goto L34
        L18:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected value: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L2c:
            r4 = r0
            r1 = r5
            goto L16
        L2f:
            r1 = r5
            r4 = r1
            goto L34
        L32:
            r1 = r0
            goto L16
        L34:
            android.location.Criteria r2 = new android.location.Criteria
            r2.<init>()
            r2.setAccuracy(r1)
            r2.setBearingAccuracy(r4)
            r2.setHorizontalAccuracy(r4)
            r2.setPowerRequirement(r5)
            r2.setSpeedAccuracy(r4)
            r2.setVerticalAccuracy(r4)
            android.location.LocationManager r1 = r12.f47460a
            java.lang.String r2 = r1.getBestProvider(r2, r0)
            r4 = 0
            if (r2 != 0) goto L65
            java.util.List r0 = r1.getProviders(r0)
            int r2 = r0.size()
            if (r2 <= 0) goto L67
            java.lang.Object r0 = r0.get(r3)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L65:
            r6 = r2
            goto L68
        L67:
            r6 = r4
        L68:
            com.zeptoconsumerapp.FusedLocation.FusedLocationModule r0 = r12.f47461b
            if (r6 != 0) goto L72
            com.zeptoconsumerapp.FusedLocation.LocationError r13 = com.zeptoconsumerapp.FusedLocation.LocationError.POSITION_UNAVAILABLE
            r0.d(r12, r13, r4)
            return
        L72:
            android.location.Location r1 = r1.getLastKnownLocation(r6)
            if (r1 == 0) goto L90
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()
            long r4 = r1.getElapsedRealtimeNanos()
            long r2 = r2 - r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            double r2 = (double) r2
            double r4 = r13.f47474f
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L90
            r0.c(r12, r1)
            return
        L90:
            android.location.LocationListener r10 = r12.f47463d
            android.os.Looper r11 = android.os.Looper.getMainLooper()
            long r7 = r13.f47470b
            r9 = 0
            android.location.LocationManager r5 = r12.f47460a
            r5.requestLocationUpdates(r6, r7, r9, r10, r11)
            boolean r0 = r12.f47462c
            if (r0 == 0) goto Lba
            long r0 = r13.f47473e
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 <= 0) goto Lba
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto Lba
            android.os.Handler r13 = r12.f47464e
            java.lang.Runnable r2 = r12.f47465f
            r13.postDelayed(r2, r0)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.FusedLocation.LocationManagerProvider.b(com.zeptoconsumerapp.FusedLocation.LocationOptions):void");
    }
}
