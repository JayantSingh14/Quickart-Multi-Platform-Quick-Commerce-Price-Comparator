package com.facebook.react.animated;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.views.view.ColorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ColorAnimatedNode extends AnimatedNode implements AnimatedNodeWithUpdateableConfig {

    /* renamed from: e, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18529e;

    /* renamed from: f, reason: collision with root package name */
    public final ReactApplicationContext f18530f;

    /* renamed from: g, reason: collision with root package name */
    public int f18531g;

    /* renamed from: h, reason: collision with root package name */
    public int f18532h;

    /* renamed from: i, reason: collision with root package name */
    public int f18533i;

    /* renamed from: j, reason: collision with root package name */
    public int f18534j;

    /* renamed from: k, reason: collision with root package name */
    public ReadableMap f18535k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f18536l;

    @Metadata
    public static final class Companion {
        public static Context a(AnimatedNode animatedNode) {
            Object objA;
            ArrayList arrayList = animatedNode.f18521a;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    AnimatedNode animatedNode2 = (AnimatedNode) it.next();
                    if (!(animatedNode2 instanceof PropsAnimatedNode)) {
                        return a(animatedNode2);
                    }
                    PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode2;
                    propsAnimatedNode.getClass();
                    try {
                        Result.Companion companion = Result.f53538b;
                        UIManager uIManager = propsAnimatedNode.f18647i;
                        objA = uIManager != null ? uIManager.resolveView(propsAnimatedNode.f18644f) : null;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.f53538b;
                        objA = ResultKt.a(th);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = null;
                    }
                    View view = (View) objA;
                    if (view != null) {
                        return view.getContext();
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public ColorAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.f18529e = nativeAnimatedNodesManager;
        this.f18530f = reactApplicationContext;
        a(config);
    }

    @Override // com.facebook.react.animated.AnimatedNodeWithUpdateableConfig
    public final void a(ReadableMap readableMap) {
        if (readableMap == null) {
            this.f18531g = 0;
            this.f18532h = 0;
            this.f18533i = 0;
            this.f18534j = 0;
            this.f18535k = null;
            this.f18536l = false;
            return;
        }
        this.f18531g = readableMap.getInt("r");
        this.f18532h = readableMap.getInt("g");
        this.f18533i = readableMap.getInt("b");
        this.f18534j = readableMap.getInt("a");
        this.f18535k = readableMap.getMap("nativeColor");
        this.f18536l = false;
        g();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final String d() {
        int i2 = this.f18524d;
        int i3 = this.f18531g;
        int i4 = this.f18532h;
        int i5 = this.f18533i;
        int i6 = this.f18534j;
        StringBuilder sbT = b.t(i2, i3, "ColorAnimatedNode[", "]: r: ", "  g: ");
        a.q(i4, i5, " b: ", " a: ", sbT);
        sbT.append(i6);
        return sbT.toString();
    }

    public final int f() {
        g();
        int i2 = this.f18531g;
        NativeAnimatedNodesManager nativeAnimatedNodesManager = this.f18529e;
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nativeAnimatedNodesManager.h(i2);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) nativeAnimatedNodesManager.h(this.f18532h);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) nativeAnimatedNodesManager.h(this.f18533i);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) nativeAnimatedNodesManager.h(this.f18534j);
        return (ColorUtil.a((valueAnimatedNode4 != null ? valueAnimatedNode4.f18673e : 0.0d) * 255) << 24) | (ColorUtil.a(valueAnimatedNode != null ? valueAnimatedNode.f18673e : 0.0d) << 16) | (ColorUtil.a(valueAnimatedNode2 != null ? valueAnimatedNode2.f18673e : 0.0d) << 8) | ColorUtil.a(valueAnimatedNode3 != null ? valueAnimatedNode3.f18673e : 0.0d);
    }

    public final void g() {
        if (this.f18535k == null || this.f18536l) {
            return;
        }
        Context currentActivity = this.f18530f.getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = Companion.a(this);
        }
        if (currentActivity == null) {
            return;
        }
        Integer color = ColorPropConverter.getColor(this.f18535k, currentActivity);
        int i2 = this.f18531g;
        NativeAnimatedNodesManager nativeAnimatedNodesManager = this.f18529e;
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nativeAnimatedNodesManager.h(i2);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) nativeAnimatedNodesManager.h(this.f18532h);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) nativeAnimatedNodesManager.h(this.f18533i);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) nativeAnimatedNodesManager.h(this.f18534j);
        if (valueAnimatedNode != null) {
            Intrinsics.c(color);
            valueAnimatedNode.f18673e = Color.red(color.intValue());
        }
        if (valueAnimatedNode2 != null) {
            Intrinsics.c(color);
            valueAnimatedNode2.f18673e = Color.green(color.intValue());
        }
        if (valueAnimatedNode3 != null) {
            Intrinsics.c(color);
            valueAnimatedNode3.f18673e = Color.blue(color.intValue());
        }
        if (valueAnimatedNode4 != null) {
            Intrinsics.c(color);
            valueAnimatedNode4.f18673e = Color.alpha(color.intValue()) / 255.0d;
        }
        this.f18536l = true;
    }
}
