package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ShortIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayShortIterator extends ShortIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53780a;

    @Override // kotlin.collections.ShortIterator
    public final short a() {
        try {
            this.f53780a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53780a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
