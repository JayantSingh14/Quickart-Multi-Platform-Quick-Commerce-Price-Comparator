package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzibo {
    public static final zzibd a(long j2, Object obj) {
        zzibd zzibdVar = (zzibd) zzidm.j(j2, obj);
        if (zzibdVar.zza()) {
            return zzibdVar;
        }
        int size = zzibdVar.size();
        zzibd zzibdVarZzh = zzibdVar.zzh(size == 0 ? 10 : size + size);
        zzidm.k(obj, j2, zzibdVarZzh);
        return zzibdVarZzh;
    }
}
