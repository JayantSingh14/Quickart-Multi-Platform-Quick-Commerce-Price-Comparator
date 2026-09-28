package io.sentry.android.core.internal.util;

import android.os.Looper;
import io.sentry.util.thread.IMainThreadChecker;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidMainThreadChecker implements IMainThreadChecker {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidMainThreadChecker f52307a = new AndroidMainThreadChecker();

    @Override // io.sentry.util.thread.IMainThreadChecker
    public final boolean a() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }
}
