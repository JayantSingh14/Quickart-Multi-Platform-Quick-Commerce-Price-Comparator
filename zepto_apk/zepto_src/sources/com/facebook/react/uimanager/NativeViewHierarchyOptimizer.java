package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.UIViewOperationQueue.ManageChildrenOperation;
import com.facebook.react.uimanager.UIViewOperationQueue.UpdateLayoutOperation;
import com.facebook.yoga.YogaDirection;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class NativeViewHierarchyOptimizer {

    /* renamed from: a, reason: collision with root package name */
    public final UIViewOperationQueue f19414a;

    /* renamed from: b, reason: collision with root package name */
    public final ShadowNodeRegistry f19415b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f19416c = new SparseBooleanArray();

    public static class NodeIndexPair {

        /* renamed from: a, reason: collision with root package name */
        public final ReactShadowNode f19417a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19418b;

        public NodeIndexPair(ReactShadowNode reactShadowNode, int i2) {
            this.f19417a = reactShadowNode;
            this.f19418b = i2;
        }
    }

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uIViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry) {
        this.f19414a = uIViewOperationQueue;
        this.f19415b = shadowNodeRegistry;
    }

    public static boolean f(ReactStylesDiffMap reactStylesDiffMap) {
        ReadableType type;
        if (reactStylesDiffMap != null) {
            ReadableMap map = reactStylesDiffMap.f19469a;
            if (map.hasKey("collapsable")) {
                if (!(map.isNull("collapsable") ? true : map.getBoolean("collapsable"))) {
                    return false;
                }
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String prop = readableMapKeySetIteratorKeySetIterator.nextKey();
                int[] iArr = ViewProps.f19620a;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(prop, "prop");
                if (!ViewProps.f19622c.contains(prop)) {
                    if ("pointerEvents".equals(prop)) {
                        String string = map.getString(prop);
                        if (!"auto".equals(string) && !"box-none".equals(string)) {
                            return false;
                        }
                    } else {
                        switch (prop.hashCode()) {
                            case -1989576717:
                                if (!prop.equals("borderRightColor") || map.getType("borderRightColor") != ReadableType.Number || map.getInt("borderRightColor") != 0) {
                                    return false;
                                }
                                break;
                            case -1971292586:
                                if (!prop.equals("borderRightWidth")) {
                                    return false;
                                }
                                if (!map.isNull("borderRightWidth") && map.getDouble("borderRightWidth") != 0.0d) {
                                    return false;
                                }
                                break;
                                break;
                            case -1470826662:
                                if (!prop.equals("borderTopColor") || map.getType("borderTopColor") != ReadableType.Number || map.getInt("borderTopColor") != 0) {
                                    return false;
                                }
                                break;
                                break;
                            case -1452542531:
                                if (!prop.equals("borderTopWidth")) {
                                    return false;
                                }
                                if (!map.isNull("borderTopWidth") && map.getDouble("borderTopWidth") != 0.0d) {
                                    return false;
                                }
                                break;
                                break;
                            case -1308858324:
                                if (!prop.equals("borderBottomColor") || map.getType("borderBottomColor") != ReadableType.Number || map.getInt("borderBottomColor") != 0) {
                                    return false;
                                }
                                break;
                                break;
                            case -1290574193:
                                if (!prop.equals("borderBottomWidth")) {
                                    return false;
                                }
                                if (!map.isNull("borderBottomWidth") && map.getDouble("borderBottomWidth") != 0.0d) {
                                    return false;
                                }
                                break;
                                break;
                            case -1267206133:
                                if (!prop.equals("opacity")) {
                                    return false;
                                }
                                if (!map.isNull("opacity") && map.getDouble("opacity") != 1.0d) {
                                    return false;
                                }
                                break;
                            case -242276144:
                                if (!prop.equals("borderLeftColor") || map.getType("borderLeftColor") != ReadableType.Number || map.getInt("borderLeftColor") != 0) {
                                    return false;
                                }
                                break;
                                break;
                            case -223992013:
                                if (!prop.equals("borderLeftWidth")) {
                                    return false;
                                }
                                if (!map.isNull("borderLeftWidth") && map.getDouble("borderLeftWidth") != 0.0d) {
                                    return false;
                                }
                                break;
                            case 306963138:
                                if (!prop.equals("borderBlockStartColor") || map.getType("borderBlockStartColor") != ReadableType.Number || map.getInt("borderBlockStartColor") != 0) {
                                    return false;
                                }
                                break;
                                break;
                            case 529642498:
                                if (!prop.equals("overflow")) {
                                    return false;
                                }
                                if (!map.isNull("overflow") && !"visible".equals(map.getString("overflow"))) {
                                    return false;
                                }
                                break;
                            case 684610594:
                                if (!prop.equals("borderBlockColor") || map.getType("borderBlockColor") != ReadableType.Number || map.getInt("borderBlockColor") != 0) {
                                    return false;
                                }
                                break;
                                break;
                            case 741115130:
                                if (!prop.equals("borderWidth")) {
                                    return false;
                                }
                                if (!map.isNull("borderWidth") && map.getDouble("borderWidth") != 0.0d) {
                                    return false;
                                }
                                break;
                                break;
                            case 762983977:
                                if (!prop.equals("borderBlockEndColor") || map.getType("borderBlockEndColor") != ReadableType.Number || map.getInt("borderBlockEndColor") != 0) {
                                    return false;
                                }
                                break;
                                break;
                            case 1349188574:
                                if (!prop.equals(Snapshot.BORDER_RADIUS)) {
                                    return false;
                                }
                                if (map.hasKey("backgroundColor") && (((type = map.getType("backgroundColor")) == ReadableType.Number && map.getInt("backgroundColor") != 0) || type != ReadableType.Null)) {
                                    return false;
                                }
                                if (map.hasKey("borderWidth") && !map.isNull("borderWidth") && map.getDouble("borderWidth") != 0.0d) {
                                    return false;
                                }
                                break;
                                break;
                            default:
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public final void a(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        Assertions.a(reactShadowNode2.N() != NativeKind.f19403a);
        for (int i3 = 0; i3 < reactShadowNode2.f(); i3++) {
            ReactShadowNodeImpl reactShadowNodeImplA = reactShadowNode2.a(i3);
            Assertions.a(reactShadowNodeImplA.f19467l == null);
            int iK = reactShadowNode.k();
            if (reactShadowNodeImplA.N() == NativeKind.f19405c) {
                a(reactShadowNode, reactShadowNodeImplA, i2);
            } else {
                b(reactShadowNode, reactShadowNodeImplA, i2);
            }
            i2 += reactShadowNode.k() - iK;
        }
    }

    public final void b(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        reactShadowNode.l(reactShadowNode2, i2);
        int iG = reactShadowNode.G();
        ViewAtIndex[] viewAtIndexArr = {new ViewAtIndex(reactShadowNode2.G(), i2)};
        UIViewOperationQueue uIViewOperationQueue = this.f19414a;
        uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new ManageChildrenOperation(iG, null, viewAtIndexArr, null));
        if (reactShadowNode2.N() != NativeKind.f19403a) {
            a(reactShadowNode, reactShadowNode2, i2 + 1);
        }
    }

    public final void c(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i2) {
        NodeIndexPair nodeIndexPair;
        int iJ = reactShadowNode.j(reactShadowNode.a(i2));
        if (reactShadowNode.N() != NativeKind.f19403a) {
            while (true) {
                if (reactShadowNode.N() == NativeKind.f19403a) {
                    nodeIndexPair = new NodeIndexPair(reactShadowNode, iJ);
                    break;
                }
                ReactShadowNodeImpl parent = reactShadowNode.getParent();
                if (parent == null) {
                    nodeIndexPair = null;
                    break;
                } else {
                    iJ = iJ + (reactShadowNode.N() == NativeKind.f19404b ? 1 : 0) + parent.j(reactShadowNode);
                    reactShadowNode = parent;
                }
            }
            if (nodeIndexPair == null) {
                return;
            }
            ReactShadowNode reactShadowNode3 = nodeIndexPair.f19417a;
            iJ = nodeIndexPair.f19418b;
            reactShadowNode = reactShadowNode3;
        }
        if (reactShadowNode2.N() != NativeKind.f19405c) {
            b(reactShadowNode, reactShadowNode2, iJ);
        } else {
            a(reactShadowNode, reactShadowNode2, iJ);
        }
    }

    public final void d(ReactShadowNode reactShadowNode) {
        int iG = reactShadowNode.G();
        SparseBooleanArray sparseBooleanArray = this.f19416c;
        if (sparseBooleanArray.get(iG)) {
            return;
        }
        sparseBooleanArray.put(iG, true);
        int iV = reactShadowNode.v();
        int iP = reactShadowNode.p();
        for (ReactShadowNodeImpl parent = reactShadowNode.getParent(); parent != null && parent.N() != NativeKind.f19403a; parent = parent.f19463h) {
            if (!parent.J()) {
                int iRound = Math.round(parent.u.i()) + iV;
                iP = Math.round(parent.u.j()) + iP;
                iV = iRound;
            }
        }
        e(reactShadowNode, iV, iP);
    }

    public final void e(ReactShadowNode reactShadowNode, int i2, int i3) {
        if (reactShadowNode.N() != NativeKind.f19405c && reactShadowNode.U() != null) {
            int iG = reactShadowNode.G();
            int i4 = reactShadowNode.T().f19456a;
            int iL = reactShadowNode.L();
            int iB = reactShadowNode.B();
            YogaDirection layoutDirection = reactShadowNode.getLayoutDirection();
            UIViewOperationQueue uIViewOperationQueue = this.f19414a;
            uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new UpdateLayoutOperation(i4, iG, i2, i3, iL, iB, layoutDirection));
            return;
        }
        for (int i5 = 0; i5 < reactShadowNode.f(); i5++) {
            ReactShadowNodeImpl reactShadowNodeImplA = reactShadowNode.a(i5);
            int i6 = reactShadowNodeImplA.f19456a;
            SparseBooleanArray sparseBooleanArray = this.f19416c;
            if (!sparseBooleanArray.get(i6)) {
                sparseBooleanArray.put(i6, true);
                e(reactShadowNodeImplA, reactShadowNodeImplA.n + i2, reactShadowNodeImplA.o + i3);
            }
        }
    }

    public final void g(ReactShadowNode reactShadowNode, boolean z) {
        if (reactShadowNode.N() != NativeKind.f19403a) {
            for (int iF = reactShadowNode.f() - 1; iF >= 0; iF--) {
                g(reactShadowNode.a(iF), z);
            }
        }
        ReactShadowNodeImpl reactShadowNodeImplU = reactShadowNode.U();
        if (reactShadowNodeImplU != null) {
            Assertions.c(reactShadowNodeImplU.f19468m);
            int iIndexOf = reactShadowNodeImplU.f19468m.indexOf((ReactShadowNodeImpl) reactShadowNode);
            Assertions.c(reactShadowNodeImplU.f19468m);
            ((ReactShadowNodeImpl) reactShadowNodeImplU.f19468m.remove(iIndexOf)).f19467l = null;
            int i2 = reactShadowNodeImplU.f19456a;
            int[] iArr = {iIndexOf};
            int[] iArr2 = z ? new int[]{reactShadowNode.G()} : null;
            UIViewOperationQueue uIViewOperationQueue = this.f19414a;
            uIViewOperationQueue.f19520h.add(uIViewOperationQueue.new ManageChildrenOperation(i2, iArr, null, iArr2));
        }
    }

    public final void h(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        ReactShadowNodeImpl parent = reactShadowNode.getParent();
        if (parent == null) {
            reactShadowNode.z(false);
            return;
        }
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) reactShadowNode;
        ArrayList arrayList = parent.f19462g;
        int iIndexOf = arrayList == null ? -1 : arrayList.indexOf(reactShadowNodeImpl);
        parent.C(iIndexOf);
        g(reactShadowNode, false);
        reactShadowNode.z(false);
        this.f19414a.b(reactShadowNode.M(), reactShadowNode.G(), reactShadowNode.s(), reactStylesDiffMap);
        parent.r(reactShadowNode, iIndexOf);
        c(parent, reactShadowNode, iIndexOf);
        for (int i2 = 0; i2 < reactShadowNode.f(); i2++) {
            c(reactShadowNode, reactShadowNode.a(i2), i2);
        }
        StringBuilder sb = new StringBuilder("Transitioning LayoutOnlyView - tag: ");
        sb.append(reactShadowNode.G());
        sb.append(" - rootTag: ");
        sb.append(reactShadowNode.O());
        sb.append(" - hasProps: ");
        sb.append(reactStylesDiffMap != null);
        sb.append(" - tagsWithLayout.size: ");
        SparseBooleanArray sparseBooleanArray = this.f19416c;
        sb.append(sparseBooleanArray.size());
        String string = sb.toString();
        if (FLog.f17086a.a(4)) {
            FLogDefaultLoggingDelegate.b(4, "NativeViewHierarchyOptimizer", string);
        }
        Assertions.a(sparseBooleanArray.size() == 0);
        d(reactShadowNode);
        for (int i3 = 0; i3 < reactShadowNode.f(); i3++) {
            d(reactShadowNode.a(i3));
        }
        sparseBooleanArray.clear();
    }
}
