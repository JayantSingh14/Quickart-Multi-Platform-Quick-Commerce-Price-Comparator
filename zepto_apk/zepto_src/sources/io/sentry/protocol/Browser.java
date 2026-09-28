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
public final class Browser implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52811a;

    /* renamed from: b, reason: collision with root package name */
    public String f52812b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f52813c;

    public static final class Deserializer implements JsonDeserializer<Browser> {
        public static Browser b(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            Browser browser = new Browser();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    browser.f52811a = objectReader.a1();
                } else if (strX.equals("version")) {
                    browser.f52812b = objectReader.a1();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.I(iLogger, concurrentHashMap, strX);
                }
            }
            browser.f52813c = concurrentHashMap;
            objectReader.t();
            return browser;
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
        if (obj != null && Browser.class == obj.getClass()) {
            Browser browser = (Browser) obj;
            if (Objects.a(this.f52811a, browser.f52811a) && Objects.a(this.f52812b, browser.f52812b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52811a, this.f52812b});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52811a != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52811a);
        }
        if (this.f52812b != null) {
            objectWriter.d("version").e(this.f52812b);
        }
        ConcurrentHashMap concurrentHashMap = this.f52813c;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52813c, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
