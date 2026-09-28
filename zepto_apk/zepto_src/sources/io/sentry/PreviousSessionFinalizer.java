package io.sentry;

import io.sentry.Session;
import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.IEnvelopeCache;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;

/* loaded from: classes.dex */
final class PreviousSessionFinalizer implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f51725b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51726a;

    public PreviousSessionFinalizer(SentryOptions sentryOptions) {
        this.f51726a = sentryOptions;
    }

    public final Date a(File file) throws IOException {
        SentryOptions sentryOptions = this.f51726a;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), f51725b));
            try {
                String line = bufferedReader.readLine();
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Crash marker file has %s timestamp.", line);
                Date dateC = DateUtils.c(line);
                bufferedReader.close();
                return dateC;
            } finally {
            }
        } catch (IOException e2) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error reading the crash marker file.", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, e3, "Error converting the crash timestamp.", new Object[0]);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Date dateA;
        SentryOptions sentryOptions = this.f51726a;
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, not finalizing the previous session.", new Object[0]);
            return;
        }
        if (!sentryOptions.isEnableAutoSessionTracking()) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Session tracking is disabled, bailing from previous session finalizer.", new Object[0]);
            return;
        }
        IEnvelopeCache envelopeDiskCache = sentryOptions.getEnvelopeDiskCache();
        if ((envelopeDiskCache instanceof EnvelopeCache) && !((EnvelopeCache) envelopeDiskCache).i()) {
            sentryOptions.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush previous session to its own file in session finalizer.", new Object[0]);
            return;
        }
        int i2 = EnvelopeCache.f52676h;
        File file = new File(cacheDirPath, "previous_session.json");
        ISerializer serializer = sentryOptions.getSerializer();
        if (file.exists()) {
            sentryOptions.getLogger().c(SentryLevel.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), f51725b));
                try {
                    Session session = (Session) serializer.d(bufferedReader, Session.class);
                    if (session == null) {
                        sentryOptions.getLogger().c(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                    } else {
                        File file2 = new File(sentryOptions.getCacheDirPath(), ".sentry-native/last_crash");
                        if (file2.exists()) {
                            sentryOptions.getLogger().c(SentryLevel.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                            dateA = a(file2);
                            if (!file2.delete()) {
                                sentryOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file2.getAbsolutePath());
                            }
                            session.c(Session.State.Crashed, null, true, null);
                        } else {
                            dateA = null;
                        }
                        if (session.n == null) {
                            session.b(dateA);
                        }
                        HubAdapter.f51658a.z(new SentryEnvelope(null, sentryOptions.getSdkVersion(), SentryEnvelopeItem.b(serializer, session)));
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Error processing previous session.", th);
            }
            if (file.delete()) {
                return;
            }
            sentryOptions.getLogger().c(SentryLevel.WARNING, "Failed to delete the previous session file.", new Object[0]);
        }
    }
}
