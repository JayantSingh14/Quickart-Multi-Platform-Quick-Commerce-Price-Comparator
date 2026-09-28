package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class SentryPackage implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f52909a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52910b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f52911c;

    public static final class Deserializer implements JsonDeserializer<SentryPackage> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            String strK0 = null;
            String strK02 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    strK0 = objectReader.K0();
                } else if (strX.equals("version")) {
                    strK02 = objectReader.K0();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            objectReader.t();
            if (strK0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strK02 != null) {
                SentryPackage sentryPackage = new SentryPackage(strK0, strK02);
                sentryPackage.f52911c = map;
                return sentryPackage;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
            iLogger.b(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
            throw illegalStateException2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentryPackage(String str, String str2) {
        Objects.b(str, "name is required.");
        this.f52909a = str;
        Objects.b(str2, "version is required.");
        this.f52910b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SentryPackage.class == obj.getClass()) {
            SentryPackage sentryPackage = (SentryPackage) obj;
            if (java.util.Objects.equals(this.f52909a, sentryPackage.f52909a) && java.util.Objects.equals(this.f52910b, sentryPackage.f52910b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return java.util.Objects.hash(this.f52909a, this.f52910b);
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52909a);
        objectWriter.d("version").e(this.f52910b);
        HashMap map = this.f52911c;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52911c.get(str));
            }
        }
        objectWriter.t();
    }
}
