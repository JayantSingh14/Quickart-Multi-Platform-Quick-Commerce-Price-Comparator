package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class zzaec<T> implements zzaet<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzafu.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzadz zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzadn zzm;
    private final zzafk zzn;
    private final zzacc zzo;
    private final zzaef zzp;
    private final zzadu zzq;

    private zzaec(int[] iArr, Object[] objArr, int i2, int i3, zzadz zzadzVar, int i4, boolean z, int[] iArr2, int i5, int i6, zzaef zzaefVar, zzadn zzadnVar, zzafk zzafkVar, zzacc zzaccVar, zzadu zzaduVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i2;
        this.zzf = i3;
        this.zzi = zzadzVar instanceof zzacq;
        boolean z2 = false;
        if (zzaccVar != null && zzaccVar.zzj(zzadzVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i5;
        this.zzl = i6;
        this.zzp = zzaefVar;
        this.zzm = zzadnVar;
        this.zzn = zzafkVar;
        this.zzo = zzaccVar;
        this.zzg = zzadzVar;
        this.zzq = zzaduVar;
    }

    private final Object zzA(Object obj, int i2) {
        zzaet zzaetVarZzx = zzx(i2);
        int iZzu = zzu(i2) & 1048575;
        if (!zzN(obj, i2)) {
            return zzaetVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzaetVarZzx.zze();
        if (object != null) {
            zzaetVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i2, int i3) {
        zzaet zzaetVarZzx = zzx(i3);
        if (!zzR(obj, i2, i3)) {
            return zzaetVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i3) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzaetVarZzx.zze();
        if (object != null) {
            zzaetVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbV = e.v("Field ", str, " for ", name, " not found. Known fields are ");
            sbV.append(string);
            throw new RuntimeException(sbV.toString());
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i2) {
        if (zzN(obj2, i2)) {
            int iZzu = zzu(i2) & 1048575;
            Unsafe unsafe = zzb;
            long j2 = iZzu;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException(b.h(this.zzc[i2], "Source subfield ", " is present but null: ", obj2.toString()));
            }
            zzaet zzaetVarZzx = zzx(i2);
            if (!zzN(obj, i2)) {
                if (zzQ(object)) {
                    Object objZze = zzaetVarZzx.zze();
                    zzaetVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j2, objZze);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                zzH(obj, i2);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!zzQ(object2)) {
                Object objZze2 = zzaetVarZzx.zze();
                zzaetVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j2, objZze2);
                object2 = objZze2;
            }
            zzaetVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i2) {
        int i3 = this.zzc[i2];
        if (zzR(obj2, i3, i2)) {
            int iZzu = zzu(i2) & 1048575;
            Unsafe unsafe = zzb;
            long j2 = iZzu;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException(b.h(this.zzc[i2], "Source subfield ", " is present but null: ", obj2.toString()));
            }
            zzaet zzaetVarZzx = zzx(i2);
            if (!zzR(obj, i3, i2)) {
                if (zzQ(object)) {
                    Object objZze = zzaetVarZzx.zze();
                    zzaetVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j2, objZze);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                zzI(obj, i3, i2);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!zzQ(object2)) {
                Object objZze2 = zzaetVarZzx.zze();
                zzaetVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j2, objZze2);
                object2 = objZze2;
            }
            zzaetVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i2, zzael zzaelVar) throws IOException {
        long j2 = i2 & 1048575;
        if (zzM(i2)) {
            zzafu.zzs(obj, j2, zzaelVar.zzs());
        } else if (this.zzi) {
            zzafu.zzs(obj, j2, zzaelVar.zzr());
        } else {
            zzafu.zzs(obj, j2, zzaelVar.zzp());
        }
    }

    private final void zzH(Object obj, int i2) {
        int iZzr = zzr(i2);
        long j2 = 1048575 & iZzr;
        if (j2 == 1048575) {
            return;
        }
        zzafu.zzq(obj, j2, (1 << (iZzr >>> 20)) | zzafu.zzc(obj, j2));
    }

    private final void zzI(Object obj, int i2, int i3) {
        zzafu.zzq(obj, zzr(i3) & 1048575, i2);
    }

    private final void zzJ(Object obj, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzH(obj, i2);
    }

    private final void zzK(Object obj, int i2, int i3, Object obj2) {
        zzb.putObject(obj, zzu(i3) & 1048575, obj2);
        zzI(obj, i2, i3);
    }

    private final boolean zzL(Object obj, Object obj2, int i2) {
        return zzN(obj, i2) == zzN(obj2, i2);
    }

    private static boolean zzM(int i2) {
        return (i2 & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i2) {
        int iZzr = zzr(i2);
        long j2 = iZzr & 1048575;
        if (j2 != 1048575) {
            return (zzafu.zzc(obj, j2) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i2);
        long j3 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzafu.zza(obj, j3)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzafu.zzb(obj, j3)) != 0;
            case 2:
                return zzafu.zzd(obj, j3) != 0;
            case 3:
                return zzafu.zzd(obj, j3) != 0;
            case 4:
                return zzafu.zzc(obj, j3) != 0;
            case 5:
                return zzafu.zzd(obj, j3) != 0;
            case 6:
                return zzafu.zzc(obj, j3) != 0;
            case 7:
                return zzafu.zzw(obj, j3);
            case 8:
                Object objZzf = zzafu.zzf(obj, j3);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzabn) {
                    return !zzabn.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzafu.zzf(obj, j3) != null;
            case 10:
                return !zzabn.zzb.equals(zzafu.zzf(obj, j3));
            case 11:
                return zzafu.zzc(obj, j3) != 0;
            case 12:
                return zzafu.zzc(obj, j3) != 0;
            case 13:
                return zzafu.zzc(obj, j3) != 0;
            case 14:
                return zzafu.zzd(obj, j3) != 0;
            case 15:
                return zzafu.zzc(obj, j3) != 0;
            case 16:
                return zzafu.zzd(obj, j3) != 0;
            case 17:
                return zzafu.zzf(obj, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? zzN(obj, i2) : (i4 & i5) != 0;
    }

    private static boolean zzP(Object obj, int i2, zzaet zzaetVar) {
        return zzaetVar.zzl(zzafu.zzf(obj, i2 & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzacq) {
            return ((zzacq) obj).zzaO();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i2, int i3) {
        return zzafu.zzc(obj, (long) (zzr(i3) & 1048575)) == i2;
    }

    private static boolean zzS(Object obj, long j2) {
        return ((Boolean) zzafu.zzf(obj, j2)).booleanValue();
    }

    private static final void zzT(int i2, Object obj, zzagc zzagcVar) throws IOException {
        if (obj instanceof String) {
            zzagcVar.zzG(i2, (String) obj);
        } else {
            zzagcVar.zzd(i2, (zzabn) obj);
        }
    }

    public static zzafl zzd(Object obj) {
        zzacq zzacqVar = (zzacq) obj;
        zzafl zzaflVar = zzacqVar.zzc;
        if (zzaflVar != zzafl.zzc()) {
            return zzaflVar;
        }
        zzafl zzaflVarZzf = zzafl.zzf();
        zzacqVar.zzc = zzaflVarZzf;
        return zzaflVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.ads.interactivemedia.v3.internal.zzaec zzm(java.lang.Class r32, com.google.ads.interactivemedia.v3.internal.zzadw r33, com.google.ads.interactivemedia.v3.internal.zzaef r34, com.google.ads.interactivemedia.v3.internal.zzadn r35, com.google.ads.interactivemedia.v3.internal.zzafk r36, com.google.ads.interactivemedia.v3.internal.zzacc r37, com.google.ads.interactivemedia.v3.internal.zzadu r38) {
        /*
            Method dump skipped, instructions count: 1061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zzm(java.lang.Class, com.google.ads.interactivemedia.v3.internal.zzadw, com.google.ads.interactivemedia.v3.internal.zzaef, com.google.ads.interactivemedia.v3.internal.zzadn, com.google.ads.interactivemedia.v3.internal.zzafk, com.google.ads.interactivemedia.v3.internal.zzacc, com.google.ads.interactivemedia.v3.internal.zzadu):com.google.ads.interactivemedia.v3.internal.zzaec");
    }

    private static double zzn(Object obj, long j2) {
        return ((Double) zzafu.zzf(obj, j2)).doubleValue();
    }

    private static float zzo(Object obj, long j2) {
        return ((Float) zzafu.zzf(obj, j2)).floatValue();
    }

    private static int zzp(Object obj, long j2) {
        return ((Integer) zzafu.zzf(obj, j2)).intValue();
    }

    private final int zzq(int i2) {
        if (i2 < this.zze || i2 > this.zzf) {
            return -1;
        }
        return zzs(i2, 0);
    }

    private final int zzr(int i2) {
        return this.zzc[i2 + 2];
    }

    private final int zzs(int i2, int i3) {
        int length = (this.zzc.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.zzc[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i2) {
        return (i2 >>> 20) & 255;
    }

    private final int zzu(int i2) {
        return this.zzc[i2 + 1];
    }

    private static long zzv(Object obj, long j2) {
        return ((Long) zzafu.zzf(obj, j2)).longValue();
    }

    private final zzacu zzw(int i2) {
        int i3 = i2 / 3;
        return (zzacu) this.zzd[i3 + i3 + 1];
    }

    private final zzaet zzx(int i2) {
        Object[] objArr = this.zzd;
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        zzaet zzaetVar = (zzaet) objArr[i4];
        if (zzaetVar != null) {
            return zzaetVar;
        }
        zzaet zzaetVarZzb = zzaei.zza().zzb((Class) objArr[i4 + 1]);
        this.zzd[i4] = zzaetVarZzb;
        return zzaetVarZzb;
    }

    private final Object zzy(Object obj, int i2, Object obj2, zzafk zzafkVar, Object obj3) {
        int i3 = this.zzc[i2];
        Object objZzf = zzafu.zzf(obj, zzu(i2) & 1048575);
        if (objZzf == null || zzw(i2) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i2) {
        int i3 = i2 / 3;
        return this.zzd[i3 + i3];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0211  */
    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 2078
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zza(java.lang.Object):int");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final int zzb(Object obj) {
        int i2;
        long jDoubleToLongBits;
        int i3;
        int iFloatToIntBits;
        int iZzc;
        int i4;
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int iZzu = zzu(i6);
            int[] iArr = this.zzc;
            int i7 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i8 = iArr[i6];
            long j2 = i7;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i2 = i5 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzafu.zza(obj, j2));
                    byte[] bArr = zzacx.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i2 + iZzc;
                    break;
                case 1:
                    i3 = i5 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzafu.zzb(obj, j2));
                    i5 = iFloatToIntBits + i3;
                    break;
                case 2:
                    i2 = i5 * 53;
                    jDoubleToLongBits = zzafu.zzd(obj, j2);
                    byte[] bArr2 = zzacx.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i2 + iZzc;
                    break;
                case 3:
                    i2 = i5 * 53;
                    jDoubleToLongBits = zzafu.zzd(obj, j2);
                    byte[] bArr3 = zzacx.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i2 + iZzc;
                    break;
                case 4:
                    i2 = i5 * 53;
                    iZzc = zzafu.zzc(obj, j2);
                    i5 = i2 + iZzc;
                    break;
                case 5:
                    i2 = i5 * 53;
                    jDoubleToLongBits = zzafu.zzd(obj, j2);
                    byte[] bArr4 = zzacx.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i2 + iZzc;
                    break;
                case 6:
                    i2 = i5 * 53;
                    iZzc = zzafu.zzc(obj, j2);
                    i5 = i2 + iZzc;
                    break;
                case 7:
                    i3 = i5 * 53;
                    iFloatToIntBits = zzacx.zza(zzafu.zzw(obj, j2));
                    i5 = iFloatToIntBits + i3;
                    break;
                case 8:
                    i3 = i5 * 53;
                    iFloatToIntBits = ((String) zzafu.zzf(obj, j2)).hashCode();
                    i5 = iFloatToIntBits + i3;
                    break;
                case 9:
                    i4 = i5 * 53;
                    Object objZzf = zzafu.zzf(obj, j2);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i5 = i4 + iHashCode;
                    break;
                case 10:
                    i3 = i5 * 53;
                    iFloatToIntBits = zzafu.zzf(obj, j2).hashCode();
                    i5 = iFloatToIntBits + i3;
                    break;
                case 11:
                    i2 = i5 * 53;
                    iZzc = zzafu.zzc(obj, j2);
                    i5 = i2 + iZzc;
                    break;
                case 12:
                    i2 = i5 * 53;
                    iZzc = zzafu.zzc(obj, j2);
                    i5 = i2 + iZzc;
                    break;
                case 13:
                    i2 = i5 * 53;
                    iZzc = zzafu.zzc(obj, j2);
                    i5 = i2 + iZzc;
                    break;
                case 14:
                    i2 = i5 * 53;
                    jDoubleToLongBits = zzafu.zzd(obj, j2);
                    byte[] bArr5 = zzacx.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i2 + iZzc;
                    break;
                case 15:
                    i2 = i5 * 53;
                    iZzc = zzafu.zzc(obj, j2);
                    i5 = i2 + iZzc;
                    break;
                case 16:
                    i2 = i5 * 53;
                    jDoubleToLongBits = zzafu.zzd(obj, j2);
                    byte[] bArr6 = zzacx.zzd;
                    iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i5 = i2 + iZzc;
                    break;
                case 17:
                    i4 = i5 * 53;
                    Object objZzf2 = zzafu.zzf(obj, j2);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i5 = i4 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case Type.A6 /* 38 */:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case Type.DNSKEY /* 48 */:
                case 49:
                    i3 = i5 * 53;
                    iFloatToIntBits = zzafu.zzf(obj, j2).hashCode();
                    i5 = iFloatToIntBits + i3;
                    break;
                case 50:
                    i3 = i5 * 53;
                    iFloatToIntBits = zzafu.zzf(obj, j2).hashCode();
                    i5 = iFloatToIntBits + i3;
                    break;
                case 51:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j2));
                        byte[] bArr7 = zzacx.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j2));
                        i5 = iFloatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j2);
                        byte[] bArr8 = zzacx.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j2);
                        byte[] bArr9 = zzacx.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iZzc = zzp(obj, j2);
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j2);
                        byte[] bArr10 = zzacx.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case Type.RKEY /* 57 */:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iZzc = zzp(obj, j2);
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case Type.TALINK /* 58 */:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iFloatToIntBits = zzacx.zza(zzS(obj, j2));
                        i5 = iFloatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case Type.CDS /* 59 */:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iFloatToIntBits = ((String) zzafu.zzf(obj, j2)).hashCode();
                        i5 = iFloatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iFloatToIntBits = zzafu.zzf(obj, j2).hashCode();
                        i5 = iFloatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iFloatToIntBits = zzafu.zzf(obj, j2).hashCode();
                        i5 = iFloatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iZzc = zzp(obj, j2);
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iZzc = zzp(obj, j2);
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iZzc = zzp(obj, j2);
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j2);
                        byte[] bArr11 = zzacx.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        iZzc = zzp(obj, j2);
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i8, i6)) {
                        i2 = i5 * 53;
                        jDoubleToLongBits = zzv(obj, j2);
                        byte[] bArr12 = zzacx.zzd;
                        iZzc = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i5 = i2 + iZzc;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (zzR(obj, i8, i6)) {
                        i3 = i5 * 53;
                        iFloatToIntBits = zzafu.zzf(obj, j2).hashCode();
                        i5 = iFloatToIntBits + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = this.zzn.zzd(obj).hashCode() + (i5 * 53);
        return this.zzh ? (iHashCode2 * 53) + this.zzo.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.ads.interactivemedia.v3.internal.zzaaz r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zzc(java.lang.Object, byte[], int, int, int, com.google.ads.interactivemedia.v3.internal.zzaaz):int");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final Object zze() {
        return ((zzacq) this.zzg).zzaA();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = zzQ(r8)
            if (r0 != 0) goto L8
            goto L91
        L8:
            boolean r0 = r8 instanceof com.google.ads.interactivemedia.v3.internal.zzacq
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.ads.interactivemedia.v3.internal.zzacq r0 = (com.google.ads.interactivemedia.v3.internal.zzacq) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzaM(r2)
            r0.zza = r1
            r0.zzaK()
        L1b:
            int[] r0 = r7.zzc
        L1d:
            int r2 = r0.length
            if (r1 >= r2) goto L83
            int r2 = r7.zzu(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = zzt(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L80
        L3d:
            sun.misc.Unsafe r2 = com.google.ads.interactivemedia.v3.internal.zzaec.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            r6 = r5
            com.google.ads.interactivemedia.v3.internal.zzadt r6 = (com.google.ads.interactivemedia.v3.internal.zzadt) r6
            r6.zzc()
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.ads.interactivemedia.v3.internal.zzadn r2 = r7.zzm
            r2.zzb(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzR(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.ads.interactivemedia.v3.internal.zzaet r2 = r7.zzx(r1)
            sun.misc.Unsafe r5 = com.google.ads.interactivemedia.v3.internal.zzaec.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzN(r8, r1)
            if (r2 == 0) goto L80
            com.google.ads.interactivemedia.v3.internal.zzaet r2 = r7.zzx(r1)
            sun.misc.Unsafe r5 = com.google.ads.interactivemedia.v3.internal.zzaec.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzf(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.ads.interactivemedia.v3.internal.zzafk r0 = r7.zzn
            r0.zzm(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.ads.interactivemedia.v3.internal.zzacc r0 = r7.zzo
            r0.zzf(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zzf(java.lang.Object):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int iZzu = zzu(i2);
            int i3 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i4 = iArr[i2];
            long j2 = i3;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i2)) {
                        zzafu.zzo(obj, j2, zzafu.zza(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i2)) {
                        zzafu.zzp(obj, j2, zzafu.zzb(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i2)) {
                        zzafu.zzr(obj, j2, zzafu.zzd(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i2)) {
                        zzafu.zzr(obj, j2, zzafu.zzd(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i2)) {
                        zzafu.zzq(obj, j2, zzafu.zzc(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i2)) {
                        zzafu.zzr(obj, j2, zzafu.zzd(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i2)) {
                        zzafu.zzq(obj, j2, zzafu.zzc(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i2)) {
                        zzafu.zzm(obj, j2, zzafu.zzw(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i2)) {
                        zzafu.zzs(obj, j2, zzafu.zzf(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i2);
                    break;
                case 10:
                    if (zzN(obj2, i2)) {
                        zzafu.zzs(obj, j2, zzafu.zzf(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i2)) {
                        zzafu.zzq(obj, j2, zzafu.zzc(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzN(obj2, i2)) {
                        zzafu.zzq(obj, j2, zzafu.zzc(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i2)) {
                        zzafu.zzq(obj, j2, zzafu.zzc(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i2)) {
                        zzafu.zzr(obj, j2, zzafu.zzd(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i2)) {
                        zzafu.zzq(obj, j2, zzafu.zzc(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i2)) {
                        zzafu.zzr(obj, j2, zzafu.zzd(obj2, j2));
                        zzH(obj, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case Type.A6 /* 38 */:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case Type.DNSKEY /* 48 */:
                case 49:
                    this.zzm.zzc(obj, obj2, j2);
                    break;
                case 50:
                    int i5 = zzaev.zza;
                    zzafu.zzs(obj, j2, zzadu.zzb(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2)));
                    break;
                case 51:
                case Type.TLSA /* 52 */:
                case 53:
                case 54:
                case 55:
                case Type.NINFO /* 56 */:
                case Type.RKEY /* 57 */:
                case Type.TALINK /* 58 */:
                case Type.CDS /* 59 */:
                    if (zzR(obj2, i4, i2)) {
                        zzafu.zzs(obj, j2, zzafu.zzf(obj2, j2));
                        zzI(obj, i4, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case WKSRecord.Protocol.RVD /* 66 */:
                case 67:
                    if (zzR(obj2, i4, i2)) {
                        zzafu.zzs(obj, j2, zzafu.zzf(obj2, j2));
                        zzI(obj, i4, i2);
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    zzF(obj, obj2, i2);
                    break;
            }
        }
        zzaev.zzr(this.zzn, obj, obj2);
        if (this.zzh) {
            zzaev.zzq(this.zzo, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x077b A[Catch: all -> 0x07a6, TryCatch #2 {all -> 0x07a6, blocks: (B:20:0x0051, B:77:0x012c, B:184:0x0776, B:186:0x077b, B:187:0x0780, B:78:0x013e, B:79:0x0156, B:80:0x016e, B:81:0x0186, B:82:0x019e, B:84:0x01ae, B:87:0x01b5, B:88:0x01bb, B:89:0x01c9, B:90:0x01e1, B:91:0x01f5, B:92:0x020d, B:93:0x021b, B:94:0x0233, B:95:0x024b, B:96:0x0263, B:97:0x027b, B:98:0x0293, B:99:0x02ab, B:100:0x02c3, B:101:0x02db, B:103:0x02f1, B:105:0x02f7, B:107:0x0312, B:108:0x0316, B:106:0x0307, B:109:0x0317, B:110:0x032f, B:111:0x0343, B:112:0x0357, B:113:0x036b, B:114:0x037f, B:124:0x03b4, B:125:0x03c2, B:126:0x03d6, B:127:0x03ea, B:128:0x03fe, B:129:0x0412, B:130:0x0426, B:131:0x043a, B:132:0x044e, B:133:0x0462, B:134:0x0476, B:135:0x048a, B:136:0x049e, B:137:0x04b2, B:142:0x04d9, B:143:0x04e7, B:144:0x04fb, B:145:0x0513, B:147:0x051f, B:148:0x0531, B:149:0x0543, B:150:0x0557, B:151:0x056b, B:152:0x057f, B:153:0x0593, B:154:0x05a7, B:155:0x05bb, B:156:0x05cf, B:157:0x05e3, B:158:0x05fb, B:159:0x0610, B:160:0x0625, B:161:0x063a, B:162:0x064f, B:164:0x065f, B:167:0x0666, B:168:0x066c, B:169:0x0677, B:170:0x068c, B:171:0x06a1, B:172:0x06b9, B:173:0x06c7, B:174:0x06dc, B:175:0x06f1, B:176:0x0706, B:177:0x071b, B:178:0x0730, B:179:0x0745, B:180:0x075a), top: B:212:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x079f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x07b4 A[LOOP:1: B:202:0x07b0->B:204:0x07b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0786 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r18, com.google.ads.interactivemedia.v3.internal.zzael r19, com.google.ads.interactivemedia.v3.internal.zzacb r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2138
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zzh(java.lang.Object, com.google.ads.interactivemedia.v3.internal.zzael, com.google.ads.interactivemedia.v3.internal.zzacb):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final void zzi(Object obj, byte[] bArr, int i2, int i3, zzaaz zzaazVar) throws IOException {
        zzc(obj, bArr, i2, i3, 0, zzaazVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r20, com.google.ads.interactivemedia.v3.internal.zzagc r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zzj(java.lang.Object, com.google.ads.interactivemedia.v3.internal.zzagc):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzH;
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int iZzu = zzu(i2);
            long j2 = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i2) || Double.doubleToLongBits(zzafu.zza(obj, j2)) != Double.doubleToLongBits(zzafu.zza(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i2) || Float.floatToIntBits(zzafu.zzb(obj, j2)) != Float.floatToIntBits(zzafu.zzb(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i2) || zzafu.zzd(obj, j2) != zzafu.zzd(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i2) || zzafu.zzd(obj, j2) != zzafu.zzd(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i2) || zzafu.zzc(obj, j2) != zzafu.zzc(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i2) || zzafu.zzd(obj, j2) != zzafu.zzd(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i2) || zzafu.zzc(obj, j2) != zzafu.zzc(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i2) || zzafu.zzw(obj, j2) != zzafu.zzw(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i2) || !zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i2) || !zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i2) || !zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i2) || zzafu.zzc(obj, j2) != zzafu.zzc(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i2) || zzafu.zzc(obj, j2) != zzafu.zzc(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i2) || zzafu.zzc(obj, j2) != zzafu.zzc(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i2) || zzafu.zzd(obj, j2) != zzafu.zzd(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i2) || zzafu.zzc(obj, j2) != zzafu.zzc(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i2) || zzafu.zzd(obj, j2) != zzafu.zzd(obj2, j2)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i2) || !zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case Type.A6 /* 38 */:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case Type.DNSKEY /* 48 */:
                case 49:
                    zZzH = zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2));
                    break;
                case 50:
                    zZzH = zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2));
                    break;
                case 51:
                case Type.TLSA /* 52 */:
                case 53:
                case 54:
                case 55:
                case Type.NINFO /* 56 */:
                case Type.RKEY /* 57 */:
                case Type.TALINK /* 58 */:
                case Type.CDS /* 59 */:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case WKSRecord.Protocol.RVD /* 66 */:
                case 67:
                case WKSRecord.Service.BOOTPC /* 68 */:
                    long jZzr = zzr(i2) & 1048575;
                    if (zzafu.zzc(obj, jZzr) != zzafu.zzc(obj2, jZzr) || !zzaev.zzH(zzafu.zzf(obj, j2), zzafu.zzf(obj2, j2))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zZzH) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Override // com.google.ads.interactivemedia.v3.internal.zzaet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzl(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaec.zzl(java.lang.Object):boolean");
    }
}
