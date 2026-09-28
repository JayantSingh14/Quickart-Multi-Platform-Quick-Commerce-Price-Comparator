package io.sentry;

import io.sentry.util.JsonSerializationUtils;
import io.sentry.vendor.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class JsonObjectSerializer {

    /* renamed from: a, reason: collision with root package name */
    public final JsonReflectionObjectSerializer f51668a;

    public JsonObjectSerializer(int i2) {
        this.f51668a = new JsonReflectionObjectSerializer(i2);
    }

    public final void a(JsonObjectWriter jsonObjectWriter, ILogger iLogger, Object obj) {
        if (obj == null) {
            jsonObjectWriter.j();
            return;
        }
        if (obj instanceof Character) {
            jsonObjectWriter.e(Character.toString(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof String) {
            jsonObjectWriter.e((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonObjectWriter.c(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Number) {
            jsonObjectWriter.f((Number) obj);
            return;
        }
        if (obj instanceof Date) {
            try {
                jsonObjectWriter.e(DateUtils.e((Date) obj));
                return;
            } catch (Exception e2) {
                iLogger.b(SentryLevel.ERROR, "Error when serializing Date", e2);
                jsonObjectWriter.j();
                return;
            }
        }
        if (obj instanceof TimeZone) {
            try {
                jsonObjectWriter.e(((TimeZone) obj).getID());
                return;
            } catch (Exception e3) {
                iLogger.b(SentryLevel.ERROR, "Error when serializing TimeZone", e3);
                jsonObjectWriter.j();
                return;
            }
        }
        if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(jsonObjectWriter, iLogger);
            return;
        }
        if (obj instanceof Collection) {
            b(jsonObjectWriter, iLogger, (Collection) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            b(jsonObjectWriter, iLogger, Arrays.asList((Object[]) obj));
            return;
        }
        if (obj instanceof Map) {
            c(jsonObjectWriter, iLogger, (Map) obj);
            return;
        }
        if (obj instanceof Locale) {
            jsonObjectWriter.e(obj.toString());
            return;
        }
        if (obj instanceof AtomicIntegerArray) {
            b(jsonObjectWriter, iLogger, JsonSerializationUtils.a((AtomicIntegerArray) obj));
            return;
        }
        if (obj instanceof AtomicBoolean) {
            jsonObjectWriter.c(((AtomicBoolean) obj).get());
            return;
        }
        if (obj instanceof URI) {
            jsonObjectWriter.e(obj.toString());
            return;
        }
        if (obj instanceof InetAddress) {
            jsonObjectWriter.e(obj.toString());
            return;
        }
        if (obj instanceof UUID) {
            jsonObjectWriter.e(obj.toString());
            return;
        }
        if (obj instanceof Currency) {
            jsonObjectWriter.e(obj.toString());
            return;
        }
        if (obj instanceof Calendar) {
            c(jsonObjectWriter, iLogger, JsonSerializationUtils.c((Calendar) obj));
            return;
        }
        if (obj.getClass().isEnum()) {
            jsonObjectWriter.e(obj.toString());
            return;
        }
        try {
            a(jsonObjectWriter, iLogger, this.f51668a.b(iLogger, obj));
        } catch (Exception e4) {
            iLogger.b(SentryLevel.ERROR, "Failed serializing unknown object.", e4);
            jsonObjectWriter.e("[OBJECT]");
        }
    }

    public final void b(JsonObjectWriter jsonObjectWriter, ILogger iLogger, Collection collection) throws IOException {
        JsonWriter jsonWriter = jsonObjectWriter.f51669a;
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
        iArr2[i3] = 1;
        jsonWriter.f53160a.write(91);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            a(jsonObjectWriter, iLogger, it.next());
        }
        jsonWriter.b(1, 2, ']');
    }

    public final void c(JsonObjectWriter jsonObjectWriter, ILogger iLogger, Map map) throws IOException {
        jsonObjectWriter.k();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                jsonObjectWriter.d((String) obj);
                a(jsonObjectWriter, iLogger, map.get(obj));
            }
        }
        jsonObjectWriter.t();
    }
}
