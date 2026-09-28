package com.google.android.gms.internal.ads;

import android.os.Handler;

/* loaded from: classes4.dex */
public final class zzadf {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f22796a;

    /* renamed from: b, reason: collision with root package name */
    public final zzadg f22797b;

    public zzadf(Handler handler, zzadg zzadgVar) {
        if (zzadgVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f22796a = handler;
        this.f22797b = zzadgVar;
    }

    public final void a(final zzbv zzbvVar) {
        Handler handler = this.f22796a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacz
                @Override // java.lang.Runnable
                public final void run() {
                    zzadf zzadfVar = this.f22786a;
                    zzadfVar.getClass();
                    String str = zzfj.f31254a;
                    zzjl zzjlVar = (zzjl) zzadfVar.f22797b;
                    zzjlVar.getClass();
                    final zzbv zzbvVar2 = zzbvVar;
                    zzdy zzdyVar = new zzdy() { // from class: com.google.android.gms.internal.ads.zzjj
                        @Override // com.google.android.gms.internal.ads.zzdy
                        public final /* synthetic */ void zza(Object obj) {
                            ((zzaz) obj).a(zzbvVar2);
                        }
                    };
                    zzed zzedVar = zzjlVar.f35004a.f35046m;
                    zzedVar.c(25, zzdyVar);
                    zzedVar.d();
                }
            });
        }
    }
}
