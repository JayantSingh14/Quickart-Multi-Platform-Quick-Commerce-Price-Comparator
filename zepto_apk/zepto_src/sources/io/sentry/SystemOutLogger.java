package io.sentry;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class SystemOutLogger implements ILogger {
    @Override // io.sentry.ILogger
    public final void a(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        PrintStream printStream = System.out;
        String str2 = String.format(str, objArr);
        String string = th.toString();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        printStream.println(sentryLevel + ": " + str2 + " \n " + string + StringUtils.LF + stringWriter.toString());
    }

    @Override // io.sentry.ILogger
    public final void b(SentryLevel sentryLevel, String str, Throwable th) {
        if (th == null) {
            c(sentryLevel, str, new Object[0]);
            return;
        }
        PrintStream printStream = System.out;
        String str2 = String.format(str, th.toString());
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        printStream.println(sentryLevel + ": " + str2 + StringUtils.LF + stringWriter.toString());
    }

    @Override // io.sentry.ILogger
    public final void c(SentryLevel sentryLevel, String str, Object... objArr) {
        System.out.println(sentryLevel + ": " + String.format(str, objArr));
    }

    @Override // io.sentry.ILogger
    public final boolean d(SentryLevel sentryLevel) {
        return true;
    }
}
