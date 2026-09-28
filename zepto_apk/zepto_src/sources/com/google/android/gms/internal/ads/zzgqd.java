package com.google.android.gms.internal.ads;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class zzgqd implements zzgqb {

    /* renamed from: a, reason: collision with root package name */
    public static final zzgqd f33069a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzgqd[] f33070b;

    static {
        zzgqd zzgqdVar = new zzgqd("ALWAYS_TRUE", 0);
        f33069a = zzgqdVar;
        f33070b = new zzgqd[]{zzgqdVar, new zzgqd("ALWAYS_FALSE", 1), new zzgqd("IS_NULL", 2), new zzgqd("NOT_NULL", 3)};
    }

    public static zzgqd[] values() {
        return (zzgqd[]) f33070b.clone();
    }

    @Override // java.lang.Enum
    public final /* synthetic */ String toString() {
        int iOrdinal = ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? super.toString() : "Predicates.notNull()" : "Predicates.isNull()" : "Predicates.alwaysFalse()" : "Predicates.alwaysTrue()";
    }

    @Override // com.google.android.gms.internal.ads.zzgqb
    public final /* synthetic */ boolean zza(Object obj) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return obj != null;
                }
                throw null;
            }
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
