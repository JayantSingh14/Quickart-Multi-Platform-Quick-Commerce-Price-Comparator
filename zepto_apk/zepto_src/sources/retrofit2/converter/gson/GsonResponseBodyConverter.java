package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.Strictness;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes5.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f58259a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter f58260b;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter typeAdapter) {
        this.f58259a = gson;
        this.f58260b = typeAdapter;
    }

    @Override // retrofit2.Converter
    public final Object a(Object obj) {
        ResponseBody responseBody = (ResponseBody) obj;
        Reader readerC = responseBody.c();
        this.f58259a.getClass();
        JsonReader jsonReader = new JsonReader(readerC);
        jsonReader.n0(Strictness.f45266b);
        try {
            Object objB = this.f58260b.b(jsonReader);
            if (jsonReader.j0() == JsonToken.f45484j) {
                return objB;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
