package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjs extends zzjv {
    private final View zzi;

    public zzjs(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, View view) {
        super(zzihVar, "fHaUCxrr3fcbpdQPVJw6OSoHeHoizr6wmxmAsnLvDUhuNG2u8ebKX4VPxAoXSx4W", "K/sgHSTVeE1LLZ4HP+m5KF6ND+k7W4ID3M3VTul8bAI=", zzafVar, i2, 57);
        this.zzi = view;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzkq.zzc().zza(zzlg.zzdn);
            Boolean bool2 = (Boolean) zzkq.zzc().zza(zzlg.zzkD);
            zzil zzilVar = new zzil((String) this.zzf.invoke(null, this.zzi, this.zzb.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzba zzbaVarZza = zzbb.zza();
            zzbaVarZza.zzb(zzilVar.zza.longValue());
            zzbaVarZza.zzd(zzilVar.zzb.longValue());
            zzbaVarZza.zze(zzilVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzbaVarZza.zzc(zzilVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzbaVarZza.zza(zzilVar.zzd.longValue());
            }
            this.zze.zzY((zzbb) zzbaVarZza.zzan());
        }
    }
}
