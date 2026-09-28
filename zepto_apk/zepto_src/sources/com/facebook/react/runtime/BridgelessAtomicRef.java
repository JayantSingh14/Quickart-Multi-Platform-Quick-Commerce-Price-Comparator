package com.facebook.react.runtime;

import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.runtime.internal.bolts.Task;
import java.util.Objects;

@Nullsafe
/* loaded from: classes3.dex */
class BridgelessAtomicRef<T> {

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f19221a;

    /* renamed from: b, reason: collision with root package name */
    public final Task f19222b;

    /* renamed from: c, reason: collision with root package name */
    public volatile State f19223c;

    /* renamed from: d, reason: collision with root package name */
    public volatile String f19224d;

    public interface Provider<T> {
        Object get();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f19225a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f19226b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f19227c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f19228d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ State[] f19229e;

        static {
            State state = new State("Init", 0);
            f19225a = state;
            State state2 = new State("Creating", 1);
            f19226b = state2;
            State state3 = new State("Success", 2);
            f19227c = state3;
            State state4 = new State("Failure", 3);
            f19228d = state4;
            f19229e = new State[]{state, state2, state3, state4};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f19229e.clone();
        }
    }

    public BridgelessAtomicRef(Task task) {
        this.f19221a = task;
        this.f19222b = task;
        this.f19223c = State.f19225a;
        this.f19224d = "";
    }

    public final synchronized Object a() {
        Object obj;
        obj = this.f19221a;
        Assertions.c(obj);
        return obj;
    }

    public final synchronized Object b() {
        return this.f19221a;
    }

    public final Object c(Provider provider) {
        boolean z;
        Object objA;
        Object objA2;
        synchronized (this) {
            try {
                State state = this.f19223c;
                State state2 = State.f19227c;
                if (state == state2) {
                    return a();
                }
                if (this.f19223c == State.f19228d) {
                    throw new RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + this.f19224d);
                }
                State state3 = this.f19223c;
                State state4 = State.f19226b;
                boolean z2 = false;
                if (state3 != state4) {
                    this.f19223c = state4;
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    try {
                        this.f19221a = provider.get();
                        synchronized (this) {
                            this.f19223c = state2;
                            notifyAll();
                            objA = a();
                        }
                        return objA;
                    } catch (RuntimeException e2) {
                        synchronized (this) {
                            this.f19223c = State.f19228d;
                            this.f19224d = Objects.toString(e2.getMessage(), "null");
                            notifyAll();
                            throw new RuntimeException("BridgelessAtomicRef: Failed to create object.", e2);
                        }
                    }
                }
                synchronized (this) {
                    while (this.f19223c == State.f19226b) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    if (this.f19223c == State.f19228d) {
                        throw new RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + this.f19224d);
                    }
                    objA2 = a();
                }
                return objA2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void d() {
        this.f19221a = this.f19222b;
        this.f19223c = State.f19225a;
        this.f19224d = "";
    }

    public BridgelessAtomicRef() {
        this(null);
    }
}
