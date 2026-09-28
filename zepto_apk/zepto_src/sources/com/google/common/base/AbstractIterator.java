package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public State f42227a;

    /* renamed from: b, reason: collision with root package name */
    public Object f42228b;

    /* renamed from: com.google.common.base.AbstractIterator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42229a;

        static {
            int[] iArr = new int[State.values().length];
            f42229a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42229a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f42230a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f42231b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f42232c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f42233d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ State[] f42234e;

        static {
            State state = new State("READY", 0);
            f42230a = state;
            State state2 = new State("NOT_READY", 1);
            f42231b = state2;
            State state3 = new State("DONE", 2);
            f42232c = state3;
            State state4 = new State("FAILED", 3);
            f42233d = state4;
            f42234e = new State[]{state, state2, state3, state4};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f42234e.clone();
        }
    }

    public abstract Object a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        State state = this.f42227a;
        State state2 = State.f42233d;
        Preconditions.n(state != state2);
        int iOrdinal = this.f42227a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 2) {
            this.f42227a = state2;
            this.f42228b = a();
            if (this.f42227a != State.f42232c) {
                this.f42227a = State.f42230a;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f42227a = State.f42231b;
        Object obj = this.f42228b;
        this.f42228b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
