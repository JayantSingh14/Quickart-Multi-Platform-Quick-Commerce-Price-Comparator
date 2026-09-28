package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
final class zzabx implements zzagc {
    private final zzabw zza;

    private zzabx(zzabw zzabwVar) {
        byte[] bArr = zzacx.zzd;
        this.zza = zzabwVar;
        zzabwVar.zza = this;
    }

    public static zzabx zza(zzabw zzabwVar) {
        zzabx zzabxVar = zzabwVar.zza;
        return zzabxVar != null ? zzabxVar : new zzabx(zzabwVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzA(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzh(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzi(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzB(int i2, int i3) throws IOException {
        this.zza.zzp(i2, (i3 >> 31) ^ (i3 + i3));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzC(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzabw zzabwVar = this.zza;
                int iIntValue = ((Integer) list.get(i3)).intValue();
                zzabwVar.zzp(i2, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzw = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue2 = ((Integer) list.get(i4)).intValue();
            iZzw += zzabw.zzw((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzq(iZzw);
        while (i3 < list.size()) {
            zzabw zzabwVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i3)).intValue();
            zzabwVar2.zzq((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzD(int i2, long j2) throws IOException {
        this.zza.zzr(i2, (j2 >> 63) ^ (j2 + j2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzE(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                zzabw zzabwVar = this.zza;
                long jLongValue = ((Long) list.get(i3)).longValue();
                zzabwVar.zzr(i2, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzx = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long jLongValue2 = ((Long) list.get(i4)).longValue();
            iZzx += zzabw.zzx((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzq(iZzx);
        while (i3 < list.size()) {
            zzabw zzabwVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i3)).longValue();
            zzabwVar2.zzs((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    @Deprecated
    public final void zzF(int i2) throws IOException {
        this.zza.zzo(i2, 3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzG(int i2, String str) throws IOException {
        this.zza.zzm(i2, str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzH(int i2, List list) throws IOException {
        int i3 = 0;
        if (!(list instanceof zzadh)) {
            while (i3 < list.size()) {
                this.zza.zzm(i2, (String) list.get(i3));
                i3++;
            }
            return;
        }
        zzadh zzadhVar = (zzadh) list;
        while (i3 < list.size()) {
            Object objZzf = zzadhVar.zzf(i3);
            if (objZzf instanceof String) {
                this.zza.zzm(i2, (String) objZzf);
            } else {
                this.zza.zze(i2, (zzabn) objZzf);
            }
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzI(int i2, int i3) throws IOException {
        this.zza.zzp(i2, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzJ(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzp(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzw = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzw += zzabw.zzw(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzq(iZzw);
        while (i3 < list.size()) {
            this.zza.zzq(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzK(int i2, long j2) throws IOException {
        this.zza.zzr(i2, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzL(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzr(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzx = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzx += zzabw.zzx(((Long) list.get(i4)).longValue());
        }
        this.zza.zzq(iZzx);
        while (i3 < list.size()) {
            this.zza.zzs(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzb(int i2, boolean z) throws IOException {
        this.zza.zzd(i2, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzc(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzd(i2, ((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Boolean) list.get(i5)).getClass();
            i4++;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzd(int i2, zzabn zzabnVar) throws IOException {
        this.zza.zze(i2, zzabnVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zze(int i2, List list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zza.zze(i2, (zzabn) list.get(i3));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzf(int i2, double d2) throws IOException {
        this.zza.zzh(i2, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzg(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzh(i2, Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Double) list.get(i5)).getClass();
            i4 += 8;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    @Deprecated
    public final void zzh(int i2) throws IOException {
        this.zza.zzo(i2, 4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzi(int i2, int i3) throws IOException {
        this.zza.zzj(i2, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzj(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzj(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzx = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzx += zzabw.zzx(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzq(iZzx);
        while (i3 < list.size()) {
            this.zza.zzk(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzk(int i2, int i3) throws IOException {
        this.zza.zzf(i2, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzl(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzf(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            i4 += 4;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzg(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzm(int i2, long j2) throws IOException {
        this.zza.zzh(i2, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzn(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzh(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Long) list.get(i5)).getClass();
            i4 += 8;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzi(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzo(int i2, float f2) throws IOException {
        this.zza.zzf(i2, Float.floatToRawIntBits(f2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzp(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzf(i2, Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Float) list.get(i5)).getClass();
            i4 += 4;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzq(int i2, Object obj, zzaet zzaetVar) throws IOException {
        zzabw zzabwVar = this.zza;
        zzabwVar.zzo(i2, 3);
        zzaetVar.zzj((zzadz) obj, zzabwVar.zza);
        zzabwVar.zzo(i2, 4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzr(int i2, int i3) throws IOException {
        this.zza.zzj(i2, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzs(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzj(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzx = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzx += zzabw.zzx(((Integer) list.get(i4)).intValue());
        }
        this.zza.zzq(iZzx);
        while (i3 < list.size()) {
            this.zza.zzk(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzt(int i2, long j2) throws IOException {
        this.zza.zzr(i2, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzu(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzr(i2, ((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int iZzx = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZzx += zzabw.zzx(((Long) list.get(i4)).longValue());
        }
        this.zza.zzq(iZzx);
        while (i3 < list.size()) {
            this.zza.zzs(((Long) list.get(i3)).longValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzv(int i2, Object obj, zzaet zzaetVar) throws IOException {
        zzadz zzadzVar = (zzadz) obj;
        zzabt zzabtVar = (zzabt) this.zza;
        zzabtVar.zzq((i2 << 3) | 2);
        zzabtVar.zzq(((zzaav) zzadzVar).zzat(zzaetVar));
        zzaetVar.zzj(zzadzVar, zzabtVar.zza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzw(int i2, Object obj) throws IOException {
        if (obj instanceof zzabn) {
            zzabt zzabtVar = (zzabt) this.zza;
            zzabtVar.zzq(11);
            zzabtVar.zzp(2, i2);
            zzabtVar.zze(3, (zzabn) obj);
            zzabtVar.zzq(12);
            return;
        }
        zzabw zzabwVar = this.zza;
        zzadz zzadzVar = (zzadz) obj;
        zzabt zzabtVar2 = (zzabt) zzabwVar;
        zzabtVar2.zzq(11);
        zzabtVar2.zzp(2, i2);
        zzabtVar2.zzq(26);
        zzabtVar2.zzq(zzadzVar.zzax());
        zzadzVar.zzaR(zzabwVar);
        zzabtVar2.zzq(12);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzx(int i2, int i3) throws IOException {
        this.zza.zzf(i2, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzy(int i2, List list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.zza.zzf(i2, ((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        this.zza.zzo(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((Integer) list.get(i5)).getClass();
            i4 += 4;
        }
        this.zza.zzq(i4);
        while (i3 < list.size()) {
            this.zza.zzg(((Integer) list.get(i3)).intValue());
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzagc
    public final void zzz(int i2, long j2) throws IOException {
        this.zza.zzh(i2, j2);
    }
}
