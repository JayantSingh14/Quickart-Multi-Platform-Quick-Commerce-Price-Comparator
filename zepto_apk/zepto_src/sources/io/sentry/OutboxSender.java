package io.sentry;

import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.util.HintUtils;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import io.sentry.util.SampleRateUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class OutboxSender extends DirectoryProcessor implements IEnvelopeSender {

    /* renamed from: i, reason: collision with root package name */
    public static final Charset f51718i = Charset.forName("UTF-8");

    /* renamed from: e, reason: collision with root package name */
    public final HubAdapter f51719e;

    /* renamed from: f, reason: collision with root package name */
    public final IEnvelopeReader f51720f;

    /* renamed from: g, reason: collision with root package name */
    public final ISerializer f51721g;

    /* renamed from: h, reason: collision with root package name */
    public final ILogger f51722h;

    public OutboxSender(HubAdapter hubAdapter, IEnvelopeReader iEnvelopeReader, ISerializer iSerializer, ILogger iLogger, long j2, int i2) {
        super(hubAdapter, iLogger, j2, i2);
        Objects.b(hubAdapter, "Hub is required.");
        this.f51719e = hubAdapter;
        Objects.b(iEnvelopeReader, "Envelope reader is required.");
        this.f51720f = iEnvelopeReader;
        Objects.b(iSerializer, "Serializer is required.");
        this.f51721g = iSerializer;
        Objects.b(iLogger, "Logger is required.");
        this.f51722h = iLogger;
    }

    public static /* synthetic */ void c(OutboxSender outboxSender, File file, Retryable retryable) {
        ILogger iLogger = outboxSender.f51722h;
        if (retryable.a()) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            iLogger.c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        } catch (RuntimeException e2) {
            iLogger.a(SentryLevel.ERROR, e2, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    @Override // io.sentry.DirectoryProcessor
    public final boolean a(String str) {
        return (str == null || str.startsWith("session") || str.startsWith("previous_session") || str.startsWith("startup_crash")) ? false : true;
    }

    @Override // io.sentry.DirectoryProcessor
    public final void b(File file, Hint hint) {
        boolean zA = a(file.getName());
        ILogger iLogger = this.f51722h;
        try {
            if (!zA) {
                iLogger.c(SentryLevel.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
                return;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    SentryEnvelope sentryEnvelopeA = this.f51720f.a(bufferedInputStream);
                    if (sentryEnvelopeA == null) {
                        iLogger.c(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                    } else {
                        e(sentryEnvelopeA, hint);
                        iLogger.c(SentryLevel.DEBUG, "File '%s' is done.", file.getAbsolutePath());
                    }
                    bufferedInputStream.close();
                    Object objB = HintUtils.b(hint);
                    if (!Retryable.class.isInstance(HintUtils.b(hint)) || objB == null) {
                        LogUtils.a(Retryable.class, objB, iLogger);
                    } else {
                        c(this, file, (Retryable) objB);
                    }
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e2) {
                iLogger.b(SentryLevel.ERROR, "Error processing envelope.", e2);
                Object objB2 = HintUtils.b(hint);
                if (!Retryable.class.isInstance(HintUtils.b(hint)) || objB2 == null) {
                    LogUtils.a(Retryable.class, objB2, iLogger);
                } else {
                    c(this, file, (Retryable) objB2);
                }
            }
        } catch (Throwable th3) {
            Object objB3 = HintUtils.b(hint);
            if (!Retryable.class.isInstance(HintUtils.b(hint)) || objB3 == null) {
                LogUtils.a(Retryable.class, objB3, iLogger);
            } else {
                c(this, file, (Retryable) objB3);
            }
            throw th3;
        }
    }

    public final TracesSamplingDecision d(TraceContext traceContext) {
        String strA;
        ILogger iLogger = this.f51722h;
        if (traceContext != null && (strA = traceContext.a()) != null) {
            try {
                Double dValueOf = Double.valueOf(Double.parseDouble(strA));
                if (SampleRateUtils.a(false, dValueOf)) {
                    return new TracesSamplingDecision(dValueOf, Boolean.TRUE);
                }
                iLogger.c(SentryLevel.ERROR, "Invalid sample rate parsed from TraceContext: %s", strA);
            } catch (Exception unused) {
                iLogger.c(SentryLevel.ERROR, "Unable to parse sample rate from TraceContext: %s", strA);
            }
        }
        return new TracesSamplingDecision();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0259 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0260 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(io.sentry.SentryEnvelope r21, io.sentry.Hint r22) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender.e(io.sentry.SentryEnvelope, io.sentry.Hint):void");
    }

    public final boolean f(Hint hint) {
        Object objB = HintUtils.b(hint);
        if (objB instanceof Flushable) {
            return ((Flushable) objB).g();
        }
        LogUtils.a(Flushable.class, objB, this.f51722h);
        return true;
    }
}
