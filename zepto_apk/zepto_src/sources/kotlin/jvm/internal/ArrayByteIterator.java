package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayByteIterator extends ByteIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53772a;

    @Override // kotlin.collections.ByteIterator
    public final byte A() {
        try {
            this.f53772a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53772a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
