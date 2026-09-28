package io.sentry;

import io.sentry.JsonObjectDeserializer;
import io.sentry.protocol.MetricSummary;
import io.sentry.vendor.gson.stream.JsonReader;
import io.sentry.vendor.gson.stream.JsonToken;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.Reader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class JsonObjectReader implements ObjectReader {

    /* renamed from: a, reason: collision with root package name */
    public final JsonReader f51667a;

    public JsonObjectReader(Reader reader) {
        this.f51667a = new JsonReader(reader);
    }

    @Override // io.sentry.ObjectReader
    public final Object B1() throws IOException {
        JsonObjectDeserializer jsonObjectDeserializer = new JsonObjectDeserializer();
        jsonObjectDeserializer.d(this);
        JsonObjectDeserializer.Token tokenA = jsonObjectDeserializer.a();
        if (tokenA != null) {
            return tokenA.getValue();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a3, code lost:
    
        r2.b();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x009d. Please report as an issue. */
    @Override // io.sentry.ObjectReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.JsonObjectReader.E():void");
    }

    @Override // io.sentry.ObjectReader
    public final void I(ILogger iLogger, AbstractMap abstractMap, String str) {
        try {
            abstractMap.put(str, B1());
        } catch (Exception e2) {
            iLogger.a(SentryLevel.ERROR, e2, "Error deserializing unknown key: %s", str);
        }
    }

    @Override // io.sentry.ObjectReader
    public final ArrayList I1(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.N();
            return null;
        }
        jsonReader.a();
        ArrayList arrayList = new ArrayList();
        if (jsonReader.r()) {
            do {
                try {
                    arrayList.add(jsonDeserializer.a(this, iLogger));
                } catch (Exception e2) {
                    iLogger.b(SentryLevel.WARNING, "Failed to deserialize object in list.", e2);
                }
            } while (jsonReader.peek() == JsonToken.BEGIN_OBJECT);
        }
        jsonReader.e();
        return arrayList;
    }

    @Override // io.sentry.ObjectReader
    public final TimeZone K(ILogger iLogger) throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.N();
            return null;
        }
        try {
            return DesugarTimeZone.getTimeZone(jsonReader.K0());
        } catch (Exception e2) {
            iLogger.b(SentryLevel.ERROR, "Error when deserializing TimeZone", e2);
            return null;
        }
    }

    @Override // io.sentry.ObjectReader
    public final String K0() {
        return this.f51667a.K0();
    }

    @Override // io.sentry.ObjectReader
    public final Integer M0() throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return Integer.valueOf(jsonReader.nextInt());
        }
        jsonReader.N();
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final Long R0() throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return Long.valueOf(jsonReader.nextLong());
        }
        jsonReader.N();
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final Double W() throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return Double.valueOf(jsonReader.nextDouble());
        }
        jsonReader.N();
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final HashMap W0(ILogger iLogger, MetricSummary.Deserializer deserializer) throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.N();
            return null;
        }
        HashMap map = new HashMap();
        k();
        if (jsonReader.r()) {
            while (true) {
                String strX = jsonReader.X();
                ArrayList arrayListI1 = I1(iLogger, deserializer);
                if (arrayListI1 != null) {
                    map.put(strX, arrayListI1);
                }
                if (jsonReader.peek() != JsonToken.BEGIN_OBJECT && jsonReader.peek() != JsonToken.NAME) {
                    break;
                }
            }
        }
        t();
        return map;
    }

    @Override // io.sentry.ObjectReader
    public final String X() {
        return this.f51667a.X();
    }

    @Override // io.sentry.ObjectReader
    public final String a1() throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return jsonReader.K0();
        }
        jsonReader.N();
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final Date c0(ILogger iLogger) throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.N();
            return null;
        }
        String strK0 = jsonReader.K0();
        if (strK0 == null) {
            return null;
        }
        try {
            try {
                return DateUtils.c(strK0);
            } catch (Exception e2) {
                iLogger.b(SentryLevel.ERROR, "Error when deserializing millis timestamp format.", e2);
                return null;
            }
        } catch (Exception unused) {
            return DateUtils.d(strK0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f51667a.close();
    }

    @Override // io.sentry.ObjectReader
    public final HashMap d1(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.N();
            return null;
        }
        jsonReader.k();
        HashMap map = new HashMap();
        if (jsonReader.r()) {
            while (true) {
                try {
                    map.put(jsonReader.X(), jsonDeserializer.a(this, iLogger));
                } catch (Exception e2) {
                    iLogger.b(SentryLevel.WARNING, "Failed to deserialize object in map.", e2);
                }
                if (jsonReader.peek() != JsonToken.BEGIN_OBJECT && jsonReader.peek() != JsonToken.NAME) {
                    break;
                }
            }
        }
        jsonReader.t();
        return map;
    }

    @Override // io.sentry.ObjectReader
    public final Boolean f0() throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return Boolean.valueOf(jsonReader.A());
        }
        jsonReader.N();
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final void k() {
        this.f51667a.k();
    }

    @Override // io.sentry.ObjectReader
    public final double nextDouble() {
        return this.f51667a.nextDouble();
    }

    @Override // io.sentry.ObjectReader
    public final float nextFloat() {
        return (float) this.f51667a.nextDouble();
    }

    @Override // io.sentry.ObjectReader
    public final int nextInt() {
        return this.f51667a.nextInt();
    }

    @Override // io.sentry.ObjectReader
    public final long nextLong() {
        return this.f51667a.nextLong();
    }

    @Override // io.sentry.ObjectReader
    public final Object o0(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return jsonDeserializer.a(this, iLogger);
        }
        jsonReader.N();
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final void p(boolean z) {
        this.f51667a.f53147b = z;
    }

    @Override // io.sentry.ObjectReader
    public final JsonToken peek() {
        return this.f51667a.peek();
    }

    @Override // io.sentry.ObjectReader
    public final void t() {
        this.f51667a.t();
    }

    @Override // io.sentry.ObjectReader
    public final Float x1() throws IOException {
        JsonReader jsonReader = this.f51667a;
        if (jsonReader.peek() != JsonToken.NULL) {
            return Float.valueOf(nextFloat());
        }
        jsonReader.N();
        return null;
    }
}
