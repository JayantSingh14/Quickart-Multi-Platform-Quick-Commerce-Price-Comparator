package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzada implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzadf f22788a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f22789b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f22790c;

    public /* synthetic */ zzada(zzadf zzadfVar, Object obj, long j2) {
        this.f22788a = zzadfVar;
        this.f22789b = obj;
        this.f22790c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzadf zzadfVar = this.f22788a;
        zzadfVar.getClass();
        String str = zzfj.f31254a;
        zzkp zzkpVar = ((zzjl) zzadfVar.f22797b).f35004a;
        zzoz zzozVar = zzkpVar.r;
        final zzmv zzmvVarO = zzozVar.o();
        final Object obj = this.f22789b;
        final long j2 = this.f22790c;
        zzozVar.k(zzmvVarO, 26, new zzdy(zzmvVarO, obj, j2) { // from class: com.google.android.gms.internal.ads.zznl

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f35248a;

            {
                this.f35248a = obj;
            }

            @Override // com.google.android.gms.internal.ads.zzdy
            public final /* synthetic */ void zza(Object obj2) {
                ((zzmx) obj2).zzo();
            }
        });
        if (zzkpVar.L == obj) {
            zzjk zzjkVar = zzjk.f35003a;
            zzed zzedVar = zzkpVar.f35046m;
            zzedVar.c(26, zzjkVar);
            zzedVar.d();
        }
    }
}
