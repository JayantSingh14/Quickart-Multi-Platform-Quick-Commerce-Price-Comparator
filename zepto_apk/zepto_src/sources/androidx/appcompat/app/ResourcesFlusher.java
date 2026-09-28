package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
class ResourcesFlusher {

    /* renamed from: a, reason: collision with root package name */
    public static Field f358a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f359b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f360c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f361d;

    /* renamed from: e, reason: collision with root package name */
    public static Field f362e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f363f;

    /* renamed from: g, reason: collision with root package name */
    public static Field f364g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f365h;

    public static void a(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        Object obj2;
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        if (!f365h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f364g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f365h = true;
        }
        Field field = f364g;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f359b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f358a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f359b = true;
        }
        Field field2 = f358a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (!f361d) {
                try {
                    f360c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException e6) {
                    Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e6);
                }
                f361d = true;
            }
            Class cls = f360c;
            if (cls == null) {
                return;
            }
            if (!f363f) {
                try {
                    Field declaredField3 = cls.getDeclaredField("mUnthemedEntries");
                    f362e = declaredField3;
                    declaredField3.setAccessible(true);
                } catch (NoSuchFieldException e7) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e7);
                }
                f363f = true;
            }
            Field field3 = f362e;
            if (field3 == null) {
                return;
            }
            try {
                longSparseArray = (LongSparseArray) field3.get(obj2);
            } catch (IllegalAccessException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e8);
            }
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }
}
