package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f1431a;

    /* renamed from: b, reason: collision with root package name */
    public int f1432b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1433c;

    public IndexBasedArrayIterator(int i2) {
        this.f1431a = i2;
    }

    public abstract Object a(int i2);

    public abstract void b(int i2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1432b < this.f1431a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a(this.f1432b);
        this.f1432b++;
        this.f1433c = true;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f1433c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i2 = this.f1432b - 1;
        this.f1432b = i2;
        b(i2);
        this.f1431a--;
        this.f1433c = false;
    }
}
