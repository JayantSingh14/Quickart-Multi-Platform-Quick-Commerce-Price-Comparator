package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4737a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController f4738b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f4739c;

    public /* synthetic */ j(SpecialEffectsController specialEffectsController, SpecialEffectsController.Operation operation, int i2) {
        this.f4737a = i2;
        this.f4738b = specialEffectsController;
        this.f4739c = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4737a) {
            case 0:
                SpecialEffectsController this$0 = this.f4738b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                SpecialEffectsController.FragmentStateManagerOperation operation = (SpecialEffectsController.FragmentStateManagerOperation) this.f4739c;
                Intrinsics.checkNotNullParameter(operation, "$operation");
                if (this$0.f4691b.contains(operation)) {
                    SpecialEffectsController.Operation.State state = operation.f4699a;
                    View view = operation.f4701c.mView;
                    Intrinsics.checkNotNullExpressionValue(view, "operation.fragment.mView");
                    state.a(view, this$0.f4690a);
                    break;
                }
                break;
            case 1:
                SpecialEffectsController this$02 = this.f4738b;
                Intrinsics.checkNotNullParameter(this$02, "this$0");
                SpecialEffectsController.FragmentStateManagerOperation operation2 = (SpecialEffectsController.FragmentStateManagerOperation) this.f4739c;
                Intrinsics.checkNotNullParameter(operation2, "$operation");
                this$02.f4691b.remove(operation2);
                this$02.f4692c.remove(operation2);
                break;
            default:
                DefaultSpecialEffectsController this$03 = (DefaultSpecialEffectsController) this.f4738b;
                Intrinsics.checkNotNullParameter(this$03, "this$0");
                SpecialEffectsController.Operation operation3 = this.f4739c;
                Intrinsics.checkNotNullParameter(operation3, "$operation");
                this$03.a(operation3);
                break;
        }
    }
}
