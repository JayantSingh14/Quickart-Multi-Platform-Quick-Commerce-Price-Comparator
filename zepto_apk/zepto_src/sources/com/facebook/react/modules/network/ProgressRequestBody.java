package com.facebook.react.modules.network;

import com.facebook.react.modules.network.NetworkingModule;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.RealBufferedSink;

/* loaded from: classes.dex */
class ProgressRequestBody extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public final RequestBody f19145a;

    /* renamed from: b, reason: collision with root package name */
    public final ProgressListener f19146b;

    /* renamed from: c, reason: collision with root package name */
    public long f19147c = 0;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.f19145a = requestBody;
        this.f19146b = progressListener;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        if (this.f19147c == 0) {
            this.f19147c = this.f19145a.contentLength();
        }
        return this.f19147c;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f19145a.contentType();
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) {
        RealBufferedSink realBufferedSinkC = Okio.c(Okio.i(new CountingOutputStream(bufferedSink.P1()) { // from class: com.facebook.react.modules.network.ProgressRequestBody.1
            {
                this.f19128a = 0L;
            }

            @Override // com.facebook.react.modules.network.CountingOutputStream, java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i2, int i3) throws IOException {
                super.write(bArr, i2, i3);
                long j2 = this.f19128a;
                ProgressRequestBody progressRequestBody = ProgressRequestBody.this;
                long jContentLength = progressRequestBody.contentLength();
                ((NetworkingModule.AnonymousClass3) progressRequestBody.f19146b).a(j2, jContentLength, j2 == jContentLength);
            }

            @Override // com.facebook.react.modules.network.CountingOutputStream, java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i2) throws IOException {
                super.write(i2);
                long j2 = this.f19128a;
                ProgressRequestBody progressRequestBody = ProgressRequestBody.this;
                long jContentLength = progressRequestBody.contentLength();
                ((NetworkingModule.AnonymousClass3) progressRequestBody.f19146b).a(j2, jContentLength, j2 == jContentLength);
            }
        }));
        contentLength();
        this.f19145a.writeTo(realBufferedSinkC);
        realBufferedSinkC.flush();
    }
}
