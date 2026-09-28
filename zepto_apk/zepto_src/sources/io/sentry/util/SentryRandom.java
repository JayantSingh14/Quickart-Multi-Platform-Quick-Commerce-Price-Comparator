package io.sentry.util;

/* loaded from: classes3.dex */
public final class SentryRandom {

    /* renamed from: a, reason: collision with root package name */
    public static final SentryRandomThreadLocal f53133a = new SentryRandomThreadLocal();

    public static class SentryRandomThreadLocal extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public final Random initialValue() {
            return new Random();
        }
    }

    public static Random a() {
        return f53133a.get();
    }
}
