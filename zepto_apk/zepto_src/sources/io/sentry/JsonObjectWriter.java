package io.sentry;

import io.sentry.vendor.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class JsonObjectWriter implements ObjectWriter {

    /* renamed from: a, reason: collision with root package name */
    public final JsonWriter f51669a;

    /* renamed from: b, reason: collision with root package name */
    public final JsonObjectSerializer f51670b;

    public JsonObjectWriter(int i2, Writer writer) {
        this.f51669a = new JsonWriter(writer);
        this.f51670b = new JsonObjectSerializer(i2);
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter a(long j2) throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        jsonWriter.s();
        jsonWriter.a();
        jsonWriter.f53160a.write(Long.toString(j2));
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter b(double d2) throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        jsonWriter.s();
        if (jsonWriter.f53165f || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
            jsonWriter.a();
            jsonWriter.f53160a.append((CharSequence) Double.toString(d2));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter c(boolean z) throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        jsonWriter.s();
        jsonWriter.a();
        jsonWriter.f53160a.write(z ? "true" : "false");
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter d(String str) {
        JsonWriter jsonWriter = this.f51669a;
        if (str == null) {
            jsonWriter.getClass();
            throw new NullPointerException("name == null");
        }
        if (jsonWriter.f53166g != null) {
            throw new IllegalStateException();
        }
        if (jsonWriter.f53162c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        jsonWriter.f53166g = str;
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter e(String str) throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        if (str == null) {
            jsonWriter.e();
            return this;
        }
        jsonWriter.s();
        jsonWriter.a();
        jsonWriter.r(str);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter f(Number number) throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        if (number == null) {
            jsonWriter.e();
            return this;
        }
        jsonWriter.s();
        String string = number.toString();
        if (jsonWriter.f53165f || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            jsonWriter.a();
            jsonWriter.f53160a.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter g() throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        jsonWriter.s();
        jsonWriter.a();
        jsonWriter.f53160a.append((CharSequence) StringUtils.LF);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter h(ILogger iLogger, Object obj) {
        this.f51670b.a(this, iLogger, obj);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter i(Boolean bool) throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        if (bool == null) {
            jsonWriter.e();
            return this;
        }
        jsonWriter.s();
        jsonWriter.a();
        jsonWriter.f53160a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public final ObjectWriter j() throws IOException {
        this.f51669a.e();
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter k() throws IOException {
        JsonWriter jsonWriter = this.f51669a;
        jsonWriter.s();
        jsonWriter.a();
        int i2 = jsonWriter.f53162c;
        int[] iArr = jsonWriter.f53161b;
        if (i2 == iArr.length) {
            jsonWriter.f53161b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = jsonWriter.f53161b;
        int i3 = jsonWriter.f53162c;
        jsonWriter.f53162c = i3 + 1;
        iArr2[i3] = 3;
        jsonWriter.f53160a.write(WKSRecord.Service.NTP);
        return this;
    }

    @Override // io.sentry.ObjectWriter
    public final void p(boolean z) {
        this.f51669a.f53165f = z;
    }

    @Override // io.sentry.ObjectWriter
    public final ObjectWriter t() throws IOException {
        this.f51669a.b(3, 5, '}');
        return this;
    }
}
