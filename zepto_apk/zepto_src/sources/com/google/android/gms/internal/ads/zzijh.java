package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzijh implements zzijg, zzija {

    /* renamed from: b, reason: collision with root package name */
    public static final zzijh f34898b = new zzijh(null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f34899a;

    public zzijh(Object obj) {
        this.f34899a = obj;
    }

    public static zzijh a(Object obj) {
        if (obj != null) {
            return new zzijh(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    public static zzijh b(Object obj) {
        return obj == null ? f34898b : new zzijh(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return this.f34899a;
    }
}
