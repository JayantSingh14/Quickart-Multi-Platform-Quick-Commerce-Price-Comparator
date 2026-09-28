package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzgym extends zzgyo {
    public static ListenableFuture a(Object obj) {
        return obj == null ? zzgyq.f33377b : new zzgyq(obj);
    }

    public static ListenableFuture b(Throwable th) {
        th.getClass();
        zzgyp zzgypVar = new zzgyp();
        zzgypVar.d(th);
        return zzgypVar;
    }

    public static ListenableFuture c(Callable callable, Executor executor) {
        zzgzl zzgzlVar = new zzgzl(callable);
        executor.execute(zzgzlVar);
        return zzgzlVar;
    }

    public static ListenableFuture d(zzgxt zzgxtVar, zzgyw zzgywVar) {
        zzgzl zzgzlVar = new zzgzl();
        zzgzlVar.f33403h = new zzgzj(zzgzlVar, zzgxtVar);
        zzgywVar.execute(zzgzlVar);
        return zzgzlVar;
    }

    public static ListenableFuture e(ListenableFuture listenableFuture, Class cls, zzgpr zzgprVar, Executor executor) {
        int i2 = zzgxe.f33304k;
        zzgxd zzgxdVar = new zzgxd(listenableFuture, cls, zzgprVar);
        listenableFuture.q(zzgxdVar, zzgzd.a(executor, zzgxdVar));
        return zzgxdVar;
    }

    public static ListenableFuture f(ListenableFuture listenableFuture, Class cls, zzgxu zzgxuVar, Executor executor) {
        int i2 = zzgxe.f33304k;
        zzgxc zzgxcVar = new zzgxc(listenableFuture, cls, zzgxuVar);
        listenableFuture.q(zzgxcVar, zzgzd.a(executor, zzgxcVar));
        return zzgxcVar;
    }

    public static ListenableFuture g(ListenableFuture listenableFuture, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        zzgzi zzgziVar = new zzgzi();
        zzgziVar.f33397h = listenableFuture;
        zzgzg zzgzgVar = new zzgzg();
        zzgzgVar.f33396a = zzgziVar;
        zzgziVar.f33398i = scheduledExecutorService.schedule(zzgzgVar, j2, timeUnit);
        listenableFuture.q(zzgzgVar, zzgyb.f33369a);
        return zzgziVar;
    }

    public static ListenableFuture h(ListenableFuture listenableFuture, zzgxu zzgxuVar, Executor executor) {
        int i2 = zzgxl.f33342j;
        zzgxj zzgxjVar = new zzgxj(listenableFuture, zzgxuVar);
        listenableFuture.q(zzgxjVar, zzgzd.a(executor, zzgxjVar));
        return zzgxjVar;
    }

    public static ListenableFuture i(ListenableFuture listenableFuture, zzgpr zzgprVar, Executor executor) {
        int i2 = zzgxl.f33342j;
        zzgxk zzgxkVar = new zzgxk(listenableFuture, zzgprVar);
        listenableFuture.q(zzgxkVar, zzgzd.a(executor, zzgxkVar));
        return zzgxkVar;
    }

    public static ListenableFuture j(ArrayList arrayList) {
        return new zzgxv(zzgtd.r(arrayList), true);
    }

    public static void k(ListenableFuture listenableFuture, zzgyj zzgyjVar, Executor executor) {
        listenableFuture.q(new zzgyk(listenableFuture, zzgyjVar), executor);
    }

    public static Object l(Future future) {
        if (future.isDone()) {
            return zzgzn.a(future);
        }
        throw new IllegalStateException(zzgqr.b("Future was expected to be done: %s", future));
    }

    public static Object m(zzcdt zzcdtVar) {
        try {
            return zzgzn.a(zzcdtVar);
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof Error) {
                throw new zzgyc((Error) e2.getCause());
            }
            throw new zzgzm(e2.getCause());
        }
    }
}
