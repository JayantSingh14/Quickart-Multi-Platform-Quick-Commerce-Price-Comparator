package com.google.android.gms.internal.pal;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzfh {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f37730a = new HashMap();

    public final AtomicReference a(String str) {
        synchronized (this) {
            try {
                if (!this.f37730a.containsKey(str)) {
                    this.f37730a.put(str, new AtomicReference());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (AtomicReference) this.f37730a.get(str);
    }
}
