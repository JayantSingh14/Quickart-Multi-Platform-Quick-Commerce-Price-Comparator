package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends Lambda implements Function1<View, LifecycleOwner> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View viewParent = (View) obj;
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        Object tag = viewParent.getTag(R.id.view_tree_lifecycle_owner);
        if (tag instanceof LifecycleOwner) {
            return (LifecycleOwner) tag;
        }
        return null;
    }
}
