package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4724a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4725b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f4726c;

    public /* synthetic */ b(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
        this.f4724a = 2;
        this.f4726c = transitionEffect;
        this.f4725b = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4724a) {
            case 0:
                SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) this.f4725b;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                DefaultSpecialEffectsController.TransitionEffect this$0 = this.f4726c;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (FragmentManager.O(2)) {
                    Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
                }
                operation.c(this$0);
                break;
            case 1:
                SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) this.f4725b;
                Intrinsics.checkNotNullParameter(operation2, "$operation");
                DefaultSpecialEffectsController.TransitionEffect this$02 = this.f4726c;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                if (FragmentManager.O(2)) {
                    Log.v("FragmentManager", "Transition for operation " + operation2 + " has completed");
                }
                operation2.c(this$02);
                break;
            default:
                DefaultSpecialEffectsController.TransitionEffect this$03 = this.f4726c;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                ViewGroup container = (ViewGroup) this.f4725b;
                Intrinsics.checkNotNullParameter(container, "$container");
                Iterator it = this$03.f4481c.iterator();
                while (it.hasNext()) {
                    SpecialEffectsController.Operation operation3 = ((DefaultSpecialEffectsController.TransitionInfo) it.next()).f4480a;
                    View view = operation3.f4701c.getView();
                    if (view != null) {
                        operation3.f4699a.a(view, container);
                    }
                }
                break;
        }
    }

    public /* synthetic */ b(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect, int i2) {
        this.f4724a = i2;
        this.f4725b = operation;
        this.f4726c = transitionEffect;
    }
}
