package io.sentry.android.core;

import io.sentry.SentryDate;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class AndroidDateUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final SentryAndroidDateProvider f52027a = new SentryAndroidDateProvider();

    public static SentryDate a() {
        return f52027a.now();
    }
}
