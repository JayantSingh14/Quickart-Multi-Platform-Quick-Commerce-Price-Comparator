package com.google.android.gms.internal.ads;

import libcore.io.Memory;

/* loaded from: classes4.dex */
final class zzidk extends zzidl {
    @Override // com.google.android.gms.internal.ads.zzidl
    public final void a(Object obj, long j2, byte b2) {
        if (zzidm.f34774h) {
            zzidm.c(obj, j2, b2);
        } else {
            zzidm.d(obj, j2, b2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final boolean b(long j2, Object obj) {
        return zzidm.f34774h ? zzidm.p(j2, obj) : zzidm.q(j2, obj);
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final void c(Object obj, long j2, boolean z) {
        if (zzidm.f34774h) {
            zzidm.c(obj, j2, z ? (byte) 1 : (byte) 0);
        } else {
            zzidm.d(obj, j2, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final float d(long j2, Object obj) {
        return Float.intBitsToFloat(this.f34766a.getInt(obj, j2));
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final void e(Object obj, long j2, float f2) {
        this.f34766a.putInt(obj, j2, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final double f(long j2, Object obj) {
        return Double.longBitsToDouble(this.f34766a.getLong(obj, j2));
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final void g(Object obj, long j2, double d2) {
        this.f34766a.putLong(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final byte h(long j2) {
        return Memory.peekByte(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzidl
    public final void i(long j2, byte[] bArr, long j3, long j4) {
        Memory.peekByteArray(j2, bArr, (int) j3, (int) j4);
    }
}
