package com.chuckerteam.chucker.internal.support;

import com.chuckerteam.chucker.internal.support.Logger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Okio;

@Metadata
/* loaded from: classes3.dex */
public final class DepletingSource extends ForwardingSource {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16754a;

    @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f16754a) {
            try {
                Okio.d(delegate()).F1(Okio.b());
            } catch (IOException e2) {
                Logger.Companion.f16778a.a("An error occurred while depleting the source", e2);
            }
        }
        this.f16754a = false;
        super.close();
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer sink, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            long j3 = super.read(sink, j2);
            if (j3 != -1) {
                return j3;
            }
            this.f16754a = false;
            return j3;
        } catch (IOException e2) {
            this.f16754a = false;
            throw e2;
        }
    }
}
