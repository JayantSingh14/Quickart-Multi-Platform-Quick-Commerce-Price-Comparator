package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzes implements zzfv {

    /* renamed from: a, reason: collision with root package name */
    public static final zzes f36350a = new zzes();

    @Override // com.google.android.gms.internal.auth.zzfv
    public final zzfu zzb(Class cls) {
        if (!zzev.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzfu) zzev.a(cls.asSubclass(zzev.class)).g(3);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final boolean zzc(Class cls) {
        return zzev.class.isAssignableFrom(cls);
    }
}
