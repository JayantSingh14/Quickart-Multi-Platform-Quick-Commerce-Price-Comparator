package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class ViewManagersPropertyCache {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f19604a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f19605b = new HashMap();

    public static class ArrayPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return (ReadableArray) obj;
        }
    }

    public static class BooleanPropSetter extends PropSetter {

        /* renamed from: i, reason: collision with root package name */
        public final boolean f19607i;

        public BooleanPropSetter(ReactProp reactProp, Method method, boolean z) {
            super(reactProp, "boolean", method);
            this.f19607i = z;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return obj == null ? this.f19607i : ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    public static class BoxedBooleanPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            if (obj != null) {
                return ((Boolean) obj).booleanValue() ? Boolean.TRUE : Boolean.FALSE;
            }
            return null;
        }
    }

    public static class BoxedColorPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            if (obj != null) {
                return ColorPropConverter.getColor(obj, context);
            }
            return null;
        }
    }

    public static class BoxedIntPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            if (obj != null) {
                return obj instanceof Double ? Integer.valueOf(((Double) obj).intValue()) : (Integer) obj;
            }
            return null;
        }
    }

    public static class DynamicPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return obj instanceof Dynamic ? obj : new DynamicFromObject(obj);
        }
    }

    public static class MapPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return (ReadableMap) obj;
        }
    }

    public static class StringPropSetter extends PropSetter {
        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return (String) obj;
        }
    }

    public static PropSetter a(ReactProp reactProp, Method method, Class cls) {
        if (cls == Dynamic.class) {
            return new DynamicPropSetter(reactProp, "mixed", method);
        }
        if (cls == Boolean.TYPE) {
            return new BooleanPropSetter(reactProp, method, reactProp.defaultBoolean());
        }
        if (cls == Integer.TYPE) {
            return "Color".equals(reactProp.customType()) ? new ColorPropSetter(reactProp, method, reactProp.defaultInt()) : new IntPropSetter(reactProp, method, reactProp.defaultInt());
        }
        if (cls == Float.TYPE) {
            return new FloatPropSetter(reactProp, method, reactProp.defaultFloat());
        }
        if (cls == Double.TYPE) {
            return new DoublePropSetter(reactProp, method, reactProp.defaultDouble());
        }
        if (cls == String.class) {
            return new StringPropSetter(reactProp, "String", method);
        }
        if (cls == Boolean.class) {
            return new BoxedBooleanPropSetter(reactProp, "boolean", method);
        }
        if (cls == Integer.class) {
            return "Color".equals(reactProp.customType()) ? new BoxedColorPropSetter(reactProp, "mixed", method) : new BoxedIntPropSetter(reactProp, "number", method);
        }
        if (cls == ReadableArray.class) {
            return new ArrayPropSetter(reactProp, "Array", method);
        }
        if (cls == ReadableMap.class) {
            return new MapPropSetter(reactProp, "Map", method);
        }
        throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
    }

    public static void b(ReactPropGroup reactPropGroup, Method method, Class cls, HashMap map) {
        String[] strArrNames = reactPropGroup.names();
        int i2 = 0;
        if (cls == Dynamic.class) {
            while (i2 < strArrNames.length) {
                map.put(strArrNames[i2], new DynamicPropSetter(reactPropGroup, "mixed", method, i2));
                i2++;
            }
            return;
        }
        if (cls == Integer.TYPE) {
            while (i2 < strArrNames.length) {
                if ("Color".equals(reactPropGroup.customType())) {
                    map.put(strArrNames[i2], new ColorPropSetter(reactPropGroup, method, i2, reactPropGroup.defaultInt()));
                } else {
                    map.put(strArrNames[i2], new IntPropSetter(reactPropGroup, method, i2, reactPropGroup.defaultInt()));
                }
                i2++;
            }
            return;
        }
        if (cls == Float.TYPE) {
            while (i2 < strArrNames.length) {
                map.put(strArrNames[i2], new FloatPropSetter(reactPropGroup, method, i2, reactPropGroup.defaultFloat()));
                i2++;
            }
            return;
        }
        if (cls == Double.TYPE) {
            for (int i3 = 0; i3 < strArrNames.length; i3++) {
                map.put(strArrNames[i3], new DoublePropSetter(reactPropGroup, method, i3, reactPropGroup.defaultDouble()));
            }
            return;
        }
        if (cls == Integer.class) {
            while (i2 < strArrNames.length) {
                if ("Color".equals(reactPropGroup.customType())) {
                    map.put(strArrNames[i2], new BoxedColorPropSetter(reactPropGroup, "mixed", method, i2));
                } else {
                    map.put(strArrNames[i2], new BoxedIntPropSetter(reactPropGroup, "number", method, i2));
                }
                i2++;
            }
            return;
        }
        throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
    }

    public static Map c(Class cls) throws SecurityException {
        HashMap map = f19605b;
        if (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (cls2 != ReactShadowNode.class) {
                }
            }
            HashMap map2 = f19604a;
            Map map3 = (Map) map2.get(cls);
            if (map3 != null) {
                return map3;
            }
            HashMap map4 = new HashMap(c(cls.getSuperclass()));
            for (Method method : cls.getDeclaredMethods()) {
                ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
                if (reactProp != null) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                    }
                    map4.put(reactProp.name(), a(reactProp, method, parameterTypes[0]));
                }
                ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
                if (reactPropGroup != null) {
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes2.length != 2) {
                        throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                    }
                    if (parameterTypes2[0] != Integer.TYPE) {
                        throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                    }
                    b(reactPropGroup, method, parameterTypes2[1], map4);
                }
            }
            map2.put(cls, map4);
            return map4;
        }
        return map;
    }

    public static Map d(Class cls) throws SecurityException {
        if (cls == ViewManager.class) {
            return f19605b;
        }
        HashMap map = f19604a;
        Map map2 = (Map) map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap map3 = new HashMap(d(cls.getSuperclass()));
        for (Method method : cls.getDeclaredMethods()) {
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (!View.class.isAssignableFrom(parameterTypes[0])) {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                }
                map3.put(reactProp.name(), a(reactProp, method, parameterTypes[1]));
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 3) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (!View.class.isAssignableFrom(parameterTypes2[0])) {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                }
                if (parameterTypes2[1] != Integer.TYPE) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
                b(reactPropGroup, method, parameterTypes2[2], map3);
            }
        }
        map.put(cls, map3);
        return map3;
    }

    public static class ColorPropSetter extends PropSetter {

        /* renamed from: i, reason: collision with root package name */
        public final int f19608i;

        public ColorPropSetter(ReactProp reactProp, Method method, int i2) {
            super(reactProp, "mixed", method);
            this.f19608i = i2;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return obj == null ? Integer.valueOf(this.f19608i) : ColorPropConverter.getColor(obj, context);
        }

        public ColorPropSetter(ReactPropGroup reactPropGroup, Method method, int i2, int i3) {
            super(reactPropGroup, "mixed", method, i2);
            this.f19608i = i3;
        }
    }

    public static class DoublePropSetter extends PropSetter {

        /* renamed from: i, reason: collision with root package name */
        public final double f19609i;

        public DoublePropSetter(ReactProp reactProp, Method method, double d2) {
            super(reactProp, "number", method);
            this.f19609i = d2;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return Double.valueOf(obj == null ? this.f19609i : ((Double) obj).doubleValue());
        }

        public DoublePropSetter(ReactPropGroup reactPropGroup, Method method, int i2, double d2) {
            super(reactPropGroup, "number", method, i2);
            this.f19609i = d2;
        }
    }

    public static class FloatPropSetter extends PropSetter {

        /* renamed from: i, reason: collision with root package name */
        public final float f19610i;

        public FloatPropSetter(ReactProp reactProp, Method method, float f2) {
            super(reactProp, "number", method);
            this.f19610i = f2;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return Float.valueOf(obj == null ? this.f19610i : ((Double) obj).floatValue());
        }

        public FloatPropSetter(ReactPropGroup reactPropGroup, Method method, int i2, float f2) {
            super(reactPropGroup, "number", method, i2);
            this.f19610i = f2;
        }
    }

    public static class IntPropSetter extends PropSetter {

        /* renamed from: i, reason: collision with root package name */
        public final int f19611i;

        public IntPropSetter(ReactProp reactProp, Method method, int i2) {
            super(reactProp, "number", method);
            this.f19611i = i2;
        }

        @Override // com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter
        public final Object a(Object obj, Context context) {
            return Integer.valueOf(obj == null ? this.f19611i : ((Double) obj).intValue());
        }

        public IntPropSetter(ReactPropGroup reactPropGroup, Method method, int i2, int i3) {
            super(reactPropGroup, "number", method, i2);
            this.f19611i = i3;
        }
    }

    public static abstract class PropSetter {

        /* renamed from: e, reason: collision with root package name */
        public static final ThreadLocal f19612e;

        /* renamed from: f, reason: collision with root package name */
        public static final ThreadLocal f19613f;

        /* renamed from: g, reason: collision with root package name */
        public static final ThreadLocal f19614g;

        /* renamed from: h, reason: collision with root package name */
        public static final ThreadLocal f19615h;

        /* renamed from: a, reason: collision with root package name */
        public final String f19616a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19617b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f19618c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f19619d;

        static {
            HashMap map = ViewManagersPropertyCache.f19604a;
            final int i2 = 2;
            f19612e = new ThreadLocal<Object[]>() { // from class: com.facebook.react.uimanager.ViewManagersPropertyCache.1
                @Override // java.lang.ThreadLocal
                public final Object[] initialValue() {
                    return new Object[i2];
                }
            };
            final int i3 = 3;
            f19613f = new ThreadLocal<Object[]>() { // from class: com.facebook.react.uimanager.ViewManagersPropertyCache.1
                @Override // java.lang.ThreadLocal
                public final Object[] initialValue() {
                    return new Object[i3];
                }
            };
            final int i4 = 1;
            f19614g = new ThreadLocal<Object[]>() { // from class: com.facebook.react.uimanager.ViewManagersPropertyCache.1
                @Override // java.lang.ThreadLocal
                public final Object[] initialValue() {
                    return new Object[i4];
                }
            };
            f19615h = new ThreadLocal<Object[]>() { // from class: com.facebook.react.uimanager.ViewManagersPropertyCache.1
                @Override // java.lang.ThreadLocal
                public final Object[] initialValue() {
                    return new Object[i2];
                }
            };
        }

        public PropSetter(ReactProp reactProp, String str, Method method) {
            this.f19616a = reactProp.name();
            this.f19617b = "__default_type__".equals(reactProp.customType()) ? str : reactProp.customType();
            this.f19618c = method;
            this.f19619d = null;
        }

        public abstract Object a(Object obj, Context context);

        public PropSetter(ReactPropGroup reactPropGroup, String str, Method method, int i2) {
            this.f19616a = reactPropGroup.names()[i2];
            this.f19617b = "__default_type__".equals(reactPropGroup.customType()) ? str : reactPropGroup.customType();
            this.f19618c = method;
            this.f19619d = Integer.valueOf(i2);
        }
    }
}
