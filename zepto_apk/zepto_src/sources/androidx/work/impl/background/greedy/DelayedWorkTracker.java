package androidx.work.impl.background.greedy;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.SystemClock;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.HashMap;

@RestrictTo
/* loaded from: classes.dex */
public class DelayedWorkTracker {

    /* renamed from: e, reason: collision with root package name */
    public static final String f12698e = Logger.g("DelayedWorkTracker");

    /* renamed from: a, reason: collision with root package name */
    public final GreedyScheduler f12699a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultRunnableScheduler f12700b;

    /* renamed from: c, reason: collision with root package name */
    public final SystemClock f12701c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f12702d = new HashMap();

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, DefaultRunnableScheduler defaultRunnableScheduler, SystemClock systemClock) {
        this.f12699a = greedyScheduler;
        this.f12700b = defaultRunnableScheduler;
        this.f12701c = systemClock;
    }
}
