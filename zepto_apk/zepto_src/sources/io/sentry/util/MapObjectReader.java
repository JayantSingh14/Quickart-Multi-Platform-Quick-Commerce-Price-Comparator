package io.sentry.util;

import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.ObjectReader;
import io.sentry.SentryLevel;
import io.sentry.protocol.MetricSummary;
import io.sentry.vendor.gson.stream.JsonToken;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class MapObjectReader implements ObjectReader {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f53127a;

    public MapObjectReader(Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f53127a = arrayDeque;
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, map));
    }

    @Override // io.sentry.ObjectReader
    public final Object B1() {
        return c();
    }

    @Override // io.sentry.ObjectReader
    public final void E() {
    }

    @Override // io.sentry.ObjectReader
    public final void I(ILogger iLogger, AbstractMap abstractMap, String str) {
        try {
            abstractMap.put(str, c());
        } catch (Exception e2) {
            iLogger.a(SentryLevel.ERROR, e2, "Error deserializing unknown key: %s", str);
        }
    }

    @Override // io.sentry.ObjectReader
    public final ArrayList I1(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            b();
            return null;
        }
        try {
            a();
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = this.f53127a;
            if (!arrayDeque.isEmpty()) {
                do {
                    try {
                        arrayList.add(jsonDeserializer.a(this, iLogger));
                    } catch (Exception e2) {
                        iLogger.b(SentryLevel.WARNING, "Failed to deserialize object in list.", e2);
                    }
                } while (peek() == JsonToken.BEGIN_OBJECT);
            }
            if (arrayDeque.size() > 1) {
                arrayDeque.removeLast();
            }
            return arrayList;
        } catch (Exception e3) {
            throw new IOException(e3);
        }
    }

    @Override // io.sentry.ObjectReader
    public final TimeZone K(ILogger iLogger) {
        String str = (String) c();
        if (str != null) {
            return DesugarTimeZone.getTimeZone(str);
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final String K0() throws IOException {
        String str = (String) c();
        if (str != null) {
            return str;
        }
        throw new IOException("Expected string");
    }

    @Override // io.sentry.ObjectReader
    public final Integer M0() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return Integer.valueOf(((Number) objC).intValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final Long R0() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return Long.valueOf(((Number) objC).longValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final Double W() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return Double.valueOf(((Number) objC).doubleValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public final HashMap W0(ILogger iLogger, MetricSummary.Deserializer deserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            b();
            return null;
        }
        HashMap map = new HashMap();
        try {
            k();
            if (!this.f53127a.isEmpty()) {
                while (true) {
                    String strX = X();
                    ArrayList arrayListI1 = I1(iLogger, deserializer);
                    if (arrayListI1 != null) {
                        map.put(strX, arrayListI1);
                    }
                    if (peek() != JsonToken.BEGIN_OBJECT && peek() != JsonToken.NAME) {
                        break;
                    }
                }
            }
            t();
            return map;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.ObjectReader
    public final String X() throws IOException {
        Map.Entry entry = (Map.Entry) this.f53127a.peekLast();
        if (entry != null && entry.getKey() != null) {
            return (String) entry.getKey();
        }
        throw new IOException("Expected a name but was " + peek());
    }

    public final void a() throws IOException {
        ArrayDeque arrayDeque = this.f53127a;
        Map.Entry entry = (Map.Entry) arrayDeque.removeLast();
        if (entry == null) {
            throw new IOException("No more entries");
        }
        Object value = entry.getValue();
        if (!(value instanceof List)) {
            throw new IOException("Current token is not an object");
        }
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, JsonToken.END_ARRAY));
        List list = (List) value;
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayDeque.addLast(new AbstractMap.SimpleEntry(null, list.get(size)));
        }
    }

    @Override // io.sentry.ObjectReader
    public final String a1() {
        return (String) c();
    }

    public final void b() throws IOException {
        if (c() == null) {
            return;
        }
        throw new IOException("Expected null but was " + peek());
    }

    public final Object c() throws IOException {
        try {
            ArrayDeque arrayDeque = this.f53127a;
            Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
            if (entry == null) {
                return null;
            }
            Object value = entry.getValue();
            arrayDeque.removeLast();
            return value;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.ObjectReader
    public final Date c0(ILogger iLogger) {
        String str = (String) c();
        if (str == null) {
            return null;
        }
        try {
            try {
                return DateUtils.c(str);
            } catch (Exception unused) {
                return DateUtils.d(str);
            }
        } catch (Exception e2) {
            iLogger.b(SentryLevel.ERROR, "Error when deserializing millis timestamp format.", e2);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f53127a.clear();
    }

    @Override // io.sentry.ObjectReader
    public final HashMap d1(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            b();
            return null;
        }
        try {
            k();
            HashMap map = new HashMap();
            if (!this.f53127a.isEmpty()) {
                while (true) {
                    try {
                        map.put(X(), jsonDeserializer.a(this, iLogger));
                    } catch (Exception e2) {
                        iLogger.b(SentryLevel.WARNING, "Failed to deserialize object in map.", e2);
                    }
                    if (peek() != JsonToken.BEGIN_OBJECT && peek() != JsonToken.NAME) {
                        break;
                    }
                }
            }
            t();
            return map;
        } catch (Exception e3) {
            throw new IOException(e3);
        }
    }

    @Override // io.sentry.ObjectReader
    public final Boolean f0() {
        return (Boolean) c();
    }

    @Override // io.sentry.ObjectReader
    public final void k() throws IOException {
        ArrayDeque arrayDeque = this.f53127a;
        Map.Entry entry = (Map.Entry) arrayDeque.removeLast();
        if (entry == null) {
            throw new IOException("No more entries");
        }
        Object value = entry.getValue();
        if (!(value instanceof Map)) {
            throw new IOException("Current token is not an object");
        }
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, JsonToken.END_OBJECT));
        Iterator it = ((Map) value).entrySet().iterator();
        while (it.hasNext()) {
            arrayDeque.addLast((Map.Entry) it.next());
        }
    }

    @Override // io.sentry.ObjectReader
    public final double nextDouble() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return ((Number) objC).doubleValue();
        }
        throw new IOException("Expected double");
    }

    @Override // io.sentry.ObjectReader
    public final float nextFloat() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return ((Number) objC).floatValue();
        }
        throw new IOException("Expected float");
    }

    @Override // io.sentry.ObjectReader
    public final int nextInt() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return ((Number) objC).intValue();
        }
        throw new IOException("Expected int");
    }

    @Override // io.sentry.ObjectReader
    public final long nextLong() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return ((Number) objC).longValue();
        }
        throw new IOException("Expected long");
    }

    @Override // io.sentry.ObjectReader
    public final Object o0(ILogger iLogger, JsonDeserializer jsonDeserializer) {
        ArrayDeque arrayDeque = this.f53127a;
        Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
        if (entry == null) {
            return null;
        }
        Object value = entry.getValue();
        if (iLogger != null) {
            return jsonDeserializer.a(this, iLogger);
        }
        arrayDeque.removeLast();
        return value;
    }

    @Override // io.sentry.ObjectReader
    public final void p(boolean z) {
    }

    @Override // io.sentry.ObjectReader
    public final JsonToken peek() {
        ArrayDeque arrayDeque = this.f53127a;
        if (arrayDeque.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
        if (entry == null) {
            return JsonToken.END_DOCUMENT;
        }
        if (entry.getKey() != null) {
            return JsonToken.NAME;
        }
        Object value = entry.getValue();
        return value instanceof Map ? JsonToken.BEGIN_OBJECT : value instanceof List ? JsonToken.BEGIN_ARRAY : value instanceof String ? JsonToken.STRING : value instanceof Number ? JsonToken.NUMBER : value instanceof Boolean ? JsonToken.BOOLEAN : value instanceof JsonToken ? (JsonToken) value : JsonToken.END_DOCUMENT;
    }

    @Override // io.sentry.ObjectReader
    public final void t() {
        ArrayDeque arrayDeque = this.f53127a;
        if (arrayDeque.size() > 1) {
            arrayDeque.removeLast();
        }
    }

    @Override // io.sentry.ObjectReader
    public final Float x1() throws IOException {
        Object objC = c();
        if (objC instanceof Number) {
            return Float.valueOf(((Number) objC).floatValue());
        }
        return null;
    }
}
