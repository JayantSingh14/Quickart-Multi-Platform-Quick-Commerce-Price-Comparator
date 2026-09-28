package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzly {
    public static zzlq b() {
        String strK;
        ClassLoader classLoader = zzly.class.getClassLoader();
        if (zzlq.class.equals(zzlq.class)) {
            strK = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!zzlq.class.getPackage().equals(zzly.class.getPackage())) {
                throw new IllegalArgumentException(zzlq.class.getName());
            }
            strK = b.k(zzlq.class.getPackage().getName(), ".BlazeGeneratedzzlqLoader");
        }
        try {
            try {
                try {
                    try {
                        return (zzlq) zzlq.class.cast(((zzly) Class.forName(strK, true, classLoader).getConstructor(null).newInstance(null)).a());
                    } catch (InvocationTargetException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (IllegalAccessException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (InstantiationException e4) {
                throw new IllegalStateException(e4);
            } catch (NoSuchMethodException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzly.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzlq) zzlq.class.cast(((zzly) it.next()).a()));
                } catch (ServiceConfigurationError e6) {
                    Logger.getLogger(zzll.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat("zzlq"), (Throwable) e6);
                }
            }
            if (arrayList.size() == 1) {
                return (zzlq) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzlq) zzlq.class.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public abstract zzlq a();
}
