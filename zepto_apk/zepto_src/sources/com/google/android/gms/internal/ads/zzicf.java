package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzicf<T> implements zzicu<T> {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f34705m = new int[0];
    public static final Unsafe n = zzidm.n();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f34706a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f34707b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34708c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34709d;

    /* renamed from: e, reason: collision with root package name */
    public final zzicc f34710e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f34711f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f34712g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f34713h;

    /* renamed from: i, reason: collision with root package name */
    public final int f34714i;

    /* renamed from: j, reason: collision with root package name */
    public final int f34715j;

    /* renamed from: k, reason: collision with root package name */
    public final zzidh f34716k;

    /* renamed from: l, reason: collision with root package name */
    public final zziad f34717l;

    public zzicf(int[] iArr, Object[] objArr, int i2, int i3, zzicc zziccVar, int[] iArr2, int i4, int i5, zzidh zzidhVar, zziad zziadVar) {
        this.f34706a = iArr;
        this.f34707b = objArr;
        this.f34708c = i2;
        this.f34709d = i3;
        this.f34712g = zziccVar instanceof zziar;
        boolean z = false;
        if (zziadVar != null && (zziccVar instanceof zzian)) {
            z = true;
        }
        this.f34711f = z;
        this.f34713h = iArr2;
        this.f34714i = i4;
        this.f34715j = i5;
        this.f34716k = zzidhVar;
        this.f34717l = zziadVar;
        this.f34710e = zziccVar;
    }

    public static int j(int i2) {
        return (i2 >>> 20) & 255;
    }

    public static boolean k(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zziar) {
            return ((zziar) obj).m();
        }
        return true;
    }

    public static void l(Object obj) {
        if (!k(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public static int m(long j2, Object obj) {
        return ((Integer) zzidm.j(j2, obj)).intValue();
    }

    public static long n(long j2, Object obj) {
        return ((Long) zzidm.j(j2, obj)).longValue();
    }

    public static final int v(byte[] bArr, int i2, int i3, zzids zzidsVar, Class cls, zzhyz zzhyzVar) throws zzibg {
        zzids zzidsVar2 = zzids.f34776c;
        switch (zzidsVar.ordinal()) {
            case 0:
                int i4 = i2 + 8;
                zzhyzVar.f34539c = Double.valueOf(Double.longBitsToDouble(zzhza.e(i2, bArr)));
                return i4;
            case 1:
                int i5 = i2 + 4;
                zzhyzVar.f34539c = Float.valueOf(Float.intBitsToFloat(zzhza.d(i2, bArr)));
                return i5;
            case 2:
            case 3:
                int iC = zzhza.c(bArr, i2, zzhyzVar);
                zzhyzVar.f34539c = Long.valueOf(zzhyzVar.f34538b);
                return iC;
            case 4:
            case 12:
            case 13:
                int iA = zzhza.a(bArr, i2, zzhyzVar);
                zzhyzVar.f34539c = Integer.valueOf(zzhyzVar.f34537a);
                return iA;
            case 5:
            case 15:
                int i6 = i2 + 8;
                zzhyzVar.f34539c = Long.valueOf(zzhza.e(i2, bArr));
                return i6;
            case 6:
            case 14:
                int i7 = i2 + 4;
                zzhyzVar.f34539c = Integer.valueOf(zzhza.d(i2, bArr));
                return i7;
            case 7:
                int iC2 = zzhza.c(bArr, i2, zzhyzVar);
                zzhyzVar.f34539c = Boolean.valueOf(zzhyzVar.f34538b != 0);
                return iC2;
            case 8:
                return zzhza.f(bArr, i2, zzhyzVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                zzicu zzicuVarA = zzicm.f34722c.a(cls);
                Object objZza = zzicuVarA.zza();
                int iH = zzhza.h(objZza, zzicuVarA, bArr, i2, i3, zzhyzVar);
                zzicuVarA.b(objZza);
                zzhyzVar.f34539c = objZza;
                return iH;
            case 11:
                return zzhza.g(bArr, i2, zzhyzVar);
            case 16:
                int iA2 = zzhza.a(bArr, i2, zzhyzVar);
                zzhyzVar.f34539c = Integer.valueOf(zzhzq.f(zzhyzVar.f34537a));
                return iA2;
            case 17:
                int iC3 = zzhza.c(bArr, i2, zzhyzVar);
                zzhyzVar.f34539c = Long.valueOf(zzhzq.g(zzhyzVar.f34538b));
                return iC3;
        }
    }

    public static zzidg w(Object obj) {
        zziar zziarVar = (zziar) obj;
        zzidg zzidgVar = zziarVar.zzt;
        if (zzidgVar != zzidg.f34760f) {
            return zzidgVar;
        }
        zzidg zzidgVarA = zzidg.a();
        zziarVar.zzt = zzidgVarA;
        return zzidgVarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzicf y(com.google.android.gms.internal.ads.zzibz r33, com.google.android.gms.internal.ads.zzidh r34, com.google.android.gms.internal.ads.zziad r35) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.y(com.google.android.gms.internal.ads.zzibz, com.google.android.gms.internal.ads.zzidh, com.google.android.gms.internal.ads.zziad):com.google.android.gms.internal.ads.zzicf");
    }

    public static Field z(Class cls, String str) {
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
            StringBuilder sb = new StringBuilder(androidx.fragment.app.e.g(11, str) + name.length() + 29 + String.valueOf(string).length());
            android.support.v4.media.b.B(sb, "Field ", str, " for ", name);
            throw new RuntimeException(android.support.v4.media.b.r(sb, " not found. Known fields are ", string), e2);
        }
    }

    public final void A(int i2, Object obj, Object obj2) {
        if (q(obj2, i2)) {
            int i3 = i(i2) & 1048575;
            Unsafe unsafe = n;
            long j2 = i3;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                int i4 = this.f34706a[i2];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(androidx.fragment.app.e.a(i4, 38) + string.length());
                sb.append("Source subfield ");
                sb.append(i4);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzicu zzicuVarC = C(i2);
            if (!q(obj, i2)) {
                if (k(object)) {
                    Object objZza = zzicuVarC.zza();
                    zzicuVarC.a(objZza, object);
                    unsafe.putObject(obj, j2, objZza);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                r(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!k(object2)) {
                Object objZza2 = zzicuVarC.zza();
                zzicuVarC.a(objZza2, object2);
                unsafe.putObject(obj, j2, objZza2);
                object2 = objZza2;
            }
            zzicuVarC.a(object2, object);
        }
    }

    public final void B(int i2, Object obj, Object obj2) {
        int[] iArr = this.f34706a;
        int i3 = iArr[i2];
        if (s(i3, i2, obj2)) {
            int i4 = i(i2) & 1048575;
            Unsafe unsafe = n;
            long j2 = i4;
            Object object = unsafe.getObject(obj2, j2);
            if (object == null) {
                int i5 = iArr[i2];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(androidx.fragment.app.e.a(i5, 38) + string.length());
                sb.append("Source subfield ");
                sb.append(i5);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzicu zzicuVarC = C(i2);
            if (!s(i3, i2, obj)) {
                if (k(object)) {
                    Object objZza = zzicuVarC.zza();
                    zzicuVarC.a(objZza, object);
                    unsafe.putObject(obj, j2, objZza);
                } else {
                    unsafe.putObject(obj, j2, object);
                }
                t(i3, i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j2);
            if (!k(object2)) {
                Object objZza2 = zzicuVarC.zza();
                zzicuVarC.a(objZza2, object2);
                unsafe.putObject(obj, j2, objZza2);
                object2 = objZza2;
            }
            zzicuVarC.a(object2, object);
        }
    }

    public final zzicu C(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        Object[] objArr = this.f34707b;
        zzicu zzicuVar = (zzicu) objArr[i4];
        if (zzicuVar != null) {
            return zzicuVar;
        }
        zzicu zzicuVarA = zzicm.f34722c.a((Class) objArr[i4 + 1]);
        objArr[i4] = zzicuVarA;
        return zzicuVarA;
    }

    public final Object D(int i2) {
        int i3 = i2 / 3;
        return this.f34707b[i3 + i3];
    }

    public final zziax E(int i2) {
        int i3 = i2 / 3;
        return (zziax) this.f34707b[i3 + i3 + 1];
    }

    public final Object F(int i2, Object obj) {
        zzicu zzicuVarC = C(i2);
        int i3 = i(i2) & 1048575;
        if (!q(obj, i2)) {
            return zzicuVarC.zza();
        }
        Object object = n.getObject(obj, i3);
        if (k(object)) {
            return object;
        }
        Object objZza = zzicuVarC.zza();
        if (object != null) {
            zzicuVarC.a(objZza, object);
        }
        return objZza;
    }

    public final void G(int i2, Object obj, Object obj2) {
        n.putObject(obj, i(i2) & 1048575, obj2);
        r(i2, obj);
    }

    public final Object H(int i2, int i3, Object obj) {
        zzicu zzicuVarC = C(i3);
        if (!s(i2, i3, obj)) {
            return zzicuVarC.zza();
        }
        Object object = n.getObject(obj, i(i3) & 1048575);
        if (k(object)) {
            return object;
        }
        Object objZza = zzicuVarC.zza();
        if (object != null) {
            zzicuVarC.a(objZza, object);
        }
        return objZza;
    }

    public final void I(Object obj, int i2, int i3, Object obj2) {
        n.putObject(obj, i(i3) & 1048575, obj2);
        t(i2, i3, obj);
    }

    public final Object J(Object obj, int i2, Object obj2, zzidh zzidhVar, Object obj3) {
        zziax zziaxVarE;
        int i3 = this.f34706a[i2];
        Object objJ = zzidm.j(i(i2) & 1048575, obj);
        if (objJ == null || (zziaxVarE = E(i2)) == null) {
            return obj2;
        }
        zzibu zzibuVar = ((zzibv) D(i2)).f34699a;
        Iterator it = ((zzibw) objJ).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zziaxVarE.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzidhVar.i(obj3);
                }
                int iF = zziag.f(zzibuVar.f34696a, 1, entry.getKey()) + zziag.f(zzibuVar.f34697b, 2, entry.getValue());
                zzhzl zzhzlVar = zzhzl.f34557b;
                byte[] bArr = new byte[iF];
                Logger logger = zzhzw.f34603b;
                zzhzt zzhztVar = new zzhzt(bArr, iF);
                try {
                    zzibv.a(zzhztVar, zzibuVar, entry.getKey(), entry.getValue());
                    zzhztVar.e();
                    zzidhVar.d(obj2, i3, new zzhzj(bArr));
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return obj2;
    }

    public final void K(int i2, zzhzr zzhzrVar, Object obj) {
        long j2 = i2 & 1048575;
        if ((536870912 & i2) != 0) {
            zzidm.k(obj, j2, zzhzrVar.I());
        } else if (this.f34712g) {
            zzidm.k(obj, j2, zzhzrVar.H());
        } else {
            zzidm.k(obj, j2, zzhzrVar.L());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // com.google.android.gms.internal.ads.zzicu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.gms.internal.ads.zzicu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = k(r8)
            if (r0 != 0) goto L8
            goto L93
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zziar
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.android.gms.internal.ads.zziar r0 = (com.google.android.gms.internal.ads.zziar) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.l(r2)
            r0.zzq = r1
            r0.n()
        L1b:
            r0 = r1
        L1c:
            int[] r2 = r7.f34706a
            int r3 = r2.length
            if (r0 >= r3) goto L85
            int r3 = r7.i(r0)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            int r3 = j(r3)
            long r4 = (long) r4
            r6 = 9
            if (r3 == r6) goto L6f
            r6 = 60
            if (r3 == r6) goto L59
            r6 = 68
            if (r3 == r6) goto L59
            switch(r3) {
                case 17: goto L6f;
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
                case 50: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L82
        L3e:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.ads.zzicf.n
            java.lang.Object r3 = r2.getObject(r8, r4)
            if (r3 == 0) goto L82
            r6 = r3
            com.google.android.gms.internal.ads.zzibw r6 = (com.google.android.gms.internal.ads.zzibw) r6
            r6.f34701a = r1
            r2.putObject(r8, r4, r3)
            goto L82
        L4f:
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzidm.j(r4, r8)
            com.google.android.gms.internal.ads.zzibd r2 = (com.google.android.gms.internal.ads.zzibd) r2
            r2.zzb()
            goto L82
        L59:
            r2 = r2[r0]
            boolean r2 = r7.s(r2, r0, r8)
            if (r2 == 0) goto L82
            com.google.android.gms.internal.ads.zzicu r2 = r7.C(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.ads.zzicf.n
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.b(r3)
            goto L82
        L6f:
            boolean r2 = r7.q(r8, r0)
            if (r2 == 0) goto L82
            com.google.android.gms.internal.ads.zzicu r2 = r7.C(r0)
            sun.misc.Unsafe r3 = com.google.android.gms.internal.ads.zzicf.n
            java.lang.Object r3 = r3.getObject(r8, r4)
            r2.b(r3)
        L82:
            int r0 = r0 + 3
            goto L1c
        L85:
            com.google.android.gms.internal.ads.zzidh r0 = r7.f34716k
            r0.k(r8)
            boolean r0 = r7.f34711f
            if (r0 == 0) goto L93
            com.google.android.gms.internal.ads.zziad r0 = r7.f34717l
            r0.a(r8)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.b(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final void c(Object obj, byte[] bArr, int i2, int i3, zzhyz zzhyzVar) {
        x(obj, bArr, i2, i3, 0, zzhyzVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0629 A[LOOP:1: B:215:0x0627->B:216:0x0629, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0603 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzicu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.Object r20, com.google.android.gms.internal.ads.zzhzr r21, com.google.android.gms.internal.ads.zziab r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.d(java.lang.Object, com.google.android.gms.internal.ads.zzhzr, com.google.android.gms.internal.ads.zziab):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0406 A[PHI: r12 r18
      0x0406: PHI (r12v47 char) = (r12v29 char), (r12v30 char), (r12v36 char), (r12v38 char), (r12v39 char), (r12v40 char), (r12v44 char), (r12v48 char) binds: [B:210:0x05d0, B:206:0x05b1, B:178:0x0510, B:160:0x049b, B:156:0x047e, B:152:0x0461, B:145:0x0426, B:139:0x0404] A[DONT_GENERATE, DONT_INLINE]
      0x0406: PHI (r18v21 int) = (r18v3 int), (r18v4 int), (r18v10 int), (r18v12 int), (r18v13 int), (r18v14 int), (r18v18 int), (r18v22 int) binds: [B:210:0x05d0, B:206:0x05b1, B:178:0x0510, B:160:0x049b, B:156:0x047e, B:152:0x0461, B:145:0x0426, B:139:0x0404] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0576 A[PHI: r12 r18
      0x0576: PHI (r12v34 char) = (r12v28 char), (r12v35 char) binds: [B:214:0x05ef, B:199:0x0574] A[DONT_GENERATE, DONT_INLINE]
      0x0576: PHI (r18v8 int) = (r18v2 int), (r18v9 int) binds: [B:214:0x05ef, B:199:0x0574] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzicu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(com.google.android.gms.internal.ads.zziar r20) {
        /*
            Method dump skipped, instructions count: 2222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.e(com.google.android.gms.internal.ads.zziar):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[PHI: r1
      0x00db: PHI (r1v35 int) = (r1v11 int), (r1v36 int) binds: [B:86:0x01ea, B:44:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzicu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(com.google.android.gms.internal.ads.zziar r11) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.f(com.google.android.gms.internal.ads.zziar):int");
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final boolean g(zziar zziarVar, zziar zziarVar2) {
        boolean zD;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f34706a;
            if (i2 < iArr.length) {
                int i3 = i(i2);
                long j2 = i3 & 1048575;
                switch (j(i3)) {
                    case 0:
                        if (!o(zziarVar, zziarVar2, i2)) {
                            break;
                        } else {
                            zzidl zzidlVar = zzidm.f34769c;
                            if (Double.doubleToLongBits(zzidlVar.f(j2, zziarVar)) != Double.doubleToLongBits(zzidlVar.f(j2, zziarVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 1:
                        if (!o(zziarVar, zziarVar2, i2)) {
                            break;
                        } else {
                            zzidl zzidlVar2 = zzidm.f34769c;
                            if (Float.floatToIntBits(zzidlVar2.d(j2, zziarVar)) != Float.floatToIntBits(zzidlVar2.d(j2, zziarVar2))) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 2:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.h(j2, zziarVar) != zzidm.h(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 3:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.h(j2, zziarVar) != zzidm.h(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 4:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.f(j2, zziarVar) != zzidm.f(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 5:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.h(j2, zziarVar) != zzidm.h(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 6:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.f(j2, zziarVar) != zzidm.f(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 7:
                        if (!o(zziarVar, zziarVar2, i2)) {
                            break;
                        } else {
                            zzidl zzidlVar3 = zzidm.f34769c;
                            if (zzidlVar3.b(j2, zziarVar) != zzidlVar3.b(j2, zziarVar2)) {
                                break;
                            } else {
                                continue;
                                i2 += 3;
                            }
                        }
                    case 8:
                        if (!o(zziarVar, zziarVar2, i2) || !zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 9:
                        if (!o(zziarVar, zziarVar2, i2) || !zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 10:
                        if (!o(zziarVar, zziarVar2, i2) || !zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 11:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.f(j2, zziarVar) != zzidm.f(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 12:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.f(j2, zziarVar) != zzidm.f(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 13:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.f(j2, zziarVar) != zzidm.f(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 14:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.h(j2, zziarVar) != zzidm.h(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 15:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.f(j2, zziarVar) != zzidm.f(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 16:
                        if (!o(zziarVar, zziarVar2, i2) || zzidm.h(j2, zziarVar) != zzidm.h(j2, zziarVar2)) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    case 17:
                        if (!o(zziarVar, zziarVar2, i2) || !zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2))) {
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
                        zD = zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2));
                        break;
                    case 50:
                        zD = zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2));
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
                        if (zzidm.f(j3, zziarVar) != zzidm.f(j3, zziarVar2) || !zzicw.d(zzidm.j(j2, zziarVar), zzidm.j(j2, zziarVar2))) {
                            break;
                        } else {
                            continue;
                            i2 += 3;
                        }
                        break;
                    default:
                        i2 += 3;
                }
                if (zD) {
                    i2 += 3;
                }
            } else if (zziarVar.zzt.equals(zziarVar2.zzt)) {
                if (this.f34711f) {
                    return ((zzian) zziarVar).zza.equals(((zzian) zziarVar2).zza);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.android.gms.internal.ads.zzicu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.lang.Object r21, com.google.android.gms.internal.ads.zzhzx r22) {
        /*
            Method dump skipped, instructions count: 4016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.h(java.lang.Object, com.google.android.gms.internal.ads.zzhzx):void");
    }

    public final int i(int i2) {
        return this.f34706a[i2 + 1];
    }

    public final boolean o(zziar zziarVar, zziar zziarVar2, int i2) {
        return q(zziarVar, i2) == q(zziarVar2, i2);
    }

    public final boolean p(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? q(obj, i2) : (i4 & i5) != 0;
    }

    public final boolean q(Object obj, int i2) {
        int i3 = this.f34706a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int i4 = i(i2);
            long j3 = i4 & 1048575;
            switch (j(i4)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzidm.f34769c.f(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzidm.f34769c.d(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzidm.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzidm.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzidm.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzidm.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzidm.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzidm.f34769c.b(j3, obj);
                case 8:
                    Object objJ = zzidm.j(j3, obj);
                    if (objJ instanceof String) {
                        if (((String) objJ).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objJ instanceof zzhzl)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzhzl.f34557b.equals(objJ)) {
                            return false;
                        }
                    }
                    break;
                case 9:
                    if (zzidm.j(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzhzl.f34557b.equals(zzidm.j(j3, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzidm.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzidm.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzidm.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzidm.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzidm.f(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzidm.h(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzidm.j(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((zzidm.f(j2, obj) & (1 << (i3 >>> 20))) == 0) {
                return false;
            }
        }
        return true;
    }

    public final void r(int i2, Object obj) {
        int i3 = this.f34706a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        zzidm.g(obj, (1 << (i3 >>> 20)) | zzidm.f(j2, obj), j2);
    }

    public final boolean s(int i2, int i3, Object obj) {
        return zzidm.f((long) (this.f34706a[i3 + 2] & 1048575), obj) == i2;
    }

    public final void t(int i2, int i3, Object obj) {
        zzidm.g(obj, i2, this.f34706a[i3 + 2] & 1048575);
    }

    public final int u(int i2, int i3) {
        int[] iArr = this.f34706a;
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
    public final int x(java.lang.Object r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.ads.zzhyz r42) {
        /*
            Method dump skipped, instructions count: 4200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.x(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzhyz):int");
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final Object zza() {
        return ((zziar) this.f34710e).t();
    }

    @Override // com.google.android.gms.internal.ads.zzicu
    public final boolean zzl(Object obj) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (i6 < this.f34714i) {
            int i8 = this.f34713h[i6];
            int[] iArr = this.f34706a;
            int i9 = iArr[i8];
            int i10 = i(i8);
            int i11 = iArr[i8 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i5 = n.getInt(obj, i12);
                }
                i3 = i8;
                i4 = i5;
                i2 = i12;
            } else {
                int i14 = i5;
                i2 = i7;
                i3 = i8;
                i4 = i14;
            }
            if ((268435456 & i10) == 0 || p(obj, i3, i2, i4, i13)) {
                int iJ = j(i10);
                if (iJ != 9 && iJ != 17) {
                    if (iJ != 27) {
                        if (iJ == 60 || iJ == 68) {
                            if (!s(i9, i3, obj) || C(i3).zzl(zzidm.j(i10 & 1048575, obj))) {
                                i6++;
                                i7 = i2;
                                i5 = i4;
                            }
                        } else if (iJ != 49) {
                            if (iJ != 50) {
                                continue;
                            } else {
                                zzibw zzibwVar = (zzibw) zzidm.j(i10 & 1048575, obj);
                                if (!zzibwVar.isEmpty() && ((zzibv) D(i3)).f34699a.f34697b.f34780a == zzidt.f34790i) {
                                    zzicu zzicuVarA = null;
                                    for (Object obj2 : zzibwVar.values()) {
                                        if (zzicuVarA == null) {
                                            zzicuVarA = zzicm.f34722c.a(obj2.getClass());
                                        }
                                        if (!zzicuVarA.zzl(obj2)) {
                                        }
                                    }
                                }
                            }
                            i6++;
                            i7 = i2;
                            i5 = i4;
                        }
                    }
                    List list = (List) zzidm.j(i10 & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        zzicu zzicuVarC = C(i3);
                        for (int i15 = 0; i15 < list.size(); i15++) {
                            if (zzicuVarC.zzl(list.get(i15))) {
                            }
                        }
                    }
                    i6++;
                    i7 = i2;
                    i5 = i4;
                } else if (!p(obj, i3, i2, i4, i13) || C(i3).zzl(zzidm.j(i10 & 1048575, obj))) {
                    i6++;
                    i7 = i2;
                    i5 = i4;
                }
            }
            return false;
        }
        if (this.f34711f) {
            ((zzian) obj).zza.d();
        }
        return true;
    }
}
