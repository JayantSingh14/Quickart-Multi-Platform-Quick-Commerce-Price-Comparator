package com.google.firebase.crashlytics.internal.model;

import androidx.fragment.app.e;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {

    /* renamed from: a, reason: collision with root package name */
    public final int f44119a;

    /* renamed from: b, reason: collision with root package name */
    public final String f44120b;

    /* renamed from: c, reason: collision with root package name */
    public final int f44121c;

    /* renamed from: d, reason: collision with root package name */
    public final int f44122d;

    /* renamed from: e, reason: collision with root package name */
    public final long f44123e;

    /* renamed from: f, reason: collision with root package name */
    public final long f44124f;

    /* renamed from: g, reason: collision with root package name */
    public final long f44125g;

    /* renamed from: h, reason: collision with root package name */
    public final String f44126h;

    /* renamed from: i, reason: collision with root package name */
    public final List f44127i;

    /* loaded from: classes4.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f44128a;

        /* renamed from: b, reason: collision with root package name */
        public String f44129b;

        /* renamed from: c, reason: collision with root package name */
        public int f44130c;

        /* renamed from: d, reason: collision with root package name */
        public int f44131d;

        /* renamed from: e, reason: collision with root package name */
        public long f44132e;

        /* renamed from: f, reason: collision with root package name */
        public long f44133f;

        /* renamed from: g, reason: collision with root package name */
        public long f44134g;

        /* renamed from: h, reason: collision with root package name */
        public String f44135h;

        /* renamed from: i, reason: collision with root package name */
        public List f44136i;

        /* renamed from: j, reason: collision with root package name */
        public byte f44137j;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo a() {
            String str;
            if (this.f44137j == 63 && (str = this.f44129b) != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.f44128a, str, this.f44130c, this.f44131d, this.f44132e, this.f44133f, this.f44134g, this.f44135h, this.f44136i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f44137j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f44129b == null) {
                sb.append(" processName");
            }
            if ((this.f44137j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f44137j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f44137j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f44137j & 16) == 0) {
                sb.append(" rss");
            }
            if ((this.f44137j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException(e.s(sb, "Missing required properties:"));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder b(List list) {
            this.f44136i = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder c(int i2) {
            this.f44131d = i2;
            this.f44137j = (byte) (this.f44137j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder d(int i2) {
            this.f44128a = i2;
            this.f44137j = (byte) (this.f44137j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f44129b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder f(long j2) {
            this.f44132e = j2;
            this.f44137j = (byte) (this.f44137j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder g(int i2) {
            this.f44130c = i2;
            this.f44137j = (byte) (this.f44137j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder h(long j2) {
            this.f44133f = j2;
            this.f44137j = (byte) (this.f44137j | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder i(long j2) {
            this.f44134g = j2;
            this.f44137j = (byte) (this.f44137j | 32);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public final CrashlyticsReport.ApplicationExitInfo.Builder j(String str) {
            this.f44135h = str;
            return this;
        }
    }

    public AutoValue_CrashlyticsReport_ApplicationExitInfo(int i2, String str, int i3, int i4, long j2, long j3, long j4, String str2, List list) {
        this.f44119a = i2;
        this.f44120b = str;
        this.f44121c = i3;
        this.f44122d = i4;
        this.f44123e = j2;
        this.f44124f = j3;
        this.f44125g = j4;
        this.f44126h = str2;
        this.f44127i = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final List b() {
        return this.f44127i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int c() {
        return this.f44122d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int d() {
        return this.f44119a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final String e() {
        return this.f44120b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.f44119a != applicationExitInfo.d() || !this.f44120b.equals(applicationExitInfo.e()) || this.f44121c != applicationExitInfo.g() || this.f44122d != applicationExitInfo.c() || this.f44123e != applicationExitInfo.f() || this.f44124f != applicationExitInfo.h() || this.f44125g != applicationExitInfo.i()) {
            return false;
        }
        String str = this.f44126h;
        if (str == null) {
            if (applicationExitInfo.j() != null) {
                return false;
            }
        } else if (!str.equals(applicationExitInfo.j())) {
            return false;
        }
        List list = this.f44127i;
        return list == null ? applicationExitInfo.b() == null : list.equals(applicationExitInfo.b());
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long f() {
        return this.f44123e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int g() {
        return this.f44121c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long h() {
        return this.f44124f;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f44119a ^ 1000003) * 1000003) ^ this.f44120b.hashCode()) * 1000003) ^ this.f44121c) * 1000003) ^ this.f44122d) * 1000003;
        long j2 = this.f44123e;
        int i2 = (iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f44124f;
        int i3 = (i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f44125g;
        int i4 = (i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        String str = this.f44126h;
        int iHashCode2 = (i4 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f44127i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long i() {
        return this.f44125g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final String j() {
        return this.f44126h;
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.f44119a + ", processName=" + this.f44120b + ", reasonCode=" + this.f44121c + ", importance=" + this.f44122d + ", pss=" + this.f44123e + ", rss=" + this.f44124f + ", timestamp=" + this.f44125g + ", traceFile=" + this.f44126h + ", buildIdMappingForArch=" + this.f44127i + "}";
    }
}
