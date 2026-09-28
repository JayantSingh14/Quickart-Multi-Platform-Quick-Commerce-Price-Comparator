package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class RendererConfiguration {

    /* renamed from: c, reason: collision with root package name */
    public static final RendererConfiguration f6356c = new RendererConfiguration(0, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f6357a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6358b;

    public RendererConfiguration(int i2, boolean z) {
        this.f6357a = i2;
        this.f6358b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RendererConfiguration.class == obj.getClass()) {
            RendererConfiguration rendererConfiguration = (RendererConfiguration) obj;
            if (this.f6357a == rendererConfiguration.f6357a && this.f6358b == rendererConfiguration.f6358b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f6357a << 1) + (this.f6358b ? 1 : 0);
    }
}
