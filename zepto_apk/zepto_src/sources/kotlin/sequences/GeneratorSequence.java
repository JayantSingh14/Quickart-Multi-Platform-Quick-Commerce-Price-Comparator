package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
final class GeneratorSequence<T> implements Sequence<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Function0 f53913a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f53914b;

    @Metadata
    /* renamed from: kotlin.sequences.GeneratorSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public Object f53915a;

        /* renamed from: b, reason: collision with root package name */
        public int f53916b = -2;

        public AnonymousClass1() {
        }

        public final void a() {
            Object objInvoke;
            int i2 = this.f53916b;
            GeneratorSequence generatorSequence = GeneratorSequence.this;
            if (i2 == -2) {
                objInvoke = generatorSequence.f53913a.invoke();
            } else {
                Function1 function1 = generatorSequence.f53914b;
                Object obj = this.f53915a;
                Intrinsics.c(obj);
                objInvoke = function1.invoke(obj);
            }
            this.f53915a = objInvoke;
            this.f53916b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f53916b < 0) {
                a();
            }
            return this.f53916b == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f53916b < 0) {
                a();
            }
            if (this.f53916b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f53915a;
            Intrinsics.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f53916b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public GeneratorSequence(Function0 getInitialValue, Function1 getNextValue) {
        Intrinsics.checkNotNullParameter(getInitialValue, "getInitialValue");
        Intrinsics.checkNotNullParameter(getNextValue, "getNextValue");
        this.f53913a = getInitialValue;
        this.f53914b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
