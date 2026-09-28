package com.reactcommunity.rndatetimepicker;

import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class ReflectionHelper {
    public static Field a(Class cls, String str, Class cls2) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            return null;
        }
    }
}
