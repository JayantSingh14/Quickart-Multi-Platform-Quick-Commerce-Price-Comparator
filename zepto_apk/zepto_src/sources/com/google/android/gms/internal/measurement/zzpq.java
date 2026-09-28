package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpq implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpq f37253b = new zzpq();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37254a = Suppliers.b(new zzps());

    public static void a() {
        ((zzpr) f37253b.f37254a.get()).getClass();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpr) this.f37254a.get();
    }
}
