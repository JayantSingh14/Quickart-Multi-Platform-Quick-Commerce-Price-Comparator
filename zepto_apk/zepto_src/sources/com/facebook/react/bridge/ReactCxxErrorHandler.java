package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@DoNotStrip
/* loaded from: classes.dex */
public class ReactCxxErrorHandler {
    private static Method mHandleErrorFunc;
    private static Object mObject;

    @DoNotStrip
    private static void handleError(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (mHandleErrorFunc != null) {
            try {
                mHandleErrorFunc.invoke(mObject, new Exception(str));
            } catch (Exception e2) {
                FLog.h("ReactCxxErrorHandler", "Failed to invoke error handler function", e2);
            }
        }
    }

    @DoNotStrip
    public static void setHandleErrorFunc(Object obj, Method method) {
        mObject = obj;
        mHandleErrorFunc = method;
    }
}
