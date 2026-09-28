package io.sentry.profilemeasurements;

import com.google.ads.interactivemedia.v3.impl.data.zzck;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.profilemeasurements.ProfileMeasurementValue;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ProfileMeasurement implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f52793a;

    /* renamed from: b, reason: collision with root package name */
    public String f52794b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f52795c;

    public static final class Deserializer implements JsonDeserializer<ProfileMeasurement> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            ProfileMeasurement profileMeasurement = new ProfileMeasurement();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("values")) {
                    ArrayList arrayListI1 = objectReader.I1(iLogger, new ProfileMeasurementValue.Deserializer());
                    if (arrayListI1 != null) {
                        profileMeasurement.f52795c = arrayListI1;
                    }
                } else if (strX.equals("unit")) {
                    String strA1 = objectReader.a1();
                    if (strA1 != null) {
                        profileMeasurement.f52794b = strA1;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.I(iLogger, concurrentHashMap, strX);
                }
            }
            profileMeasurement.f52793a = concurrentHashMap;
            objectReader.t();
            return profileMeasurement;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public ProfileMeasurement() {
        this(zzck.UNKNOWN_CONTENT_TYPE, new ArrayList());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ProfileMeasurement.class != obj.getClass()) {
            return false;
        }
        ProfileMeasurement profileMeasurement = (ProfileMeasurement) obj;
        return Objects.a(this.f52793a, profileMeasurement.f52793a) && this.f52794b.equals(profileMeasurement.f52794b) && new ArrayList(this.f52795c).equals(new ArrayList(profileMeasurement.f52795c));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52793a, this.f52794b, this.f52795c});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("unit").h(iLogger, this.f52794b);
        objectWriter.d("values").h(iLogger, this.f52795c);
        ConcurrentHashMap concurrentHashMap = this.f52793a;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52793a, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public ProfileMeasurement(String str, AbstractCollection abstractCollection) {
        this.f52794b = str;
        this.f52795c = abstractCollection;
    }
}
