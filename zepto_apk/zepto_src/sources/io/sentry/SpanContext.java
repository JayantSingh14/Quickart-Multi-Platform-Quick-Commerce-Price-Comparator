package io.sentry;

import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.protocol.SentryId;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class SpanContext implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51921a;

    /* renamed from: b, reason: collision with root package name */
    public final SpanId f51922b;

    /* renamed from: c, reason: collision with root package name */
    public final SpanId f51923c;

    /* renamed from: d, reason: collision with root package name */
    public transient TracesSamplingDecision f51924d;

    /* renamed from: e, reason: collision with root package name */
    public final String f51925e;

    /* renamed from: f, reason: collision with root package name */
    public String f51926f;

    /* renamed from: g, reason: collision with root package name */
    public SpanStatus f51927g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap f51928h;

    /* renamed from: i, reason: collision with root package name */
    public String f51929i;

    /* renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap f51930j;

    public static final class Deserializer implements JsonDeserializer<SpanContext> {
        public static SpanContext b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            String strK0 = null;
            SentryId sentryIdB = null;
            SpanId spanId = null;
            SpanId spanId2 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strK02 = null;
            SpanStatus spanStatus = null;
            String strK03 = null;
            ConcurrentHashMap concurrentHashMapC = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "span_id":
                        new SpanId.Deserializer();
                        spanId = new SpanId(objectReader.K0());
                        break;
                    case "parent_span_id":
                        spanId2 = (SpanId) objectReader.o0(iLogger, new SpanId.Deserializer());
                        break;
                    case "description":
                        strK02 = objectReader.K0();
                        break;
                    case "origin":
                        strK03 = objectReader.K0();
                        break;
                    case "status":
                        spanStatus = (SpanStatus) objectReader.o0(iLogger, new SpanStatus.Deserializer());
                        break;
                    case "op":
                        strK0 = objectReader.K0();
                        break;
                    case "tags":
                        concurrentHashMapC = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "trace_id":
                        new SentryId.Deserializer();
                        sentryIdB = SentryId.Deserializer.b(objectReader);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            if (sentryIdB == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (spanId == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"span_id\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strK0 == null) {
                strK0 = "";
            }
            SpanContext spanContext = new SpanContext(sentryIdB, spanId, strK0, spanId2, null);
            spanContext.f51926f = strK02;
            spanContext.f51927g = spanStatus;
            spanContext.f51929i = strK03;
            if (concurrentHashMapC != null) {
                spanContext.f51928h = concurrentHashMapC;
            }
            spanContext.f51930j = concurrentHashMap;
            objectReader.t();
            return spanContext;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SpanContext(SentryId sentryId, SpanId spanId, String str, SpanId spanId2, TracesSamplingDecision tracesSamplingDecision) {
        this(sentryId, spanId, spanId2, str, null, tracesSamplingDecision, null, "manual");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanContext)) {
            return false;
        }
        SpanContext spanContext = (SpanContext) obj;
        return this.f51921a.equals(spanContext.f51921a) && this.f51922b.equals(spanContext.f51922b) && Objects.a(this.f51923c, spanContext.f51923c) && this.f51925e.equals(spanContext.f51925e) && Objects.a(this.f51926f, spanContext.f51926f) && this.f51927g == spanContext.f51927g;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f51921a, this.f51922b, this.f51923c, this.f51925e, this.f51926f, this.f51927g});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("trace_id");
        this.f51921a.serialize(objectWriter, iLogger);
        objectWriter.d("span_id");
        objectWriter.e(this.f51922b.f51932a);
        SpanId spanId = this.f51923c;
        if (spanId != null) {
            objectWriter.d("parent_span_id");
            objectWriter.e(spanId.f51932a);
        }
        objectWriter.d("op").e(this.f51925e);
        if (this.f51926f != null) {
            objectWriter.d("description").e(this.f51926f);
        }
        if (this.f51927g != null) {
            objectWriter.d(CLConstants.OTP_STATUS).h(iLogger, this.f51927g);
        }
        if (this.f51929i != null) {
            objectWriter.d("origin").h(iLogger, this.f51929i);
        }
        if (!this.f51928h.isEmpty()) {
            objectWriter.d("tags").h(iLogger, this.f51928h);
        }
        ConcurrentHashMap concurrentHashMap = this.f51930j;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                objectWriter.d(str).h(iLogger, this.f51930j.get(str));
            }
        }
        objectWriter.t();
    }

    public SpanContext(SentryId sentryId, SpanId spanId, SpanId spanId2, String str, String str2, TracesSamplingDecision tracesSamplingDecision, SpanStatus spanStatus, String str3) {
        this.f51928h = new ConcurrentHashMap();
        this.f51929i = "manual";
        Objects.b(sentryId, "traceId is required");
        this.f51921a = sentryId;
        Objects.b(spanId, "spanId is required");
        this.f51922b = spanId;
        Objects.b(str, "operation is required");
        this.f51925e = str;
        this.f51923c = spanId2;
        this.f51924d = tracesSamplingDecision;
        this.f51926f = str2;
        this.f51927g = spanStatus;
        this.f51929i = str3;
    }

    public SpanContext(SpanContext spanContext) {
        this.f51928h = new ConcurrentHashMap();
        this.f51929i = "manual";
        this.f51921a = spanContext.f51921a;
        this.f51922b = spanContext.f51922b;
        this.f51923c = spanContext.f51923c;
        this.f51924d = spanContext.f51924d;
        this.f51925e = spanContext.f51925e;
        this.f51926f = spanContext.f51926f;
        this.f51927g = spanContext.f51927g;
        ConcurrentHashMap concurrentHashMapC = CollectionUtils.c(spanContext.f51928h);
        if (concurrentHashMapC != null) {
            this.f51928h = concurrentHashMapC;
        }
    }
}
