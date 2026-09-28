package androidx.media3.common;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class TrackSelectionOverride {

    /* renamed from: c, reason: collision with root package name */
    public static final String f5506c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5507d;

    /* renamed from: a, reason: collision with root package name */
    public final TrackGroup f5508a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList f5509b;

    static {
        int i2 = Util.f5744a;
        f5506c = Integer.toString(0, 36);
        f5507d = Integer.toString(1, 36);
    }

    public TrackSelectionOverride(TrackGroup trackGroup, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.f5501a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f5508a = trackGroup;
        this.f5509b = ImmutableList.o(list);
    }

    public final int a() {
        return this.f5508a.f5503c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackSelectionOverride.class == obj.getClass()) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
            if (this.f5508a.equals(trackSelectionOverride.f5508a) && this.f5509b.equals(trackSelectionOverride.f5509b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f5509b.hashCode() * 31) + this.f5508a.hashCode();
    }
}
