package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzqr implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzqr f37294b = new zzqr();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37295a = Suppliers.b(new zzqt());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzqs) this.f37295a.get();
    }
}
