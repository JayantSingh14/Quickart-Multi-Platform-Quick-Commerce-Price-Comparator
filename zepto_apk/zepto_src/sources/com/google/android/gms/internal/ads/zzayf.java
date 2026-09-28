package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzayf implements zzfvd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfuf f24472a;

    public zzayf(zzfuf zzfufVar) {
        this.f24472a = zzfufVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvd
    public final void zza(int i2, long j2) {
        this.f24472a.b(i2, System.currentTimeMillis() - j2);
    }

    @Override // com.google.android.gms.internal.ads.zzfvd
    public final void zzb(int i2, long j2, String str) {
        this.f24472a.e(i2, System.currentTimeMillis() - j2, null, null, str);
    }
}
