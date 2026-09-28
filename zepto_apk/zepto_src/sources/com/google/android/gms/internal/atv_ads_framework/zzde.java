package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzde implements zzem {

    /* renamed from: a, reason: collision with root package name */
    public static final zzde f36119a = new zzde();

    @Override // com.google.android.gms.internal.atv_ads_framework.zzem
    public final zzel zzb(Class cls) {
        if (!zzdh.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzel) zzdh.f(cls.asSubclass(zzdh.class)).d(3);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzem
    public final boolean zzc(Class cls) {
        return zzdh.class.isAssignableFrom(cls);
    }
}
