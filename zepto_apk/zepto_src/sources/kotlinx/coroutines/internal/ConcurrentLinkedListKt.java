package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ConcurrentLinkedListKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Symbol f55062a = new Symbol("CLOSED");

    public static final Object a(Segment segment, long j2, Function2 function2) {
        while (true) {
            if (segment.f55105c >= j2 && !segment.d()) {
                return segment;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ConcurrentLinkedListNode.f55063a;
            Object obj = atomicReferenceFieldUpdater.get(segment);
            Symbol symbol = f55062a;
            if (obj == symbol) {
                return symbol;
            }
            Segment segment2 = (Segment) ((ConcurrentLinkedListNode) obj);
            if (segment2 == null) {
                segment2 = (Segment) function2.invoke(Long.valueOf(segment.f55105c + 1), segment);
                if (com.google.android.gms.internal.pal.a.v(atomicReferenceFieldUpdater, segment, segment2)) {
                    if (segment.d()) {
                        segment.e();
                    }
                }
            }
            segment = segment2;
        }
    }
}
