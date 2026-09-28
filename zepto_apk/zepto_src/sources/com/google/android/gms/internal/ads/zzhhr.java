package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhhr {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33831a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f33832b = new HashMap();

    public final void a(Enum r2, Object obj) {
        this.f33831a.put(r2, obj);
        this.f33832b.put(obj, r2);
    }

    public final zzhhs b() {
        return new zzhhs(Collections.unmodifiableMap(this.f33831a), Collections.unmodifiableMap(this.f33832b));
    }
}
