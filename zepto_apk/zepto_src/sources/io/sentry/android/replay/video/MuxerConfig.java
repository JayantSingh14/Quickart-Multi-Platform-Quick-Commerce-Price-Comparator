package io.sentry.android.replay.video;

import android.annotation.TargetApi;
import android.support.v4.media.a;
import android.support.v4.media.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@TargetApi(24)
/* loaded from: classes3.dex */
public final class MuxerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final File f52633a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52634b;

    /* renamed from: c, reason: collision with root package name */
    public final int f52635c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52636d;

    /* renamed from: e, reason: collision with root package name */
    public final int f52637e;

    public MuxerConfig(File file, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter("video/avc", "mimeType");
        this.f52633a = file;
        this.f52634b = i2;
        this.f52635c = i3;
        this.f52636d = i4;
        this.f52637e = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MuxerConfig)) {
            return false;
        }
        MuxerConfig muxerConfig = (MuxerConfig) obj;
        return this.f52633a.equals(muxerConfig.f52633a) && this.f52634b == muxerConfig.f52634b && this.f52635c == muxerConfig.f52635c && this.f52636d == muxerConfig.f52636d && this.f52637e == muxerConfig.f52637e;
    }

    public final int hashCode() {
        return ((Integer.hashCode(this.f52637e) + a.b(this.f52636d, a.b(this.f52635c, a.b(this.f52634b, this.f52633a.hashCode() * 31, 31), 31), 31)) * 31) + 1331836730;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MuxerConfig(file=");
        sb.append(this.f52633a);
        sb.append(", recordingWidth=");
        sb.append(this.f52634b);
        sb.append(", recordingHeight=");
        sb.append(this.f52635c);
        sb.append(", frameRate=");
        sb.append(this.f52636d);
        sb.append(", bitRate=");
        return b.o(sb, this.f52637e, ", mimeType=video/avc)");
    }
}
