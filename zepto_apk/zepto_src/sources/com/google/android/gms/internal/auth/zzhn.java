package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzhn {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhm f36430a;

    static {
        if (zzhj.f36428e && zzhj.f36427d) {
            int i2 = zzds.f36325a;
        }
        f36430a = new zzhm();
    }

    public static /* bridge */ /* synthetic */ int a(int i2, byte[] bArr, int i3) {
        int i4 = i3 - i2;
        byte b2 = bArr[i2 - 1];
        if (i4 == 0) {
            if (b2 > -12) {
                return -1;
            }
            return b2;
        }
        if (i4 == 1) {
            byte b3 = bArr[i2];
            if (b2 > -12 || b3 > -65) {
                return -1;
            }
            return (b3 << 8) ^ b2;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        byte b4 = bArr[i2];
        byte b5 = bArr[i2 + 1];
        if (b2 > -12 || b4 > -65 || b5 > -65) {
            return -1;
        }
        return (b5 << 16) ^ ((b4 << 8) ^ b2);
    }
}
