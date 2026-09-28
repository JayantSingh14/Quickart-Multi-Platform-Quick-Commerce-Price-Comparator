package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbeo implements zzbde {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzber f24843a;

    public zzbeo(zzber zzberVar) {
        Objects.requireNonNull(zzberVar);
        this.f24843a = zzberVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void j1(boolean z) {
        zzber zzberVar = this.f24843a;
        if (z) {
            zzberVar.d();
        } else {
            zzberVar.c();
        }
    }
}
