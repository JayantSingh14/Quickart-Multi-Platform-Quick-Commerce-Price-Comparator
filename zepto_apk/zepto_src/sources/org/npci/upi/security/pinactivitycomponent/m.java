package org.npci.upi.security.pinactivitycomponent;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class m {
    public static String a(Object obj) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        a(obj, sb);
        return sb.toString();
    }

    private static void a(Object obj, StringBuilder sb) throws SecurityException {
        if (obj == null) {
            sb.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        int i2 = 0;
        if (cls.isArray()) {
            sb.append("[");
            while (i2 < Array.getLength(obj)) {
                a(Array.get(obj, i2), sb);
                sb.append(",");
                i2++;
            }
            sb.replace(sb.length() - 1, sb.length(), "]");
            return;
        }
        if (cls.equals(String.class)) {
            sb.append("\"");
            sb.append(obj);
            sb.append("\"");
            return;
        }
        if (cls.isPrimitive() || cls.equals(Integer.class) || cls.equals(Long.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Float.class) || cls.equals(BigDecimal.class)) {
            sb.append(String.valueOf(obj));
            return;
        }
        try {
            sb.append("{");
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            while (i2 < length) {
                Field field = declaredFields[i2];
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    sb.append("\"");
                    sb.append(field.getName());
                    sb.append("\"");
                    sb.append(":");
                    a(field.get(obj), sb);
                    sb.append(",");
                }
                i2++;
            }
            sb.replace(sb.length() - 1, sb.length(), "}");
        } catch (Exception e2) {
            q.a("JsonUtils", "Exception: " + e2.getLocalizedMessage());
        }
    }
}
