package com.google.android.gms.internal.consent_sdk;

/* loaded from: classes4.dex */
public final class zzdn implements zzdr {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f36565c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile zzdo f36566a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f36567b;

    @Override // com.google.android.gms.internal.consent_sdk.zzdt
    public final Object zza() {
        Object obj = this.f36567b;
        Object obj2 = f36565c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                Object obj3 = this.f36567b;
                if (obj3 != obj2) {
                    return obj3;
                }
                Object objZza = this.f36566a.zza();
                Object obj4 = this.f36567b;
                if (obj4 != obj2 && obj4 != objZza) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + objZza + ". This is likely due to a circular dependency.");
                }
                this.f36567b = objZza;
                this.f36566a = null;
                return objZza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
