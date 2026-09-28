package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzrd implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzrd f37306b = new zzrd();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37307a = Suppliers.b(new zzrf());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzre) this.f37307a.get();
    }
}
