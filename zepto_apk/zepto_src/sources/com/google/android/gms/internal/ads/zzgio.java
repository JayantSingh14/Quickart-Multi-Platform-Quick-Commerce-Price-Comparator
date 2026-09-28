package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzgio implements zzgid {

    /* renamed from: a, reason: collision with root package name */
    public final zzfvy f32658a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgjw f32659b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgls f32660c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgnc f32661d;

    /* renamed from: e, reason: collision with root package name */
    public final ExecutorService f32662e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f32663f = new AtomicReference("2.815976881.-1");

    public zzgio(zzfvy zzfvyVar, zzgjw zzgjwVar, zzgls zzglsVar, zzgnc zzgncVar, ExecutorService executorService) {
        this.f32658a = zzfvyVar;
        this.f32659b = zzgjwVar;
        this.f32660c = zzglsVar;
        this.f32661d = zzgncVar;
        this.f32662e = executorService;
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final ListenableFuture a(final Context context) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgij
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgio zzgioVar = this.f32645a;
                zzfui zzfuiVarB = zzgioVar.f32658a.b();
                zzgnc zzgncVar = zzgioVar.f32661d;
                if (zzfuiVarB == null) {
                    zzgncVar.b(15004);
                    return "";
                }
                String strA = ((zzfvn) zzfuiVarB).a(context);
                if (strA != null) {
                    return strA;
                }
                zzgncVar.b(15006);
                return "";
            }
        }, this.f32662e);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final ListenableFuture b(final Context context, final View view, final Activity activity) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgik
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgio zzgioVar = this.f32647a;
                zzfui zzfuiVarB = zzgioVar.f32658a.b();
                zzgnc zzgncVar = zzgioVar.f32661d;
                if (zzfuiVarB == null) {
                    zzgncVar.b(15004);
                    return "";
                }
                String strB = ((zzfvn) zzfuiVarB).b(context, view, activity);
                if (strB != null) {
                    return strB;
                }
                zzgncVar.b(15007);
                return "";
            }
        }, this.f32662e);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final ListenableFuture c(final Context context, final String str, final View view) {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgil
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgio zzgioVar = this.f32651a;
                zzfui zzfuiVarB = zzgioVar.f32658a.b();
                zzgnc zzgncVar = zzgioVar.f32661d;
                if (zzfuiVarB == null) {
                    zzgncVar.b(15004);
                    return "";
                }
                String strC = ((zzfvn) zzfuiVarB).c(context, str, view, null);
                if (strC != null) {
                    return strC;
                }
                zzgncVar.b(15008);
                return "";
            }
        }, this.f32662e);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final void d(MotionEvent motionEvent) {
        zzfui zzfuiVarB = this.f32658a.b();
        zzgnc zzgncVar = this.f32661d;
        if (zzfuiVarB == null) {
            zzgncVar.b(15004);
        } else {
            if (motionEvent == null) {
                return;
            }
            try {
                ((zzfvn) zzfuiVarB).d(motionEvent);
            } catch (zzfvx e2) {
                zzgncVar.d(15005, e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final String zza() {
        return (String) this.f32663f.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final zzgye zzb() {
        zzgye zzgyeVarS = zzgye.s(this.f32659b.zzb());
        zzgin zzginVar = zzgin.f32657a;
        zzgyb zzgybVar = zzgyb.f33369a;
        return (zzgye) zzgym.i((zzgye) zzgym.i((zzgye) zzgym.h((zzgye) zzgym.i((zzgye) zzgym.e(zzgyeVarS, Throwable.class, zzginVar, zzgybVar), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgif
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                zzgcs zzgcsVar = (zzgcs) obj;
                zzgio zzgioVar = this.f32641a;
                if (zzgioVar.f32660c.a(zzgcsVar) && zzgcsVar != null) {
                    return new Boolean(true);
                }
                zzgioVar.f32661d.b(15003);
                throw new zzgie(1);
            }
        }, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzgig
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.f32642a.f32659b.zze();
            }
        }, zzgybVar), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgih
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                final zzfvo zzfvoVar = (zzfvo) obj;
                final zzgio zzgioVar = this.f32643a;
                zzgioVar.getClass();
                if (zzfvoVar == null) {
                    throw new zzgie(3);
                }
                if (Build.VERSION.SDK_INT >= 34) {
                    zzfvoVar.f31933b.setReadOnly();
                }
                zzgioVar.f32661d.f(15002, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgim
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzgio zzgioVar2 = zzgioVar;
                        zzfvy zzfvyVar = zzgioVar2.f32658a;
                        zzfvo zzfvoVar2 = zzfvoVar;
                        if (!zzfvyVar.a(zzfvoVar2)) {
                            throw new zzgie(2);
                        }
                        zzgioVar2.f32663f.set("2.815976881.".concat(String.valueOf(zzfvoVar2.f31932a.C())));
                    }
                });
                return new Boolean(true);
            }
        }, zzgybVar), zzgii.f32644a, zzgybVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgid
    public final int zzg() {
        return 3;
    }
}
