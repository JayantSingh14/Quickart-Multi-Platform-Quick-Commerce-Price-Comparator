package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.FluentIterable;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;

@DoNotMock
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {

    /* renamed from: com.google.common.base.Optional$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Iterable<Object> {

        /* renamed from: com.google.common.base.Optional$1$1, reason: invalid class name and collision with other inner class name */
        class C00311 extends AbstractIterator<Object> {
            @Override // com.google.common.base.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<Object> iterator() {
            throw null;
        }
    }

    public static Optional a() {
        return Absent.f42226a;
    }

    public static Optional d(Object obj) {
        obj.getClass();
        return new Present(obj);
    }

    public abstract Object b();

    public abstract boolean c();

    public abstract Object e(FluentIterable fluentIterable);

    public abstract Object f();
}
