package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class zzabw extends zzabc {
    private static final Logger zzb = Logger.getLogger(zzabw.class.getName());
    private static final boolean zzc = zzafu.zzx();
    zzabx zza;

    private zzabw() {
    }

    @Deprecated
    public static int zzt(int i2, zzadz zzadzVar, zzaet zzaetVar) {
        int iZzw = zzw(i2 << 3);
        return ((zzaav) zzadzVar).zzat(zzaetVar) + iZzw + iZzw;
    }

    public static int zzu(zzadz zzadzVar, zzaet zzaetVar) {
        int iZzat = ((zzaav) zzadzVar).zzat(zzaetVar);
        return zzw(iZzat) + iZzat;
    }

    public static int zzv(String str) {
        int length;
        try {
            length = zzafz.zze(str);
        } catch (zzafy unused) {
            length = str.getBytes(zzacx.zzb).length;
        }
        return zzw(length) + length;
    }

    public static int zzw(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public static int zzx(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    public static zzabw zzy(byte[] bArr, int i2, int i3) {
        return new zzabt(bArr, 0, i3);
    }

    public final void zzA(String str, zzafy zzafyVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzafyVar);
        byte[] bytes = str.getBytes(zzacx.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzabu(e2);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b2) throws IOException;

    public abstract void zzd(int i2, boolean z) throws IOException;

    public abstract void zze(int i2, zzabn zzabnVar) throws IOException;

    public abstract void zzf(int i2, int i3) throws IOException;

    public abstract void zzg(int i2) throws IOException;

    public abstract void zzh(int i2, long j2) throws IOException;

    public abstract void zzi(long j2) throws IOException;

    public abstract void zzj(int i2, int i3) throws IOException;

    public abstract void zzk(int i2) throws IOException;

    public abstract void zzl(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void zzm(int i2, String str) throws IOException;

    public abstract void zzo(int i2, int i3) throws IOException;

    public abstract void zzp(int i2, int i3) throws IOException;

    public abstract void zzq(int i2) throws IOException;

    public abstract void zzr(int i2, long j2) throws IOException;

    public abstract void zzs(long j2) throws IOException;

    public final void zzz() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public /* synthetic */ zzabw(zzabv zzabvVar) {
    }
}
