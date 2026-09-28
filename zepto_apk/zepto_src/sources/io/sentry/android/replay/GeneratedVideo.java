package io.sentry.android.replay;

import androidx.compose.runtime.internal.StabilityInferred;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StabilityInferred(parameters = 0)
@Metadata
/* loaded from: classes3.dex */
public final class GeneratedVideo {

    /* renamed from: a, reason: collision with root package name */
    public final File f52406a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52407b;

    /* renamed from: c, reason: collision with root package name */
    public final long f52408c;

    public GeneratedVideo(File video, int i2, long j2) {
        Intrinsics.checkNotNullParameter(video, "video");
        this.f52406a = video;
        this.f52407b = i2;
        this.f52408c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeneratedVideo)) {
            return false;
        }
        GeneratedVideo generatedVideo = (GeneratedVideo) obj;
        return Intrinsics.b(this.f52406a, generatedVideo.f52406a) && this.f52407b == generatedVideo.f52407b && this.f52408c == generatedVideo.f52408c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f52408c) + android.support.v4.media.a.b(this.f52407b, this.f52406a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "GeneratedVideo(video=" + this.f52406a + ", frameCount=" + this.f52407b + ", duration=" + this.f52408c + ')';
    }
}
