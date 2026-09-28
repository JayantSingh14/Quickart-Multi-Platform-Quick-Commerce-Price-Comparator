package co.touchlab.kermit;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class JvmMutableLoggerConfig implements MutableLoggerConfig {

    /* renamed from: a, reason: collision with root package name */
    public volatile Severity f13844a;

    /* renamed from: b, reason: collision with root package name */
    public volatile List f13845b;

    @Override // co.touchlab.kermit.LoggerConfig
    public final Severity a() {
        return this.f13844a;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public final List b() {
        return this.f13845b;
    }
}
