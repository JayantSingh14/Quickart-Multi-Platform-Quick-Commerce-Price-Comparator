package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzffb implements zzgpr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfff f31002a;

    public zzffb(zzfff zzfffVar) {
        this.f31002a = zzfffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgpr
    public final Object apply(Object obj) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.d("", (zzeef) obj);
        com.google.android.gms.ads.internal.util.zze.k("Failed to get a cache key, reverting to legacy flow.");
        zzfff zzfffVar = this.f31002a;
        zzfik zzfikVarZzb = zzfffVar.f31008b.zzb();
        zzfkg zzfkgVar = ((zzfka) zzfffVar.f31007a).f31293b;
        zzbze zzbzeVarA = new zzbzd(zzfkgVar.f31307a).a();
        zzffd zzffdVar = new zzffd(null, new zzfkk(zzfikVarZzb.f31216d, zzfikVarZzb.f31219g, zzbzeVarA.f25768j, zzfkgVar.f31313g, zzfikVarZzb.f31223k));
        zzfffVar.f31010d = zzffdVar;
        return zzffdVar;
    }
}
