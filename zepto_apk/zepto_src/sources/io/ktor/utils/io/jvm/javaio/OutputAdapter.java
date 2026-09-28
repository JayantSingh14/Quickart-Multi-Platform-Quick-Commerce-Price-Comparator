package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import java.io.OutputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DisposableHandle;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class OutputAdapter extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final ByteWriteChannel f51321a;

    /* renamed from: b, reason: collision with root package name */
    public final OutputAdapter$loop$1 f51322b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f51323c;

    public OutputAdapter(ByteWriteChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f51321a = channel;
        this.f51322b = new OutputAdapter$loop$1(this);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.f51322b.d(BlockingKt.f51308b);
            OutputAdapter$loop$1 outputAdapter$loop$1 = this.f51322b;
            DisposableHandle disposableHandle = outputAdapter$loop$1.f51299c;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
            Result.Companion companion = Result.f53538b;
            outputAdapter$loop$1.f51298b.resumeWith(ResultKt.a(new CancellationException("Stream closed")));
        } finally {
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final synchronized void flush() {
        this.f51322b.d(BlockingKt.f51309c);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        try {
            byte[] bArr = this.f51323c;
            if (bArr == null) {
                bArr = new byte[1];
                this.f51323c = bArr;
            }
            bArr[0] = (byte) i2;
            this.f51322b.c(0, bArr, 1);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i3) {
        OutputAdapter$loop$1 outputAdapter$loop$1 = this.f51322b;
        Intrinsics.c(bArr);
        outputAdapter$loop$1.c(i2, bArr, i3);
    }
}
