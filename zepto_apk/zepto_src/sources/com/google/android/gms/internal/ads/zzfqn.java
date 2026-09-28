package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqn implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31652a;

    public zzfqn(zzfqy zzfqyVar) {
        Objects.requireNonNull(zzfqyVar);
        this.f31652a = zzfqyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfqy zzfqyVar = this.f31652a;
        synchronized (zzfqyVar) {
            try {
                zzfqyVar.f31679m.set(false);
                if ((th instanceof zzfpq) && ((zzfpq) th).f31587a == 0) {
                    throw null;
                }
                zzfqyVar.c(true);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfqy zzfqyVar = this.f31652a;
        synchronized (zzfqyVar) {
            try {
                zzfqyVar.f31679m.set(false);
                if (obj != null) {
                    zzfqyVar.f31677k.a();
                    zzfqyVar.q.set(true);
                    zzfqyVar.b(obj);
                }
                if (obj == null || zzfqyVar.f31672f == null) {
                    zzfqyVar.c(obj == null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
