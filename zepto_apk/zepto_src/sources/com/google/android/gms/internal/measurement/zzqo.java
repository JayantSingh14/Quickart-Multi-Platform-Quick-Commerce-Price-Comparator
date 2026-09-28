package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzqo implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzqo f37291b = new zzqo();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37292a = Suppliers.b(new zzqq());

    public static boolean a() {
        return ((zzqp) f37291b.f37292a.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzqp) this.f37292a.get();
    }
}
