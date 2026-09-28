package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzclb {

    /* renamed from: a, reason: collision with root package name */
    public final int f26491a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26492b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26493c;

    public zzclb(int i2, int i3, int i4) {
        this.f26491a = i2;
        this.f26493c = i3;
        this.f26492b = i4;
    }

    public static zzclb a(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        return zzrVar.f21284d ? new zzclb(3, 0, 0) : zzrVar.f21289i ? new zzclb(2, 0, 0) : zzrVar.f21288h ? new zzclb(0, 0, 0) : new zzclb(1, zzrVar.f21286f, zzrVar.f21283c);
    }

    public final boolean b() {
        return this.f26491a == 3;
    }
}
