package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ExecutionSequencer {

    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$1, reason: invalid class name */
    class AnonymousClass1 implements AsyncCallable<Object> {
        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$2, reason: invalid class name */
    class AnonymousClass2 implements AsyncCallable<Object> {
        public final String toString() {
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RunningState {

        /* renamed from: a, reason: collision with root package name */
        public static final RunningState f43444a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ RunningState[] f43445b;

        /* JADX INFO: Fake field, exist only in values array */
        RunningState EF0;

        static {
            RunningState runningState = new RunningState("NOT_RUN", 0);
            RunningState runningState2 = new RunningState("CANCELLED", 1);
            f43444a = runningState2;
            f43445b = new RunningState[]{runningState, runningState2, new RunningState("STARTED", 2)};
        }

        public static RunningState valueOf(String str) {
            return (RunningState) Enum.valueOf(RunningState.class, str);
        }

        public static RunningState[] values() {
            return (RunningState[]) f43445b.clone();
        }
    }

    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f43446a;

        /* renamed from: b, reason: collision with root package name */
        public Thread f43447b;

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            if (get() == RunningState.f43444a) {
                return;
            }
            this.f43447b = Thread.currentThread();
            try {
                throw null;
            } catch (Throwable th) {
                this.f43447b = null;
                throw th;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (Thread.currentThread() == this.f43447b) {
                throw null;
            }
            Runnable runnable = this.f43446a;
            Objects.requireNonNull(runnable);
            this.f43446a = null;
            runnable.run();
        }
    }

    public static final class ThreadConfinedTaskQueue {
    }
}
