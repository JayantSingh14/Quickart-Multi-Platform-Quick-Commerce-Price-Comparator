package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.ArrayDeque;
import java.util.Iterator;

@Beta
@GwtCompatible
@Deprecated
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class TreeTraverser<T> {

    /* renamed from: com.google.common.collect.TreeTraverser$1, reason: invalid class name */
    class AnonymousClass1 extends TreeTraverser<Object> {
    }

    /* renamed from: com.google.common.collect.TreeTraverser$2, reason: invalid class name */
    class AnonymousClass2 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.TreeTraverser$3, reason: invalid class name */
    class AnonymousClass3 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.collect.TreeTraverser$4, reason: invalid class name */
    class AnonymousClass4 extends FluentIterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator iterator() {
            return new BreadthFirstIterator();
        }
    }

    public final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayDeque f43165a;

        public BreadthFirstIterator() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f43165a = arrayDeque;
            arrayDeque.add(null);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f43165a.isEmpty();
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.f43165a.remove();
            throw null;
        }
    }

    public final class PostOrderIterator extends AbstractIterator<T> {
        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            throw null;
        }
    }

    public static final class PostOrderNode<T> {
    }

    public final class PreOrderIterator extends UnmodifiableIterator<T> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw null;
        }
    }
}
