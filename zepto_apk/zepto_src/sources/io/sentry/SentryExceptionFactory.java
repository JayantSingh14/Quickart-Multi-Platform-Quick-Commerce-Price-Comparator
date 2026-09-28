package io.sentry;

import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackTrace;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryExceptionFactory {

    /* renamed from: a, reason: collision with root package name */
    public final SentryStackTraceFactory f51832a;

    public SentryExceptionFactory(SentryStackTraceFactory sentryStackTraceFactory) {
        this.f51832a = sentryStackTraceFactory;
    }

    public static SentryException a(Throwable th, Mechanism mechanism, Long l2, List list, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + CLConstants.DOT_SALT_DELIMETER, "");
        }
        String name2 = r0 != null ? r0.getName() : null;
        if (list != null && !list.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(list);
            if (z) {
                sentryStackTrace.f52944c = Boolean.TRUE;
            }
            sentryException.f52904e = sentryStackTrace;
        }
        sentryException.f52903d = l2;
        sentryException.f52900a = name;
        sentryException.f52905f = mechanism;
        sentryException.f52902c = name2;
        sentryException.f52901b = message;
        return sentryException;
    }
}
