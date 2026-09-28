package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzexg implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f30523a;

    public zzexg(Boolean bool) {
        this.f30523a = bool;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Boolean bool = this.f30523a;
        if (bool != null) {
            zzczmVar.f27481a.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
