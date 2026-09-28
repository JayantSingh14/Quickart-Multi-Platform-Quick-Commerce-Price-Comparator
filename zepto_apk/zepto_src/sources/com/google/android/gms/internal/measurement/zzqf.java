package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzqf implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzqf f37270b = new zzqf();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37271a = Suppliers.b(new zzqh());

    public static boolean a() {
        return ((zzqg) f37270b.f37271a.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzqg) this.f37271a.get();
    }
}
