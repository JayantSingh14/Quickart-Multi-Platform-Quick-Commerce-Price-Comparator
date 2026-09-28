package io.sentry.android.replay.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MainLooperHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f52630a;

    public MainLooperHandler() {
        this(0);
    }

    public MainLooperHandler(int i2) {
        Looper looper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getMainLooper()");
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f52630a = new Handler(looper);
    }
}
