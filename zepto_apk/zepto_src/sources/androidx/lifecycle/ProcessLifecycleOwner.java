package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ProcessLifecycleOwner implements LifecycleOwner {

    /* renamed from: i, reason: collision with root package name */
    public static final ProcessLifecycleOwner f4856i = new ProcessLifecycleOwner();

    /* renamed from: a, reason: collision with root package name */
    public int f4857a;

    /* renamed from: b, reason: collision with root package name */
    public int f4858b;

    /* renamed from: e, reason: collision with root package name */
    public Handler f4861e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4859c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4860d = true;

    /* renamed from: f, reason: collision with root package name */
    public final LifecycleRegistry f4862f = new LifecycleRegistry(this);

    /* renamed from: g, reason: collision with root package name */
    public final a f4863g = new a(this, 0);

    /* renamed from: h, reason: collision with root package name */
    public final ProcessLifecycleOwner$initializationListener$1 f4864h = new ProcessLifecycleOwner$initializationListener$1(this);

    @RequiresApi
    @Metadata
    public static final class Api29Impl {
        @JvmStatic
        @DoNotInline
        public static final void a(@NotNull Activity activity, @NotNull Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    @Metadata
    public static final class Companion {
    }

    private ProcessLifecycleOwner() {
    }

    public final void a() {
        int i2 = this.f4858b + 1;
        this.f4858b = i2;
        if (i2 == 1) {
            if (this.f4859c) {
                this.f4862f.f(Lifecycle.Event.ON_RESUME);
                this.f4859c = false;
            } else {
                Handler handler = this.f4861e;
                Intrinsics.c(handler);
                handler.removeCallbacks(this.f4863g);
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f4862f;
    }
}
