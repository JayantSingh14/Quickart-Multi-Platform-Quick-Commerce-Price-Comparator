package com.zeptoconsumerapp.performancemode.performanceClasses;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NetworkPerformanceResult {

    /* renamed from: a, reason: collision with root package name */
    public final int f47785a;

    /* renamed from: b, reason: collision with root package name */
    public final int f47786b;

    /* renamed from: c, reason: collision with root package name */
    public final int f47787c;

    /* renamed from: d, reason: collision with root package name */
    public final int f47788d;

    /* renamed from: e, reason: collision with root package name */
    public final NetworkConnectionType f47789e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f47790f;

    public NetworkPerformanceResult(int i2, int i3, int i4, int i5, NetworkConnectionType networkConnectionType, boolean z) {
        Intrinsics.checkNotNullParameter(networkConnectionType, "networkConnectionType");
        this.f47785a = i2;
        this.f47786b = i3;
        this.f47787c = i4;
        this.f47788d = i5;
        this.f47789e = networkConnectionType;
        this.f47790f = z;
    }

    public final int a() {
        return this.f47787c;
    }

    public final int b() {
        return this.f47785a;
    }

    public final boolean c() {
        return this.f47790f;
    }

    public final NetworkConnectionType d() {
        return this.f47789e;
    }

    public final int e() {
        return this.f47788d;
    }

    public final int f() {
        return this.f47786b;
    }
}
