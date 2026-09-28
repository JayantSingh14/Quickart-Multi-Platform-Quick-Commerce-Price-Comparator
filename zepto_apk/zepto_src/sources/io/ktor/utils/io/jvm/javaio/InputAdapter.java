package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class InputAdapter extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final ByteReadChannel f51312a;

    /* renamed from: b, reason: collision with root package name */
    public final JobImpl f51313b;

    /* renamed from: c, reason: collision with root package name */
    public final InputAdapter$loop$1 f51314c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f51315d;

    public InputAdapter(ByteReadChannel channel, Job job) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f51312a = channel;
        this.f51313b = new JobImpl(job);
        this.f51314c = new InputAdapter$loop$1(job, this);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f51312a.g();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            super.close();
            ByteReadChannel byteReadChannel = this.f51312a;
            Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
            byteReadChannel.l(null);
            if (!this.f51313b.W()) {
                this.f51313b.e(null);
            }
            InputAdapter$loop$1 inputAdapter$loop$1 = this.f51314c;
            DisposableHandle disposableHandle = inputAdapter$loop$1.f51299c;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
            Result.Companion companion = Result.f53538b;
            inputAdapter$loop$1.f51298b.resumeWith(ResultKt.a(new CancellationException("Stream closed")));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        try {
            byte[] bArr = this.f51315d;
            if (bArr == null) {
                bArr = new byte[1];
                this.f51315d = bArr;
            }
            int iC = this.f51314c.c(0, bArr, 1);
            if (iC == -1) {
                return -1;
            }
            if (iC == 1) {
                return bArr[0] & 255;
            }
            throw new IllegalStateException(("Expected a single byte or EOF. Got " + iC + " bytes.").toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i3) {
        InputAdapter$loop$1 inputAdapter$loop$1;
        inputAdapter$loop$1 = this.f51314c;
        Intrinsics.c(bArr);
        return inputAdapter$loop$1.c(i2, bArr, i3);
    }
}
