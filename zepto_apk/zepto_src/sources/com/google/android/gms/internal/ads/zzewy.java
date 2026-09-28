package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzewy implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f30503a;

    public zzewy(Integer num) {
        this.f30503a = num;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        Integer num = this.f30503a;
        if (num != null) {
            zzczmVar.f27481a.putInt("dspct", Math.min(num.intValue(), 20));
        }
    }
}
