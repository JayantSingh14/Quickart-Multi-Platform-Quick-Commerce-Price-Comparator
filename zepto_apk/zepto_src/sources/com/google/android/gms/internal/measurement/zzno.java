package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzno<T> implements zznw<T> {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f37144l = new int[0];

    /* renamed from: m, reason: collision with root package name */
    public static final Unsafe f37145m = zzoo.k();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f37146a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f37147b;

    /* renamed from: c, reason: collision with root package name */
    public final int f37148c;

    /* renamed from: d, reason: collision with root package name */
    public final int f37149d;

    /* renamed from: e, reason: collision with root package name */
    public final zznl f37150e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f37151f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f37152g;

    /* renamed from: h, reason: collision with root package name */
    public final int f37153h;

    /* renamed from: i, reason: collision with root package name */
    public final int f37154i;

    /* renamed from: j, reason: collision with root package name */
    public final zzoj f37155j;

    /* renamed from: k, reason: collision with root package name */
    public final zzls f37156k;

    public zzno(int[] iArr, Object[] objArr, int i2, int i3, zznl zznlVar, int[] iArr2, int i4, int i5, zzoj zzojVar, zzls zzlsVar) {
        this.f37146a = iArr;
        this.f37147b = objArr;
        this.f37148c = i2;
        this.f37149d = i3;
        boolean z = false;
        if (zzlsVar != null && (zznlVar instanceof zzmb)) {
            z = true;
        }
        this.f37151f = z;
        this.f37152g = iArr2;
        this.f37153h = i4;
        this.f37154i = i5;
        this.f37155j = zzojVar;
        this.f37156k = zzlsVar;
        this.f37150e = zznlVar;
    }

    public static int F(int i2) {
        return (i2 >>> 20) & 255;
    }

    public static boolean i(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzme) {
            return ((zzme) obj).i();
        }
        return true;
    }

    public static int j(long j2, Object obj) {
        return ((Integer) zzoo.i(j2, obj)).intValue();
    }

    public static long k(long j2, Object obj) {
        return ((Long) zzoo.i(j2, obj)).longValue();
    }

    public static final int r(byte[] bArr, int i2, int i3, zzos zzosVar, Class cls, zzkv zzkvVar) {
        zzos zzosVar2 = zzos.f37202c;
        switch (zzosVar.ordinal()) {
            case 0:
                int i4 = i2 + 8;
                zzkvVar.f37061c = Double.valueOf(Double.longBitsToDouble(zzkw.e(i2, bArr)));
                return i4;
            case 1:
                int i5 = i2 + 4;
                zzkvVar.f37061c = Float.valueOf(Float.intBitsToFloat(zzkw.d(i2, bArr)));
                return i5;
            case 2:
            case 3:
                int iC = zzkw.c(bArr, i2, zzkvVar);
                zzkvVar.f37061c = Long.valueOf(zzkvVar.f37060b);
                return iC;
            case 4:
            case 12:
            case 13:
                int iA = zzkw.a(bArr, i2, zzkvVar);
                zzkvVar.f37061c = Integer.valueOf(zzkvVar.f37059a);
                return iA;
            case 5:
            case 15:
                int i6 = i2 + 8;
                zzkvVar.f37061c = Long.valueOf(zzkw.e(i2, bArr));
                return i6;
            case 6:
            case 14:
                int i7 = i2 + 4;
                zzkvVar.f37061c = Integer.valueOf(zzkw.d(i2, bArr));
                return i7;
            case 7:
                int iC2 = zzkw.c(bArr, i2, zzkvVar);
                zzkvVar.f37061c = Boolean.valueOf(zzkvVar.f37060b != 0);
                return iC2;
            case 8:
                return zzkw.f(bArr, i2, zzkvVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                zznw zznwVarA = zznt.f37161c.a(cls);
                Object objZza = zznwVarA.zza();
                int iH = zzkw.h(objZza, zznwVarA, bArr, i2, i3, zzkvVar);
                zznwVarA.d(objZza);
                zzkvVar.f37061c = objZza;
                return iH;
            case 11:
                return zzkw.g(bArr, i2, zzkvVar);
            case 16:
                int iA2 = zzkw.a(bArr, i2, zzkvVar);
                zzkvVar.f37061c = Integer.valueOf(zzli.a(zzkvVar.f37059a));
                return iA2;
            case 17:
                int iC3 = zzkw.c(bArr, i2, zzkvVar);
                zzkvVar.f37061c = Long.valueOf(zzli.b(zzkvVar.f37060b));
                return iC3;
        }
    }

    public static zzoi s(Object obj) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVar = zzmeVar.zzc;
        if (zzoiVar != zzoi.f37187f) {
            return zzoiVar;
        }
        zzoi zzoiVarA = zzoi.a();
        zzmeVar.zzc = zzoiVarA;
        return zzoiVarA;
    }

    public static zzno u(zzni zzniVar, zzoj zzojVar, zzls zzlsVar) {
        int i2;
        int iCharAt;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        char cCharAt;
        int i10;
        char cCharAt2;
        int i11;
        char cCharAt3;
        int i12;
        char cCharAt4;
        int i13;
        char cCharAt5;
        int i14;
        char cCharAt6;
        int i15;
        char cCharAt7;
        int i16;
        char cCharAt8;
        int i17;
        int i18;
        int i19;
        Object[] objArr;
        int i20;
        int i21;
        int iObjectFieldOffset;
        int i22;
        int i23;
        int i24;
        int i25;
        Field fieldV;
        int i26;
        char cCharAt9;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Field fieldV2;
        Field fieldV3;
        int i32;
        char cCharAt10;
        int i33;
        int i34;
        char cCharAt11;
        int i35;
        char cCharAt12;
        int i36;
        char cCharAt13;
        if (!(zzniVar instanceof zznv)) {
            throw null;
        }
        zznv zznvVar = (zznv) zzniVar;
        String str = zznvVar.f37169b;
        int length = str.length();
        char c2 = 55296;
        if (str.charAt(0) >= 55296) {
            int i37 = 1;
            while (true) {
                i2 = i37 + 1;
                if (str.charAt(i37) < 55296) {
                    break;
                }
                i37 = i2;
            }
        } else {
            i2 = 1;
        }
        int i38 = i2 + 1;
        int iCharAt2 = str.charAt(i2);
        if (iCharAt2 >= 55296) {
            int i39 = iCharAt2 & 8191;
            int i40 = 13;
            while (true) {
                i36 = i38 + 1;
                cCharAt13 = str.charAt(i38);
                if (cCharAt13 < 55296) {
                    break;
                }
                i39 |= (cCharAt13 & 8191) << i40;
                i40 += 13;
                i38 = i36;
            }
            iCharAt2 = i39 | (cCharAt13 << i40);
            i38 = i36;
        }
        if (iCharAt2 == 0) {
            i5 = 0;
            i7 = 0;
            iCharAt = 0;
            i4 = 0;
            i6 = 0;
            i8 = 0;
            iArr = f37144l;
            i3 = 0;
        } else {
            int i41 = i38 + 1;
            int iCharAt3 = str.charAt(i38);
            if (iCharAt3 >= 55296) {
                int i42 = iCharAt3 & 8191;
                int i43 = 13;
                while (true) {
                    i16 = i41 + 1;
                    cCharAt8 = str.charAt(i41);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i16;
                }
                iCharAt3 = i42 | (cCharAt8 << i43);
                i41 = i16;
            }
            int i44 = i41 + 1;
            int iCharAt4 = str.charAt(i41);
            if (iCharAt4 >= 55296) {
                int i45 = iCharAt4 & 8191;
                int i46 = 13;
                while (true) {
                    i15 = i44 + 1;
                    cCharAt7 = str.charAt(i44);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i15;
                }
                iCharAt4 = i45 | (cCharAt7 << i46);
                i44 = i15;
            }
            int i47 = i44 + 1;
            int iCharAt5 = str.charAt(i44);
            if (iCharAt5 >= 55296) {
                int i48 = iCharAt5 & 8191;
                int i49 = 13;
                while (true) {
                    i14 = i47 + 1;
                    cCharAt6 = str.charAt(i47);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i14;
                }
                iCharAt5 = i48 | (cCharAt6 << i49);
                i47 = i14;
            }
            int i50 = i47 + 1;
            int iCharAt6 = str.charAt(i47);
            if (iCharAt6 >= 55296) {
                int i51 = iCharAt6 & 8191;
                int i52 = 13;
                while (true) {
                    i13 = i50 + 1;
                    cCharAt5 = str.charAt(i50);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i13;
                }
                iCharAt6 = i51 | (cCharAt5 << i52);
                i50 = i13;
            }
            int i53 = i50 + 1;
            iCharAt = str.charAt(i50);
            if (iCharAt >= 55296) {
                int i54 = iCharAt & 8191;
                int i55 = 13;
                while (true) {
                    i12 = i53 + 1;
                    cCharAt4 = str.charAt(i53);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i12;
                }
                iCharAt = i54 | (cCharAt4 << i55);
                i53 = i12;
            }
            int i56 = i53 + 1;
            int iCharAt7 = str.charAt(i53);
            if (iCharAt7 >= 55296) {
                int i57 = iCharAt7 & 8191;
                int i58 = 13;
                while (true) {
                    i11 = i56 + 1;
                    cCharAt3 = str.charAt(i56);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i11;
                }
                iCharAt7 = i57 | (cCharAt3 << i58);
                i56 = i11;
            }
            int i59 = i56 + 1;
            int iCharAt8 = str.charAt(i56);
            if (iCharAt8 >= 55296) {
                int i60 = iCharAt8 & 8191;
                int i61 = 13;
                while (true) {
                    i10 = i59 + 1;
                    cCharAt2 = str.charAt(i59);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt2 & 8191) << i61;
                    i61 += 13;
                    i59 = i10;
                }
                iCharAt8 = i60 | (cCharAt2 << i61);
                i59 = i10;
            }
            int i62 = i59 + 1;
            int iCharAt9 = str.charAt(i59);
            if (iCharAt9 >= 55296) {
                int i63 = iCharAt9 & 8191;
                int i64 = 13;
                while (true) {
                    i9 = i62 + 1;
                    cCharAt = str.charAt(i62);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i63 |= (cCharAt & 8191) << i64;
                    i64 += 13;
                    i62 = i9;
                }
                iCharAt9 = i63 | (cCharAt << i64);
                i62 = i9;
            }
            int i65 = iCharAt3 + iCharAt3 + iCharAt4;
            i3 = iCharAt3;
            i38 = i62;
            iArr = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i66 = iCharAt7;
            i4 = iCharAt5;
            i5 = i66;
            i6 = iCharAt6;
            i7 = i65;
            i8 = iCharAt9;
        }
        Unsafe unsafe = f37145m;
        Class<?> cls = zznvVar.f37168a.getClass();
        int i67 = i8 + i5;
        int i68 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr2 = new Object[i68];
        int i69 = i8;
        int i70 = i67;
        int i71 = 0;
        int i72 = 0;
        while (i38 < length) {
            int i73 = i38 + 1;
            int iCharAt10 = str.charAt(i38);
            if (iCharAt10 >= c2) {
                int i74 = iCharAt10 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i35 = i75 + 1;
                    cCharAt12 = str.charAt(i75);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i74 |= (cCharAt12 & 8191) << i76;
                    i76 += 13;
                    i75 = i35;
                }
                iCharAt10 = i74 | (cCharAt12 << i76);
                i17 = i35;
            } else {
                i17 = i73;
            }
            int i77 = i17 + 1;
            int iCharAt11 = str.charAt(i17);
            if (iCharAt11 >= c2) {
                int i78 = iCharAt11 & 8191;
                int i79 = i77;
                int i80 = 13;
                while (true) {
                    i34 = i79 + 1;
                    cCharAt11 = str.charAt(i79);
                    i18 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i78 |= (cCharAt11 & 8191) << i80;
                    i80 += 13;
                    i79 = i34;
                    length = i18;
                }
                iCharAt11 = i78 | (cCharAt11 << i80);
                i19 = i34;
            } else {
                i18 = length;
                i19 = i77;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i72] = i71;
                i72++;
            }
            int i81 = iCharAt11 & 255;
            int i82 = iCharAt10;
            int i83 = iCharAt11 & 2048;
            Object[] objArr3 = zznvVar.f37170c;
            if (i81 >= 51) {
                int i84 = i19 + 1;
                int iCharAt12 = str.charAt(i19);
                if (iCharAt12 >= 55296) {
                    int i85 = iCharAt12 & 8191;
                    int i86 = i84;
                    int i87 = 13;
                    while (true) {
                        i32 = i86 + 1;
                        cCharAt10 = str.charAt(i86);
                        i33 = i85;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i85 = i33 | ((cCharAt10 & 8191) << i87);
                        i87 += 13;
                        i86 = i32;
                    }
                    iCharAt12 = i33 | (cCharAt10 << i87);
                    i30 = i32;
                } else {
                    i30 = i84;
                }
                int i88 = iCharAt12;
                int i89 = i81 - 51;
                int i90 = i30;
                if (i89 == 9 || i89 == 17) {
                    objArr2[e.b(i71, 3, 1)] = objArr3[i7];
                    i31 = i83;
                    i7++;
                } else if (i89 != 12) {
                    i31 = i83;
                } else if (zznvVar.zzc() == 1 || i83 != 0) {
                    objArr2[e.b(i71, 3, 1)] = objArr3[i7];
                    i7++;
                    i31 = i83;
                } else {
                    i31 = 0;
                }
                int i91 = i88 + i88;
                Object obj = objArr3[i91];
                int i92 = i31;
                if (obj instanceof Field) {
                    fieldV2 = (Field) obj;
                } else {
                    fieldV2 = v(cls, (String) obj);
                    objArr3[i91] = fieldV2;
                }
                Object[] objArr4 = objArr2;
                int i93 = i7;
                int iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldV2);
                int i94 = i91 + 1;
                Object obj2 = objArr3[i94];
                if (obj2 instanceof Field) {
                    fieldV3 = (Field) obj2;
                } else {
                    fieldV3 = v(cls, (String) obj2);
                    objArr3[i94] = fieldV3;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldV3);
                i25 = iObjectFieldOffset2;
                i83 = i92;
                i7 = i93;
                i20 = i3;
                i22 = i90;
                objArr = objArr4;
                i24 = 0;
            } else {
                Object[] objArr5 = objArr2;
                int i95 = i7 + 1;
                objArr = objArr5;
                Field fieldV4 = v(cls, (String) objArr3[i7]);
                i20 = i3;
                if (i81 == 9 || i81 == 17) {
                    i21 = i95;
                    objArr[e.b(i71, 3, 1)] = fieldV4.getType();
                } else {
                    if (i81 == 27) {
                        i27 = i95;
                        i28 = 1;
                        i29 = i7 + 2;
                    } else if (i81 == 49) {
                        i29 = i7 + 2;
                        i27 = i95;
                        i28 = 1;
                    } else if (i81 == 12 || i81 == 30 || i81 == 44) {
                        i21 = i95;
                        if (zznvVar.zzc() == 1 || i83 != 0) {
                            i29 = i7 + 2;
                            objArr[e.b(i71, 3, 1)] = objArr3[i21];
                            i21 = i29;
                        } else {
                            i83 = 0;
                        }
                    } else if (i81 == 50) {
                        int i96 = i7 + 2;
                        int i97 = i69 + 1;
                        iArr[i69] = i71;
                        int i98 = i71 / 3;
                        int i99 = i98 + i98;
                        objArr[i99] = objArr3[i95];
                        if (i83 != 0) {
                            objArr[i99 + 1] = objArr3[i96];
                            i69 = i97;
                            i21 = i7 + 3;
                        } else {
                            i69 = i97;
                            i83 = 0;
                            i21 = i96;
                        }
                    } else {
                        i21 = i95;
                    }
                    objArr[e.b(i71, 3, i28)] = objArr3[i27];
                    i21 = i29;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldV4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i81 > 17) {
                    i22 = i19;
                    i23 = 0;
                } else {
                    i22 = i19 + 1;
                    int iCharAt13 = str.charAt(i19);
                    if (iCharAt13 >= 55296) {
                        int i100 = iCharAt13 & 8191;
                        int i101 = 13;
                        while (true) {
                            i26 = i22 + 1;
                            cCharAt9 = str.charAt(i22);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i100 |= (cCharAt9 & 8191) << i101;
                            i101 += 13;
                            i22 = i26;
                        }
                        iCharAt13 = i100 | (cCharAt9 << i101);
                        i22 = i26;
                    }
                    int i102 = (iCharAt13 / 32) + i20 + i20;
                    Object obj3 = objArr3[i102];
                    if (obj3 instanceof Field) {
                        fieldV = (Field) obj3;
                    } else {
                        fieldV = v(cls, (String) obj3);
                        objArr3[i102] = fieldV;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldV);
                    i23 = iCharAt13 % 32;
                }
                if (i81 < 18 || i81 > 49) {
                    i24 = i23;
                    i25 = iObjectFieldOffset3;
                } else {
                    iArr[i70] = iObjectFieldOffset3;
                    i24 = i23;
                    i25 = iObjectFieldOffset3;
                    i70++;
                }
                i7 = i21;
            }
            int i103 = i71 + 1;
            iArr2[i71] = i82;
            int i104 = i71 + 2;
            String str2 = str;
            iArr2[i103] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i83 != 0 ? Integer.MIN_VALUE : 0) | (i81 << 20) | i25;
            i71 += 3;
            iArr2[i104] = (i24 << 20) | iObjectFieldOffset;
            i38 = i22;
            length = i18;
            str = str2;
            i3 = i20;
            objArr2 = objArr;
            c2 = 55296;
        }
        return new zzno(iArr2, objArr2, i4, i6, zznvVar.f37168a, iArr, i8, i67, zzojVar, zzlsVar);
    }

    public static Field v(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e2) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(e.g(11, str) + name.length() + 29 + String.valueOf(string).length());
            b.B(sb, "Field ", str, " for ", name);
            throw new RuntimeException(b.r(sb, " not found. Known fields are ", string), e2);
        }
    }

    public final Object A(int i2, Object obj) {
        zznw zznwVarY = y(i2);
        int iE = E(i2) & 1048575;
        if (!n(i2, obj)) {
            return zznwVarY.zza();
        }
        Object object = f37145m.getObject(obj, iE);
        if (i(object)) {
            return object;
        }
        Object objZza = zznwVarY.zza();
        if (object != null) {
            zznwVarY.a(objZza, object);
        }
        return objZza;
    }

    public final void B(int i2, Object obj, Object obj2) {
        f37145m.putObject(obj, E(i2) & 1048575, obj2);
        o(i2, obj);
    }

    public final Object C(int i2, int i3, Object obj) {
        zznw zznwVarY = y(i3);
        if (!p(i2, i3, obj)) {
            return zznwVarY.zza();
        }
        Object object = f37145m.getObject(obj, E(i3) & 1048575);
        if (i(object)) {
            return object;
        }
        Object objZza = zznwVarY.zza();
        if (object != null) {
            zznwVarY.a(objZza, object);
        }
        return objZza;
    }

    public final void D(Object obj, int i2, int i3, Object obj2) {
        f37145m.putObject(obj, E(i3) & 1048575, obj2);
        zzoo.f(obj, i2, this.f37146a[i3 + 2] & 1048575);
    }

    public final int E(int i2) {
        return this.f37146a[i2 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.a(java.lang.Object, java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean b(Object obj) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (i6 < this.f37153h) {
            int i8 = this.f37152g[i6];
            int[] iArr = this.f37146a;
            int i9 = iArr[i8];
            int iE = E(i8);
            int i10 = iArr[i8 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i7) {
                if (i11 != 1048575) {
                    i5 = f37145m.getInt(obj, i11);
                }
                i3 = i8;
                i4 = i5;
                i2 = i11;
            } else {
                int i13 = i5;
                i2 = i7;
                i3 = i8;
                i4 = i13;
            }
            if ((268435456 & iE) == 0 || m(obj, i3, i2, i4, i12)) {
                int iF = F(iE);
                if (iF != 9 && iF != 17) {
                    if (iF != 27) {
                        if (iF == 60 || iF == 68) {
                            if (!p(i9, i3, obj) || y(i3).b(zzoo.i(iE & 1048575, obj))) {
                                i6++;
                                i7 = i2;
                                i5 = i4;
                            }
                        } else if (iF != 49) {
                            if (iF != 50) {
                                continue;
                            } else {
                                zznf zznfVar = (zznf) zzoo.i(iE & 1048575, obj);
                                if (zznfVar.isEmpty()) {
                                    continue;
                                } else {
                                    int i14 = i3 / 3;
                                    if (((zzne) this.f37147b[i14 + i14]).f37139a.f37138b.a() == zzot.f37215i) {
                                        zznw zznwVarA = null;
                                        for (Object obj2 : zznfVar.values()) {
                                            if (zznwVarA == null) {
                                                zznwVarA = zznt.f37161c.a(obj2.getClass());
                                            }
                                            if (!zznwVarA.b(obj2)) {
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            i6++;
                            i7 = i2;
                            i5 = i4;
                        }
                    }
                    List list = (List) zzoo.i(iE & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        zznw zznwVarY = y(i3);
                        for (int i15 = 0; i15 < list.size(); i15++) {
                            if (zznwVarY.b(list.get(i15))) {
                            }
                        }
                    }
                    i6++;
                    i7 = i2;
                    i5 = i4;
                } else if (!m(obj, i3, i2, i4, i12) || y(i3).b(zzoo.i(iE & 1048575, obj))) {
                    i6++;
                    i7 = i2;
                    i5 = i4;
                }
            }
            return false;
        }
        if (this.f37151f) {
            ((zzmb) obj).zzb.c();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ed  */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(com.google.android.gms.internal.measurement.zzme r18) {
        /*
            Method dump skipped, instructions count: 2068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.c(com.google.android.gms.internal.measurement.zzme):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = i(r8)
            if (r0 != 0) goto L8
            goto L90
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.zzme
            r1 = 0
            if (r0 == 0) goto L18
            r0 = r8
            com.google.android.gms.internal.measurement.zzme r0 = (com.google.android.gms.internal.measurement.zzme) r0
            r0.n()
            r0.zza = r1
            r0.j()
        L18:
            r0 = r1
        L19:
            int[] r2 = r7.f37146a
            int r3 = r2.length
            if (r0 >= r3) goto L82
            int r3 = r7.E(r0)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            int r3 = F(r3)
            long r4 = (long) r4
            r6 = 9
            if (r3 == r6) goto L6c
            r6 = 60
            if (r3 == r6) goto L56
            r6 = 68
            if (r3 == r6) goto L56
            switch(r3) {
                case 17: goto L6c;
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
            goto L7f
        L3b:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.zzno.f37145m
            java.lang.Object r3 = r2.getObject(r8, r4)
            if (r3 == 0) goto L7f
            r6 = r3
            com.google.android.gms.internal.measurement.zznf r6 = (com.google.android.gms.internal.measurement.zznf) r6
            r6.f37141a = r1
            r2.putObject(r8, r4, r3)
            goto L7f
        L4c:
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzoo.i(r4, r8)
            com.google.android.gms.internal.measurement.zzmn r2 = (com.google.android.gms.internal.measurement.zzmn) r2
            r2.zzb()
            goto L7f
        L56:
            r2 = r2[r0]
            boolean r2 = r7.p(r2, r0, r8)
            if (r2 == 0) goto L7f
            com.google.android.gms.internal.measurement.zznw r2 = r7.y(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.measurement.zzno.f37145m
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.d(r3)
            goto L7f
        L6c:
            boolean r2 = r7.n(r0, r8)
            if (r2 == 0) goto L7f
            com.google.android.gms.internal.measurement.zznw r2 = r7.y(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.measurement.zzno.f37145m
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.d(r3)
        L7f:
            int r0 = r0 + 3
            goto L19
        L82:
            com.google.android.gms.internal.measurement.zzoj r0 = r7.f37155j
            r0.b(r8)
            boolean r0 = r7.f37151f
            if (r0 == 0) goto L90
            com.google.android.gms.internal.measurement.zzls r0 = r7.f37156k
            r0.a(r8)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.d(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r19, com.google.android.gms.internal.measurement.zzou r20) {
        /*
            Method dump skipped, instructions count: 1706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.e(java.lang.Object, com.google.android.gms.internal.measurement.zzou):void");
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean f(zzme zzmeVar, zzme zzmeVar2) {
        boolean zA;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f37146a;
            if (i2 < iArr.length) {
                int iE = E(i2);
                long j2 = iE & 1048575;
                switch (F(iE)) {
                    case 0:
                        if (!l(zzmeVar, zzmeVar2, i2)) {
                            break;
                        } else {
                            zzon zzonVar = zzoo.f37196c;
                            if (Double.doubleToLongBits(zzonVar.f(j2, zzmeVar)) != Double.doubleToLongBits(zzonVar.f(j2, zzmeVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 1:
                        if (!l(zzmeVar, zzmeVar2, i2)) {
                            break;
                        } else {
                            zzon zzonVar2 = zzoo.f37196c;
                            if (Float.floatToIntBits(zzonVar2.d(j2, zzmeVar)) != Float.floatToIntBits(zzonVar2.d(j2, zzmeVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 2:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.g(j2, zzmeVar) != zzoo.g(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 3:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.g(j2, zzmeVar) != zzoo.g(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 4:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.e(j2, zzmeVar) != zzoo.e(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 5:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.g(j2, zzmeVar) != zzoo.g(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 6:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.e(j2, zzmeVar) != zzoo.e(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 7:
                        if (!l(zzmeVar, zzmeVar2, i2)) {
                            break;
                        } else {
                            zzon zzonVar3 = zzoo.f37196c;
                            if (zzonVar3.b(j2, zzmeVar) != zzonVar3.b(j2, zzmeVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 8:
                        if (!l(zzmeVar, zzmeVar2, i2) || !zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 9:
                        if (!l(zzmeVar, zzmeVar2, i2) || !zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 10:
                        if (!l(zzmeVar, zzmeVar2, i2) || !zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 11:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.e(j2, zzmeVar) != zzoo.e(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 12:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.e(j2, zzmeVar) != zzoo.e(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 13:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.e(j2, zzmeVar) != zzoo.e(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 14:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.g(j2, zzmeVar) != zzoo.g(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 15:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.e(j2, zzmeVar) != zzoo.e(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 16:
                        if (!l(zzmeVar, zzmeVar2, i2) || zzoo.g(j2, zzmeVar) != zzoo.g(j2, zzmeVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 17:
                        if (!l(zzmeVar, zzmeVar2, i2) || !zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2))) {
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
                        zA = zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2));
                        break;
                    case 50:
                        zA = zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2));
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
                        if (zzoo.e(j3, zzmeVar) != zzoo.e(j3, zzmeVar2) || !zzny.a(zzoo.i(j2, zzmeVar), zzoo.i(j2, zzmeVar2))) {
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
            } else if (zzmeVar.zzc.equals(zzmeVar2.zzc)) {
                if (this.f37151f) {
                    return ((zzmb) zzmeVar).zzb.equals(((zzmb) zzmeVar2).zzb);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void g(Object obj, byte[] bArr, int i2, int i3, zzkv zzkvVar) {
        t(obj, bArr, i2, i3, 0, zzkvVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[PHI: r1
      0x00db: PHI (r1v35 int) = (r1v11 int), (r1v36 int) binds: [B:86:0x01ea, B:44:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(com.google.android.gms.internal.measurement.zzme r11) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.h(com.google.android.gms.internal.measurement.zzme):int");
    }

    public final boolean l(zzme zzmeVar, zzme zzmeVar2, int i2) {
        return n(i2, zzmeVar) == n(i2, zzmeVar2);
    }

    public final boolean m(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? n(i2, obj) : (i4 & i5) != 0;
    }

    public final boolean n(int i2, Object obj) {
        int i3 = this.f37146a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int iE = E(i2);
            long j3 = iE & 1048575;
            switch (F(iE)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzoo.f37196c.f(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzoo.f37196c.d(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzoo.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzoo.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzoo.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzoo.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzoo.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzoo.f37196c.b(j3, obj);
                case 8:
                    Object objI = zzoo.i(j3, obj);
                    if (objI instanceof String) {
                        if (((String) objI).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objI instanceof zzlg)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzlg.f37073b.equals(objI)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (zzoo.i(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzlg.f37073b.equals(zzoo.i(j3, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzoo.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzoo.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzoo.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzoo.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzoo.e(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzoo.g(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzoo.i(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & zzoo.e(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final void o(int i2, Object obj) {
        int i3 = this.f37146a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        zzoo.f(obj, (1 << (i3 >>> 20)) | zzoo.e(j2, obj), j2);
    }

    public final boolean p(int i2, int i3, Object obj) {
        return zzoo.e((long) (this.f37146a[i3 + 2] & 1048575), obj) == i2;
    }

    public final int q(int i2, int i3) {
        int[] iArr = this.f37146a;
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

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final int t(java.lang.Object r39, byte[] r40, int r41, int r42, int r43, com.google.android.gms.internal.measurement.zzkv r44) {
        /*
            Method dump skipped, instructions count: 4594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.t(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzkv):int");
    }

    public final void w(int i2, Object obj, Object obj2) {
        if (n(i2, obj2)) {
            int iE = E(i2) & 1048575;
            Unsafe unsafe = f37145m;
            long j2 = iE;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                int i3 = this.f37146a[i2];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(e.a(i3, 38) + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zznw zznwVarY = y(i2);
            if (!n(i2, obj)) {
                if (i(object)) {
                    Object objZza = zznwVarY.zza();
                    zznwVarY.a(objZza, object);
                    unsafe.putObject(obj, j2, objZza);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                o(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!i(object2)) {
                Object objZza2 = zznwVarY.zza();
                zznwVarY.a(objZza2, object2);
                unsafe.putObject(obj, j2, objZza2);
                object2 = objZza2;
            }
            zznwVarY.a(object2, object);
        }
    }

    public final void x(int i2, Object obj, Object obj2) {
        int[] iArr = this.f37146a;
        int i3 = iArr[i2];
        if (p(i3, i2, obj2)) {
            int iE = E(i2) & 1048575;
            Unsafe unsafe = f37145m;
            long j2 = iE;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                int i4 = iArr[i2];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(e.a(i4, 38) + string.length());
                sb.append("Source subfield ");
                sb.append(i4);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zznw zznwVarY = y(i2);
            if (!p(i3, i2, obj)) {
                if (i(object)) {
                    Object objZza = zznwVarY.zza();
                    zznwVarY.a(objZza, object);
                    unsafe.putObject(obj, j2, objZza);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                zzoo.f(obj, i3, iArr[i2 + 2] & 1048575);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!i(object2)) {
                Object objZza2 = zznwVarY.zza();
                zznwVarY.a(objZza2, object2);
                unsafe.putObject(obj, j2, objZza2);
                object2 = objZza2;
            }
            zznwVarY.a(object2, object);
        }
    }

    public final zznw y(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        Object[] objArr = this.f37147b;
        zznw zznwVar = (zznw) objArr[i4];
        if (zznwVar != null) {
            return zznwVar;
        }
        zznw zznwVarA = zznt.f37161c.a((Class) objArr[i4 + 1]);
        objArr[i4] = zznwVarA;
        return zznwVarA;
    }

    public final zzmj z(int i2) {
        int i3 = i2 / 3;
        return (zzmj) this.f37147b[i3 + i3 + 1];
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        return (zzme) ((zzme) this.f37150e).r(4);
    }
}
