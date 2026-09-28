package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpk implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpk f37246b = new zzpk();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37247a = Suppliers.b(new zzpm());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpl) this.f37247a.get();
    }
}
