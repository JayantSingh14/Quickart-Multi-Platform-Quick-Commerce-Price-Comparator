package io.sentry.metrics;

import java.nio.charset.Charset;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class EncodedMetrics {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f52779b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f52780a;

    public EncodedMetrics(HashMap map) {
        this.f52780a = map;
    }
}
