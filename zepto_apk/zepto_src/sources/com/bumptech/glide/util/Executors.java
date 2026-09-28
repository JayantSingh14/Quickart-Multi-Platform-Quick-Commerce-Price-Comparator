package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class Executors {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f16516a = new Executor() { // from class: com.bumptech.glide.util.Executors.1

        /* renamed from: a, reason: collision with root package name */
        public final Handler f16518a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f16518a.post(runnable);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f16517b = new AnonymousClass2();

    /* renamed from: com.bumptech.glide.util.Executors$2, reason: invalid class name */
    public class AnonymousClass2 implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }
}
