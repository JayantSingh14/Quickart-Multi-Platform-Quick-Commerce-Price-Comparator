package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzej {
    public static final void a(Object obj, Object obj2) {
        zzei zzeiVar = (zzei) obj;
        if (zzeiVar.isEmpty()) {
            return;
        }
        Iterator it = zzeiVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
    }
}
