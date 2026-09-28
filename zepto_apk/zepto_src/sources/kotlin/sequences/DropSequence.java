package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Sequence f53893a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53894b;

    @Metadata
    /* renamed from: kotlin.sequences.DropSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f53895a;

        /* renamed from: b, reason: collision with root package name */
        public int f53896b;

        public AnonymousClass1(DropSequence dropSequence) {
            this.f53895a = dropSequence.f53893a.iterator();
            this.f53896b = dropSequence.f53894b;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Iterator it;
            while (true) {
                int i2 = this.f53896b;
                it = this.f53895a;
                if (i2 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f53896b--;
            }
            return it.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Iterator it;
            while (true) {
                int i2 = this.f53896b;
                it = this.f53895a;
                if (i2 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f53896b--;
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DropSequence(Sequence sequence, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.f53893a = sequence;
        this.f53894b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int i2) {
        int i3 = this.f53894b + i2;
        return i3 < 0 ? new DropSequence(this, i2) : new DropSequence(this.f53893a, i3);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence take() {
        int i2 = this.f53894b;
        int i3 = i2 + 16;
        return i3 < 0 ? new TakeSequence(this) : new SubSequence(this.f53893a, i2, i3);
    }
}
