package io.sentry;

import io.sentry.hints.Retryable;
import io.sentry.util.Objects;
import java.io.File;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class EnvelopeSender extends DirectoryProcessor implements IEnvelopeSender {

    /* renamed from: e, reason: collision with root package name */
    public final HubAdapter f51617e;

    /* renamed from: f, reason: collision with root package name */
    public final ISerializer f51618f;

    /* renamed from: g, reason: collision with root package name */
    public final ILogger f51619g;

    public EnvelopeSender(HubAdapter hubAdapter, ISerializer iSerializer, ILogger iLogger, long j2, int i2) {
        super(hubAdapter, iLogger, j2, i2);
        Objects.b(hubAdapter, "Hub is required.");
        this.f51617e = hubAdapter;
        Objects.b(iSerializer, "Serializer is required.");
        this.f51618f = iSerializer;
        Objects.b(iLogger, "Logger is required.");
        this.f51619g = iLogger;
    }

    public static void c(EnvelopeSender envelopeSender, File file, Retryable retryable) {
        envelopeSender.getClass();
        boolean zA = retryable.a();
        ILogger iLogger = envelopeSender.f51619g;
        if (zA) {
            iLogger.c(SentryLevel.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.delete()) {
                iLogger.c(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), "after trying to capture it");
            }
        } catch (Throwable th) {
            iLogger.a(SentryLevel.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), "after trying to capture it");
        }
        iLogger.c(SentryLevel.DEBUG, "Deleted file %s.", file.getAbsolutePath());
    }

    @Override // io.sentry.DirectoryProcessor
    public final boolean a(String str) {
        return str.endsWith(".envelope");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
    
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0115, code lost:
    
        c(r7, r8, (io.sentry.hints.Retryable) r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013e, code lost:
    
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015e, code lost:
    
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0161, code lost:
    
        return;
     */
    @Override // io.sentry.DirectoryProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.io.File r8, io.sentry.Hint r9) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.EnvelopeSender.b(java.io.File, io.sentry.Hint):void");
    }
}
