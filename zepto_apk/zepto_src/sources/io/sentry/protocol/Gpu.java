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
public final class Gpu implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52835a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f52836b;

    /* renamed from: c, reason: collision with root package name */
    public String f52837c;

    /* renamed from: d, reason: collision with root package name */
    public String f52838d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f52839e;

    /* renamed from: f, reason: collision with root package name */
    public String f52840f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f52841g;

    /* renamed from: h, reason: collision with root package name */
    public String f52842h;

    /* renamed from: i, reason: collision with root package name */
    public String f52843i;

    /* renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap f52844j;

    public static final class Deserializer implements JsonDeserializer<Gpu> {
        public static Gpu b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            Gpu gpu = new Gpu();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "npot_support":
                        gpu.f52843i = objectReader.a1();
                        break;
                    case "vendor_id":
                        gpu.f52837c = objectReader.a1();
                        break;
                    case "multi_threaded_rendering":
                        gpu.f52841g = objectReader.f0();
                        break;
                    case "id":
                        gpu.f52836b = objectReader.M0();
                        break;
                    case "name":
                        gpu.f52835a = objectReader.a1();
                        break;
                    case "vendor_name":
                        gpu.f52838d = objectReader.a1();
                        break;
                    case "version":
                        gpu.f52842h = objectReader.a1();
                        break;
                    case "api_type":
                        gpu.f52840f = objectReader.a1();
                        break;
                    case "memory_size":
                        gpu.f52839e = objectReader.M0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            gpu.f52844j = concurrentHashMap;
            objectReader.t();
            return gpu;
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
        if (obj != null && Gpu.class == obj.getClass()) {
            Gpu gpu = (Gpu) obj;
            if (Objects.a(this.f52835a, gpu.f52835a) && Objects.a(this.f52836b, gpu.f52836b) && Objects.a(this.f52837c, gpu.f52837c) && Objects.a(this.f52838d, gpu.f52838d) && Objects.a(this.f52839e, gpu.f52839e) && Objects.a(this.f52840f, gpu.f52840f) && Objects.a(this.f52841g, gpu.f52841g) && Objects.a(this.f52842h, gpu.f52842h) && Objects.a(this.f52843i, gpu.f52843i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52835a, this.f52836b, this.f52837c, this.f52838d, this.f52839e, this.f52840f, this.f52841g, this.f52842h, this.f52843i});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52835a != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52835a);
        }
        if (this.f52836b != null) {
            objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).f(this.f52836b);
        }
        if (this.f52837c != null) {
            objectWriter.d("vendor_id").e(this.f52837c);
        }
        if (this.f52838d != null) {
            objectWriter.d("vendor_name").e(this.f52838d);
        }
        if (this.f52839e != null) {
            objectWriter.d("memory_size").f(this.f52839e);
        }
        if (this.f52840f != null) {
            objectWriter.d("api_type").e(this.f52840f);
        }
        if (this.f52841g != null) {
            objectWriter.d("multi_threaded_rendering").i(this.f52841g);
        }
        if (this.f52842h != null) {
            objectWriter.d("version").e(this.f52842h);
        }
        if (this.f52843i != null) {
            objectWriter.d("npot_support").e(this.f52843i);
        }
        ConcurrentHashMap concurrentHashMap = this.f52844j;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52844j, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
