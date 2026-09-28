package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzw extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final zzj f37322c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f37323d;

    public zzw(zzj zzjVar) {
        super("require");
        this.f37323d = new HashMap();
        this.f37322c = zzjVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        zzao zzaoVar;
        zzh.a("require", list, 1);
        String strZzc = zzgVar.f36956b.b(zzgVar, (zzao) list.get(0)).zzc();
        HashMap map = this.f37323d;
        if (map.containsKey(strZzc)) {
            return (zzao) map.get(strZzc);
        }
        HashMap map2 = this.f37322c.f36983a;
        if (map2.containsKey(strZzc)) {
            try {
                zzaoVar = (zzao) ((Callable) map2.get(strZzc)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(strZzc)));
            }
        } else {
            zzaoVar = zzao.o0;
        }
        if (zzaoVar instanceof zzai) {
            map.put(strZzc, (zzai) zzaoVar);
        }
        return zzaoVar;
    }
}
