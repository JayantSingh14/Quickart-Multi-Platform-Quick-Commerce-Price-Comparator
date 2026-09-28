package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* loaded from: classes.dex */
public final class zzoy implements Supplier {

    /* renamed from: b, reason: collision with root package name */
    public static final zzoy f37220b = new zzoy();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f37221a = Suppliers.b(new zzpa());

    @Override // com.google.common.base.Supplier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzoz get() {
        return (zzoz) this.f37221a.get();
    }
}
