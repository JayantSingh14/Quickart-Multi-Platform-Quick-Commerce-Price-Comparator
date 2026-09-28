package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
final class zzglv implements zzgls {

    /* renamed from: a, reason: collision with root package name */
    public final zzgnc f32879a;

    /* renamed from: b, reason: collision with root package name */
    public final long f32880b;

    public zzglv(zzgnc zzgncVar, long j2) {
        this.f32879a = zzgncVar;
        this.f32880b = j2;
    }

    public static boolean c(zzgcs zzgcsVar) {
        int iC = zzgcsVar.D().C().C();
        int iD = zzgcsVar.D().C().D();
        byte[] versionArray = zzatg.a();
        Intrinsics.checkNotNullParameter(versionArray, "versionArray");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(6);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putShort((short) iC);
        byteBufferAllocate.putInt(iD);
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return Arrays.equals(bArrArray, versionArray);
    }

    @Override // com.google.android.gms.internal.ads.zzgls
    public final boolean a(zzgcs zzgcsVar) {
        zzgnc zzgncVar = this.f32879a;
        if (zzgcsVar == null || zzgcsVar.equals(zzgcs.H())) {
            zzgncVar.b(20204);
            return false;
        }
        if (c(zzgcsVar)) {
            return true;
        }
        zzgncVar.b(20206);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgls
    public final boolean b(zzgcs zzgcsVar) {
        zzgnc zzgncVar = this.f32879a;
        if (zzgcsVar == null || zzgcsVar.equals(zzgcs.H())) {
            zzgncVar.b(20202);
            return true;
        }
        if (!c(zzgcsVar)) {
            zzgncVar.b(20205);
            return true;
        }
        boolean z = zzgcsVar.D().E() - System.currentTimeMillis() <= this.f32880b;
        if (z) {
            zzgncVar.b(20203);
        }
        return z;
    }
}
