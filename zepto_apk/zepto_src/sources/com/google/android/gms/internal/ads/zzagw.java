package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
final class zzagw implements zzadz {

    /* renamed from: a, reason: collision with root package name */
    public final zzafb f23061a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23062b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaev f23063c = new zzaev();

    public /* synthetic */ zzagw(zzafb zzafbVar, int i2) {
        this.f23061a = zzafbVar;
        this.f23062b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final zzady a(zzaef zzaefVar, long j2) throws EOFException, InterruptedIOException {
        long j3 = zzaefVar.f22872d;
        long jB = b(zzaefVar);
        long jZzm = zzaefVar.zzm();
        zzaefVar.f(Math.max(6, this.f23061a.f22906c), false);
        long jB2 = b(zzaefVar);
        return (jB > j2 || jB2 <= j2) ? jB2 <= j2 ? new zzady(jB2, zzaefVar.zzm(), -2) : new zzady(jB, j3, -1) : new zzady(-9223372036854775807L, jZzm, 0);
    }

    public final long b(zzaef zzaefVar) throws EOFException, InterruptedIOException {
        long j2;
        zzaev zzaevVar;
        zzafb zzafbVar;
        long j3;
        int iE;
        while (true) {
            long jZzm = zzaefVar.zzm();
            j2 = zzaefVar.f22871c;
            long j4 = j2 - 6;
            zzaevVar = this.f23063c;
            zzafbVar = this.f23061a;
            if (jZzm >= j4) {
                j3 = -6;
                break;
            }
            long jZzm2 = zzaefVar.zzm();
            zzer zzerVar = new zzer(17);
            zzaefVar.t(zzerVar.f30144a, 0, 2, false);
            char cR = zzerVar.r(0, ByteOrder.BIG_ENDIAN);
            int i2 = this.f23062b;
            if (cR != i2) {
                zzaefVar.f22874f = 0;
                zzaefVar.f((int) (jZzm2 - zzaefVar.f22872d), false);
            } else {
                byte[] bArr = zzerVar.f30144a;
                int i3 = 0;
                j3 = -6;
                while (i3 < 15 && (iE = zzaefVar.e(2 + i3, bArr, 15 - i3)) != -1) {
                    i3 += iE;
                }
                zzerVar.C(i3 + 2);
                zzaefVar.f22874f = 0;
                zzaefVar.f((int) (jZzm2 - zzaefVar.f22872d), false);
                if (zzaew.a(zzerVar, zzafbVar, i2, zzaevVar)) {
                    break;
                }
            }
            zzaefVar.f(1, false);
        }
        if (zzaefVar.zzm() < j2 + j3) {
            return zzaevVar.f22898a;
        }
        zzaefVar.f((int) (j2 - zzaefVar.zzm()), false);
        return zzafbVar.f22913j;
    }
}
