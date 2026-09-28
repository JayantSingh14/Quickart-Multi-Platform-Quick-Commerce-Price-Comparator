package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzevl implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzerp f30417a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30418b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30419c;

    public zzevl(zzerp zzerpVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30417a = zzerpVar;
        this.f30418b = zzijfVar;
        this.f30419c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzezx zzernVar = new zzern(this.f30417a.f30174a.a());
        zzezx zzezxVar = (zzeul) this.f30418b.zzb();
        if (true == ((List) this.f30419c.zzb()).contains("2")) {
            zzernVar = zzezxVar;
        }
        zzijo.a(zzernVar);
        return zzernVar;
    }
}
