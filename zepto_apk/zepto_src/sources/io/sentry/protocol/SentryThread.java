package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLockReason;
import io.sentry.a;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class SentryThread implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public Long f52946a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f52947b;

    /* renamed from: c, reason: collision with root package name */
    public String f52948c;

    /* renamed from: d, reason: collision with root package name */
    public String f52949d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f52950e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f52951f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f52952g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f52953h;

    /* renamed from: i, reason: collision with root package name */
    public SentryStackTrace f52954i;

    /* renamed from: j, reason: collision with root package name */
    public Map f52955j;

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap f52956k;

    public static final class Deserializer implements JsonDeserializer<SentryThread> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            SentryThread sentryThread = new SentryThread();
            objectReader.k();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "daemon":
                        sentryThread.f52952g = objectReader.f0();
                        break;
                    case "priority":
                        sentryThread.f52947b = objectReader.M0();
                        break;
                    case "held_locks":
                        HashMap mapD1 = objectReader.d1(iLogger, new SentryLockReason.Deserializer());
                        if (mapD1 == null) {
                            break;
                        } else {
                            sentryThread.f52955j = new HashMap(mapD1);
                            break;
                        }
                    case "id":
                        sentryThread.f52946a = objectReader.R0();
                        break;
                    case "main":
                        sentryThread.f52953h = objectReader.f0();
                        break;
                    case "name":
                        sentryThread.f52948c = objectReader.a1();
                        break;
                    case "state":
                        sentryThread.f52949d = objectReader.a1();
                        break;
                    case "crashed":
                        sentryThread.f52950e = objectReader.f0();
                        break;
                    case "current":
                        sentryThread.f52951f = objectReader.f0();
                        break;
                    case "stacktrace":
                        sentryThread.f52954i = (SentryStackTrace) objectReader.o0(iLogger, new SentryStackTrace.Deserializer());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            sentryThread.f52956k = concurrentHashMap;
            objectReader.t();
            return sentryThread;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52946a != null) {
            objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).f(this.f52946a);
        }
        if (this.f52947b != null) {
            objectWriter.d("priority").f(this.f52947b);
        }
        if (this.f52948c != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52948c);
        }
        if (this.f52949d != null) {
            objectWriter.d("state").e(this.f52949d);
        }
        if (this.f52950e != null) {
            objectWriter.d("crashed").i(this.f52950e);
        }
        if (this.f52951f != null) {
            objectWriter.d("current").i(this.f52951f);
        }
        if (this.f52952g != null) {
            objectWriter.d("daemon").i(this.f52952g);
        }
        if (this.f52953h != null) {
            objectWriter.d("main").i(this.f52953h);
        }
        if (this.f52954i != null) {
            objectWriter.d("stacktrace").h(iLogger, this.f52954i);
        }
        if (this.f52955j != null) {
            objectWriter.d("held_locks").h(iLogger, this.f52955j);
        }
        ConcurrentHashMap concurrentHashMap = this.f52956k;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52956k, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
