package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* loaded from: classes.dex */
final class BuiltInConverters extends Converter.Factory {

    /* loaded from: classes5.dex */
    public static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        public static final BufferingResponseBodyConverter f58076a = new BufferingResponseBodyConverter();

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            ResponseBody responseBody = (ResponseBody) obj;
            try {
                Buffer content = new Buffer();
                responseBody.source().F1(content);
                MediaType mediaTypeL = responseBody.l();
                long jE = responseBody.e();
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(content, "<this>");
                return new ResponseBody$Companion$asResponseBody$1(mediaTypeL, jE, content);
            } finally {
                responseBody.close();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {

        /* renamed from: a, reason: collision with root package name */
        public static final RequestBodyConverter f58077a = new RequestBodyConverter();

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            return (RequestBody) obj;
        }
    }

    /* loaded from: classes5.dex */
    public static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        public static final StreamingResponseBodyConverter f58078a = new StreamingResponseBodyConverter();

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            return (ResponseBody) obj;
        }
    }

    /* loaded from: classes5.dex */
    public static final class ToStringConverter implements Converter<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final ToStringConverter f58079a = new ToStringConverter();

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            return obj.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static final class UnitResponseBodyConverter implements Converter<ResponseBody, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public static final UnitResponseBodyConverter f58080a = new UnitResponseBodyConverter();

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            ((ResponseBody) obj).close();
            return Unit.f53572a;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {

        /* renamed from: a, reason: collision with root package name */
        public static final VoidResponseBodyConverter f58081a = new VoidResponseBodyConverter();

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            ((ResponseBody) obj).close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    public final Converter a(Type type) {
        if (RequestBody.class.isAssignableFrom(Utils.e(type))) {
            return RequestBodyConverter.f58077a;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public final Converter b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            return Utils.h(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.f58078a : BufferingResponseBodyConverter.f58076a;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.f58081a;
        }
        if (Utils.i(type)) {
            return UnitResponseBodyConverter.f58080a;
        }
        return null;
    }
}
