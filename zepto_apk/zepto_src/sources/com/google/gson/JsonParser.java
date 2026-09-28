package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes4.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement a(JsonReader jsonReader) {
        Strictness strictness = jsonReader.f45463b;
        if (strictness == Strictness.f45266b) {
            jsonReader.f45463b = Strictness.f45265a;
        }
        try {
            try {
                return Streams.a(jsonReader);
            } catch (OutOfMemoryError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            } catch (StackOverflowError e3) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e3);
            }
        } finally {
            jsonReader.n0(strictness);
        }
    }

    public static JsonElement b(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            JsonElement jsonElementA = a(jsonReader);
            jsonElementA.getClass();
            if (!(jsonElementA instanceof JsonNull) && jsonReader.j0() != JsonToken.f45484j) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return jsonElementA;
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }
}
