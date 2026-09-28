package io.sentry.util.thread;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class NoOpMainThreadChecker implements IMainThreadChecker {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpMainThreadChecker f53138a = new NoOpMainThreadChecker();

    @Override // io.sentry.util.thread.IMainThreadChecker
    public final boolean a() {
        return false;
    }
}
