package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzov implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzov f37217b = new zzov();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37218a = Suppliers.b(new zzox());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzow) this.f37218a.get();
    }
}
