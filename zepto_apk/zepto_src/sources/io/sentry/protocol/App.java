package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class App implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52799a;

    /* renamed from: b, reason: collision with root package name */
    public Date f52800b;

    /* renamed from: c, reason: collision with root package name */
    public String f52801c;

    /* renamed from: d, reason: collision with root package name */
    public String f52802d;

    /* renamed from: e, reason: collision with root package name */
    public String f52803e;

    /* renamed from: f, reason: collision with root package name */
    public String f52804f;

    /* renamed from: g, reason: collision with root package name */
    public String f52805g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractMap f52806h;

    /* renamed from: i, reason: collision with root package name */
    public List f52807i;

    /* renamed from: j, reason: collision with root package name */
    public String f52808j;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f52809k;

    /* renamed from: l, reason: collision with root package name */
    public ConcurrentHashMap f52810l;

    public static final class Deserializer implements JsonDeserializer<App> {
        public static App b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            App app2 = new App();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "device_app_hash":
                        app2.f52801c = objectReader.a1();
                        break;
                    case "start_type":
                        app2.f52808j = objectReader.a1();
                        break;
                    case "view_names":
                        List list = (List) objectReader.B1();
                        if (list == null) {
                            break;
                        } else {
                            app2.f52807i = list;
                            break;
                        }
                    case "app_version":
                        app2.f52804f = objectReader.a1();
                        break;
                    case "in_foreground":
                        app2.f52809k = objectReader.f0();
                        break;
                    case "build_type":
                        app2.f52802d = objectReader.a1();
                        break;
                    case "app_identifier":
                        app2.f52799a = objectReader.a1();
                        break;
                    case "app_start_time":
                        app2.f52800b = objectReader.c0(iLogger);
                        break;
                    case "permissions":
                        app2.f52806h = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "app_name":
                        app2.f52803e = objectReader.a1();
                        break;
                    case "app_build":
                        app2.f52805g = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            app2.f52810l = concurrentHashMap;
            objectReader.t();
            return app2;
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
        if (obj == null || App.class != obj.getClass()) {
            return false;
        }
        App app2 = (App) obj;
        return Objects.a(this.f52799a, app2.f52799a) && Objects.a(this.f52800b, app2.f52800b) && Objects.a(this.f52801c, app2.f52801c) && Objects.a(this.f52802d, app2.f52802d) && Objects.a(this.f52803e, app2.f52803e) && Objects.a(this.f52804f, app2.f52804f) && Objects.a(this.f52805g, app2.f52805g) && Objects.a(this.f52806h, app2.f52806h) && Objects.a(this.f52809k, app2.f52809k) && Objects.a(this.f52807i, app2.f52807i) && Objects.a(this.f52808j, app2.f52808j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52799a, this.f52800b, this.f52801c, this.f52802d, this.f52803e, this.f52804f, this.f52805g, this.f52806h, this.f52809k, this.f52807i, this.f52808j});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52799a != null) {
            objectWriter.d("app_identifier").e(this.f52799a);
        }
        if (this.f52800b != null) {
            objectWriter.d("app_start_time").h(iLogger, this.f52800b);
        }
        if (this.f52801c != null) {
            objectWriter.d("device_app_hash").e(this.f52801c);
        }
        if (this.f52802d != null) {
            objectWriter.d("build_type").e(this.f52802d);
        }
        if (this.f52803e != null) {
            objectWriter.d("app_name").e(this.f52803e);
        }
        if (this.f52804f != null) {
            objectWriter.d("app_version").e(this.f52804f);
        }
        if (this.f52805g != null) {
            objectWriter.d("app_build").e(this.f52805g);
        }
        AbstractMap abstractMap = this.f52806h;
        if (abstractMap != null && !abstractMap.isEmpty()) {
            objectWriter.d("permissions").h(iLogger, this.f52806h);
        }
        if (this.f52809k != null) {
            objectWriter.d("in_foreground").i(this.f52809k);
        }
        if (this.f52807i != null) {
            objectWriter.d("view_names").h(iLogger, this.f52807i);
        }
        if (this.f52808j != null) {
            objectWriter.d("start_type").e(this.f52808j);
        }
        ConcurrentHashMap concurrentHashMap = this.f52810l;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52810l.get(str));
            }
        }
        objectWriter.t();
    }
}
