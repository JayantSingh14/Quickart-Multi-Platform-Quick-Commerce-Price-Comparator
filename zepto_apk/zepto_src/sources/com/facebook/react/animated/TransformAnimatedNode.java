package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class TransformAnimatedNode extends AnimatedNode {

    /* renamed from: e, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18668e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f18669f;

    @Metadata
    /* loaded from: classes3.dex */
    public final class AnimatedTransformConfig extends TransformConfig {

        /* renamed from: b, reason: collision with root package name */
        public int f18670b;

        public final int c() {
            return this.f18670b;
        }

        public final void d(int i2) {
            this.f18670b = i2;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public final class StaticTransformConfig extends TransformConfig {

        /* renamed from: b, reason: collision with root package name */
        public double f18671b;

        public final double c() {
            return this.f18671b;
        }

        public final void d(double d2) {
            this.f18671b = d2;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public class TransformConfig {

        /* renamed from: a, reason: collision with root package name */
        public String f18672a;

        public final String a() {
            return this.f18672a;
        }

        public final void b(String str) {
            this.f18672a = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.facebook.react.animated.TransformAnimatedNode$StaticTransformConfig, com.facebook.react.animated.TransformAnimatedNode$TransformConfig] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.facebook.react.animated.TransformAnimatedNode$AnimatedTransformConfig, com.facebook.react.animated.TransformAnimatedNode$TransformConfig] */
    public TransformAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Object obj;
        ?? staticTransformConfig;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18668e = nativeAnimatedNodesManager;
        ReadableArray array = config.getArray("transforms");
        if (array == null) {
            obj = EmptyList.f53609a;
        } else {
            int size = array.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                ReadableMap map = array.getMap(i2);
                if (map == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                String string = map.getString("property");
                if (Intrinsics.b(map.getString("type"), "animated")) {
                    staticTransformConfig = new AnimatedTransformConfig();
                    staticTransformConfig.b(string);
                    staticTransformConfig.d(map.getInt("nodeTag"));
                } else {
                    staticTransformConfig = new StaticTransformConfig();
                    staticTransformConfig.b(string);
                    staticTransformConfig.d(map.getDouble(CLConstants.FIELD_PAY_INFO_VALUE));
                }
                arrayList.add(staticTransformConfig);
            }
            obj = arrayList;
        }
        this.f18669f = obj;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "TransformAnimatedNode[" + this.f18524d + "]: transformConfigs: " + this.f18669f;
    }
}
