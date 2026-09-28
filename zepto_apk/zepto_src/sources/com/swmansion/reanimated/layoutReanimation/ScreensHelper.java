package com.swmansion.reanimated.layoutReanimation;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class ScreensHelper {
    public static View getTabNavigator(View view) {
        while (view != null) {
            if (isScreenContainer(view)) {
                return view;
            }
            if (!isScreen(view) || !isScreensCoordinatorLayout(view.getParent())) {
                if (!(view.getParent() instanceof View)) {
                    break;
                }
                view = (View) view.getParent();
            } else {
                try {
                    view = (View) view.getClass().getMethod("getContainer", null).invoke(view, null);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                    Log.e("[Reanimated]", e2.getMessage() != null ? e2.getMessage() : "Unable to invoke the getContainer method");
                }
            }
        }
        return null;
    }

    public static View getTopScreenForStack(View view) {
        if (isScreenStack(view)) {
            try {
                return (View) view.getClass().getMethod("getTopScreen", null).invoke(view, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return view;
    }

    private static boolean isInstanceOf(Object obj, String str) {
        return obj != null && obj.getClass().getSimpleName().equals(str);
    }

    public static boolean isScreen(Object obj) {
        return isInstanceOf(obj, "Screen");
    }

    public static boolean isScreenContainer(Object obj) {
        return isInstanceOf(obj, "ScreenContainer");
    }

    public static boolean isScreenFragment(Object obj) {
        return isInstanceOf(obj, "ScreenFragment");
    }

    public static boolean isScreenStack(Object obj) {
        return isInstanceOf(obj, "ScreenStack");
    }

    public static boolean isScreensCoordinatorLayout(Object obj) {
        return isInstanceOf(obj, "ScreensCoordinatorLayout");
    }

    public static boolean isViewChildOfScreen(View view, View view2) {
        while (view != null) {
            if (view == view2) {
                return true;
            }
            if (!(view.getParent() instanceof View)) {
                return false;
            }
            view = (View) view.getParent();
        }
        return false;
    }
}
