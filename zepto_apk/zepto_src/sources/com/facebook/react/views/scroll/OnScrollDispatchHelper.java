package com.facebook.react.views.scroll;

import android.os.SystemClock;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class OnScrollDispatchHelper {

    /* renamed from: c, reason: collision with root package name */
    public float f20016c;

    /* renamed from: d, reason: collision with root package name */
    public float f20017d;

    /* renamed from: a, reason: collision with root package name */
    public int f20014a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f20015b = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public long f20018e = -11;

    @Metadata
    public static final class Companion {
    }

    public final boolean a(int i2, int i3) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j2 = this.f20018e;
        boolean z = (jUptimeMillis - j2 <= 10 && this.f20014a == i2 && this.f20015b == i3) ? false : true;
        if (jUptimeMillis - j2 != 0) {
            this.f20016c = (i2 - this.f20014a) / (jUptimeMillis - j2);
            this.f20017d = (i3 - this.f20015b) / (jUptimeMillis - j2);
        }
        this.f20018e = jUptimeMillis;
        this.f20014a = i2;
        this.f20015b = i3;
        return z;
    }
}
