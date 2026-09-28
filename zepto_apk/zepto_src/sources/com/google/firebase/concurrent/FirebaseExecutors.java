package com.google.firebase.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class FirebaseExecutors {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes4.dex */
    public static final class DirectExecutor implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DirectExecutor[] f43638a = {new DirectExecutor("INSTANCE", 0)};

        /* JADX INFO: Fake field, exist only in values array */
        DirectExecutor EF5;

        public static DirectExecutor valueOf(String str) {
            return (DirectExecutor) Enum.valueOf(DirectExecutor.class, str);
        }

        public static DirectExecutor[] values() {
            return (DirectExecutor[]) f43638a.clone();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
