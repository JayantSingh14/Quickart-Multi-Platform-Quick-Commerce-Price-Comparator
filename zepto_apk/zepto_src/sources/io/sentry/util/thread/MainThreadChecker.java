package io.sentry.util.thread;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class MainThreadChecker implements IMainThreadChecker {

    /* renamed from: a, reason: collision with root package name */
    public static final long f53136a = Thread.currentThread().getId();

    /* renamed from: b, reason: collision with root package name */
    public static final MainThreadChecker f53137b = new MainThreadChecker();

    public static MainThreadChecker b() {
        return f53137b;
    }

    @Override // io.sentry.util.thread.IMainThreadChecker
    public final boolean a() {
        return f53136a == Thread.currentThread().getId();
    }
}
