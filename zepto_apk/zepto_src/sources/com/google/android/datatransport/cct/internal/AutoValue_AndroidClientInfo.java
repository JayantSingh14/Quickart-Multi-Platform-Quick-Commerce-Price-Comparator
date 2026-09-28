package com.google.android.datatransport.cct.internal;

import android.support.v4.media.b;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;

/* loaded from: classes3.dex */
final class AutoValue_AndroidClientInfo extends AndroidClientInfo {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f20588a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20589b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20590c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20591d;

    /* renamed from: e, reason: collision with root package name */
    public final String f20592e;

    /* renamed from: f, reason: collision with root package name */
    public final String f20593f;

    /* renamed from: g, reason: collision with root package name */
    public final String f20594g;

    /* renamed from: h, reason: collision with root package name */
    public final String f20595h;

    /* renamed from: i, reason: collision with root package name */
    public final String f20596i;

    /* renamed from: j, reason: collision with root package name */
    public final String f20597j;

    /* renamed from: k, reason: collision with root package name */
    public final String f20598k;

    /* renamed from: l, reason: collision with root package name */
    public final String f20599l;

    public static final class Builder extends AndroidClientInfo.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Integer f20600a;

        /* renamed from: b, reason: collision with root package name */
        public String f20601b;

        /* renamed from: c, reason: collision with root package name */
        public String f20602c;

        /* renamed from: d, reason: collision with root package name */
        public String f20603d;

        /* renamed from: e, reason: collision with root package name */
        public String f20604e;

        /* renamed from: f, reason: collision with root package name */
        public String f20605f;

        /* renamed from: g, reason: collision with root package name */
        public String f20606g;

        /* renamed from: h, reason: collision with root package name */
        public String f20607h;

        /* renamed from: i, reason: collision with root package name */
        public String f20608i;

        /* renamed from: j, reason: collision with root package name */
        public String f20609j;

        /* renamed from: k, reason: collision with root package name */
        public String f20610k;

        /* renamed from: l, reason: collision with root package name */
        public String f20611l;

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo a() {
            return new AutoValue_AndroidClientInfo(this.f20600a, this.f20601b, this.f20602c, this.f20603d, this.f20604e, this.f20605f, this.f20606g, this.f20607h, this.f20608i, this.f20609j, this.f20610k, this.f20611l);
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder b(String str) {
            this.f20611l = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder c(String str) {
            this.f20609j = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder d(String str) {
            this.f20603d = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder e(String str) {
            this.f20607h = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder f(String str) {
            this.f20602c = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder g(String str) {
            this.f20608i = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder h(String str) {
            this.f20606g = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder i(String str) {
            this.f20610k = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder j(String str) {
            this.f20601b = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder k(String str) {
            this.f20605f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder l(String str) {
            this.f20604e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public final AndroidClientInfo.Builder m(Integer num) {
            this.f20600a = num;
            return this;
        }
    }

    public AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f20588a = num;
        this.f20589b = str;
        this.f20590c = str2;
        this.f20591d = str3;
        this.f20592e = str4;
        this.f20593f = str5;
        this.f20594g = str6;
        this.f20595h = str7;
        this.f20596i = str8;
        this.f20597j = str9;
        this.f20598k = str10;
        this.f20599l = str11;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String b() {
        return this.f20599l;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String c() {
        return this.f20597j;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String d() {
        return this.f20591d;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String e() {
        return this.f20595h;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.f20588a;
        if (num == null) {
            if (androidClientInfo.m() != null) {
                return false;
            }
        } else if (!num.equals(androidClientInfo.m())) {
            return false;
        }
        String str = this.f20589b;
        if (str == null) {
            if (androidClientInfo.j() != null) {
                return false;
            }
        } else if (!str.equals(androidClientInfo.j())) {
            return false;
        }
        String str2 = this.f20590c;
        if (str2 == null) {
            if (androidClientInfo.f() != null) {
                return false;
            }
        } else if (!str2.equals(androidClientInfo.f())) {
            return false;
        }
        String str3 = this.f20591d;
        if (str3 == null) {
            if (androidClientInfo.d() != null) {
                return false;
            }
        } else if (!str3.equals(androidClientInfo.d())) {
            return false;
        }
        String str4 = this.f20592e;
        if (str4 == null) {
            if (androidClientInfo.l() != null) {
                return false;
            }
        } else if (!str4.equals(androidClientInfo.l())) {
            return false;
        }
        String str5 = this.f20593f;
        if (str5 == null) {
            if (androidClientInfo.k() != null) {
                return false;
            }
        } else if (!str5.equals(androidClientInfo.k())) {
            return false;
        }
        String str6 = this.f20594g;
        if (str6 == null) {
            if (androidClientInfo.h() != null) {
                return false;
            }
        } else if (!str6.equals(androidClientInfo.h())) {
            return false;
        }
        String str7 = this.f20595h;
        if (str7 == null) {
            if (androidClientInfo.e() != null) {
                return false;
            }
        } else if (!str7.equals(androidClientInfo.e())) {
            return false;
        }
        String str8 = this.f20596i;
        if (str8 == null) {
            if (androidClientInfo.g() != null) {
                return false;
            }
        } else if (!str8.equals(androidClientInfo.g())) {
            return false;
        }
        String str9 = this.f20597j;
        if (str9 == null) {
            if (androidClientInfo.c() != null) {
                return false;
            }
        } else if (!str9.equals(androidClientInfo.c())) {
            return false;
        }
        String str10 = this.f20598k;
        if (str10 == null) {
            if (androidClientInfo.i() != null) {
                return false;
            }
        } else if (!str10.equals(androidClientInfo.i())) {
            return false;
        }
        String str11 = this.f20599l;
        return str11 == null ? androidClientInfo.b() == null : str11.equals(androidClientInfo.b());
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String f() {
        return this.f20590c;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String g() {
        return this.f20596i;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String h() {
        return this.f20594g;
    }

    public final int hashCode() {
        Integer num = this.f20588a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f20589b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f20590c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f20591d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f20592e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f20593f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f20594g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f20595h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f20596i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f20597j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f20598k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f20599l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String i() {
        return this.f20598k;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String j() {
        return this.f20589b;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String k() {
        return this.f20593f;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final String l() {
        return this.f20592e;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public final Integer m() {
        return this.f20588a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f20588a);
        sb.append(", model=");
        sb.append(this.f20589b);
        sb.append(", hardware=");
        sb.append(this.f20590c);
        sb.append(", device=");
        sb.append(this.f20591d);
        sb.append(", product=");
        sb.append(this.f20592e);
        sb.append(", osBuild=");
        sb.append(this.f20593f);
        sb.append(", manufacturer=");
        sb.append(this.f20594g);
        sb.append(", fingerprint=");
        sb.append(this.f20595h);
        sb.append(", locale=");
        sb.append(this.f20596i);
        sb.append(", country=");
        sb.append(this.f20597j);
        sb.append(", mccMnc=");
        sb.append(this.f20598k);
        sb.append(", applicationBuild=");
        return b.r(sb, this.f20599l, "}");
    }
}
