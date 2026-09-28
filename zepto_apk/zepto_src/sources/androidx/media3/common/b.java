package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheKeyFactory;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.common.base.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function, SimpleBasePlayer.PositionSupplier, CacheKeyFactory, ListenerSet.Event, ListenerSet.IterationFinishedEvent {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5611a;

    public /* synthetic */ b(int i2) {
        this.f5611a = i2;
    }

    @Override // androidx.media3.datasource.cache.CacheKeyFactory
    public String a(DataSpec dataSpec) {
        String str = dataSpec.f5858h;
        return str != null ? str : dataSpec.f5851a.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x036a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0368  */
    @Override // com.google.common.base.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r52) {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.b.apply(java.lang.Object):java.lang.Object");
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void c(Object obj, FlagSet flagSet) {
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f5611a) {
            case 10:
                analyticsListener.getClass();
                break;
            case 11:
                analyticsListener.getClass();
                break;
            case 12:
                analyticsListener.getClass();
                break;
            case 13:
                analyticsListener.getClass();
                break;
            case 14:
                analyticsListener.getClass();
                break;
            case 15:
                analyticsListener.getClass();
                break;
            case 16:
                analyticsListener.getClass();
                break;
            case 17:
                analyticsListener.getClass();
                break;
            case 18:
                analyticsListener.getClass();
                break;
            case 19:
                analyticsListener.getClass();
                break;
            case 20:
                analyticsListener.getClass();
                break;
            case 21:
                analyticsListener.getClass();
                break;
            case 22:
                analyticsListener.getClass();
                break;
            case 23:
                analyticsListener.getClass();
                break;
            case 24:
                analyticsListener.getClass();
                break;
            case 25:
                analyticsListener.getClass();
                break;
            case 26:
                analyticsListener.getClass();
                break;
            case 27:
                analyticsListener.getClass();
                break;
            default:
                analyticsListener.getClass();
                break;
        }
    }

    public /* synthetic */ b(AnalyticsListener.EventTime eventTime, int i2) {
        this.f5611a = i2;
    }
}
