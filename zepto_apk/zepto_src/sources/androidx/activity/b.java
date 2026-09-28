package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f182b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f181a = i2;
        this.f182b = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Window window;
        View viewPeekDecorView;
        Object obj = this.f182b;
        switch (this.f181a) {
            case 0:
                int i2 = ComponentActivity.f122h;
                ComponentActivity this$0 = (ComponentActivity) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_STOP && (window = this$0.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                ComponentActivity.b((ComponentActivity) obj, lifecycleOwner, event);
                break;
            default:
                SavedStateRegistry this$02 = (SavedStateRegistry) obj;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event != Lifecycle.Event.ON_START) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        this$02.f11890f = false;
                        break;
                    }
                } else {
                    this$02.f11890f = true;
                    break;
                }
                break;
        }
    }
}
