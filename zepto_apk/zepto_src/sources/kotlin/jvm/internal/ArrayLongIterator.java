package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayLongIterator extends LongIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53779a;

    @Override // kotlin.collections.LongIterator
    public final long a() {
        try {
            this.f53779a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53779a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
