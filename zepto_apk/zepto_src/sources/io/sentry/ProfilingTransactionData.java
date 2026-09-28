package io.sentry;

import com.google.ads.interactivemedia.v3.impl.data.zzck;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ProfilingTransactionData implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f51740a;

    /* renamed from: b, reason: collision with root package name */
    public String f51741b;

    /* renamed from: c, reason: collision with root package name */
    public String f51742c;

    /* renamed from: d, reason: collision with root package name */
    public Long f51743d;

    /* renamed from: e, reason: collision with root package name */
    public Long f51744e;

    /* renamed from: f, reason: collision with root package name */
    public Long f51745f;

    /* renamed from: g, reason: collision with root package name */
    public Long f51746g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap f51747h;

    public static final class Deserializer implements JsonDeserializer<ProfilingTransactionData> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            ProfilingTransactionData profilingTransactionData = new ProfilingTransactionData();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "relative_start_ns":
                        Long lR0 = objectReader.R0();
                        if (lR0 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51743d = lR0;
                            break;
                        }
                    case "relative_end_ns":
                        Long lR02 = objectReader.R0();
                        if (lR02 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51744e = lR02;
                            break;
                        }
                    case "id":
                        String strA1 = objectReader.a1();
                        if (strA1 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51740a = strA1;
                            break;
                        }
                    case "name":
                        String strA12 = objectReader.a1();
                        if (strA12 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51742c = strA12;
                            break;
                        }
                    case "trace_id":
                        String strA13 = objectReader.a1();
                        if (strA13 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51741b = strA13;
                            break;
                        }
                    case "relative_cpu_end_ms":
                        Long lR03 = objectReader.R0();
                        if (lR03 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51746g = lR03;
                            break;
                        }
                    case "relative_cpu_start_ms":
                        Long lR04 = objectReader.R0();
                        if (lR04 == null) {
                            break;
                        } else {
                            profilingTransactionData.f51745f = lR04;
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
            profilingTransactionData.f51747h = concurrentHashMap;
            objectReader.t();
            return profilingTransactionData;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public ProfilingTransactionData() {
        this(NoOpTransaction.f51714a, 0L, 0L);
    }

    public final void a(Long l2, Long l3, Long l4, Long l5) {
        if (this.f51744e == null) {
            this.f51744e = Long.valueOf(l2.longValue() - l3.longValue());
            this.f51743d = Long.valueOf(this.f51743d.longValue() - l3.longValue());
            this.f51746g = Long.valueOf(l4.longValue() - l5.longValue());
            this.f51745f = Long.valueOf(this.f51745f.longValue() - l5.longValue());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ProfilingTransactionData.class != obj.getClass()) {
            return false;
        }
        ProfilingTransactionData profilingTransactionData = (ProfilingTransactionData) obj;
        return this.f51740a.equals(profilingTransactionData.f51740a) && this.f51741b.equals(profilingTransactionData.f51741b) && this.f51742c.equals(profilingTransactionData.f51742c) && this.f51743d.equals(profilingTransactionData.f51743d) && this.f51745f.equals(profilingTransactionData.f51745f) && Objects.a(this.f51746g, profilingTransactionData.f51746g) && Objects.a(this.f51744e, profilingTransactionData.f51744e) && Objects.a(this.f51747h, profilingTransactionData.f51747h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f51740a, this.f51741b, this.f51742c, this.f51743d, this.f51744e, this.f51745f, this.f51746g, this.f51747h});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).h(iLogger, this.f51740a);
        objectWriter.d("trace_id").h(iLogger, this.f51741b);
        objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).h(iLogger, this.f51742c);
        objectWriter.d("relative_start_ns").h(iLogger, this.f51743d);
        objectWriter.d("relative_end_ns").h(iLogger, this.f51744e);
        objectWriter.d("relative_cpu_start_ms").h(iLogger, this.f51745f);
        objectWriter.d("relative_cpu_end_ms").h(iLogger, this.f51746g);
        ConcurrentHashMap concurrentHashMap = this.f51747h;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f51747h, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }

    public ProfilingTransactionData(ITransaction iTransaction, Long l2, Long l3) {
        this.f51740a = iTransaction.e().toString();
        this.f51741b = iTransaction.o().f51921a.toString();
        this.f51742c = iTransaction.getName().isEmpty() ? zzck.UNKNOWN_CONTENT_TYPE : iTransaction.getName();
        this.f51743d = l2;
        this.f51745f = l3;
    }
}
