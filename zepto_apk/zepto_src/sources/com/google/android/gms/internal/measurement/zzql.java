package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzql implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzql f37281b = new zzql();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37282a = Suppliers.b(new zzqn());

    public static void a() {
        f37281b.get().getClass();
    }

    @Override // com.google.common.base.Supplier
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final zzqm get() {
        return (zzqm) this.f37282a.get();
    }
}
