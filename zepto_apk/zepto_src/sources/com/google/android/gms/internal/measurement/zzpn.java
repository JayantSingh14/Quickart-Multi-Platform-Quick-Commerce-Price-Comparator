package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpn implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpn f37249b = new zzpn();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37250a = Suppliers.b(new zzpp());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpo) this.f37250a.get();
    }
}
