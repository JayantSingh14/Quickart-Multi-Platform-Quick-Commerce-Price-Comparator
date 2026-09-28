package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zziak implements zzica {

    /* renamed from: a, reason: collision with root package name */
    public static final zziak f34636a = new zziak();

    @Override // com.google.android.gms.internal.ads.zzica
    public final boolean zzb(Class cls) {
        return zziar.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzica
    public final zzibz zzc(Class cls) {
        if (!zziar.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzibz) zziar.w(cls.asSubclass(zziar.class)).y(zziaq.f34642c, null);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }
}
