package io.sentry.android.replay;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReplayFrame {

    /* renamed from: a, reason: collision with root package name */
    public final File f52432a;

    /* renamed from: b, reason: collision with root package name */
    public final long f52433b;

    /* renamed from: c, reason: collision with root package name */
    public final String f52434c;

    public ReplayFrame(File screenshot, long j2, String str) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        this.f52432a = screenshot;
        this.f52433b = j2;
        this.f52434c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplayFrame)) {
            return false;
        }
        ReplayFrame replayFrame = (ReplayFrame) obj;
        return Intrinsics.b(this.f52432a, replayFrame.f52432a) && this.f52433b == replayFrame.f52433b && Intrinsics.b(this.f52434c, replayFrame.f52434c);
    }

    public final int hashCode() {
        int iD = android.support.v4.media.a.d(this.f52432a.hashCode() * 31, 31, this.f52433b);
        String str = this.f52434c;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ReplayFrame(screenshot=");
        sb.append(this.f52432a);
        sb.append(", timestamp=");
        sb.append(this.f52433b);
        sb.append(", screen=");
        return androidx.fragment.app.e.t(sb, this.f52434c, ')');
    }
}
