package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzfs {
    public static final zzfr a(Object obj, Object obj2) {
        zzfr zzfrVar = (zzfr) obj;
        zzfr zzfrVar2 = (zzfr) obj2;
        if (!zzfrVar2.isEmpty()) {
            if (!zzfrVar.f36367a) {
                if (zzfrVar.isEmpty()) {
                    zzfrVar = new zzfr();
                } else {
                    zzfr zzfrVar3 = new zzfr(zzfrVar);
                    zzfrVar3.f36367a = true;
                    zzfrVar = zzfrVar3;
                }
            }
            zzfrVar.b();
            if (!zzfrVar2.isEmpty()) {
                zzfrVar.putAll(zzfrVar2);
            }
        }
        return zzfrVar;
    }
}
