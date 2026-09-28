package io.sentry.android.core.util;

import android.content.Context;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidLazyEvaluator<T> {

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f52387a = null;

    /* renamed from: b, reason: collision with root package name */
    public final AndroidEvaluator f52388b;

    public interface AndroidEvaluator<T> {
        Object d(Context context);
    }

    public AndroidLazyEvaluator(AndroidEvaluator androidEvaluator) {
        this.f52388b = androidEvaluator;
    }

    public final Object a(Context context) {
        if (this.f52387a == null) {
            synchronized (this) {
                try {
                    if (this.f52387a == null) {
                        this.f52387a = this.f52388b.d(context);
                    }
                } finally {
                }
            }
        }
        return this.f52387a;
    }
}
