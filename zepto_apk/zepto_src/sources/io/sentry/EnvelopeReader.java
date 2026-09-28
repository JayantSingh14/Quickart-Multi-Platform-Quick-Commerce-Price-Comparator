package io.sentry;

import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class EnvelopeReader implements IEnvelopeReader {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f51615b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final ISerializer f51616a;

    public EnvelopeReader(ISerializer iSerializer) {
        this.f51616a = iSerializer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
    
        r13 = new io.sentry.SentryEnvelope(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
    
        throw new java.lang.IllegalArgumentException("Item header at index '" + r4.size() + "' is null or empty.");
     */
    @Override // io.sentry.IEnvelopeReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.SentryEnvelope a(java.io.InputStream r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.EnvelopeReader.a(java.io.InputStream):io.sentry.SentryEnvelope");
    }
}
