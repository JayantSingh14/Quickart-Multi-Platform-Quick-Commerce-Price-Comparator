package io.ktor.util.converters;

import io.ktor.util.KtorDsl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DataConversion implements ConversionService {

    /* renamed from: a, reason: collision with root package name */
    public final Map f50532a;

    @KtorDsl
    @Metadata
    public static final class Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f50533a = new LinkedHashMap();
    }

    public DataConversion(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f50532a = MapsKt.l(configuration.f50533a);
    }
}
