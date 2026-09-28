package timber.log;

import android.support.v4.media.b;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public final class Timber {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f58261a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static volatile Tree[] f58262b = new Tree[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Tree f58263c = new AnonymousClass1();

    /* loaded from: classes5.dex */
    public static class DebugTree extends Tree {

        /* renamed from: b, reason: collision with root package name */
        public static final Pattern f58264b = Pattern.compile("(\\$\\d+)+$");

        @Override // timber.log.Timber.Tree
        public final String a() {
            String strA = super.a();
            if (strA != null) {
                return strA;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length <= 5) {
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
            String className = stackTrace[5].getClassName();
            Matcher matcher = f58264b.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String strSubstring = className.substring(className.lastIndexOf(46) + 1);
            strSubstring.length();
            return strSubstring;
        }

        @Override // timber.log.Timber.Tree
        public final void log(int i2, String str, String str2, Throwable th) {
            int iMin;
            if (str2.length() < 4000) {
                if (i2 == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i2, str, str2);
                    return;
                }
            }
            int length = str2.length();
            int i3 = 0;
            while (i3 < length) {
                int iIndexOf = str2.indexOf(10, i3);
                if (iIndexOf == -1) {
                    iIndexOf = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf, i3 + 4000);
                    String strSubstring = str2.substring(i3, iMin);
                    if (i2 == 7) {
                        Log.wtf(str, strSubstring);
                    } else {
                        Log.println(i2, str, strSubstring);
                    }
                    if (iMin >= iIndexOf) {
                        break;
                    } else {
                        i3 = iMin;
                    }
                }
                i3 = iMin + 1;
            }
        }
    }

    public static abstract class Tree {

        /* renamed from: a, reason: collision with root package name */
        public final ThreadLocal f58265a = new ThreadLocal();

        public String a() {
            ThreadLocal threadLocal = this.f58265a;
            String str = (String) threadLocal.get();
            if (str != null) {
                threadLocal.remove();
            }
            return str;
        }

        public final void b(int i2, Throwable th, String str, Object... objArr) {
            String strA = a();
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr != null && objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                if (th != null) {
                    StringBuilder sbX = b.x(str, StringUtils.LF);
                    StringWriter stringWriter = new StringWriter(256);
                    PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    sbX.append(stringWriter.toString());
                    str = sbX.toString();
                }
            } else {
                if (th == null) {
                    return;
                }
                StringWriter stringWriter2 = new StringWriter(256);
                PrintWriter printWriter2 = new PrintWriter((Writer) stringWriter2, false);
                th.printStackTrace(printWriter2);
                printWriter2.flush();
                str = stringWriter2.toString();
            }
            log(i2, strA, str, th);
        }

        public void d(String str, Object... objArr) {
            b(3, null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            b(6, null, str, objArr);
        }

        public void i(String str, Object... objArr) {
            b(4, null, str, objArr);
        }

        public abstract void log(int i2, String str, String str2, Throwable th);

        public void log(int i2, String str, Object... objArr) {
            b(i2, null, str, objArr);
        }

        public void v(String str, Object... objArr) {
            b(2, null, str, objArr);
        }

        public void w(String str, Object... objArr) {
            b(5, null, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            b(7, null, str, objArr);
        }

        public void d(Throwable th, String str, Object... objArr) {
            b(3, th, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            b(6, th, str, objArr);
        }

        public void i(Throwable th, String str, Object... objArr) {
            b(4, th, str, objArr);
        }

        public void log(int i2, Throwable th, String str, Object... objArr) {
            b(i2, th, str, objArr);
        }

        public void v(Throwable th, String str, Object... objArr) {
            b(2, th, str, objArr);
        }

        public void w(Throwable th, String str, Object... objArr) {
            b(5, th, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            b(7, th, str, objArr);
        }

        public void d(Throwable th) {
            b(3, th, null, new Object[0]);
        }

        public void e(Throwable th) {
            b(6, th, null, new Object[0]);
        }

        public void i(Throwable th) {
            b(4, th, null, new Object[0]);
        }

        public void log(int i2, Throwable th) {
            b(i2, th, null, new Object[0]);
        }

        public void v(Throwable th) {
            b(2, th, null, new Object[0]);
        }

        public void w(Throwable th) {
            b(5, th, null, new Object[0]);
        }

        public void wtf(Throwable th) {
            b(7, th, null, new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        f58263c.d(str, objArr);
    }

    public static void b(Throwable th, String str, Object... objArr) {
        f58263c.e(th, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        f58263c.i(str, objArr);
    }

    public static Tree d(String str) {
        for (Tree tree : f58262b) {
            tree.f58265a.set(str);
        }
        return f58263c;
    }

    /* renamed from: timber.log.Timber$1, reason: invalid class name */
    public static class AnonymousClass1 extends Tree {
        @Override // timber.log.Timber.Tree
        public final void d(String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.d(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void e(String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.e(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void i(String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.i(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void log(int i2, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.log(i2, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void v(String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.v(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void w(String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.w(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void wtf(String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.wtf(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void d(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.d(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void e(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.e(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void i(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.i(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void log(int i2, Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.log(i2, th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void v(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.v(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void w(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.w(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void wtf(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.f58262b) {
                tree.wtf(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void d(Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.d(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void e(Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.e(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void i(Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.i(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void log(int i2, Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.log(i2, th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void v(Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.v(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void w(Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.w(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void wtf(Throwable th) {
            for (Tree tree : Timber.f58262b) {
                tree.wtf(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void log(int i2, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    }
}
