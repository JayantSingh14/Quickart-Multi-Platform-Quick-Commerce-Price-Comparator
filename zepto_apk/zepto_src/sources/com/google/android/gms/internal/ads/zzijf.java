package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzijf implements zzijp, zzija {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f34895c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile zzijp f34896a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f34897b = f34895c;

    public zzijf(zzijp zzijpVar) {
        this.f34896a = zzijpVar;
    }

    public static zzijf a(zzijp zzijpVar) {
        return zzijpVar instanceof zzijf ? (zzijf) zzijpVar : new zzijf(zzijpVar);
    }

    public static zzija b(zzijp zzijpVar) {
        if (zzijpVar instanceof zzija) {
            return (zzija) zzijpVar;
        }
        zzijpVar.getClass();
        return new zzijf(zzijpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Object obj = this.f34897b;
        Object obj2 = f34895c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                Object obj3 = this.f34897b;
                if (obj3 != obj2) {
                    return obj3;
                }
                Object objZzb = this.f34896a.zzb();
                Object obj4 = this.f34897b;
                if (obj4 != obj2 && obj4 != objZzb) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + objZzb + ". This is likely due to a circular dependency.");
                }
                this.f34897b = objZzb;
                this.f34896a = null;
                return objZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
