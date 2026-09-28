package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzduw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzduz f28612a;

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        final zzduz zzduzVar = this.f28612a;
        zzduzVar.getClass();
        zzduzVar.f28617c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdux
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzduzVar.a();
            }
        });
    }
}
