package com.swmansion.rnscreens;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.yoga.YogaEdge;
import com.swmansion.rnscreens.utils.PaddingBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ScreenStackHeaderConfigShadowNode extends LayoutShadowNode {
    public float A;
    public float z;

    public ScreenStackHeaderConfigShadowNode(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void q(Object obj) {
        if (obj instanceof PaddingBundle) {
            PaddingBundle paddingBundle = (PaddingBundle) obj;
            float f2 = paddingBundle.f47150b;
            this.z = paddingBundle.f47151c;
            this.A = paddingBundle.f47149a;
            w(f2, 4);
            w(this.z, 5);
            float f3 = -this.A;
            this.u.g0(YogaEdge.a(1), f3);
        }
    }
}
