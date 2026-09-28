package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
final class zzaqg {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f24153a = {0, 0, 0, 0, 16, 0, -128, 0, 0, -86, 0, 56, -101, 113};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f24154b = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean a(zzaef zzaefVar) {
        zzer zzerVar = new zzer(8);
        int i2 = zzaqf.a(zzaefVar, zzerVar).f24151a;
        if (i2 != 1380533830 && i2 != 1380333108) {
            return false;
        }
        zzaefVar.t(zzerVar.f30144a, 0, 4, false);
        zzerVar.E(0);
        int iB = zzerVar.b();
        if (iB == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iB).length() + 23);
        sb.append("Unsupported form type: ");
        sb.append(iB);
        zzee.e("WavHeaderReader", sb.toString());
        return false;
    }

    public static zzaqf b(int i2, zzaef zzaefVar, zzer zzerVar) throws zzat, EOFException, InterruptedIOException {
        zzaqf zzaqfVarA = zzaqf.a(zzaefVar, zzerVar);
        while (true) {
            int i3 = zzaqfVarA.f24151a;
            if (i3 == i2) {
                return zzaqfVarA;
            }
            b.d(new StringBuilder(String.valueOf(i3).length() + 28), "Ignoring unknown WAV chunk: ", i3, "WavHeaderReader");
            long j2 = zzaqfVarA.f24152b;
            long j3 = 8 + j2;
            if ((1 & j2) != 0) {
                j3 = 9 + j2;
            }
            if (j3 > TTL.MAX_VALUE) {
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 40);
                sb.append("Chunk is too large (~2GB+) to skip; id: ");
                sb.append(i3);
                throw zzat.b(sb.toString());
            }
            zzaefVar.d((int) j3, false);
            zzaqfVarA = zzaqf.a(zzaefVar, zzerVar);
        }
    }
}
