package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Iterators {

    /* renamed from: com.google.common.collect.Iterators$10, reason: invalid class name */
    class AnonymousClass10 implements Enumeration<Object> {
        @Override // java.util.Enumeration
        public final boolean hasMoreElements() {
            throw null;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterators$2, reason: invalid class name */
    class AnonymousClass2 implements Iterator<Object> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterators$4, reason: invalid class name */
    class AnonymousClass4 extends UnmodifiableIterator<List<Object>> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterators$6, reason: invalid class name */
    class AnonymousClass6 extends TransformedIterator<Object, Object> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function f42754b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Iterator it, Function function) {
            super(it);
            this.f42754b = function;
        }

        @Override // com.google.common.collect.TransformedIterator
        public final Object a(Object obj) {
            return this.f42754b.apply(obj);
        }
    }

    /* renamed from: com.google.common.collect.Iterators$7, reason: invalid class name */
    class AnonymousClass7 implements Iterator<Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f42755a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f42755a++;
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.Iterators$8, reason: invalid class name */
    class AnonymousClass8 extends UnmodifiableIterator<Object> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw null;
        }

        public final String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    /* renamed from: com.google.common.collect.Iterators$9, reason: invalid class name */
    class AnonymousClass9 extends UnmodifiableIterator<Object> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw null;
        }
    }

    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {

        /* renamed from: d, reason: collision with root package name */
        public static final UnmodifiableListIterator f42756d = new ArrayItr(new Object[0]);

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f42757c;

        public ArrayItr(Object[] objArr) {
            super(objArr.length, 0);
            this.f42757c = objArr;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public final Object a(int i2) {
            return this.f42757c[i2];
        }
    }

    public static class ConcatenatedIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public Iterator f42758a;

        /* renamed from: b, reason: collision with root package name */
        public Iterator f42759b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator f42760c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayDeque f42761d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Iterator it;
            while (true) {
                Iterator it2 = this.f42759b;
                it2.getClass();
                if (it2.hasNext()) {
                    return true;
                }
                while (true) {
                    Iterator it3 = this.f42760c;
                    if (it3 != null && it3.hasNext()) {
                        it = this.f42760c;
                        break;
                    }
                    ArrayDeque arrayDeque = this.f42761d;
                    if (arrayDeque == null || arrayDeque.isEmpty()) {
                        break;
                    }
                    this.f42760c = (Iterator) this.f42761d.removeFirst();
                }
                it = null;
                this.f42760c = it;
                if (it == null) {
                    return false;
                }
                Iterator it4 = (Iterator) it.next();
                this.f42759b = it4;
                if (it4 instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) it4;
                    this.f42759b = concatenatedIterator.f42759b;
                    if (this.f42761d == null) {
                        this.f42761d = new ArrayDeque();
                    }
                    this.f42761d.addFirst(this.f42760c);
                    if (concatenatedIterator.f42761d != null) {
                        while (!concatenatedIterator.f42761d.isEmpty()) {
                            this.f42761d.addFirst((Iterator) concatenatedIterator.f42761d.removeLast());
                        }
                    }
                    this.f42760c = concatenatedIterator.f42760c;
                }
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = this.f42759b;
            this.f42758a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Iterator it = this.f42758a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f42758a = null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class EmptyModifiableIterator implements Iterator<Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final EmptyModifiableIterator f42762a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EmptyModifiableIterator[] f42763b;

        static {
            EmptyModifiableIterator emptyModifiableIterator = new EmptyModifiableIterator("INSTANCE", 0);
            f42762a = emptyModifiableIterator;
            f42763b = new EmptyModifiableIterator[]{emptyModifiableIterator};
        }

        public static EmptyModifiableIterator valueOf(String str) {
            return (EmptyModifiableIterator) Enum.valueOf(EmptyModifiableIterator.class, str);
        }

        public static EmptyModifiableIterator[] values() {
            return (EmptyModifiableIterator[]) f42763b.clone();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            CollectPreconditions.d(false);
        }
    }

    public static class MergingIterator<T> extends UnmodifiableIterator<T> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw null;
        }
    }

    public static class PeekingImpl<E> implements PeekingIterator<E> {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f42764a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42765b;

        /* renamed from: c, reason: collision with root package name */
        public Object f42766c;

        public PeekingImpl(Iterator it) {
            it.getClass();
            this.f42764a = it;
        }

        public final Object a() {
            if (!this.f42765b) {
                this.f42766c = this.f42764a.next();
                this.f42765b = true;
            }
            return this.f42766c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42765b || this.f42764a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.f42765b) {
                return this.f42764a.next();
            }
            Object obj = this.f42766c;
            this.f42765b = false;
            this.f42766c = null;
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Preconditions.m("Can't remove after you've peeked at next", !this.f42765b);
            this.f42764a.remove();
        }
    }

    public static final class SingletonIterator<T> extends UnmodifiableIterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public static final Object f42767b = new Object();

        /* renamed from: a, reason: collision with root package name */
        public Object f42768a;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42768a != f42767b;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object obj = this.f42768a;
            Object obj2 = f42767b;
            if (obj == obj2) {
                throw new NoSuchElementException();
            }
            this.f42768a = obj2;
            return obj;
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        collection.getClass();
        it.getClass();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static void b(Iterator it) {
        it.getClass();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static Iterator c(Iterator it, Iterator it2) {
        final Iterator[] itArr = {it, it2};
        UnmodifiableIterator<Iterator<?>> unmodifiableIterator = new UnmodifiableIterator<Iterator<?>>() { // from class: com.google.common.collect.Iterators.3

            /* renamed from: a, reason: collision with root package name */
            public int f42750a = 0;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f42750a < itArr.length;
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i2 = this.f42750a;
                Iterator[] itArr2 = itArr;
                Iterator it3 = itArr2[i2];
                Objects.requireNonNull(it3);
                int i3 = this.f42750a;
                itArr2[i3] = null;
                this.f42750a = i3 + 1;
                return it3;
            }
        };
        ConcatenatedIterator concatenatedIterator = new ConcatenatedIterator();
        concatenatedIterator.f42759b = ArrayItr.f42756d;
        concatenatedIterator.f42760c = unmodifiableIterator;
        return concatenatedIterator;
    }

    public static boolean d(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.Objects.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static UnmodifiableIterator f(final Iterator it, final Predicate predicate) {
        it.getClass();
        predicate.getClass();
        return new AbstractIterator<Object>() { // from class: com.google.common.collect.Iterators.5
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                Object next;
                do {
                    Iterator it2 = it;
                    if (!it2.hasNext()) {
                        this.f42456a = AbstractIterator.State.f42461c;
                        return null;
                    }
                    next = it2.next();
                } while (!predicate.apply(next));
                return next;
            }
        };
    }

    public static Object g(Iterator it, Predicate predicate) {
        it.getClass();
        predicate.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return null;
    }

    public static UnmodifiableIterator h(Object... objArr) {
        if (objArr.length != 0) {
            return new ArrayItr(objArr);
        }
        Preconditions.k(0, objArr.length);
        return ArrayItr.f42756d;
    }

    public static Object i(Iterator it, String str) {
        return it.hasNext() ? it.next() : str;
    }

    public static PeekingIterator j(Iterator it) {
        return it instanceof PeekingImpl ? (PeekingImpl) it : new PeekingImpl(it);
    }

    public static Object k(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static boolean l(Collection collection, Iterator it) {
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static int m(Iterator it) {
        long j2 = 0;
        while (it.hasNext()) {
            it.next();
            j2++;
        }
        return Ints.f(j2);
    }

    public static Iterator n(Iterator it, Function function) {
        function.getClass();
        return new AnonymousClass6(it, function);
    }

    public static UnmodifiableIterator o(final Iterator it) {
        it.getClass();
        return it instanceof UnmodifiableIterator ? (UnmodifiableIterator) it : new UnmodifiableIterator<Object>() { // from class: com.google.common.collect.Iterators.1
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                return it.next();
            }
        };
    }
}
