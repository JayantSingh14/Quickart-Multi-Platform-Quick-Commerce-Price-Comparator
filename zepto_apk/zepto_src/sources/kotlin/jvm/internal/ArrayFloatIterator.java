package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.FloatIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayFloatIterator extends FloatIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53775a;

    @Override // kotlin.collections.FloatIterator
    public final float a() {
        try {
            this.f53775a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53775a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
