package io.sentry;

import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class TraceContext implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51944a;

    /* renamed from: b, reason: collision with root package name */
    public final String f51945b;

    /* renamed from: c, reason: collision with root package name */
    public final String f51946c;

    /* renamed from: d, reason: collision with root package name */
    public final String f51947d;

    /* renamed from: e, reason: collision with root package name */
    public final String f51948e;

    /* renamed from: f, reason: collision with root package name */
    public final String f51949f;

    /* renamed from: g, reason: collision with root package name */
    public final String f51950g;

    /* renamed from: h, reason: collision with root package name */
    public final String f51951h;

    /* renamed from: i, reason: collision with root package name */
    public final String f51952i;

    /* renamed from: j, reason: collision with root package name */
    public final SentryId f51953j;

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap f51954k;

    public static final class Deserializer implements JsonDeserializer<TraceContext> {
        public static IllegalStateException b(String str, ILogger iLogger) {
            String strD = android.support.v4.media.b.D("Missing required field \"", str, "\"");
            IllegalStateException illegalStateException = new IllegalStateException(strD);
            iLogger.b(SentryLevel.ERROR, strD, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
        @Override // io.sentry.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(io.sentry.ObjectReader r20, io.sentry.ILogger r21) {
            /*
                Method dump skipped, instructions count: 394
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.TraceContext.Deserializer.a(io.sentry.ObjectReader, io.sentry.ILogger):java.lang.Object");
        }
    }

    public static final class JsonKeys {
    }

    @Deprecated
    public static final class TraceContextUser implements JsonUnknown {

        /* renamed from: a, reason: collision with root package name */
        public String f51955a;

        /* renamed from: b, reason: collision with root package name */
        public String f51956b;

        public static final class Deserializer implements JsonDeserializer<TraceContextUser> {
            @Override // io.sentry.JsonDeserializer
            public final Object a(ObjectReader objectReader, ILogger iLogger) {
                objectReader.k();
                String strA1 = null;
                String strA12 = null;
                ConcurrentHashMap concurrentHashMap = null;
                while (objectReader.peek() == JsonToken.NAME) {
                    String strX = objectReader.X();
                    strX.getClass();
                    if (strX.equals(CLConstants.SHARED_PREFERENCE_ITEM_ID)) {
                        strA1 = objectReader.a1();
                    } else if (strX.equals("segment")) {
                        strA12 = objectReader.a1();
                    } else {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                    }
                }
                TraceContextUser traceContextUser = new TraceContextUser();
                traceContextUser.f51955a = strA1;
                traceContextUser.f51956b = strA12;
                objectReader.t();
                return traceContextUser;
            }
        }

        public static final class JsonKeys {
        }
    }

    public TraceContext(SentryId sentryId) {
        this(sentryId, "", null, null, null, null, null, null, null, null);
    }

    public final String a() {
        return this.f51951h;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("trace_id").h(iLogger, this.f51944a);
        objectWriter.d("public_key").e(this.f51945b);
        String str = this.f51946c;
        if (str != null) {
            objectWriter.d("release").e(str);
        }
        String str2 = this.f51947d;
        if (str2 != null) {
            objectWriter.d(PaymentConstants.ENV).e(str2);
        }
        String str3 = this.f51948e;
        if (str3 != null) {
            objectWriter.d("user_id").e(str3);
        }
        String str4 = this.f51949f;
        if (str4 != null) {
            objectWriter.d("user_segment").e(str4);
        }
        String str5 = this.f51950g;
        if (str5 != null) {
            objectWriter.d("transaction").e(str5);
        }
        String str6 = this.f51951h;
        if (str6 != null) {
            objectWriter.d("sample_rate").e(str6);
        }
        String str7 = this.f51952i;
        if (str7 != null) {
            objectWriter.d("sampled").e(str7);
        }
        SentryId sentryId = this.f51953j;
        if (sentryId != null) {
            objectWriter.d("replay_id").h(iLogger, sentryId);
        }
        ConcurrentHashMap concurrentHashMap = this.f51954k;
        if (concurrentHashMap != null) {
            for (String str8 : concurrentHashMap.keySet()) {
                a.b(this.f51954k, str8, objectWriter, str8, iLogger);
            }
        }
        objectWriter.t();
    }

    public TraceContext(SentryId sentryId, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, SentryId sentryId2) {
        this.f51944a = sentryId;
        this.f51945b = str;
        this.f51946c = str2;
        this.f51947d = str3;
        this.f51948e = str4;
        this.f51949f = str5;
        this.f51950g = str6;
        this.f51951h = str7;
        this.f51952i = str8;
        this.f51953j = sentryId2;
    }
}
