package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.collect.AbstractIterator;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

@Beta
@ElementTypesAreNonnullByDefault
@DoNotMock
/* loaded from: classes4.dex */
public abstract class Traverser<N> {

    /* renamed from: com.google.common.graph.Traverser$1, reason: invalid class name */
    class AnonymousClass1 extends Traverser<Object> {
    }

    /* renamed from: com.google.common.graph.Traverser$2, reason: invalid class name */
    class AnonymousClass2 extends Traverser<Object> {
    }

    /* renamed from: com.google.common.graph.Traverser$3, reason: invalid class name */
    class AnonymousClass3 implements Iterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator<Object> iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.graph.Traverser$4, reason: invalid class name */
    class AnonymousClass4 implements Iterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator<Object> iterator() {
            throw null;
        }
    }

    /* renamed from: com.google.common.graph.Traverser$5, reason: invalid class name */
    class AnonymousClass5 implements Iterable<Object> {
        @Override // java.lang.Iterable
        public final Iterator<Object> iterator() {
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class InsertionOrder {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InsertionOrder[] f43198a = {new InsertionOrder() { // from class: com.google.common.graph.Traverser.InsertionOrder.1
        }, new InsertionOrder() { // from class: com.google.common.graph.Traverser.InsertionOrder.2
        }};

        /* JADX INFO: Fake field, exist only in values array */
        InsertionOrder EF2;

        public static InsertionOrder valueOf(String str) {
            return (InsertionOrder) Enum.valueOf(InsertionOrder.class, str);
        }

        public static InsertionOrder[] values() {
            return (InsertionOrder[]) f43198a.clone();
        }
    }

    public static abstract class Traversal<N> {

        /* renamed from: com.google.common.graph.Traverser$Traversal$1, reason: invalid class name */
        class AnonymousClass1 extends Traversal<Object> {
            @Override // com.google.common.graph.Traverser.Traversal
            public final Object a(ArrayDeque arrayDeque) {
                Iterator it = (Iterator) arrayDeque.getFirst();
                if (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                    throw null;
                }
                arrayDeque.removeFirst();
                return null;
            }
        }

        /* renamed from: com.google.common.graph.Traverser$Traversal$2, reason: invalid class name */
        class AnonymousClass2 extends Traversal<Object> {
            @Override // com.google.common.graph.Traverser.Traversal
            public final Object a(ArrayDeque arrayDeque) {
                Iterator it = (Iterator) arrayDeque.getFirst();
                if (!it.hasNext()) {
                    arrayDeque.removeFirst();
                    return null;
                }
                Object next = it.next();
                next.getClass();
                return next;
            }
        }

        /* renamed from: com.google.common.graph.Traverser$Traversal$3, reason: invalid class name */
        class AnonymousClass3 extends AbstractIterator<Object> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        /* renamed from: com.google.common.graph.Traverser$Traversal$4, reason: invalid class name */
        class AnonymousClass4 extends AbstractIterator<Object> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        public abstract Object a(ArrayDeque arrayDeque);
    }
}
