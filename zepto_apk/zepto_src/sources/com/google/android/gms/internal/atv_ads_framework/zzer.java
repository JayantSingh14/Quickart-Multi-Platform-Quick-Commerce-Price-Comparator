package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzer<T> implements zzey<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f36154k = new int[0];

    /* renamed from: l, reason: collision with root package name */
    public static final Unsafe f36155l = zzfz.h();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f36156a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f36157b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdh f36158c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f36159d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f36160e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f36161f;

    /* renamed from: g, reason: collision with root package name */
    public final int f36162g;

    /* renamed from: h, reason: collision with root package name */
    public final zzec f36163h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfp f36164i;

    /* renamed from: j, reason: collision with root package name */
    public final zzcy f36165j;

    public zzer(int[] iArr, Object[] objArr, zzdh zzdhVar, boolean z, int[] iArr2, int i2, zzec zzecVar, zzfp zzfpVar, zzcy zzcyVar) {
        this.f36156a = iArr;
        this.f36157b = objArr;
        this.f36160e = z;
        boolean z2 = false;
        if (zzcyVar != null && zzcyVar.c(zzdhVar)) {
            z2 = true;
        }
        this.f36159d = z2;
        this.f36161f = iArr2;
        this.f36162g = i2;
        this.f36163h = zzecVar;
        this.f36164i = zzfpVar;
        this.f36165j = zzcyVar;
        this.f36158c = zzdhVar;
    }

    public static boolean i(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzdh) {
            return ((zzdh) obj).b();
        }
        return true;
    }

    public static final void k(int i2, Object obj, zzgg zzggVar) {
        if (obj instanceof String) {
            zzggVar.G(i2, (String) obj);
        } else {
            zzggVar.D(i2, (zzcn) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0378  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.atv_ads_framework.zzer l(com.google.android.gms.internal.atv_ads_framework.zzel r30, com.google.android.gms.internal.atv_ads_framework.zzec r31, com.google.android.gms.internal.atv_ads_framework.zzfp r32, com.google.android.gms.internal.atv_ads_framework.zzcy r33) {
        /*
            Method dump skipped, instructions count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.l(com.google.android.gms.internal.atv_ads_framework.zzel, com.google.android.gms.internal.atv_ads_framework.zzec, com.google.android.gms.internal.atv_ads_framework.zzfp, com.google.android.gms.internal.atv_ads_framework.zzcy):com.google.android.gms.internal.atv_ads_framework.zzer");
    }

    public static int n(long j2, Object obj) {
        return ((Integer) zzfz.g(obj, j2)).intValue();
    }

    public static int o(int i2) {
        return (i2 >>> 20) & 255;
    }

    public static long q(long j2, Object obj) {
        return ((Long) zzfz.g(obj, j2)).longValue();
    }

    public static Field s(Class cls, String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = i(r10)
            if (r0 != 0) goto L8
            goto L87
        L8:
            boolean r0 = r10 instanceof com.google.android.gms.internal.atv_ads_framework.zzdh
            r1 = 0
            if (r0 == 0) goto L18
            r0 = r10
            com.google.android.gms.internal.atv_ads_framework.zzdh r0 = (com.google.android.gms.internal.atv_ads_framework.zzdh) r0
            r0.j()
            r0.zza = r1
            r0.h()
        L18:
            int[] r0 = r9.f36156a
            int r2 = r0.length
            r3 = r1
        L1c:
            if (r3 >= r2) goto L7e
            int r4 = r9.p(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            int r4 = o(r4)
            long r5 = (long) r5
            r7 = 9
            if (r4 == r7) goto L68
            r7 = 60
            if (r4 == r7) goto L52
            r7 = 68
            if (r4 == r7) goto L52
            switch(r4) {
                case 17: goto L68;
                case 18: goto L4c;
                case 19: goto L4c;
                case 20: goto L4c;
                case 21: goto L4c;
                case 22: goto L4c;
                case 23: goto L4c;
                case 24: goto L4c;
                case 25: goto L4c;
                case 26: goto L4c;
                case 27: goto L4c;
                case 28: goto L4c;
                case 29: goto L4c;
                case 30: goto L4c;
                case 31: goto L4c;
                case 32: goto L4c;
                case 33: goto L4c;
                case 34: goto L4c;
                case 35: goto L4c;
                case 36: goto L4c;
                case 37: goto L4c;
                case 38: goto L4c;
                case 39: goto L4c;
                case 40: goto L4c;
                case 41: goto L4c;
                case 42: goto L4c;
                case 43: goto L4c;
                case 44: goto L4c;
                case 45: goto L4c;
                case 46: goto L4c;
                case 47: goto L4c;
                case 48: goto L4c;
                case 49: goto L4c;
                case 50: goto L3b;
                default: goto L3a;
            }
        L3a:
            goto L7b
        L3b:
            sun.misc.Unsafe r4 = com.google.android.gms.internal.atv_ads_framework.zzer.f36155l
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L7b
            r8 = r7
            com.google.android.gms.internal.atv_ads_framework.zzei r8 = (com.google.android.gms.internal.atv_ads_framework.zzei) r8
            r8.f36151a = r1
            r4.putObject(r10, r5, r7)
            goto L7b
        L4c:
            com.google.android.gms.internal.atv_ads_framework.zzec r4 = r9.f36163h
            r4.a(r5, r10)
            goto L7b
        L52:
            r4 = r0[r3]
            boolean r4 = r9.j(r4, r3, r10)
            if (r4 == 0) goto L7b
            com.google.android.gms.internal.atv_ads_framework.zzey r4 = r9.r(r3)
            sun.misc.Unsafe r7 = com.google.android.gms.internal.atv_ads_framework.zzer.f36155l
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.a(r5)
            goto L7b
        L68:
            boolean r4 = r9.h(r3, r10)
            if (r4 == 0) goto L7b
            com.google.android.gms.internal.atv_ads_framework.zzey r4 = r9.r(r3)
            sun.misc.Unsafe r7 = com.google.android.gms.internal.atv_ads_framework.zzer.f36155l
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.a(r5)
        L7b:
            int r3 = r3 + 3
            goto L1c
        L7e:
            com.google.android.gms.internal.atv_ads_framework.zzfp r0 = r9.f36164i
            r0.e(r10)
            boolean r0 = r9.f36159d
            if (r0 != 0) goto L88
        L87:
            return
        L88:
            com.google.android.gms.internal.atv_ads_framework.zzcy r0 = r9.f36165j
            r0.b(r10)
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.a(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:308:0x071c A[PHI: r18
      0x071c: PHI (r18v6 int) = 
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v2 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
      (r18v1 int)
     binds: [B:307:0x0719, B:532:0x0b6a, B:534:0x0b70, B:527:0x0b52, B:529:0x0b58, B:530:0x0b5a, B:522:0x0b3a, B:524:0x0b40, B:525:0x0b42, B:517:0x0b22, B:519:0x0b28, B:520:0x0b2a, B:512:0x0b0a, B:514:0x0b10, B:515:0x0b12, B:507:0x0af2, B:509:0x0af8, B:510:0x0afa, B:502:0x0ada, B:504:0x0ae0, B:505:0x0ae2, B:497:0x0ac2, B:499:0x0ac8, B:500:0x0aca, B:492:0x0aab, B:494:0x0ab1, B:495:0x0ab3, B:490:0x0a9d, B:369:0x085f, B:371:0x0865, B:769:0x071c, B:364:0x0845, B:361:0x0830, B:362:0x0832, B:358:0x081b, B:359:0x081d, B:355:0x080c, B:356:0x080e, B:352:0x07fd, B:353:0x07ff, B:349:0x07ee, B:350:0x07f0, B:346:0x07df, B:347:0x07e1, B:343:0x07d0, B:344:0x07d2, B:340:0x07bb, B:341:0x07bd, B:337:0x07ac, B:338:0x07ae, B:334:0x0799, B:335:0x079b, B:331:0x0789, B:332:0x078b, B:328:0x077b, B:329:0x077d, B:325:0x076d, B:326:0x076f, B:322:0x075f, B:323:0x0761, B:319:0x0751, B:320:0x0753, B:316:0x0743, B:317:0x0745, B:313:0x0735, B:314:0x0737, B:310:0x0723, B:311:0x0725] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r22, com.google.android.gms.internal.atv_ads_framework.zzgg r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.b(java.lang.Object, com.google.android.gms.internal.atv_ads_framework.zzgg):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[PHI: r3
      0x00db: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:85:0x01e8, B:43:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(com.google.android.gms.internal.atv_ads_framework.zzdh r13) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.c(com.google.android.gms.internal.atv_ads_framework.zzdh):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0350  */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.atv_ads_framework.zzdh r13) {
        /*
            Method dump skipped, instructions count: 1710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.d(com.google.android.gms.internal.atv_ads_framework.zzdh):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.e(java.lang.Object, java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final boolean f(zzdh zzdhVar, zzdh zzdhVar2) {
        boolean zA;
        int[] iArr = this.f36156a;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                int iP = p(i2);
                long j2 = iP & 1048575;
                switch (o(iP)) {
                    case 0:
                        if (!w(zzdhVar, zzdhVar2, i2)) {
                            break;
                        } else {
                            zzfy zzfyVar = zzfz.f36212c;
                            if (Double.doubleToLongBits(zzfyVar.a(zzdhVar, j2)) != Double.doubleToLongBits(zzfyVar.a(zzdhVar2, j2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 1:
                        if (!w(zzdhVar, zzdhVar2, i2)) {
                            break;
                        } else {
                            zzfy zzfyVar2 = zzfz.f36212c;
                            if (Float.floatToIntBits(zzfyVar2.b(zzdhVar, j2)) != Float.floatToIntBits(zzfyVar2.b(zzdhVar2, j2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 2:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.e(zzdhVar, j2) != zzfz.e(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 3:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.e(zzdhVar, j2) != zzfz.e(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 4:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.d(zzdhVar, j2) != zzfz.d(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 5:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.e(zzdhVar, j2) != zzfz.e(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 6:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.d(zzdhVar, j2) != zzfz.d(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 7:
                        if (!w(zzdhVar, zzdhVar2, i2)) {
                            break;
                        } else {
                            zzfy zzfyVar3 = zzfz.f36212c;
                            if (zzfyVar3.g(zzdhVar, j2) != zzfyVar3.g(zzdhVar2, j2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 8:
                        if (!w(zzdhVar, zzdhVar2, i2) || !zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 9:
                        if (!w(zzdhVar, zzdhVar2, i2) || !zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 10:
                        if (!w(zzdhVar, zzdhVar2, i2) || !zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 11:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.d(zzdhVar, j2) != zzfz.d(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 12:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.d(zzdhVar, j2) != zzfz.d(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 13:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.d(zzdhVar, j2) != zzfz.d(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 14:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.e(zzdhVar, j2) != zzfz.e(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 15:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.d(zzdhVar, j2) != zzfz.d(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 16:
                        if (!w(zzdhVar, zzdhVar2, i2) || zzfz.e(zzdhVar, j2) != zzfz.e(zzdhVar2, j2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 17:
                        if (!w(zzdhVar, zzdhVar2, i2) || !zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2))) {
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
                        zA = zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2));
                        break;
                    case 50:
                        zA = zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2));
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
                        if (zzfz.d(zzdhVar, j3) != zzfz.d(zzdhVar2, j3) || !zzfa.a(zzfz.g(zzdhVar, j2), zzfz.g(zzdhVar2, j2))) {
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
                zzfp zzfpVar = this.f36164i;
                if (zzfpVar.c(zzdhVar).equals(zzfpVar.c(zzdhVar2))) {
                    if (!this.f36159d) {
                        return true;
                    }
                    this.f36165j.a(zzdhVar);
                    throw null;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.g(java.lang.Object):boolean");
    }

    public final boolean h(int i2, Object obj) {
        int i3 = this.f36156a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int iP = p(i2);
            long j3 = iP & 1048575;
            switch (o(iP)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzfz.f36212c.a(obj, j3)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzfz.f36212c.b(obj, j3)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzfz.e(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzfz.e(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzfz.d(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzfz.e(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzfz.d(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzfz.f36212c.g(obj, j3);
                case 8:
                    Object objG = zzfz.g(obj, j3);
                    if (objG instanceof String) {
                        if (((String) objG).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objG instanceof zzcn)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzcn.f36095b.equals(objG)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (zzfz.g(obj, j3) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzcn.f36095b.equals(zzfz.g(obj, j3))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzfz.d(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzfz.d(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzfz.d(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzfz.e(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzfz.d(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzfz.e(obj, j3) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzfz.g(obj, j3) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & zzfz.d(obj, j2)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean j(int i2, int i3, Object obj) {
        return zzfz.d(obj, (long) (this.f36156a[i3 + 2] & 1048575)) == i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0359  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(com.google.android.gms.internal.atv_ads_framework.zzdh r17) {
        /*
            Method dump skipped, instructions count: 1690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzer.m(com.google.android.gms.internal.atv_ads_framework.zzdh):int");
    }

    public final int p(int i2) {
        return this.f36156a[i2 + 1];
    }

    public final zzey r(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        Object[] objArr = this.f36157b;
        zzey zzeyVar = (zzey) objArr[i4];
        if (zzeyVar != null) {
            return zzeyVar;
        }
        zzey zzeyVarA = zzew.f36171c.a((Class) objArr[i4 + 1]);
        objArr[i4] = zzeyVarA;
        return zzeyVarA;
    }

    public final void t(int i2, Object obj, Object obj2) {
        if (h(i2, obj2)) {
            int iP = p(i2) & 1048575;
            Unsafe unsafe = f36155l;
            long j2 = iP;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException(b.h(this.f36156a[i2], "Source subfield ", " is present but null: ", obj2.toString()));
            }
            zzey zzeyVarR = r(i2);
            if (!h(i2, obj)) {
                if (i(object)) {
                    Object objZzc = zzeyVarR.zzc();
                    zzeyVarR.e(objZzc, object);
                    unsafe.putObject(obj, j2, objZzc);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                v(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!i(object2)) {
                Object objZzc2 = zzeyVarR.zzc();
                zzeyVarR.e(objZzc2, object2);
                unsafe.putObject(obj, j2, objZzc2);
                object2 = objZzc2;
            }
            zzeyVarR.e(object2, object);
        }
    }

    public final void u(int i2, Object obj, Object obj2) {
        int[] iArr = this.f36156a;
        int i3 = iArr[i2];
        if (j(i3, i2, obj2)) {
            int iP = p(i2) & 1048575;
            Unsafe unsafe = f36155l;
            long j2 = iP;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                throw new IllegalStateException(b.h(iArr[i2], "Source subfield ", " is present but null: ", obj2.toString()));
            }
            zzey zzeyVarR = r(i2);
            if (!j(i3, i2, obj)) {
                if (i(object)) {
                    Object objZzc = zzeyVarR.zzc();
                    zzeyVarR.e(objZzc, object);
                    unsafe.putObject(obj, j2, objZzc);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                zzfz.i(obj, iArr[i2 + 2] & 1048575, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!i(object2)) {
                Object objZzc2 = zzeyVarR.zzc();
                zzeyVarR.e(objZzc2, object2);
                unsafe.putObject(obj, j2, objZzc2);
                object2 = objZzc2;
            }
            zzeyVarR.e(object2, object);
        }
    }

    public final void v(int i2, Object obj) {
        int i3 = this.f36156a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        zzfz.i(obj, j2, (1 << (i3 >>> 20)) | zzfz.d(obj, j2));
    }

    public final boolean w(zzdh zzdhVar, zzdh zzdhVar2, int i2) {
        return h(i2, zzdhVar) == h(i2, zzdhVar2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final Object zzc() {
        return (zzdh) this.f36158c.d(4);
    }
}
