package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzdui implements zzdbf {

    /* renamed from: a, reason: collision with root package name */
    public final zzcir f28593a;

    public zzdui(zzcir zzcirVar) {
        this.f28593a = zzcirVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void P(Context context) {
        zzcir zzcirVar = this.f28593a;
        if (zzcirVar != null) {
            zzcirVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void S(Context context) {
        zzcir zzcirVar = this.f28593a;
        if (zzcirVar != null) {
            zzcirVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void a(Context context) {
        zzcir zzcirVar = this.f28593a;
        if (zzcirVar != null) {
            zzcirVar.destroy();
        }
    }
}
