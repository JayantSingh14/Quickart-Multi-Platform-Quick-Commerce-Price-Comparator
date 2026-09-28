package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzra implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzra f37303b = new zzra();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37304a = Suppliers.b(new zzrc());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzrb) this.f37304a.get();
    }
}
