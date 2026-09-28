package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class FluentIterable<E> implements Iterable<E> {

    /* renamed from: a, reason: collision with root package name */
    public final Optional f42616a;

    /* renamed from: com.google.common.collect.FluentIterable$2, reason: invalid class name */
    class AnonymousClass2 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.FluentIterable$3, reason: invalid class name */
    class AnonymousClass3 extends FluentIterable<Object> {

        /* renamed from: com.google.common.collect.FluentIterable$3$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIndexedListIterator<Iterator<Object>> {
            public AnonymousClass1(int i2) {
                super(i2, 0);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            public final Object a(int i2) {
                throw null;
            }
        }

        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    public static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return FluentIterable.d((Iterable) obj);
        }
    }

    public FluentIterable() {
        this.f42616a = Optional.a();
    }

    public static FluentIterable d(final Iterable iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<Object>(iterable) { // from class: com.google.common.collect.FluentIterable.1
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return iterable.iterator();
            }
        };
    }

    public final FluentIterable b(Class cls) {
        Iterable iterableF = f();
        iterableF.getClass();
        cls.getClass();
        return d(new Iterables.AnonymousClass4(iterableF, Predicates.g(cls)));
    }

    public final Iterable f() {
        return (Iterable) this.f42616a.e(this);
    }

    public final ImmutableSet g() {
        Iterable iterableF = f();
        int i2 = ImmutableSet.f42719c;
        if (iterableF instanceof Collection) {
            return ImmutableSet.o((Collection) iterableF);
        }
        Iterator it = iterableF.iterator();
        if (!it.hasNext()) {
            return RegularImmutableSet.f43033j;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return new SingletonImmutableSet(next);
        }
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        builder.c(next);
        while (it.hasNext()) {
            builder.c(it.next());
        }
        return builder.k();
    }

    public String toString() {
        Iterator it = f().iterator();
        StringBuilder sb = new StringBuilder("[");
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public FluentIterable(Iterable iterable) {
        this.f42616a = Optional.d(iterable);
    }
}
