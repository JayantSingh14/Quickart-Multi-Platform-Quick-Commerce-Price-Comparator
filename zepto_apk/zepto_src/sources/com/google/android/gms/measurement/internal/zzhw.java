package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
final class zzhw extends FutureTask implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final long f39062a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f39063b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39064c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzhy f39065d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhw(zzhy zzhyVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        Objects.requireNonNull(zzhyVar);
        this.f39065d = zzhyVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhy.f39070k.getAndIncrement();
        this.f39062a = andIncrement;
        this.f39064c = str;
        this.f39063b = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgt zzgtVar = zzhyVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        zzhw zzhwVar = (zzhw) obj;
        boolean z = zzhwVar.f39063b;
        boolean z2 = this.f39063b;
        if (z2 != z) {
            return !z2 ? 1 : -1;
        }
        long j2 = this.f39062a;
        long j3 = zzhwVar.f39062a;
        if (j2 < j3) {
            return -1;
        }
        if (j2 > j3) {
            return 1;
        }
        zzgt zzgtVar = this.f39065d.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38959g.b(Long.valueOf(j2), "Two tasks share the same index. index");
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        zzgt zzgtVar = this.f39065d.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38958f.b(th, this.f39064c);
        if ((th instanceof zzhu) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhw(zzhy zzhyVar, Callable callable, boolean z) {
        super(callable);
        Objects.requireNonNull(zzhyVar);
        this.f39065d = zzhyVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzhy.f39070k.getAndIncrement();
        this.f39062a = andIncrement;
        this.f39064c = "Task exception on worker thread";
        this.f39063b = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgt zzgtVar = zzhyVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Tasks index overflow");
        }
    }
}
