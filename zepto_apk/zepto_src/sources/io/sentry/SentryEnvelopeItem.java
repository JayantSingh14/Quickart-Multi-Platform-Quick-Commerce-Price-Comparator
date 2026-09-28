package io.sentry;

import io.sentry.SentryEnvelopeItem;
import io.sentry.clientreport.ClientReport;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryEnvelopeItem {

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f51819d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final SentryEnvelopeItemHeader f51820a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable f51821b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f51822c;

    public static class CachedItem {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f51823a;

        /* renamed from: b, reason: collision with root package name */
        public final Callable f51824b;

        public CachedItem(Callable callable) {
            this.f51824b = callable;
        }

        public final byte[] a() {
            Callable callable;
            if (this.f51823a == null && (callable = this.f51824b) != null) {
                this.f51823a = (byte[]) callable.call();
            }
            byte[] bArr = this.f51823a;
            return bArr != null ? bArr : new byte[0];
        }
    }

    public SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, byte[] bArr) {
        this.f51820a = sentryEnvelopeItemHeader;
        this.f51822c = bArr;
        this.f51821b = null;
    }

    public static SentryEnvelopeItem a(ISerializer iSerializer, ClientReport clientReport) {
        Objects.b(iSerializer, "ISerializer is required.");
        CachedItem cachedItem = new CachedItem(new androidx.media3.datasource.b(9, iSerializer, clientReport));
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(clientReport), new m(cachedItem, 6), "application/json", (String) null, (String) null), new m(cachedItem, 8));
    }

    public static SentryEnvelopeItem b(final ISerializer iSerializer, final Session session) {
        Objects.b(iSerializer, "ISerializer is required.");
        Objects.b(session, "Session is required.");
        final CachedItem cachedItem = new CachedItem(new Callable() { // from class: io.sentry.n
            @Override // java.util.concurrent.Callable
            public final Object call() throws IOException {
                ISerializer iSerializer2 = iSerializer;
                Session session2 = session;
                Charset charset = SentryEnvelopeItem.f51819d;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, SentryEnvelopeItem.f51819d));
                    try {
                        iSerializer2.e(session2, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        });
        final int i2 = 0;
        final int i3 = 1;
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Session, new Callable() { // from class: io.sentry.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SentryEnvelopeItem.CachedItem cachedItem2 = cachedItem;
                switch (i2) {
                    case 0:
                        Charset charset = SentryEnvelopeItem.f51819d;
                        return Integer.valueOf(cachedItem2.a().length);
                    default:
                        Charset charset2 = SentryEnvelopeItem.f51819d;
                        return cachedItem2.a();
                }
            }
        }, "application/json", (String) null, (String) null), new Callable() { // from class: io.sentry.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SentryEnvelopeItem.CachedItem cachedItem2 = cachedItem;
                switch (i3) {
                    case 0:
                        Charset charset = SentryEnvelopeItem.f51819d;
                        return Integer.valueOf(cachedItem2.a().length);
                    default:
                        Charset charset2 = SentryEnvelopeItem.f51819d;
                        return cachedItem2.a();
                }
            }
        });
    }

    public static byte[] g(LinkedHashMap linkedHashMap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) (linkedHashMap.size() | 128));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                byte[] bytes = ((String) entry.getKey()).getBytes(f51819d);
                int length = bytes.length;
                byteArrayOutputStream.write(-39);
                byteArrayOutputStream.write((byte) length);
                byteArrayOutputStream.write(bytes);
                byte[] bArr = (byte[]) entry.getValue();
                int length2 = bArr.length;
                byteArrayOutputStream.write(-58);
                byteArrayOutputStream.write(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(length2).array());
                byteArrayOutputStream.write(bArr);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final ClientReport c(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.f51820a;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.f51827c != SentryItemType.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d()), f51819d));
        try {
            ClientReport clientReport = (ClientReport) iSerializer.d(bufferedReader, ClientReport.class);
            bufferedReader.close();
            return clientReport;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final byte[] d() {
        Callable callable;
        if (this.f51822c == null && (callable = this.f51821b) != null) {
            this.f51822c = (byte[]) callable.call();
        }
        return this.f51822c;
    }

    public final SentryEvent e(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.f51820a;
        if (sentryEnvelopeItemHeader == null) {
            return null;
        }
        if (sentryEnvelopeItemHeader.f51827c != SentryItemType.Event) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d()), f51819d));
        try {
            SentryEvent sentryEvent = (SentryEvent) iSerializer.d(bufferedReader, SentryEvent.class);
            bufferedReader.close();
            return sentryEvent;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final SentryTransaction f(ISerializer iSerializer) throws IOException {
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = this.f51820a;
        if (sentryEnvelopeItemHeader == null || sentryEnvelopeItemHeader.f51827c != SentryItemType.Transaction) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d()), f51819d));
        try {
            SentryTransaction sentryTransaction = (SentryTransaction) iSerializer.d(bufferedReader, SentryTransaction.class);
            bufferedReader.close();
            return sentryTransaction;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, Callable callable) {
        this.f51820a = sentryEnvelopeItemHeader;
        this.f51821b = callable;
        this.f51822c = null;
    }
}
