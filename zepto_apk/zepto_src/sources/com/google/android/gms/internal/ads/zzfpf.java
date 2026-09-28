package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzfpf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f31546a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f31547b;

    /* renamed from: c, reason: collision with root package name */
    public final zzczy f31548c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f31549d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f31550e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdaa f31551f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f31552g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f31553h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f31554i;

    public zzfpf(zzijf zzijfVar, zzcmg zzcmgVar, zzczy zzczyVar, zzijf zzijfVar2, zzijf zzijfVar3, zzdaa zzdaaVar, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6) {
        this.f31546a = zzijfVar;
        this.f31547b = zzcmgVar;
        this.f31548c = zzczyVar;
        this.f31549d = zzijfVar2;
        this.f31550e = zzijfVar3;
        this.f31551f = zzdaaVar;
        this.f31552g = zzijfVar4;
        this.f31553h = zzijfVar5;
        this.f31554i = zzijfVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzemr zzemrVar = (zzemr) this.f31546a.zzb();
        VersionInfoParcel versionInfoParcelA = this.f31547b.a();
        String str = ((zzcxa) this.f31548c.f27531a.zzb()).f27336b.f25900e;
        zzijo.a(str);
        return new zzfpe(zzemrVar, versionInfoParcelA, str, (String) this.f31549d.zzb(), (Context) this.f31550e.zzb(), this.f31551f.f27540a.f27521d, (zzfie) this.f31552g.zzb(), (Clock) this.f31553h.zzb(), (zzayq) this.f31554i.zzb());
    }
}
