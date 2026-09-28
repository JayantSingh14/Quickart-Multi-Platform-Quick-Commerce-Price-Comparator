package org.shadow.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: classes5.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    public final void b(Class cls) throws SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        boolean zIsArray = cls.isArray();
        Object obj = this.f57733b;
        if (zIsArray) {
            this.f57734c.t(this.f57732a, obj);
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            String name = field.getName();
            if (field.getName().indexOf(36) == -1 && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                try {
                    a(field.get(obj), name);
                } catch (IllegalAccessException e2) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e2.getMessage());
                }
            }
        }
    }

    @Override // org.shadow.apache.commons.lang3.builder.ToStringBuilder
    public final String toString() throws SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj = this.f57733b;
        if (obj == null) {
            return this.f57734c.q();
        }
        Class<?> superclass = obj.getClass();
        b(superclass);
        while (superclass.getSuperclass() != null) {
            superclass = superclass.getSuperclass();
            b(superclass);
        }
        return super.toString();
    }
}
