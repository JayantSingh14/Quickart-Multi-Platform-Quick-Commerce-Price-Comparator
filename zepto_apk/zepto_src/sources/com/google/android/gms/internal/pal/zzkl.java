package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzkl {
    public static zzkk a(String str) throws GeneralSecurityException {
        Map mapUnmodifiableMap;
        Logger logger = zzlf.f37911a;
        synchronized (zzlf.class) {
            mapUnmodifiableMap = Collections.unmodifiableMap(zzlf.f37917g);
        }
        zzkk zzkkVar = (zzkk) mapUnmodifiableMap.get(str);
        if (zzkkVar != null) {
            return zzkkVar;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
