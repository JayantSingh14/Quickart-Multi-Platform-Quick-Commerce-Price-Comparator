package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayIntIterator extends IntIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53776a;

    @Override // kotlin.collections.IntIterator
    public final int a() {
        try {
            this.f53776a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53776a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
