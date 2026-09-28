package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;

/* loaded from: classes.dex */
final class RequestFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Class f58199a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f58200b;

    /* renamed from: c, reason: collision with root package name */
    public final HttpUrl f58201c;

    /* renamed from: d, reason: collision with root package name */
    public final String f58202d;

    /* renamed from: e, reason: collision with root package name */
    public final String f58203e;

    /* renamed from: f, reason: collision with root package name */
    public final Headers f58204f;

    /* renamed from: g, reason: collision with root package name */
    public final MediaType f58205g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f58206h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f58207i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f58208j;

    /* renamed from: k, reason: collision with root package name */
    public final ParameterHandler[] f58209k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f58210l;

    public static final class Builder {
        public static final Pattern y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        public static final Pattern z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        public final Retrofit f58211a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f58212b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f58213c;

        /* renamed from: d, reason: collision with root package name */
        public final Annotation[] f58214d;

        /* renamed from: e, reason: collision with root package name */
        public final Annotation[][] f58215e;

        /* renamed from: f, reason: collision with root package name */
        public final Type[] f58216f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f58217g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f58218h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f58219i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f58220j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f58221k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f58222l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f58223m;
        public boolean n;
        public String o;
        public boolean p;
        public boolean q;
        public boolean r;
        public String s;
        public Headers t;
        public MediaType u;
        public LinkedHashSet v;
        public ParameterHandler[] w;
        public boolean x;

        public Builder(Retrofit retrofit, Class cls, Method method) {
            this.f58211a = retrofit;
            this.f58212b = cls;
            this.f58213c = method;
            this.f58214d = method.getAnnotations();
            this.f58216f = method.getGenericParameterTypes();
            this.f58215e = method.getParameterAnnotations();
        }

        public static Class a(Class cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        public final void b(String str, String str2, boolean z2) {
            String str3 = this.o;
            Method method = this.f58213c;
            if (str3 != null) {
                throw Utils.j(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.o = str;
            this.p = z2;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            Pattern pattern = y;
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (pattern.matcher(strSubstring).find()) {
                    throw Utils.j(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.s = str2;
            Matcher matcher = pattern.matcher(str2);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            this.v = linkedHashSet;
        }

        public final void c(int i2, Type type) {
            if (Utils.g(type)) {
                throw Utils.k(this.f58213c, i2, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public RequestFactory(Builder builder) {
        this.f58199a = builder.f58212b;
        this.f58200b = builder.f58213c;
        this.f58201c = builder.f58211a.f58229c;
        this.f58202d = builder.o;
        this.f58203e = builder.s;
        this.f58204f = builder.t;
        this.f58205g = builder.u;
        this.f58206h = builder.p;
        this.f58207i = builder.q;
        this.f58208j = builder.r;
        this.f58209k = builder.w;
        this.f58210l = builder.x;
    }
}
