package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
final class zzgdj implements zzgct {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f32315a;

    /* renamed from: b, reason: collision with root package name */
    public final zzija f32316b;

    /* renamed from: c, reason: collision with root package name */
    public final zzija f32317c;

    /* renamed from: d, reason: collision with root package name */
    public final zzglx f32318d;

    /* renamed from: e, reason: collision with root package name */
    public final zzija f32319e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijv f32320f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgad f32321g;

    public zzgdj(ExecutorService executorService, zzija zzijaVar, zzija zzijaVar2, zzglx zzglxVar, zzija zzijaVar3, zzijv zzijvVar, zzgad zzgadVar) {
        this.f32315a = executorService;
        this.f32316b = zzijaVar;
        this.f32317c = zzijaVar2;
        this.f32318d = zzglxVar;
        this.f32319e = zzijaVar3;
        this.f32320f = zzijvVar;
        this.f32321g = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture a(Context context) {
        zzgdz zzgdzVarA = ((zzgdz) ((zzgao) this.f32320f).zzb()).a(context);
        ((zzgas) zzgdzVarA).f32187g = this.f32318d.a();
        zzgas zzgasVar = (zzgas) zzgdzVarA;
        zzgasVar.c(zzawp.F0());
        zzgasVar.f32189i = zzgba.f32197a;
        return ((zzgat) zzgasVar.b()).a().a();
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture b(Context context, View view, Activity activity) {
        zzgdz zzgdzVarA = ((zzgdz) ((zzgao) this.f32320f).zzb()).a(context);
        ((zzgas) zzgdzVarA).f32184d = view;
        zzgas zzgasVar = (zzgas) zzgdzVarA;
        zzgasVar.f32185e = activity;
        zzgasVar.f32186f = true != this.f32321g.L() ? "" : null;
        zzgasVar.f32187g = this.f32318d.b(context, view);
        zzgasVar.c(zzawp.F0());
        zzgasVar.f32189i = zzgba.f32198b;
        return ((zzgat) zzgasVar.b()).a().a();
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture c(Context context, String str, View view) {
        zzija zzijaVar = this.f32319e;
        HashMap mapC = this.f32318d.c();
        zzgdr zzgdrVar = (zzgdr) zzijaVar.zzb();
        synchronized (zzgdrVar) {
            try {
                MotionEvent motionEvent = zzgdrVar.f32344b;
                if (motionEvent != null) {
                    mapC.put("nv", motionEvent);
                }
                mapC.put("oe", zzgdrVar.f32345c);
                ArrayDeque arrayDeque = zzgdrVar.f32343a;
                mapC.put("ro", arrayDeque.toArray(new zzgdq[arrayDeque.size()]));
                zzgdrVar.f32345c = new zzgdp();
                arrayDeque.clear();
                MotionEvent motionEvent2 = zzgdrVar.f32344b;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                    zzgdrVar.f32344b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzgdz zzgdzVarA = ((zzgdz) ((zzgao) this.f32320f).zzb()).a(context);
        ((zzgas) zzgdzVarA).f32184d = view;
        zzgas zzgasVar = (zzgas) zzgdzVarA;
        zzgasVar.f32185e = null;
        zzgasVar.f32186f = str;
        zzgasVar.f32187g = mapC;
        zzgasVar.f32189i = zzgba.f32199c;
        zzgasVar.c(zzawp.F0());
        return ((zzgat) zzgasVar.b()).a().a();
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final void d(MotionEvent motionEvent) {
        if (motionEvent != null) {
            zzgdr zzgdrVar = (zzgdr) this.f32319e.zzb();
            synchronized (zzgdrVar) {
                try {
                    if (motionEvent.getAction() == 1) {
                        zzgdrVar.f32344b = MotionEvent.obtain(motionEvent);
                    }
                    zzgdrVar.f32345c.a(motionEvent);
                    ArrayDeque arrayDeque = zzgdrVar.f32343a;
                    if (arrayDeque.size() >= 6) {
                        arrayDeque.remove();
                    }
                    arrayDeque.add(new zzgdq(motionEvent));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final String zza() {
        return "1.815976881";
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture zzb() {
        return zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgdi
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgdj zzgdjVar = this.f32314a;
                ((zzgec) zzgdjVar.f32317c.zzb()).a();
                ((zzgev) zzgdjVar.f32316b.zzb()).zza();
                return null;
            }
        }, this.f32315a);
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final int zzg() {
        return 2;
    }
}
