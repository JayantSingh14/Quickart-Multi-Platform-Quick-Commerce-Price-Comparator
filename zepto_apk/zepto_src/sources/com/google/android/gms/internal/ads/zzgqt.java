package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class zzgqt implements Serializable, zzgqs {

    /* renamed from: a, reason: collision with root package name */
    public final transient zzgqz f33084a = new zzgqz();

    /* renamed from: b, reason: collision with root package name */
    public final zzgqs f33085b;

    /* renamed from: c, reason: collision with root package name */
    public volatile transient boolean f33086c;

    /* renamed from: d, reason: collision with root package name */
    public transient Object f33087d;

    public zzgqt(zzgqs zzgqsVar) {
        this.f33085b = zzgqsVar;
    }

    public final String toString() {
        Object objS;
        if (this.f33086c) {
            String strValueOf = String.valueOf(this.f33087d);
            objS = android.support.v4.media.b.s(new StringBuilder(strValueOf.length() + 25), "<supplier that returned ", strValueOf, ">");
        } else {
            objS = this.f33085b;
        }
        String string = objS.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 19), "Suppliers.memoize(", string, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgqs
    public final Object zza() {
        if (!this.f33086c) {
            synchronized (this.f33084a) {
                try {
                    if (!this.f33086c) {
                        Object objZza = this.f33085b.zza();
                        this.f33087d = objZza;
                        this.f33086c = true;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.f33087d;
    }
}
