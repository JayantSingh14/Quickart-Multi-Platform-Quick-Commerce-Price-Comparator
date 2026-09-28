package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzidh extends zzidf {
    @Override // com.google.android.gms.internal.ads.zzidf
    public final /* bridge */ /* synthetic */ void a(Object obj, int i2, long j2) {
        ((zzidg) obj).d(i2 << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.ads.zzidf
    public final /* bridge */ /* synthetic */ void b(int i2, int i3, Object obj) {
        ((zzidg) obj).d((i2 << 3) | 5, Integer.valueOf(i3));
    }

    @Override // com.google.android.gms.internal.ads.zzidf
    public final /* bridge */ /* synthetic */ void c(Object obj, int i2, long j2) {
        ((zzidg) obj).d((i2 << 3) | 1, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.ads.zzidf
    public final /* bridge */ /* synthetic */ void d(Object obj, int i2, zzhzl zzhzlVar) {
        ((zzidg) obj).d((i2 << 3) | 2, zzhzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzidf
    public final /* bridge */ /* synthetic */ void e(int i2, Object obj, Object obj2) {
        ((zzidg) obj).d((i2 << 3) | 3, (zzidg) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzidf
    public final /* synthetic */ zzidg f() {
        return zzidg.a();
    }

    @Override // com.google.android.gms.internal.ads.zzidf
    public final zzidg g(Object obj) {
        zzidg zzidgVar = (zzidg) obj;
        if (zzidgVar.f34765e) {
            zzidgVar.f34765e = false;
        }
        return zzidgVar;
    }

    public final /* bridge */ /* synthetic */ zzidg i(Object obj) {
        zziar zziarVar = (zziar) obj;
        zzidg zzidgVar = zziarVar.zzt;
        if (zzidgVar != zzidg.f34760f) {
            return zzidgVar;
        }
        zzidg zzidgVarA = zzidg.a();
        zziarVar.zzt = zzidgVarA;
        return zzidgVarA;
    }

    public final /* synthetic */ void j(Object obj, Object obj2) {
        ((zziar) obj).zzt = (zzidg) obj2;
    }

    public final void k(Object obj) {
        zzidg zzidgVar = ((zziar) obj).zzt;
        if (zzidgVar.f34765e) {
            zzidgVar.f34765e = false;
        }
    }
}
