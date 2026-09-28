package io.sentry.android.replay;

import android.annotation.SuppressLint;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata
@SuppressLint({"PrivateApi"})
/* loaded from: classes3.dex */
public final class WindowSpy {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f52512a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f52513b;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53530c;
        f52512a = LazyKt.a(lazyThreadSafetyMode, WindowSpy$decorViewClass$2.f52514c);
        f52513b = LazyKt.a(lazyThreadSafetyMode, WindowSpy$windowField$2.f52515c);
    }
}
