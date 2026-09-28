package io.sentry.protocol;

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
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class OperatingSystem implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52865a;

    /* renamed from: b, reason: collision with root package name */
    public String f52866b;

    /* renamed from: c, reason: collision with root package name */
    public String f52867c;

    /* renamed from: d, reason: collision with root package name */
    public String f52868d;

    /* renamed from: e, reason: collision with root package name */
    public String f52869e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f52870f;

    /* renamed from: g, reason: collision with root package name */
    public ConcurrentHashMap f52871g;

    public static final class Deserializer implements JsonDeserializer<OperatingSystem> {
        public static OperatingSystem b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            OperatingSystem operatingSystem = new OperatingSystem();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "rooted":
                        operatingSystem.f52870f = objectReader.f0();
                        break;
                    case "raw_description":
                        operatingSystem.f52867c = objectReader.a1();
                        break;
                    case "name":
                        operatingSystem.f52865a = objectReader.a1();
                        break;
                    case "build":
                        operatingSystem.f52868d = objectReader.a1();
                        break;
                    case "version":
                        operatingSystem.f52866b = objectReader.a1();
                        break;
                    case "kernel_version":
                        operatingSystem.f52869e = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            operatingSystem.f52871g = concurrentHashMap;
            objectReader.t();
            return operatingSystem;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && OperatingSystem.class == obj.getClass()) {
            OperatingSystem operatingSystem = (OperatingSystem) obj;
            if (Objects.a(this.f52865a, operatingSystem.f52865a) && Objects.a(this.f52866b, operatingSystem.f52866b) && Objects.a(this.f52867c, operatingSystem.f52867c) && Objects.a(this.f52868d, operatingSystem.f52868d) && Objects.a(this.f52869e, operatingSystem.f52869e) && Objects.a(this.f52870f, operatingSystem.f52870f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52865a, this.f52866b, this.f52867c, this.f52868d, this.f52869e, this.f52870f});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52865a != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52865a);
        }
        if (this.f52866b != null) {
            objectWriter.d("version").e(this.f52866b);
        }
        if (this.f52867c != null) {
            objectWriter.d("raw_description").e(this.f52867c);
        }
        if (this.f52868d != null) {
            objectWriter.d("build").e(this.f52868d);
        }
        if (this.f52869e != null) {
            objectWriter.d("kernel_version").e(this.f52869e);
        }
        if (this.f52870f != null) {
            objectWriter.d("rooted").i(this.f52870f);
        }
        ConcurrentHashMap concurrentHashMap = this.f52871g;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52871g, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
