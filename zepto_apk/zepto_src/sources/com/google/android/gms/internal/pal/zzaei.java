package com.google.android.gms.internal.pal;

import androidx.fragment.app.e;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzaei<T> implements zzaer<T> {
    public static final int[] o = new int[0];
    public static final Unsafe p = zzafs.e();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f37439a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f37440b;

    /* renamed from: c, reason: collision with root package name */
    public final int f37441c;

    /* renamed from: d, reason: collision with root package name */
    public final int f37442d;

    /* renamed from: e, reason: collision with root package name */
    public final zzaef f37443e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f37444f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f37445g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f37446h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f37447i;

    /* renamed from: j, reason: collision with root package name */
    public final int f37448j;

    /* renamed from: k, reason: collision with root package name */
    public final int f37449k;

    /* renamed from: l, reason: collision with root package name */
    public final zzadt f37450l;

    /* renamed from: m, reason: collision with root package name */
    public final zzafi f37451m;
    public final zzacn n;

    public zzaei(int[] iArr, Object[] objArr, int i2, int i3, zzaef zzaefVar, boolean z, int[] iArr2, int i4, int i5, zzadt zzadtVar, zzafi zzafiVar, zzacn zzacnVar, zzaea zzaeaVar) {
        this.f37439a = iArr;
        this.f37440b = objArr;
        this.f37441c = i2;
        this.f37442d = i3;
        this.f37445g = zzaefVar instanceof zzacz;
        this.f37446h = z;
        boolean z2 = false;
        if (zzacnVar != null && zzacnVar.e(zzaefVar)) {
            z2 = true;
        }
        this.f37444f = z2;
        this.f37447i = iArr2;
        this.f37448j = i4;
        this.f37449k = i5;
        this.f37450l = zzadtVar;
        this.f37451m = zzafiVar;
        this.n = zzacnVar;
        this.f37443e = zzaefVar;
    }

    public static zzafj A(Object obj) {
        zzacz zzaczVar = (zzacz) obj;
        zzafj zzafjVar = zzaczVar.zzc;
        if (zzafjVar != zzafj.f37488f) {
            return zzafjVar;
        }
        zzafj zzafjVarB = zzafj.b();
        zzaczVar.zzc = zzafjVarB;
        return zzafjVarB;
    }

    public static zzaei B(zzaec zzaecVar, zzadt zzadtVar, zzafi zzafiVar, zzacn zzacnVar, zzaea zzaeaVar) {
        if (zzaecVar instanceof zzaep) {
            return C((zzaep) zzaecVar, zzadtVar, zzafiVar, zzacnVar, zzaeaVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.pal.zzaei C(com.google.android.gms.internal.pal.zzaep r34, com.google.android.gms.internal.pal.zzadt r35, com.google.android.gms.internal.pal.zzafi r36, com.google.android.gms.internal.pal.zzacn r37, com.google.android.gms.internal.pal.zzaea r38) {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.C(com.google.android.gms.internal.pal.zzaep, com.google.android.gms.internal.pal.zzadt, com.google.android.gms.internal.pal.zzafi, com.google.android.gms.internal.pal.zzacn, com.google.android.gms.internal.pal.zzaea):com.google.android.gms.internal.pal.zzaei");
    }

    public static int F(long j2, Object obj) {
        return ((Integer) zzafs.f37500c.m(j2, obj)).intValue();
    }

    public static int h(int i2) {
        return (i2 >>> 20) & 255;
    }

    public static long j(long j2, Object obj) {
        return ((Long) zzafs.f37500c.m(j2, obj)).longValue();
    }

    public static Field o(Class cls, String str) {
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

    public static final void y(int i2, Object obj, zzaga zzagaVar) {
        if (obj instanceof String) {
            zzagaVar.j(i2, (String) obj);
        } else {
            zzagaVar.m(i2, (zzaby) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0333  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int D(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 1636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.D(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0335  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int E(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 1716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.E(java.lang.Object):int");
    }

    public final void G(Object obj, int i2, long j2) {
        Unsafe unsafe = p;
        Object objN = n(i2);
        Object object = unsafe.getObject(obj, j2);
        if (!((zzadz) object).f37436a) {
            zzadz zzadzVarA = zzadz.f37435b.a();
            zzaea.b(zzadzVarA, object);
            unsafe.putObject(obj, j2, zzadzVarA);
        }
        throw null;
    }

    public final int H(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, zzabl zzablVar) throws zzadi {
        Object object;
        Unsafe unsafe = p;
        long j3 = this.f37439a[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Double.valueOf(Double.longBitsToDouble(zzabm.l(bArr, i2))));
                unsafe.putInt(obj, j3, i5);
                return i2 + 8;
            case Type.TLSA /* 52 */:
                if (i6 != 5) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Float.valueOf(Float.intBitsToFloat(zzabm.b(bArr, i2))));
                unsafe.putInt(obj, j3, i5);
                return i2 + 4;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i2;
                }
                int iK = zzabm.k(bArr, i2, zzablVar);
                unsafe.putObject(obj, j2, Long.valueOf(zzablVar.f37353b));
                unsafe.putInt(obj, j3, i5);
                return iK;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i2;
                }
                int iH = zzabm.h(bArr, i2, zzablVar);
                unsafe.putObject(obj, j2, Integer.valueOf(zzablVar.f37352a));
                unsafe.putInt(obj, j3, i5);
                return iH;
            case Type.NINFO /* 56 */:
            case 65:
                if (i6 != 1) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Long.valueOf(zzabm.l(bArr, i2)));
                unsafe.putInt(obj, j3, i5);
                return i2 + 8;
            case Type.RKEY /* 57 */:
            case 64:
                if (i6 != 5) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(zzabm.b(bArr, i2)));
                unsafe.putInt(obj, j3, i5);
                return i2 + 4;
            case Type.TALINK /* 58 */:
                if (i6 != 0) {
                    return i2;
                }
                int iK2 = zzabm.k(bArr, i2, zzablVar);
                unsafe.putObject(obj, j2, Boolean.valueOf(zzablVar.f37353b != 0));
                unsafe.putInt(obj, j3, i5);
                return iK2;
            case Type.CDS /* 59 */:
                if (i6 != 2) {
                    return i2;
                }
                int iH2 = zzabm.h(bArr, i2, zzablVar);
                int i10 = zzablVar.f37352a;
                if (i10 == 0) {
                    unsafe.putObject(obj, j2, "");
                } else {
                    if ((i7 & 536870912) != 0) {
                        if (!zzafx.f37505a.b(bArr, iH2, iH2 + i10)) {
                            throw zzadi.b();
                        }
                    }
                    unsafe.putObject(obj, j2, new String(bArr, iH2, i10, zzadg.f37410a));
                    iH2 += i10;
                }
                unsafe.putInt(obj, j3, i5);
                return iH2;
            case 60:
                if (i6 != 2) {
                    return i2;
                }
                int iD = zzabm.d(l(i9), bArr, i2, i3, zzablVar);
                object = unsafe.getInt(obj, j3) == i5 ? unsafe.getObject(obj, j2) : null;
                if (object == null) {
                    unsafe.putObject(obj, j2, zzablVar.f37354c);
                } else {
                    unsafe.putObject(obj, j2, zzadg.b(object, zzablVar.f37354c));
                }
                unsafe.putInt(obj, j3, i5);
                return iD;
            case 61:
                if (i6 != 2) {
                    return i2;
                }
                int iA = zzabm.a(bArr, i2, zzablVar);
                unsafe.putObject(obj, j2, zzablVar.f37354c);
                unsafe.putInt(obj, j3, i5);
                return iA;
            case 63:
                if (i6 != 0) {
                    return i2;
                }
                int iH3 = zzabm.h(bArr, i2, zzablVar);
                int i11 = zzablVar.f37352a;
                zzadd zzaddVarK = k(i9);
                if (zzaddVarK != null && !zzaddVarK.zza(i11)) {
                    A(obj).c(i4, Long.valueOf(i11));
                    return iH3;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(i11));
                unsafe.putInt(obj, j3, i5);
                return iH3;
            case WKSRecord.Protocol.RVD /* 66 */:
                if (i6 != 0) {
                    return i2;
                }
                int iH4 = zzabm.h(bArr, i2, zzablVar);
                unsafe.putObject(obj, j2, Integer.valueOf(zzacc.k(zzablVar.f37352a)));
                unsafe.putInt(obj, j3, i5);
                return iH4;
            case 67:
                if (i6 != 0) {
                    return i2;
                }
                int iK3 = zzabm.k(bArr, i2, zzablVar);
                unsafe.putObject(obj, j2, Long.valueOf(zzacc.l(zzablVar.f37353b)));
                unsafe.putInt(obj, j3, i5);
                return iK3;
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (i6 == 3) {
                    int iC = zzabm.c(l(i9), bArr, i2, i3, (i4 & (-8)) | 4, zzablVar);
                    object = unsafe.getInt(obj, j3) == i5 ? unsafe.getObject(obj, j2) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j2, zzablVar.f37354c);
                    } else {
                        unsafe.putObject(obj, j2, zzadg.b(object, zzablVar.f37354c));
                    }
                    unsafe.putInt(obj, j3, i5);
                    return iC;
                }
                break;
        }
        return i2;
    }

    public final void I(Object obj, byte[] bArr, int i2, int i3, zzabl zzablVar) throws zzadi {
        int i4;
        int iG;
        Unsafe unsafe;
        int i5;
        int i6;
        Object obj2;
        int i7;
        int i8;
        Unsafe unsafe2;
        Object obj3;
        int i9;
        char c2;
        int iK;
        Object obj4;
        int i10;
        int i11;
        int i12;
        int iH;
        zzaei<T> zzaeiVar = this;
        Object obj5 = obj;
        byte[] bArr2 = bArr;
        int i13 = i3;
        zzabl zzablVar2 = zzablVar;
        Unsafe unsafe3 = p;
        int iK2 = i2;
        int i14 = -1;
        int i15 = 0;
        int i16 = 1048575;
        int i17 = 0;
        while (iK2 < i13) {
            int i18 = iK2 + 1;
            int i19 = bArr2[iK2];
            if (i19 < 0) {
                i18 = zzabm.i(i19, bArr2, i18, zzablVar2);
                i19 = zzablVar2.f37352a;
            }
            int i20 = i18;
            int i21 = i19 >>> 3;
            int i22 = i19 & 7;
            int i23 = zzaeiVar.f37442d;
            int i24 = zzaeiVar.f37441c;
            if (i21 > i14) {
                iG = (i21 < i24 || i21 > i23) ? -1 : zzaeiVar.g(i21, i15 / 3);
                i4 = 0;
            } else if (i21 < i24 || i21 > i23) {
                i4 = 0;
                iG = -1;
            } else {
                i4 = 0;
                iG = zzaeiVar.g(i21, 0);
            }
            int i25 = iG;
            if (i25 == -1) {
                unsafe = unsafe3;
                i5 = i19;
                i6 = i4;
                obj2 = obj5;
                i7 = i20;
            } else {
                int[] iArr = zzaeiVar.f37439a;
                int i26 = iArr[i25 + 1];
                int iH2 = h(i26);
                int i27 = i19;
                long j2 = i26 & 1048575;
                if (iH2 <= 17) {
                    int i28 = iArr[i25 + 2];
                    int i29 = 1 << (i28 >>> 20);
                    int i30 = i28 & 1048575;
                    if (i30 != i16) {
                        int i31 = 1048575;
                        i8 = i26;
                        if (i16 != 1048575) {
                            unsafe3.putInt(obj5, i16, i17);
                            i31 = 1048575;
                        }
                        if (i30 != i31) {
                            i17 = unsafe3.getInt(obj5, i30);
                        }
                        i16 = i30;
                    } else {
                        i8 = i26;
                    }
                    switch (iH2) {
                        case 0:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 1) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                zzafs.f37500c.e(obj5, j2, Double.longBitsToDouble(zzabm.l(bArr2, i20)));
                                iK2 = i20 + 8;
                                i17 |= i29;
                                obj5 = obj5;
                                unsafe3 = unsafe3;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 1:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 5) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                zzafs.f37500c.f(obj5, j2, Float.intBitsToFloat(zzabm.b(bArr2, i20)));
                                iK2 = i20 + 4;
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 2:
                        case 3:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 0) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK = zzabm.k(bArr2, i20, zzablVar2);
                                unsafe3.putLong(obj5, j2, zzablVar2.f37353b);
                                i17 |= i29;
                                iK2 = iK;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 4:
                        case 11:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 0) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                int iH3 = zzabm.h(bArr2, i20, zzablVar2);
                                unsafe3.putInt(obj5, j2, zzablVar2.f37352a);
                                i17 |= i29;
                                iK2 = iH3;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 5:
                        case 14:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 1) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                unsafe3.putLong(obj5, j2, zzabm.l(bArr2, i20));
                                iK2 = i20 + 8;
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 6:
                        case 13:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 5) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                unsafe3.putInt(obj5, j2, zzabm.b(bArr2, i20));
                                iK2 = i20 + 4;
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 7:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 0) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK2 = zzabm.k(bArr2, i20, zzablVar2);
                                zzafs.f37500c.c(obj5, j2, zzablVar2.f37353b != 0);
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 8:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 2) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                if ((i8 & 536870912) == 0) {
                                    iK2 = zzabm.f(bArr2, i20, zzablVar2);
                                } else {
                                    iK2 = zzabm.h(bArr2, i20, zzablVar2);
                                    int i32 = zzablVar2.f37352a;
                                    if (i32 < 0) {
                                        throw zzadi.c();
                                    }
                                    if (i32 == 0) {
                                        zzablVar2.f37354c = "";
                                    } else {
                                        zzablVar2.f37354c = zzafx.d(iK2, bArr2, i32);
                                        iK2 += i32;
                                    }
                                }
                                unsafe3.putObject(obj5, j2, zzablVar2.f37354c);
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 9:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 2) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK2 = zzabm.d(zzaeiVar.l(i25), bArr2, i20, i13, zzablVar2);
                                Object object = unsafe3.getObject(obj5, j2);
                                if (object == null) {
                                    unsafe3.putObject(obj5, j2, zzablVar2.f37354c);
                                } else {
                                    unsafe3.putObject(obj5, j2, zzadg.b(object, zzablVar2.f37354c));
                                }
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 10:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 2) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK2 = zzabm.a(bArr2, i20, zzablVar2);
                                unsafe3.putObject(obj5, j2, zzablVar2.f37354c);
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 12:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 0) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK2 = zzabm.h(bArr2, i20, zzablVar2);
                                unsafe3.putInt(obj5, j2, zzablVar2.f37352a);
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 15:
                            i9 = i21;
                            c2 = 65535;
                            if (i22 != 0) {
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK2 = zzabm.h(bArr2, i20, zzablVar2);
                                unsafe3.putInt(obj5, j2, zzacc.k(zzablVar2.f37352a));
                                i17 |= i29;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        case 16:
                            if (i22 != 0) {
                                i9 = i21;
                                c2 = 65535;
                                unsafe2 = unsafe3;
                                obj3 = obj5;
                                i5 = i27;
                                unsafe = unsafe2;
                                i6 = i25;
                                i7 = i20;
                                i21 = i9;
                                obj2 = obj3;
                                break;
                            } else {
                                iK = zzabm.k(bArr2, i20, zzablVar2);
                                i9 = i21;
                                unsafe3.putLong(obj5, j2, zzacc.l(zzablVar2.f37353b));
                                i17 |= i29;
                                iK2 = iK;
                                i15 = i25;
                                i14 = i9;
                                break;
                            }
                        default:
                            unsafe2 = unsafe3;
                            obj3 = obj5;
                            i9 = i21;
                            c2 = 65535;
                            i5 = i27;
                            unsafe = unsafe2;
                            i6 = i25;
                            i7 = i20;
                            i21 = i9;
                            obj2 = obj3;
                            break;
                    }
                } else {
                    Object obj6 = obj5;
                    Unsafe unsafe4 = unsafe3;
                    if (iH2 != 27) {
                        i5 = i27;
                        if (iH2 <= 49) {
                            i6 = i25;
                            i12 = i16;
                            unsafe = unsafe4;
                            i10 = i17;
                            i21 = i21;
                            iH = zzaeiVar.J(obj, bArr, i20, i3, i5, i21, i22, i6, i26, iH2, j2, zzablVar);
                            obj5 = obj;
                            if (iH != i20) {
                                zzablVar2 = zzablVar;
                                i14 = i21;
                                iK2 = iH;
                                i15 = i6;
                                i16 = i12;
                                i17 = i10;
                                unsafe3 = unsafe;
                                bArr2 = bArr;
                                i13 = i3;
                            } else {
                                obj2 = obj5;
                                i7 = iH;
                                i16 = i12;
                                i17 = i10;
                            }
                        } else {
                            obj4 = obj;
                            unsafe = unsafe4;
                            i6 = i25;
                            i10 = i17;
                            i11 = i20;
                            i12 = i16;
                            i21 = i21;
                            if (iH2 == 50) {
                                if (i22 == 2) {
                                    zzaeiVar.G(obj4, i6, j2);
                                    throw null;
                                }
                                obj2 = obj4;
                                i7 = i11;
                                i16 = i12;
                                i17 = i10;
                            } else {
                                iH = zzaeiVar.H(obj4, bArr, i11, i3, i5, i21, i22, i26, iH2, j2, i6, zzablVar);
                                obj2 = obj4;
                                i6 = i6;
                                if (iH != i11) {
                                    zzaeiVar = this;
                                    zzablVar2 = zzablVar;
                                    i14 = i21;
                                    iK2 = iH;
                                    i15 = i6;
                                    obj5 = obj2;
                                    i16 = i12;
                                    i17 = i10;
                                    unsafe3 = unsafe;
                                    bArr2 = bArr;
                                    i13 = i3;
                                } else {
                                    i7 = iH;
                                    i16 = i12;
                                    i17 = i10;
                                }
                            }
                        }
                    } else if (i22 == 2) {
                        zzadf zzadfVarZzd = (zzadf) unsafe4.getObject(obj6, j2);
                        if (!zzadfVarZzd.zzc()) {
                            int size = zzadfVarZzd.size();
                            zzadfVarZzd = zzadfVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe4.putObject(obj6, j2, zzadfVarZzd);
                        }
                        int iE = zzabm.e(zzaeiVar.l(i25), i27, bArr2, i20, i13, zzadfVarZzd, zzablVar2);
                        obj5 = obj;
                        bArr2 = bArr;
                        zzablVar2 = zzablVar;
                        iK2 = iE;
                        unsafe3 = unsafe4;
                        i15 = i25;
                        i14 = i21;
                        i13 = i3;
                    } else {
                        i5 = i27;
                        unsafe = unsafe4;
                        i6 = i25;
                        i12 = i16;
                        i10 = i17;
                        i11 = i20;
                        i21 = i21;
                        obj4 = obj;
                        obj2 = obj4;
                        i7 = i11;
                        i16 = i12;
                        i17 = i10;
                    }
                }
            }
            int iG2 = zzabm.g(i5, bArr, i7, i3, A(obj2), zzablVar);
            bArr2 = bArr;
            zzablVar2 = zzablVar;
            i14 = i21;
            i15 = i6;
            obj5 = obj2;
            unsafe3 = unsafe;
            i13 = i3;
            iK2 = iG2;
            zzaeiVar = this;
        }
        Unsafe unsafe5 = unsafe3;
        Object obj7 = obj5;
        int i33 = i13;
        int i34 = i16;
        int i35 = i17;
        if (i34 != 1048575) {
            unsafe5.putInt(obj7, i34, i35);
        }
        if (iK2 != i33) {
            throw zzadi.d();
        }
    }

    public final int J(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, zzabl zzablVar) throws zzadi {
        int iJ;
        Unsafe unsafe = p;
        zzadf zzadfVarZzd = (zzadf) unsafe.getObject(obj, j3);
        if (!zzadfVarZzd.zzc()) {
            int size = zzadfVarZzd.size();
            zzadfVarZzd = zzadfVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j3, zzadfVarZzd);
        }
        zzadf zzadfVar = zzadfVarZzd;
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    zzacj zzacjVar = (zzacj) zzadfVar;
                    int iH = zzabm.h(bArr, i2, zzablVar);
                    int i9 = zzablVar.f37352a + iH;
                    while (iH < i9) {
                        zzacjVar.d(Double.longBitsToDouble(zzabm.l(bArr, iH)));
                        iH += 8;
                    }
                    if (iH == i9) {
                        return iH;
                    }
                    throw zzadi.e();
                }
                if (i6 == 1) {
                    zzacj zzacjVar2 = (zzacj) zzadfVar;
                    zzacjVar2.d(Double.longBitsToDouble(zzabm.l(bArr, i2)));
                    int i10 = i2 + 8;
                    while (i10 < i3) {
                        int iH2 = zzabm.h(bArr, i10, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return i10;
                        }
                        zzacjVar2.d(Double.longBitsToDouble(zzabm.l(bArr, iH2)));
                        i10 = iH2 + 8;
                    }
                    return i10;
                }
                return i2;
            case 19:
            case 36:
                if (i6 == 2) {
                    zzact zzactVar = (zzact) zzadfVar;
                    int iH3 = zzabm.h(bArr, i2, zzablVar);
                    int i11 = zzablVar.f37352a + iH3;
                    while (iH3 < i11) {
                        zzactVar.d(Float.intBitsToFloat(zzabm.b(bArr, iH3)));
                        iH3 += 4;
                    }
                    if (iH3 == i11) {
                        return iH3;
                    }
                    throw zzadi.e();
                }
                if (i6 == 5) {
                    zzact zzactVar2 = (zzact) zzadfVar;
                    zzactVar2.d(Float.intBitsToFloat(zzabm.b(bArr, i2)));
                    int i12 = i2 + 4;
                    while (i12 < i3) {
                        int iH4 = zzabm.h(bArr, i12, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return i12;
                        }
                        zzactVar2.d(Float.intBitsToFloat(zzabm.b(bArr, iH4)));
                        i12 = iH4 + 4;
                    }
                    return i12;
                }
                return i2;
            case 20:
            case 21:
            case 37:
            case Type.A6 /* 38 */:
                if (i6 == 2) {
                    zzadu zzaduVar = (zzadu) zzadfVar;
                    int iH5 = zzabm.h(bArr, i2, zzablVar);
                    int i13 = zzablVar.f37352a + iH5;
                    while (iH5 < i13) {
                        iH5 = zzabm.k(bArr, iH5, zzablVar);
                        zzaduVar.d(zzablVar.f37353b);
                    }
                    if (iH5 == i13) {
                        return iH5;
                    }
                    throw zzadi.e();
                }
                if (i6 == 0) {
                    zzadu zzaduVar2 = (zzadu) zzadfVar;
                    int iK = zzabm.k(bArr, i2, zzablVar);
                    zzaduVar2.d(zzablVar.f37353b);
                    while (iK < i3) {
                        int iH6 = zzabm.h(bArr, iK, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return iK;
                        }
                        iK = zzabm.k(bArr, iH6, zzablVar);
                        zzaduVar2.d(zzablVar.f37353b);
                    }
                    return iK;
                }
                return i2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 != 2) {
                    if (i6 == 0) {
                        return zzabm.j(i4, bArr, i2, i3, zzadfVar, zzablVar);
                    }
                    return i2;
                }
                zzada zzadaVar = (zzada) zzadfVar;
                int iH7 = zzabm.h(bArr, i2, zzablVar);
                int i14 = zzablVar.f37352a + iH7;
                while (iH7 < i14) {
                    iH7 = zzabm.h(bArr, iH7, zzablVar);
                    zzadaVar.d(zzablVar.f37352a);
                }
                if (iH7 == i14) {
                    return iH7;
                }
                throw zzadi.e();
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    zzadu zzaduVar3 = (zzadu) zzadfVar;
                    int iH8 = zzabm.h(bArr, i2, zzablVar);
                    int i15 = zzablVar.f37352a + iH8;
                    while (iH8 < i15) {
                        zzaduVar3.d(zzabm.l(bArr, iH8));
                        iH8 += 8;
                    }
                    if (iH8 == i15) {
                        return iH8;
                    }
                    throw zzadi.e();
                }
                if (i6 == 1) {
                    zzadu zzaduVar4 = (zzadu) zzadfVar;
                    zzaduVar4.d(zzabm.l(bArr, i2));
                    int i16 = i2 + 8;
                    while (i16 < i3) {
                        int iH9 = zzabm.h(bArr, i16, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return i16;
                        }
                        zzaduVar4.d(zzabm.l(bArr, iH9));
                        i16 = iH9 + 8;
                    }
                    return i16;
                }
                return i2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    zzada zzadaVar2 = (zzada) zzadfVar;
                    int iH10 = zzabm.h(bArr, i2, zzablVar);
                    int i17 = zzablVar.f37352a + iH10;
                    while (iH10 < i17) {
                        zzadaVar2.d(zzabm.b(bArr, iH10));
                        iH10 += 4;
                    }
                    if (iH10 == i17) {
                        return iH10;
                    }
                    throw zzadi.e();
                }
                if (i6 == 5) {
                    zzada zzadaVar3 = (zzada) zzadfVar;
                    zzadaVar3.d(zzabm.b(bArr, i2));
                    int i18 = i2 + 4;
                    while (i18 < i3) {
                        int iH11 = zzabm.h(bArr, i18, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return i18;
                        }
                        zzadaVar3.d(zzabm.b(bArr, iH11));
                        i18 = iH11 + 4;
                    }
                    return i18;
                }
                return i2;
            case 25:
            case 42:
                if (i6 == 2) {
                    zzabn zzabnVar = (zzabn) zzadfVar;
                    int iH12 = zzabm.h(bArr, i2, zzablVar);
                    int i19 = zzablVar.f37352a + iH12;
                    while (iH12 < i19) {
                        iH12 = zzabm.k(bArr, iH12, zzablVar);
                        zzabnVar.d(zzablVar.f37353b != 0);
                    }
                    if (iH12 == i19) {
                        return iH12;
                    }
                    throw zzadi.e();
                }
                if (i6 == 0) {
                    zzabn zzabnVar2 = (zzabn) zzadfVar;
                    int iK2 = zzabm.k(bArr, i2, zzablVar);
                    zzabnVar2.d(zzablVar.f37353b != 0);
                    while (iK2 < i3) {
                        int iH13 = zzabm.h(bArr, iK2, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return iK2;
                        }
                        iK2 = zzabm.k(bArr, iH13, zzablVar);
                        zzabnVar2.d(zzablVar.f37353b != 0);
                    }
                    return iK2;
                }
                return i2;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int iH14 = zzabm.h(bArr, i2, zzablVar);
                        int i20 = zzablVar.f37352a;
                        if (i20 < 0) {
                            throw zzadi.c();
                        }
                        if (i20 == 0) {
                            zzadfVar.add("");
                        } else {
                            zzadfVar.add(new String(bArr, iH14, i20, zzadg.f37410a));
                            iH14 += i20;
                        }
                        while (iH14 < i3) {
                            int iH15 = zzabm.h(bArr, iH14, zzablVar);
                            if (i4 != zzablVar.f37352a) {
                                return iH14;
                            }
                            iH14 = zzabm.h(bArr, iH15, zzablVar);
                            int i21 = zzablVar.f37352a;
                            if (i21 < 0) {
                                throw zzadi.c();
                            }
                            if (i21 == 0) {
                                zzadfVar.add("");
                            } else {
                                zzadfVar.add(new String(bArr, iH14, i21, zzadg.f37410a));
                                iH14 += i21;
                            }
                        }
                        return iH14;
                    }
                    int iH16 = zzabm.h(bArr, i2, zzablVar);
                    int i22 = zzablVar.f37352a;
                    if (i22 < 0) {
                        throw zzadi.c();
                    }
                    if (i22 == 0) {
                        zzadfVar.add("");
                    } else {
                        int i23 = iH16 + i22;
                        if (!zzafx.f37505a.b(bArr, iH16, i23)) {
                            throw zzadi.b();
                        }
                        zzadfVar.add(new String(bArr, iH16, i22, zzadg.f37410a));
                        iH16 = i23;
                    }
                    while (iH16 < i3) {
                        int iH17 = zzabm.h(bArr, iH16, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return iH16;
                        }
                        iH16 = zzabm.h(bArr, iH17, zzablVar);
                        int i24 = zzablVar.f37352a;
                        if (i24 < 0) {
                            throw zzadi.c();
                        }
                        if (i24 == 0) {
                            zzadfVar.add("");
                        } else {
                            int i25 = iH16 + i24;
                            if (!zzafx.f37505a.b(bArr, iH16, i25)) {
                                throw zzadi.b();
                            }
                            zzadfVar.add(new String(bArr, iH16, i24, zzadg.f37410a));
                            iH16 = i25;
                        }
                    }
                    return iH16;
                }
                return i2;
            case 27:
                if (i6 == 2) {
                    return zzabm.e(l(i7), i4, bArr, i2, i3, zzadfVar, zzablVar);
                }
                return i2;
            case 28:
                if (i6 == 2) {
                    int iH18 = zzabm.h(bArr, i2, zzablVar);
                    int i26 = zzablVar.f37352a;
                    if (i26 < 0) {
                        throw zzadi.c();
                    }
                    if (i26 > bArr.length - iH18) {
                        throw zzadi.e();
                    }
                    if (i26 == 0) {
                        zzadfVar.add(zzaby.f37363b);
                    } else {
                        zzadfVar.add(zzaby.q(iH18, bArr, i26));
                        iH18 += i26;
                    }
                    while (iH18 < i3) {
                        int iH19 = zzabm.h(bArr, iH18, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return iH18;
                        }
                        iH18 = zzabm.h(bArr, iH19, zzablVar);
                        int i27 = zzablVar.f37352a;
                        if (i27 < 0) {
                            throw zzadi.c();
                        }
                        if (i27 > bArr.length - iH18) {
                            throw zzadi.e();
                        }
                        if (i27 == 0) {
                            zzadfVar.add(zzaby.f37363b);
                        } else {
                            zzadfVar.add(zzaby.q(iH18, bArr, i27));
                            iH18 += i27;
                        }
                    }
                    return iH18;
                }
                return i2;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        iJ = zzabm.j(i4, bArr, i2, i3, zzadfVar, zzablVar);
                    }
                    return i2;
                }
                zzada zzadaVar4 = (zzada) zzadfVar;
                iJ = zzabm.h(bArr, i2, zzablVar);
                int i28 = zzablVar.f37352a + iJ;
                while (iJ < i28) {
                    iJ = zzabm.h(bArr, iJ, zzablVar);
                    zzadaVar4.d(zzablVar.f37352a);
                }
                if (iJ != i28) {
                    throw zzadi.e();
                }
                zzacz zzaczVar = (zzacz) obj;
                zzafj zzafjVar = zzaczVar.zzc;
                if (zzafjVar == zzafj.f37488f) {
                    zzafjVar = null;
                }
                Object objA = zzaet.a(i5, zzadfVar, k(i7), zzafjVar, this.f37451m);
                if (objA == null) {
                    return iJ;
                }
                zzaczVar.zzc = (zzafj) objA;
                return iJ;
            case 33:
            case 47:
                if (i6 == 2) {
                    zzada zzadaVar5 = (zzada) zzadfVar;
                    int iH20 = zzabm.h(bArr, i2, zzablVar);
                    int i29 = zzablVar.f37352a + iH20;
                    while (iH20 < i29) {
                        iH20 = zzabm.h(bArr, iH20, zzablVar);
                        zzadaVar5.d(zzacc.k(zzablVar.f37352a));
                    }
                    if (iH20 == i29) {
                        return iH20;
                    }
                    throw zzadi.e();
                }
                if (i6 == 0) {
                    zzada zzadaVar6 = (zzada) zzadfVar;
                    int iH21 = zzabm.h(bArr, i2, zzablVar);
                    zzadaVar6.d(zzacc.k(zzablVar.f37352a));
                    while (iH21 < i3) {
                        int iH22 = zzabm.h(bArr, iH21, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return iH21;
                        }
                        iH21 = zzabm.h(bArr, iH22, zzablVar);
                        zzadaVar6.d(zzacc.k(zzablVar.f37352a));
                    }
                    return iH21;
                }
                return i2;
            case 34:
            case Type.DNSKEY /* 48 */:
                if (i6 == 2) {
                    zzadu zzaduVar5 = (zzadu) zzadfVar;
                    int iH23 = zzabm.h(bArr, i2, zzablVar);
                    int i30 = zzablVar.f37352a + iH23;
                    while (iH23 < i30) {
                        iH23 = zzabm.k(bArr, iH23, zzablVar);
                        zzaduVar5.d(zzacc.l(zzablVar.f37353b));
                    }
                    if (iH23 == i30) {
                        return iH23;
                    }
                    throw zzadi.e();
                }
                if (i6 == 0) {
                    zzadu zzaduVar6 = (zzadu) zzadfVar;
                    int iK3 = zzabm.k(bArr, i2, zzablVar);
                    zzaduVar6.d(zzacc.l(zzablVar.f37353b));
                    while (iK3 < i3) {
                        int iH24 = zzabm.h(bArr, iK3, zzablVar);
                        if (i4 != zzablVar.f37352a) {
                            return iK3;
                        }
                        iK3 = zzabm.k(bArr, iH24, zzablVar);
                        zzaduVar6.d(zzacc.l(zzablVar.f37353b));
                    }
                    return iK3;
                }
                return i2;
            default:
                if (i6 == 3) {
                    zzaer zzaerVarL = l(i7);
                    int i31 = (i4 & (-8)) | 4;
                    int iC = zzabm.c(zzaerVarL, bArr, i2, i3, i31, zzablVar);
                    zzaer zzaerVar = zzaerVarL;
                    zzabl zzablVar2 = zzablVar;
                    zzadfVar.add(zzablVar2.f37354c);
                    while (iC < i3) {
                        int iH25 = zzabm.h(bArr, iC, zzablVar2);
                        if (i4 != zzablVar2.f37352a) {
                            return iC;
                        }
                        zzaer zzaerVar2 = zzaerVar;
                        zzabl zzablVar3 = zzablVar2;
                        iC = zzabm.c(zzaerVar2, bArr, iH25, i3, i31, zzablVar3);
                        zzadfVar.add(zzablVar3.f37354c);
                        zzaerVar = zzaerVar2;
                        zzablVar2 = zzablVar3;
                    }
                    return iC;
                }
                return i2;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void a(Object obj, byte[] bArr, int i2, int i3, zzabl zzablVar) throws zzadi {
        if (this.f37446h) {
            I(obj, bArr, i2, i3, zzablVar);
        } else {
            z(obj, bArr, i2, i3, 0, zzablVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.google.android.gms.internal.pal.zzaer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.android.gms.internal.pal.zzacz r11, com.google.android.gms.internal.pal.zzacz r12) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.b(com.google.android.gms.internal.pal.zzacz, com.google.android.gms.internal.pal.zzacz):void");
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void c(Object obj, zzaga zzagaVar) throws zzacf {
        if (!this.f37446h) {
            u(obj, zzagaVar);
            return;
        }
        if (this.f37444f) {
            this.n.a(obj);
            throw null;
        }
        int[] iArr = this.f37439a;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i(i2);
            int i4 = iArr[i2];
            switch (h(i3)) {
                case 0:
                    if (w(i2, obj)) {
                        zzagaVar.zzf(i4, zzafs.f37500c.a(obj, i3 & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (w(i2, obj)) {
                        zzagaVar.zzo(i4, zzafs.f37500c.b(obj, i3 & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (w(i2, obj)) {
                        zzagaVar.zzt(i4, zzafs.f37500c.k(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (w(i2, obj)) {
                        zzagaVar.q(i4, zzafs.f37500c.k(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (w(i2, obj)) {
                        zzagaVar.zzr(i4, zzafs.f37500c.j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (w(i2, obj)) {
                        zzagaVar.zzm(i4, zzafs.f37500c.k(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (w(i2, obj)) {
                        zzagaVar.zzk(i4, zzafs.f37500c.j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (w(i2, obj)) {
                        zzagaVar.zzb(i4, zzafs.f37500c.g(obj, i3 & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (w(i2, obj)) {
                        y(i4, zzafs.f37500c.m(i3 & 1048575, obj), zzagaVar);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (w(i2, obj)) {
                        zzagaVar.b(i4, zzafs.f37500c.m(i3 & 1048575, obj), l(i2));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (w(i2, obj)) {
                        zzagaVar.m(i4, (zzaby) zzafs.f37500c.m(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (w(i2, obj)) {
                        zzagaVar.o(i4, zzafs.f37500c.j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (w(i2, obj)) {
                        zzagaVar.zzi(i4, zzafs.f37500c.j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (w(i2, obj)) {
                        zzagaVar.k(i4, zzafs.f37500c.j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (w(i2, obj)) {
                        zzagaVar.p(i4, zzafs.f37500c.k(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (w(i2, obj)) {
                        zzagaVar.i(i4, zzafs.f37500c.j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (w(i2, obj)) {
                        zzagaVar.n(i4, zzafs.f37500c.k(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (w(i2, obj)) {
                        zzagaVar.l(i4, zzafs.f37500c.m(i3 & 1048575, obj), l(i2));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    List list = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls = zzaet.f37467a;
                    if (list != null && !list.isEmpty()) {
                        zzagaVar.zzg(i4, list, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 19:
                    List list2 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls2 = zzaet.f37467a;
                    if (list2 != null && !list2.isEmpty()) {
                        zzagaVar.zzp(i4, list2, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 20:
                    List list3 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls3 = zzaet.f37467a;
                    if (list3 != null && !list3.isEmpty()) {
                        zzagaVar.zzu(i4, list3, false);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    List list4 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls4 = zzaet.f37467a;
                    if (list4 != null && !list4.isEmpty()) {
                        zzagaVar.c(i4, list4, false);
                        break;
                    } else {
                        break;
                    }
                case 22:
                    List list5 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls5 = zzaet.f37467a;
                    if (list5 != null && !list5.isEmpty()) {
                        zzagaVar.zzs(i4, list5, false);
                        break;
                    } else {
                        break;
                    }
                case 23:
                    List list6 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls6 = zzaet.f37467a;
                    if (list6 != null && !list6.isEmpty()) {
                        zzagaVar.zzn(i4, list6, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 24:
                    List list7 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls7 = zzaet.f37467a;
                    if (list7 != null && !list7.isEmpty()) {
                        zzagaVar.zzl(i4, list7, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 25:
                    List list8 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls8 = zzaet.f37467a;
                    if (list8 != null && !list8.isEmpty()) {
                        zzagaVar.zzc(i4, list8, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 26:
                    List list9 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls9 = zzaet.f37467a;
                    if (list9 != null && !list9.isEmpty()) {
                        zzagaVar.e(i4, list9);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 27:
                    List list10 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    zzaer zzaerVarL = l(i2);
                    Class cls10 = zzaet.f37467a;
                    if (list10 != null && !list10.isEmpty()) {
                        for (int i5 = 0; i5 < list10.size(); i5++) {
                            ((zzaci) zzagaVar).b(i4, list10.get(i5), zzaerVarL);
                        }
                        break;
                    } else {
                        break;
                    }
                case 28:
                    List list11 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls11 = zzaet.f37467a;
                    if (list11 != null && !list11.isEmpty()) {
                        zzagaVar.zze(i4, list11);
                        break;
                    } else {
                        break;
                    }
                case 29:
                    List list12 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls12 = zzaet.f37467a;
                    if (list12 != null && !list12.isEmpty()) {
                        zzagaVar.a(i4, list12, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 30:
                    List list13 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls13 = zzaet.f37467a;
                    if (list13 != null && !list13.isEmpty()) {
                        zzagaVar.zzj(i4, list13, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 31:
                    List list14 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls14 = zzaet.f37467a;
                    if (list14 != null && !list14.isEmpty()) {
                        zzagaVar.g(i4, list14, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 32:
                    List list15 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls15 = zzaet.f37467a;
                    if (list15 != null && !list15.isEmpty()) {
                        zzagaVar.d(i4, list15, false);
                        break;
                    } else {
                        break;
                    }
                case 33:
                    List list16 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls16 = zzaet.f37467a;
                    if (list16 != null && !list16.isEmpty()) {
                        zzagaVar.f(i4, list16, false);
                        break;
                    } else {
                        break;
                    }
                case 34:
                    List list17 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls17 = zzaet.f37467a;
                    if (list17 != null && !list17.isEmpty()) {
                        zzagaVar.h(i4, list17, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 35:
                    List list18 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls18 = zzaet.f37467a;
                    if (list18 != null && !list18.isEmpty()) {
                        zzagaVar.zzg(i4, list18, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 36:
                    List list19 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls19 = zzaet.f37467a;
                    if (list19 != null && !list19.isEmpty()) {
                        zzagaVar.zzp(i4, list19, true);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    List list20 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls20 = zzaet.f37467a;
                    if (list20 != null && !list20.isEmpty()) {
                        zzagaVar.zzu(i4, list20, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case Type.A6 /* 38 */:
                    List list21 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls21 = zzaet.f37467a;
                    if (list21 != null && !list21.isEmpty()) {
                        zzagaVar.c(i4, list21, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 39:
                    List list22 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls22 = zzaet.f37467a;
                    if (list22 != null && !list22.isEmpty()) {
                        zzagaVar.zzs(i4, list22, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 40:
                    List list23 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls23 = zzaet.f37467a;
                    if (list23 != null && !list23.isEmpty()) {
                        zzagaVar.zzn(i4, list23, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 41:
                    List list24 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls24 = zzaet.f37467a;
                    if (list24 != null && !list24.isEmpty()) {
                        zzagaVar.zzl(i4, list24, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 42:
                    List list25 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls25 = zzaet.f37467a;
                    if (list25 != null && !list25.isEmpty()) {
                        zzagaVar.zzc(i4, list25, true);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    List list26 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls26 = zzaet.f37467a;
                    if (list26 != null && !list26.isEmpty()) {
                        zzagaVar.a(i4, list26, true);
                        break;
                    } else {
                        break;
                    }
                case 44:
                    List list27 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls27 = zzaet.f37467a;
                    if (list27 != null && !list27.isEmpty()) {
                        zzagaVar.zzj(i4, list27, true);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    List list28 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls28 = zzaet.f37467a;
                    if (list28 != null && !list28.isEmpty()) {
                        zzagaVar.g(i4, list28, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 46:
                    List list29 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls29 = zzaet.f37467a;
                    if (list29 != null && !list29.isEmpty()) {
                        zzagaVar.d(i4, list29, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 47:
                    List list30 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls30 = zzaet.f37467a;
                    if (list30 != null && !list30.isEmpty()) {
                        zzagaVar.f(i4, list30, true);
                        break;
                    } else {
                        break;
                    }
                    break;
                case Type.DNSKEY /* 48 */:
                    List list31 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    Class cls31 = zzaet.f37467a;
                    if (list31 != null && !list31.isEmpty()) {
                        zzagaVar.h(i4, list31, true);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list32 = (List) zzafs.f37500c.m(i3 & 1048575, obj);
                    zzaer zzaerVarL2 = l(i2);
                    Class cls32 = zzaet.f37467a;
                    if (list32 != null && !list32.isEmpty()) {
                        for (int i6 = 0; i6 < list32.size(); i6++) {
                            ((zzaci) zzagaVar).l(i4, list32.get(i6), zzaerVarL2);
                        }
                        break;
                    } else {
                        break;
                    }
                case 50:
                    if (zzafs.f37500c.m(i3 & 1048575, obj) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzf(i4, ((Double) zzafs.f37500c.m(i3 & 1048575, obj)).doubleValue());
                        break;
                    } else {
                        break;
                    }
                case Type.TLSA /* 52 */:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzo(i4, ((Float) zzafs.f37500c.m(i3 & 1048575, obj)).floatValue());
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzt(i4, j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (x(i4, i2, obj)) {
                        zzagaVar.q(i4, j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzr(i4, F(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case Type.NINFO /* 56 */:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzm(i4, j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case Type.RKEY /* 57 */:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzk(i4, F(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case Type.TALINK /* 58 */:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzb(i4, ((Boolean) zzafs.f37500c.m(i3 & 1048575, obj)).booleanValue());
                        break;
                    } else {
                        break;
                    }
                case Type.CDS /* 59 */:
                    if (x(i4, i2, obj)) {
                        y(i4, zzafs.f37500c.m(i3 & 1048575, obj), zzagaVar);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (x(i4, i2, obj)) {
                        zzagaVar.b(i4, zzafs.f37500c.m(i3 & 1048575, obj), l(i2));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (x(i4, i2, obj)) {
                        zzagaVar.m(i4, (zzaby) zzafs.f37500c.m(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (x(i4, i2, obj)) {
                        zzagaVar.o(i4, F(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (x(i4, i2, obj)) {
                        zzagaVar.zzi(i4, F(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (x(i4, i2, obj)) {
                        zzagaVar.k(i4, F(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (x(i4, i2, obj)) {
                        zzagaVar.p(i4, j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (x(i4, i2, obj)) {
                        zzagaVar.i(i4, F(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (x(i4, i2, obj)) {
                        zzagaVar.n(i4, j(i3 & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (x(i4, i2, obj)) {
                        zzagaVar.l(i4, zzafs.f37500c.m(i3 & 1048575, obj), l(i2));
                        break;
                    } else {
                        break;
                    }
            }
        }
        zzafi zzafiVar = this.f37451m;
        zzafiVar.p(zzafiVar.d(obj), zzagaVar);
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final boolean d(zzacz zzaczVar, zzacz zzaczVar2) {
        boolean zB;
        int[] iArr = this.f37439a;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                int i3 = i(i2);
                long j2 = i3 & 1048575;
                switch (h(i3)) {
                    case 0:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar = zzafs.f37500c;
                            if (Double.doubleToLongBits(zzafrVar.a(zzaczVar, j2)) != Double.doubleToLongBits(zzafrVar.a(zzaczVar2, j2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 1:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar2 = zzafs.f37500c;
                            if (Float.floatToIntBits(zzafrVar2.b(zzaczVar, j2)) != Float.floatToIntBits(zzafrVar2.b(zzaczVar2, j2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 2:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar3 = zzafs.f37500c;
                            if (zzafrVar3.k(j2, zzaczVar) != zzafrVar3.k(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 3:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar4 = zzafs.f37500c;
                            if (zzafrVar4.k(j2, zzaczVar) != zzafrVar4.k(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 4:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar5 = zzafs.f37500c;
                            if (zzafrVar5.j(j2, zzaczVar) != zzafrVar5.j(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 5:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar6 = zzafs.f37500c;
                            if (zzafrVar6.k(j2, zzaczVar) != zzafrVar6.k(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 6:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar7 = zzafs.f37500c;
                            if (zzafrVar7.j(j2, zzaczVar) != zzafrVar7.j(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 7:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar8 = zzafs.f37500c;
                            if (zzafrVar8.g(zzaczVar, j2) != zzafrVar8.g(zzaczVar2, j2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 8:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar9 = zzafs.f37500c;
                            if (!zzaet.b(zzafrVar9.m(j2, zzaczVar), zzafrVar9.m(j2, zzaczVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 9:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar10 = zzafs.f37500c;
                            if (!zzaet.b(zzafrVar10.m(j2, zzaczVar), zzafrVar10.m(j2, zzaczVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 10:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar11 = zzafs.f37500c;
                            if (!zzaet.b(zzafrVar11.m(j2, zzaczVar), zzafrVar11.m(j2, zzaczVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 11:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar12 = zzafs.f37500c;
                            if (zzafrVar12.j(j2, zzaczVar) != zzafrVar12.j(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 12:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar13 = zzafs.f37500c;
                            if (zzafrVar13.j(j2, zzaczVar) != zzafrVar13.j(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 13:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar14 = zzafs.f37500c;
                            if (zzafrVar14.j(j2, zzaczVar) != zzafrVar14.j(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 14:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar15 = zzafs.f37500c;
                            if (zzafrVar15.k(j2, zzaczVar) != zzafrVar15.k(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 15:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar16 = zzafs.f37500c;
                            if (zzafrVar16.j(j2, zzaczVar) != zzafrVar16.j(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 16:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar17 = zzafs.f37500c;
                            if (zzafrVar17.k(j2, zzaczVar) != zzafrVar17.k(j2, zzaczVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 17:
                        if (!v(zzaczVar, zzaczVar2, i2)) {
                            break;
                        } else {
                            zzafr zzafrVar18 = zzafs.f37500c;
                            if (!zzaet.b(zzafrVar18.m(j2, zzaczVar), zzafrVar18.m(j2, zzaczVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
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
                        zzafr zzafrVar19 = zzafs.f37500c;
                        zB = zzaet.b(zzafrVar19.m(j2, zzaczVar), zzafrVar19.m(j2, zzaczVar2));
                        break;
                    case 50:
                        zzafr zzafrVar20 = zzafs.f37500c;
                        zB = zzaet.b(zzafrVar20.m(j2, zzaczVar), zzafrVar20.m(j2, zzaczVar2));
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
                        zzafr zzafrVar21 = zzafs.f37500c;
                        if (zzafrVar21.j(j3, zzaczVar) != zzafrVar21.j(j3, zzaczVar2) || !zzaet.b(zzafrVar21.m(j2, zzaczVar), zzafrVar21.m(j2, zzaczVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    default:
                        i2 += 3;
                }
                if (zB) {
                    i2 += 3;
                }
            } else {
                zzafi zzafiVar = this.f37451m;
                if (zzafiVar.d(zzaczVar).equals(zzafiVar.d(zzaczVar2))) {
                    if (!this.f37444f) {
                        return true;
                    }
                    this.n.a(zzaczVar);
                    throw null;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05c7 A[Catch: all -> 0x04b1, TryCatch #0 {all -> 0x04b1, blocks: (B:170:0x05c2, B:172:0x05c7, B:173:0x05cc, B:136:0x044a, B:137:0x0456, B:138:0x0468, B:139:0x047a, B:140:0x048c, B:142:0x0499, B:145:0x04a0, B:147:0x04a4, B:149:0x04aa, B:152:0x04b4, B:153:0x04bf, B:154:0x04d1, B:155:0x04e3, B:157:0x04ec, B:158:0x0506, B:159:0x0519, B:160:0x0524, B:161:0x0538, B:162:0x054a, B:163:0x055b, B:164:0x056c, B:165:0x057d, B:166:0x058e, B:167:0x05a1), top: B:188:0x05c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05d2 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [int] */
    @Override // com.google.android.gms.internal.pal.zzaer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r20, com.google.android.gms.internal.pal.zzacd r21, com.google.android.gms.internal.pal.zzacm r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.e(java.lang.Object, com.google.android.gms.internal.pal.zzacd, com.google.android.gms.internal.pal.zzacm):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[PHI: r3
      0x00e4: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:84:0x0219, B:42:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.pal.zzaer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(com.google.android.gms.internal.pal.zzacz r12) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.f(com.google.android.gms.internal.pal.zzacz):int");
    }

    public final int g(int i2, int i3) {
        int[] iArr = this.f37439a;
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

    public final int i(int i2) {
        return this.f37439a[i2 + 1];
    }

    public final zzadd k(int i2) {
        int i3 = i2 / 3;
        return (zzadd) this.f37440b[i3 + i3 + 1];
    }

    public final zzaer l(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        Object[] objArr = this.f37440b;
        zzaer zzaerVar = (zzaer) objArr[i4];
        if (zzaerVar != null) {
            return zzaerVar;
        }
        zzaer zzaerVarA = zzaen.f37457c.a((Class) objArr[i4 + 1]);
        objArr[i4] = zzaerVarA;
        return zzaerVarA;
    }

    public final void m(int i2, Object obj, Object obj2) {
        int i3 = this.f37439a[i2];
        Object objM = zzafs.f37500c.m(i(i2) & 1048575, obj);
        if (objM == null || k(i2) == null) {
            return;
        }
        throw null;
    }

    public final Object n(int i2) {
        int i3 = i2 / 3;
        return this.f37440b[i3 + i3];
    }

    public final void p(zzacz zzaczVar, zzacz zzaczVar2, int i2) {
        long jI = i(i2) & 1048575;
        if (w(i2, zzaczVar2)) {
            zzafr zzafrVar = zzafs.f37500c;
            Object objM = zzafrVar.m(jI, zzaczVar);
            Object objM2 = zzafrVar.m(jI, zzaczVar2);
            if (objM != null && objM2 != null) {
                zzafs.h(zzaczVar, jI, zzadg.b(objM, objM2));
                s(i2, zzaczVar);
            } else if (objM2 != null) {
                zzafs.h(zzaczVar, jI, objM2);
                s(i2, zzaczVar);
            }
        }
    }

    public final void q(zzacz zzaczVar, zzacz zzaczVar2, int i2) {
        int i3 = i(i2);
        int i4 = this.f37439a[i2];
        long j2 = i3 & 1048575;
        if (x(i4, i2, zzaczVar2)) {
            Object objM = x(i4, i2, zzaczVar) ? zzafs.f37500c.m(j2, zzaczVar) : null;
            Object objM2 = zzafs.f37500c.m(j2, zzaczVar2);
            if (objM != null && objM2 != null) {
                zzafs.h(zzaczVar, j2, zzadg.b(objM, objM2));
                t(i4, i2, zzaczVar);
            } else if (objM2 != null) {
                zzafs.h(zzaczVar, j2, objM2);
                t(i4, i2, zzaczVar);
            }
        }
    }

    public final void r(Object obj, int i2, zzacd zzacdVar) {
        if ((536870912 & i2) != 0) {
            zzafs.h(obj, i2 & 1048575, zzacdVar.M());
        } else if (this.f37445g) {
            zzafs.h(obj, i2 & 1048575, zzacdVar.L());
        } else {
            zzafs.h(obj, i2 & 1048575, zzacdVar.I());
        }
    }

    public final void s(int i2, Object obj) {
        int i3 = this.f37439a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        zzafs.f(obj, j2, (1 << (i3 >>> 20)) | zzafs.f37500c.j(j2, obj));
    }

    public final void t(int i2, int i3, Object obj) {
        zzafs.f(obj, this.f37439a[i3 + 2] & 1048575, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void u(Object obj, zzaga zzagaVar) throws zzacf {
        int i2;
        int i3;
        boolean z;
        boolean z2 = true;
        if (this.f37444f) {
            this.n.a(obj);
            throw null;
        }
        int[] iArr = this.f37439a;
        int length = iArr.length;
        Unsafe unsafe = p;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < length) {
            int i7 = i(i4);
            int i8 = iArr[i4];
            int iH = h(i7);
            if (iH <= 17) {
                int i9 = iArr[i4 + 2];
                i2 = 1048575;
                int i10 = i9 & 1048575;
                if (i10 != i6) {
                    i5 = unsafe.getInt(obj, i10);
                    i6 = i10;
                }
                i3 = (z2 ? 1 : 0) << (i9 >>> 20);
            } else {
                i2 = 1048575;
                i3 = 0;
            }
            long j2 = i7 & i2;
            switch (iH) {
                case 0:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzf(i8, zzafs.f37500c.a(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 1:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzo(i8, zzafs.f37500c.b(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 2:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzt(i8, unsafe.getLong(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 3:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.q(i8, unsafe.getLong(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 4:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzr(i8, unsafe.getInt(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 5:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzm(i8, unsafe.getLong(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 6:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzk(i8, unsafe.getInt(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 7:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzb(i8, zzafs.f37500c.g(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 8:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        y(i8, unsafe.getObject(obj, j2), zzagaVar);
                    }
                    i4 += 3;
                    z2 = z;
                case 9:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.b(i8, unsafe.getObject(obj, j2), l(i4));
                    }
                    i4 += 3;
                    z2 = z;
                case 10:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.m(i8, (zzaby) unsafe.getObject(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 11:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.o(i8, unsafe.getInt(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 12:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.zzi(i8, unsafe.getInt(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 13:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.k(i8, unsafe.getInt(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 14:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.p(i8, unsafe.getLong(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 15:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.i(i8, unsafe.getInt(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 16:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.n(i8, unsafe.getLong(obj, j2));
                    }
                    i4 += 3;
                    z2 = z;
                case 17:
                    z = z2 ? 1 : 0;
                    if ((i5 & i3) != 0) {
                        zzagaVar.l(i8, unsafe.getObject(obj, j2), l(i4));
                    }
                    i4 += 3;
                    z2 = z;
                case 18:
                    z = z2 ? 1 : 0;
                    int i11 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j2);
                    Class cls = zzaet.f37467a;
                    if (list != null && !list.isEmpty()) {
                        zzagaVar.zzg(i11, list, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 19:
                    z = z2 ? 1 : 0;
                    int i12 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j2);
                    Class cls2 = zzaet.f37467a;
                    if (list2 != null && !list2.isEmpty()) {
                        zzagaVar.zzp(i12, list2, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 20:
                    z = z2 ? 1 : 0;
                    int i13 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j2);
                    Class cls3 = zzaet.f37467a;
                    if (list3 != null && !list3.isEmpty()) {
                        zzagaVar.zzu(i13, list3, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 21:
                    z = z2 ? 1 : 0;
                    int i14 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j2);
                    Class cls4 = zzaet.f37467a;
                    if (list4 != null && !list4.isEmpty()) {
                        zzagaVar.c(i14, list4, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 22:
                    z = z2 ? 1 : 0;
                    int i15 = iArr[i4];
                    List list5 = (List) unsafe.getObject(obj, j2);
                    Class cls5 = zzaet.f37467a;
                    if (list5 != null && !list5.isEmpty()) {
                        zzagaVar.zzs(i15, list5, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 23:
                    z = z2 ? 1 : 0;
                    int i16 = iArr[i4];
                    List list6 = (List) unsafe.getObject(obj, j2);
                    Class cls6 = zzaet.f37467a;
                    if (list6 != null && !list6.isEmpty()) {
                        zzagaVar.zzn(i16, list6, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 24:
                    z = z2 ? 1 : 0;
                    int i17 = iArr[i4];
                    List list7 = (List) unsafe.getObject(obj, j2);
                    Class cls7 = zzaet.f37467a;
                    if (list7 != null && !list7.isEmpty()) {
                        zzagaVar.zzl(i17, list7, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 25:
                    z = z2 ? 1 : 0;
                    int i18 = iArr[i4];
                    List list8 = (List) unsafe.getObject(obj, j2);
                    Class cls8 = zzaet.f37467a;
                    if (list8 != null && !list8.isEmpty()) {
                        zzagaVar.zzc(i18, list8, false);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 26:
                    z = z2 ? 1 : 0;
                    int i19 = iArr[i4];
                    List list9 = (List) unsafe.getObject(obj, j2);
                    Class cls9 = zzaet.f37467a;
                    if (list9 != null && !list9.isEmpty()) {
                        zzagaVar.e(i19, list9);
                    }
                    i4 += 3;
                    z2 = z;
                    break;
                case 27:
                    int i20 = iArr[i4];
                    List list10 = (List) unsafe.getObject(obj, j2);
                    zzaer zzaerVarL = l(i4);
                    Class cls10 = zzaet.f37467a;
                    if (list10 != null && !list10.isEmpty()) {
                        int i21 = 0;
                        while (i21 < list10.size()) {
                            Object obj2 = list10.get(i21);
                            boolean z3 = z2 ? 1 : 0;
                            ((zzaci) zzagaVar).b(i20, obj2, zzaerVarL);
                            i21++;
                            z2 = z3;
                        }
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 28:
                    int i22 = iArr[i4];
                    List list11 = (List) unsafe.getObject(obj, j2);
                    Class cls11 = zzaet.f37467a;
                    if (list11 != null && !list11.isEmpty()) {
                        zzagaVar.zze(i22, list11);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 29:
                    int i23 = iArr[i4];
                    List list12 = (List) unsafe.getObject(obj, j2);
                    Class cls12 = zzaet.f37467a;
                    if (list12 != null && !list12.isEmpty()) {
                        zzagaVar.a(i23, list12, false);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 30:
                    int i24 = iArr[i4];
                    List list13 = (List) unsafe.getObject(obj, j2);
                    Class cls13 = zzaet.f37467a;
                    if (list13 != null && !list13.isEmpty()) {
                        zzagaVar.zzj(i24, list13, false);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 31:
                    int i25 = iArr[i4];
                    List list14 = (List) unsafe.getObject(obj, j2);
                    Class cls14 = zzaet.f37467a;
                    if (list14 != null && !list14.isEmpty()) {
                        zzagaVar.g(i25, list14, false);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 32:
                    int i26 = iArr[i4];
                    List list15 = (List) unsafe.getObject(obj, j2);
                    Class cls15 = zzaet.f37467a;
                    if (list15 != null && !list15.isEmpty()) {
                        zzagaVar.d(i26, list15, false);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 33:
                    int i27 = iArr[i4];
                    List list16 = (List) unsafe.getObject(obj, j2);
                    Class cls16 = zzaet.f37467a;
                    if (list16 != null && !list16.isEmpty()) {
                        zzagaVar.f(i27, list16, false);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 34:
                    int i28 = iArr[i4];
                    List list17 = (List) unsafe.getObject(obj, j2);
                    Class cls17 = zzaet.f37467a;
                    if (list17 != null && !list17.isEmpty()) {
                        zzagaVar.h(i28, list17, false);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 35:
                    int i29 = iArr[i4];
                    List list18 = (List) unsafe.getObject(obj, j2);
                    Class cls18 = zzaet.f37467a;
                    if (list18 != null && !list18.isEmpty()) {
                        zzagaVar.zzg(i29, list18, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 36:
                    int i30 = iArr[i4];
                    List list19 = (List) unsafe.getObject(obj, j2);
                    Class cls19 = zzaet.f37467a;
                    if (list19 != null && !list19.isEmpty()) {
                        zzagaVar.zzp(i30, list19, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 37:
                    int i31 = iArr[i4];
                    List list20 = (List) unsafe.getObject(obj, j2);
                    Class cls20 = zzaet.f37467a;
                    if (list20 != null && !list20.isEmpty()) {
                        zzagaVar.zzu(i31, list20, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case Type.A6 /* 38 */:
                    int i32 = iArr[i4];
                    List list21 = (List) unsafe.getObject(obj, j2);
                    Class cls21 = zzaet.f37467a;
                    if (list21 != null && !list21.isEmpty()) {
                        zzagaVar.c(i32, list21, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 39:
                    int i33 = iArr[i4];
                    List list22 = (List) unsafe.getObject(obj, j2);
                    Class cls22 = zzaet.f37467a;
                    if (list22 != null && !list22.isEmpty()) {
                        zzagaVar.zzs(i33, list22, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 40:
                    int i34 = iArr[i4];
                    List list23 = (List) unsafe.getObject(obj, j2);
                    Class cls23 = zzaet.f37467a;
                    if (list23 != null && !list23.isEmpty()) {
                        zzagaVar.zzn(i34, list23, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 41:
                    int i35 = iArr[i4];
                    List list24 = (List) unsafe.getObject(obj, j2);
                    Class cls24 = zzaet.f37467a;
                    if (list24 != null && !list24.isEmpty()) {
                        zzagaVar.zzl(i35, list24, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 42:
                    int i36 = iArr[i4];
                    List list25 = (List) unsafe.getObject(obj, j2);
                    Class cls25 = zzaet.f37467a;
                    if (list25 != null && !list25.isEmpty()) {
                        zzagaVar.zzc(i36, list25, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 43:
                    int i37 = iArr[i4];
                    List list26 = (List) unsafe.getObject(obj, j2);
                    Class cls26 = zzaet.f37467a;
                    if (list26 != null && !list26.isEmpty()) {
                        zzagaVar.a(i37, list26, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 44:
                    int i38 = iArr[i4];
                    List list27 = (List) unsafe.getObject(obj, j2);
                    Class cls27 = zzaet.f37467a;
                    if (list27 != null && !list27.isEmpty()) {
                        zzagaVar.zzj(i38, list27, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 45:
                    int i39 = iArr[i4];
                    List list28 = (List) unsafe.getObject(obj, j2);
                    Class cls28 = zzaet.f37467a;
                    if (list28 != null && !list28.isEmpty()) {
                        zzagaVar.g(i39, list28, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 46:
                    int i40 = iArr[i4];
                    List list29 = (List) unsafe.getObject(obj, j2);
                    Class cls29 = zzaet.f37467a;
                    if (list29 != null && !list29.isEmpty()) {
                        zzagaVar.d(i40, list29, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 47:
                    int i41 = iArr[i4];
                    List list30 = (List) unsafe.getObject(obj, j2);
                    Class cls30 = zzaet.f37467a;
                    if (list30 != null && !list30.isEmpty()) {
                        zzagaVar.f(i41, list30, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case Type.DNSKEY /* 48 */:
                    int i42 = iArr[i4];
                    List list31 = (List) unsafe.getObject(obj, j2);
                    Class cls31 = zzaet.f37467a;
                    if (list31 != null && !list31.isEmpty()) {
                        zzagaVar.h(i42, list31, z2);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 49:
                    int i43 = iArr[i4];
                    List list32 = (List) unsafe.getObject(obj, j2);
                    zzaer zzaerVarL2 = l(i4);
                    Class cls32 = zzaet.f37467a;
                    if (list32 != null && !list32.isEmpty()) {
                        for (int i44 = 0; i44 < list32.size(); i44 += z2 ? 1 : 0) {
                            ((zzaci) zzagaVar).l(i43, list32.get(i44), zzaerVarL2);
                        }
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j2) != null) {
                        throw null;
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 51:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzf(i8, ((Double) zzafs.f37500c.m(j2, obj)).doubleValue());
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case Type.TLSA /* 52 */:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzo(i8, ((Float) zzafs.f37500c.m(j2, obj)).floatValue());
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 53:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzt(i8, j(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 54:
                    if (x(i8, i4, obj)) {
                        zzagaVar.q(i8, j(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 55:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzr(i8, F(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case Type.NINFO /* 56 */:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzm(i8, j(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case Type.RKEY /* 57 */:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzk(i8, F(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case Type.TALINK /* 58 */:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzb(i8, ((Boolean) zzafs.f37500c.m(j2, obj)).booleanValue());
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case Type.CDS /* 59 */:
                    if (x(i8, i4, obj)) {
                        y(i8, unsafe.getObject(obj, j2), zzagaVar);
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 60:
                    if (x(i8, i4, obj)) {
                        zzagaVar.b(i8, unsafe.getObject(obj, j2), l(i4));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 61:
                    if (x(i8, i4, obj)) {
                        zzagaVar.m(i8, (zzaby) unsafe.getObject(obj, j2));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 62:
                    if (x(i8, i4, obj)) {
                        zzagaVar.o(i8, F(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 63:
                    if (x(i8, i4, obj)) {
                        zzagaVar.zzi(i8, F(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 64:
                    if (x(i8, i4, obj)) {
                        zzagaVar.k(i8, F(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 65:
                    if (x(i8, i4, obj)) {
                        zzagaVar.p(i8, j(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (x(i8, i4, obj)) {
                        zzagaVar.i(i8, F(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case 67:
                    if (x(i8, i4, obj)) {
                        zzagaVar.n(i8, j(j2, obj));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (x(i8, i4, obj)) {
                        zzagaVar.l(i8, unsafe.getObject(obj, j2), l(i4));
                    }
                    z = z2;
                    i4 += 3;
                    z2 = z;
                default:
                    z = z2;
                    i4 += 3;
                    z2 = z;
            }
        }
        zzafi zzafiVar = this.f37451m;
        zzafiVar.p(zzafiVar.d(obj), zzagaVar);
    }

    public final boolean v(zzacz zzaczVar, zzacz zzaczVar2, int i2) {
        return w(i2, zzaczVar) == w(i2, zzaczVar2);
    }

    public final boolean w(int i2, Object obj) {
        int i3 = this.f37439a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int i4 = i(i2);
            long j3 = i4 & 1048575;
            switch (h(i4)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzafs.f37500c.a(obj, j3)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzafs.f37500c.b(obj, j3)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzafs.f37500c.k(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzafs.f37500c.k(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzafs.f37500c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzafs.f37500c.k(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzafs.f37500c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzafs.f37500c.g(obj, j3);
                case 8:
                    Object objM = zzafs.f37500c.m(j3, obj);
                    if (objM instanceof String) {
                        if (((String) objM).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objM instanceof zzaby)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzaby.f37363b.equals(objM)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (zzafs.f37500c.m(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzaby.f37363b.equals(zzafs.f37500c.m(j3, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzafs.f37500c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzafs.f37500c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzafs.f37500c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzafs.f37500c.k(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzafs.f37500c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzafs.f37500c.k(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzafs.f37500c.m(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzafs.f37500c.j(j2, obj) & (1 << (i3 >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    public final boolean x(int i2, int i3, Object obj) {
        return zzafs.f37500c.j((long) (this.f37439a[i3 + 2] & 1048575), obj) == i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x047c, code lost:
    
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x04dd, code lost:
    
        if (r0 == r1) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x04df, code lost:
    
        r26.putInt(r9, r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x04e5, code lost:
    
        r0 = r8.f37448j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x04e9, code lost:
    
        if (r0 >= r8.f37449k) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x04eb, code lost:
    
        r8.m(r8.f37447i[r0], r9, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04f5, code lost:
    
        if (r7 != 0) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x04f7, code lost:
    
        if (r4 != r3) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x04fe, code lost:
    
        throw com.google.android.gms.internal.pal.zzadi.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x04ff, code lost:
    
        if (r4 > r3) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0501, code lost:
    
        if (r6 != r7) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0503, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0508, code lost:
    
        throw com.google.android.gms.internal.pal.zzadi.d();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int z(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.pal.zzabl r35) {
        /*
            Method dump skipped, instructions count: 1328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.z(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.pal.zzabl):int");
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final int zza(Object obj) {
        return this.f37446h ? E(obj) : D(obj);
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final Object zze() {
        return ((zzacz) this.f37443e).o(4);
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void zzf(Object obj) {
        int[] iArr;
        int i2;
        int i3 = this.f37448j;
        while (true) {
            iArr = this.f37447i;
            i2 = this.f37449k;
            if (i3 >= i2) {
                break;
            }
            long jI = i(iArr[i3]) & 1048575;
            Object objM = zzafs.f37500c.m(jI, obj);
            if (objM != null) {
                ((zzadz) objM).f37436a = false;
                zzafs.h(obj, jI, objM);
            }
            i3++;
        }
        int length = iArr.length;
        while (i2 < length) {
            this.f37450l.b(obj, iArr[i2]);
            i2++;
        }
        this.f37451m.m(obj);
        if (this.f37444f) {
            this.n.d(obj);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    @Override // com.google.android.gms.internal.pal.zzaer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzl(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzaei.zzl(java.lang.Object):boolean");
    }
}
