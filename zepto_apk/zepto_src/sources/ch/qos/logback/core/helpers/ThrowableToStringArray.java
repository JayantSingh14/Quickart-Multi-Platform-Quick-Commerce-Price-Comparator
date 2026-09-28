package ch.qos.logback.core.helpers;

import android.support.v4.media.b;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class ThrowableToStringArray {
    public static String[] a(Throwable th) {
        LinkedList linkedList = new LinkedList();
        b(linkedList, th, null);
        return (String[]) linkedList.toArray(new String[0]);
    }

    public static void b(LinkedList linkedList, Throwable th, StackTraceElement[] stackTraceElementArr) {
        int i2;
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTraceElementArr == null) {
            i2 = 0;
        } else {
            int length = stackTrace.length - 1;
            i2 = 0;
            for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementArr[length2]); length2--) {
                i2++;
                length--;
            }
        }
        String strConcat = (stackTraceElementArr != null ? "Caused by: " : "").concat(th.getClass().getName());
        if (th.getMessage() != null) {
            StringBuilder sbX = b.x(strConcat, ": ");
            sbX.append(th.getMessage());
            strConcat = sbX.toString();
        }
        linkedList.add(strConcat);
        for (int i3 = 0; i3 < stackTrace.length - i2; i3++) {
            linkedList.add("\tat " + stackTrace[i3].toString());
        }
        if (i2 != 0) {
            linkedList.add("\t... " + i2 + " common frames omitted");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            b(linkedList, cause, stackTrace);
        }
    }
}
