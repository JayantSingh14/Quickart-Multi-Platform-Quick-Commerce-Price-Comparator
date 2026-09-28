package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ComparisonPredicate<T, E> implements Predicate<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f55532a;

    /* renamed from: b, reason: collision with root package name */
    public final OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1 f55533b;

    public ComparisonPredicate(Object obj, OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1 getter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        this.f55532a = obj;
        this.f55533b = getter;
    }

    @Override // kotlinx.datetime.internal.format.Predicate
    public final boolean test(Object obj) {
        return Intrinsics.b(this.f55533b.invoke(obj), this.f55532a);
    }
}
