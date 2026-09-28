package com.rnmaps.maps;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.yoga.YogaNode;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class SizeReportingShadowNode extends LayoutShadowNode {
    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public final void d0(UIViewOperationQueue uIViewOperationQueue) {
        HashMap map = new HashMap();
        YogaNode yogaNode = this.u;
        map.put(Snapshot.WIDTH, Float.valueOf(yogaNode.h()));
        map.put(Snapshot.HEIGHT, Float.valueOf(yogaNode.f()));
        uIViewOperationQueue.c(this.f19456a, map);
    }
}
