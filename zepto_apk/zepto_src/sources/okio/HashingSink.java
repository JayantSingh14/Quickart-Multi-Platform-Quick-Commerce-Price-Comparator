package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HashingSink extends ForwardingSink implements Sink {

    @Metadata
    public static final class Companion {
    }

    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.f56914b, 0L, j2);
        Intrinsics.c(source.f56913a);
        if (0 >= j2) {
            super.write(source, j2);
        } else {
            Math.min(j2, r9.f56990c - r9.f56989b);
            Intrinsics.c(null);
            throw null;
        }
    }
}
