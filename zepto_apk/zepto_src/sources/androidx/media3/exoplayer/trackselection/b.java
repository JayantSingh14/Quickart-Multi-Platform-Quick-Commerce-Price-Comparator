package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8045a;

    public /* synthetic */ b(int i2) {
        this.f8045a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i2 = 5;
        int i3 = 4;
        ComparisonChain comparisonChainC = ComparisonChain.f42583a;
        switch (this.f8045a) {
            case 0:
                return Integer.compare(((DefaultTrackSelector.ImageTrackInfo) ((List) obj).get(0)).f7992f, ((DefaultTrackSelector.ImageTrackInfo) ((List) obj2).get(0)).f7992f);
            case 1:
                return ((DefaultTrackSelector.AudioTrackInfo) Collections.max((List) obj)).c((DefaultTrackSelector.AudioTrackInfo) Collections.max((List) obj2));
            case 2:
                List list = (List) obj;
                List list2 = (List) obj2;
                return comparisonChainC.c((DefaultTrackSelector.VideoTrackInfo) Collections.max(list, new b(i3)), (DefaultTrackSelector.VideoTrackInfo) Collections.max(list2, new b(i3)), new b(i3)).a(list.size(), list2.size()).c((DefaultTrackSelector.VideoTrackInfo) Collections.max(list, new b(i2)), (DefaultTrackSelector.VideoTrackInfo) Collections.max(list2, new b(i2)), new b(i2)).f();
            case 3:
                return ((DefaultTrackSelector.TextTrackInfo) ((List) obj).get(0)).c((DefaultTrackSelector.TextTrackInfo) ((List) obj2).get(0));
            case 4:
                DefaultTrackSelector.VideoTrackInfo videoTrackInfo = (DefaultTrackSelector.VideoTrackInfo) obj;
                DefaultTrackSelector.VideoTrackInfo videoTrackInfo2 = (DefaultTrackSelector.VideoTrackInfo) obj2;
                ComparisonChain comparisonChainC2 = comparisonChainC.d(videoTrackInfo.f8019h, videoTrackInfo2.f8019h).a(videoTrackInfo.f8024m, videoTrackInfo2.f8024m).d(videoTrackInfo.n, videoTrackInfo2.n).d(videoTrackInfo.f8020i, videoTrackInfo2.f8020i).d(videoTrackInfo.f8016e, videoTrackInfo2.f8016e).d(videoTrackInfo.f8018g, videoTrackInfo2.f8018g).c(Integer.valueOf(videoTrackInfo.f8023l), Integer.valueOf(videoTrackInfo2.f8023l), Ordering.c().g());
                boolean z = videoTrackInfo2.q;
                boolean z2 = videoTrackInfo.q;
                ComparisonChain comparisonChainD = comparisonChainC2.d(z2, z);
                boolean z3 = videoTrackInfo2.r;
                boolean z4 = videoTrackInfo.r;
                ComparisonChain comparisonChainD2 = comparisonChainD.d(z4, z3);
                if (z2 && z4) {
                    comparisonChainD2 = comparisonChainD2.a(videoTrackInfo.s, videoTrackInfo2.s);
                }
                return comparisonChainD2.f();
            case 5:
                DefaultTrackSelector.VideoTrackInfo videoTrackInfo3 = (DefaultTrackSelector.VideoTrackInfo) obj;
                DefaultTrackSelector.VideoTrackInfo videoTrackInfo4 = (DefaultTrackSelector.VideoTrackInfo) obj2;
                Ordering orderingG = (videoTrackInfo3.f8016e && videoTrackInfo3.f8019h) ? DefaultTrackSelector.f7974k : DefaultTrackSelector.f7974k.g();
                boolean z5 = videoTrackInfo3.f8017f.y;
                int i4 = videoTrackInfo3.f8021j;
                if (z5) {
                    comparisonChainC = comparisonChainC.c(Integer.valueOf(i4), Integer.valueOf(videoTrackInfo4.f8021j), DefaultTrackSelector.f7974k.g());
                }
                return comparisonChainC.c(Integer.valueOf(videoTrackInfo3.f8022k), Integer.valueOf(videoTrackInfo4.f8022k), orderingG).c(Integer.valueOf(i4), Integer.valueOf(videoTrackInfo4.f8021j), orderingG).f();
            case 6:
                return ((Format) obj2).f5221i - ((Format) obj).f5221i;
            default:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                Ordering ordering = DefaultTrackSelector.f7974k;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
        }
    }
}
