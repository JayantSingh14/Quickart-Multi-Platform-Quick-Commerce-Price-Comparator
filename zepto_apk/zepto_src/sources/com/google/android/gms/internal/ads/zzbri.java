package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbri implements zzcdx {
    @Override // com.google.android.gms.internal.ads.zzcdx
    public final void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("Ending javascript session.");
        zzbrt zzbrtVar = (zzbrt) ((zzbrs) obj);
        HashSet hashSet = zzbrtVar.f25498b;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            com.google.android.gms.ads.internal.util.zze.k("Unregistering eventhandler: ".concat(String.valueOf(((zzbnn) simpleEntry.getValue()).toString())));
            zzbrtVar.f25497a.x0((String) simpleEntry.getKey(), (zzbnn) simpleEntry.getValue());
        }
        hashSet.clear();
    }
}
