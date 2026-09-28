package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzetw implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final int f30321a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30322b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f30323c;

    /* renamed from: d, reason: collision with root package name */
    public final int f30324d;

    /* renamed from: e, reason: collision with root package name */
    public final int f30325e;

    /* renamed from: f, reason: collision with root package name */
    public final int f30326f;

    /* renamed from: g, reason: collision with root package name */
    public final int f30327g;

    /* renamed from: h, reason: collision with root package name */
    public final int f30328h;

    /* renamed from: i, reason: collision with root package name */
    public final float f30329i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f30330j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f30331k;

    public zzetw(int i2, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, float f2, boolean z3, boolean z4) {
        this.f30321a = i2;
        this.f30322b = z;
        this.f30323c = z2;
        this.f30324d = i3;
        this.f30325e = i4;
        this.f30326f = i5;
        this.f30327g = i6;
        this.f30328h = i7;
        this.f30329i = f2;
        this.f30330j = z3;
        this.f30331k = z4;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ec)).booleanValue()) {
            bundle.putInt("muv_min", this.f30325e);
            bundle.putInt("muv_max", this.f30326f);
        }
        bundle.putFloat("android_app_volume", this.f30329i);
        bundle.putBoolean("android_app_muted", this.f30330j);
        if (this.f30331k) {
            return;
        }
        bundle.putInt("am", this.f30321a);
        bundle.putBoolean("ma", this.f30322b);
        bundle.putBoolean("sp", this.f30323c);
        bundle.putInt("muv", this.f30324d);
        bundle.putInt("rm", this.f30327g);
        bundle.putInt("riv", this.f30328h);
    }
}
