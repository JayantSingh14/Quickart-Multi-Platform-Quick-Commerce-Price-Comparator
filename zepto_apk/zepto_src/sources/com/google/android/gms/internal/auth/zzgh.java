package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzgh implements zzfu {

    /* renamed from: a, reason: collision with root package name */
    public final zzhs f36392a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f36393b;

    /* renamed from: c, reason: collision with root package name */
    public final int f36394c;

    public zzgh(zzhs zzhsVar, Object[] objArr) {
        this.f36392a = zzhsVar;
        this.f36393b = objArr;
        char cCharAt = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(0);
        if (cCharAt < 55296) {
            this.f36394c = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a".charAt(i4);
            if (cCharAt2 < 55296) {
                this.f36394c = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final zzfx zza() {
        return this.f36392a;
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final boolean zzb() {
        return (this.f36394c & 2) == 2;
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final int zzc() {
        return (this.f36394c & 1) != 0 ? 1 : 2;
    }
}
