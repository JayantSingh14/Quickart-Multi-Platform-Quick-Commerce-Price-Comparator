package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;

/* loaded from: classes5.dex */
public class CompareToBuilder implements Builder<Integer> {
    private int comparison = 0;

    private void appendArray(Object obj, Object obj2, Comparator<?> comparator) {
        if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
        } else {
            append((Object[]) obj, (Object[]) obj2, comparator);
        }
    }

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z, String[] strArr) throws SecurityException {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i2 = 0; i2 < declaredFields.length && compareToBuilder.comparison == 0; i2++) {
            Field field = declaredFields[i2];
            if (!ArrayUtils.contains(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder appendSuper(int i2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i2;
        return this;
    }

    public int toComparison() {
        return this.comparison;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        return reflectionCompare(obj, obj2, z, null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.comparison != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.comparison = -1;
            return this;
        }
        if (obj2 == null) {
            this.comparison = 1;
            return this;
        }
        if (obj.getClass().isArray()) {
            appendArray(obj, obj2, comparator);
            return this;
        }
        if (comparator == null) {
            this.comparison = ((Comparable) obj).compareTo(obj2);
            return this;
        }
        this.comparison = comparator.compare(obj, obj2);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toComparison());
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, null, strArr);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) throws SecurityException {
        if (obj == obj2) {
            return 0;
        }
        if (obj != null && obj2 != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2.isInstance(obj2)) {
                CompareToBuilder compareToBuilder = new CompareToBuilder();
                boolean z2 = z;
                String[] strArr2 = strArr;
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z2, strArr2);
                while (cls2.getSuperclass() != null && cls2 != cls) {
                    Class<? super Object> superclass = cls2.getSuperclass();
                    CompareToBuilder compareToBuilder2 = compareToBuilder;
                    boolean z3 = z2;
                    String[] strArr3 = strArr2;
                    reflectionAppend(obj, obj2, superclass, compareToBuilder2, z3, strArr3);
                    cls2 = superclass;
                    compareToBuilder = compareToBuilder2;
                    z2 = z3;
                    strArr2 = strArr3;
                }
                return compareToBuilder.toComparison();
            }
            throw new ClassCastException();
        }
        throw null;
    }

    public CompareToBuilder append(long j2, long j3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = j2 < j3 ? -1 : j2 > j3 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(int i2, int i3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i2 < i3 ? -1 : i2 > i3 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(short s, short s2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = s < s2 ? -1 : s > s2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(char c2, char c3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = c2 < c3 ? -1 : c2 > c3 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(byte b2, byte b3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = b2 < b3 ? -1 : b2 > b3 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(double d2, double d3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Double.compare(d2, d3);
        return this;
    }

    public CompareToBuilder append(float f2, float f3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Float.compare(f2, f3);
        return this;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        if (this.comparison != 0 || z == z2) {
            return this;
        }
        if (!z) {
            this.comparison = -1;
            return this;
        }
        this.comparison = 1;
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.comparison == 0 && objArr != objArr2) {
            if (objArr == null) {
                this.comparison = -1;
                return this;
            }
            if (objArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (objArr.length != objArr2.length) {
                this.comparison = objArr.length >= objArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < objArr.length && this.comparison == 0; i2++) {
                append(objArr[i2], objArr2[i2], comparator);
            }
        }
        return this;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        if (this.comparison == 0 && jArr != jArr2) {
            if (jArr == null) {
                this.comparison = -1;
                return this;
            }
            if (jArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (jArr.length != jArr2.length) {
                this.comparison = jArr.length >= jArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < jArr.length && this.comparison == 0; i2++) {
                append(jArr[i2], jArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        if (this.comparison == 0 && iArr != iArr2) {
            if (iArr == null) {
                this.comparison = -1;
                return this;
            }
            if (iArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (iArr.length != iArr2.length) {
                this.comparison = iArr.length >= iArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < iArr.length && this.comparison == 0; i2++) {
                append(iArr[i2], iArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        if (this.comparison == 0 && sArr != sArr2) {
            if (sArr == null) {
                this.comparison = -1;
                return this;
            }
            if (sArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (sArr.length != sArr2.length) {
                this.comparison = sArr.length >= sArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < sArr.length && this.comparison == 0; i2++) {
                append(sArr[i2], sArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        if (this.comparison == 0 && cArr != cArr2) {
            if (cArr == null) {
                this.comparison = -1;
                return this;
            }
            if (cArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (cArr.length != cArr2.length) {
                this.comparison = cArr.length >= cArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < cArr.length && this.comparison == 0; i2++) {
                append(cArr[i2], cArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.comparison == 0 && bArr != bArr2) {
            if (bArr == null) {
                this.comparison = -1;
                return this;
            }
            if (bArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (bArr.length != bArr2.length) {
                this.comparison = bArr.length >= bArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < bArr.length && this.comparison == 0; i2++) {
                append(bArr[i2], bArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        if (this.comparison == 0 && dArr != dArr2) {
            if (dArr == null) {
                this.comparison = -1;
                return this;
            }
            if (dArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (dArr.length != dArr2.length) {
                this.comparison = dArr.length >= dArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < dArr.length && this.comparison == 0; i2++) {
                append(dArr[i2], dArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        if (this.comparison == 0 && fArr != fArr2) {
            if (fArr == null) {
                this.comparison = -1;
                return this;
            }
            if (fArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (fArr.length != fArr2.length) {
                this.comparison = fArr.length >= fArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < fArr.length && this.comparison == 0; i2++) {
                append(fArr[i2], fArr2[i2]);
            }
        }
        return this;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.comparison == 0 && zArr != zArr2) {
            if (zArr == null) {
                this.comparison = -1;
                return this;
            }
            if (zArr2 == null) {
                this.comparison = 1;
                return this;
            }
            if (zArr.length != zArr2.length) {
                this.comparison = zArr.length >= zArr2.length ? 1 : -1;
                return this;
            }
            for (int i2 = 0; i2 < zArr.length && this.comparison == 0; i2++) {
                append(zArr[i2], zArr2[i2]);
            }
        }
        return this;
    }
}
