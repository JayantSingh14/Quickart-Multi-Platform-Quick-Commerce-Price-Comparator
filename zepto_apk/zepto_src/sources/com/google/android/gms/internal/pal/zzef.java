package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzef extends zzfg {
    public zzef(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "w1mRpvC09hSNbQ10UvFXagm2P4TWR/T2KztJ+buPFQZnRnjxpdFVScAm9trUP6jM", "1tXSieficgPhud4YihA+CzunTIb+yA05iyb1BkAzMoc=", zzrVar, i2, 89);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        String str = (String) this.f37727e.invoke(null, null);
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.V((zzaf) zzrVar.f37405b, str);
        }
    }
}
