package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class zzabr {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzabs zzc;

    public /* synthetic */ zzabr(zzabq zzabqVar) {
    }

    public static int zzs(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long zzt(long j2) {
        return (j2 >>> 1) ^ (-(1 & j2));
    }

    public static zzabr zzu(byte[] bArr, int i2, int i3, boolean z) {
        zzabp zzabpVar = new zzabp(bArr, i2, i3, z, null);
        try {
            zzabpVar.zzc(i3);
            return zzabpVar;
        } catch (zzacz e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int zzb();

    public abstract int zzc(int i2) throws zzacz;

    public abstract int zzf() throws IOException;

    public abstract zzabn zzj() throws IOException;

    public abstract String zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract void zzm(int i2) throws zzacz;

    public abstract void zzn(int i2);

    public abstract boolean zzp() throws IOException;

    public abstract boolean zzq() throws IOException;

    public abstract boolean zzr(int i2) throws IOException;
}
