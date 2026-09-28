package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzin implements zzaah {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f34940a;

    /* renamed from: b, reason: collision with root package name */
    public final zzpn f34941b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzip f34942c;

    public zzin(zzip zzipVar, zzpn zzpnVar) {
        Objects.requireNonNull(zzipVar);
        this.f34942c = zzipVar;
        this.f34940a = new HashMap();
        this.f34941b = zzpnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized void a(zzaag zzaagVar) {
        this.f34942c.f34949c.a(zzaagVar);
        while (zzaagVar != null) {
            c(zzaagVar.zzd());
            zzaagVar = zzaagVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized void b(zzaaf zzaafVar) {
        this.f34942c.f34949c.b(zzaafVar);
        c(zzaafVar);
    }

    public final void c(zzaaf zzaafVar) {
        zzpn zzpnVar = (zzpn) this.f34940a.remove(zzaafVar);
        zzpnVar.getClass();
        zzio zzioVar = (zzio) this.f34942c.n.get(zzpnVar);
        if (zzioVar != null) {
            synchronized (zzioVar) {
                zzioVar.f34946d--;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized zzaaf zza() {
        zzaaf zzaafVarZza;
        zzip zzipVar = this.f34942c;
        zzaan zzaanVar = zzipVar.f34949c;
        HashMap map = this.f34940a;
        zzaafVarZza = zzaanVar.zza();
        zzpn zzpnVar = this.f34941b;
        map.put(zzaafVarZza, zzpnVar);
        zzio zzioVar = (zzio) zzipVar.n.get(zzpnVar);
        if (zzioVar != null) {
            synchronized (zzioVar) {
                zzioVar.f34946d++;
            }
        }
        return zzaafVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzaah
    public final synchronized void zzd() {
        this.f34942c.f34949c.zzd();
    }
}
