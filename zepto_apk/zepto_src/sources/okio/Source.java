package okio;

import java.io.Closeable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface Source extends Closeable, AutoCloseable {
    long read(Buffer buffer, long j2);

    Timeout timeout();
}
