package com.google.firebase.installations.local;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

@AutoValue
/* loaded from: classes.dex */
public abstract class PersistedInstallationEntry {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44622a = 0;

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract PersistedInstallationEntry a();

        public abstract Builder b(String str);

        public abstract Builder c(long j2);

        public abstract Builder d(String str);

        public abstract Builder e(String str);

        public abstract Builder f(PersistedInstallation.RegistrationStatus registrationStatus);

        public abstract Builder g(long j2);
    }

    static {
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        builder.f44609f = 0L;
        builder.f44605b = PersistedInstallation.RegistrationStatus.f44616a;
        builder.f44608e = 0L;
        builder.a();
    }

    public abstract String a();

    public abstract long b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract PersistedInstallation.RegistrationStatus f();

    public abstract long g();

    public abstract Builder h();

    public final PersistedInstallationEntry i() {
        AutoValue_PersistedInstallationEntry.Builder builder = (AutoValue_PersistedInstallationEntry.Builder) h();
        builder.f44610g = "BAD CONFIG";
        builder.f44605b = PersistedInstallation.RegistrationStatus.f44620e;
        return builder.a();
    }
}
