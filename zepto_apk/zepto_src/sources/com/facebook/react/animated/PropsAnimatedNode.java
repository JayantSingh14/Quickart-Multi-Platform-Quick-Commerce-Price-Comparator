package com.facebook.react.animated;

import android.support.v4.media.b;
import com.facebook.react.animated.TransformAnimatedNode;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.MapBuilderEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PropsAnimatedNode extends AnimatedNode {

    /* renamed from: e, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18643e;

    /* renamed from: f, reason: collision with root package name */
    public int f18644f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f18645g;

    /* renamed from: h, reason: collision with root package name */
    public final JavaOnlyMap f18646h;

    /* renamed from: i, reason: collision with root package name */
    public UIManager f18647i;

    public PropsAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18643e = nativeAnimatedNodesManager;
        this.f18644f = -1;
        this.f18646h = new JavaOnlyMap();
        ReadableMap map = config.getMap("props");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map != null ? map.keySetIterator() : null;
        this.f18645g = new LinkedHashMap();
        while (readableMapKeySetIteratorKeySetIterator != null && readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            this.f18645g.put(strNextKey, Integer.valueOf(map.getInt(strNextKey)));
        }
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final String d() {
        int i2 = this.f18524d;
        int i3 = this.f18644f;
        LinkedHashMap linkedHashMap = this.f18645g;
        StringBuilder sbT = b.t(i2, i3, "PropsAnimatedNode[", "] connectedViewTag: ", " propNodeMapping: ");
        sbT.append(linkedHashMap);
        sbT.append(" propMap: ");
        sbT.append(this.f18646h);
        return sbT.toString();
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, java.util.List] */
    public final void f() {
        double dC;
        if (this.f18644f == -1) {
            return;
        }
        Iterator it = this.f18645g.entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            JavaOnlyMap propsMap = this.f18646h;
            if (!zHasNext) {
                UIManager uIManager = this.f18647i;
                if (uIManager != null) {
                    uIManager.synchronouslyUpdateViewOnUIThread(this.f18644f, propsMap);
                    return;
                }
                return;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            AnimatedNode animatedNodeH = this.f18643e.h(((Number) entry.getValue()).intValue());
            if (animatedNodeH == null) {
                return;
            }
            if (animatedNodeH instanceof StyleAnimatedNode) {
                StyleAnimatedNode styleAnimatedNode = (StyleAnimatedNode) animatedNodeH;
                Intrinsics.checkNotNullParameter(propsMap, "propsMap");
                Object it2 = ((MapBuilderEntries) styleAnimatedNode.f18660f.entrySet()).iterator();
                while (((MapBuilder.Itr) it2).hasNext()) {
                    Map.Entry entry2 = (Map.Entry) ((MapBuilder.EntriesItr) it2).next();
                    String str2 = (String) entry2.getKey();
                    AnimatedNode animatedNodeH2 = styleAnimatedNode.f18659e.h(((Number) entry2.getValue()).intValue());
                    if (animatedNodeH2 != null) {
                        if (animatedNodeH2 instanceof TransformAnimatedNode) {
                            TransformAnimatedNode transformAnimatedNode = (TransformAnimatedNode) animatedNodeH2;
                            Intrinsics.checkNotNullParameter(propsMap, "propsMap");
                            ?? r6 = transformAnimatedNode.f18669f;
                            int size = r6.size();
                            ArrayList arrayList = new ArrayList(size);
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    propsMap.putArray("transform", JavaOnlyArray.Companion.from(arrayList));
                                    break;
                                }
                                TransformAnimatedNode.TransformConfig transformConfig = (TransformAnimatedNode.TransformConfig) r6.get(i2);
                                if (transformConfig instanceof TransformAnimatedNode.AnimatedTransformConfig) {
                                    AnimatedNode animatedNodeH3 = transformAnimatedNode.f18668e.h(((TransformAnimatedNode.AnimatedTransformConfig) transformConfig).c());
                                    if (animatedNodeH3 != null && (animatedNodeH3 instanceof ValueAnimatedNode)) {
                                        dC = ((ValueAnimatedNode) animatedNodeH3).g();
                                    }
                                } else {
                                    Intrinsics.d(transformConfig, "null cannot be cast to non-null type com.facebook.react.animated.TransformAnimatedNode.StaticTransformConfig");
                                    dC = ((TransformAnimatedNode.StaticTransformConfig) transformConfig).c();
                                }
                                arrayList.add(JavaOnlyMap.Companion.of(transformConfig.a(), Double.valueOf(dC)));
                                i2++;
                            }
                        } else if (animatedNodeH2 instanceof ValueAnimatedNode) {
                            ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNodeH2;
                            Object objF = valueAnimatedNode.f();
                            if (objF instanceof Integer) {
                                propsMap.putInt(str2, ((Number) objF).intValue());
                            } else if (objF instanceof String) {
                                propsMap.putString(str2, (String) objF);
                            } else {
                                propsMap.putDouble(str2, valueAnimatedNode.g());
                            }
                        } else if (animatedNodeH2 instanceof ColorAnimatedNode) {
                            propsMap.putInt(str2, ((ColorAnimatedNode) animatedNodeH2).f());
                        } else if (animatedNodeH2 instanceof ObjectAnimatedNode) {
                            ((ObjectAnimatedNode) animatedNodeH2).f(str2, propsMap);
                        }
                    }
                }
            } else if (animatedNodeH instanceof ValueAnimatedNode) {
                ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) animatedNodeH;
                Object objF2 = valueAnimatedNode2.f();
                if (objF2 instanceof Integer) {
                    propsMap.putInt(str, ((Number) objF2).intValue());
                } else if (objF2 instanceof String) {
                    propsMap.putString(str, (String) objF2);
                } else {
                    propsMap.putDouble(str, valueAnimatedNode2.g());
                }
            } else if (animatedNodeH instanceof ColorAnimatedNode) {
                propsMap.putInt(str, ((ColorAnimatedNode) animatedNodeH).f());
            } else if (animatedNodeH instanceof ObjectAnimatedNode) {
                ((ObjectAnimatedNode) animatedNodeH).f(str, propsMap);
            }
        }
    }
}
