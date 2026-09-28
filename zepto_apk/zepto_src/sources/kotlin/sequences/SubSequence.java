package kotlin.sequences;

import android.support.v4.media.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Sequence f53927a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53928b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53929c;

    @Metadata
    /* renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f53930a;

        /* renamed from: b, reason: collision with root package name */
        public int f53931b;

        public AnonymousClass1() {
            this.f53930a = SubSequence.this.f53927a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            SubSequence subSequence;
            Iterator it;
            while (true) {
                int i2 = this.f53931b;
                subSequence = SubSequence.this;
                int i3 = subSequence.f53928b;
                it = this.f53930a;
                if (i2 >= i3 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f53931b++;
            }
            return this.f53931b < subSequence.f53929c && it.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            SubSequence subSequence;
            Iterator it;
            while (true) {
                int i2 = this.f53931b;
                subSequence = SubSequence.this;
                int i3 = subSequence.f53928b;
                it = this.f53930a;
                if (i2 >= i3 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f53931b++;
            }
            int i4 = this.f53931b;
            if (i4 >= subSequence.f53929c) {
                throw new NoSuchElementException();
            }
            this.f53931b = i4 + 1;
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public SubSequence(Sequence sequence, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f53927a = sequence;
        this.f53928b = i2;
        this.f53929c = i3;
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "startIndex should be non-negative, but is ").toString());
        }
        if (i3 < 0) {
            throw new IllegalArgumentException(b.f(i3, "endIndex should be non-negative, but is ").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(b.d(i3, i2, "endIndex should be not less than startIndex, but was ", " < ").toString());
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int i2) {
        int i3 = this.f53929c;
        int i4 = this.f53928b;
        if (i2 >= i3 - i4) {
            return EmptySequence.f53903a;
        }
        return new SubSequence(this.f53927a, i4 + i2, i3);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take() {
        int i2 = this.f53929c;
        int i3 = this.f53928b;
        if (16 >= i2 - i3) {
            return this;
        }
        return new SubSequence(this.f53927a, i3, i3 + 16);
    }
}
