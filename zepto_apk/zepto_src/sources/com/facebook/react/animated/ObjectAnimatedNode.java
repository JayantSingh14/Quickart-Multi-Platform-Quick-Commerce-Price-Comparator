package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ObjectAnimatedNode extends AnimatedNode {

    /* renamed from: e, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18640e;

    /* renamed from: f, reason: collision with root package name */
    public final JavaOnlyMap f18641f;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18642a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f18642a = iArr;
        }
    }

    public ObjectAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18640e = nativeAnimatedNodesManager;
        this.f18641f = JavaOnlyMap.Companion.deepClone(config);
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "ObjectAnimatedNode[" + this.f18524d + "]: mConfig: " + this.f18641f;
    }

    public final void f(String propKey, JavaOnlyMap propsMap) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        JavaOnlyMap javaOnlyMap = this.f18641f;
        ReadableType type = javaOnlyMap.getType(CLConstants.FIELD_PAY_INFO_VALUE);
        if (type == ReadableType.Map) {
            propsMap.putMap(propKey, h(javaOnlyMap.getMap(CLConstants.FIELD_PAY_INFO_VALUE)));
        } else {
            if (type != ReadableType.Array) {
                throw new IllegalArgumentException("Invalid value type for ObjectAnimatedNode");
            }
            propsMap.putArray(propKey, g(javaOnlyMap.getArray(CLConstants.FIELD_PAY_INFO_VALUE)));
        }
    }

    public final JavaOnlyArray g(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            switch (WhenMappings.f18642a[readableArray.getType(i2).ordinal()]) {
                case 1:
                    javaOnlyArray.pushNull();
                    break;
                case 2:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i2));
                    break;
                case 3:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i2));
                    break;
                case 4:
                    javaOnlyArray.pushString(readableArray.getString(i2));
                    break;
                case 5:
                    ReadableMap map = readableArray.getMap(i2);
                    if (map == null || !map.hasKey("nodeTag") || map.getType("nodeTag") != ReadableType.Number) {
                        javaOnlyArray.pushMap(h(readableArray.getMap(i2)));
                        break;
                    } else {
                        AnimatedNode animatedNodeH = this.f18640e.h(map.getInt("nodeTag"));
                        if (animatedNodeH == null) {
                            throw new IllegalArgumentException("Mapped value node does not exist");
                        }
                        if (animatedNodeH instanceof ValueAnimatedNode) {
                            ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNodeH;
                            Object objF = valueAnimatedNode.f();
                            if (objF instanceof Integer) {
                                javaOnlyArray.pushInt(((Number) objF).intValue());
                                break;
                            } else if (objF instanceof String) {
                                javaOnlyArray.pushString((String) objF);
                                break;
                            } else {
                                javaOnlyArray.pushDouble(valueAnimatedNode.g());
                                break;
                            }
                        } else if (animatedNodeH instanceof ColorAnimatedNode) {
                            javaOnlyArray.pushInt(((ColorAnimatedNode) animatedNodeH).f());
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                case 6:
                    javaOnlyArray.pushArray(g(readableArray.getArray(i2)));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return javaOnlyArray;
    }

    public final JavaOnlyMap h(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (WhenMappings.f18642a[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    javaOnlyMap.putNull(strNextKey);
                    break;
                case 2:
                    javaOnlyMap.putBoolean(strNextKey, readableMap.getBoolean(strNextKey));
                    break;
                case 3:
                    javaOnlyMap.putDouble(strNextKey, readableMap.getDouble(strNextKey));
                    break;
                case 4:
                    javaOnlyMap.putString(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 5:
                    ReadableMap map = readableMap.getMap(strNextKey);
                    if (map == null || !map.hasKey("nodeTag") || map.getType("nodeTag") != ReadableType.Number) {
                        javaOnlyMap.putMap(strNextKey, h(map));
                        break;
                    } else {
                        AnimatedNode animatedNodeH = this.f18640e.h(map.getInt("nodeTag"));
                        if (animatedNodeH == null) {
                            throw new IllegalArgumentException("Mapped value node does not exist");
                        }
                        if (!(animatedNodeH instanceof ValueAnimatedNode)) {
                            if (!(animatedNodeH instanceof ColorAnimatedNode)) {
                                break;
                            } else {
                                javaOnlyMap.putInt(strNextKey, ((ColorAnimatedNode) animatedNodeH).f());
                                break;
                            }
                        } else {
                            ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNodeH;
                            Object objF = valueAnimatedNode.f();
                            if (!(objF instanceof Integer)) {
                                if (!(objF instanceof String)) {
                                    javaOnlyMap.putDouble(strNextKey, valueAnimatedNode.g());
                                    break;
                                } else {
                                    javaOnlyMap.putString(strNextKey, (String) objF);
                                    break;
                                }
                            } else {
                                javaOnlyMap.putInt(strNextKey, ((Number) objF).intValue());
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    javaOnlyMap.putArray(strNextKey, g(readableMap.getArray(strNextKey)));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return javaOnlyMap;
    }
}
