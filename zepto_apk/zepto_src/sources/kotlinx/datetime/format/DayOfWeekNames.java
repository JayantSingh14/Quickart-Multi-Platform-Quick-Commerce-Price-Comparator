package kotlinx.datetime.format;

import android.support.v4.media.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DayOfWeekNames {

    /* renamed from: b, reason: collision with root package name */
    public static final DayOfWeekNames f55413b;

    /* renamed from: a, reason: collision with root package name */
    public final List f55414a;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DayOfWeekNames$toString$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, String> {

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass1 f55415b = new AnonymousClass1(1, String.class, "toString", "toString()Ljava/lang/String;", 0);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            String p0 = (String) obj;
            Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.toString();
        }
    }

    static {
        new DayOfWeekNames(CollectionsKt.I("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        f55413b = new DayOfWeekNames(CollectionsKt.I("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
    }

    public DayOfWeekNames(List names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.f55414a = names;
        if (names.size() != 7) {
            throw new IllegalArgumentException("Day of week names must contain exactly 7 elements");
        }
        Iterator<Integer> it = CollectionsKt.A(names).iterator();
        while (((IntProgressionIterator) it).f53843c) {
            int iA = ((IntIterator) it).a();
            if (((CharSequence) this.f55414a.get(iA)).length() <= 0) {
                throw new IllegalArgumentException("A day-of-week name can not be empty");
            }
            for (int i2 = 0; i2 < iA; i2++) {
                if (Intrinsics.b(this.f55414a.get(iA), this.f55414a.get(i2))) {
                    throw new IllegalArgumentException(b.r(new StringBuilder("Day-of-week names must be unique, but '"), (String) this.f55414a.get(iA), "' was repeated").toString());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DayOfWeekNames) {
            return Intrinsics.b(this.f55414a, ((DayOfWeekNames) obj).f55414a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55414a.hashCode();
    }

    public final String toString() {
        return CollectionsKt.E(this.f55414a, ", ", "DayOfWeekNames(", ")", AnonymousClass1.f55415b, 24);
    }
}
