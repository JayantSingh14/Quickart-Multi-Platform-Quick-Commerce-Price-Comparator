package com.amazon.android.apay.commonlibrary.instrumentationlib.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public class SingletonHolder<T, A> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Function1<A, T> f14917a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile T f14918b;

    /* JADX WARN: Multi-variable type inference failed */
    public SingletonHolder(@NotNull Function1<? super A, ? extends T> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        this.f14917a = constructor;
    }

    public final void clear() {
        this.f14918b = null;
    }

    public final T getInstance(A a2) {
        T t;
        T t2 = this.f14918b;
        if (t2 != null) {
            return t2;
        }
        synchronized (this) {
            t = this.f14918b;
            if (t == null) {
                t = (T) this.f14917a.invoke(a2);
                this.f14918b = t;
            }
        }
        return t;
    }
}
