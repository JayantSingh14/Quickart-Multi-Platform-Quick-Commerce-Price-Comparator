package org.shadow.apache.commons.lang3.builder;

import android.support.v4.media.a;
import android.support.v4.media.b;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.shadow.apache.commons.lang3.ClassUtils;
import org.shadow.apache.commons.lang3.StringUtils;
import org.shadow.apache.commons.lang3.SystemUtils;

/* loaded from: classes5.dex */
public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle r = new DefaultToStringStyle();
    public static final ThreadLocal s;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f57735a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f57736b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f57737c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f57738d = true;

    /* renamed from: e, reason: collision with root package name */
    public String f57739e = "[";

    /* renamed from: f, reason: collision with root package name */
    public String f57740f = "]";

    /* renamed from: g, reason: collision with root package name */
    public final String f57741g = "=";

    /* renamed from: h, reason: collision with root package name */
    public final boolean f57742h = false;

    /* renamed from: i, reason: collision with root package name */
    public String f57743i = ",";

    /* renamed from: j, reason: collision with root package name */
    public String f57744j = "{";

    /* renamed from: k, reason: collision with root package name */
    public String f57745k = ",";

    /* renamed from: l, reason: collision with root package name */
    public String f57746l = "}";

    /* renamed from: m, reason: collision with root package name */
    public final String f57747m = "<null>";
    public final String n = "<size=";
    public final String o = ">";
    public final String p = "<";
    public final String q = ">";

    public static final class DefaultToStringStyle extends ToStringStyle {
    }

    public static final class JsonToStringStyle extends ToStringStyle {
        @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
        public final void a(StringBuffer stringBuffer, String str, Object obj) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.a(stringBuffer, str, obj);
        }

        @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
        public final void c(StringBuffer stringBuffer, String str, Object obj) {
            if (obj == null) {
                stringBuffer.append(this.f57747m);
                return;
            }
            if (obj.getClass() != String.class) {
                stringBuffer.append(obj);
                return;
            }
            stringBuffer.append("\"" + ((String) obj) + "\"");
        }

        @Override // org.shadow.apache.commons.lang3.builder.ToStringStyle
        public final void n(StringBuffer stringBuffer, String str) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.n(stringBuffer, b.D("\"", str, "\""));
        }
    }

    public static final class MultiLineToStringStyle extends ToStringStyle {
    }

    public static final class NoClassNameToStringStyle extends ToStringStyle {
    }

    public static final class NoFieldNameToStringStyle extends ToStringStyle {
    }

    public static final class ShortPrefixToStringStyle extends ToStringStyle {
    }

    public static final class SimpleToStringStyle extends ToStringStyle {
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = SystemUtils.f57727c;
        sb.append(str);
        sb.append("  ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("]");
        s = new ThreadLocal();
    }

    public static void u(Object obj) {
        if (obj != null) {
            ThreadLocal threadLocal = s;
            if (((Map) threadLocal.get()) == null) {
                threadLocal.set(new WeakHashMap());
            }
            ((Map) threadLocal.get()).put(obj, null);
        }
    }

    public static void v(Object obj) {
        if (obj != null) {
            ThreadLocal threadLocal = s;
            Map map = (Map) threadLocal.get();
            if (map != null) {
                map.remove(obj);
                if (map.isEmpty()) {
                    threadLocal.remove();
                }
            }
        }
    }

    public void a(StringBuffer stringBuffer, String str, Object obj) {
        n(stringBuffer, str);
        if (obj == null) {
            stringBuffer.append(this.f57747m);
        } else {
            o(stringBuffer, str, obj, true);
        }
        stringBuffer.append(this.f57743i);
    }

    public final void b(StringBuffer stringBuffer, Object obj) {
        if (!this.f57736b || obj == null) {
            return;
        }
        u(obj);
        if (this.f57737c) {
            stringBuffer.append(r(obj.getClass()));
        } else {
            stringBuffer.append(obj.getClass().getName());
        }
    }

    public void c(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    public void d(StringBuffer stringBuffer, String str, Collection collection) {
        stringBuffer.append(collection);
    }

    public void e(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append((int) bArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void f(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append(cArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void g(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append(dArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void h(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append(fArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void i(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append(iArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void j(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append(jArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void k(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            if (obj == null) {
                stringBuffer.append(this.f57747m);
            } else {
                o(stringBuffer, str, obj, true);
            }
        }
        stringBuffer.append(this.f57746l);
    }

    public void l(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append((int) sArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void m(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.f57744j);
        for (int i2 = 0; i2 < zArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            stringBuffer.append(zArr[i2]);
        }
        stringBuffer.append(this.f57746l);
    }

    public void n(StringBuffer stringBuffer, String str) {
        if (!this.f57735a || str == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(this.f57741g);
    }

    public final void o(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        Map map = (Map) s.get();
        if (map != null && map.containsKey(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            if (obj == null) {
                throw new NullPointerException("Cannot get the toString of a null identity");
            }
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        u(obj);
        try {
            if (obj instanceof Collection) {
                if (z) {
                    d(stringBuffer, str, (Collection) obj);
                } else {
                    p(stringBuffer, ((Collection) obj).size());
                }
            } else if (obj instanceof Map) {
                if (z) {
                    stringBuffer.append((Map) obj);
                } else {
                    p(stringBuffer, ((Map) obj).size());
                }
            } else if (obj instanceof long[]) {
                if (z) {
                    j(stringBuffer, str, (long[]) obj);
                } else {
                    p(stringBuffer, ((long[]) obj).length);
                }
            } else if (obj instanceof int[]) {
                if (z) {
                    i(stringBuffer, str, (int[]) obj);
                } else {
                    p(stringBuffer, ((int[]) obj).length);
                }
            } else if (obj instanceof short[]) {
                if (z) {
                    l(stringBuffer, str, (short[]) obj);
                } else {
                    p(stringBuffer, ((short[]) obj).length);
                }
            } else if (obj instanceof byte[]) {
                if (z) {
                    e(stringBuffer, str, (byte[]) obj);
                } else {
                    p(stringBuffer, ((byte[]) obj).length);
                }
            } else if (obj instanceof char[]) {
                if (z) {
                    f(stringBuffer, str, (char[]) obj);
                } else {
                    p(stringBuffer, ((char[]) obj).length);
                }
            } else if (obj instanceof double[]) {
                if (z) {
                    g(stringBuffer, str, (double[]) obj);
                } else {
                    p(stringBuffer, ((double[]) obj).length);
                }
            } else if (obj instanceof float[]) {
                if (z) {
                    h(stringBuffer, str, (float[]) obj);
                } else {
                    p(stringBuffer, ((float[]) obj).length);
                }
            } else if (obj instanceof boolean[]) {
                if (z) {
                    m(stringBuffer, str, (boolean[]) obj);
                } else {
                    p(stringBuffer, ((boolean[]) obj).length);
                }
            } else if (obj.getClass().isArray()) {
                if (z) {
                    k(stringBuffer, str, (Object[]) obj);
                } else {
                    p(stringBuffer, ((Object[]) obj).length);
                }
            } else if (z) {
                c(stringBuffer, str, obj);
            } else {
                stringBuffer.append(this.p);
                stringBuffer.append(r(obj.getClass()));
                stringBuffer.append(this.q);
            }
            v(obj);
        } catch (Throwable th) {
            v(obj);
            throw th;
        }
    }

    public final void p(StringBuffer stringBuffer, int i2) {
        stringBuffer.append(this.n);
        stringBuffer.append(i2);
        stringBuffer.append(this.o);
    }

    public String q() {
        return this.f57747m;
    }

    public String r(Class cls) {
        HashMap map = ClassUtils.f57702a;
        String name = cls.getName();
        if (StringUtils.a(name)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (name.startsWith("[")) {
            while (name.charAt(0) == '[') {
                name = name.substring(1);
                sb.append("[]");
            }
            if (name.charAt(0) == 'L' && name.charAt(name.length() - 1) == ';') {
                name = a.k(1, 1, name);
            }
            Map map2 = ClassUtils.f57705d;
            if (map2.containsKey(name)) {
                name = (String) map2.get(name);
            }
        }
        int iLastIndexOf = name.lastIndexOf(46);
        int iIndexOf = name.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = name.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        return strSubstring + ((Object) sb);
    }

    public boolean s() {
        return this.f57738d;
    }

    public void t(StringBuffer stringBuffer, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        stringBuffer.append(this.f57744j);
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            Object obj2 = Array.get(obj, i2);
            if (i2 > 0) {
                stringBuffer.append(this.f57745k);
            }
            if (obj2 == null) {
                stringBuffer.append(this.f57747m);
            } else {
                o(stringBuffer, null, obj2, true);
            }
        }
        stringBuffer.append(this.f57746l);
    }
}
