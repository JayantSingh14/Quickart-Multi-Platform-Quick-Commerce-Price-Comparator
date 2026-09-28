package com.google.firebase.installations.local;

import android.support.v4.media.b;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes.dex */
final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* renamed from: b, reason: collision with root package name */
    public final String f44597b;

    /* renamed from: c, reason: collision with root package name */
    public final PersistedInstallation.RegistrationStatus f44598c;

    /* renamed from: d, reason: collision with root package name */
    public final String f44599d;

    /* renamed from: e, reason: collision with root package name */
    public final String f44600e;

    /* renamed from: f, reason: collision with root package name */
    public final long f44601f;

    /* renamed from: g, reason: collision with root package name */
    public final long f44602g;

    /* renamed from: h, reason: collision with root package name */
    public final String f44603h;

    public static final class Builder extends PersistedInstallationEntry.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44604a;

        /* renamed from: b, reason: collision with root package name */
        public PersistedInstallation.RegistrationStatus f44605b;

        /* renamed from: c, reason: collision with root package name */
        public String f44606c;

        /* renamed from: d, reason: collision with root package name */
        public String f44607d;

        /* renamed from: e, reason: collision with root package name */
        public Long f44608e;

        /* renamed from: f, reason: collision with root package name */
        public Long f44609f;

        /* renamed from: g, reason: collision with root package name */
        public String f44610g;

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry a() {
            String strK = this.f44605b == null ? " registrationStatus" : "";
            if (this.f44608e == null) {
                strK = strK.concat(" expiresInSecs");
            }
            if (this.f44609f == null) {
                strK = b.k(strK, " tokenCreationEpochInSecs");
            }
            if (strK.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.f44604a, this.f44605b, this.f44606c, this.f44607d, this.f44608e.longValue(), this.f44609f.longValue(), this.f44610g);
            }
            throw new IllegalStateException("Missing required properties:".concat(strK));
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry.Builder b(String str) {
            this.f44606c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry.Builder c(long j2) {
            this.f44608e = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry.Builder d(String str) {
            this.f44604a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry.Builder e(String str) {
            this.f44607d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry.Builder f(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f44605b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public final PersistedInstallationEntry.Builder g(long j2) {
            this.f44609f = Long.valueOf(j2);
            return this;
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j2, long j3, String str4) {
        this.f44597b = str;
        this.f44598c = registrationStatus;
        this.f44599d = str2;
        this.f44600e = str3;
        this.f44601f = j2;
        this.f44602g = j3;
        this.f44603h = str4;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String a() {
        return this.f44599d;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final long b() {
        return this.f44601f;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String c() {
        return this.f44597b;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String d() {
        return this.f44603h;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String e() {
        return this.f44600e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str = this.f44597b;
        if (str == null) {
            if (persistedInstallationEntry.c() != null) {
                return false;
            }
        } else if (!str.equals(persistedInstallationEntry.c())) {
            return false;
        }
        if (!this.f44598c.equals(persistedInstallationEntry.f())) {
            return false;
        }
        String str2 = this.f44599d;
        if (str2 == null) {
            if (persistedInstallationEntry.a() != null) {
                return false;
            }
        } else if (!str2.equals(persistedInstallationEntry.a())) {
            return false;
        }
        String str3 = this.f44600e;
        if (str3 == null) {
            if (persistedInstallationEntry.e() != null) {
                return false;
            }
        } else if (!str3.equals(persistedInstallationEntry.e())) {
            return false;
        }
        if (this.f44601f != persistedInstallationEntry.b() || this.f44602g != persistedInstallationEntry.g()) {
            return false;
        }
        String str4 = this.f44603h;
        return str4 == null ? persistedInstallationEntry.d() == null : str4.equals(persistedInstallationEntry.d());
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final PersistedInstallation.RegistrationStatus f() {
        return this.f44598c;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final long g() {
        return this.f44602g;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final PersistedInstallationEntry.Builder h() {
        Builder builder = new Builder();
        builder.f44604a = c();
        builder.f44605b = f();
        builder.f44606c = a();
        builder.f44607d = e();
        builder.f44608e = Long.valueOf(b());
        builder.f44609f = Long.valueOf(g());
        builder.f44610g = d();
        return builder;
    }

    public final int hashCode() {
        String str = this.f44597b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f44598c.hashCode()) * 1000003;
        String str2 = this.f44599d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f44600e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j2 = this.f44601f;
        int i2 = (iHashCode3 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f44602g;
        int i3 = (i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str4 = this.f44603h;
        return (str4 != null ? str4.hashCode() : 0) ^ i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f44597b);
        sb.append(", registrationStatus=");
        sb.append(this.f44598c);
        sb.append(", authToken=");
        sb.append(this.f44599d);
        sb.append(", refreshToken=");
        sb.append(this.f44600e);
        sb.append(", expiresInSecs=");
        sb.append(this.f44601f);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f44602g);
        sb.append(", fisError=");
        return b.r(sb, this.f44603h, "}");
    }
}
