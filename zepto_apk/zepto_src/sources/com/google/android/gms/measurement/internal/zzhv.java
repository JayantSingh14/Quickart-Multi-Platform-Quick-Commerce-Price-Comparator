package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzhv implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f39060a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzhy f39061b;

    public zzhv(zzhy zzhyVar, String str) {
        Objects.requireNonNull(zzhyVar);
        this.f39061b = zzhyVar;
        Preconditions.checkNotNull(str);
        this.f39060a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        zzgt zzgtVar = this.f39061b.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38958f.b(th, this.f39060a);
    }
}
