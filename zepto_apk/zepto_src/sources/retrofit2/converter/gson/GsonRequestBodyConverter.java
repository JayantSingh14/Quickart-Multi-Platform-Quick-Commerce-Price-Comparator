package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.Buffer$outputStream$1;
import retrofit2.Converter;

/* loaded from: classes.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /* renamed from: c, reason: collision with root package name */
    public static final MediaType f58256c;

    /* renamed from: a, reason: collision with root package name */
    public final Gson f58257a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter f58258b;

    static {
        Pattern pattern = MediaType.f56278d;
        f58256c = MediaType.Companion.a("application/json; charset=UTF-8");
    }

    public GsonRequestBodyConverter(Gson gson, TypeAdapter typeAdapter) {
        this.f58257a = gson;
        this.f58258b = typeAdapter;
    }

    @Override // retrofit2.Converter
    public final Object a(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterH = this.f58257a.h(new OutputStreamWriter(new Buffer$outputStream$1(buffer), StandardCharsets.UTF_8));
        this.f58258b.c(jsonWriterH, obj);
        jsonWriterH.close();
        return RequestBody.create(f58256c, buffer.s0(buffer.f56914b));
    }
}
