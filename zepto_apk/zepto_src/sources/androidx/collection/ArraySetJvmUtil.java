package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: classes3.dex */
class ArraySetJvmUtil {
    public static Object[] a(int i2, Object[] objArr) {
        if (objArr.length < i2) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        if (objArr.length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
