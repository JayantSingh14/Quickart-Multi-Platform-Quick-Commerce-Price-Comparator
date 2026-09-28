package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class UtcTimingElement {

    /* renamed from: a, reason: collision with root package name */
    public final String f6869a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6870b;

    public UtcTimingElement(String str, String str2) {
        this.f6869a = str;
        this.f6870b = str2;
    }

    public final String toString() {
        return this.f6869a + ", " + this.f6870b;
    }
}
