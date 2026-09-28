package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgjr implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32749a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32750b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32751c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32752d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32753e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f32754f;

    public zzgjr(zzijh zzijhVar, zzijh zzijhVar2, zzijh zzijhVar3, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f32749a = zzijhVar;
        this.f32750b = zzijhVar2;
        this.f32751c = zzijhVar3;
        this.f32752d = zzijfVar;
        this.f32753e = zzijfVar2;
        this.f32754f = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgjq((Context) this.f32749a.f34899a, (ExecutorService) this.f32750b.f34899a, (zzgad) this.f32751c.f34899a, (zzgbc) this.f32752d.zzb(), (zzgnc) this.f32753e.zzb(), (zzgjs) this.f32754f.zzb());
    }
}
