package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class SdkInfo implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52890a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f52891b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f52892c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f52893d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f52894e;

    public static final class Deserializer implements JsonDeserializer<SdkInfo> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            SdkInfo sdkInfo = new SdkInfo();
            objectReader.k();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "sdk_name":
                        sdkInfo.f52890a = objectReader.a1();
                        break;
                    case "version_patchlevel":
                        sdkInfo.f52893d = objectReader.M0();
                        break;
                    case "version_major":
                        sdkInfo.f52891b = objectReader.M0();
                        break;
                    case "version_minor":
                        sdkInfo.f52892c = objectReader.M0();
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
            sdkInfo.f52894e = map;
            return sdkInfo;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52890a != null) {
            objectWriter.d("sdk_name").e(this.f52890a);
        }
        if (this.f52891b != null) {
            objectWriter.d("version_major").f(this.f52891b);
        }
        if (this.f52892c != null) {
            objectWriter.d("version_minor").f(this.f52892c);
        }
        if (this.f52893d != null) {
            objectWriter.d("version_patchlevel").f(this.f52893d);
        }
        HashMap map = this.f52894e;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52894e.get(str));
            }
        }
        objectWriter.t();
    }
}
