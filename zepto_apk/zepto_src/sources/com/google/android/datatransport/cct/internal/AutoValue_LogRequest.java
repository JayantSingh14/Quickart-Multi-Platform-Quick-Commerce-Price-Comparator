package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_LogRequest extends LogRequest {

    /* renamed from: a, reason: collision with root package name */
    public final long f20647a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20648b;

    /* renamed from: c, reason: collision with root package name */
    public final ClientInfo f20649c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f20650d;

    /* renamed from: e, reason: collision with root package name */
    public final String f20651e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f20652f;

    /* renamed from: g, reason: collision with root package name */
    public final QosTier f20653g;

    public static final class Builder extends LogRequest.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Long f20654a;

        /* renamed from: b, reason: collision with root package name */
        public Long f20655b;

        /* renamed from: c, reason: collision with root package name */
        public ClientInfo f20656c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f20657d;

        /* renamed from: e, reason: collision with root package name */
        public String f20658e;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList f20659f;

        /* renamed from: g, reason: collision with root package name */
        public QosTier f20660g;

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest a() {
            String strConcat = this.f20654a == null ? " requestTimeMs" : "";
            if (this.f20655b == null) {
                strConcat = strConcat.concat(" requestUptimeMs");
            }
            if (strConcat.isEmpty()) {
                return new AutoValue_LogRequest(this.f20654a.longValue(), this.f20655b.longValue(), this.f20656c, this.f20657d, this.f20658e, this.f20659f, this.f20660g);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder b(ClientInfo clientInfo) {
            this.f20656c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder c(ArrayList arrayList) {
            this.f20659f = arrayList;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder d(Integer num) {
            this.f20657d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder e(String str) {
            this.f20658e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder f() {
            this.f20660g = QosTier.f20674a;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder g(long j2) {
            this.f20654a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public final LogRequest.Builder h(long j2) {
            this.f20655b = Long.valueOf(j2);
            return this;
        }
    }

    public AutoValue_LogRequest(long j2, long j3, ClientInfo clientInfo, Integer num, String str, ArrayList arrayList, QosTier qosTier) {
        this.f20647a = j2;
        this.f20648b = j3;
        this.f20649c = clientInfo;
        this.f20650d = num;
        this.f20651e = str;
        this.f20652f = arrayList;
        this.f20653g = qosTier;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final ClientInfo b() {
        return this.f20649c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final List c() {
        return this.f20652f;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final Integer d() {
        return this.f20650d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final String e() {
        return this.f20651e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f20647a != logRequest.g() || this.f20648b != logRequest.h()) {
            return false;
        }
        ClientInfo clientInfo = this.f20649c;
        if (clientInfo == null) {
            if (logRequest.b() != null) {
                return false;
            }
        } else if (!clientInfo.equals(logRequest.b())) {
            return false;
        }
        Integer num = this.f20650d;
        if (num == null) {
            if (logRequest.d() != null) {
                return false;
            }
        } else if (!num.equals(logRequest.d())) {
            return false;
        }
        String str = this.f20651e;
        if (str == null) {
            if (logRequest.e() != null) {
                return false;
            }
        } else if (!str.equals(logRequest.e())) {
            return false;
        }
        ArrayList arrayList = this.f20652f;
        if (arrayList == null) {
            if (logRequest.c() != null) {
                return false;
            }
        } else if (!arrayList.equals(logRequest.c())) {
            return false;
        }
        QosTier qosTier = this.f20653g;
        return qosTier == null ? logRequest.f() == null : qosTier.equals(logRequest.f());
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final QosTier f() {
        return this.f20653g;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final long g() {
        return this.f20647a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final long h() {
        return this.f20648b;
    }

    public final int hashCode() {
        long j2 = this.f20647a;
        long j3 = this.f20648b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        ClientInfo clientInfo = this.f20649c;
        int iHashCode = (i2 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f20650d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f20651e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        ArrayList arrayList = this.f20652f;
        int iHashCode4 = (iHashCode3 ^ (arrayList == null ? 0 : arrayList.hashCode())) * 1000003;
        QosTier qosTier = this.f20653g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f20647a + ", requestUptimeMs=" + this.f20648b + ", clientInfo=" + this.f20649c + ", logSource=" + this.f20650d + ", logSourceName=" + this.f20651e + ", logEvents=" + this.f20652f + ", qosTier=" + this.f20653g + "}";
    }
}
