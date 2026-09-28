package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ClosedRange<T extends Comparable<? super T>> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean a(ClosedRange closedRange) {
            return closedRange.b().compareTo(closedRange.d()) > 0;
        }
    }

    Comparable b();

    Comparable d();
}
