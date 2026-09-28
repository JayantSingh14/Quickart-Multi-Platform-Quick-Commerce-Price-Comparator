package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class zzsr extends zzst {
    @SafeVarargs
    public static zzsq zza(zzta... zztaVarArr) {
        return new zzsq(false, zzqf.zzl(zztaVarArr), null);
    }

    public static Object zzb(Future future) throws ExecutionException {
        Object obj;
        if (!future.isDone()) {
            throw new IllegalStateException(zzpg.zzb("Future was expected to be done: %s", future));
        }
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static void zzc(zzta zztaVar, zzsn zzsnVar, Executor executor) {
        zztaVar.zzm(new zzso(zztaVar, zzsnVar), executor);
    }
}
