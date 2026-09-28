package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.KEYRecord;

@Metadata
/* loaded from: classes.dex */
public final class SegmentPool {

    /* renamed from: a, reason: collision with root package name */
    public static final Segment f56995a = new Segment(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f56996b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f56997c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f56996b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i2 = 0; i2 < iHighestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference();
        }
        f56997c = atomicReferenceArr;
    }

    public static final void a(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.f56993f != null || segment.f56994g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f56991d) {
            return;
        }
        AtomicReference atomicReference = f56997c[(int) (Thread.currentThread().getId() & (f56996b - 1))];
        Segment segment2 = f56995a;
        Segment segment3 = (Segment) atomicReference.getAndSet(segment2);
        if (segment3 == segment2) {
            return;
        }
        int i2 = segment3 != null ? segment3.f56990c : 0;
        if (i2 >= 65536) {
            atomicReference.set(segment3);
            return;
        }
        segment.f56993f = segment3;
        segment.f56989b = 0;
        segment.f56990c = i2 + KEYRecord.Flags.FLAG2;
        atomicReference.set(segment);
    }

    public static final Segment b() {
        AtomicReference atomicReference = f56997c[(int) (Thread.currentThread().getId() & (f56996b - 1))];
        Segment segment = f56995a;
        Segment segment2 = (Segment) atomicReference.getAndSet(segment);
        if (segment2 == segment) {
            return new Segment();
        }
        if (segment2 == null) {
            atomicReference.set(null);
            return new Segment();
        }
        atomicReference.set(segment2.f56993f);
        segment2.f56993f = null;
        segment2.f56990c = 0;
        return segment2;
    }
}
