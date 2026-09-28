package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class zzny {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zznh zze;
    private boolean zzf;

    public zzny(@NonNull Context context, @NonNull int i2, @NonNull zznh zznhVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i2 - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zznhVar;
        this.zzf = z;
    }

    private final File zze(@NonNull String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(@NonNull zzka zzkaVar) {
        zzkc zzkcVarZzd = zzkd.zzd();
        zzkcVarZzd.zze(zzkaVar.zzc().zzk());
        zzkcVarZzd.zza(zzkaVar.zzc().zzi());
        zzkcVarZzd.zzb(zzkaVar.zzc().zza());
        zzkcVarZzd.zzd(zzkaVar.zzc().zzc());
        zzkcVarZzd.zzc(zzkaVar.zzc().zzb());
        return Hex.bytesToStringLowercase(((zzkd) zzkcVarZzd.zzan()).zzav());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i2, long j2) {
        this.zze.zza(i2, j2);
    }

    private final void zzj(int i2, long j2, String str) {
        this.zze.zzb(i2, j2, str);
    }

    @Nullable
    private final zzkd zzk(int i2) {
        String string = i2 == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzabn zzabnVar = zzabn.zzb;
            return zzkd.zzh(zzabn.zzs(bArrStringToBytes, 0, bArrStringToBytes.length), this.zzf ? zzacb.zza() : zzacb.zzb());
        } catch (zzacz unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(@NonNull zzka zzkaVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                if (!zzns.zze(new File(zze(zzkaVar.zzc().zzk()), "pcbc"), zzkaVar.zzd().zzx())) {
                    zzi(4020, jCurrentTimeMillis);
                    return false;
                }
                String strZzf = zzf(zzkaVar);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                boolean zCommit = editorEdit.commit();
                if (zCommit) {
                    zzi(5015, jCurrentTimeMillis);
                } else {
                    zzi(4021, jCurrentTimeMillis);
                }
                return zCommit;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(@NonNull zzka zzkaVar, @Nullable zznx zznxVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzkd zzkdVarZzk = zzk(1);
                String strZzk = zzkaVar.zzc().zzk();
                if (zzkdVarZzk != null && zzkdVarZzk.zzk().equals(strZzk)) {
                    zzi(4014, jCurrentTimeMillis);
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File fileZze = zze(strZzk);
                if (fileZze.exists()) {
                    zzj(4023, jCurrentTimeMillis2, "d:" + (true != fileZze.isDirectory() ? "0" : "1") + ",f:" + (true != fileZze.isFile() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                } else if (!fileZze.mkdirs()) {
                    zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                    zzi(4015, jCurrentTimeMillis2);
                    return false;
                }
                File fileZze2 = zze(strZzk);
                File file = new File(fileZze2, "pcam.jar");
                File file2 = new File(fileZze2, "pcbc");
                if (!zzns.zze(file, zzkaVar.zze().zzx())) {
                    zzi(4016, jCurrentTimeMillis);
                    return false;
                }
                if (!zzns.zze(file2, zzkaVar.zzd().zzx())) {
                    zzi(4017, jCurrentTimeMillis);
                    return false;
                }
                if (zznxVar != null && !zznxVar.zza(file)) {
                    zzi(4018, jCurrentTimeMillis);
                    zzns.zzd(fileZze2);
                    return false;
                }
                String strZzf = zzf(zzkaVar);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                String string = this.zzc.getString(zzh(), null);
                SharedPreferences.Editor editorEdit = this.zzc.edit();
                editorEdit.putString(zzh(), strZzf);
                if (string != null) {
                    editorEdit.putString(zzg(), string);
                }
                if (!editorEdit.commit()) {
                    zzi(4019, jCurrentTimeMillis3);
                    return false;
                }
                HashSet hashSet = new HashSet();
                zzkd zzkdVarZzk2 = zzk(1);
                if (zzkdVarZzk2 != null) {
                    hashSet.add(zzkdVarZzk2.zzk());
                }
                zzkd zzkdVarZzk3 = zzk(2);
                if (zzkdVarZzk3 != null) {
                    hashSet.add(zzkdVarZzk3.zzk());
                }
                for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                    if (!hashSet.contains(file3.getName())) {
                        zzns.zzd(file3);
                    }
                }
                zzi(5014, jCurrentTimeMillis);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final zznq zzc(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzkd zzkdVarZzk = zzk(1);
                if (zzkdVarZzk == null) {
                    zzi(4022, jCurrentTimeMillis);
                    return null;
                }
                File fileZze = zze(zzkdVarZzk.zzk());
                File file = new File(fileZze, "pcam.jar");
                if (!file.exists()) {
                    file = new File(fileZze, "pcam");
                }
                File file2 = new File(fileZze, "pcbc");
                File file3 = new File(fileZze, "pcopt");
                zzi(5016, jCurrentTimeMillis);
                return new zznq(zzkdVarZzk, file, file2, file3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzd(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            try {
                zzkd zzkdVarZzk = zzk(1);
                if (zzkdVarZzk == null) {
                    zzi(4025, jCurrentTimeMillis);
                    return false;
                }
                File fileZze = zze(zzkdVarZzk.zzk());
                if (!new File(fileZze, "pcam.jar").exists()) {
                    zzi(4026, jCurrentTimeMillis);
                    return false;
                }
                if (new File(fileZze, "pcbc").exists()) {
                    zzi(5019, jCurrentTimeMillis);
                    return true;
                }
                zzi(4027, jCurrentTimeMillis);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
