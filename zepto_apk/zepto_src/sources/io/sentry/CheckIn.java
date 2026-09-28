package io.sentry;

import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.MonitorConfig;
import io.sentry.MonitorContexts;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class CheckIn implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51564a;

    /* renamed from: b, reason: collision with root package name */
    public final String f51565b;

    /* renamed from: c, reason: collision with root package name */
    public final String f51566c;

    /* renamed from: d, reason: collision with root package name */
    public Double f51567d;

    /* renamed from: e, reason: collision with root package name */
    public String f51568e;

    /* renamed from: f, reason: collision with root package name */
    public String f51569f;

    /* renamed from: g, reason: collision with root package name */
    public final MonitorContexts f51570g = new MonitorContexts();

    /* renamed from: h, reason: collision with root package name */
    public MonitorConfig f51571h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap f51572i;

    public static final class Deserializer implements JsonDeserializer<CheckIn> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryId sentryIdB = null;
            String strA1 = null;
            String strA12 = null;
            HashMap map = null;
            Double dW = null;
            String strA13 = null;
            String strA14 = null;
            MonitorConfig monitorConfigB = null;
            MonitorContexts monitorContextsB = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "monitor_config":
                        new MonitorConfig.Deserializer();
                        monitorConfigB = MonitorConfig.Deserializer.b(objectReader, iLogger);
                        break;
                    case "duration":
                        dW = objectReader.W();
                        break;
                    case "status":
                        strA12 = objectReader.a1();
                        break;
                    case "contexts":
                        new MonitorContexts.Deserializer();
                        monitorContextsB = MonitorContexts.Deserializer.b(objectReader, iLogger);
                        break;
                    case "environment":
                        strA14 = objectReader.a1();
                        break;
                    case "release":
                        strA13 = objectReader.a1();
                        break;
                    case "check_in_id":
                        new SentryId.Deserializer();
                        sentryIdB = SentryId.Deserializer.b(objectReader);
                        break;
                    case "monitor_slug":
                        strA1 = objectReader.a1();
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
            if (sentryIdB == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"check_in_id\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"check_in_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (strA1 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"monitor_slug\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"monitor_slug\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strA12 == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"status\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"status\"", illegalStateException3);
                throw illegalStateException3;
            }
            CheckIn checkIn = new CheckIn(sentryIdB, strA1, strA12);
            checkIn.f51567d = dW;
            checkIn.f51568e = strA13;
            checkIn.f51569f = strA14;
            checkIn.f51571h = monitorConfigB;
            checkIn.f51570g.putAll(monitorContextsB);
            checkIn.f51572i = map;
            return checkIn;
        }
    }

    public static final class JsonKeys {
    }

    public CheckIn(SentryId sentryId, String str, String str2) {
        this.f51564a = sentryId;
        this.f51565b = str;
        this.f51566c = str2;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("check_in_id");
        this.f51564a.serialize(objectWriter, iLogger);
        objectWriter.d("monitor_slug").e(this.f51565b);
        objectWriter.d(CLConstants.OTP_STATUS).e(this.f51566c);
        if (this.f51567d != null) {
            objectWriter.d("duration").f(this.f51567d);
        }
        if (this.f51568e != null) {
            objectWriter.d("release").e(this.f51568e);
        }
        if (this.f51569f != null) {
            objectWriter.d(PaymentConstants.ENV).e(this.f51569f);
        }
        if (this.f51571h != null) {
            objectWriter.d("monitor_config");
            this.f51571h.serialize(objectWriter, iLogger);
        }
        MonitorContexts monitorContexts = this.f51570g;
        if (monitorContexts != null) {
            objectWriter.d("contexts");
            monitorContexts.serialize(objectWriter, iLogger);
        }
        HashMap map = this.f51572i;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f51572i.get(str));
            }
        }
        objectWriter.t();
    }
}
