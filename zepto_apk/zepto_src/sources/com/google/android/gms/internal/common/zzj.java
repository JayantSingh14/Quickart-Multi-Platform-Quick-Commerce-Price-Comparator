package com.google.android.gms.internal.common;

import android.os.Process;

/* loaded from: classes4.dex */
public final class zzj {
    public static Object a(zzi... zziVarArr) {
        return b(Process.class, "isIsolated", zziVarArr);
    }

    public static Object b(Class cls, String str, zzi... zziVarArr) {
        int length = zziVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < zziVarArr.length; i2++) {
            zzi zziVar = zziVarArr[i2];
            zziVar.getClass();
            clsArr[i2] = zziVar.f36494a;
            objArr[i2] = zziVarArr[i2].f36495b;
        }
        return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
    }
}
