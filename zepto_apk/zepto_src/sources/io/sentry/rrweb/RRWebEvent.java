package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.rrweb.RRWebEventType;
import io.sentry.util.Objects;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class RRWebEvent {

    /* renamed from: a, reason: collision with root package name */
    public RRWebEventType f53030a;

    /* renamed from: b, reason: collision with root package name */
    public long f53031b = System.currentTimeMillis();

    /* loaded from: classes3.dex */
    public static final class Deserializer {
        public static boolean a(RRWebEvent rRWebEvent, String str, ObjectReader objectReader, ILogger iLogger) {
            if (str.equals("type")) {
                RRWebEventType rRWebEventType = (RRWebEventType) objectReader.o0(iLogger, new RRWebEventType.Deserializer());
                Objects.b(rRWebEventType, "");
                rRWebEvent.f53030a = rRWebEventType;
                return true;
            }
            if (!str.equals("timestamp")) {
                return false;
            }
            rRWebEvent.f53031b = objectReader.nextLong();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    /* loaded from: classes3.dex */
    public static final class Serializer {
        public static void a(RRWebEvent rRWebEvent, ObjectWriter objectWriter, ILogger iLogger) {
            objectWriter.d("type").h(iLogger, rRWebEvent.f53030a);
            objectWriter.d("timestamp").a(rRWebEvent.f53031b);
        }
    }

    public RRWebEvent(RRWebEventType rRWebEventType) {
        this.f53030a = rRWebEventType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RRWebEvent)) {
            return false;
        }
        RRWebEvent rRWebEvent = (RRWebEvent) obj;
        return this.f53031b == rRWebEvent.f53031b && this.f53030a == rRWebEvent.f53030a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f53030a, Long.valueOf(this.f53031b)});
    }
}
