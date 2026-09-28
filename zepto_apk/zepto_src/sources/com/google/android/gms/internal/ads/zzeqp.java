package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzeqp implements AppEventListener, zzddq, zzdby, zzdan, zzdbe, com.google.android.gms.ads.internal.client.zza, zzdak, zzddb, zzdba, zzdir {

    /* renamed from: i, reason: collision with root package name */
    public final zzdxe f30111i;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f30103a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f30104b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f30105c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f30106d = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference f30107e = new AtomicReference();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f30108f = new AtomicBoolean(true);

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f30109g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f30110h = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final ArrayBlockingQueue f30112j = new ArrayBlockingQueue(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.X9)).intValue());

    public zzeqp(zzdxe zzdxeVar) {
        this.f30111i = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
        this.f30108f.set(true);
        this.f30110h.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void S() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sb)).booleanValue()) {
            zzfey.a(this.f30103a, zzeqh.f30095a);
        }
        zzfey.a(this.f30107e, zzeqn.f30101a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
        zzfey.a(this.f30103a, zzeqc.f30090a);
    }

    @Override // com.google.android.gms.internal.ads.zzddb
    public final void a(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfey.a(this.f30105c, new zzfex() { // from class: com.google.android.gms.internal.ads.zzepx
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdt) obj).va(zztVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdir
    public final void a0() {
        zzfey.a(this.f30103a, zzeqg.f30094a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
        zzfey.a(this.f30103a, zzeqj.f30097a);
        zzfey.a(this.f30107e, zzeqo.f30102a);
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void c(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfey.a(this.f30107e, new zzfex() { // from class: com.google.android.gms.internal.ads.zzepz
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcv) obj).R9(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() {
        zzfey.a(this.f30103a, zzeqi.f30096a);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
        zzfey.a(this.f30103a, zzeqe.f30092a);
        AtomicReference atomicReference = this.f30107e;
        zzfey.a(atomicReference, zzeql.f30099a);
        zzfey.a(atomicReference, zzeqm.f30100a);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Sb)).booleanValue()) {
            return;
        }
        zzfey.a(this.f30103a, zzeqf.f30093a);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbk j() {
        return (com.google.android.gms.ads.internal.client.zzbk) this.f30103a.get();
    }

    public final void m(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        this.f30104b.set(zzcoVar);
        this.f30109g.set(true);
        t();
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfex zzfexVar = new zzfex() { // from class: com.google.android.gms.internal.ads.zzeqb
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).t0(zzeVar);
            }
        };
        AtomicReference atomicReference = this.f30103a;
        zzfey.a(atomicReference, zzfexVar);
        zzfey.a(atomicReference, new zzfex() { // from class: com.google.android.gms.internal.ads.zzepv
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).l(zzeVar.f21161a);
            }
        });
        zzfey.a(this.f30106d, new zzfex() { // from class: com.google.android.gms.internal.ads.zzepw
            @Override // com.google.android.gms.internal.ads.zzfex
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbn) obj).k1(zzeVar);
            }
        });
        this.f30108f.set(false);
        this.f30112j.clear();
    }

    public final void t() {
        if (this.f30109g.get() && this.f30110h.get()) {
            ArrayBlockingQueue arrayBlockingQueue = this.f30112j;
            Iterator it = arrayBlockingQueue.iterator();
            while (it.hasNext()) {
                final Pair pair = (Pair) it.next();
                zzfey.a(this.f30104b, new zzfex() { // from class: com.google.android.gms.internal.ads.zzeqa
                    @Override // com.google.android.gms.internal.ads.zzfex
                    public final /* synthetic */ void zza(Object obj) {
                        Pair pair2 = pair;
                        ((com.google.android.gms.ads.internal.client.zzco) obj).p1((String) pair2.first, (String) pair2.second);
                    }
                });
            }
            arrayBlockingQueue.clear();
            this.f30108f.set(false);
        }
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final synchronized void y(final String str, final String str2) {
        if (!this.f30108f.get()) {
            zzfey.a(this.f30104b, new zzfex() { // from class: com.google.android.gms.internal.ads.zzepy
                @Override // com.google.android.gms.internal.ads.zzfex
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzco) obj).p1(str, str2);
                }
            });
            return;
        }
        if (!this.f30112j.offer(new Pair(str, str2))) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("The queue for app events is full, dropping the new event.");
            zzdxe zzdxeVar = this.f30111i;
            if (zzdxeVar != null) {
                zzdxd zzdxdVarA = zzdxeVar.a();
                zzdxdVarA.b("action", "dae_action");
                zzdxdVarA.b("dae_name", str);
                zzdxdVarA.b("dae_data", str2);
                zzdxdVarA.c();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final synchronized void zzg() {
        zzfey.a(this.f30103a, zzeqd.f30091a);
        zzfey.a(this.f30106d, zzeqk.f30098a);
        this.f30110h.set(true);
        t();
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) {
    }
}
