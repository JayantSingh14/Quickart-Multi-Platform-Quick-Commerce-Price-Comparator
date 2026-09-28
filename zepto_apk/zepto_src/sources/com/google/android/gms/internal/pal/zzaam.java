package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzaam extends zzzg {
    public static void b(zzabe zzabeVar, zzyy zzyyVar) throws IOException {
        StringWriter stringWriter = zzabeVar.f37343a;
        if (zzyyVar == null || (zzyyVar instanceof zzza)) {
            if (zzabeVar.f37348f != null) {
                zzabeVar.l();
            }
            zzabeVar.c();
            stringWriter.write("null");
            return;
        }
        if (!(zzyyVar instanceof zzzd)) {
            if (zzyyVar instanceof zzyx) {
                zzabeVar.l();
                zzabeVar.c();
                int i2 = zzabeVar.f37345c;
                int[] iArr = zzabeVar.f37344b;
                if (i2 == iArr.length) {
                    zzabeVar.f37344b = Arrays.copyOf(iArr, i2 + i2);
                }
                int[] iArr2 = zzabeVar.f37344b;
                int i3 = zzabeVar.f37345c;
                zzabeVar.f37345c = i3 + 1;
                iArr2[i3] = 1;
                stringWriter.write(91);
                Iterator it = ((zzyx) zzyyVar).f38165a.iterator();
                while (it.hasNext()) {
                    b(zzabeVar, (zzyy) it.next());
                }
                zzabeVar.b(1, 2, ']');
                return;
            }
            if (!(zzyyVar instanceof zzzb)) {
                Class<?> cls = zzyyVar.getClass();
                cls.toString();
                throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(cls)));
            }
            zzabeVar.l();
            zzabeVar.c();
            int i4 = zzabeVar.f37345c;
            int[] iArr3 = zzabeVar.f37344b;
            if (i4 == iArr3.length) {
                zzabeVar.f37344b = Arrays.copyOf(iArr3, i4 + i4);
            }
            int[] iArr4 = zzabeVar.f37344b;
            int i5 = zzabeVar.f37345c;
            zzabeVar.f37345c = i5 + 1;
            iArr4[i5] = 3;
            stringWriter.write(WKSRecord.Service.NTP);
            Iterator it2 = ((zzzm) zzyyVar.f().f38167a.entrySet()).iterator();
            while (((zzzp) it2).hasNext()) {
                zzzq next = ((zzzl) it2).next();
                String str = (String) next.getKey();
                if (str == null) {
                    throw new NullPointerException("name == null");
                }
                if (zzabeVar.f37348f != null) {
                    throw new IllegalStateException();
                }
                if (zzabeVar.f37345c == 0) {
                    throw new IllegalStateException("JsonWriter is closed.");
                }
                zzabeVar.f37348f = str;
                b(zzabeVar, (zzyy) next.getValue());
            }
            zzabeVar.b(3, 5, '}');
            return;
        }
        zzzd zzzdVar = (zzzd) zzyyVar;
        Serializable serializable = zzzdVar.f38168a;
        if (!(serializable instanceof Number)) {
            if (serializable instanceof Boolean) {
                boolean zBooleanValue = serializable != null ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(zzzdVar.d());
                zzabeVar.l();
                zzabeVar.c();
                stringWriter.write(true != zBooleanValue ? "false" : "true");
                return;
            }
            String strD = zzzdVar.d();
            if (strD != null) {
                zzabeVar.l();
                zzabeVar.c();
                zzabeVar.e(strD);
                return;
            } else {
                if (zzabeVar.f37348f != null) {
                    zzabeVar.l();
                }
                zzabeVar.c();
                stringWriter.write("null");
                return;
            }
        }
        Number numberG = zzzdVar.g();
        zzabeVar.l();
        String string = numberG.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls2 = numberG.getClass();
            if (cls2 != Integer.class && cls2 != Long.class && cls2 != Double.class && cls2 != Float.class && cls2 != Byte.class && cls2 != Short.class && cls2 != BigDecimal.class && cls2 != BigInteger.class && cls2 != AtomicInteger.class && cls2 != AtomicLong.class && !zzabe.f37341g.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls2 + " is not a valid JSON number: " + string);
            }
        } else if (!zzabeVar.f37347e) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
        }
        zzabeVar.c();
        stringWriter.append((CharSequence) string);
    }

    public static final zzyy c(zzabc zzabcVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 5) {
            return new zzzd(zzabcVar.c());
        }
        if (i3 == 6) {
            return new zzzd(new zzzj(zzabcVar.c()));
        }
        boolean z = true;
        if (i3 != 7) {
            if (i3 != 8) {
                throw new IllegalStateException("Unexpected token: ".concat(zzabd.a(i2)));
            }
            int iA = zzabcVar.f37334g;
            if (iA == 0) {
                iA = zzabcVar.a();
            }
            if (iA != 7) {
                throw new IllegalStateException("Expected null but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
            }
            zzabcVar.f37334g = 0;
            int[] iArr = zzabcVar.f37340m;
            int i4 = zzabcVar.f37338k - 1;
            iArr[i4] = iArr[i4] + 1;
            return zzza.f38166a;
        }
        int iA2 = zzabcVar.f37334g;
        if (iA2 == 0) {
            iA2 = zzabcVar.a();
        }
        if (iA2 == 5) {
            zzabcVar.f37334g = 0;
            int[] iArr2 = zzabcVar.f37340m;
            int i5 = zzabcVar.f37338k - 1;
            iArr2[i5] = iArr2[i5] + 1;
        } else {
            if (iA2 != 6) {
                throw new IllegalStateException("Expected a boolean but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
            }
            zzabcVar.f37334g = 0;
            int[] iArr3 = zzabcVar.f37340m;
            int i6 = zzabcVar.f37338k - 1;
            iArr3[i6] = iArr3[i6] + 1;
            z = false;
        }
        return new zzzd(Boolean.valueOf(z));
    }

    public static final zzyy d(zzabc zzabcVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 0) {
            int iA = zzabcVar.f37334g;
            if (iA == 0) {
                iA = zzabcVar.a();
            }
            if (iA == 3) {
                zzabcVar.A(1);
                zzabcVar.f37340m[zzabcVar.f37338k - 1] = 0;
                zzabcVar.f37334g = 0;
                return new zzyx();
            }
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
        }
        if (i3 != 2) {
            return null;
        }
        int iA2 = zzabcVar.f37334g;
        if (iA2 == 0) {
            iA2 = zzabcVar.a();
        }
        if (iA2 == 1) {
            zzabcVar.A(3);
            zzabcVar.f37334g = 0;
            return new zzzb();
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
    }

    @Override // com.google.android.gms.internal.pal.zzzg
    public final Object a(zzabc zzabcVar) throws IOException {
        String strS;
        int iE = zzabcVar.e();
        zzyy zzyyVarD = d(zzabcVar, iE);
        if (zzyyVarD == null) {
            return c(zzabcVar, iE);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            int iA = zzabcVar.f37334g;
            if (iA == 0) {
                iA = zzabcVar.a();
            }
            String str = null;
            if (iA == 2 || iA == 4 || iA == 17) {
                if (zzyyVarD instanceof zzyx) {
                    int iA2 = zzabcVar.f37334g;
                    if (iA2 == 0) {
                        iA2 = zzabcVar.a();
                    }
                    if (iA2 != 4) {
                        throw new IllegalStateException("Expected END_ARRAY but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
                    }
                    int i2 = zzabcVar.f37338k;
                    zzabcVar.f37338k = i2 - 1;
                    int[] iArr = zzabcVar.f37340m;
                    int i3 = i2 - 2;
                    iArr[i3] = iArr[i3] + 1;
                    zzabcVar.f37334g = 0;
                } else {
                    int iA3 = zzabcVar.f37334g;
                    if (iA3 == 0) {
                        iA3 = zzabcVar.a();
                    }
                    if (iA3 != 2) {
                        throw new IllegalStateException("Expected END_OBJECT but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
                    }
                    int i4 = zzabcVar.f37338k;
                    int i5 = i4 - 1;
                    zzabcVar.f37338k = i5;
                    zzabcVar.f37339l[i5] = null;
                    int[] iArr2 = zzabcVar.f37340m;
                    int i6 = i4 - 2;
                    iArr2[i6] = iArr2[i6] + 1;
                    zzabcVar.f37334g = 0;
                }
                if (arrayDeque.isEmpty()) {
                    return zzyyVarD;
                }
                zzyyVarD = (zzyy) arrayDeque.removeLast();
            } else {
                if (zzyyVarD instanceof zzzb) {
                    int iA4 = zzabcVar.f37334g;
                    if (iA4 == 0) {
                        iA4 = zzabcVar.a();
                    }
                    if (iA4 == 14) {
                        strS = zzabcVar.x();
                    } else if (iA4 == 12) {
                        strS = zzabcVar.s('\'');
                    } else {
                        if (iA4 != 13) {
                            throw new IllegalStateException("Expected a name but was " + ((Object) zzabd.a(zzabcVar.e())) + zzabcVar.b());
                        }
                        strS = zzabcVar.s('\"');
                    }
                    str = strS;
                    zzabcVar.f37334g = 0;
                    zzabcVar.f37339l[zzabcVar.f37338k - 1] = str;
                }
                int iE2 = zzabcVar.e();
                zzyy zzyyVarD2 = d(zzabcVar, iE2);
                zzyy zzyyVarC = zzyyVarD2 == null ? c(zzabcVar, iE2) : zzyyVarD2;
                if (zzyyVarD instanceof zzyx) {
                    ((zzyx) zzyyVarD).f38165a.add(zzyyVarC);
                } else {
                    ((zzzb) zzyyVarD).f38167a.put(str, zzyyVarC);
                }
                if (zzyyVarD2 != null) {
                    arrayDeque.addLast(zzyyVarD);
                    zzyyVarD = zzyyVarC;
                }
            }
        }
    }
}
