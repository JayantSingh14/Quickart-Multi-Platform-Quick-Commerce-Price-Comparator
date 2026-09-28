package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class zzdgi {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f27721a = new HashMap();

    public zzdgi(Set set) {
        synchronized (this) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                zzdij zzdijVar = (zzdij) it.next();
                synchronized (this) {
                    t0(zzdijVar.f27784a, zzdijVar.f27785b);
                }
            }
        }
    }

    public final synchronized void t0(Object obj, Executor executor) {
        this.f27721a.put(obj, executor);
    }

    public final synchronized void v0(final zzdgh zzdghVar) {
        for (Map.Entry entry : this.f27721a.entrySet()) {
            final Object key = entry.getKey();
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgg
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdghVar.zza(key);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.e("EventEmitter.notify", th);
                        com.google.android.gms.ads.internal.util.zze.l("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
