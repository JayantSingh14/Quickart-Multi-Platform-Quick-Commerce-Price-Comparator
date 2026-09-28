package com.google.android.gms.internal.auth;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzga<T> implements zzgi<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f36370k = new int[0];

    /* renamed from: l, reason: collision with root package name */
    public static final Unsafe f36371l = zzhj.e();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f36372a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f36373b;

    /* renamed from: c, reason: collision with root package name */
    public final int f36374c;

    /* renamed from: d, reason: collision with root package name */
    public final int f36375d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhs f36376e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f36377f;

    /* renamed from: g, reason: collision with root package name */
    public final int f36378g;

    /* renamed from: h, reason: collision with root package name */
    public final int f36379h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfl f36380i;

    /* renamed from: j, reason: collision with root package name */
    public final zzgz f36381j;

    public zzga(int[] iArr, Object[] objArr, int i2, int i3, zzhs zzhsVar, int[] iArr2, int i4, int i5, zzfl zzflVar, zzgz zzgzVar) {
        this.f36372a = iArr;
        this.f36373b = objArr;
        this.f36374c = i2;
        this.f36375d = i3;
        this.f36377f = iArr2;
        this.f36378g = i4;
        this.f36379h = i5;
        this.f36380i = zzflVar;
        this.f36381j = zzgzVar;
        this.f36376e = zzhsVar;
    }

    public static boolean k(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).f();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0388  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.auth.zzga n(com.google.android.gms.internal.auth.zzfu r32, com.google.android.gms.internal.auth.zzfl r33, com.google.android.gms.internal.auth.zzgz r34) {
        /*
            Method dump skipped, instructions count: 1017
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.n(com.google.android.gms.internal.auth.zzfu, com.google.android.gms.internal.auth.zzfl, com.google.android.gms.internal.auth.zzgz):com.google.android.gms.internal.auth.zzga");
    }

    public static int o(zzev zzevVar, long j2) {
        return ((Integer) zzhj.d(zzevVar, j2)).intValue();
    }

    public static int q(int i2) {
        return (i2 >>> 20) & 255;
    }

    public static Field w(Class cls, String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = k(r10)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r10 instanceof com.google.android.gms.internal.auth.zzev
            r1 = 0
            if (r0 == 0) goto L17
            r0 = r10
            com.google.android.gms.internal.auth.zzev r0 = (com.google.android.gms.internal.auth.zzev) r0
            r0.e()
            r0.zza = r1
            r0.c()
        L17:
            int[] r0 = r9.f36372a
            int r2 = r0.length
            r3 = r1
        L1b:
            if (r3 >= r2) goto L7d
            int r4 = r9.r(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            int r4 = q(r4)
            long r5 = (long) r5
            r7 = 9
            if (r4 == r7) goto L67
            r7 = 60
            if (r4 == r7) goto L51
            r7 = 68
            if (r4 == r7) goto L51
            switch(r4) {
                case 17: goto L67;
                case 18: goto L4b;
                case 19: goto L4b;
                case 20: goto L4b;
                case 21: goto L4b;
                case 22: goto L4b;
                case 23: goto L4b;
                case 24: goto L4b;
                case 25: goto L4b;
                case 26: goto L4b;
                case 27: goto L4b;
                case 28: goto L4b;
                case 29: goto L4b;
                case 30: goto L4b;
                case 31: goto L4b;
                case 32: goto L4b;
                case 33: goto L4b;
                case 34: goto L4b;
                case 35: goto L4b;
                case 36: goto L4b;
                case 37: goto L4b;
                case 38: goto L4b;
                case 39: goto L4b;
                case 40: goto L4b;
                case 41: goto L4b;
                case 42: goto L4b;
                case 43: goto L4b;
                case 44: goto L4b;
                case 45: goto L4b;
                case 46: goto L4b;
                case 47: goto L4b;
                case 48: goto L4b;
                case 49: goto L4b;
                case 50: goto L3a;
                default: goto L39;
            }
        L39:
            goto L7a
        L3a:
            sun.misc.Unsafe r4 = com.google.android.gms.internal.auth.zzga.f36371l
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L7a
            r8 = r7
            com.google.android.gms.internal.auth.zzfr r8 = (com.google.android.gms.internal.auth.zzfr) r8
            r8.f36367a = r1
            r4.putObject(r10, r5, r7)
            goto L7a
        L4b:
            com.google.android.gms.internal.auth.zzfl r4 = r9.f36380i
            r4.a(r5, r10)
            goto L7a
        L51:
            r4 = r0[r3]
            boolean r4 = r9.l(r4, r3, r10)
            if (r4 == 0) goto L7a
            com.google.android.gms.internal.auth.zzgi r4 = r9.t(r3)
            sun.misc.Unsafe r7 = com.google.android.gms.internal.auth.zzga.f36371l
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.a(r5)
            goto L7a
        L67:
            boolean r4 = r9.j(r3, r10)
            if (r4 == 0) goto L7a
            com.google.android.gms.internal.auth.zzgi r4 = r9.t(r3)
            sun.misc.Unsafe r7 = com.google.android.gms.internal.auth.zzga.f36371l
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.a(r5)
        L7a:
            int r3 = r3 + 3
            goto L1b
        L7d:
            com.google.android.gms.internal.auth.zzgz r0 = r9.f36381j
            r0.e(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.a(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean b(zzev zzevVar, zzev zzevVar2) {
        boolean zA;
        int[] iArr = this.f36372a;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                int iR = r(i2);
                long j2 = iR & 1048575;
                switch (q(iR)) {
                    case 0:
                        if (!i(zzevVar, zzevVar2, i2)) {
                            break;
                        } else {
                            zzhi zzhiVar = zzhj.f36426c;
                            if (Double.doubleToLongBits(zzhiVar.a(zzevVar, j2)) != Double.doubleToLongBits(zzhiVar.a(zzevVar2, j2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 1:
                        if (!i(zzevVar, zzevVar2, i2)) {
                            break;
                        } else {
                            zzhi zzhiVar2 = zzhj.f36426c;
                            if (Float.floatToIntBits(zzhiVar2.b(zzevVar, j2)) != Float.floatToIntBits(zzhiVar2.b(zzevVar2, j2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 2:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.b(zzevVar, j2) != zzhj.b(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 3:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.b(zzevVar, j2) != zzhj.b(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 4:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.a(zzevVar, j2) != zzhj.a(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 5:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.b(zzevVar, j2) != zzhj.b(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 6:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.a(zzevVar, j2) != zzhj.a(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 7:
                        if (!i(zzevVar, zzevVar2, i2)) {
                            break;
                        } else {
                            zzhi zzhiVar3 = zzhj.f36426c;
                            if (zzhiVar3.f(j2, zzevVar) != zzhiVar3.f(j2, zzevVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 8:
                        if (!i(zzevVar, zzevVar2, i2) || !zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 9:
                        if (!i(zzevVar, zzevVar2, i2) || !zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 10:
                        if (!i(zzevVar, zzevVar2, i2) || !zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 11:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.a(zzevVar, j2) != zzhj.a(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 12:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.a(zzevVar, j2) != zzhj.a(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 13:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.a(zzevVar, j2) != zzhj.a(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 14:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.b(zzevVar, j2) != zzhj.b(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 15:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.a(zzevVar, j2) != zzhj.a(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 16:
                        if (!i(zzevVar, zzevVar2, i2) || zzhj.b(zzevVar, j2) != zzhj.b(zzevVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 17:
                        if (!i(zzevVar, zzevVar2, i2) || !zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
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
                        zA = zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2));
                        break;
                    case 50:
                        zA = zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2));
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
                        long j3 = iArr[i2 + 2] & 1048575;
                        if (zzhj.a(zzevVar, j3) != zzhj.a(zzevVar2, j3) || !zzgk.a(zzhj.d(zzevVar, j2), zzhj.d(zzevVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    default:
                        i2 += 3;
                }
                if (zA) {
                    i2 += 3;
                }
            } else {
                zzgz zzgzVar = this.f36381j;
                if (zzgzVar.b(zzevVar).equals(zzgzVar.b(zzevVar2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8 A[PHI: r3
      0x00e8: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:85:0x0207, B:43:0x00e6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(com.google.android.gms.internal.auth.zzev r13) {
        /*
            Method dump skipped, instructions count: 760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.c(com.google.android.gms.internal.auth.zzev):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void d(Object obj, byte[] bArr, int i2, int i3, zzdt zzdtVar) {
        m(obj, bArr, i2, i3, 0, zzdtVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.e(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.f(java.lang.Object):boolean");
    }

    public final void g(int i2, Object obj, Object obj2) {
        f36371l.putObject(obj, r(i2) & 1048575, obj2);
        z(i2, obj);
    }

    public final void h(Object obj, int i2, int i3, Object obj2) {
        f36371l.putObject(obj, r(i3) & 1048575, obj2);
        zzhj.h(obj, i2, this.f36372a[i3 + 2] & 1048575);
    }

    public final boolean i(zzev zzevVar, zzev zzevVar2, int i2) {
        return j(i2, zzevVar) == j(i2, zzevVar2);
    }

    public final boolean j(int i2, Object obj) {
        int i3 = this.f36372a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int iR = r(i2);
            long j3 = iR & 1048575;
            switch (q(iR)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzhj.f36426c.a(obj, j3)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzhj.f36426c.b(obj, j3)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzhj.b(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzhj.b(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzhj.a(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzhj.b(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzhj.a(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzhj.f36426c.f(j3, obj);
                case 8:
                    Object objD = zzhj.d(obj, j3);
                    if (objD instanceof String) {
                        if (((String) objD).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objD instanceof zzef)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzef.f36336b.equals(objD)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (zzhj.d(obj, j3) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzef.f36336b.equals(zzhj.d(obj, j3))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzhj.a(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzhj.a(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzhj.a(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzhj.b(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzhj.a(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzhj.b(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzhj.d(obj, j3) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & zzhj.a(obj, j2)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean l(int i2, int i3, Object obj) {
        return zzhj.a(obj, (long) (this.f36372a[i3 + 2] & 1048575)) == i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0361, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03b9, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0421, code lost:
    
        throw com.google.android.gms.internal.auth.zzfb.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0539, code lost:
    
        r15 = r27 | r31;
        r11 = r41;
        r4 = r42;
        r16 = r12;
        r3 = r13;
        r6 = r14;
        r19 = r23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0399 A[PHI: r9
      0x0399: PHI (r9v37 byte) = (r9v36 byte), (r9v38 byte) binds: [B:126:0x0394, B:128:0x0398] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0c83 A[PHI: r1 r2 r6 r8 r13 r14 r15 r23 r35
      0x0c83: PHI (r1v182 int) = (r1v84 int), (r1v86 int), (r1v89 int), (r1v155 int), (r1v183 int) binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r2v128 byte[]) = (r2v71 byte[]), (r2v72 byte[]), (r2v74 byte[]), (r2v104 byte[]), (r2v129 byte[]) binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r6v72 com.google.android.gms.internal.auth.zzdt) = 
      (r6v50 com.google.android.gms.internal.auth.zzdt)
      (r6v51 com.google.android.gms.internal.auth.zzdt)
      (r6v53 com.google.android.gms.internal.auth.zzdt)
      (r6v67 com.google.android.gms.internal.auth.zzdt)
      (r6v73 com.google.android.gms.internal.auth.zzdt)
     binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r8v122 int) = (r8v93 int), (r8v94 int), (r8v96 int), (r8v115 int), (r8v123 int) binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r13v100 int) = (r13v70 int), (r13v71 int), (r13v73 int), (r13v94 int), (r13v101 int) binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r14v69 int) = (r14v55 int), (r14v56 int), (r14v58 int), (r14v65 int), (r14v70 int) binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r15v83 int) = (r15v64 int), (r15v64 int), (r15v64 int), (r15v64 int), (r15v84 int) binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r23v52 com.google.android.gms.internal.auth.zzha) = 
      (r23v30 com.google.android.gms.internal.auth.zzha)
      (r23v31 com.google.android.gms.internal.auth.zzha)
      (r23v33 com.google.android.gms.internal.auth.zzha)
      (r23v45 com.google.android.gms.internal.auth.zzha)
      (r23v53 com.google.android.gms.internal.auth.zzha)
     binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]
      0x0c83: PHI (r35v32 sun.misc.Unsafe) = 
      (r35v9 sun.misc.Unsafe)
      (r35v10 sun.misc.Unsafe)
      (r35v12 sun.misc.Unsafe)
      (r35v24 sun.misc.Unsafe)
      (r35v33 sun.misc.Unsafe)
     binds: [B:501:0x0c59, B:485:0x0bf9, B:469:0x0ba2, B:301:0x08a7, B:237:0x0725] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0f4c A[PHI: r4 r7 r13 r20 r30 r31
      0x0f4c: PHI (r4v85 int) = (r4v59 int), (r4v60 int), (r4v61 int), (r4v62 int), (r4v63 int), (r4v64 int), (r4v68 int), (r4v77 int), (r4v86 int) binds: [B:603:0x0f35, B:600:0x0f12, B:597:0x0ef3, B:594:0x0ed4, B:591:0x0eb5, B:588:0x0e95, B:562:0x0e03, B:538:0x0d75, B:528:0x0d16] A[DONT_GENERATE, DONT_INLINE]
      0x0f4c: PHI (r7v60 com.google.android.gms.internal.auth.zzha) = 
      (r7v35 com.google.android.gms.internal.auth.zzha)
      (r7v36 com.google.android.gms.internal.auth.zzha)
      (r7v37 com.google.android.gms.internal.auth.zzha)
      (r7v38 com.google.android.gms.internal.auth.zzha)
      (r7v39 com.google.android.gms.internal.auth.zzha)
      (r7v40 com.google.android.gms.internal.auth.zzha)
      (r7v45 com.google.android.gms.internal.auth.zzha)
      (r7v55 com.google.android.gms.internal.auth.zzha)
      (r7v61 com.google.android.gms.internal.auth.zzha)
     binds: [B:603:0x0f35, B:600:0x0f12, B:597:0x0ef3, B:594:0x0ed4, B:591:0x0eb5, B:588:0x0e95, B:562:0x0e03, B:538:0x0d75, B:528:0x0d16] A[DONT_GENERATE, DONT_INLINE]
      0x0f4c: PHI (r13v68 byte[]) = 
      (r13v44 byte[])
      (r13v45 byte[])
      (r13v46 byte[])
      (r13v47 byte[])
      (r13v48 byte[])
      (r13v49 byte[])
      (r13v53 byte[])
      (r13v62 byte[])
      (r13v69 byte[])
     binds: [B:603:0x0f35, B:600:0x0f12, B:597:0x0ef3, B:594:0x0ed4, B:591:0x0eb5, B:588:0x0e95, B:562:0x0e03, B:538:0x0d75, B:528:0x0d16] A[DONT_GENERATE, DONT_INLINE]
      0x0f4c: PHI (r20v31 int) = 
      (r20v12 int)
      (r20v13 int)
      (r20v14 int)
      (r20v15 int)
      (r20v16 int)
      (r20v17 int)
      (r20v20 int)
      (r20v25 int)
      (r20v32 int)
     binds: [B:603:0x0f35, B:600:0x0f12, B:597:0x0ef3, B:594:0x0ed4, B:591:0x0eb5, B:588:0x0e95, B:562:0x0e03, B:538:0x0d75, B:528:0x0d16] A[DONT_GENERATE, DONT_INLINE]
      0x0f4c: PHI (r30v19 int) = (r30v0 int), (r30v1 int), (r30v2 int), (r30v3 int), (r30v4 int), (r30v5 int), (r30v7 int), (r30v12 int), (r30v20 int) binds: [B:603:0x0f35, B:600:0x0f12, B:597:0x0ef3, B:594:0x0ed4, B:591:0x0eb5, B:588:0x0e95, B:562:0x0e03, B:538:0x0d75, B:528:0x0d16] A[DONT_GENERATE, DONT_INLINE]
      0x0f4c: PHI (r31v30 int) = (r31v5 int), (r31v6 int), (r31v7 int), (r31v8 int), (r31v9 int), (r31v10 int), (r31v14 int), (r31v23 int), (r31v31 int) binds: [B:603:0x0f35, B:600:0x0f12, B:597:0x0ef3, B:594:0x0ed4, B:591:0x0eb5, B:588:0x0e95, B:562:0x0e03, B:538:0x0d75, B:528:0x0d16] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0f4f  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0f67  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0c86 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:738:0x0c9b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0315  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(java.lang.Object r39, byte[] r40, int r41, int r42, int r43, com.google.android.gms.internal.auth.zzdt r44) {
        /*
            Method dump skipped, instructions count: 4264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.m(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
    }

    public final int p(int i2, int i3) {
        int[] iArr = this.f36372a;
        int length = (iArr.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = iArr[i5];
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

    public final int r(int i2) {
        return this.f36372a[i2 + 1];
    }

    public final zzey s(int i2) {
        int i3 = i2 / 3;
        return (zzey) this.f36373b[i3 + i3 + 1];
    }

    public final zzgi t(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        Object[] objArr = this.f36373b;
        zzgi zzgiVar = (zzgi) objArr[i4];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarA = zzgf.f36386c.a((Class) objArr[i4 + 1]);
        objArr[i4] = zzgiVarA;
        return zzgiVarA;
    }

    public final Object u(int i2, Object obj) {
        zzgi zzgiVarT = t(i2);
        int iR = r(i2) & 1048575;
        if (!j(i2, obj)) {
            return zzgiVarT.zzd();
        }
        Object object = f36371l.getObject(obj, iR);
        if (k(object)) {
            return object;
        }
        zzev zzevVarZzd = zzgiVarT.zzd();
        if (object != null) {
            zzgiVarT.e(zzevVarZzd, object);
        }
        return zzevVarZzd;
    }

    public final Object v(int i2, int i3, Object obj) {
        zzgi zzgiVarT = t(i3);
        if (!l(i2, i3, obj)) {
            return zzgiVarT.zzd();
        }
        Object object = f36371l.getObject(obj, r(i3) & 1048575);
        if (k(object)) {
            return object;
        }
        zzev zzevVarZzd = zzgiVarT.zzd();
        if (object != null) {
            zzgiVarT.e(zzevVarZzd, object);
        }
        return zzevVarZzd;
    }

    public final void x(int i2, Object obj, Object obj2) {
        if (j(i2, obj2)) {
            int iR = r(i2) & 1048575;
            Unsafe unsafe = f36371l;
            long j2 = iR;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException(b.h(this.f36372a[i2], "Source subfield ", " is present but null: ", obj2.toString()));
            }
            zzgi zzgiVarT = t(i2);
            if (!j(i2, obj)) {
                if (k(object)) {
                    zzev zzevVarZzd = zzgiVarT.zzd();
                    zzgiVarT.e(zzevVarZzd, object);
                    unsafe.putObject(obj, j2, zzevVarZzd);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                z(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!k(object2)) {
                zzev zzevVarZzd2 = zzgiVarT.zzd();
                zzgiVarT.e(zzevVarZzd2, object2);
                unsafe.putObject(obj, j2, zzevVarZzd2);
                object2 = zzevVarZzd2;
            }
            zzgiVarT.e(object2, object);
        }
    }

    public final void y(int i2, Object obj, Object obj2) {
        int[] iArr = this.f36372a;
        int i3 = iArr[i2];
        if (l(i3, i2, obj2)) {
            int iR = r(i2) & 1048575;
            Unsafe unsafe = f36371l;
            long j2 = iR;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException(b.h(iArr[i2], "Source subfield ", " is present but null: ", obj2.toString()));
            }
            zzgi zzgiVarT = t(i2);
            if (!l(i3, i2, obj)) {
                if (k(object)) {
                    zzev zzevVarZzd = zzgiVarT.zzd();
                    zzgiVarT.e(zzevVarZzd, object);
                    unsafe.putObject(obj, j2, zzevVarZzd);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                zzhj.h(obj, i3, iArr[i2 + 2] & 1048575);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!k(object2)) {
                zzev zzevVarZzd2 = zzgiVarT.zzd();
                zzgiVarT.e(zzevVarZzd2, object2);
                unsafe.putObject(obj, j2, zzevVarZzd2);
                object2 = zzevVarZzd2;
            }
            zzgiVarT.e(object2, object);
        }
    }

    public final void z(int i2, Object obj) {
        int i3 = this.f36372a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        zzhj.h(obj, (1 << (i3 >>> 20)) | zzhj.a(obj, j2), j2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final zzev zzd() {
        return (zzev) this.f36376e.g(4);
    }
}
