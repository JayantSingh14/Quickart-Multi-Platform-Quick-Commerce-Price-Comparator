package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzlz implements zznj {

    /* renamed from: a, reason: collision with root package name */
    public static final zzlz f37104a = new zzlz();

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        return zzme.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        if (!zzme.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzni) zzme.o(cls.asSubclass(zzme.class)).r(3);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }
}
