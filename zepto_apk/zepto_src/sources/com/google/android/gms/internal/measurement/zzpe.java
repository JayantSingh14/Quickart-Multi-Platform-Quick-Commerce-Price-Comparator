package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzpe implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpe f37238b = new zzpe();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37239a = Suppliers.b(new zzpg());

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpf) this.f37239a.get();
    }
}
