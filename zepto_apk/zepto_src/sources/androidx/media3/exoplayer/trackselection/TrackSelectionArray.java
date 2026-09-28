package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class TrackSelectionArray {

    /* renamed from: a, reason: collision with root package name */
    public final TrackSelection[] f8035a;

    /* renamed from: b, reason: collision with root package name */
    public int f8036b;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.f8035a = trackSelectionArr;
        int length = trackSelectionArr.length;
    }

    public final TrackSelection a(int i2) {
        return this.f8035a[i2];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f8035a, ((TrackSelectionArray) obj).f8035a);
    }

    public final int hashCode() {
        if (this.f8036b == 0) {
            this.f8036b = 527 + Arrays.hashCode(this.f8035a);
        }
        return this.f8036b;
    }
}
