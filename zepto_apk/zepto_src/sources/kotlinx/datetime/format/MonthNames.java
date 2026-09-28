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
public final class MonthNames {

    /* renamed from: b, reason: collision with root package name */
    public static final MonthNames f55467b;

    /* renamed from: a, reason: collision with root package name */
    public final List f55468a;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.MonthNames$toString$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, String> {

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass1 f55469b = new AnonymousClass1(1, String.class, "toString", "toString()Ljava/lang/String;", 0);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            String p0 = (String) obj;
            Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.toString();
        }
    }

    static {
        new MonthNames(CollectionsKt.I("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
        f55467b = new MonthNames(CollectionsKt.I("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
    }

    public MonthNames(List names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.f55468a = names;
        if (names.size() != 12) {
            throw new IllegalArgumentException("Month names must contain exactly 12 elements");
        }
        Iterator<Integer> it = CollectionsKt.A(names).iterator();
        while (((IntProgressionIterator) it).f53843c) {
            int iA = ((IntIterator) it).a();
            if (((CharSequence) this.f55468a.get(iA)).length() <= 0) {
                throw new IllegalArgumentException("A month name can not be empty");
            }
            for (int i2 = 0; i2 < iA; i2++) {
                if (Intrinsics.b(this.f55468a.get(iA), this.f55468a.get(i2))) {
                    throw new IllegalArgumentException(b.r(new StringBuilder("Month names must be unique, but '"), (String) this.f55468a.get(iA), "' was repeated").toString());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MonthNames) {
            return Intrinsics.b(this.f55468a, ((MonthNames) obj).f55468a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55468a.hashCode();
    }

    public final String toString() {
        return CollectionsKt.E(this.f55468a, ", ", "MonthNames(", ")", AnonymousClass1.f55469b, 24);
    }
}
