package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayDoubleIterator extends DoubleIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53774a;

    @Override // kotlin.collections.DoubleIterator
    public final double a() {
        try {
            this.f53774a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53774a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
