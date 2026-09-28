package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzpt implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzpt f37258b = new zzpt();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37259a = Suppliers.b(new zzpv());

    public static boolean a() {
        return ((zzpu) f37258b.f37259a.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzpu) this.f37259a.get();
    }
}
