package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzrg implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzrg f37310b = new zzrg();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37311a = Suppliers.b(new zzri());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzrh) this.f37311a.get();
    }
}
