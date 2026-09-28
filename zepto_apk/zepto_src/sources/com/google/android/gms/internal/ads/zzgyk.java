package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
final class zzgyk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ListenableFuture f33373a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyj f33374b;

    public zzgyk(ListenableFuture listenableFuture, zzgyj zzgyjVar) {
        this.f33373a = listenableFuture;
        this.f33374b = zzgyjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable thA;
        ListenableFuture listenableFuture = this.f33373a;
        boolean z = listenableFuture instanceof zzgzo;
        zzgyj zzgyjVar = this.f33374b;
        if (z && (thA = ((zzgzo) listenableFuture).a()) != null) {
            zzgyjVar.zza(thA);
            return;
        }
        try {
            zzgyjVar.zzb(zzgym.l(listenableFuture));
        } catch (ExecutionException e2) {
            zzgyjVar.zza(e2.getCause());
        } catch (Throwable th) {
            zzgyjVar.zza(th);
        }
    }

    public final String toString() {
        zzgpw zzgpwVar = new zzgpw("zzgyk");
        zzgpv zzgpvVar = new zzgpv();
        zzgpwVar.f33061c.f33058b = zzgpvVar;
        zzgpwVar.f33061c = zzgpvVar;
        zzgpvVar.f33057a = this.f33374b;
        return zzgpwVar.toString();
    }
}
