package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzewh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeym f30470a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30471b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30472c;

    public zzewh(zzeym zzeymVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30470a = zzeymVar;
        this.f30471b = zzijfVar;
        this.f30472c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzezx zzezxVarZzb = this.f30470a.zzb();
        zzezx zzezxVar = (zzeul) this.f30471b.zzb();
        if (true == ((List) this.f30472c.zzb()).contains("29")) {
            zzezxVarZzb = zzezxVar;
        }
        zzijo.a(zzezxVarZzb);
        return zzezxVarZzb;
    }
}
