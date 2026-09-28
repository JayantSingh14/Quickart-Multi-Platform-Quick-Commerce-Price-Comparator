package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class zzmh implements zzjt {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f37925c = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final zzvt f37926a;

    /* renamed from: b, reason: collision with root package name */
    public final zzjt f37927b;

    public zzmh(zzvt zzvtVar, zzjt zzjtVar) {
        this.f37926a = zzvtVar;
        this.f37927b = zzjtVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        zzvt zzvtVar = this.f37926a;
        byte[] bArrF = zzlf.b(zzvtVar).F();
        byte[] bArrZza = this.f37927b.zza(bArrF, f37925c);
        String strS = zzvtVar.s();
        byte[] bArrZza2 = ((zzjt) ((zzki) zzlf.f37912b.get()).a(zzjt.class, strS).b(zzaby.q(0, bArrF, bArrF.length))).zza(bArr, bArr2);
        int length = bArrZza.length;
        return ByteBuffer.allocate(length + 4 + bArrZza2.length).putInt(length).put(bArrZza).put(bArrZza2).array();
    }
}
