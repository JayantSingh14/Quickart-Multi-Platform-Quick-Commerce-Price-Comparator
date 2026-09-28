package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4720a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4721b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4722c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4723d;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i2) {
        this.f4720a = i2;
        this.f4721b = obj;
        this.f4722c = obj2;
        this.f4723d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4720a) {
            case 0:
                ViewGroup container = (ViewGroup) this.f4721b;
                Intrinsics.checkNotNullParameter(container, "$container");
                DefaultSpecialEffectsController.AnimationEffect this$0 = (DefaultSpecialEffectsController.AnimationEffect) this.f4723d;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                container.endViewTransition((View) this.f4722c);
                this$0.f4463c.f4480a.c(this$0);
                break;
            case 1:
                DefaultSpecialEffectsController.TransitionEffect this$02 = (DefaultSpecialEffectsController.TransitionEffect) this.f4723d;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                FragmentTransition.a(((SpecialEffectsController.Operation) this.f4721b).f4701c, ((SpecialEffectsController.Operation) this.f4722c).f4701c, this$02.o, this$02.n);
                break;
            default:
                FragmentTransitionImpl impl = (FragmentTransitionImpl) this.f4721b;
                Intrinsics.checkNotNullParameter(impl, "$impl");
                Rect lastInEpicenterRect = (Rect) this.f4723d;
                Intrinsics.checkNotNullParameter(lastInEpicenterRect, "$lastInEpicenterRect");
                View view = (View) this.f4722c;
                impl.getClass();
                FragmentTransitionImpl.j(lastInEpicenterRect, view);
                break;
        }
    }
}
