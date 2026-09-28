package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final class zzggy implements zzgct {

    /* renamed from: a, reason: collision with root package name */
    public final zzija f32559a;

    /* renamed from: b, reason: collision with root package name */
    public final zzija f32560b;

    /* renamed from: c, reason: collision with root package name */
    public final zzija f32561c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f32562d;

    /* renamed from: e, reason: collision with root package name */
    public final long f32563e;

    public zzggy(zzija zzijaVar, zzija zzijaVar2, zzija zzijaVar3, boolean z, long j2) {
        this.f32559a = zzijaVar;
        this.f32560b = zzijaVar2;
        this.f32561c = zzijaVar3;
        this.f32562d = z;
        this.f32563e = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture a(Context context) {
        return ((zzgid) this.f32560b.zzb()).a(context);
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture b(Context context, View view, Activity activity) {
        return ((zzgid) this.f32560b.zzb()).b(context, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture c(Context context, String str, View view) {
        return ((zzgid) this.f32560b.zzb()).c(context, str, view);
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final void d(MotionEvent motionEvent) {
        ((zzgid) this.f32560b.zzb()).d(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final String zza() {
        return ((zzgid) this.f32560b.zzb()).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final ListenableFuture zzb() {
        zzgyb zzgybVar = zzgyb.f33369a;
        if (this.f32562d) {
            return (zzgye) zzgym.h((zzgye) zzgym.h((zzgye) zzgym.e(zzgye.s(((zzghq) this.f32559a.zzb()).a()), Throwable.class, zzggu.f32555a, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzggv
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return ((zzgjv) this.f32556a.f32561c.zzb()).zza();
                }
            }, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzggw
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return ((zzgid) this.f32557a.f32560b.zzb()).zzb();
                }
            }, zzgybVar);
        }
        zzgye zzgyeVar = (zzgye) zzgym.h((zzgye) zzgym.e(zzgye.s(((zzgjv) this.f32561c.zzb()).zza()), Throwable.class, zzggx.f32558a, zzgybVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzggs
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return ((zzgid) this.f32553a.f32560b.zzb()).zzb();
            }
        }, zzgybVar);
        zzgyeVar.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzggt
            @Override // java.lang.Runnable
            public final void run() {
                zzggy zzggyVar = this.f32554a;
                final zzghq zzghqVar = (zzghq) zzggyVar.f32559a.zzb();
                long j2 = zzggyVar.f32563e;
                if (j2 <= 0) {
                    zzghqVar.a();
                    return;
                }
                zzghqVar.getClass();
                zzghqVar.f32601e.a(j2, new Runnable() { // from class: com.google.android.gms.internal.ads.zzgho
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzghqVar.a();
                    }
                });
            }
        }, zzgybVar);
        return zzgyeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgct
    public final int zzg() {
        return ((zzgid) this.f32560b.zzb()).zzg();
    }
}
