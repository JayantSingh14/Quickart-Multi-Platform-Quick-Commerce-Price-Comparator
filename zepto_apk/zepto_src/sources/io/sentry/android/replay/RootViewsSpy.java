package io.sentry.android.replay;

import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class RootViewsSpy implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f52458a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final Object f52459b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final RootViewsSpy$listeners$1 f52460c = new RootViewsSpy$listeners$1(this);

    /* renamed from: d, reason: collision with root package name */
    public final RootViewsSpy$delegatingViewList$1 f52461d = new RootViewsSpy$delegatingViewList$1(this);

    @Metadata
    public static final class Companion {
        public static RootViewsSpy a() {
            RootViewsSpy rootViewsSpy = new RootViewsSpy();
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new c(rootViewsSpy, 1));
            return rootViewsSpy;
        }
    }

    public final RootViewsSpy$listeners$1 a() {
        return this.f52460c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f52458a.set(true);
        this.f52460c.clear();
    }
}
