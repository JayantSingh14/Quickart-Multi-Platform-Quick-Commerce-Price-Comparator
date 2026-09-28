package com.google.android.gms.internal.ads;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzauc implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f24389a;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ zzauc f24388c = new zzauc(1);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzauc f24387b = new zzauc(0);

    public /* synthetic */ zzauc(int i2) {
        this.f24389a = i2;
    }

    @Override // java.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.f24389a != 0 ? zzaus.a(null) : new zzauf();
    }
}
