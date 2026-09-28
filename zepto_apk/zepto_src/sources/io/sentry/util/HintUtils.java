package io.sentry.util;

import io.sentry.Hint;
import io.sentry.hints.ApplyScopeData;
import io.sentry.hints.Backfillable;
import io.sentry.hints.Cached;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class HintUtils {

    @FunctionalInterface
    public interface SentryConsumer<T> {
    }

    @FunctionalInterface
    public interface SentryHintFallback {
    }

    @FunctionalInterface
    /* loaded from: classes3.dex */
    public interface SentryNullableConsumer<T> {
    }

    public static Hint a(Object obj) {
        Hint hint = new Hint();
        hint.c(obj, "sentry:typeCheckHint");
        return hint;
    }

    public static Object b(Hint hint) {
        Object obj;
        synchronized (hint) {
            obj = hint.f51636a.get("sentry:typeCheckHint");
        }
        return obj;
    }

    public static boolean c(Hint hint, Class cls) {
        return cls.isInstance(b(hint));
    }

    public static boolean d(Hint hint) {
        return Boolean.TRUE.equals(hint.b(Boolean.class, "sentry:isFromHybridSdk"));
    }

    public static boolean e(Hint hint) {
        return !(Cached.class.isInstance(b(hint)) || Backfillable.class.isInstance(b(hint))) || ApplyScopeData.class.isInstance(b(hint));
    }
}
