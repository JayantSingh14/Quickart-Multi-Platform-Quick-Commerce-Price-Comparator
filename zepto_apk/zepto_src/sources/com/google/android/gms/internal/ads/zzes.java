package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzes {

    /* renamed from: c, reason: collision with root package name */
    public static final zzes f30200c = new zzes(-1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f30201a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30202b;

    static {
        new zzes(0, 0);
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzes(int i2, int i3) {
        boolean z = false;
        if ((i2 == -1 || i2 >= 0) && (i3 == -1 || i3 >= 0)) {
            z = true;
        }
        zzgqa.a(z);
        this.f30201a = i2;
        this.f30202b = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzes) {
            zzes zzesVar = (zzes) obj;
            if (this.f30201a == zzesVar.f30201a && this.f30202b == zzesVar.f30202b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f30201a;
        return ((i2 >>> 16) | (i2 << 16)) ^ this.f30202b;
    }

    public final String toString() {
        int i2 = this.f30201a;
        int length = String.valueOf(i2).length();
        int i3 = this.f30202b;
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(i3).length());
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        return sb.toString();
    }
}
