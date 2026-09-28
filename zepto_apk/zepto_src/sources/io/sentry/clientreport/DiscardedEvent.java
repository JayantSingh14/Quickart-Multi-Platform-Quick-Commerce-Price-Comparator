package io.sentry.clientreport;

import android.support.v4.media.b;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class DiscardedEvent implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f52719a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52720b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f52721c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f52722d;

    public static final class Deserializer implements JsonDeserializer<DiscardedEvent> {
        public static IllegalStateException b(String str, ILogger iLogger) {
            String strD = b.D("Missing required field \"", str, "\"");
            IllegalStateException illegalStateException = new IllegalStateException(strD);
            iLogger.b(SentryLevel.ERROR, strD, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            String strA1 = null;
            String strA12 = null;
            Long lR0 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "quantity":
                        lR0 = objectReader.R0();
                        break;
                    case "reason":
                        strA1 = objectReader.a1();
                        break;
                    case "category":
                        strA12 = objectReader.a1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            if (strA1 == null) {
                throw b("reason", iLogger);
            }
            if (strA12 == null) {
                throw b("category", iLogger);
            }
            if (lR0 == null) {
                throw b("quantity", iLogger);
            }
            DiscardedEvent discardedEvent = new DiscardedEvent(strA1, strA12, lR0);
            discardedEvent.f52722d = map;
            return discardedEvent;
        }
    }

    public static final class JsonKeys {
    }

    public DiscardedEvent(String str, String str2, Long l2) {
        this.f52719a = str;
        this.f52720b = str2;
        this.f52721c = l2;
    }

    public final String a() {
        return this.f52720b;
    }

    public final Long b() {
        return this.f52721c;
    }

    public final String c() {
        return this.f52719a;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("reason").e(this.f52719a);
        objectWriter.d("category").e(this.f52720b);
        objectWriter.d("quantity").f(this.f52721c);
        HashMap map = this.f52722d;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52722d.get(str));
            }
        }
        objectWriter.t();
    }

    public final String toString() {
        return "DiscardedEvent{reason='" + this.f52719a + "', category='" + this.f52720b + "', quantity=" + this.f52721c + '}';
    }
}
