package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.core.os.BuildCompat;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public class DynamicColors {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f40252a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f40253b;

    /* renamed from: com.google.android.material.color.DynamicColors$1, reason: invalid class name */
    public class AnonymousClass1 implements DeviceSupportCondition {
        @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
        public final boolean a() {
            return true;
        }
    }

    /* renamed from: com.google.android.material.color.DynamicColors$2, reason: invalid class name */
    public class AnonymousClass2 implements DeviceSupportCondition {

        /* renamed from: a, reason: collision with root package name */
        public Long f40254a;

        @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
        public final boolean a() throws NoSuchMethodException, SecurityException {
            if (this.f40254a == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    Long l2 = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                    l2.longValue();
                    this.f40254a = l2;
                } catch (Exception unused) {
                    this.f40254a = -1L;
                }
            }
            return this.f40254a.longValue() >= 40100;
        }
    }

    public interface DeviceSupportCondition {
        boolean a();
    }

    public static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreCreated(Activity activity, Bundle bundle) {
            Map map = DynamicColors.f40252a;
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (!BuildCompat.b()) {
                String str = Build.MANUFACTURER;
                Locale locale = Locale.ROOT;
                DeviceSupportCondition deviceSupportCondition = (DeviceSupportCondition) DynamicColors.f40252a.get(str.toLowerCase(locale));
                if (deviceSupportCondition == null) {
                    deviceSupportCondition = (DeviceSupportCondition) DynamicColors.f40253b.get(Build.BRAND.toLowerCase(locale));
                }
                if (deviceSupportCondition == null || !deviceSupportCondition.a()) {
                    return;
                }
            }
            throw null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    public interface OnAppliedCallback {
    }

    public interface Precondition {
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        HashMap map = new HashMap();
        map.put("fcnt", anonymousClass1);
        map.put("google", anonymousClass1);
        map.put("hmd global", anonymousClass1);
        map.put("infinix", anonymousClass1);
        map.put("infinix mobility limited", anonymousClass1);
        map.put("itel", anonymousClass1);
        map.put("kyocera", anonymousClass1);
        map.put("lenovo", anonymousClass1);
        map.put("lge", anonymousClass1);
        map.put("meizu", anonymousClass1);
        map.put("motorola", anonymousClass1);
        map.put("nothing", anonymousClass1);
        map.put("oneplus", anonymousClass1);
        map.put("oppo", anonymousClass1);
        map.put("realme", anonymousClass1);
        map.put("robolectric", anonymousClass1);
        map.put("samsung", anonymousClass2);
        map.put("sharp", anonymousClass1);
        map.put("shift", anonymousClass1);
        map.put("sony", anonymousClass1);
        map.put("tcl", anonymousClass1);
        map.put("tecno", anonymousClass1);
        map.put("tecno mobile limited", anonymousClass1);
        map.put("vivo", anonymousClass1);
        map.put("wingtech", anonymousClass1);
        map.put("xiaomi", anonymousClass1);
        f40252a = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", anonymousClass1);
        map2.put("jio", anonymousClass1);
        f40253b = Collections.unmodifiableMap(map2);
    }
}
