package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzcuk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzemk f27168a;

    /* renamed from: b, reason: collision with root package name */
    public final zzeoj f27169b;

    public zzcuk(zzemk zzemkVar, zzeoj zzeojVar) {
        this.f27168a = zzemkVar;
        this.f27169b = zzeojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.p6);
        bool.booleanValue();
        return true == bool.booleanValue() ? this.f27168a.zzb() : this.f27169b.zzb();
    }
}
