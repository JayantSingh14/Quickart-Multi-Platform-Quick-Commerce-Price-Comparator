package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzgzg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public zzgzi f33396a;

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture;
        zzgzi zzgziVar = this.f33396a;
        if (zzgziVar == null || (listenableFuture = zzgziVar.f33397h) == null) {
            return;
        }
        this.f33396a = null;
        if (listenableFuture.isDone()) {
            zzgziVar.m(listenableFuture);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgziVar.f33398i;
            zzgziVar.f33398i = null;
            String string = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        StringBuilder sb = new StringBuilder(String.valueOf(jAbs).length() + 55);
                        sb.append("Timed out (timeout delayed by ");
                        sb.append(jAbs);
                        sb.append(" ms after scheduled time)");
                        string = sb.toString();
                    }
                } catch (Throwable th) {
                    zzgziVar.d(new zzgzh(string));
                    throw th;
                }
            }
            String string2 = listenableFuture.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 2 + string2.length());
            sb2.append(string);
            sb2.append(": ");
            sb2.append(string2);
            zzgziVar.d(new zzgzh(sb2.toString()));
        } finally {
            listenableFuture.cancel(true);
        }
    }
}
