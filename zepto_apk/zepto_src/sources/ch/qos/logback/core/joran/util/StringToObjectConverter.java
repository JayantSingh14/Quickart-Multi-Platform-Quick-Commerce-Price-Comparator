package ch.qos.logback.core.joran.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* loaded from: classes3.dex */
public class StringToObjectConverter {

    /* renamed from: a, reason: collision with root package name */
    public static final Class[] f13584a = {String.class};

    public static Object a(PropertySetter propertySetter, String str, Class cls) {
        if (str != null) {
            String strTrim = str.trim();
            if (String.class.isAssignableFrom(cls)) {
                return strTrim;
            }
            if (Integer.TYPE.isAssignableFrom(cls)) {
                return new Integer(strTrim);
            }
            if (Long.TYPE.isAssignableFrom(cls)) {
                return new Long(strTrim);
            }
            if (Float.TYPE.isAssignableFrom(cls)) {
                return new Float(strTrim);
            }
            if (Double.TYPE.isAssignableFrom(cls)) {
                return new Double(strTrim);
            }
            if (Boolean.TYPE.isAssignableFrom(cls)) {
                if ("true".equalsIgnoreCase(strTrim)) {
                    return Boolean.TRUE;
                }
                if ("false".equalsIgnoreCase(strTrim)) {
                    return Boolean.FALSE;
                }
            } else {
                if (cls.isEnum()) {
                    return Enum.valueOf(cls, strTrim);
                }
                if (b(cls)) {
                    try {
                        return cls.getMethod("valueOf", f13584a).invoke(null, strTrim);
                    } catch (Exception unused) {
                        propertySetter.l1("Failed to invoke valueOf{} method in class [" + cls.getName() + "] with value [" + strTrim + "]");
                    }
                } else if (Charset.class.isAssignableFrom(cls)) {
                    try {
                        return Charset.forName(str);
                    } catch (UnsupportedCharsetException e2) {
                        propertySetter.o1("Failed to get charset [" + str + "]", e2);
                    }
                }
            }
        }
        return null;
    }

    public static boolean b(Class cls) throws NoSuchMethodException, SecurityException {
        Method method = null;
        try {
            method = cls.getMethod("valueOf", f13584a);
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        if (method == null) {
            return false;
        }
        return Modifier.isStatic(method.getModifiers());
    }
}
