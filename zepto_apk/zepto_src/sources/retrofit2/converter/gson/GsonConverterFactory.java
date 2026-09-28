package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes.dex */
public final class GsonConverterFactory extends Converter.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f58255a;

    public GsonConverterFactory(Gson gson) {
        this.f58255a = gson;
    }

    public static GsonConverterFactory c() {
        return new GsonConverterFactory(new Gson());
    }

    @Override // retrofit2.Converter.Factory
    public final Converter a(Type type) {
        TypeToken typeToken = new TypeToken(type);
        Gson gson = this.f58255a;
        return new GsonRequestBodyConverter(gson, gson.f(typeToken));
    }

    @Override // retrofit2.Converter.Factory
    public final Converter b(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        TypeToken typeToken = new TypeToken(type);
        Gson gson = this.f58255a;
        return new GsonResponseBodyConverter(gson, gson.f(typeToken));
    }
}
