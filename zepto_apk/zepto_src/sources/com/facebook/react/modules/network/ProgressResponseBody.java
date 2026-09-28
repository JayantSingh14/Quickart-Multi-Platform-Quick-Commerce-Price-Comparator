package com.facebook.react.modules.network;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSource;

/* loaded from: classes.dex */
public class ProgressResponseBody extends ResponseBody {

    /* renamed from: b, reason: collision with root package name */
    public final ResponseBody f19149b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressListener f19150c;

    /* renamed from: d, reason: collision with root package name */
    public RealBufferedSource f19151d;

    /* renamed from: e, reason: collision with root package name */
    public long f19152e = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.f19149b = responseBody;
        this.f19150c = progressListener;
    }

    @Override // okhttp3.ResponseBody
    public final long e() {
        return this.f19149b.e();
    }

    @Override // okhttp3.ResponseBody
    public final MediaType l() {
        return this.f19149b.l();
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        if (this.f19151d == null) {
            this.f19151d = Okio.d(new ForwardingSource(this.f19149b.source()) { // from class: com.facebook.react.modules.network.ProgressResponseBody.1
                @Override // okio.ForwardingSource, okio.Source
                public final long read(Buffer buffer, long j2) {
                    long j3 = super.read(buffer, j2);
                    ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                    long j4 = progressResponseBody.f19152e + (j3 != -1 ? j3 : 0L);
                    progressResponseBody.f19152e = j4;
                    progressResponseBody.f19150c.a(j4, progressResponseBody.f19149b.e(), j3 == -1);
                    return j3;
                }
            });
        }
        return this.f19151d;
    }
}
