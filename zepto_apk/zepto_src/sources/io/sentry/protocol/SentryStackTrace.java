package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class SentryStackTrace implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public List f52942a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f52943b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f52944c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f52945d;

    public static final class Deserializer implements JsonDeserializer<SentryStackTrace> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            SentryStackTrace sentryStackTrace = new SentryStackTrace();
            objectReader.k();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "frames":
                        sentryStackTrace.f52942a = objectReader.I1(iLogger, new SentryStackFrame.Deserializer());
                        break;
                    case "registers":
                        sentryStackTrace.f52943b = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "snapshot":
                        sentryStackTrace.f52944c = objectReader.f0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            sentryStackTrace.f52945d = concurrentHashMap;
            objectReader.t();
            return sentryStackTrace;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentryStackTrace() {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52942a != null) {
            objectWriter.d("frames").h(iLogger, this.f52942a);
        }
        if (this.f52943b != null) {
            objectWriter.d("registers").h(iLogger, this.f52943b);
        }
        if (this.f52944c != null) {
            objectWriter.d("snapshot").i(this.f52944c);
        }
        ConcurrentHashMap concurrentHashMap = this.f52945d;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52945d, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public SentryStackTrace(List list) {
        this.f52942a = list;
    }
}
