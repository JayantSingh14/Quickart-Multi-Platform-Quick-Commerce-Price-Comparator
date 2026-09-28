package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class LazyEvaluator<T> {

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f53125a = null;

    /* renamed from: b, reason: collision with root package name */
    public final Evaluator f53126b;

    public interface Evaluator<T> {
        Object a();
    }

    public LazyEvaluator(Evaluator evaluator) {
        this.f53126b = evaluator;
    }

    public final Object a() {
        if (this.f53125a == null) {
            synchronized (this) {
                try {
                    if (this.f53125a == null) {
                        this.f53125a = this.f53126b.a();
                    }
                } finally {
                }
            }
        }
        return this.f53125a;
    }
}
