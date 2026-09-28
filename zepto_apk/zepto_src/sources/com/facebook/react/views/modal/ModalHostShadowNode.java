package com.facebook.react.views.modal;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public final class ModalHostShadowNode extends LayoutShadowNode {
    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    /* renamed from: W */
    public final void r(ReactShadowNodeImpl child, int i2) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.r(child, i2);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void r(ReactShadowNode reactShadowNode, int i2) {
        ReactShadowNodeImpl child = (ReactShadowNodeImpl) reactShadowNode;
        Intrinsics.checkNotNullParameter(child, "child");
        super.r(child, i2);
    }
}
