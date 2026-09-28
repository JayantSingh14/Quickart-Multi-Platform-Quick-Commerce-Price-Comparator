package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f53582a;

    /* renamed from: b, reason: collision with root package name */
    public Object f53583b;

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f53582a;
        if (i2 == 0) {
            this.f53582a = 3;
            a();
            return this.f53582a == 1;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f53582a;
        if (i2 == 1) {
            this.f53582a = 0;
            return this.f53583b;
        }
        if (i2 != 2) {
            this.f53582a = 3;
            a();
            if (this.f53582a == 1) {
                this.f53582a = 0;
                return this.f53583b;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
