package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayBooleanIterator extends BooleanIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53771a;

    @Override // kotlin.collections.BooleanIterator
    public final boolean a() {
        try {
            this.f53771a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53771a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
