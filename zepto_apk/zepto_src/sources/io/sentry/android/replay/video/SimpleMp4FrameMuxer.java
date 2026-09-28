package io.sentry.android.replay.video;

import android.media.MediaMuxer;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StabilityInferred(parameters = 0)
@Metadata
/* loaded from: classes3.dex */
public final class SimpleMp4FrameMuxer implements SimpleFrameMuxer {

    /* renamed from: a, reason: collision with root package name */
    public final long f52638a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaMuxer f52639b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f52640c;

    /* renamed from: d, reason: collision with root package name */
    public int f52641d;

    /* renamed from: e, reason: collision with root package name */
    public int f52642e;

    /* renamed from: f, reason: collision with root package name */
    public long f52643f;

    public SimpleMp4FrameMuxer(String path, float f2) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f52638a = (long) (TimeUnit.SECONDS.toMicros(1L) / f2);
        this.f52639b = new MediaMuxer(path, 0);
    }
}
