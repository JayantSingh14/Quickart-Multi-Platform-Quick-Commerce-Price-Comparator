package io.sentry.android.core;

import android.app.Activity;
import io.sentry.Attachment;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.util.Debouncer;
import io.sentry.android.core.internal.util.ScreenshotUtils;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ScreenshotEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final SentryAndroidOptions f52181a;

    /* renamed from: b, reason: collision with root package name */
    public final BuildInfoProvider f52182b;

    /* renamed from: c, reason: collision with root package name */
    public final Debouncer f52183c;

    public ScreenshotEventProcessor(SentryAndroidOptions sentryAndroidOptions, BuildInfoProvider buildInfoProvider) {
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52181a = sentryAndroidOptions;
        this.f52182b = buildInfoProvider;
        this.f52183c = new Debouncer(2000L, 3);
        if (sentryAndroidOptions.isAttachScreenshot()) {
            IntegrationUtils.a("Screenshot");
        }
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        if (sentryEvent.f()) {
            SentryAndroidOptions sentryAndroidOptions = this.f52181a;
            if (!sentryAndroidOptions.isAttachScreenshot()) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "attachScreenshot is disabled.", new Object[0]);
                return sentryEvent;
            }
            WeakReference weakReference = CurrentActivityHolder.f52112b.f52113a;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity != null && !HintUtils.d(hint)) {
                boolean zA = this.f52183c.a();
                SentryAndroidOptions.BeforeCaptureCallback beforeScreenshotCaptureCallback = sentryAndroidOptions.getBeforeScreenshotCaptureCallback();
                if (beforeScreenshotCaptureCallback == null ? !zA : beforeScreenshotCaptureCallback.d()) {
                    byte[] bArrA = ScreenshotUtils.a(activity, sentryAndroidOptions.getMainThreadChecker(), sentryAndroidOptions.getLogger(), this.f52182b);
                    if (bArrA != null) {
                        hint.f51638c = Attachment.a(bArrA);
                        hint.c(activity, "android:activity");
                    }
                }
            }
        }
        return sentryEvent;
    }

    @Override // io.sentry.EventProcessor
    public final SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }
}
