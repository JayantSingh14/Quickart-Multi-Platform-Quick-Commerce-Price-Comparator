package ch.qos.logback.core.util;

import android.support.v4.media.b;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.spi.PropertyContainer;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.subst.NodeToStringTransformer;

/* loaded from: classes.dex */
public class OptionHelper {
    public static Object a(String str, Class cls, Context context) throws DynamicClassLoadingException, IncompatibleClassException {
        ClassLoader classLoaderA = Loader.a(context);
        str.getClass();
        try {
            Class<?> clsLoadClass = classLoaderA.loadClass(str);
            if (cls.isAssignableFrom(clsLoadClass)) {
                return clsLoadClass.newInstance();
            }
            throw new IncompatibleClassException();
        } catch (IncompatibleClassException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new DynamicClassLoadingException("Failed to instantiate type ".concat(str), th);
        }
    }

    public static boolean b(String str) {
        return str == null || "".equals(str);
    }

    public static String c(String str, InterpretationContext interpretationContext, PropertyContainer propertyContainer) {
        try {
            return NodeToStringTransformer.b(str, interpretationContext, propertyContainer);
        } catch (ScanException e2) {
            throw new IllegalArgumentException(b.D("Failed to parse input [", str, "]"), e2);
        }
    }

    public static boolean d(String str, boolean z) {
        if (str != null) {
            String strTrim = str.trim();
            if ("true".equalsIgnoreCase(strTrim)) {
                return true;
            }
            if ("false".equalsIgnoreCase(strTrim)) {
                return false;
            }
        }
        return z;
    }
}
