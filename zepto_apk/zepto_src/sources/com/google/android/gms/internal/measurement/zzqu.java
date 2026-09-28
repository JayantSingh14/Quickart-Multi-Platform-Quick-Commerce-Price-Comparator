package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzqu implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzqu f37297b = new zzqu();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37298a = Suppliers.b(new zzqw());

    public static void a() {
        ((zzqv) f37297b.f37298a.get()).getClass();
    }

    public static boolean b() {
        return ((zzqv) f37297b.f37298a.get()).zzb();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzqv) this.f37298a.get();
    }
}
