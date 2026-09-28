package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzdlo implements zzcvn {

    /* renamed from: a, reason: collision with root package name */
    public final Map f27899a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f27900b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f27901c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f27902d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdnw f27903e;

    public zzdlo(Map map, Map map2, Map map3, zzijf zzijfVar, zzdnw zzdnwVar) {
        this.f27899a = map;
        this.f27900b = map2;
        this.f27901c = map3;
        this.f27902d = zzijfVar;
        this.f27903e = zzdnwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvn
    public final zzejg a(int i2, String str) {
        zzejg zzejgVarA;
        zzejg zzejgVar = (zzejg) this.f27899a.get(str);
        if (zzejgVar != null) {
            return zzejgVar;
        }
        if (i2 != 1) {
            if (i2 != 4) {
                return null;
            }
            zzelm zzelmVar = (zzelm) this.f27901c.get(str);
            if (zzelmVar != null) {
                return new zzejh(zzelmVar, zzcvr.f27241a);
            }
            zzejgVarA = (zzejg) this.f27900b.get(str);
            if (zzejgVarA == null) {
                return null;
            }
        } else if (this.f27903e.f28061d == null || (zzejgVarA = ((zzcvn) this.f27902d.zzb()).a(i2, str)) == null) {
            return null;
        }
        return new zzejh(zzejgVarA, zzcvq.f27240a);
    }
}
