package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbsh implements zzcdv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f25513a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbrl f25514b;

    public zzbsh(zzbrl zzbrlVar, zzbsj zzbsjVar, zzcdt zzcdtVar) {
        this.f25513a = zzcdtVar;
        this.f25514b = zzbrlVar;
        Objects.requireNonNull(zzbsjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.k("callJs > getEngine: Promise rejected");
        this.f25513a.c(new zzbru("Unable to obtain a JavascriptEngine."));
        this.f25514b.d();
    }
}
