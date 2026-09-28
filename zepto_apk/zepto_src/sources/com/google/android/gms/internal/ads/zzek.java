package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzek implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzel f29519a;

    public /* synthetic */ zzek(zzel zzelVar) {
        this.f29519a = zzelVar;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        zzel zzelVar = this.f29519a;
        zzej zzejVar = (zzej) zzelVar.f29595a.get();
        if (zzejVar != null) {
            zzejVar.zza(zzelVar.f29597c.b());
        }
    }
}
