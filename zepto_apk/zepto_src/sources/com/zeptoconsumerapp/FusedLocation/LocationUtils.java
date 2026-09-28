package com.zeptoconsumerapp.FusedLocation;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;

/* loaded from: classes.dex */
public class LocationUtils {

    /* renamed from: com.zeptoconsumerapp.FusedLocation.LocationUtils$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47482a;

        static {
            int[] iArr = new int[LocationError.values().length];
            f47482a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47482a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47482a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47482a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47482a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47482a[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static boolean a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            return i2 >= 28 ? locationManager.isLocationEnabled() : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }
}
