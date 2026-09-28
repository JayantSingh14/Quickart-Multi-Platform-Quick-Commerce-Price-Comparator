package com.google.ads.interactivemedia.v3.internal;

import java.util.Objects;
import java.util.concurrent.Future;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
abstract class zzrx extends zzsd {
    private static final zzsz zza = new zzsz(zzrx.class);

    @CheckForNull
    private zzqb zzd;

    public zzrx(zzqb zzqbVar, boolean z, boolean z2) {
        super(zzqbVar.size());
        this.zzd = zzqbVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    @CheckForNull
    public final String zza() {
        zzqb zzqbVar = this.zzd;
        return zzqbVar != null ? "futures=".concat(zzqbVar.toString()) : super.zza();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final void zzb() {
        zzqb zzqbVar = this.zzd;
        zzr(1);
        if ((zzqbVar != null) && isCancelled()) {
            boolean zZzo = zzo();
            zzrm zzrmVarListIterator = ((zzqf) zzqbVar).listIterator(0);
            while (zzrmVarListIterator.hasNext()) {
                ((Future) zzrmVarListIterator.next()).cancel(zZzo);
            }
        }
    }

    public abstract void zzp();

    public final void zzq() {
        Objects.requireNonNull(this.zzd);
        if (this.zzd.isEmpty()) {
            zzp();
            return;
        }
        final zzqb zzqbVar = null;
        Runnable runnable = new Runnable(zzqbVar) { // from class: com.google.ads.interactivemedia.v3.internal.zzrw
            @Override // java.lang.Runnable
            public final void run() {
                zzrx zzrxVar = this.zza;
                int iZzt = zzrxVar.zzt();
                zzpd.zzg(iZzt >= 0, "Less than 0 remaining futures");
                if (iZzt == 0) {
                    zzrxVar.zzv();
                    zzrxVar.zzp();
                    zzrxVar.zzr(2);
                }
            }
        };
        zzrm zzrmVarListIterator = ((zzqf) this.zzd).listIterator(0);
        while (zzrmVarListIterator.hasNext()) {
            ((zzta) zzrmVarListIterator.next()).zzm(runnable, zzsh.INSTANCE);
        }
    }

    public void zzr(int i2) {
        this.zzd = null;
    }
}
