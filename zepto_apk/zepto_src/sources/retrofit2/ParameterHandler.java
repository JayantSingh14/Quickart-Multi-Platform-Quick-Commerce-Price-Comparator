package retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.BuiltInConverters;

/* loaded from: classes.dex */
abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58136a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58137b;

        /* renamed from: c, reason: collision with root package name */
        public final Converter f58138c;

        public Body(Method method, int i2, Converter converter) {
            this.f58136a = method;
            this.f58137b = i2;
            this.f58138c = converter;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            int i2 = this.f58137b;
            Method method = this.f58136a;
            if (obj == null) {
                throw Utils.k(method, i2, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.f58196k = (RequestBody) this.f58138c.a(obj);
            } catch (IOException e2) {
                throw Utils.l(method, e2, i2, "Unable to convert " + obj + " to RequestBody", new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Field<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f58139a;

        /* renamed from: b, reason: collision with root package name */
        public final Converter f58140b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f58141c;

        public Field(String str, Converter converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.f58139a = str;
            this.f58140b = converter;
            this.f58141c = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            ((BuiltInConverters.ToStringConverter) this.f58140b).getClass();
            String string = obj.toString();
            if (string == null) {
                return;
            }
            FormBody.Builder builder = requestBuilder.f58195j;
            String str = this.f58139a;
            if (this.f58141c) {
                builder.b(str, string);
            } else {
                builder.a(str, string);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58142a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58143b;

        /* renamed from: c, reason: collision with root package name */
        public final Converter f58144c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f58145d;

        public FieldMap(Method method, int i2, Converter converter, boolean z) {
            this.f58142a = method;
            this.f58143b = i2;
            this.f58144c = converter;
            this.f58145d = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            Map map = (Map) obj;
            int i2 = this.f58143b;
            Method method = this.f58142a;
            if (map == null) {
                throw Utils.k(method, i2, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.k(method, i2, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.k(method, i2, android.support.v4.media.b.D("Field map contained null value for key '", str, "'."), new Object[0]);
                }
                Converter converter = this.f58144c;
                ((BuiltInConverters.ToStringConverter) converter).getClass();
                String string = value.toString();
                if (string == null) {
                    throw Utils.k(method, i2, "Field map value '" + value + "' converted to null by " + converter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                FormBody.Builder builder = requestBuilder.f58195j;
                if (this.f58145d) {
                    builder.b(str, string);
                } else {
                    builder.a(str, string);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Header<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f58146a;

        /* renamed from: b, reason: collision with root package name */
        public final Converter f58147b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f58148c;

        public Header(String str, Converter converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.f58146a = str;
            this.f58147b = converter;
            this.f58148c = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            ((BuiltInConverters.ToStringConverter) this.f58147b).getClass();
            String string = obj.toString();
            if (string == null) {
                return;
            }
            requestBuilder.a(this.f58146a, string, this.f58148c);
        }
    }

    /* loaded from: classes5.dex */
    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58149a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58150b;

        /* renamed from: c, reason: collision with root package name */
        public final Converter f58151c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f58152d;

        public HeaderMap(Method method, int i2, Converter converter, boolean z) {
            this.f58149a = method;
            this.f58150b = i2;
            this.f58151c = converter;
            this.f58152d = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            Map map = (Map) obj;
            int i2 = this.f58150b;
            Method method = this.f58149a;
            if (map == null) {
                throw Utils.k(method, i2, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.k(method, i2, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.k(method, i2, android.support.v4.media.b.D("Header map contained null value for key '", str, "'."), new Object[0]);
                }
                ((BuiltInConverters.ToStringConverter) this.f58151c).getClass();
                requestBuilder.a(str, value.toString(), this.f58152d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Headers extends ParameterHandler<okhttp3.Headers> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58153a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58154b;

        public Headers(Method method, int i2) {
            this.f58153a = method;
            this.f58154b = i2;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            okhttp3.Headers headers = (okhttp3.Headers) obj;
            if (headers == null) {
                int i2 = this.f58154b;
                throw Utils.k(this.f58153a, i2, "Headers parameter must not be null.", new Object[0]);
            }
            Headers.Builder builder = requestBuilder.f58191f;
            builder.getClass();
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                builder.c(headers.f(i3), headers.m(i3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Part<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58155a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58156b;

        /* renamed from: c, reason: collision with root package name */
        public final okhttp3.Headers f58157c;

        /* renamed from: d, reason: collision with root package name */
        public final Converter f58158d;

        public Part(Method method, int i2, okhttp3.Headers headers, Converter converter) {
            this.f58155a = method;
            this.f58156b = i2;
            this.f58157c = headers;
            this.f58158d = converter;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            try {
                requestBuilder.f58194i.a(this.f58157c, (RequestBody) this.f58158d.a(obj));
            } catch (IOException e2) {
                throw Utils.k(this.f58155a, this.f58156b, "Unable to convert " + obj + " to RequestBody", e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58159a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58160b;

        /* renamed from: c, reason: collision with root package name */
        public final Converter f58161c;

        /* renamed from: d, reason: collision with root package name */
        public final String f58162d;

        public PartMap(Method method, int i2, Converter converter, String str) {
            this.f58159a = method;
            this.f58160b = i2;
            this.f58161c = converter;
            this.f58162d = str;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            Map map = (Map) obj;
            int i2 = this.f58160b;
            Method method = this.f58159a;
            if (map == null) {
                throw Utils.k(method, i2, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.k(method, i2, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.k(method, i2, android.support.v4.media.b.D("Part map contained null value for key '", str, "'."), new Object[0]);
                }
                requestBuilder.f58194i.a(Headers.Companion.c("Content-Disposition", android.support.v4.media.b.D("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.f58162d), (RequestBody) this.f58161c.a(value));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Path<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58163a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58164b;

        /* renamed from: c, reason: collision with root package name */
        public final String f58165c;

        /* renamed from: d, reason: collision with root package name */
        public final Converter f58166d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f58167e;

        public Path(Method method, int i2, String str, Converter converter, boolean z) {
            this.f58163a = method;
            this.f58164b = i2;
            Objects.requireNonNull(str, "name == null");
            this.f58165c = str;
            this.f58166d = converter;
            this.f58167e = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00eb  */
        @Override // retrofit2.ParameterHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(retrofit2.RequestBuilder r18, java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.ParameterHandler.Path.a(retrofit2.RequestBuilder, java.lang.Object):void");
        }
    }

    /* loaded from: classes5.dex */
    public static final class Query<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f58168a;

        /* renamed from: b, reason: collision with root package name */
        public final Converter f58169b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f58170c;

        public Query(String str, Converter converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.f58168a = str;
            this.f58169b = converter;
            this.f58170c = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            ((BuiltInConverters.ToStringConverter) this.f58169b).getClass();
            String string = obj.toString();
            if (string == null) {
                return;
            }
            requestBuilder.b(this.f58168a, string, this.f58170c);
        }
    }

    /* loaded from: classes5.dex */
    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58171a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58172b;

        /* renamed from: c, reason: collision with root package name */
        public final Converter f58173c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f58174d;

        public QueryMap(Method method, int i2, Converter converter, boolean z) {
            this.f58171a = method;
            this.f58172b = i2;
            this.f58173c = converter;
            this.f58174d = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            Map map = (Map) obj;
            int i2 = this.f58172b;
            Method method = this.f58171a;
            if (map == null) {
                throw Utils.k(method, i2, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.k(method, i2, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.k(method, i2, android.support.v4.media.b.D("Query map contained null value for key '", str, "'."), new Object[0]);
                }
                Converter converter = this.f58173c;
                ((BuiltInConverters.ToStringConverter) converter).getClass();
                String string = value.toString();
                if (string == null) {
                    throw Utils.k(method, i2, "Query map value '" + value + "' converted to null by " + converter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.b(str, string, this.f58174d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class QueryName<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Converter f58175a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f58176b;

        public QueryName(Converter converter, boolean z) {
            this.f58175a = converter;
            this.f58176b = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            ((BuiltInConverters.ToStringConverter) this.f58175a).getClass();
            requestBuilder.b(obj.toString(), null, this.f58176b);
        }
    }

    /* loaded from: classes5.dex */
    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {

        /* renamed from: a, reason: collision with root package name */
        public static final RawPart f58177a = new RawPart();

        private RawPart() {
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            MultipartBody.Part part = (MultipartBody.Part) obj;
            if (part != null) {
                requestBuilder.f58194i.b(part);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class RelativeUrl extends ParameterHandler<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final Method f58178a;

        /* renamed from: b, reason: collision with root package name */
        public final int f58179b;

        public RelativeUrl(Method method, int i2) {
            this.f58178a = method;
            this.f58179b = i2;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            if (obj != null) {
                requestBuilder.f58188c = obj.toString();
            } else {
                int i2 = this.f58179b;
                throw Utils.k(this.f58178a, i2, "@Url parameter is null.", new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Tag<T> extends ParameterHandler<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class f58180a;

        public Tag(Class cls) {
            this.f58180a = cls;
        }

        @Override // retrofit2.ParameterHandler
        public final void a(RequestBuilder requestBuilder, Object obj) {
            requestBuilder.f58190e.h(this.f58180a, obj);
        }
    }

    public abstract void a(RequestBuilder requestBuilder, Object obj);
}
