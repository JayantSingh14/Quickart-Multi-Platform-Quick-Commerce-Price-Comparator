package io.ktor.utils.io.streams;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class StreamsKt$outputStream$1 extends OutputStream implements AutoCloseable {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        throw null;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(b2, "b");
        io.ktor.utils.io.core.OutputKt.b(null, b2, i2, i3);
        throw null;
    }
}
