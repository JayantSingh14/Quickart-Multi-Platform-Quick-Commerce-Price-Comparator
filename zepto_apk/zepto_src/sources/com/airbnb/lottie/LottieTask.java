package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public class LottieTask<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final ExecutorService f14193e = Executors.newCachedThreadPool(new LottieThreadFactory());

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f14194a = new LinkedHashSet(1);

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f14195b = new LinkedHashSet(1);

    /* renamed from: c, reason: collision with root package name */
    public final Handler f14196c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public volatile LottieResult f14197d = null;

    public static class LottieFutureTask<T> extends FutureTask<LottieResult<T>> {

        /* renamed from: a, reason: collision with root package name */
        public LottieTask f14198a;

        @Override // java.util.concurrent.FutureTask
        public final void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    LottieTask lottieTask = this.f14198a;
                    LottieResult<T> lottieResult = get();
                    ExecutorService executorService = LottieTask.f14193e;
                    lottieTask.g(lottieResult);
                } catch (InterruptedException | ExecutionException e2) {
                    LottieTask lottieTask2 = this.f14198a;
                    LottieResult lottieResult2 = new LottieResult(e2);
                    ExecutorService executorService2 = LottieTask.f14193e;
                    lottieTask2.g(lottieResult2);
                }
            } finally {
                this.f14198a = null;
            }
        }
    }

    public LottieTask(LottieComposition lottieComposition) {
        g(new LottieResult(lottieComposition));
    }

    public final synchronized void a(LottieListener lottieListener) {
        Throwable th;
        try {
            LottieResult lottieResult = this.f14197d;
            if (lottieResult != null && (th = lottieResult.f14192b) != null) {
                lottieListener.onResult(th);
            }
            this.f14195b.add(lottieListener);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void b(LottieListener lottieListener) {
        LottieComposition lottieComposition;
        try {
            LottieResult lottieResult = this.f14197d;
            if (lottieResult != null && (lottieComposition = lottieResult.f14191a) != null) {
                lottieListener.onResult(lottieComposition);
            }
            this.f14194a.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final LottieResult c() {
        return this.f14197d;
    }

    public final void d() {
        LottieResult lottieResult = this.f14197d;
        if (lottieResult == null) {
            return;
        }
        LottieComposition lottieComposition = lottieResult.f14191a;
        if (lottieComposition != null) {
            synchronized (this) {
                Iterator it = new ArrayList(this.f14194a).iterator();
                while (it.hasNext()) {
                    ((LottieListener) it.next()).onResult(lottieComposition);
                }
            }
            return;
        }
        Throwable th = lottieResult.f14192b;
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.f14195b);
            if (arrayList.isEmpty()) {
                Logger.c("Lottie encountered an error but no failure listener was added:", th);
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((LottieListener) it2.next()).onResult(th);
            }
        }
    }

    public final synchronized void e(LottieListener lottieListener) {
        this.f14195b.remove(lottieListener);
    }

    public final synchronized void f(LottieListener lottieListener) {
        this.f14194a.remove(lottieListener);
    }

    public final void g(LottieResult lottieResult) {
        if (this.f14197d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f14197d = lottieResult;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            this.f14196c.post(new f(this, 2));
        }
    }

    public LottieTask(Callable callable, boolean z) {
        if (z) {
            try {
                g((LottieResult) callable.call());
                return;
            } catch (Throwable th) {
                g(new LottieResult(th));
                return;
            }
        }
        ExecutorService executorService = f14193e;
        LottieFutureTask lottieFutureTask = new LottieFutureTask(callable);
        lottieFutureTask.f14198a = this;
        executorService.execute(lottieFutureTask);
    }
}
