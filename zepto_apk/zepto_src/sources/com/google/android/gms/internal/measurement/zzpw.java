package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzpw implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpw f37261b = new zzpw();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37262a = Suppliers.b(new zzpy());

    public static boolean a() {
        return ((zzpx) f37261b.f37262a.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpx) this.f37262a.get();
    }
}
