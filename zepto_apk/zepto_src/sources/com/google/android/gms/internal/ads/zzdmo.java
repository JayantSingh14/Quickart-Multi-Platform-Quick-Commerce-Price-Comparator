package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zzdmo implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27972a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcwb f27973b;

    public zzdmo(zzcwb zzcwbVar, zzijf zzijfVar) {
        this.f27972a = zzijfVar;
        this.f27973b = zzcwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdil((Context) this.f27972a.zzb(), new HashSet(), this.f27973b.a());
    }
}
