package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzacu implements zzaed {

    /* renamed from: a, reason: collision with root package name */
    public static final zzacu f37403a = new zzacu();

    @Override // com.google.android.gms.internal.pal.zzaed
    public final zzaec zzb(Class cls) {
        if (!zzacz.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzaec) zzacz.l(cls.asSubclass(zzacz.class)).o(3);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaed
    public final boolean zzc(Class cls) {
        return zzacz.class.isAssignableFrom(cls);
    }
}
