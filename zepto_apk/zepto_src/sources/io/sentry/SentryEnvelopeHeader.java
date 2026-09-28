package io.sentry;

import io.sentry.TraceContext;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Date;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryEnvelopeHeader implements JsonSerializable, JsonUnknown {

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51814a;

    /* renamed from: b, reason: collision with root package name */
    public final SdkVersion f51815b;

    /* renamed from: c, reason: collision with root package name */
    public final TraceContext f51816c;

    /* renamed from: d, reason: collision with root package name */
    public Date f51817d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f51818e;

    public static final class Deserializer implements JsonDeserializer<SentryEnvelopeHeader> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryId sentryId = null;
            SdkVersion sdkVersion = null;
            TraceContext traceContext = null;
            Date dateC0 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "sdk":
                        sdkVersion = (SdkVersion) objectReader.o0(iLogger, new SdkVersion.Deserializer());
                        break;
                    case "trace":
                        traceContext = (TraceContext) objectReader.o0(iLogger, new TraceContext.Deserializer());
                        break;
                    case "event_id":
                        sentryId = (SentryId) objectReader.o0(iLogger, new SentryId.Deserializer());
                        break;
                    case "sent_at":
                        dateC0 = objectReader.c0(iLogger);
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            SentryEnvelopeHeader sentryEnvelopeHeader = new SentryEnvelopeHeader(sentryId, sdkVersion, traceContext);
            sentryEnvelopeHeader.f51817d = dateC0;
            sentryEnvelopeHeader.f51818e = map;
            objectReader.t();
            return sentryEnvelopeHeader;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion, TraceContext traceContext) {
        this.f51814a = sentryId;
        this.f51815b = sdkVersion;
        this.f51816c = traceContext;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        SentryId sentryId = this.f51814a;
        if (sentryId != null) {
            objectWriter.d("event_id").h(iLogger, sentryId);
        }
        SdkVersion sdkVersion = this.f51815b;
        if (sdkVersion != null) {
            objectWriter.d("sdk").h(iLogger, sdkVersion);
        }
        TraceContext traceContext = this.f51816c;
        if (traceContext != null) {
            objectWriter.d("trace").h(iLogger, traceContext);
        }
        if (this.f51817d != null) {
            objectWriter.d("sent_at").h(iLogger, DateUtils.e(this.f51817d));
        }
        HashMap map = this.f51818e;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f51818e.get(str);
                objectWriter.d(str);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
    }

    public SentryEnvelopeHeader() {
        this(new SentryId(), null, null);
    }
}
