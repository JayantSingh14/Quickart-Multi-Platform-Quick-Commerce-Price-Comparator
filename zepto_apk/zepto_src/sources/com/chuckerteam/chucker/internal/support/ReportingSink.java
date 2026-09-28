package com.chuckerteam.chucker.internal.support;

import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.Logger;
import com.chuckerteam.chucker.internal.support.ResponseProcessor;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata
/* loaded from: classes3.dex */
public final class ReportingSink implements Sink {

    /* renamed from: a, reason: collision with root package name */
    public final File f16789a;

    /* renamed from: b, reason: collision with root package name */
    public final Callback f16790b;

    /* renamed from: c, reason: collision with root package name */
    public long f16791c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16792d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16793e;

    /* renamed from: f, reason: collision with root package name */
    public final Sink f16794f;

    @Metadata
    public interface Callback {
    }

    public ReportingSink(File file, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f16789a = file;
        this.f16790b = callback;
        Sink sinkJ = null;
        if (file != null) {
            try {
                sinkJ = Okio.j(file);
            } catch (IOException e2) {
                a(new IOException("Failed to use file " + this.f16789a + " by Chucker", e2));
            }
        }
        this.f16794f = sinkJ;
    }

    public final void a(IOException exception) {
        if (this.f16792d) {
            return;
        }
        this.f16792d = true;
        b();
        Intrinsics.checkNotNullParameter(exception, "exception");
        Logger.Companion.f16778a.a("Failed to read response payload", exception);
    }

    public final void b() {
        try {
            Sink sink = this.f16794f;
            if (sink != null) {
                sink.close();
                Unit unit = Unit.f53572a;
            }
        } catch (IOException e2) {
            a(e2);
            Unit unit2 = Unit.f53572a;
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Buffer buffer;
        String str;
        if (this.f16793e) {
            return;
        }
        this.f16793e = true;
        b();
        long j2 = this.f16791c;
        ResponseProcessor.ResponseReportingSinkCallback responseReportingSinkCallback = (ResponseProcessor.ResponseReportingSinkCallback) this.f16790b;
        Response response = responseReportingSinkCallback.f16804a;
        HttpTransaction httpTransaction = responseReportingSinkCallback.f16805b;
        File file = this.f16789a;
        ResponseProcessor responseProcessor = responseReportingSinkCallback.f16806c;
        if (file != null) {
            try {
                Source sourceB = OkHttpUtilsKt.b(Okio.l(file), response.f56355f);
                try {
                    buffer = new Buffer();
                    buffer.g0(sourceB);
                    sourceB.close();
                } finally {
                }
            } catch (IOException e2) {
                Logger.Companion.f16778a.a("Response payload couldn't be processed", e2);
                buffer = null;
            }
            if (buffer != null) {
                responseProcessor.getClass();
                ResponseBody responseBody = response.f56356g;
                if (responseBody != null) {
                    MediaType mediaTypeL = responseBody.l();
                    if (mediaTypeL == null || (str = mediaTypeL.f56280a) == null || !StringsKt.n(str, "image", true)) {
                        long j3 = buffer.f56914b;
                        if (j3 != 0) {
                            String str2 = (String) SequencesKt.h(SequencesKt.n(CollectionsKt.n(responseProcessor.f16803e), new com.brentvatne.react.a(2, response, buffer.s0(j3))));
                            httpTransaction.setResponseBody(str2);
                            httpTransaction.setResponseBodyEncoded(str2 == null);
                        }
                    } else {
                        long j4 = buffer.f56914b;
                        if (j4 < 1000000) {
                            httpTransaction.setResponseImageData(buffer.r0(j4));
                        }
                    }
                }
            }
        }
        httpTransaction.setResponsePayloadSize(Long.valueOf(j2));
        responseProcessor.f16799a.a(httpTransaction);
        if (file != null) {
            file.delete();
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.f16792d) {
            return;
        }
        try {
            Sink sink = this.f16794f;
            if (sink != null) {
                sink.flush();
            }
        } catch (IOException e2) {
            a(e2);
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        Timeout timeout;
        Sink sink = this.f16794f;
        return (sink == null || (timeout = sink.timeout()) == null) ? Timeout.f57001d : timeout;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = this.f16791c;
        long j4 = j3 + j2;
        this.f16791c = j4;
        if (this.f16792d || j3 >= 250000) {
            return;
        }
        if (j4 > 250000) {
            j2 = 250000 - j3;
        }
        if (j2 == 0) {
            return;
        }
        try {
            Sink sink = this.f16794f;
            if (sink != null) {
                sink.write(source, j2);
            }
        } catch (IOException e2) {
            a(e2);
        }
    }
}
