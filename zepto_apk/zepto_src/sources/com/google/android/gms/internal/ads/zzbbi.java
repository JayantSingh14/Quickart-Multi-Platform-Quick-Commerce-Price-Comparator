package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzbbi {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f24676a = new HashMap();

    public final AtomicReference a(String str) {
        synchronized (this) {
            try {
                HashMap map = this.f24676a;
                if (!map.containsKey(str)) {
                    map.put(str, new AtomicReference());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (AtomicReference) this.f24676a.get(str);
    }
}
