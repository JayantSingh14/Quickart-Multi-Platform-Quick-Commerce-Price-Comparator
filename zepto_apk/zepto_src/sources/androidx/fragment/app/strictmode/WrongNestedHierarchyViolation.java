package androidx.fragment.app.strictmode;

import android.support.v4.media.b;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WrongNestedHierarchyViolation extends Violation {
    public WrongNestedHierarchyViolation(Fragment fragment, Fragment expectedParentFragment, int i2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(expectedParentFragment, "expectedParentFragment");
        StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
        sb.append(fragment);
        sb.append(" within the view of parent fragment ");
        sb.append(expectedParentFragment);
        sb.append(" via container with ID ");
        super(fragment, b.o(sb, i2, " without using parent's childFragmentManager"));
    }
}
