package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.Executor;
import java.util.logging.Level;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public final class ExecutionList {

    /* renamed from: c, reason: collision with root package name */
    public static final LazyLogger f43438c = new LazyLogger(ExecutionList.class);

    /* renamed from: a, reason: collision with root package name */
    public RunnableExecutorPair f43439a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f43440b;

    public static final class RunnableExecutorPair {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f43441a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f43442b;

        /* renamed from: c, reason: collision with root package name */
        public RunnableExecutorPair f43443c;

        public RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair runnableExecutorPair) {
            this.f43441a = runnable;
            this.f43442b = executor;
            this.f43443c = runnableExecutorPair;
        }
    }

    public static void a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            f43438c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }
}
