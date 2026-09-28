package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata
/* loaded from: classes3.dex */
final class ArrayCharIterator extends CharIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f53773a;

    @Override // kotlin.collections.CharIterator
    public final char a() {
        try {
            this.f53773a++;
            throw null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f53773a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }
}
