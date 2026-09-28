package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class SentryException implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52900a;

    /* renamed from: b, reason: collision with root package name */
    public String f52901b;

    /* renamed from: c, reason: collision with root package name */
    public String f52902c;

    /* renamed from: d, reason: collision with root package name */
    public Long f52903d;

    /* renamed from: e, reason: collision with root package name */
    public SentryStackTrace f52904e;

    /* renamed from: f, reason: collision with root package name */
    public Mechanism f52905f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f52906g;

    public static final class Deserializer implements JsonDeserializer<SentryException> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            SentryException sentryException = new SentryException();
            objectReader.k();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "thread_id":
                        sentryException.f52903d = objectReader.R0();
                        break;
                    case "module":
                        sentryException.f52902c = objectReader.a1();
                        break;
                    case "type":
                        sentryException.f52900a = objectReader.a1();
                        break;
                    case "value":
                        sentryException.f52901b = objectReader.a1();
                        break;
                    case "mechanism":
                        sentryException.f52905f = (Mechanism) objectReader.o0(iLogger, new Mechanism.Deserializer());
                        break;
                    case "stacktrace":
                        sentryException.f52904e = (SentryStackTrace) objectReader.o0(iLogger, new SentryStackTrace.Deserializer());
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
            sentryException.f52906g = map;
            return sentryException;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52900a != null) {
            objectWriter.d("type").e(this.f52900a);
        }
        if (this.f52901b != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_VALUE).e(this.f52901b);
        }
        if (this.f52902c != null) {
            objectWriter.d("module").e(this.f52902c);
        }
        if (this.f52903d != null) {
            objectWriter.d("thread_id").f(this.f52903d);
        }
        if (this.f52904e != null) {
            objectWriter.d("stacktrace").h(iLogger, this.f52904e);
        }
        if (this.f52905f != null) {
            objectWriter.d("mechanism").h(iLogger, this.f52905f);
        }
        HashMap map = this.f52906g;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52906g.get(str));
            }
        }
        objectWriter.t();
    }
}
