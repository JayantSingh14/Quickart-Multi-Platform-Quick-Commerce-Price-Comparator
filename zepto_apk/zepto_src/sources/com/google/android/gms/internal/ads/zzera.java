package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzera {

    /* renamed from: a, reason: collision with root package name */
    public final zzerm f30147a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30148b;

    /* renamed from: c, reason: collision with root package name */
    public zzdad f30149c;

    public zzera(zzerm zzermVar, String str) {
        this.f30147a = zzermVar;
        this.f30148b = str;
    }

    public final synchronized void a(com.google.android.gms.ads.internal.client.zzm zzmVar, int i2) {
        this.f30149c = null;
        zzerg zzergVar = new zzerg(i2);
        zzeqz zzeqzVar = new zzeqz(this);
        this.f30147a.a(zzmVar, this.f30148b, zzergVar, zzeqzVar);
    }
}
