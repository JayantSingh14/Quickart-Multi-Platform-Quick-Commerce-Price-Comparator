package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbrn implements zzcdv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrl f25482a;

    public zzbrn(zzbrq zzbrqVar, zzbrl zzbrlVar) {
        this.f25482a = zzbrlVar;
        Objects.requireNonNull(zzbrqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.k("Rejecting reference for JS Engine.");
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w8)).booleanValue();
        zzbrl zzbrlVar = this.f25482a;
        if (zBooleanValue) {
            zzbrlVar.c("SdkJavascriptFactory.createNewReference.FailureCallback", new IllegalStateException("Unable to create JS engine reference."));
        } else {
            zzbrlVar.b();
        }
    }
}
