package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* loaded from: classes3.dex */
public final class zznr {

    @VisibleForTesting
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zznr(@NonNull Context context, int i2) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzns.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzns.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i2;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(@androidx.annotation.NonNull com.google.ads.interactivemedia.v3.internal.zzka r8, @androidx.annotation.Nullable com.google.ads.interactivemedia.v3.internal.zznx r9) throws java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zznr.zza(com.google.ads.interactivemedia.v3.internal.zzka, com.google.ads.interactivemedia.v3.internal.zznx):boolean");
    }

    @Nullable
    @VisibleForTesting
    public final zzkd zzb(int i2) throws IllegalArgumentException {
        String string = i2 == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzabn zzabnVar = zzabn.zzb;
            zzkd zzkdVarZzg = zzkd.zzg(zzabn.zzs(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZzk = zzkdVarZzg.zzk();
            File fileZzb = zzns.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzns.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzns.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists()) {
                if (fileZzb2.exists()) {
                    return zzkdVarZzg;
                }
            }
        } catch (zzacz unused) {
        }
        return null;
    }

    @Nullable
    public final zznq zzc(int i2) throws IllegalArgumentException {
        zzkd zzkdVarZzb = zzb(1);
        if (zzkdVarZzb == null) {
            return null;
        }
        String strZzk = zzkdVarZzb.zzk();
        File fileZzb = zzns.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzns.zzb(strZzk, "pcam", zzd());
        }
        return new zznq(zzkdVarZzb, fileZzb, zzns.zzb(strZzk, "pcbc", zzd()), zzns.zzb(strZzk, "pcopt", zzd()));
    }
}
