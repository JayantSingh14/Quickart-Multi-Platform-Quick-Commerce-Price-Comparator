package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class Device implements JsonUnknown, JsonSerializable {
    public String A;
    public String B;
    public String C;
    public String D;
    public Float E;
    public Integer F;
    public Double G;
    public String H;
    public ConcurrentHashMap I;

    /* renamed from: a, reason: collision with root package name */
    public String f52818a;

    /* renamed from: b, reason: collision with root package name */
    public String f52819b;

    /* renamed from: c, reason: collision with root package name */
    public String f52820c;

    /* renamed from: d, reason: collision with root package name */
    public String f52821d;

    /* renamed from: e, reason: collision with root package name */
    public String f52822e;

    /* renamed from: f, reason: collision with root package name */
    public String f52823f;

    /* renamed from: g, reason: collision with root package name */
    public String[] f52824g;

    /* renamed from: h, reason: collision with root package name */
    public Float f52825h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f52826i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f52827j;

    /* renamed from: k, reason: collision with root package name */
    public DeviceOrientation f52828k;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f52829l;

    /* renamed from: m, reason: collision with root package name */
    public Long f52830m;
    public Long n;
    public Long o;
    public Boolean p;
    public Long q;
    public Long r;
    public Long s;
    public Long t;
    public Integer u;
    public Integer v;
    public Float w;
    public Integer x;
    public Date y;
    public TimeZone z;

    public static final class Deserializer implements JsonDeserializer<Device> {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static Device b(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            Device device = new Device();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                char c2 = 65535;
                switch (strX.hashCode()) {
                    case -2076227591:
                        if (strX.equals("timezone")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -2012489734:
                        if (strX.equals("boot_time")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1981332476:
                        if (strX.equals("simulator")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1969347631:
                        if (strX.equals("manufacturer")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1613589672:
                        if (strX.equals("language")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1608004830:
                        if (strX.equals("processor_count")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -1439500848:
                        if (strX.equals("orientation")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -1410521534:
                        if (strX.equals("battery_temperature")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -1281860764:
                        if (strX.equals("family")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -1097462182:
                        if (strX.equals("locale")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -1012222381:
                        if (strX.equals("online")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -877252910:
                        if (strX.equals("battery_level")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -619038223:
                        if (strX.equals("model_id")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case -568274923:
                        if (strX.equals("screen_density")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                    case -417046774:
                        if (strX.equals("screen_dpi")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case -136523212:
                        if (strX.equals("free_memory")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 3355:
                        if (strX.equals(CLConstants.SHARED_PREFERENCE_ITEM_ID)) {
                            c2 = 16;
                            break;
                        }
                        break;
                    case 3373707:
                        if (strX.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                            c2 = 17;
                            break;
                        }
                        break;
                    case 59142220:
                        if (strX.equals("low_memory")) {
                            c2 = 18;
                            break;
                        }
                        break;
                    case 93076189:
                        if (strX.equals("archs")) {
                            c2 = 19;
                            break;
                        }
                        break;
                    case 93997959:
                        if (strX.equals("brand")) {
                            c2 = 20;
                            break;
                        }
                        break;
                    case 104069929:
                        if (strX.equals("model")) {
                            c2 = 21;
                            break;
                        }
                        break;
                    case 115746789:
                        if (strX.equals("cpu_description")) {
                            c2 = 22;
                            break;
                        }
                        break;
                    case 244497903:
                        if (strX.equals("processor_frequency")) {
                            c2 = 23;
                            break;
                        }
                        break;
                    case 731866107:
                        if (strX.equals("connection_type")) {
                            c2 = 24;
                            break;
                        }
                        break;
                    case 817830969:
                        if (strX.equals("screen_width_pixels")) {
                            c2 = 25;
                            break;
                        }
                        break;
                    case 823882553:
                        if (strX.equals("external_storage_size")) {
                            c2 = 26;
                            break;
                        }
                        break;
                    case 897428293:
                        if (strX.equals("storage_size")) {
                            c2 = 27;
                            break;
                        }
                        break;
                    case 1331465768:
                        if (strX.equals("usable_memory")) {
                            c2 = 28;
                            break;
                        }
                        break;
                    case 1418777727:
                        if (strX.equals("memory_size")) {
                            c2 = 29;
                            break;
                        }
                        break;
                    case 1436115569:
                        if (strX.equals("charging")) {
                            c2 = 30;
                            break;
                        }
                        break;
                    case 1450613660:
                        if (strX.equals("external_free_storage")) {
                            c2 = 31;
                            break;
                        }
                        break;
                    case 1524159400:
                        if (strX.equals("free_storage")) {
                            c2 = ' ';
                            break;
                        }
                        break;
                    case 1556284978:
                        if (strX.equals("screen_height_pixels")) {
                            c2 = '!';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        device.z = objectReader.K(iLogger);
                        break;
                    case 1:
                        if (objectReader.peek() != JsonToken.STRING) {
                            break;
                        } else {
                            device.y = objectReader.c0(iLogger);
                            break;
                        }
                    case 2:
                        device.f52829l = objectReader.f0();
                        break;
                    case 3:
                        device.f52819b = objectReader.a1();
                        break;
                    case 4:
                        device.B = objectReader.a1();
                        break;
                    case 5:
                        device.F = objectReader.M0();
                        break;
                    case 6:
                        device.f52828k = (DeviceOrientation) objectReader.o0(iLogger, new DeviceOrientation.Deserializer());
                        break;
                    case 7:
                        device.E = objectReader.x1();
                        break;
                    case '\b':
                        device.f52821d = objectReader.a1();
                        break;
                    case '\t':
                        device.C = objectReader.a1();
                        break;
                    case '\n':
                        device.f52827j = objectReader.f0();
                        break;
                    case 11:
                        device.f52825h = objectReader.x1();
                        break;
                    case '\f':
                        device.f52823f = objectReader.a1();
                        break;
                    case '\r':
                        device.w = objectReader.x1();
                        break;
                    case 14:
                        device.x = objectReader.M0();
                        break;
                    case 15:
                        device.n = objectReader.R0();
                        break;
                    case 16:
                        device.A = objectReader.a1();
                        break;
                    case 17:
                        device.f52818a = objectReader.a1();
                        break;
                    case 18:
                        device.p = objectReader.f0();
                        break;
                    case 19:
                        List list = (List) objectReader.B1();
                        if (list == null) {
                            break;
                        } else {
                            String[] strArr = new String[list.size()];
                            list.toArray(strArr);
                            device.f52824g = strArr;
                            break;
                        }
                    case 20:
                        device.f52820c = objectReader.a1();
                        break;
                    case 21:
                        device.f52822e = objectReader.a1();
                        break;
                    case 22:
                        device.H = objectReader.a1();
                        break;
                    case 23:
                        device.G = objectReader.W();
                        break;
                    case 24:
                        device.D = objectReader.a1();
                        break;
                    case 25:
                        device.u = objectReader.M0();
                        break;
                    case 26:
                        device.s = objectReader.R0();
                        break;
                    case 27:
                        device.q = objectReader.R0();
                        break;
                    case 28:
                        device.o = objectReader.R0();
                        break;
                    case 29:
                        device.f52830m = objectReader.R0();
                        break;
                    case 30:
                        device.f52826i = objectReader.f0();
                        break;
                    case 31:
                        device.t = objectReader.R0();
                        break;
                    case ' ':
                        device.r = objectReader.R0();
                        break;
                    case '!':
                        device.v = objectReader.M0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            device.I = concurrentHashMap;
            objectReader.t();
            return device;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    public enum DeviceOrientation implements JsonSerializable {
        PORTRAIT,
        LANDSCAPE;

        public static final class Deserializer implements JsonDeserializer<DeviceOrientation> {
            @Override // io.sentry.JsonDeserializer
            public final Object a(ObjectReader objectReader, ILogger iLogger) {
                return DeviceOrientation.valueOf(objectReader.K0().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.JsonSerializable
        public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            objectWriter.e(toString().toLowerCase(Locale.ROOT));
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Device.class == obj.getClass()) {
            Device device = (Device) obj;
            if (Objects.a(this.f52818a, device.f52818a) && Objects.a(this.f52819b, device.f52819b) && Objects.a(this.f52820c, device.f52820c) && Objects.a(this.f52821d, device.f52821d) && Objects.a(this.f52822e, device.f52822e) && Objects.a(this.f52823f, device.f52823f) && Arrays.equals(this.f52824g, device.f52824g) && Objects.a(this.f52825h, device.f52825h) && Objects.a(this.f52826i, device.f52826i) && Objects.a(this.f52827j, device.f52827j) && this.f52828k == device.f52828k && Objects.a(this.f52829l, device.f52829l) && Objects.a(this.f52830m, device.f52830m) && Objects.a(this.n, device.n) && Objects.a(this.o, device.o) && Objects.a(this.p, device.p) && Objects.a(this.q, device.q) && Objects.a(this.r, device.r) && Objects.a(this.s, device.s) && Objects.a(this.t, device.t) && Objects.a(this.u, device.u) && Objects.a(this.v, device.v) && Objects.a(this.w, device.w) && Objects.a(this.x, device.x) && Objects.a(this.y, device.y) && Objects.a(this.A, device.A) && Objects.a(this.B, device.B) && Objects.a(this.C, device.C) && Objects.a(this.D, device.D) && Objects.a(this.E, device.E) && Objects.a(this.F, device.F) && Objects.a(this.G, device.G) && Objects.a(this.H, device.H)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(new Object[]{this.f52818a, this.f52819b, this.f52820c, this.f52821d, this.f52822e, this.f52823f, this.f52825h, this.f52826i, this.f52827j, this.f52828k, this.f52829l, this.f52830m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H}) * 31) + Arrays.hashCode(this.f52824g);
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52818a != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52818a);
        }
        if (this.f52819b != null) {
            objectWriter.d("manufacturer").e(this.f52819b);
        }
        if (this.f52820c != null) {
            objectWriter.d("brand").e(this.f52820c);
        }
        if (this.f52821d != null) {
            objectWriter.d("family").e(this.f52821d);
        }
        if (this.f52822e != null) {
            objectWriter.d("model").e(this.f52822e);
        }
        if (this.f52823f != null) {
            objectWriter.d("model_id").e(this.f52823f);
        }
        if (this.f52824g != null) {
            objectWriter.d("archs").h(iLogger, this.f52824g);
        }
        if (this.f52825h != null) {
            objectWriter.d("battery_level").f(this.f52825h);
        }
        if (this.f52826i != null) {
            objectWriter.d("charging").i(this.f52826i);
        }
        if (this.f52827j != null) {
            objectWriter.d("online").i(this.f52827j);
        }
        if (this.f52828k != null) {
            objectWriter.d("orientation").h(iLogger, this.f52828k);
        }
        if (this.f52829l != null) {
            objectWriter.d("simulator").i(this.f52829l);
        }
        if (this.f52830m != null) {
            objectWriter.d("memory_size").f(this.f52830m);
        }
        if (this.n != null) {
            objectWriter.d("free_memory").f(this.n);
        }
        if (this.o != null) {
            objectWriter.d("usable_memory").f(this.o);
        }
        if (this.p != null) {
            objectWriter.d("low_memory").i(this.p);
        }
        if (this.q != null) {
            objectWriter.d("storage_size").f(this.q);
        }
        if (this.r != null) {
            objectWriter.d("free_storage").f(this.r);
        }
        if (this.s != null) {
            objectWriter.d("external_storage_size").f(this.s);
        }
        if (this.t != null) {
            objectWriter.d("external_free_storage").f(this.t);
        }
        if (this.u != null) {
            objectWriter.d("screen_width_pixels").f(this.u);
        }
        if (this.v != null) {
            objectWriter.d("screen_height_pixels").f(this.v);
        }
        if (this.w != null) {
            objectWriter.d("screen_density").f(this.w);
        }
        if (this.x != null) {
            objectWriter.d("screen_dpi").f(this.x);
        }
        if (this.y != null) {
            objectWriter.d("boot_time").h(iLogger, this.y);
        }
        if (this.z != null) {
            objectWriter.d("timezone").h(iLogger, this.z);
        }
        if (this.A != null) {
            objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).e(this.A);
        }
        if (this.B != null) {
            objectWriter.d("language").e(this.B);
        }
        if (this.D != null) {
            objectWriter.d("connection_type").e(this.D);
        }
        if (this.E != null) {
            objectWriter.d("battery_temperature").f(this.E);
        }
        if (this.C != null) {
            objectWriter.d("locale").e(this.C);
        }
        if (this.F != null) {
            objectWriter.d("processor_count").f(this.F);
        }
        if (this.G != null) {
            objectWriter.d("processor_frequency").f(this.G);
        }
        if (this.H != null) {
            objectWriter.d("cpu_description").e(this.H);
        }
        ConcurrentHashMap concurrentHashMap = this.I;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                objectWriter.d(str).h(iLogger, this.I.get(str));
            }
        }
        objectWriter.t();
    }
}
