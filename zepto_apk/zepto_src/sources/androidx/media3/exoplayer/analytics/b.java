package androidx.media3.exoplayer.analytics;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements ListenerSet.Event, AccessibilityViewCommand {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6445a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6446b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6447c;

    public /* synthetic */ b(int i2, int i3, Object obj) {
        this.f6445a = i3;
        this.f6446b = obj;
        this.f6447c = i2;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean c(View view) {
        int i2 = SideSheetBehavior.x;
        ((SideSheetBehavior) this.f6446b).f(this.f6447c);
        return true;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        switch (this.f6445a) {
            case 0:
                analyticsListener.I((AnalyticsListener.EventTime) this.f6446b, this.f6447c);
                break;
            case 1:
                AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) this.f6446b;
                analyticsListener.getClass();
                analyticsListener.u(eventTime, this.f6447c);
                break;
            case 2:
                analyticsListener.q((AnalyticsListener.EventTime) this.f6446b, this.f6447c);
                break;
            case 3:
                analyticsListener.s((AnalyticsListener.EventTime) this.f6446b, this.f6447c);
                break;
            case 4:
                analyticsListener.F((AnalyticsListener.EventTime) this.f6446b, this.f6447c);
                break;
            case 5:
                analyticsListener.x((AnalyticsListener.EventTime) this.f6446b, this.f6447c);
                break;
            default:
                analyticsListener.M((AnalyticsListener.EventTime) this.f6446b, this.f6447c);
                break;
        }
    }

    public /* synthetic */ b(int i2, long j2, AnalyticsListener.EventTime eventTime) {
        this.f6445a = 0;
        this.f6446b = eventTime;
        this.f6447c = i2;
    }

    public /* synthetic */ b(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        this.f6445a = 3;
        this.f6446b = eventTime;
        this.f6447c = i2;
    }
}
