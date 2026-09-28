package io.sentry;

import com.amazon.apay.hardened.external.model.APayConstants;
import in.juspay.hyperutil.constants.LogLevel;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryLevel;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class SentryEvent extends SentryBaseEvent implements JsonUnknown, JsonSerializable {
    public Date p;
    public Message q;
    public String r;
    public SentryValues s;
    public SentryValues t;
    public SentryLevel u;
    public String v;
    public List w;
    public ConcurrentHashMap x;
    public AbstractMap y;

    public static final class Deserializer implements JsonDeserializer<SentryEvent> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryEvent sentryEvent = new SentryEvent();
            new SentryBaseEvent.Deserializer();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "fingerprint":
                        List list = (List) objectReader.B1();
                        if (list == null) {
                            break;
                        } else {
                            sentryEvent.w = list;
                            break;
                        }
                    case "threads":
                        objectReader.k();
                        objectReader.X();
                        sentryEvent.s = new SentryValues(objectReader.I1(iLogger, new SentryThread.Deserializer()));
                        objectReader.t();
                        break;
                    case "logger":
                        sentryEvent.r = objectReader.a1();
                        break;
                    case "timestamp":
                        Date dateC0 = objectReader.c0(iLogger);
                        if (dateC0 == null) {
                            break;
                        } else {
                            sentryEvent.p = dateC0;
                            break;
                        }
                    case "level":
                        sentryEvent.u = (SentryLevel) objectReader.o0(iLogger, new SentryLevel.Deserializer());
                        break;
                    case "message":
                        sentryEvent.q = (Message) objectReader.o0(iLogger, new Message.Deserializer());
                        break;
                    case "modules":
                        sentryEvent.y = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "exception":
                        objectReader.k();
                        objectReader.X();
                        sentryEvent.t = new SentryValues(objectReader.I1(iLogger, new SentryException.Deserializer()));
                        objectReader.t();
                        break;
                    case "transaction":
                        sentryEvent.v = objectReader.a1();
                        break;
                    default:
                        if (!SentryBaseEvent.Deserializer.a(sentryEvent, strX, objectReader, iLogger)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.I(iLogger, concurrentHashMap, strX);
                            break;
                        } else {
                            break;
                        }
                }
            }
            sentryEvent.x = concurrentHashMap;
            objectReader.t();
            return sentryEvent;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentryEvent(Throwable th) {
        this();
        this.f51800j = th;
    }

    public final ArrayList c() {
        SentryValues sentryValues = this.t;
        if (sentryValues == null) {
            return null;
        }
        return sentryValues.a();
    }

    public final ArrayList d() {
        SentryValues sentryValues = this.s;
        if (sentryValues != null) {
            return sentryValues.a();
        }
        return null;
    }

    public final SentryException e() {
        Boolean bool;
        SentryValues sentryValues = this.t;
        if (sentryValues == null) {
            return null;
        }
        Iterator it = sentryValues.a().iterator();
        while (it.hasNext()) {
            SentryException sentryException = (SentryException) it.next();
            Mechanism mechanism = sentryException.f52905f;
            if (mechanism != null && (bool = mechanism.f52851d) != null && !bool.booleanValue()) {
                return sentryException;
            }
        }
        return null;
    }

    public final boolean f() {
        SentryValues sentryValues = this.t;
        return (sentryValues == null || sentryValues.a().isEmpty()) ? false : true;
    }

    public final void g(ArrayList arrayList) {
        this.t = new SentryValues(arrayList);
    }

    public final void h(ArrayList arrayList) {
        this.s = new SentryValues(arrayList);
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("timestamp").h(iLogger, this.p);
        if (this.q != null) {
            objectWriter.d(APayConstants.Error.MESSAGE).h(iLogger, this.q);
        }
        if (this.r != null) {
            objectWriter.d("logger").e(this.r);
        }
        SentryValues sentryValues = this.s;
        if (sentryValues != null && !sentryValues.a().isEmpty()) {
            objectWriter.d("threads");
            objectWriter.k();
            objectWriter.d("values").h(iLogger, this.s.a());
            objectWriter.t();
        }
        SentryValues sentryValues2 = this.t;
        if (sentryValues2 != null && !sentryValues2.a().isEmpty()) {
            objectWriter.d(LogLevel.EXCEPTION);
            objectWriter.k();
            objectWriter.d("values").h(iLogger, this.t.a());
            objectWriter.t();
        }
        if (this.u != null) {
            objectWriter.d("level").h(iLogger, this.u);
        }
        if (this.v != null) {
            objectWriter.d("transaction").e(this.v);
        }
        if (this.w != null) {
            objectWriter.d("fingerprint").h(iLogger, this.w);
        }
        if (this.y != null) {
            objectWriter.d("modules").h(iLogger, this.y);
        }
        new SentryBaseEvent.Serializer();
        SentryBaseEvent.Serializer.a(this, objectWriter, iLogger);
        ConcurrentHashMap concurrentHashMap = this.x;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.x, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public SentryEvent() {
        SentryId sentryId = new SentryId();
        Date dateA = DateUtils.a();
        super(sentryId);
        this.p = dateA;
    }
}
