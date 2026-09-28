package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.a;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class ConstraintTracker<T> {

    /* renamed from: a, reason: collision with root package name */
    public final WorkManagerTaskExecutor f12836a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12837b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12838c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f12839d;

    /* renamed from: e, reason: collision with root package name */
    public Object f12840e;

    public ConstraintTracker(Context context, WorkManagerTaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f12836a = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f12837b = applicationContext;
        this.f12838c = new Object();
        this.f12839d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.f12838c) {
            Object obj2 = this.f12840e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.f12840e = obj;
                this.f12836a.f13064d.execute(new a(13, CollectionsKt.e0(this.f12839d), this));
                Unit unit = Unit.f53572a;
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
