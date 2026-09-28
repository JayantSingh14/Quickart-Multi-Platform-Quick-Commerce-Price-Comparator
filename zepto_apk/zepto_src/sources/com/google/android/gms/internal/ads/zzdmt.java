package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdmt implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27978a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27979b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27980c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f27981d;

    public zzdmt(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f27978a = zzijfVar;
        this.f27979b = zzijfVar2;
        this.f27980c = zzijfVar3;
        this.f27981d = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbch zzbchVar = (zzbch) this.f27978a.zzb();
        Executor executor = (Executor) this.f27979b.zzb();
        Context context = (Context) this.f27980c.zzb();
        return new zzcsh(executor, new zzcrt(context, zzbchVar), (Clock) this.f27981d.zzb());
    }
}
