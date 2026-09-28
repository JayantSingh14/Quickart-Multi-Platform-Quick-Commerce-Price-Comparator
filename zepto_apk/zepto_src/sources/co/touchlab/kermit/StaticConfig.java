package co.touchlab.kermit;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class StaticConfig implements LoggerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final Severity f13853a;

    /* renamed from: b, reason: collision with root package name */
    public final List f13854b;

    public StaticConfig(Severity minSeverity, List logWriterList) {
        Intrinsics.checkNotNullParameter(minSeverity, "minSeverity");
        Intrinsics.checkNotNullParameter(logWriterList, "logWriterList");
        this.f13853a = minSeverity;
        this.f13854b = logWriterList;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public final Severity a() {
        return this.f13853a;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public final List b() {
        return this.f13854b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StaticConfig)) {
            return false;
        }
        StaticConfig staticConfig = (StaticConfig) obj;
        return this.f13853a == staticConfig.f13853a && Intrinsics.b(this.f13854b, staticConfig.f13854b);
    }

    public final int hashCode() {
        return this.f13854b.hashCode() + (this.f13853a.hashCode() * 31);
    }

    public final String toString() {
        return "StaticConfig(minSeverity=" + this.f13853a + ", logWriterList=" + this.f13854b + ')';
    }

    public StaticConfig() {
        this(BaseLoggerKt.f13841a, CollectionsKt.H(new CommonWriter(0)));
    }
}
