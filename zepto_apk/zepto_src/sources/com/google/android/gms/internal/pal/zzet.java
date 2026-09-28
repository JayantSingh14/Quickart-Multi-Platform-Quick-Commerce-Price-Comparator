package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzet extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f37706h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f37707i = new Object();

    public zzet(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "Cv0JAL9ptzpRvgIi9AFTFGn0l5MhpPgpRN4VfZybymKMuiqBn9AG0bgJaX/QotAk", "/xONYRXeBwNZknPQ1yARx5KZSPQPbfL2mKAb1nbkf2s=", zzrVar, i2, 1);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        zzr zzrVar = this.f37726d;
        if (zzrVar.f37406c) {
            zzrVar.k();
            zzrVar.f37406c = false;
        }
        zzaf.k0((zzaf) zzrVar.f37405b, "E");
        if (f37706h == null) {
            synchronized (f37707i) {
                try {
                    if (f37706h == null) {
                        f37706h = (String) this.f37727e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        synchronized (this.f37726d) {
            zzr zzrVar2 = this.f37726d;
            String str = f37706h;
            if (zzrVar2.f37406c) {
                zzrVar2.k();
                zzrVar2.f37406c = false;
            }
            zzaf.k0((zzaf) zzrVar2.f37405b, str);
        }
    }
}
