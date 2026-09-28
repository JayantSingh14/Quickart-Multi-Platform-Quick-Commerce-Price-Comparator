package ch.qos.logback.classic.spi;

/* loaded from: classes3.dex */
public class ThrowableProxyUtil {
    public static int a(StackTraceElement[] stackTraceElementArr, StackTraceElementProxy[] stackTraceElementProxyArr) {
        int i2 = 0;
        if (stackTraceElementProxyArr != null && stackTraceElementArr != null) {
            int length = stackTraceElementArr.length - 1;
            for (int length2 = stackTraceElementProxyArr.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(stackTraceElementProxyArr[length2].f13375a); length2--) {
                i2++;
                length--;
            }
        }
        return i2;
    }

    public static void b(int i2, StringBuilder sb) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append('\t');
        }
    }
}
