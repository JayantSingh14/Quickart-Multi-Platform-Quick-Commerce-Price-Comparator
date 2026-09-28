package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HashingSource extends ForwardingSource implements Source {

    @Metadata
    public static final class Companion {
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer sink, long j2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = super.read(sink, j2);
        if (j3 != -1) {
            long j4 = sink.f56914b;
            long j5 = j4 - j3;
            Segment segment = sink.f56913a;
            Intrinsics.c(segment);
            while (j4 > j5) {
                segment = segment.f56994g;
                Intrinsics.c(segment);
                j4 -= segment.f56990c - segment.f56989b;
            }
            if (j4 < sink.f56914b) {
                Intrinsics.c(null);
                throw null;
            }
        }
        return j3;
    }
}
