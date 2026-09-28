package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes4.dex */
public final class zzrj implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzrj f37313b = new zzrj();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37314a = Suppliers.b(new zzrl());

    public static boolean a() {
        return ((zzrk) f37313b.f37314a.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return (zzrk) this.f37314a.get();
    }
}
