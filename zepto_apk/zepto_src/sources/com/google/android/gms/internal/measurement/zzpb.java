package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzpb implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpb f37235b = new zzpb();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37236a = Suppliers.b(new zzpd());

    public static long a() {
        return ((zzpc) f37235b.f37236a.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpc) this.f37236a.get();
    }
}
