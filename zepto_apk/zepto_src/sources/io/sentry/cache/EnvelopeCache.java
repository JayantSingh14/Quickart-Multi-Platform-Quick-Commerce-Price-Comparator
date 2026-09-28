package io.sentry.cache;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class EnvelopeCache extends CacheStrategy implements IEnvelopeCache {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f52676h = 0;

    /* renamed from: f, reason: collision with root package name */
    public final CountDownLatch f52677f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakHashMap f52678g;

    public EnvelopeCache(SentryOptions sentryOptions, String str, int i2) {
        super(sentryOptions, str, i2);
        this.f52678g = new WeakHashMap();
        this.f52677f = new CountDownLatch(1);
    }

    public final File[] f() {
        File file = this.f52673c;
        if (file.isDirectory() && file.canWrite() && file.canRead()) {
            File[] fileArrListFiles = file.listFiles(new com.google.firebase.crashlytics.internal.persistence.b(1));
            if (fileArrListFiles != null) {
                return fileArrListFiles;
            }
        } else {
            this.f52671a.getLogger().c(SentryLevel.ERROR, "The directory for caching files is inaccessible.: %s", file.getAbsolutePath());
        }
        return new File[0];
    }

    public final synchronized File g(SentryEnvelope sentryEnvelope) {
        String str;
        try {
            if (this.f52678g.containsKey(sentryEnvelope)) {
                str = (String) this.f52678g.get(sentryEnvelope);
            } else {
                String str2 = UUID.randomUUID() + ".envelope";
                this.f52678g.put(sentryEnvelope, str2);
                str = str2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new File(this.f52673c.getAbsolutePath(), str);
    }

    public final boolean i() {
        SentryOptions sentryOptions = this.f52671a;
        try {
            return this.f52677f.await(sentryOptions.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<SentryEnvelope> iterator() throws IOException {
        SentryOptions sentryOptions = this.f52671a;
        File[] fileArrF = f();
        ArrayList arrayList = new ArrayList(fileArrF.length);
        for (File file : fileArrF) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(((ISerializer) this.f52672b.a()).b(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e2) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Error while reading cached envelope from file " + file.getAbsolutePath(), e2);
            }
        }
        return arrayList.iterator();
    }

    public final void j(File file, Session session) {
        boolean zExists = file.exists();
        SentryOptions sentryOptions = this.f52671a;
        UUID uuid = session.f51898e;
        if (zExists) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", uuid);
            if (!file.delete()) {
                sentryOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, CacheStrategy.f52670e));
                try {
                    ((ISerializer) this.f52672b.a()).e(session, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Error writing Session to offline storage: %s", uuid);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[PHI: r3 r4 r8
      0x0051: PHI (r3v28 java.io.File[]) = 
      (r3v27 java.io.File[])
      (r3v27 java.io.File[])
      (r3v27 java.io.File[])
      (r3v27 java.io.File[])
      (r3v27 java.io.File[])
      (r3v27 java.io.File[])
      (r3v31 java.io.File[])
     binds: [B:10:0x0043, B:12:0x004f, B:25:0x008a, B:33:0x009e, B:36:0x00a3, B:38:0x00a9, B:307:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r4v33 int) = (r4v32 int), (r4v32 int), (r4v32 int), (r4v32 int), (r4v32 int), (r4v32 int), (r4v37 int) binds: [B:10:0x0043, B:12:0x004f, B:25:0x008a, B:33:0x009e, B:36:0x00a3, B:38:0x00a9, B:307:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r8v14 io.sentry.SentryOptions) = 
      (r8v13 io.sentry.SentryOptions)
      (r8v13 io.sentry.SentryOptions)
      (r8v13 io.sentry.SentryOptions)
      (r8v13 io.sentry.SentryOptions)
      (r8v13 io.sentry.SentryOptions)
      (r8v13 io.sentry.SentryOptions)
      (r8v17 io.sentry.SentryOptions)
     binds: [B:10:0x0043, B:12:0x004f, B:25:0x008a, B:33:0x009e, B:36:0x00a3, B:38:0x00a9, B:307:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0205 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v0(io.sentry.SentryEnvelope r23, io.sentry.Hint r24) {
        /*
            Method dump skipped, instructions count: 1439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.v0(io.sentry.SentryEnvelope, io.sentry.Hint):void");
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public final void x(SentryEnvelope sentryEnvelope) {
        Objects.b(sentryEnvelope, "Envelope is required.");
        File fileG = g(sentryEnvelope);
        boolean zExists = fileG.exists();
        SentryOptions sentryOptions = this.f52671a;
        if (!zExists) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Envelope was not cached: %s", fileG.getAbsolutePath());
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.DEBUG, "Discarding envelope from cache: %s", fileG.getAbsolutePath());
        if (fileG.delete()) {
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete envelope: %s", fileG.getAbsolutePath());
    }
}
