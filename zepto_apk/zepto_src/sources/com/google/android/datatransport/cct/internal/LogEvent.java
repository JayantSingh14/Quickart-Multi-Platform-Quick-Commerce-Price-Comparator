package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class LogEvent {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract LogEvent a();

        public abstract Builder b(ComplianceData complianceData);

        public abstract Builder c(Integer num);

        public abstract Builder d(long j2);

        public abstract Builder e(long j2);

        public abstract Builder f(ExperimentIds experimentIds);

        public abstract Builder g(NetworkConnectionInfo networkConnectionInfo);

        public abstract Builder h(long j2);
    }

    public static Builder j(String str) {
        AutoValue_LogEvent.Builder builder = new AutoValue_LogEvent.Builder();
        builder.f20643f = str;
        return builder;
    }

    public static Builder k(byte[] bArr) {
        AutoValue_LogEvent.Builder builder = new AutoValue_LogEvent.Builder();
        builder.f20642e = bArr;
        return builder;
    }

    public abstract ComplianceData a();

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract ExperimentIds e();

    public abstract NetworkConnectionInfo f();

    public abstract byte[] g();

    public abstract String h();

    public abstract long i();
}
