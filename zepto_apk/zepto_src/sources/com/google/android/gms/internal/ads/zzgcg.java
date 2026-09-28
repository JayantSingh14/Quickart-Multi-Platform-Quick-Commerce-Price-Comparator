package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgcg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32254a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32255b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32256c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32257d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijh f32258e;

    public zzgcg(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar, zzijh zzijhVar2, zzijh zzijhVar3) {
        this.f32254a = zzijhVar;
        this.f32255b = zzijfVar;
        this.f32256c = zzijhVar2;
        this.f32257d = zzijfVar2;
        this.f32258e = zzijhVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f32254a.f34899a;
        zzgbj zzgbjVar = (zzgbj) this.f32255b.zzb();
        ExecutorService executorService = (ExecutorService) this.f32256c.f34899a;
        zzgbc zzgbcVar = (zzgbc) this.f32257d.zzb();
        zzgad zzgadVar = (zzgad) this.f32258e.f34899a;
        return new zzgco(context, zzgbjVar, executorService, zzgbcVar, new Random(), zzgadVar.K().C(), zzgadVar.K().E(), zzgadVar.K().F(), zzgadVar.K().D(), zzgadVar.I(), zzgadVar.F() - 1);
    }
}
