package com.google.android.gms.internal.pal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzaea {
    public static final void a(Object obj, Object obj2) {
        zzadz zzadzVar = (zzadz) obj;
        if (zzadzVar.isEmpty()) {
            return;
        }
        Iterator it = zzadzVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
    }

    public static final zzadz b(Object obj, Object obj2) {
        zzadz zzadzVarA = (zzadz) obj;
        zzadz zzadzVar = (zzadz) obj2;
        if (!zzadzVar.isEmpty()) {
            if (!zzadzVarA.f37436a) {
                zzadzVarA = zzadzVarA.a();
            }
            zzadzVarA.c();
            if (!zzadzVar.isEmpty()) {
                zzadzVarA.putAll(zzadzVar);
            }
        }
        return zzadzVarA;
    }
}
