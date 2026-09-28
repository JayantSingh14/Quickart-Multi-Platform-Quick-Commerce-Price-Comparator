package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdzf implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdzp f28819a;

    public zzdzf(zzdzp zzdzpVar) {
        Objects.requireNonNull(zzdzpVar);
        this.f28819a = zzdzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        synchronized (this) {
            zzdzp zzdzpVar = this.f28819a;
            zzdzpVar.f28848c = true;
            zzdzpVar.d("com.google.android.gms.ads.MobileAds", (int) (com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzdzpVar.f28849d), "Internal Error.", false);
            zzdzpVar.f28850e.c(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        final String str = (String) obj;
        synchronized (this) {
            zzdzp zzdzpVar = this.f28819a;
            zzdzpVar.f28848c = true;
            zzdzpVar.d("com.google.android.gms.ads.MobileAds", (int) (com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - zzdzpVar.f28849d), "", true);
            zzdzpVar.f28854i.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdze
                /* JADX WARN: Removed duplicated region for block: B:70:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void run() throws org.json.JSONException {
                    /*
                        Method dump skipped, instructions count: 465
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdze.run():void");
                }
            });
        }
    }
}
