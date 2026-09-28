package io.sentry.android.replay.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.transport.CurrentDateProvider;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@StabilityInferred(parameters = 0)
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReplayGestureConverter {

    /* renamed from: a, reason: collision with root package name */
    public final CurrentDateProvider f52622a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f52623b;

    /* renamed from: c, reason: collision with root package name */
    public long f52624c;

    /* renamed from: d, reason: collision with root package name */
    public long f52625d;

    @Metadata
    public static final class Companion {
    }

    public ReplayGestureConverter(CurrentDateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.f52622a = dateProvider;
        this.f52623b = new LinkedHashMap(10);
    }
}
