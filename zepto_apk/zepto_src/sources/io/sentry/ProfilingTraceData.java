package io.sentry;

import com.google.ads.interactivemedia.v3.impl.data.zzck;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.ProfilingTransactionData;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.CharUtils;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ProfilingTraceData implements JsonUnknown, JsonSerializable {
    public final HashMap A;
    public ConcurrentHashMap C;

    /* renamed from: a, reason: collision with root package name */
    public final File f51727a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable f51728b;

    /* renamed from: c, reason: collision with root package name */
    public int f51729c;

    /* renamed from: e, reason: collision with root package name */
    public String f51731e;

    /* renamed from: f, reason: collision with root package name */
    public String f51732f;

    /* renamed from: g, reason: collision with root package name */
    public String f51733g;

    /* renamed from: h, reason: collision with root package name */
    public String f51734h;

    /* renamed from: i, reason: collision with root package name */
    public String f51735i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f51736j;

    /* renamed from: k, reason: collision with root package name */
    public String f51737k;

    /* renamed from: m, reason: collision with root package name */
    public String f51739m;
    public String n;
    public String o;
    public final ArrayList p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public Date z;

    /* renamed from: l, reason: collision with root package name */
    public List f51738l = new ArrayList();
    public String B = null;

    /* renamed from: d, reason: collision with root package name */
    public String f51730d = Locale.getDefault().toString();

    public static final class Deserializer implements JsonDeserializer<ProfilingTraceData> {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            ProfilingTraceData profilingTraceData = new ProfilingTraceData(new File("dummy"), DateUtils.a(), new ArrayList(), "", SentryId.f52907b.toString(), NoOpTransaction.f51714a.o().f51921a.toString(), "0", 0, "", new c(2), null, null, null, null, null, null, null, null, "normal", new HashMap());
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                char c2 = 65535;
                switch (strX.hashCode()) {
                    case -2133529830:
                        if (strX.equals("device_manufacturer")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1981468849:
                        if (strX.equals("android_api_level")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1430655860:
                        if (strX.equals("build_id")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1172160413:
                        if (strX.equals("device_locale")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1102636175:
                        if (strX.equals("profile_id")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -716656436:
                        if (strX.equals("device_os_build_number")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -591076352:
                        if (strX.equals("device_model")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -512511455:
                        if (strX.equals("device_is_emulator")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -478065584:
                        if (strX.equals("duration_ns")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -362243017:
                        if (strX.equals("measurements")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -332426004:
                        if (strX.equals("device_physical_memory_bytes")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -212264198:
                        if (strX.equals("device_cpu_frequencies")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -102985484:
                        if (strX.equals("version_code")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case -102670958:
                        if (strX.equals("version_name")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                    case -85904877:
                        if (strX.equals(PaymentConstants.ENV)) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case 55126294:
                        if (strX.equals("timestamp")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 508853068:
                        if (strX.equals("transaction_name")) {
                            c2 = 16;
                            break;
                        }
                        break;
                    case 796476189:
                        if (strX.equals("device_os_name")) {
                            c2 = 17;
                            break;
                        }
                        break;
                    case 839674195:
                        if (strX.equals("architecture")) {
                            c2 = 18;
                            break;
                        }
                        break;
                    case 1010584092:
                        if (strX.equals("transaction_id")) {
                            c2 = 19;
                            break;
                        }
                        break;
                    case 1052553990:
                        if (strX.equals("device_os_version")) {
                            c2 = 20;
                            break;
                        }
                        break;
                    case 1163928186:
                        if (strX.equals("truncation_reason")) {
                            c2 = 21;
                            break;
                        }
                        break;
                    case 1270300245:
                        if (strX.equals("trace_id")) {
                            c2 = 22;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (strX.equals("platform")) {
                            c2 = 23;
                            break;
                        }
                        break;
                    case 1953158756:
                        if (strX.equals("sampled_profile")) {
                            c2 = 24;
                            break;
                        }
                        break;
                    case 1954122069:
                        if (strX.equals("transactions")) {
                            c2 = 25;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        String strA1 = objectReader.a1();
                        if (strA1 == null) {
                            break;
                        } else {
                            profilingTraceData.f51731e = strA1;
                            break;
                        }
                    case 1:
                        Integer numM0 = objectReader.M0();
                        if (numM0 == null) {
                            break;
                        } else {
                            profilingTraceData.f51729c = numM0.intValue();
                            break;
                        }
                    case 2:
                        String strA12 = objectReader.a1();
                        if (strA12 == null) {
                            break;
                        } else {
                            profilingTraceData.o = strA12;
                            break;
                        }
                    case 3:
                        String strA13 = objectReader.a1();
                        if (strA13 == null) {
                            break;
                        } else {
                            profilingTraceData.f51730d = strA13;
                            break;
                        }
                    case 4:
                        String strA14 = objectReader.a1();
                        if (strA14 == null) {
                            break;
                        } else {
                            profilingTraceData.w = strA14;
                            break;
                        }
                    case 5:
                        String strA15 = objectReader.a1();
                        if (strA15 == null) {
                            break;
                        } else {
                            profilingTraceData.f51733g = strA15;
                            break;
                        }
                    case 6:
                        String strA16 = objectReader.a1();
                        if (strA16 == null) {
                            break;
                        } else {
                            profilingTraceData.f51732f = strA16;
                            break;
                        }
                    case 7:
                        Boolean boolF0 = objectReader.f0();
                        if (boolF0 == null) {
                            break;
                        } else {
                            profilingTraceData.f51736j = boolF0.booleanValue();
                            break;
                        }
                    case '\b':
                        String strA17 = objectReader.a1();
                        if (strA17 == null) {
                            break;
                        } else {
                            profilingTraceData.r = strA17;
                            break;
                        }
                    case '\t':
                        HashMap mapD1 = objectReader.d1(iLogger, new ProfileMeasurement.Deserializer());
                        if (mapD1 == null) {
                            break;
                        } else {
                            profilingTraceData.A.putAll(mapD1);
                            break;
                        }
                    case '\n':
                        String strA18 = objectReader.a1();
                        if (strA18 == null) {
                            break;
                        } else {
                            profilingTraceData.f51739m = strA18;
                            break;
                        }
                    case 11:
                        List list = (List) objectReader.B1();
                        if (list == null) {
                            break;
                        } else {
                            profilingTraceData.f51738l = list;
                            break;
                        }
                    case '\f':
                        String strA19 = objectReader.a1();
                        if (strA19 == null) {
                            break;
                        } else {
                            profilingTraceData.s = strA19;
                            break;
                        }
                    case '\r':
                        String strA110 = objectReader.a1();
                        if (strA110 == null) {
                            break;
                        } else {
                            profilingTraceData.t = strA110;
                            break;
                        }
                    case 14:
                        String strA111 = objectReader.a1();
                        if (strA111 == null) {
                            break;
                        } else {
                            profilingTraceData.x = strA111;
                            break;
                        }
                    case 15:
                        Date dateC0 = objectReader.c0(iLogger);
                        if (dateC0 == null) {
                            break;
                        } else {
                            profilingTraceData.z = dateC0;
                            break;
                        }
                    case 16:
                        String strA112 = objectReader.a1();
                        if (strA112 == null) {
                            break;
                        } else {
                            profilingTraceData.q = strA112;
                            break;
                        }
                    case 17:
                        String strA113 = objectReader.a1();
                        if (strA113 == null) {
                            break;
                        } else {
                            profilingTraceData.f51734h = strA113;
                            break;
                        }
                    case 18:
                        String strA114 = objectReader.a1();
                        if (strA114 == null) {
                            break;
                        } else {
                            profilingTraceData.f51737k = strA114;
                            break;
                        }
                    case 19:
                        String strA115 = objectReader.a1();
                        if (strA115 == null) {
                            break;
                        } else {
                            profilingTraceData.u = strA115;
                            break;
                        }
                    case 20:
                        String strA116 = objectReader.a1();
                        if (strA116 == null) {
                            break;
                        } else {
                            profilingTraceData.f51735i = strA116;
                            break;
                        }
                    case 21:
                        String strA117 = objectReader.a1();
                        if (strA117 == null) {
                            break;
                        } else {
                            profilingTraceData.y = strA117;
                            break;
                        }
                    case 22:
                        String strA118 = objectReader.a1();
                        if (strA118 == null) {
                            break;
                        } else {
                            profilingTraceData.v = strA118;
                            break;
                        }
                    case 23:
                        String strA119 = objectReader.a1();
                        if (strA119 == null) {
                            break;
                        } else {
                            profilingTraceData.n = strA119;
                            break;
                        }
                    case 24:
                        String strA120 = objectReader.a1();
                        if (strA120 == null) {
                            break;
                        } else {
                            profilingTraceData.B = strA120;
                            break;
                        }
                    case 25:
                        ArrayList arrayListI1 = objectReader.I1(iLogger, new ProfilingTransactionData.Deserializer());
                        if (arrayListI1 == null) {
                            break;
                        } else {
                            profilingTraceData.p.addAll(arrayListI1);
                            break;
                        }
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            profilingTraceData.C = concurrentHashMap;
            objectReader.t();
            return profilingTraceData;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public ProfilingTraceData(File file, Date date, ArrayList arrayList, String str, String str2, String str3, String str4, int i2, String str5, Callable callable, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, HashMap map) {
        this.f51727a = file;
        this.z = date;
        this.f51737k = str5;
        this.f51728b = callable;
        this.f51729c = i2;
        this.f51731e = str6 == null ? "" : str6;
        this.f51732f = str7 == null ? "" : str7;
        this.f51735i = str8 != null ? str8 : "";
        this.f51736j = bool != null ? bool.booleanValue() : false;
        this.f51739m = str9 != null ? str9 : "0";
        this.f51733g = "";
        this.f51734h = LogSubCategory.LifeCycle.ANDROID;
        this.n = LogSubCategory.LifeCycle.ANDROID;
        this.o = str10 != null ? str10 : "";
        this.p = arrayList;
        this.q = str.isEmpty() ? zzck.UNKNOWN_CONTENT_TYPE : str;
        this.r = str4;
        this.s = "";
        this.t = str11 != null ? str11 : "";
        this.u = str2;
        this.v = str3;
        this.w = UUID.randomUUID().toString();
        this.x = str12 != null ? str12 : "production";
        this.y = str13;
        if (!str13.equals("normal") && !this.y.equals("timeout") && !this.y.equals("backgrounded")) {
            this.y = "normal";
        }
        this.A = map;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("android_api_level").h(iLogger, Integer.valueOf(this.f51729c));
        objectWriter.d("device_locale").h(iLogger, this.f51730d);
        objectWriter.d("device_manufacturer").e(this.f51731e);
        objectWriter.d("device_model").e(this.f51732f);
        objectWriter.d("device_os_build_number").e(this.f51733g);
        objectWriter.d("device_os_name").e(this.f51734h);
        objectWriter.d("device_os_version").e(this.f51735i);
        objectWriter.d("device_is_emulator").c(this.f51736j);
        objectWriter.d("architecture").h(iLogger, this.f51737k);
        objectWriter.d("device_cpu_frequencies").h(iLogger, this.f51738l);
        objectWriter.d("device_physical_memory_bytes").e(this.f51739m);
        objectWriter.d("platform").e(this.n);
        objectWriter.d("build_id").e(this.o);
        objectWriter.d("transaction_name").e(this.q);
        objectWriter.d("duration_ns").e(this.r);
        objectWriter.d("version_name").e(this.t);
        objectWriter.d("version_code").e(this.s);
        ArrayList arrayList = this.p;
        if (!arrayList.isEmpty()) {
            objectWriter.d("transactions").h(iLogger, arrayList);
        }
        objectWriter.d("transaction_id").e(this.u);
        objectWriter.d("trace_id").e(this.v);
        objectWriter.d("profile_id").e(this.w);
        objectWriter.d(PaymentConstants.ENV).e(this.x);
        objectWriter.d("truncation_reason").e(this.y);
        if (this.B != null) {
            objectWriter.d("sampled_profile").e(this.B);
        }
        objectWriter.d("measurements").h(iLogger, this.A);
        objectWriter.d("timestamp").h(iLogger, this.z);
        ConcurrentHashMap concurrentHashMap = this.C;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.C, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
