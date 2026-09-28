package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcrx implements zzbck, zzdbf, com.google.android.gms.ads.internal.overlay.zzr, zzdbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzcrs f27011a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcrt f27012b;

    /* renamed from: d, reason: collision with root package name */
    public final zzbsr f27014d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f27015e;

    /* renamed from: f, reason: collision with root package name */
    public final Clock f27016f;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f27013c = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f27017g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public final zzcrw f27018h = new zzcrw();

    /* renamed from: i, reason: collision with root package name */
    public boolean f27019i = false;

    /* renamed from: j, reason: collision with root package name */
    public WeakReference f27020j = new WeakReference(this);

    public zzcrx(zzbso zzbsoVar, zzcrt zzcrtVar, Executor executor, zzcrs zzcrsVar, Clock clock) {
        this.f27011a = zzcrsVar;
        zzbrz zzbrzVar = zzbsc.f25504a;
        zzbsoVar.a();
        this.f27014d = new zzbsr(zzbsoVar.f25529b);
        this.f27012b = zzcrtVar;
        this.f27015e = executor;
        this.f27016f = clock;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final synchronized void P(Context context) {
        this.f27018h.f27007b = true;
        b();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final synchronized void S(Context context) {
        this.f27018h.f27007b = false;
        b();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final synchronized void a(Context context) {
        this.f27018h.f27009d = "u";
        b();
        c();
        this.f27019i = true;
    }

    public final synchronized void b() {
        try {
            if (this.f27020j.get() == null) {
                synchronized (this) {
                    c();
                    this.f27019i = true;
                }
                return;
            }
            if (this.f27019i || !this.f27017g.get()) {
                return;
            }
            try {
                zzcrw zzcrwVar = this.f27018h;
                zzcrwVar.f27008c = this.f27016f.elapsedRealtime();
                final JSONObject jSONObjectA = this.f27012b.zzb(zzcrwVar);
                Iterator it = this.f27013c.iterator();
                while (it.hasNext()) {
                    final zzcir zzcirVar = (zzcir) it.next();
                    this.f27015e.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            JSONObject jSONObject = jSONObjectA;
                            String string = jSONObject.toString();
                            String strS = android.support.v4.media.b.s(new StringBuilder(string.length() + 31), "Calling AFMA_updateActiveView(", string, ")");
                            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.a(strS);
                            zzcirVar.f("AFMA_updateActiveView", jSONObject);
                        }
                    });
                }
                zzbsr zzbsrVar = this.f27014d;
                zzbsrVar.getClass();
                zzcdr.b(zzgym.h(zzbsrVar.f25533a, new zzbsq(zzbsrVar, jSONObjectA), zzcdo.f25988g), "ActiveViewListener.callActiveViewJs");
                return;
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zze.l("Failed to call ActiveViewJS", e2);
                return;
            }
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    public final void c() {
        Iterator it = this.f27013c.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            final String str = "/untrackActiveViewUnit";
            final String str2 = "/updateActiveView";
            zzcrs zzcrsVar = this.f27011a;
            if (!zHasNext) {
                final zzbnn zzbnnVar = zzcrsVar.f26997e;
                zzbso zzbsoVar = zzcrsVar.f26994b;
                ListenableFuture listenableFuture = zzbsoVar.f25529b;
                zzgpr zzgprVar = new zzgpr() { // from class: com.google.android.gms.internal.ads.zzbsm
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj) {
                        zzbrs zzbrsVar = (zzbrs) obj;
                        zzbrsVar.x0(str2, zzbnnVar);
                        return zzbrsVar;
                    }
                };
                zzgyw zzgywVar = zzcdo.f25988g;
                ListenableFuture listenableFutureI = zzgym.i(listenableFuture, zzgprVar, zzgywVar);
                zzbsoVar.f25529b = listenableFutureI;
                final zzbnn zzbnnVar2 = zzcrsVar.f26998f;
                zzbsoVar.f25529b = zzgym.i(listenableFutureI, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzbsm
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj) {
                        zzbrs zzbrsVar = (zzbrs) obj;
                        zzbrsVar.x0(str, zzbnnVar2);
                        return zzbrsVar;
                    }
                }, zzgywVar);
                return;
            }
            zzcir zzcirVar = (zzcir) it.next();
            zzcirVar.h0("/updateActiveView", zzcrsVar.f26997e);
            zzcirVar.h0("/untrackActiveViewUnit", zzcrsVar.f26998f);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void d9() {
        this.f27018h.f27007b = false;
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final synchronized void f() {
        if (this.f27017g.compareAndSet(false, true)) {
            zzcrs zzcrsVar = this.f27011a;
            final zzbnn zzbnnVar = zzcrsVar.f26997e;
            zzbso zzbsoVar = zzcrsVar.f26994b;
            final String str = "/updateActiveView";
            zzbsoVar.a();
            ListenableFuture listenableFuture = zzbsoVar.f25529b;
            zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzbsl
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    zzbrs zzbrsVar = (zzbrs) obj;
                    zzbrsVar.A0(str, zzbnnVar);
                    return zzgym.a(zzbrsVar);
                }
            };
            zzgyw zzgywVar = zzcdo.f25988g;
            zzbsoVar.f25529b = zzgym.h(listenableFuture, zzgxuVar, zzgywVar);
            final zzbnn zzbnnVar2 = zzcrsVar.f26998f;
            final String str2 = "/untrackActiveViewUnit";
            zzbsoVar.a();
            zzbsoVar.f25529b = zzgym.h(zzbsoVar.f25529b, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzbsl
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    zzbrs zzbrsVar = (zzbrs) obj;
                    zzbrsVar.A0(str2, zzbnnVar2);
                    return zzgym.a(zzbrsVar);
                }
            }, zzgywVar);
            zzcrsVar.f26996d = this;
            b();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void i5() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final synchronized void u0(zzbcj zzbcjVar) {
        zzcrw zzcrwVar = this.f27018h;
        zzcrwVar.f27006a = zzbcjVar.f24707j;
        zzcrwVar.f27010e = zzbcjVar;
        b();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void w8() {
        this.f27018h.f27007b = true;
        b();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
    }
}
