package ch.qos.logback.classic.gaffer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.status.ErrorStatus;

/* loaded from: classes3.dex */
public class GafferUtil {
    public static void a(LoggerContext loggerContext, Object obj, ReflectiveOperationException reflectiveOperationException) {
        BasicStatusManager basicStatusManager = loggerContext.f13434c;
        if (basicStatusManager == null) {
            return;
        }
        basicStatusManager.a(new ErrorStatus(2, "Failed to instantiate ch.qos.logback.classic.gaffer.GafferConfigurator", obj, reflectiveOperationException));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(ch.qos.logback.classic.LoggerContext r2, java.lang.Object r3, java.net.URL r4) {
        /*
            java.lang.String r0 = "ch.qos.logback.classic.gaffer.GafferConfigurator"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.IllegalAccessException -> L1b java.lang.InstantiationException -> L1d java.lang.reflect.InvocationTargetException -> L1f java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L23
            java.lang.Class<ch.qos.logback.classic.LoggerContext> r1 = ch.qos.logback.classic.LoggerContext.class
            java.lang.Class[] r1 = new java.lang.Class[]{r1}     // Catch: java.lang.IllegalAccessException -> L1b java.lang.InstantiationException -> L1d java.lang.reflect.InvocationTargetException -> L1f java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L23
            java.lang.reflect.Constructor r0 = r0.getConstructor(r1)     // Catch: java.lang.IllegalAccessException -> L1b java.lang.InstantiationException -> L1d java.lang.reflect.InvocationTargetException -> L1f java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L23
            java.lang.Object[] r1 = new java.lang.Object[]{r2}     // Catch: java.lang.IllegalAccessException -> L1b java.lang.InstantiationException -> L1d java.lang.reflect.InvocationTargetException -> L1f java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L23
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.IllegalAccessException -> L1b java.lang.InstantiationException -> L1d java.lang.reflect.InvocationTargetException -> L1f java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L23
            ch.qos.logback.classic.gaffer.GafferConfigurator r0 = (ch.qos.logback.classic.gaffer.GafferConfigurator) r0     // Catch: java.lang.IllegalAccessException -> L1b java.lang.InstantiationException -> L1d java.lang.reflect.InvocationTargetException -> L1f java.lang.NoSuchMethodException -> L21 java.lang.ClassNotFoundException -> L23
            goto L39
        L1b:
            r0 = move-exception
            goto L25
        L1d:
            r0 = move-exception
            goto L29
        L1f:
            r0 = move-exception
            goto L2d
        L21:
            r0 = move-exception
            goto L31
        L23:
            r0 = move-exception
            goto L35
        L25:
            a(r2, r3, r0)
            goto L38
        L29:
            a(r2, r3, r0)
            goto L38
        L2d:
            a(r2, r3, r0)
            goto L38
        L31:
            a(r2, r3, r0)
            goto L38
        L35:
            a(r2, r3, r0)
        L38:
            r0 = 0
        L39:
            if (r0 == 0) goto L3e
            r0.e(r4)
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.gaffer.GafferUtil.b(ch.qos.logback.classic.LoggerContext, java.lang.Object, java.net.URL):void");
    }
}
