package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.Executor;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
final class SequentialExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43468a = 0;

    /* renamed from: com.google.common.util.concurrent.SequentialExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public final class QueueWorker implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                int i2 = SequentialExecutor.f43468a;
                throw null;
            } catch (Error unused) {
                int i3 = SequentialExecutor.f43468a;
                throw null;
            }
        }

        public final String toString() {
            throw null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class WorkerRunningState {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WorkerRunningState[] f43469a = {new WorkerRunningState("IDLE", 0), new WorkerRunningState("QUEUING", 1), new WorkerRunningState("QUEUED", 2), new WorkerRunningState("RUNNING", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        WorkerRunningState EF5;

        public static WorkerRunningState valueOf(String str) {
            return (WorkerRunningState) Enum.valueOf(WorkerRunningState.class, str);
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) f43469a.clone();
        }
    }

    static {
        new LazyLogger(SequentialExecutor.class);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        throw null;
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{null}";
    }
}
