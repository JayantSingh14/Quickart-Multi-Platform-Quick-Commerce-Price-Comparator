package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
public final class zzxk extends zzaaq {
    private static final Reader zzb = new zzxj();
    private static final Object zzc = new Object();
    private Object[] zzd;
    private int zze;
    private String[] zzf;
    private int[] zzg;

    public zzxk(zzuc zzucVar) {
        super(zzb);
        this.zzd = new Object[32];
        this.zze = 0;
        this.zzf = new String[32];
        this.zzg = new int[32];
        zzD(zzucVar);
    }

    private final String zzA(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (true) {
            int i3 = this.zze;
            if (i2 >= i3) {
                return sb.toString();
            }
            Object[] objArr = this.zzd;
            Object obj = objArr[i2];
            if (obj instanceof zzua) {
                i2++;
                if (i2 < i3 && (objArr[i2] instanceof Iterator)) {
                    int i4 = this.zzg[i2];
                    if (z && i4 > 0 && (i2 == i3 - 1 || i2 == i3 - 2)) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                }
            } else if ((obj instanceof zzuf) && (i2 = i2 + 1) < i3 && (objArr[i2] instanceof Iterator)) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.zzf[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
            i2++;
        }
    }

    private final String zzB() {
        return " at path ".concat(zzA(false));
    }

    private final String zzC(boolean z) throws IOException {
        zzE(5);
        Map.Entry entry = (Map.Entry) ((Iterator) zzy()).next();
        String str = (String) entry.getKey();
        this.zzf[this.zze - 1] = true != z ? str : "<skipped>";
        zzD(entry.getValue());
        return str;
    }

    private final void zzD(Object obj) {
        int i2 = this.zze;
        Object[] objArr = this.zzd;
        if (i2 == objArr.length) {
            int i3 = i2 + i2;
            this.zzd = Arrays.copyOf(objArr, i3);
            this.zzg = Arrays.copyOf(this.zzg, i3);
            this.zzf = (String[]) Arrays.copyOf(this.zzf, i3);
        }
        Object[] objArr2 = this.zzd;
        int i4 = this.zze;
        this.zze = i4 + 1;
        objArr2[i4] = obj;
    }

    private final void zzE(int i2) throws IOException {
        if (zzr() == i2) {
            return;
        }
        throw new IllegalStateException("Expected " + zzaar.zza(i2) + " but was " + zzaar.zza(zzr()) + zzB());
    }

    private final Object zzy() {
        return this.zzd[this.zze - 1];
    }

    private final Object zzz() {
        Object[] objArr = this.zzd;
        int i2 = this.zze - 1;
        this.zze = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzd = new Object[]{zzc};
        this.zze = 1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final String toString() {
        return "zzxk".concat(zzB());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final double zza() throws IOException {
        int iZzr = zzr();
        if (iZzr != 7 && iZzr != 6) {
            throw new IllegalStateException("Expected NUMBER but was " + zzaar.zza(iZzr) + zzB());
        }
        double dZza = ((zzuh) zzy()).zza();
        if (!zzx() && (Double.isNaN(dZza) || Double.isInfinite(dZza))) {
            throw new zzaat("JSON forbids NaN and infinities: " + dZza);
        }
        zzz();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return dZza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final int zzb() throws IOException {
        int iZzr = zzr();
        if (iZzr != 7 && iZzr != 6) {
            throw new IllegalStateException("Expected NUMBER but was " + zzaar.zza(iZzr) + zzB());
        }
        int iZzb = ((zzuh) zzy()).zzb();
        zzz();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return iZzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final long zzc() throws IOException {
        int iZzr = zzr();
        if (iZzr != 7 && iZzr != 6) {
            throw new IllegalStateException("Expected NUMBER but was " + zzaar.zza(iZzr) + zzB());
        }
        long jZzc = ((zzuh) zzy()).zzc();
        zzz();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return jZzc;
    }

    public final zzuc zzd() throws IOException {
        int iZzr = zzr();
        if (iZzr != 5 && iZzr != 2 && iZzr != 4 && iZzr != 10) {
            zzuc zzucVar = (zzuc) zzy();
            zzo();
            return zzucVar;
        }
        throw new IllegalStateException("Unexpected " + zzaar.zza(iZzr) + " when reading a JsonElement.");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final String zze() {
        return zzA(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final String zzf() {
        return zzA(true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final String zzg() throws IOException {
        return zzC(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final String zzh() throws IOException {
        int iZzr = zzr();
        if (iZzr != 6 && iZzr != 7) {
            throw new IllegalStateException("Expected STRING but was " + zzaar.zza(iZzr) + zzB());
        }
        String strZze = ((zzuh) zzz()).zze();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return strZze;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final void zzi() throws IOException {
        zzE(1);
        zzD(((zzua) zzy()).iterator());
        this.zzg[this.zze - 1] = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final void zzj() throws IOException {
        zzE(3);
        zzD(((zzuf) zzy()).zza().iterator());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final void zzk() throws IOException {
        zzE(2);
        zzz();
        zzz();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final void zzl() throws IOException {
        zzE(4);
        this.zzf[this.zze - 1] = null;
        zzz();
        zzz();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final void zzm() throws IOException {
        zzE(9);
        zzz();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void zzn() throws IOException {
        zzE(5);
        Map.Entry entry = (Map.Entry) ((Iterator) zzy()).next();
        zzD(entry.getValue());
        zzD(new zzuh((String) entry.getKey()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final void zzo() throws IOException {
        int iZzr = zzr() - 1;
        if (iZzr == 1) {
            zzk();
            return;
        }
        if (iZzr != 9) {
            if (iZzr == 3) {
                zzl();
                return;
            }
            if (iZzr == 4) {
                zzC(true);
                return;
            }
            zzz();
            int i2 = this.zze;
            if (i2 > 0) {
                int[] iArr = this.zzg;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final boolean zzp() throws IOException {
        int iZzr = zzr();
        return (iZzr == 4 || iZzr == 2 || iZzr == 10) ? false : true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final boolean zzq() throws IOException {
        zzE(8);
        boolean zZzh = ((zzuh) zzz()).zzh();
        int i2 = this.zze;
        if (i2 > 0) {
            int[] iArr = this.zzg;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return zZzh;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaaq
    public final int zzr() throws IOException {
        if (this.zze == 0) {
            return 10;
        }
        Object objZzy = zzy();
        if (objZzy instanceof Iterator) {
            boolean z = this.zzd[this.zze - 2] instanceof zzuf;
            Iterator it = (Iterator) objZzy;
            if (!it.hasNext()) {
                return z ? 4 : 2;
            }
            if (z) {
                return 5;
            }
            zzD(it.next());
            return zzr();
        }
        if (objZzy instanceof zzuf) {
            return 3;
        }
        if (objZzy instanceof zzua) {
            return 1;
        }
        if (!(objZzy instanceof zzuh)) {
            if (objZzy instanceof zzue) {
                return 9;
            }
            if (objZzy == zzc) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new zzaat(b.D("Custom JsonElement subclass ", objZzy.getClass().getName(), " is not supported"));
        }
        zzuh zzuhVar = (zzuh) objZzy;
        if (zzuhVar.zzk()) {
            return 6;
        }
        if (zzuhVar.zzi()) {
            return 8;
        }
        if (zzuhVar.zzj()) {
            return 7;
        }
        throw new AssertionError();
    }
}
