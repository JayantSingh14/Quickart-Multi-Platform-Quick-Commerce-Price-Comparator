package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class TreeIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f3071a = ViewGroupKt$descendants$1$1.f3102c;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3072b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Iterator f3073c;

    public TreeIterator(Iterator it) {
        this.f3073c = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3073c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.f3073c.next();
        Iterator it = (Iterator) ViewGroupKt$descendants$1$1.f3102c.invoke(next);
        ArrayList arrayList = this.f3072b;
        if (it != null && it.hasNext()) {
            arrayList.add(this.f3073c);
            this.f3073c = it;
            return next;
        }
        while (!this.f3073c.hasNext() && !arrayList.isEmpty()) {
            this.f3073c = (Iterator) CollectionsKt.F(arrayList);
            CollectionsKt.P(arrayList);
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
