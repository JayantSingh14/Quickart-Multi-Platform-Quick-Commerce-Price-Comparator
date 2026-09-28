package com.google.android.gms.internal.ads;

import android.os.Build;

/* loaded from: classes4.dex */
public final class zzpn {

    /* renamed from: c, reason: collision with root package name */
    public static final zzpn f35325c;

    /* renamed from: a, reason: collision with root package name */
    public final String f35326a;

    /* renamed from: b, reason: collision with root package name */
    public final zzpm f35327b;

    static {
        new zzpn("");
        f35325c = new zzpn("preload");
    }

    public zzpn(String str) {
        this.f35326a = str;
        this.f35327b = Build.VERSION.SDK_INT >= 31 ? new zzpm() : null;
    }
}
