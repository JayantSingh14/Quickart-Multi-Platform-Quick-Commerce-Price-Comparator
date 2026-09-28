package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.Writer;

@RestrictTo
@Deprecated
/* loaded from: classes3.dex */
public class LogWriter extends Writer implements AutoCloseable {
    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        throw null;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        if (i3 > 0) {
            if (cArr[i2] != '\n') {
                throw null;
            }
            throw null;
        }
    }
}
