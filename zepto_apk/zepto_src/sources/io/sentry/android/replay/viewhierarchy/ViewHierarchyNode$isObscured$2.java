package io.sentry.android.replay.viewhierarchy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ViewHierarchyNode$isObscured$2 extends Lambda implements Function1<ViewHierarchyNode, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ViewHierarchyNode otherNode = (ViewHierarchyNode) obj;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        if (otherNode.f52659e == null) {
            return Boolean.FALSE;
        }
        throw null;
    }
}
