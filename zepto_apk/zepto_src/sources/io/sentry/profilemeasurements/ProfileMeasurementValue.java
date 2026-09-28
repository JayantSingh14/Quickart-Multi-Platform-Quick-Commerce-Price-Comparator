package io.sentry.profilemeasurements;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ProfileMeasurementValue implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f52796a;

    /* renamed from: b, reason: collision with root package name */
    public String f52797b;

    /* renamed from: c, reason: collision with root package name */
    public double f52798c;

    public static final class Deserializer implements JsonDeserializer<ProfileMeasurementValue> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            ProfileMeasurementValue profileMeasurementValue = new ProfileMeasurementValue();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("elapsed_since_start_ns")) {
                    String strA1 = objectReader.a1();
                    if (strA1 != null) {
                        profileMeasurementValue.f52797b = strA1;
                    }
                } else if (strX.equals(CLConstants.FIELD_PAY_INFO_VALUE)) {
                    Double dW = objectReader.W();
                    if (dW != null) {
                        profileMeasurementValue.f52798c = dW.doubleValue();
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.I(iLogger, concurrentHashMap, strX);
                }
            }
            profileMeasurementValue.f52796a = concurrentHashMap;
            objectReader.t();
            return profileMeasurementValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public ProfileMeasurementValue() {
        this(0L, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ProfileMeasurementValue.class != obj.getClass()) {
            return false;
        }
        ProfileMeasurementValue profileMeasurementValue = (ProfileMeasurementValue) obj;
        return Objects.a(this.f52796a, profileMeasurementValue.f52796a) && this.f52797b.equals(profileMeasurementValue.f52797b) && this.f52798c == profileMeasurementValue.f52798c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52796a, this.f52797b, Double.valueOf(this.f52798c)});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d(CLConstants.FIELD_PAY_INFO_VALUE).h(iLogger, Double.valueOf(this.f52798c));
        objectWriter.d("elapsed_since_start_ns").h(iLogger, this.f52797b);
        ConcurrentHashMap concurrentHashMap = this.f52796a;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52796a, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public ProfileMeasurementValue(Long l2, Number number) {
        this.f52797b = l2.toString();
        this.f52798c = number.doubleValue();
    }
}
