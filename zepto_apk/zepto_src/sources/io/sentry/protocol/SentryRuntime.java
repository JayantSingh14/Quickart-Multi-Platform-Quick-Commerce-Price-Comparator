package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class SentryRuntime implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52912a;

    /* renamed from: b, reason: collision with root package name */
    public String f52913b;

    /* renamed from: c, reason: collision with root package name */
    public String f52914c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap f52915d;

    public static final class Deserializer implements JsonDeserializer<SentryRuntime> {
        public static SentryRuntime b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryRuntime sentryRuntime = new SentryRuntime();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "raw_description":
                        sentryRuntime.f52914c = objectReader.a1();
                        break;
                    case "name":
                        sentryRuntime.f52912a = objectReader.a1();
                        break;
                    case "version":
                        sentryRuntime.f52913b = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            sentryRuntime.f52915d = concurrentHashMap;
            objectReader.t();
            return sentryRuntime;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52912a != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52912a);
        }
        if (this.f52913b != null) {
            objectWriter.d("version").e(this.f52913b);
        }
        if (this.f52914c != null) {
            objectWriter.d("raw_description").e(this.f52914c);
        }
        ConcurrentHashMap concurrentHashMap = this.f52915d;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52915d, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
