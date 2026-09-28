package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzcuv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcua f27182a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27183b;

    public zzcuv(zzcua zzcuaVar, zzijf zzijfVar) {
        this.f27182a = zzcuaVar;
        this.f27183b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzctj zzctjVar = this.f27182a.f27154a;
        return new zzcuu(zzctjVar.f27120d, (Executor) this.f27183b.zzb());
    }
}
