package io.sentry;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.Reader;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class NoOpSerializer implements ISerializer {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpSerializer f51712a = new NoOpSerializer();

    @Override // io.sentry.ISerializer
    public final String a(ConcurrentHashMap concurrentHashMap) {
        return "";
    }

    @Override // io.sentry.ISerializer
    public final SentryEnvelope b(BufferedInputStream bufferedInputStream) {
        return null;
    }

    @Override // io.sentry.ISerializer
    public final void c(SentryEnvelope sentryEnvelope, OutputStream outputStream) {
    }

    @Override // io.sentry.ISerializer
    public final Object d(Reader reader, Class cls) {
        return null;
    }

    @Override // io.sentry.ISerializer
    public final void e(Object obj, BufferedWriter bufferedWriter) {
    }
}
