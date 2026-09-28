package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgey implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32419a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32420b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32421c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32422d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32423e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f32424f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijh f32425g;

    public zzgey(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijh zzijhVar, zzijh zzijhVar2, zzijh zzijhVar3) {
        this.f32419a = zzijhVar;
        this.f32420b = zzijhVar2;
        this.f32421c = zzijfVar;
        this.f32422d = zzijfVar2;
        this.f32423e = zzijfVar3;
        this.f32424f = zzijfVar4;
        this.f32425g = zzijhVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f32419a.f34899a;
        ExecutorService executorService = (ExecutorService) this.f32420b.f34899a;
        zzgec zzgecVar = (zzgec) this.f32421c.zzb();
        zzgeu zzgeuVar = (zzgeu) this.f32422d.zzb();
        File file = (File) this.f32423e.zzb();
        zzgnc zzgncVar = (zzgnc) this.f32424f.zzb();
        zzgad zzgadVar = (zzgad) this.f32425g.f34899a;
        return new zzgex(context, executorService, zzgecVar, zzgeuVar, file, zzgncVar, zzgadVar.U(), zzgfb.a());
    }
}
