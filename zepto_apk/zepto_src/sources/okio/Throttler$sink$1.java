package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Throttler$sink$1 extends ForwardingSink {
    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (j2 > 0) {
            throw null;
        }
    }
}
