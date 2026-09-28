package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.SystemClock;
import androidx.work.impl.constraints.WorkConstraintsTracker;

@RestrictTo
/* loaded from: classes3.dex */
class ConstraintsCommandHandler {

    /* renamed from: e, reason: collision with root package name */
    public static final String f12737e = Logger.g("ConstraintsCmdHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12738a;

    /* renamed from: b, reason: collision with root package name */
    public final SystemClock f12739b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12740c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkConstraintsTracker f12741d;

    public ConstraintsCommandHandler(Context context, SystemClock systemClock, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f12738a = context;
        this.f12739b = systemClock;
        this.f12740c = i2;
        this.f12741d = new WorkConstraintsTracker(systemAlarmDispatcher.f12761e.f12662j);
    }
}
