package io.sentry.android.core.performance;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class ActivityLifecycleTimeSpan implements Comparable<ActivityLifecycleTimeSpan> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeSpan f52365a = new TimeSpan();

    /* renamed from: b, reason: collision with root package name */
    public final TimeSpan f52366b = new TimeSpan();

    @Override // java.lang.Comparable
    public final int compareTo(ActivityLifecycleTimeSpan activityLifecycleTimeSpan) {
        ActivityLifecycleTimeSpan activityLifecycleTimeSpan2 = activityLifecycleTimeSpan;
        int iCompare = Long.compare(this.f52365a.f52382c, activityLifecycleTimeSpan2.f52365a.f52382c);
        return iCompare == 0 ? Long.compare(this.f52366b.f52382c, activityLifecycleTimeSpan2.f52366b.f52382c) : iCompare;
    }
}
