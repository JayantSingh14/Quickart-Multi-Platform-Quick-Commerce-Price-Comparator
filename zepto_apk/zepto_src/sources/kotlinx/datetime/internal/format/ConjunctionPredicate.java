package kotlinx.datetime.internal.format;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ConjunctionPredicate<T> implements Predicate<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f55535a;

    public ConjunctionPredicate(ArrayList predicates) {
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        this.f55535a = predicates;
    }

    @Override // kotlinx.datetime.internal.format.Predicate
    public final boolean test(Object obj) {
        ArrayList arrayList = this.f55535a;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((Predicate) it.next()).test(obj)) {
                return false;
            }
        }
        return true;
    }
}
