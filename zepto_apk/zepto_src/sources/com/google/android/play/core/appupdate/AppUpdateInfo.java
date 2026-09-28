package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AppUpdateInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f41660a;

    /* renamed from: b, reason: collision with root package name */
    public final int f41661b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41662c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f41663d;

    /* renamed from: e, reason: collision with root package name */
    public final int f41664e;

    /* renamed from: f, reason: collision with root package name */
    public final long f41665f;

    /* renamed from: g, reason: collision with root package name */
    public final long f41666g;

    /* renamed from: h, reason: collision with root package name */
    public final long f41667h;

    /* renamed from: i, reason: collision with root package name */
    public final PendingIntent f41668i;

    /* renamed from: j, reason: collision with root package name */
    public final PendingIntent f41669j;

    /* renamed from: k, reason: collision with root package name */
    public final PendingIntent f41670k;

    /* renamed from: l, reason: collision with root package name */
    public final PendingIntent f41671l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41672m = false;

    public AppUpdateInfo(String str, int i2, int i3, Integer num, int i4, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, HashMap map) {
        this.f41660a = str;
        this.f41661b = i2;
        this.f41662c = i3;
        this.f41663d = num;
        this.f41664e = i4;
        this.f41665f = j2;
        this.f41666g = j3;
        this.f41667h = j4;
        this.f41668i = pendingIntent;
        this.f41669j = pendingIntent2;
        this.f41670k = pendingIntent3;
        this.f41671l = pendingIntent4;
    }

    public final PendingIntent a(AppUpdateOptions appUpdateOptions) {
        int iB = appUpdateOptions.b();
        long j2 = this.f41667h;
        long j3 = this.f41666g;
        if (iB == 0) {
            PendingIntent pendingIntent = this.f41669j;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (!appUpdateOptions.a() || j3 > j2) {
                return null;
            }
            return this.f41671l;
        }
        if (appUpdateOptions.b() == 1) {
            PendingIntent pendingIntent2 = this.f41668i;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (appUpdateOptions.a() && j3 <= j2) {
                return this.f41670k;
            }
        }
        return null;
    }
}
