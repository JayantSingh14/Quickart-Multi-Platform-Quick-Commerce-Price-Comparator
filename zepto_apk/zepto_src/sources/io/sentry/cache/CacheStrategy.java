package io.sentry.cache;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class CacheStrategy {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f52670e = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52671a;

    /* renamed from: b, reason: collision with root package name */
    public final LazyEvaluator f52672b = new LazyEvaluator(new a(this, 0));

    /* renamed from: c, reason: collision with root package name */
    public final File f52673c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52674d;

    public CacheStrategy(SentryOptions sentryOptions, String str, int i2) {
        Objects.b(sentryOptions, "SentryOptions is required.");
        this.f52671a = sentryOptions;
        this.f52673c = new File(str);
        this.f52674d = i2;
    }

    public final SentryEnvelope b(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                SentryEnvelope sentryEnvelopeB = ((ISerializer) this.f52672b.a()).b(bufferedInputStream);
                bufferedInputStream.close();
                return sentryEnvelopeB;
            } finally {
            }
        } catch (IOException e2) {
            this.f52671a.getLogger().b(SentryLevel.ERROR, "Failed to deserialize the envelope.", e2);
            return null;
        }
    }

    public final Session d(SentryEnvelopeItem sentryEnvelopeItem) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.d()), f52670e));
            try {
                Session session = (Session) ((ISerializer) this.f52672b.a()).d(bufferedReader, Session.class);
                bufferedReader.close();
                return session;
            } finally {
            }
        } catch (Throwable th) {
            this.f52671a.getLogger().b(SentryLevel.ERROR, "Failed to deserialize the session.", th);
            return null;
        }
    }
}
