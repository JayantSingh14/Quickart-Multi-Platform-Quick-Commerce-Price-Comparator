package com.truecaller.android.sdk.common.callVerification;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class CallRejectorLegacyImpl implements CallRejector {

    /* renamed from: a, reason: collision with root package name */
    public final TelephonyManager f47208a;

    public CallRejectorLegacyImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.f47208a = (TelephonyManager) systemService;
    }

    public static Object b(Object[] objArr, Object obj) throws NoSuchMethodException, SecurityException {
        Class<?> cls = obj.getClass();
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            arrayList.add(obj2.getClass());
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Method declaredMethod = cls.getDeclaredMethod("endCall", (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    @Override // com.truecaller.android.sdk.common.callVerification.CallRejector
    public final boolean a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        TelephonyManager telephonyManager = this.f47208a;
        try {
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getITelephony", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(telephonyManager, null);
            if (objInvoke != null) {
                Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("endCall", null);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(objInvoke, null);
                return true;
            }
        } catch (Exception unused) {
            try {
                Method declaredMethod3 = telephonyManager.getClass().getDeclaredMethod("getITelephonyMSim", null);
                declaredMethod3.setAccessible(true);
                Object objInvoke2 = declaredMethod3.invoke(telephonyManager, null);
                if (objInvoke2 != null) {
                    if (Intrinsics.b(b(new Object[]{0}, objInvoke2), Boolean.FALSE)) {
                        b(new Object[]{1}, objInvoke2);
                    }
                }
            } catch (Exception unused2) {
            }
            return false;
        }
        return true;
    }
}
