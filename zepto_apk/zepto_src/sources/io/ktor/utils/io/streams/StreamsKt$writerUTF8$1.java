package io.ktor.utils.io.streams;

import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class StreamsKt$writerUTF8$1 extends Writer implements AutoCloseable {
    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(char[] cbuf, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        throw null;
    }
}
