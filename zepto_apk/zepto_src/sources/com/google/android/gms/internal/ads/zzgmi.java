package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzgmi implements zzglz, zzgcb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32909a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgnc f32910b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f32911c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgad f32912d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f32913e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public ListenableFuture f32914f = zzgyq.f33377b;

    public zzgmi(Context context, zzgad zzgadVar, zzgnc zzgncVar, zzgyw zzgywVar) {
        this.f32909a = context;
        this.f32910b = zzgncVar;
        this.f32911c = zzgywVar;
        this.f32912d = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void a(HashMap map, Context context, View view) {
        map.put("gs", this.f32914f);
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void b(HashMap map) {
        map.put("gs", this.f32914f);
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void c(HashMap map) {
        map.put("gs", this.f32914f);
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final ListenableFuture zza() {
        if (this.f32913e.getAndSet(true) || !this.f32912d.J()) {
            return zzgyq.f33377b;
        }
        return this.f32911c.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgmh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                final zzgmi zzgmiVar = this.f32908a;
                zzgmiVar.getClass();
                ListenableFuture listenableFutureSubmit = zzgmiVar.f32911c.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzgmg
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        Context context = zzgmiVar.f32909a;
                        try {
                            return zzfum.a(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
                        } catch (Throwable unused) {
                            return null;
                        }
                    }
                });
                zzgmiVar.f32910b.e(53, listenableFutureSubmit);
                zzgmiVar.f32914f = listenableFutureSubmit;
            }
        });
    }
}
