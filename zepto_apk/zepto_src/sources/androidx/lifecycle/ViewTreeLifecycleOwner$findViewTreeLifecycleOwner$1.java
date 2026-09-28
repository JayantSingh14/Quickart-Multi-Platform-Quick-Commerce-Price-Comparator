package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends Lambda implements Function1<View, View> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View currentView = (View) obj;
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        Object parent = currentView.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
