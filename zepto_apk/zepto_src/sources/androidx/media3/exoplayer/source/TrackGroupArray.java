package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;

@UnstableApi
/* loaded from: classes3.dex */
public final class TrackGroupArray {

    /* renamed from: d, reason: collision with root package name */
    public static final TrackGroupArray f7769d = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: e, reason: collision with root package name */
    public static final String f7770e;

    /* renamed from: a, reason: collision with root package name */
    public final int f7771a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList f7772b;

    /* renamed from: c, reason: collision with root package name */
    public int f7773c;

    static {
        int i2 = Util.f5744a;
        f7770e = Integer.toString(0, 36);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f7772b = ImmutableList.p(trackGroupArr);
        this.f7771a = trackGroupArr.length;
        int i2 = 0;
        while (true) {
            ImmutableList immutableList = this.f7772b;
            if (i2 >= immutableList.size()) {
                return;
            }
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < immutableList.size(); i4++) {
                if (((TrackGroup) immutableList.get(i2)).equals(immutableList.get(i4))) {
                    Log.e("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TrackGroup a(int i2) {
        return (TrackGroup) this.f7772b.get(i2);
    }

    public final int b(TrackGroup trackGroup) {
        int iIndexOf = this.f7772b.indexOf(trackGroup);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroupArray.class == obj.getClass()) {
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            if (this.f7771a == trackGroupArray.f7771a && this.f7772b.equals(trackGroupArray.f7772b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f7773c == 0) {
            this.f7773c = this.f7772b.hashCode();
        }
        return this.f7773c;
    }
}
