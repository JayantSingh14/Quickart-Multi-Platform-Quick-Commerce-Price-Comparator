package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfpg implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfne f31555a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfno f31556b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzdcz f31557c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfpi f31558d;

    public zzfpg(zzfpi zzfpiVar, zzfne zzfneVar, zzfno zzfnoVar, zzdcz zzdczVar) {
        this.f31555a = zzfneVar;
        this.f31556b = zzfnoVar;
        this.f31557c = zzdczVar;
        Objects.requireNonNull(zzfpiVar);
        this.f31558d = zzfpiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfne zzfneVar = this.f31555a;
        if (zzfneVar == null) {
            return;
        }
        zzfneVar.a(false);
        zzfno zzfnoVar = this.f31556b;
        if (zzfnoVar == null) {
            this.f31558d.f31566f.b(zzfneVar.zzm());
        } else {
            zzfnoVar.a(zzfneVar);
            zzfnoVar.h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    @Override // com.google.android.gms.internal.ads.zzgyj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfpg.zzb(java.lang.Object):void");
    }
}
