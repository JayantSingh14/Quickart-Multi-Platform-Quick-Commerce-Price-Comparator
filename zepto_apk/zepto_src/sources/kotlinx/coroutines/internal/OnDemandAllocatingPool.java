package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OnDemandAllocatingPool<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55101a = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState$volatile");
    private volatile /* synthetic */ int controlState$volatile;

    public final String toString() {
        StringBuilder sb = new StringBuilder("OnDemandAllocatingPool(");
        int i2 = f55101a.get(this);
        IntRange intRangeF = RangesKt.f(0, Integer.MAX_VALUE & i2);
        ArrayList arrayList = new ArrayList(CollectionsKt.r(intRangeF, 10));
        Iterator<Integer> it = intRangeF.iterator();
        if (((IntProgressionIterator) it).f53843c) {
            ((IntIterator) it).a();
            throw null;
        }
        sb.append(arrayList.toString() + ((i2 & Integer.MIN_VALUE) != 0 ? "[closed]" : ""));
        sb.append(')');
        return sb.toString();
    }
}
