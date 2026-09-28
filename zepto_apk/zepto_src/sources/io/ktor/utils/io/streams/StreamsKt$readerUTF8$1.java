package io.ktor.utils.io.streams;

import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.KEYRecord;

@Metadata
/* loaded from: classes3.dex */
public final class StreamsKt$readerUTF8$1 extends Reader implements AutoCloseable {
    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // java.io.Reader
    public final int read(char[] cbuf, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        throw null;
    }

    @Override // java.io.Reader
    public final long skip(long j2) {
        char[] cbuf = StreamsKt.f51379a;
        if (0 >= j2) {
            return 0L;
        }
        Math.min(KEYRecord.Flags.FLAG2, j2);
        Intrinsics.checkNotNullParameter(cbuf, "cbuf");
        throw null;
    }
}
