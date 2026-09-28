package io.sentry.protocol;

import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SpanContext;
import io.sentry.protocol.App;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Device;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.Response;
import io.sentry.protocol.SentryRuntime;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class Contexts extends ConcurrentHashMap<String, Object> implements JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f52814a = new Object();

    public static final class Deserializer implements JsonDeserializer<Contexts> {
        public static Contexts b(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            Contexts contexts = new Contexts();
            objectReader.k();
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "device":
                        new Device.Deserializer();
                        contexts.put(LogSubCategory.Context.DEVICE, Device.Deserializer.b(objectReader, iLogger));
                        break;
                    case "response":
                        new Response.Deserializer();
                        Response responseB = Response.Deserializer.b(objectReader, iLogger);
                        synchronized (contexts.f52814a) {
                            contexts.put("response", responseB);
                        }
                        break;
                    case "os":
                        new OperatingSystem.Deserializer();
                        contexts.put("os", OperatingSystem.Deserializer.b(objectReader, iLogger));
                        break;
                    case "app":
                        new App.Deserializer();
                        contexts.b(App.Deserializer.b(objectReader, iLogger));
                        break;
                    case "gpu":
                        new Gpu.Deserializer();
                        contexts.put("gpu", Gpu.Deserializer.b(objectReader, iLogger));
                        break;
                    case "trace":
                        new SpanContext.Deserializer();
                        contexts.c(SpanContext.Deserializer.b(objectReader, iLogger));
                        break;
                    case "browser":
                        new Browser.Deserializer();
                        contexts.put("browser", Browser.Deserializer.b(objectReader, iLogger));
                        break;
                    case "runtime":
                        new SentryRuntime.Deserializer();
                        contexts.put("runtime", SentryRuntime.Deserializer.b(objectReader, iLogger));
                        break;
                    default:
                        Object objB1 = objectReader.B1();
                        if (objB1 == null) {
                            break;
                        } else {
                            contexts.put(strX, objB1);
                            break;
                        }
                }
            }
            objectReader.t();
            return contexts;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    public Contexts() {
    }

    public final SpanContext a() {
        return (SpanContext) d(SpanContext.class, "trace");
    }

    public final void b(App app2) {
        put(Constants.APP_DIR, app2);
    }

    public final void c(SpanContext spanContext) {
        Objects.b(spanContext, "traceContext is required");
        put("trace", spanContext);
    }

    public final Object d(Class cls, String str) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                objectWriter.d(str).h(iLogger, obj);
            }
        }
        objectWriter.t();
    }

    public Contexts(Contexts contexts) {
        for (Map.Entry<String, Object> entry : contexts.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if (Constants.APP_DIR.equals(entry.getKey()) && (value instanceof App)) {
                    App app2 = (App) value;
                    App app3 = new App();
                    app3.f52805g = app2.f52805g;
                    app3.f52799a = app2.f52799a;
                    app3.f52803e = app2.f52803e;
                    app3.f52800b = app2.f52800b;
                    app3.f52804f = app2.f52804f;
                    app3.f52802d = app2.f52802d;
                    app3.f52801c = app2.f52801c;
                    app3.f52806h = CollectionUtils.c(app2.f52806h);
                    app3.f52809k = app2.f52809k;
                    app3.f52807i = CollectionUtils.b(app2.f52807i);
                    app3.f52808j = app2.f52808j;
                    app3.f52810l = CollectionUtils.c(app2.f52810l);
                    b(app3);
                } else if ("browser".equals(entry.getKey()) && (value instanceof Browser)) {
                    Browser browser = (Browser) value;
                    Browser browser2 = new Browser();
                    browser2.f52811a = browser.f52811a;
                    browser2.f52812b = browser.f52812b;
                    browser2.f52813c = CollectionUtils.c(browser.f52813c);
                    put("browser", browser2);
                } else if (LogSubCategory.Context.DEVICE.equals(entry.getKey()) && (value instanceof Device)) {
                    Device device = (Device) value;
                    Device device2 = new Device();
                    device2.f52818a = device.f52818a;
                    device2.f52819b = device.f52819b;
                    device2.f52820c = device.f52820c;
                    device2.f52821d = device.f52821d;
                    device2.f52822e = device.f52822e;
                    device2.f52823f = device.f52823f;
                    device2.f52826i = device.f52826i;
                    device2.f52827j = device.f52827j;
                    device2.f52828k = device.f52828k;
                    device2.f52829l = device.f52829l;
                    device2.f52830m = device.f52830m;
                    device2.n = device.n;
                    device2.o = device.o;
                    device2.p = device.p;
                    device2.q = device.q;
                    device2.r = device.r;
                    device2.s = device.s;
                    device2.t = device.t;
                    device2.u = device.u;
                    device2.v = device.v;
                    device2.w = device.w;
                    device2.x = device.x;
                    device2.y = device.y;
                    device2.A = device.A;
                    device2.B = device.B;
                    device2.D = device.D;
                    device2.E = device.E;
                    device2.f52825h = device.f52825h;
                    String[] strArr = device.f52824g;
                    device2.f52824g = strArr != null ? (String[]) strArr.clone() : null;
                    device2.C = device.C;
                    TimeZone timeZone = device.z;
                    device2.z = timeZone != null ? (TimeZone) timeZone.clone() : null;
                    device2.F = device.F;
                    device2.G = device.G;
                    device2.H = device.H;
                    device2.I = CollectionUtils.c(device.I);
                    put(LogSubCategory.Context.DEVICE, device2);
                } else if ("os".equals(entry.getKey()) && (value instanceof OperatingSystem)) {
                    OperatingSystem operatingSystem = (OperatingSystem) value;
                    OperatingSystem operatingSystem2 = new OperatingSystem();
                    operatingSystem2.f52865a = operatingSystem.f52865a;
                    operatingSystem2.f52866b = operatingSystem.f52866b;
                    operatingSystem2.f52867c = operatingSystem.f52867c;
                    operatingSystem2.f52868d = operatingSystem.f52868d;
                    operatingSystem2.f52869e = operatingSystem.f52869e;
                    operatingSystem2.f52870f = operatingSystem.f52870f;
                    operatingSystem2.f52871g = CollectionUtils.c(operatingSystem.f52871g);
                    put("os", operatingSystem2);
                } else if ("runtime".equals(entry.getKey()) && (value instanceof SentryRuntime)) {
                    SentryRuntime sentryRuntime = (SentryRuntime) value;
                    SentryRuntime sentryRuntime2 = new SentryRuntime();
                    sentryRuntime2.f52912a = sentryRuntime.f52912a;
                    sentryRuntime2.f52913b = sentryRuntime.f52913b;
                    sentryRuntime2.f52914c = sentryRuntime.f52914c;
                    sentryRuntime2.f52915d = CollectionUtils.c(sentryRuntime.f52915d);
                    put("runtime", sentryRuntime2);
                } else if ("gpu".equals(entry.getKey()) && (value instanceof Gpu)) {
                    Gpu gpu = (Gpu) value;
                    Gpu gpu2 = new Gpu();
                    gpu2.f52835a = gpu.f52835a;
                    gpu2.f52836b = gpu.f52836b;
                    gpu2.f52837c = gpu.f52837c;
                    gpu2.f52838d = gpu.f52838d;
                    gpu2.f52839e = gpu.f52839e;
                    gpu2.f52840f = gpu.f52840f;
                    gpu2.f52841g = gpu.f52841g;
                    gpu2.f52842h = gpu.f52842h;
                    gpu2.f52843i = gpu.f52843i;
                    gpu2.f52844j = CollectionUtils.c(gpu.f52844j);
                    put("gpu", gpu2);
                } else if ("trace".equals(entry.getKey()) && (value instanceof SpanContext)) {
                    c(new SpanContext((SpanContext) value));
                } else if ("response".equals(entry.getKey()) && (value instanceof Response)) {
                    Response response = new Response((Response) value);
                    synchronized (this.f52814a) {
                        put("response", response);
                    }
                } else {
                    put(entry.getKey(), value);
                }
            }
        }
    }
}
