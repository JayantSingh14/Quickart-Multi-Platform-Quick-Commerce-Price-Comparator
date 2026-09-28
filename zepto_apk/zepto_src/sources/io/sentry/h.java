package io.sentry;

import io.sentry.DirectoryProcessor;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.transport.RateLimiter;
import io.sentry.util.HintUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Queue;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILogger f52741a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f52742b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DirectoryProcessor f52743c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ File f52744d;

    public /* synthetic */ h(ILogger iLogger, String str, DirectoryProcessor directoryProcessor, File file) {
        this.f52741a = iLogger;
        this.f52742b = str;
        this.f52743c = directoryProcessor;
        this.f52744d = file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget
    public final void c1() {
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        String str = this.f52742b;
        ILogger iLogger = this.f52741a;
        iLogger.c(sentryLevel, "Started processing cached files from %s", str);
        final DirectoryProcessor directoryProcessor = this.f52743c;
        File file = this.f52744d;
        ILogger iLogger2 = directoryProcessor.f51600b;
        try {
            SentryLevel sentryLevel2 = SentryLevel.DEBUG;
            iLogger2.c(sentryLevel2, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                iLogger2.c(SentryLevel.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
            } else if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: io.sentry.b
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file2, String str2) {
                            return directoryProcessor.a(str2);
                        }
                    });
                    int i2 = 0;
                    iLogger2.c(sentryLevel2, "Processing %d items from cache dir %s", Integer.valueOf(fileArrListFiles2 != null ? fileArrListFiles2.length : 0), file.getAbsolutePath());
                    int length = fileArrListFiles.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        File file2 = fileArrListFiles[i3];
                        if (file2.isFile()) {
                            String absolutePath = file2.getAbsolutePath();
                            Queue queue = directoryProcessor.f51602d;
                            if (!((SynchronizedCollection) queue).contains(absolutePath)) {
                                RateLimiter rateLimiterO = directoryProcessor.f51599a.o();
                                if (rateLimiterO != null && rateLimiterO.b(DataCategory.All)) {
                                    iLogger2.c(SentryLevel.INFO, "DirectoryProcessor, rate limiting active.", new Object[i2]);
                                    break;
                                } else {
                                    iLogger2.c(SentryLevel.DEBUG, "Processing file: %s", absolutePath);
                                    directoryProcessor.b(file2, HintUtils.a(new DirectoryProcessor.SendCachedEnvelopeHint(directoryProcessor.f51601c, directoryProcessor.f51600b, absolutePath, queue)));
                                    Thread.sleep(100L);
                                }
                            } else {
                                iLogger2.c(SentryLevel.DEBUG, "File '%s' has already been processed so it will not be processed again.", absolutePath);
                            }
                        } else {
                            iLogger2.c(SentryLevel.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                        }
                        i3++;
                        i2 = 0;
                    }
                } else {
                    iLogger2.c(SentryLevel.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                }
            } else {
                iLogger2.c(SentryLevel.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
            }
        } catch (Throwable th) {
            iLogger2.a(SentryLevel.ERROR, th, "Failed processing '%s'", file.getAbsolutePath());
        }
        iLogger.c(sentryLevel, "Finished processing cached files from %s", str);
    }
}
