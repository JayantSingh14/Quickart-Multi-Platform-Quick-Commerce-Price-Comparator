package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzcv extends zzcp {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // com.google.android.gms.internal.ads.zzco
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcv.b(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl e(zzcl zzclVar) throws zzcn {
        int i2 = zzclVar.f26487c;
        if (i2 != 3) {
            if (i2 == 2) {
                return zzcl.f26484e;
            }
            if (i2 != 268435456 && i2 != 21 && i2 != 1342177280 && i2 != 22 && i2 != 1610612736 && i2 != 4) {
                throw new zzcn("Unhandled input format:", zzclVar);
            }
        }
        return new zzcl(zzclVar.f26485a, zzclVar.f26486b, 2);
    }
}
