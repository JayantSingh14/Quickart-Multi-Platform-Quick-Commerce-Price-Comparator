package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.extractor.Extractor;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Consumer, Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7920a;

    public /* synthetic */ l(int i2) {
        this.f7920a = i2;
    }

    private final void a(Object obj) {
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        switch (this.f7920a) {
            case 0:
                ((SampleQueue.SharedSampleMetadata) obj).f7709b.release();
                break;
        }
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        switch (this.f7920a) {
            case 1:
                return ((Extractor) obj).e().getClass().getSimpleName();
            case 2:
                return ImmutableList.o(Lists.d(new l(4), ((MediaPeriod) obj).p().f7772b));
            default:
                TrackGroupArray trackGroupArray = TrackGroupArray.f7769d;
                return Integer.valueOf(((TrackGroup) obj).f5503c);
        }
    }
}
