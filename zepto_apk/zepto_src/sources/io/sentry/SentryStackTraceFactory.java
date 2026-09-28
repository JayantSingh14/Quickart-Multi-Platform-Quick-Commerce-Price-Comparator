package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryStackTraceFactory {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51872a;

    public SentryStackTraceFactory(SentryOptions sentryOptions) {
        this.f51872a = sentryOptions;
    }

    public final ArrayList a(StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (z || !className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    SentryStackFrame sentryStackFrame = new SentryStackFrame();
                    sentryStackFrame.f52936h = b(className);
                    sentryStackFrame.f52931c = className;
                    sentryStackFrame.f52930b = stackTraceElement.getMethodName();
                    sentryStackFrame.f52929a = stackTraceElement.getFileName();
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sentryStackFrame.f52932d = Integer.valueOf(stackTraceElement.getLineNumber());
                    }
                    sentryStackFrame.f52938j = Boolean.valueOf(stackTraceElement.isNativeMethod());
                    arrayList.add(sentryStackFrame);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public final Boolean b(String str) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        SentryOptions sentryOptions = this.f51872a;
        Iterator<String> it = sentryOptions.getInAppIncludes().iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return Boolean.TRUE;
            }
        }
        Iterator<String> it2 = sentryOptions.getInAppExcludes().iterator();
        while (it2.hasNext()) {
            if (str.startsWith(it2.next())) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
