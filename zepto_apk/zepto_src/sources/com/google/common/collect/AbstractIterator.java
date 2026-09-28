package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public State f42456a = State.f42460b;

    /* renamed from: b, reason: collision with root package name */
    public Object f42457b;

    /* renamed from: com.google.common.collect.AbstractIterator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42458a;

        static {
            int[] iArr = new int[State.values().length];
            f42458a = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42458a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f42459a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f42460b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f42461c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f42462d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ State[] f42463e;

        static {
            State state = new State("READY", 0);
            f42459a = state;
            State state2 = new State("NOT_READY", 1);
            f42460b = state2;
            State state3 = new State("DONE", 2);
            f42461c = state3;
            State state4 = new State("FAILED", 3);
            f42462d = state4;
            f42463e = new State[]{state, state2, state3, state4};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f42463e.clone();
        }
    }

    public abstract Object a();

    public final void b() {
        this.f42456a = State.f42461c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        State state = this.f42456a;
        State state2 = State.f42462d;
        Preconditions.n(state != state2);
        int iOrdinal = this.f42456a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 2) {
            this.f42456a = state2;
            this.f42457b = a();
            if (this.f42456a != State.f42461c) {
                this.f42456a = State.f42459a;
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
        this.f42456a = State.f42460b;
        Object obj = this.f42457b;
        this.f42457b = null;
        return obj;
    }
}
