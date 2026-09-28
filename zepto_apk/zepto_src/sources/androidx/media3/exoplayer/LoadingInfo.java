package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class LoadingInfo {

    /* renamed from: a, reason: collision with root package name */
    public final long f6261a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6262b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6263c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f6264a = -9223372036854775807L;

        /* renamed from: b, reason: collision with root package name */
        public float f6265b = -3.4028235E38f;

        /* renamed from: c, reason: collision with root package name */
        public long f6266c = -9223372036854775807L;
    }

    public LoadingInfo(Builder builder) {
        this.f6261a = builder.f6264a;
        this.f6262b = builder.f6265b;
        this.f6263c = builder.f6266c;
    }

    public final boolean a(long j2) {
        long j3 = this.f6263c;
        return (j3 == -9223372036854775807L || j2 == -9223372036854775807L || j3 < j2) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadingInfo)) {
            return false;
        }
        LoadingInfo loadingInfo = (LoadingInfo) obj;
        return this.f6261a == loadingInfo.f6261a && this.f6262b == loadingInfo.f6262b && this.f6263c == loadingInfo.f6263c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f6261a), Float.valueOf(this.f6262b), Long.valueOf(this.f6263c)});
    }
}
