package ch.qos.logback.classic.spi;

import android.support.v4.media.a;
import java.net.URL;
import java.security.CodeSource;
import java.util.HashMap;
import sun.reflect.Reflection;

/* loaded from: classes3.dex */
public class PackagingDataCalculator {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f13372b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13373a = new HashMap();

    static {
        try {
            Reflection.getCallerClass(2);
            f13372b = true;
        } catch (NoClassDefFoundError | NoSuchMethodError | UnsupportedOperationException unused) {
        } catch (Throwable th) {
            System.err.println("Unexpected exception");
            th.printStackTrace();
        }
    }

    public static String b(Class cls) {
        URL location;
        if (cls == null) {
            return "na";
        }
        try {
            CodeSource codeSource = cls.getProtectionDomain().getCodeSource();
            if (codeSource == null || (location = codeSource.getLocation()) == null) {
                return "na";
            }
            String string = location.toString();
            String strC = c(string, '/');
            return strC != null ? strC : c(string, '\\');
        } catch (Exception unused) {
            return "na";
        }
    }

    public static String c(String str, char c2) {
        int iLastIndexOf = str.lastIndexOf(c2);
        if (iLastIndexOf != -1 && iLastIndexOf + 1 == str.length()) {
            return str.substring(str.lastIndexOf(c2, iLastIndexOf - 1) + 1);
        }
        if (iLastIndexOf > 0) {
            return str.substring(iLastIndexOf + 1);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021 A[PHI: r2
      0x0021: PHI (r2v7 java.lang.Class<?>) = (r2v2 java.lang.Class<?>), (r2v3 java.lang.Class<?>) binds: [B:13:0x001f, B:24:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ch.qos.logback.classic.spi.ClassPackagingData a(ch.qos.logback.classic.spi.StackTraceElementProxy r5, java.lang.ClassLoader r6) throws java.lang.ClassNotFoundException {
        /*
            r4 = this;
            java.lang.StackTraceElement r5 = r5.f13375a
            java.lang.String r5 = r5.getClassName()
            java.util.HashMap r0 = r4.f13373a
            java.lang.Object r1 = r0.get(r5)
            ch.qos.logback.classic.spi.ClassPackagingData r1 = (ch.qos.logback.classic.spi.ClassPackagingData) r1
            if (r1 == 0) goto L11
            return r1
        L11:
            r1 = 0
            if (r6 != 0) goto L15
            goto L1e
        L15:
            java.lang.Class r2 = r6.loadClass(r5)     // Catch: java.lang.Exception -> L1a java.lang.Throwable -> L1e
            goto L1f
        L1a:
            r2 = move-exception
            r2.printStackTrace()
        L1e:
            r2 = r1
        L1f:
            if (r2 == 0) goto L23
        L21:
            r1 = r2
            goto L47
        L23:
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r3 = r3.getContextClassLoader()
            if (r3 == r6) goto L3b
            if (r3 != 0) goto L30
            goto L3a
        L30:
            java.lang.Class r6 = r3.loadClass(r5)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L3a
            r2 = r6
            goto L3b
        L36:
            r6 = move-exception
            r6.printStackTrace()
        L3a:
            r2 = r1
        L3b:
            if (r2 == 0) goto L3e
            goto L21
        L3e:
            java.lang.Class r1 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L47
            goto L47
        L43:
            r6 = move-exception
            r6.printStackTrace()
        L47:
            if (r1 != 0) goto L4a
            goto L56
        L4a:
            java.lang.Package r6 = r1.getPackage()
            if (r6 == 0) goto L56
            java.lang.String r6 = r6.getImplementationVersion()
            if (r6 != 0) goto L58
        L56:
            java.lang.String r6 = "na"
        L58:
            java.lang.String r1 = b(r1)
            ch.qos.logback.classic.spi.ClassPackagingData r2 = new ch.qos.logback.classic.spi.ClassPackagingData
            r3 = 0
            r2.<init>(r3, r1, r6)
            r0.put(r5, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.spi.PackagingDataCalculator.a(ch.qos.logback.classic.spi.StackTraceElementProxy, java.lang.ClassLoader):ch.qos.logback.classic.spi.ClassPackagingData");
    }

    public final void d(StackTraceElementProxy[] stackTraceElementProxyArr) throws ClassNotFoundException {
        int i2;
        String implementationVersion;
        ClassPackagingData classPackagingData;
        StackTraceElement[] stackTrace = new Throwable("local stack reference").getStackTrace();
        int i3 = 1;
        if (stackTraceElementProxyArr == null) {
            i2 = 0;
        } else {
            int length = stackTrace.length - 1;
            i2 = 0;
            for (int length2 = stackTraceElementProxyArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementProxyArr[length2].f13375a); length2--) {
                i2++;
                length--;
            }
        }
        int length3 = stackTrace.length - i2;
        int length4 = stackTraceElementProxyArr.length - i2;
        int i4 = 0;
        ClassLoader classLoader = null;
        int i5 = 0;
        ClassLoader classLoader2 = null;
        while (i4 < i2) {
            Class callerClass = f13372b ? Reflection.getCallerClass(a.A(length3, i4, i5, i3)) : null;
            StackTraceElementProxy stackTraceElementProxy = stackTraceElementProxyArr[length4 + i4];
            String className = stackTraceElementProxy.f13375a.getClassName();
            if (callerClass == null || !className.equals(callerClass.getName())) {
                i5++;
                ClassPackagingData classPackagingDataA = a(stackTraceElementProxy, classLoader2);
                if (stackTraceElementProxy.f13377c != null) {
                    throw new IllegalStateException("Packaging data has been already set");
                }
                stackTraceElementProxy.f13377c = classPackagingDataA;
            } else {
                classLoader2 = callerClass.getClassLoader();
                if (classLoader == null) {
                    classLoader = classLoader2;
                }
                String name = callerClass.getName();
                HashMap map = this.f13373a;
                ClassPackagingData classPackagingData2 = (ClassPackagingData) map.get(name);
                if (classPackagingData2 != null) {
                    classPackagingData = classPackagingData2;
                } else {
                    Package r16 = callerClass.getPackage();
                    if (r16 == null || (implementationVersion = r16.getImplementationVersion()) == null) {
                        implementationVersion = "na";
                    }
                    classPackagingData = new ClassPackagingData(b(callerClass), implementationVersion);
                    map.put(name, classPackagingData);
                }
                if (stackTraceElementProxy.f13377c != null) {
                    throw new IllegalStateException("Packaging data has been already set");
                }
                stackTraceElementProxy.f13377c = classPackagingData;
            }
            i4++;
            i3 = 1;
        }
        int length5 = stackTraceElementProxyArr.length - i2;
        for (int i6 = 0; i6 < length5; i6++) {
            StackTraceElementProxy stackTraceElementProxy2 = stackTraceElementProxyArr[i6];
            ClassPackagingData classPackagingDataA2 = a(stackTraceElementProxy2, classLoader);
            if (stackTraceElementProxy2.f13377c != null) {
                throw new IllegalStateException("Packaging data has been already set");
            }
            stackTraceElementProxy2.f13377c = classPackagingDataA2;
        }
    }
}
