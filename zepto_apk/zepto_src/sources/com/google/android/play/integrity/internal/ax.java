package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
public final class ax implements bb {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f42185c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile ay f42186a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f42187b;

    /* JADX WARN: Multi-variable type inference failed */
    public static ax b(ay ayVar) {
        if (ayVar instanceof ax) {
            return (ax) ayVar;
        }
        ax axVar = new ax();
        axVar.f42187b = f42185c;
        axVar.f42186a = ayVar;
        return axVar;
    }

    @Override // com.google.android.play.integrity.internal.bd
    public final Object a() {
        Object objA;
        Object obj = this.f42187b;
        Object obj2 = f42185c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objA = this.f42187b;
                if (objA == obj2) {
                    objA = this.f42186a.a();
                    Object obj3 = this.f42187b;
                    if (obj3 != obj2 && obj3 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.f42187b = objA;
                    this.f42186a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objA;
    }
}
