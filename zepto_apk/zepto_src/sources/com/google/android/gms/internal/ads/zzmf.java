package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzmf extends zzvu {

    /* renamed from: c, reason: collision with root package name */
    public final zzbe f35202c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmf(zzmg zzmgVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzmgVar);
        this.f35202c = new zzbe();
    }

    @Override // com.google.android.gms.internal.ads.zzvu, com.google.android.gms.internal.ads.zzbf
    public final zzbd d(int i2, zzbd zzbdVar, boolean z) {
        zzbf zzbfVar = this.f35734b;
        zzbd zzbdVarD = zzbfVar.d(i2, zzbdVar, z);
        if (!zzbfVar.b(zzbdVarD.f24739c, this.f35202c, 0L).b()) {
            zzbdVarD.f24741e = true;
            return zzbdVarD;
        }
        Integer num = zzbdVar.f24737a;
        Object obj = zzbdVar.f24738b;
        int i3 = zzbdVar.f24739c;
        long j2 = zzbdVar.f24740d;
        zzc zzcVar = zzc.f25783b;
        zzbdVarD.a(num, obj, i3, j2, true);
        return zzbdVarD;
    }
}
