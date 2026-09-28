package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes3.dex */
public abstract class zzabn implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzabn zzb = new zzabk(zzacx.zzd);
    private static final zzabm zzd;
    private int zzc = 0;

    static {
        int i2 = zzaay.zza;
        zzd = new zzabm(null);
        zza = new zzabe();
    }

    private static zzabn zzc(Iterator it, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(b.g(i2, "length (", ") must be >= 1"));
        }
        if (i2 == 1) {
            return (zzabn) it.next();
        }
        int i3 = i2 >>> 1;
        zzabn zzabnVarZzc = zzc(it, i3);
        zzabn zzabnVarZzc2 = zzc(it, i2 - i3);
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - zzabnVarZzc.zzd() >= zzabnVarZzc2.zzd()) {
            return zzaes.zzz(zzabnVarZzc, zzabnVarZzc2);
        }
        throw new IllegalArgumentException(b.d(zzabnVarZzc.zzd(), zzabnVarZzc2.zzd(), "ByteString would be too long: ", "+"));
    }

    public static int zzp(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(b.g(i2, "Beginning index: ", " < 0"));
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException(b.d(i2, i3, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(b.d(i3, i4, "End index: ", " >= "));
    }

    public static zzabn zzs(byte[] bArr, int i2, int i3) {
        zzp(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzabk(bArr2);
    }

    public static zzabn zzt(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = inputStream.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            }
            zzabn zzabnVarZzs = i2 == 0 ? null : zzs(bArr, 0, i2);
            if (zzabnVarZzs == null) {
                break;
            }
            arrayList.add(zzabnVarZzs);
            iMin = Math.min(iMin + iMin, KEYRecord.Flags.FLAG2);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    public static void zzv(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 >= 0) {
                throw new ArrayIndexOutOfBoundsException(b.d(i2, i3, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(b.f(i2, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zzc;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zzc = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzafi.zza(this) : zzafi.zza(zzk(0, 47)).concat("...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzd);
        sb.append(" contents=\"");
        return b.r(sb, strZza, "\">");
    }

    public abstract byte zza(int i2);

    public abstract byte zzb(int i2);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i2, int i3, int i4);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i2, int i3, int i4);

    public abstract int zzj(int i2, int i3, int i4);

    public abstract zzabn zzk(int i2, int i3);

    public abstract zzabr zzl();

    public abstract String zzm(Charset charset);

    public abstract void zzn(zzabc zzabcVar) throws IOException;

    public abstract boolean zzo();

    public final int zzq() {
        return this.zzc;
    }

    @Override // java.lang.Iterable
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public zzabh iterator() {
        return new zzabd(this);
    }

    public final String zzu(Charset charset) {
        return zzd() == 0 ? "" : zzm(charset);
    }

    @Deprecated
    public final void zzw(byte[] bArr, int i2, int i3, int i4) {
        zzp(0, i4, zzd());
        zzp(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            zze(bArr, 0, i3, i4);
        }
    }

    public final byte[] zzx() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzacx.zzd;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
