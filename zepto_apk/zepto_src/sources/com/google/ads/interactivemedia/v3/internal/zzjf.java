package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjf extends zzjv {
    private final zzhz zzi;

    public zzjf(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, zzhz zzhzVar) {
        super(zzihVar, "QcEEfK1PwFv2Eb+NZQ+4kWKAUUVvycYqoBzmAjBexJV/sKEjaFlajeD5MAZYWXy5", "361aY1ErIwpwsXwpamiiDSCpkl/IcdBM93dd8sW9a/Y=", zzafVar, i2, 94);
        this.zzi = zzhzVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zzf.invoke(null, this.zzi.zza())).intValue();
        synchronized (this.zze) {
            this.zze.zzae(zzat.zza(iIntValue));
        }
    }
}
