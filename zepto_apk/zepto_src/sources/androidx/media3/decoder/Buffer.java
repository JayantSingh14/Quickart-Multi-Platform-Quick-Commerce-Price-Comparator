package androidx.media3.decoder;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class Buffer {

    /* renamed from: a, reason: collision with root package name */
    public int f6056a;

    public final void e(int i2) {
        this.f6056a = i2 | this.f6056a;
    }

    public final boolean g(int i2) {
        return (this.f6056a & i2) == i2;
    }
}
