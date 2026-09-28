package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4727a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4728b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f4727a = i2;
        this.f4728b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4727a) {
            case 0:
                DefaultSpecialEffectsController.TransitionEffect this$0 = (DefaultSpecialEffectsController.TransitionEffect) this.f4728b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (FragmentManager.O(2)) {
                    Log.v("FragmentManager", "Transition for all operations has completed");
                }
                Iterator it = this$0.f4481c.iterator();
                while (it.hasNext()) {
                    ((DefaultSpecialEffectsController.TransitionInfo) it.next()).f4480a.c(this$0);
                }
                break;
            case 1:
                Ref.ObjectRef seekCancelLambda = (Ref.ObjectRef) this.f4728b;
                Intrinsics.checkNotNullParameter(seekCancelLambda, "$seekCancelLambda");
                Function0 function0 = (Function0) seekCancelLambda.f53801a;
                if (function0 != null) {
                    function0.invoke();
                    break;
                }
                break;
            case 2:
                ArrayList transitioningViews = (ArrayList) this.f4728b;
                Intrinsics.checkNotNullParameter(transitioningViews, "$transitioningViews");
                FragmentTransition.d(4, transitioningViews);
                break;
            default:
                Iterator it2 = ((FragmentManager) this.f4728b).o.iterator();
                while (it2.hasNext()) {
                    ((FragmentManager.OnBackStackChangedListener) it2.next()).getClass();
                }
                break;
        }
    }
}
