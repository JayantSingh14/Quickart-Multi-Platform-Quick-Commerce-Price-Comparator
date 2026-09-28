package retrofit2;

import android.annotation.TargetApi;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.Converter;

@TargetApi(24)
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class OptionalConverterFactory extends Converter.Factory {

    @IgnoreJRERequirement
    /* loaded from: classes5.dex */
    public static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        public final Converter f58133a;

        public OptionalConverter(Converter converter) {
            this.f58133a = converter;
        }

        @Override // retrofit2.Converter
        public final Object a(Object obj) {
            return Optional.ofNullable(this.f58133a.a((ResponseBody) obj));
        }
    }

    @Override // retrofit2.Converter.Factory
    public final Converter b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Utils.e(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.d(Utils.d(0, (ParameterizedType) type), annotationArr));
    }
}
