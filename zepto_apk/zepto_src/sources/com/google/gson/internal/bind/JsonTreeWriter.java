package com.google.gson.internal.bind;

import android.support.v4.media.b;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class JsonTreeWriter extends JsonWriter {
    public static final Writer r = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    };
    public static final JsonPrimitive s = new JsonPrimitive("closed");
    public final ArrayList o;
    public String p;
    public JsonElement q;

    public JsonTreeWriter() {
        super(r);
        this.o = new ArrayList();
        this.q = JsonNull.f45255a;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void O(double d2) {
        if (this.f45495h == Strictness.f45265a || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            r0(new JsonPrimitive(Double.valueOf(d2)));
        } else {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void T(long j2) {
        r0(new JsonPrimitive(Long.valueOf(j2)));
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void V(Boolean bool) {
        if (bool == null) {
            r0(JsonNull.f45255a);
        } else {
            r0(new JsonPrimitive(bool));
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void Z(Number number) {
        if (number == null) {
            r0(JsonNull.f45255a);
            return;
        }
        if (this.f45495h != Strictness.f45265a) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        r0(new JsonPrimitive(number));
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void b() {
        JsonArray jsonArray = new JsonArray();
        r0(jsonArray);
        this.o.add(jsonArray);
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.o;
        if (!arrayList.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList.add(s);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void e() {
        ArrayList arrayList = this.o;
        if (arrayList.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (!(n0() instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public final void flush() {
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void j0(String str) {
        if (str == null) {
            r0(JsonNull.f45255a);
        } else {
            r0(new JsonPrimitive(str));
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void k() {
        JsonObject jsonObject = new JsonObject();
        r0(jsonObject);
        this.o.add(jsonObject);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void k0(boolean z) {
        r0(new JsonPrimitive(Boolean.valueOf(z)));
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void l(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.o.isEmpty() || this.p != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(n0() instanceof JsonObject)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.p = str;
    }

    public final JsonElement n0() {
        return (JsonElement) b.c(1, this.o);
    }

    public final void r0(JsonElement jsonElement) {
        if (this.p != null) {
            jsonElement.getClass();
            if (!(jsonElement instanceof JsonNull) || this.f45498k) {
                ((JsonObject) n0()).j(this.p, jsonElement);
            }
            this.p = null;
            return;
        }
        if (this.o.isEmpty()) {
            this.q = jsonElement;
            return;
        }
        JsonElement jsonElementN0 = n0();
        if (!(jsonElementN0 instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        JsonArray jsonArray = (JsonArray) jsonElementN0;
        if (jsonElement == null) {
            jsonArray.getClass();
            jsonElement = JsonNull.f45255a;
        }
        jsonArray.f45254a.add(jsonElement);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter s() {
        r0(JsonNull.f45255a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void t() {
        ArrayList arrayList = this.o;
        if (arrayList.isEmpty() || this.p != null) {
            throw new IllegalStateException();
        }
        if (!(n0() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }
}
