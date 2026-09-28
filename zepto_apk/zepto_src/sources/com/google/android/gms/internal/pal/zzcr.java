package com.google.android.gms.internal.pal;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public abstract class zzcr implements zzcq {
    public static volatile zzdu t;

    /* renamed from: a, reason: collision with root package name */
    public MotionEvent f37583a;

    /* renamed from: j, reason: collision with root package name */
    public double f37592j;

    /* renamed from: k, reason: collision with root package name */
    public double f37593k;

    /* renamed from: l, reason: collision with root package name */
    public double f37594l;

    /* renamed from: m, reason: collision with root package name */
    public float f37595m;
    public float n;
    public float o;
    public float p;
    public final DisplayMetrics s;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f37584b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public long f37585c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f37586d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f37587e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f37588f = 0;

    /* renamed from: g, reason: collision with root package name */
    public long f37589g = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f37590h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f37591i = 0;
    public boolean q = false;
    public boolean r = false;

    public zzcr(Context context) {
        try {
            if (((Boolean) zzfv.f37741d.f37744c.a(zzgk.p)).booleanValue()) {
                zzbn.b();
            } else {
                zzdv.a(t);
            }
            this.s = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    public final String a(Context context) {
        char[] cArr = zzdx.f37659a;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return e(context, null, 1, null, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public abstract zzr b(Context context, View view, Activity activity);

    public abstract zzr c(Context context, zzi zziVar);

    public abstract zzr d(Context context, View view, Activity activity);

    public final String e(Context context, String str, int i2, View view, Activity activity, byte[] bArr) {
        zzi zziVarP;
        zzcp zzcpVar;
        String str2;
        int i3;
        int i4;
        String strA;
        zzr zzrVarC;
        int i5;
        int i6;
        int i7 = i2;
        zzr zzrVarB = null;
        if (bArr == null || bArr.length <= 0) {
            zziVarP = null;
        } else {
            try {
                zziVarP = zzi.p(bArr, zzacm.a());
            } catch (zzadi unused) {
            } catch (NullPointerException unused2) {
                return Integer.toString(3);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzgc zzgcVar = zzgk.f37769f;
        zzfv zzfvVar = zzfv.f37741d;
        boolean zBooleanValue = ((Boolean) zzfvVar.f37744c.a(zzgcVar)).booleanValue();
        if (zBooleanValue) {
            zzcp zzcpVar2 = t != null ? t.f37645l : null;
            str2 = true != ((Boolean) zzfvVar.f37744c.a(zzgk.p)).booleanValue() ? "te" : "be";
            zzcpVar = zzcpVar2;
        } else {
            zzcpVar = null;
            str2 = null;
        }
        try {
            if (i7 == 3) {
                zzrVarB = b(context, view, activity);
                this.q = true;
                i6 = 1002;
            } else {
                if (i7 == 2) {
                    zzrVarC = d(context, view, activity);
                    i5 = 1008;
                } else {
                    zzrVarC = c(context, zziVarP);
                    i5 = 1000;
                }
                zzrVarB = zzrVarC;
                i6 = i5;
            }
            if (zBooleanValue && zzcpVar != null) {
                zzcpVar.a(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
            }
        } catch (Exception e2) {
            if (zBooleanValue && zzcpVar != null) {
                if (i7 == 3) {
                    i4 = 1003;
                } else if (i7 == 2) {
                    i4 = 1009;
                } else {
                    i3 = 1001;
                    i7 = 1;
                    zzcpVar.a(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e2);
                }
                i3 = i4;
                zzcpVar.a(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e2);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (zzrVarB != null) {
            try {
                if (((zzaf) zzrVarB.h()).i() == 0) {
                    strA = Integer.toString(5);
                } else {
                    strA = zzbn.a((zzaf) zzrVarB.h(), str);
                    if (zBooleanValue && zzcpVar != null) {
                        zzcpVar.a(i7 == 3 ? 1006 : i7 == 2 ? 1010 : 1004, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, null);
                    }
                }
            } catch (Exception e3) {
                strA = Integer.toString(7);
                if (zBooleanValue && zzcpVar != null) {
                    zzcpVar.a(i7 == 3 ? 1007 : i7 == 2 ? 1011 : 1005, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, e3);
                }
            }
        } else {
            strA = Integer.toString(5);
        }
        return strA;
    }
}
