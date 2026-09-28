package com.chuckerteam.chucker.internal.support;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata
/* loaded from: classes3.dex */
public final class TeeSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedSource f16832a;

    /* renamed from: b, reason: collision with root package name */
    public final ReportingSink f16833b;

    /* renamed from: c, reason: collision with root package name */
    public final Buffer f16834c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16835d;

    public TeeSource(BufferedSource upstream, ReportingSink sideStream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(sideStream, "sideStream");
        this.f16832a = upstream;
        this.f16833b = sideStream;
        this.f16834c = new Buffer();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            this.f16833b.close();
        } catch (IOException unused) {
            this.f16835d = true;
        }
        this.f16832a.close();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = this.f16832a.read(sink, j2);
        ReportingSink reportingSink = this.f16833b;
        if (j3 == -1) {
            try {
                reportingSink.close();
                return -1L;
            } catch (IOException unused) {
                this.f16835d = true;
                return -1L;
            }
        }
        if (!this.f16835d) {
            sink.e(this.f16834c, sink.f56914b - j3, j3);
            try {
                reportingSink.write(this.f16834c, j3);
                return j3;
            } catch (IOException unused2) {
                this.f16835d = true;
                try {
                    reportingSink.close();
                } catch (IOException unused3) {
                    this.f16835d = true;
                }
            }
        }
        return j3;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.f16832a.timeout();
    }
}
