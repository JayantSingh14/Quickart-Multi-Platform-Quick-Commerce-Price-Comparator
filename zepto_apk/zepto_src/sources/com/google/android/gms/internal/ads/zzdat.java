package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzdat extends zzdgi implements zzdao {
    @Override // com.google.android.gms.internal.ads.zzdao
    public final void j(final zzdlg zzdlgVar) {
        v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdaq
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                zzdba zzdbaVar = (zzdba) obj;
                String message = zzdlgVar.getMessage();
                if (message == null) {
                    message = "Internal show error.";
                }
                zzdbaVar.c(zzfjm.d(12, message, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void k1(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdas
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                ((zzdba) obj).c(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdao
    public final void zze() {
        v0(zzdar.f27567a);
    }
}
