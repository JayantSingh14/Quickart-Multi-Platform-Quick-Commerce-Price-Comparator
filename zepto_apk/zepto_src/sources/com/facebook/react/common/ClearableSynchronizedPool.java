package com.facebook.react.common;

import androidx.core.util.Pools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ClearableSynchronizedPool<T> implements Pools.Pool<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f18688a = new Object[1024];

    /* renamed from: b, reason: collision with root package name */
    public int f18689b;

    @Override // androidx.core.util.Pools.Pool
    public final synchronized boolean a(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        int i2 = this.f18689b;
        Object[] objArr = this.f18688a;
        if (i2 == objArr.length) {
            return false;
        }
        objArr[i2] = instance;
        this.f18689b = i2 + 1;
        return true;
    }

    @Override // androidx.core.util.Pools.Pool
    public final synchronized Object b() {
        int i2 = this.f18689b;
        if (i2 == 0) {
            return null;
        }
        int i3 = i2 - 1;
        this.f18689b = i3;
        Object obj = this.f18688a[i3];
        Intrinsics.d(obj, "null cannot be cast to non-null type T of com.facebook.react.common.ClearableSynchronizedPool");
        this.f18688a[i3] = null;
        return obj;
    }

    public final synchronized void c() {
        try {
            int i2 = this.f18689b;
            for (int i3 = 0; i3 < i2; i3++) {
                this.f18688a[i3] = null;
            }
            this.f18689b = 0;
        } catch (Throwable th) {
            throw th;
        }
    }
}
