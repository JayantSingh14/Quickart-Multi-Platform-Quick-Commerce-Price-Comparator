package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
final class zzgfe implements zzgfy {

    /* renamed from: a, reason: collision with root package name */
    public final Map f32438a;

    /* renamed from: b, reason: collision with root package name */
    public final zzavs f32439b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgna f32440c;

    /* renamed from: d, reason: collision with root package name */
    public final long f32441d;

    public zzgfe(zzavs zzavsVar, Map map, zzgad zzgadVar, zzgnc zzgncVar) {
        this.f32438a = map;
        this.f32439b = zzavsVar;
        this.f32440c = zzgncVar.a(112);
        this.f32441d = zzgadVar.P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzawp zzawpVar;
        try {
            try {
                this.f32440c.a();
                ListenableFuture listenableFuture = (ListenableFuture) this.f32438a.get("gs");
                if (listenableFuture != null && (zzawpVar = (zzawp) listenableFuture.get(this.f32441d, TimeUnit.MILLISECONDS)) != null) {
                    zzavs zzavsVar = this.f32439b;
                    synchronized (zzavsVar) {
                        zzaxc zzaxcVarD0 = zzawpVar.D0();
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).r0(zzaxcVarD0);
                        long jA0 = zzawpVar.A0();
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).Z(jA0);
                    }
                }
            } catch (Throwable th) {
                this.f32440c.c();
                throw th;
            }
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException e2) {
            this.f32440c.b(e2);
        }
        this.f32440c.c();
        return null;
    }
}
