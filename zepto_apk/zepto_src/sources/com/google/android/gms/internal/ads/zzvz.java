package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzvz extends zzvu {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f35748e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Object f35749c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f35750d;

    public zzvz(zzbf zzbfVar, Object obj, Object obj2) {
        super(zzbfVar);
        this.f35749c = obj;
        this.f35750d = obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzvu, com.google.android.gms.internal.ads.zzbf
    public final zzbe b(int i2, zzbe zzbeVar, long j2) {
        this.f35734b.b(i2, zzbeVar, j2);
        if (Objects.equals(zzbeVar.f24823a, this.f35749c)) {
            zzbeVar.f24823a = zzbe.f24822m;
        }
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu, com.google.android.gms.internal.ads.zzbf
    public final zzbd d(int i2, zzbd zzbdVar, boolean z) {
        this.f35734b.d(i2, zzbdVar, z);
        if (Objects.equals(zzbdVar.f24738b, this.f35750d) && z) {
            zzbdVar.f24738b = f35748e;
        }
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu, com.google.android.gms.internal.ads.zzbf
    public final int e(Object obj) {
        Object obj2;
        if (f35748e.equals(obj) && (obj2 = this.f35750d) != null) {
            obj = obj2;
        }
        return this.f35734b.e(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzvu, com.google.android.gms.internal.ads.zzbf
    public final Object f(int i2) {
        Object objF = this.f35734b.f(i2);
        return Objects.equals(objF, this.f35750d) ? f35748e : objF;
    }
}
