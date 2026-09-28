package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* loaded from: classes4.dex */
public final class zzdfo extends zzdgi implements zzbmf {
    @Override // com.google.android.gms.internal.ads.zzbmf
    public final synchronized void p1(final String str, final String str2) {
        v0(new zzdgh() { // from class: com.google.android.gms.internal.ads.zzdfn
            @Override // com.google.android.gms.internal.ads.zzdgh
            public final /* synthetic */ void zza(Object obj) {
                ((AppEventListener) obj).y(str, str2);
            }
        });
    }
}
