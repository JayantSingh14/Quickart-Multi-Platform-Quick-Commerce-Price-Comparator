package io.sentry;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.Reader;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public interface ISerializer {
    String a(ConcurrentHashMap concurrentHashMap);

    SentryEnvelope b(BufferedInputStream bufferedInputStream);

    void c(SentryEnvelope sentryEnvelope, OutputStream outputStream);

    Object d(Reader reader, Class cls);

    void e(Object obj, BufferedWriter bufferedWriter);
}
