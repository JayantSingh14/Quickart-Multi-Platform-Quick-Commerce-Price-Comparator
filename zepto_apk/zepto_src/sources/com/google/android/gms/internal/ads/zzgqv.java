package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgqv implements zzgqs {

    /* renamed from: d, reason: collision with root package name */
    public static final zzgqs f33089d = null;

    /* renamed from: a, reason: collision with root package name */
    public final zzgqz f33090a = new zzgqz();

    /* renamed from: b, reason: collision with root package name */
    public volatile zzgqs f33091b;

    /* renamed from: c, reason: collision with root package name */
    public Object f33092c;

    public zzgqv(zzgqs zzgqsVar) {
        this.f33091b = zzgqsVar;
    }

    public final String toString() {
        Object objS = this.f33091b;
        if (objS == zzgqu.f33088a) {
            String strValueOf = String.valueOf(this.f33092c);
            objS = android.support.v4.media.b.s(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        }
        String strValueOf2 = String.valueOf(objS);
        return android.support.v4.media.b.s(new StringBuilder(strValueOf2.length() + 19), "Suppliers.memoize(", strValueOf2, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgqs
    public final Object zza() {
        zzgqs zzgqsVar = this.f33091b;
        zzgqu zzgquVar = zzgqu.f33088a;
        if (zzgqsVar != zzgquVar) {
            synchronized (this.f33090a) {
                try {
                    if (this.f33091b != zzgquVar) {
                        Object objZza = this.f33091b.zza();
                        this.f33092c = objZza;
                        this.f33091b = zzgquVar;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.f33092c;
    }
}
