package org.shadow.apache.commons.lang3;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class SerializationUtils {

    public static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {

        /* renamed from: a, reason: collision with root package name */
        public static final HashMap f57724a = new HashMap();

        @Override // java.io.ObjectInputStream
        public final Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, null);
                } catch (ClassNotFoundException e2) {
                    Class cls = (Class) f57724a.get(name);
                    if (cls != null) {
                        return cls;
                    }
                    throw e2;
                }
            } catch (ClassNotFoundException unused) {
                return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
            }
        }
    }
}
