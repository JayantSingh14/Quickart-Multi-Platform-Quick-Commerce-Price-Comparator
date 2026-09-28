package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzht {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f34213a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map f34214b;

    public final synchronized Map a() {
        try {
            if (this.f34214b == null) {
                this.f34214b = Collections.unmodifiableMap(new HashMap(this.f34213a));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f34214b;
    }
}
