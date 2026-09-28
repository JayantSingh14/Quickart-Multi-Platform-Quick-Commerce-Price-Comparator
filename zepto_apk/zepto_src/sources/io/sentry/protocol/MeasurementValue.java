package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class MeasurementValue implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final Number f52845a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52846b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f52847c;

    public static final class Deserializer implements JsonDeserializer<MeasurementValue> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            Number number = null;
            String strA1 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("unit")) {
                    strA1 = objectReader.a1();
                } else if (strX.equals(CLConstants.FIELD_PAY_INFO_VALUE)) {
                    number = (Number) objectReader.B1();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.I(iLogger, concurrentHashMap, strX);
                }
            }
            objectReader.t();
            if (number != null) {
                MeasurementValue measurementValue = new MeasurementValue(number, strA1);
                measurementValue.f52847c = concurrentHashMap;
                return measurementValue;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
            iLogger.b(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException);
            throw illegalStateException;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public MeasurementValue(Number number, String str) {
        this.f52845a = number;
        this.f52846b = str;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d(CLConstants.FIELD_PAY_INFO_VALUE).f(this.f52845a);
        String str = this.f52846b;
        if (str != null) {
            objectWriter.d("unit").e(str);
        }
        ConcurrentHashMap concurrentHashMap = this.f52847c;
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                a.b(this.f52847c, str2, objectWriter, str2, iLogger);
            }
        }
        objectWriter.t();
    }
}
