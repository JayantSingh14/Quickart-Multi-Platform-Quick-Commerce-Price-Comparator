package androidx.work.impl.constraints;

import androidx.work.impl.constraints.controllers.ConstraintController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class WorkConstraintsTracker$areAllConstraintsMet$1 extends Lambda implements Function1<ConstraintController<?>, CharSequence> {

    /* renamed from: c, reason: collision with root package name */
    public static final WorkConstraintsTracker$areAllConstraintsMet$1 f12807c = new WorkConstraintsTracker$areAllConstraintsMet$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ConstraintController it = (ConstraintController) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String simpleName = it.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "it.javaClass.simpleName");
        return simpleName;
    }
}
