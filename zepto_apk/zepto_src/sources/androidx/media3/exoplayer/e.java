package androidx.media3.exoplayer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.MediaPeriodHolder;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements ListenerSet.Event, MediaPeriodHolder.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6956a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6957b;

    public /* synthetic */ e(Object obj, int i2) {
        this.f6956a = i2;
        this.f6957b = obj;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Object obj2 = this.f6957b;
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f6956a) {
            case 0:
                int i2 = ExoPlayerImpl.n0;
                listener.o1((MediaMetadata) obj2);
                break;
            case 1:
                int i3 = ExoPlayerImpl.n0;
                listener.A1((AudioAttributes) obj2);
                break;
            case 2:
                int i4 = ExoPlayerImpl.n0;
                listener.p1((TrackSelectionParameters) obj2);
                break;
            case 3:
                listener.o1(ExoPlayerImpl.this.M);
                break;
            case 4:
            default:
                listener.b((VideoSize) obj2);
                break;
            case 5:
                listener.e1((CueGroup) obj2);
                break;
            case 6:
                listener.f1((Metadata) obj2);
                break;
            case 7:
                listener.k((List) obj2);
                break;
        }
    }
}
