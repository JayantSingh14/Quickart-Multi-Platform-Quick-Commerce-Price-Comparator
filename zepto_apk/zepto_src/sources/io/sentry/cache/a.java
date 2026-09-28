package io.sentry.cache;

import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.cache.tape.ObjectQueue;
import io.sentry.cache.tape.QueueFile;
import io.sentry.util.LazyEvaluator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements LazyEvaluator.Evaluator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52684a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52685b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f52684a = i2;
        this.f52685b = obj;
    }

    @Override // io.sentry.util.LazyEvaluator.Evaluator
    public final Object a() throws IOException {
        QueueFile queueFile;
        switch (this.f52684a) {
            case 0:
                return ((CacheStrategy) this.f52685b).f52671a.getSerializer();
            default:
                final PersistingScopeObserver persistingScopeObserver = (PersistingScopeObserver) this.f52685b;
                SentryAndroidOptions sentryAndroidOptions = persistingScopeObserver.f52681a;
                File fileB = CacheUtils.b(sentryAndroidOptions, ".scope-cache");
                if (fileB == null) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
                    return ObjectQueue.s();
                }
                File file = new File(fileB, "breadcrumbs.json");
                try {
                    try {
                        QueueFile.Builder builder = new QueueFile.Builder(file);
                        builder.f52703a = sentryAndroidOptions.getMaxBreadcrumbs();
                        try {
                            queueFile = new QueueFile(file, QueueFile.b(file), builder.f52703a);
                        } finally {
                        }
                    } catch (IOException unused) {
                        file.delete();
                        QueueFile.Builder builder2 = new QueueFile.Builder(file);
                        builder2.f52703a = sentryAndroidOptions.getMaxBreadcrumbs();
                        try {
                            queueFile = new QueueFile(file, QueueFile.b(file), builder2.f52703a);
                        } finally {
                        }
                    }
                    return ObjectQueue.r(queueFile, new ObjectQueue.Converter<Breadcrumb>() { // from class: io.sentry.cache.PersistingScopeObserver.1
                        @Override // io.sentry.cache.tape.ObjectQueue.Converter
                        public final void a(Object obj, OutputStream outputStream) throws IOException {
                            Breadcrumb breadcrumb = (Breadcrumb) obj;
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, PersistingScopeObserver.f52680c));
                            try {
                                PersistingScopeObserver.this.f52681a.getSerializer().e(breadcrumb, bufferedWriter);
                                bufferedWriter.close();
                            } catch (Throwable th) {
                                try {
                                    bufferedWriter.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }

                        @Override // io.sentry.cache.tape.ObjectQueue.Converter
                        public final Breadcrumb b(byte[] bArr) {
                            PersistingScopeObserver persistingScopeObserver2 = PersistingScopeObserver.this;
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), PersistingScopeObserver.f52680c));
                                try {
                                    Breadcrumb breadcrumb = (Breadcrumb) persistingScopeObserver2.f52681a.getSerializer().d(bufferedReader, Breadcrumb.class);
                                    bufferedReader.close();
                                    return breadcrumb;
                                } finally {
                                }
                            } catch (Throwable th) {
                                persistingScopeObserver2.f52681a.getLogger().a(SentryLevel.ERROR, th, "Error reading entity from scope cache", new Object[0]);
                                return null;
                            }
                        }
                    });
                } catch (IOException e2) {
                    sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to create breadcrumbs queue", e2);
                    return ObjectQueue.s();
                }
        }
    }
}
