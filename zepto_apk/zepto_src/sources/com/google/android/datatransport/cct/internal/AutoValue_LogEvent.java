package com.google.android.datatransport.cct.internal;

import android.support.v4.media.b;
import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class AutoValue_LogEvent extends LogEvent {

    /* renamed from: a, reason: collision with root package name */
    public final long f20629a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f20630b;

    /* renamed from: c, reason: collision with root package name */
    public final ComplianceData f20631c;

    /* renamed from: d, reason: collision with root package name */
    public final long f20632d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f20633e;

    /* renamed from: f, reason: collision with root package name */
    public final String f20634f;

    /* renamed from: g, reason: collision with root package name */
    public final long f20635g;

    /* renamed from: h, reason: collision with root package name */
    public final NetworkConnectionInfo f20636h;

    /* renamed from: i, reason: collision with root package name */
    public final ExperimentIds f20637i;

    public static final class Builder extends LogEvent.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Long f20638a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f20639b;

        /* renamed from: c, reason: collision with root package name */
        public ComplianceData f20640c;

        /* renamed from: d, reason: collision with root package name */
        public Long f20641d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f20642e;

        /* renamed from: f, reason: collision with root package name */
        public String f20643f;

        /* renamed from: g, reason: collision with root package name */
        public Long f20644g;

        /* renamed from: h, reason: collision with root package name */
        public NetworkConnectionInfo f20645h;

        /* renamed from: i, reason: collision with root package name */
        public ExperimentIds f20646i;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent a() {
            String strK = this.f20638a == null ? " eventTimeMs" : "";
            if (this.f20641d == null) {
                strK = strK.concat(" eventUptimeMs");
            }
            if (this.f20644g == null) {
                strK = b.k(strK, " timezoneOffsetSeconds");
            }
            if (strK.isEmpty()) {
                return new AutoValue_LogEvent(this.f20638a.longValue(), this.f20639b, this.f20640c, this.f20641d.longValue(), this.f20642e, this.f20643f, this.f20644g.longValue(), this.f20645h, this.f20646i);
            }
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder b(ComplianceData complianceData) {
            this.f20640c = complianceData;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder c(Integer num) {
            this.f20639b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder d(long j2) {
            this.f20638a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder e(long j2) {
            this.f20641d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder f(ExperimentIds experimentIds) {
            this.f20646i = experimentIds;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder g(NetworkConnectionInfo networkConnectionInfo) {
            this.f20645h = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public final LogEvent.Builder h(long j2) {
            this.f20644g = Long.valueOf(j2);
            return this;
        }
    }

    public AutoValue_LogEvent(long j2, Integer num, ComplianceData complianceData, long j3, byte[] bArr, String str, long j4, NetworkConnectionInfo networkConnectionInfo, ExperimentIds experimentIds) {
        this.f20629a = j2;
        this.f20630b = num;
        this.f20631c = complianceData;
        this.f20632d = j3;
        this.f20633e = bArr;
        this.f20634f = str;
        this.f20635g = j4;
        this.f20636h = networkConnectionInfo;
        this.f20637i = experimentIds;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final ComplianceData a() {
        return this.f20631c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final Integer b() {
        return this.f20630b;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long c() {
        return this.f20629a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long d() {
        return this.f20632d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final ExperimentIds e() {
        return this.f20637i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f20629a != logEvent.c()) {
            return false;
        }
        Integer num = this.f20630b;
        if (num == null) {
            if (logEvent.b() != null) {
                return false;
            }
        } else if (!num.equals(logEvent.b())) {
            return false;
        }
        ComplianceData complianceData = this.f20631c;
        if (complianceData == null) {
            if (logEvent.a() != null) {
                return false;
            }
        } else if (!complianceData.equals(logEvent.a())) {
            return false;
        }
        if (this.f20632d != logEvent.d()) {
            return false;
        }
        if (!Arrays.equals(this.f20633e, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).f20633e : logEvent.g())) {
            return false;
        }
        String str = this.f20634f;
        if (str == null) {
            if (logEvent.h() != null) {
                return false;
            }
        } else if (!str.equals(logEvent.h())) {
            return false;
        }
        if (this.f20635g != logEvent.i()) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = this.f20636h;
        if (networkConnectionInfo == null) {
            if (logEvent.f() != null) {
                return false;
            }
        } else if (!networkConnectionInfo.equals(logEvent.f())) {
            return false;
        }
        ExperimentIds experimentIds = this.f20637i;
        return experimentIds == null ? logEvent.e() == null : experimentIds.equals(logEvent.e());
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final NetworkConnectionInfo f() {
        return this.f20636h;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final byte[] g() {
        return this.f20633e;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final String h() {
        return this.f20634f;
    }

    public final int hashCode() {
        long j2 = this.f20629a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f20630b;
        int iHashCode = (i2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        ComplianceData complianceData = this.f20631c;
        int iHashCode2 = (iHashCode ^ (complianceData == null ? 0 : complianceData.hashCode())) * 1000003;
        long j3 = this.f20632d;
        int iHashCode3 = (((iHashCode2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f20633e)) * 1000003;
        String str = this.f20634f;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j4 = this.f20635g;
        int i3 = (iHashCode4 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f20636h;
        int iHashCode5 = (i3 ^ (networkConnectionInfo == null ? 0 : networkConnectionInfo.hashCode())) * 1000003;
        ExperimentIds experimentIds = this.f20637i;
        return iHashCode5 ^ (experimentIds != null ? experimentIds.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long i() {
        return this.f20635g;
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f20629a + ", eventCode=" + this.f20630b + ", complianceData=" + this.f20631c + ", eventUptimeMs=" + this.f20632d + ", sourceExtension=" + Arrays.toString(this.f20633e) + ", sourceExtensionJsonProto3=" + this.f20634f + ", timezoneOffsetSeconds=" + this.f20635g + ", networkConnectionInfo=" + this.f20636h + ", experimentIds=" + this.f20637i + "}";
    }
}
