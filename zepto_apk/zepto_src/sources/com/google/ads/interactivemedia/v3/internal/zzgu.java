package com.google.ads.interactivemedia.v3.internal;

import java.io.File;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
final class zzgu implements zznx {
    final /* synthetic */ zzmj zza;

    public zzgu(zzgw zzgwVar, zzmj zzmjVar) {
        this.zza = zzmjVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zznx
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
