package com.facebook.react.animated;

import android.support.v4.media.b;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class NativeAnimatedNodesManager implements EventDispatcherListener {

    /* renamed from: e, reason: collision with root package name */
    public final ReactApplicationContext f18632e;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f18628a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f18629b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f18630c = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f18631d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public int f18633f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f18634g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public boolean f18635h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18636i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18637j = false;

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.f18632e = reactApplicationContext;
    }

    public final void a(int i2, String str, ReadableMap readableMap) {
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(readableMap.getInt("animatedValueTag"));
        if (animatedNode != null && (animatedNode instanceof ValueAnimatedNode)) {
            ReadableArray array = readableMap.getArray("nativeEventPath");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i3 = 0; i3 < array.size(); i3++) {
                arrayList.add(array.getString(i3));
            }
            if (str.startsWith("on")) {
                str = "top" + str.substring(2);
            }
            this.f18631d.add(new EventAnimationDriver(str, i2, arrayList, (ValueAnimatedNode) animatedNode));
            if (str.equals("topScroll")) {
                a(i2, "topScrollEnded", readableMap);
            }
        }
    }

    public final void b(int i2, int i3) {
        ReactApplicationContext reactApplicationContext;
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i2);
        if (animatedNode == null || !(animatedNode instanceof PropsAnimatedNode) || (reactApplicationContext = this.f18632e) == null) {
            return;
        }
        UIManager uIManagerF = UIManagerHelper.f(reactApplicationContext, ViewUtil.a(i3), true);
        if (uIManagerF == null) {
            ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException(b.f(i3, "connectAnimatedNodeToView: Animated node could not be connected to UIManager - uiManager disappeared for tag: ")));
            return;
        }
        PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) animatedNode;
        propsAnimatedNode.f18644f = i3;
        propsAnimatedNode.f18647i = uIManagerF;
        this.f18630c.put(i2, animatedNode);
    }

    public final void c(int i2, int i3) {
        AnimatedNode child;
        SparseArray sparseArray = this.f18628a;
        AnimatedNode animatedNode = (AnimatedNode) sparseArray.get(i2);
        if (animatedNode == null || (child = (AnimatedNode) sparseArray.get(i3)) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        ArrayList arrayList = animatedNode.f18521a;
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            animatedNode.f18521a = arrayList;
        }
        arrayList.add(child);
        child.b(animatedNode);
        this.f18630c.put(i3, child);
    }

    public final void d(int i2, ReadableMap readableMap) {
        AnimatedNode objectAnimatedNode;
        SparseArray sparseArray = this.f18628a;
        if (sparseArray.get(i2) != null) {
            return;
        }
        String string = readableMap.getString("type");
        if ("style".equals(string)) {
            objectAnimatedNode = new StyleAnimatedNode(readableMap, this);
        } else if (CLConstants.FIELD_PAY_INFO_VALUE.equals(string)) {
            objectAnimatedNode = new ValueAnimatedNode(readableMap);
        } else if ("color".equals(string)) {
            objectAnimatedNode = new ColorAnimatedNode(readableMap, this, this.f18632e);
        } else if ("props".equals(string)) {
            objectAnimatedNode = new PropsAnimatedNode(readableMap, this);
        } else if ("interpolation".equals(string)) {
            objectAnimatedNode = new InterpolationAnimatedNode(readableMap);
        } else if ("addition".equals(string)) {
            objectAnimatedNode = new AdditionAnimatedNode(readableMap, this);
        } else if ("subtraction".equals(string)) {
            objectAnimatedNode = new SubtractionAnimatedNode(readableMap, this);
        } else if ("division".equals(string)) {
            objectAnimatedNode = new DivisionAnimatedNode(readableMap, this);
        } else if ("multiplication".equals(string)) {
            objectAnimatedNode = new MultiplicationAnimatedNode(readableMap, this);
        } else if ("modulus".equals(string)) {
            objectAnimatedNode = new ModulusAnimatedNode(readableMap, this);
        } else if ("diffclamp".equals(string)) {
            objectAnimatedNode = new DiffClampAnimatedNode(readableMap, this);
        } else if ("transform".equals(string)) {
            objectAnimatedNode = new TransformAnimatedNode(readableMap, this);
        } else if ("tracking".equals(string)) {
            objectAnimatedNode = new TrackingAnimatedNode(readableMap, this);
        } else if (!"object".equals(string)) {
            return;
        } else {
            objectAnimatedNode = new ObjectAnimatedNode(readableMap, this);
        }
        objectAnimatedNode.f18524d = i2;
        sparseArray.put(i2, objectAnimatedNode);
        this.f18630c.put(i2, objectAnimatedNode);
    }

    public final void e(int i2, int i3) {
        AnimatedNode child;
        SparseArray sparseArray = this.f18628a;
        AnimatedNode animatedNode = (AnimatedNode) sparseArray.get(i2);
        if (animatedNode == null || (child = (AnimatedNode) sparseArray.get(i3)) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        ArrayList arrayList = animatedNode.f18521a;
        if (arrayList != null) {
            child.c(animatedNode);
            arrayList.remove(child);
        }
        this.f18630c.put(i3, child);
    }

    public final void f(int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            return;
        }
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode;
        valueAnimatedNode.f18674f += valueAnimatedNode.f18673e;
        valueAnimatedNode.f18673e = 0.0d;
    }

    public final void g(int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            return;
        }
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) animatedNode;
        valueAnimatedNode.f18673e += valueAnimatedNode.f18674f;
        valueAnimatedNode.f18674f = 0.0d;
    }

    public final AnimatedNode h(int i2) {
        return (AnimatedNode) this.f18628a.get(i2);
    }

    public final void i(int i2, Callback callback) {
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            return;
        }
        double dG = ((ValueAnimatedNode) animatedNode).g();
        if (callback != null) {
            callback.invoke(Double.valueOf(dG));
            return;
        }
        ReactApplicationContext reactApplicationContext = this.f18632e;
        if (reactApplicationContext == null) {
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("tag", i2);
        writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, dG);
        reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleGetValue", writableMapCreateMap);
    }

    public final void j(Event event) {
        LinkedList linkedList;
        ArrayList arrayList = this.f18631d;
        if (arrayList.isEmpty()) {
            return;
        }
        Event.EventAnimationDriverMatchSpec eventAnimationDriverMatchSpec = event.getEventAnimationDriverMatchSpec();
        Iterator it = arrayList.iterator();
        boolean z = false;
        while (true) {
            boolean zHasNext = it.hasNext();
            linkedList = this.f18634g;
            if (!zHasNext) {
                break;
            }
            EventAnimationDriver eventAnimationDriver = (EventAnimationDriver) it.next();
            if (eventAnimationDriverMatchSpec.a(eventAnimationDriver.viewTag, eventAnimationDriver.eventName)) {
                q(eventAnimationDriver.valueNode);
                event.dispatchModern(eventAnimationDriver);
                linkedList.add(eventAnimationDriver.valueNode);
                z = true;
            }
        }
        if (z) {
            r(linkedList);
            linkedList.clear();
        }
    }

    public final void k(int i2, int i3, String str) {
        if (str.startsWith("on")) {
            str = "top" + str.substring(2);
        }
        ListIterator listIterator = this.f18631d.listIterator();
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            EventAnimationDriver eventAnimationDriver = (EventAnimationDriver) listIterator.next();
            if (str.equals(eventAnimationDriver.eventName) && i2 == eventAnimationDriver.viewTag && i3 == eventAnimationDriver.valueNode.f18524d) {
                listIterator.remove();
                break;
            }
        }
        if (str.equals("topScroll")) {
            k(i2, i3, "topScrollEnded");
        }
    }

    public final void l(int i2) {
        PropsAnimatedNode propsAnimatedNode;
        int i3;
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i2);
        if (animatedNode == null || !(animatedNode instanceof PropsAnimatedNode) || (i3 = (propsAnimatedNode = (PropsAnimatedNode) animatedNode).f18644f) == -1 || ViewUtil.a(i3) == 2) {
            return;
        }
        JavaOnlyMap javaOnlyMap = propsAnimatedNode.f18646h;
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = javaOnlyMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            javaOnlyMap.putNull(readableMapKeySetIteratorKeySetIterator.nextKey());
        }
        UIManager uIManager = propsAnimatedNode.f18647i;
        if (uIManager != null) {
            uIManager.synchronouslyUpdateViewOnUIThread(propsAnimatedNode.f18644f, javaOnlyMap);
        }
    }

    public final void m(long j2) {
        SparseArray sparseArray;
        LinkedList linkedList;
        SparseArray sparseArray2;
        ReactApplicationContext reactApplicationContext;
        UiThreadUtil.assertOnUiThread();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            sparseArray = this.f18630c;
            int size = sparseArray.size();
            linkedList = this.f18634g;
            if (i3 >= size) {
                break;
            }
            linkedList.add((AnimatedNode) sparseArray.valueAt(i3));
            i3++;
        }
        sparseArray.clear();
        boolean z = false;
        while (true) {
            sparseArray2 = this.f18629b;
            if (i2 >= sparseArray2.size()) {
                break;
            }
            AnimationDriver animationDriver = (AnimationDriver) sparseArray2.valueAt(i2);
            animationDriver.b(j2);
            linkedList.add(animationDriver.f18526b);
            if (animationDriver.f18525a) {
                z = true;
            }
            i2++;
        }
        r(linkedList);
        linkedList.clear();
        if (z) {
            int size2 = sparseArray2.size() - 1;
            WritableArray writableArrayCreateArray = null;
            while (true) {
                reactApplicationContext = this.f18632e;
                if (size2 < 0) {
                    break;
                }
                AnimationDriver animationDriver2 = (AnimationDriver) sparseArray2.valueAt(size2);
                if (animationDriver2.f18525a) {
                    if (animationDriver2.f18527c != null) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putBoolean("finished", true);
                        writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, animationDriver2.f18526b.f18673e);
                        animationDriver2.f18527c.invoke(writableMapCreateMap);
                    } else if (reactApplicationContext != null) {
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        writableMapCreateMap2.putInt("animationId", animationDriver2.f18528d);
                        writableMapCreateMap2.putBoolean("finished", true);
                        writableMapCreateMap2.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, animationDriver2.f18526b.f18673e);
                        if (writableArrayCreateArray == null) {
                            writableArrayCreateArray = Arguments.createArray();
                        }
                        writableArrayCreateArray.pushMap(writableMapCreateMap2);
                    }
                    sparseArray2.removeAt(size2);
                }
                size2--;
            }
            if (writableArrayCreateArray != null) {
                reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
            }
        }
    }

    public final void n(int i2, double d2) {
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i2);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            return;
        }
        q(animatedNode);
        ((ValueAnimatedNode) animatedNode).f18673e = d2;
        this.f18630c.put(i2, animatedNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.facebook.react.animated.SpringAnimation] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.facebook.react.animated.AnimationDriver, com.facebook.react.animated.FrameBasedAnimationDriver] */
    public final void o(int i2, ReadableMap config, Callback callback, int i3) {
        DecayAnimation decayAnimation;
        AnimatedNode animatedNode = (AnimatedNode) this.f18628a.get(i3);
        if (animatedNode != null && (animatedNode instanceof ValueAnimatedNode)) {
            SparseArray sparseArray = this.f18629b;
            AnimationDriver animationDriver = (AnimationDriver) sparseArray.get(i2);
            if (animationDriver != null) {
                animationDriver.a(config);
                return;
            }
            String string = config.getString("type");
            if ("frames".equals(string)) {
                Intrinsics.checkNotNullParameter(config, "config");
                ?? frameBasedAnimationDriver = new FrameBasedAnimationDriver();
                frameBasedAnimationDriver.f18551e = -1L;
                frameBasedAnimationDriver.f18552f = new double[0];
                frameBasedAnimationDriver.f18555i = 1;
                frameBasedAnimationDriver.f18556j = 1;
                frameBasedAnimationDriver.a(config);
                decayAnimation = frameBasedAnimationDriver;
            } else if ("spring".equals(string)) {
                decayAnimation = new SpringAnimation(config);
            } else if (!"decay".equals(string)) {
                return;
            } else {
                decayAnimation = new DecayAnimation(config);
            }
            decayAnimation.f18528d = i2;
            decayAnimation.f18527c = callback;
            decayAnimation.f18526b = (ValueAnimatedNode) animatedNode;
            sparseArray.put(i2, decayAnimation);
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public final void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            j(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.animated.NativeAnimatedNodesManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    NativeAnimatedNodesManager.this.j(event);
                }
            });
        }
    }

    public final void p(int i2) {
        ReactApplicationContext reactApplicationContext;
        WritableArray writableArrayCreateArray;
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f18629b;
            int size = sparseArray.size();
            reactApplicationContext = this.f18632e;
            writableArrayCreateArray = null;
            if (i3 >= size) {
                break;
            }
            AnimationDriver animationDriver = (AnimationDriver) sparseArray.valueAt(i3);
            if (animationDriver.f18528d == i2) {
                if (animationDriver.f18527c != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putBoolean("finished", false);
                    writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, animationDriver.f18526b.f18673e);
                    animationDriver.f18527c.invoke(writableMapCreateMap);
                } else if (reactApplicationContext != null) {
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    writableMapCreateMap2.putInt("animationId", animationDriver.f18528d);
                    writableMapCreateMap2.putBoolean("finished", false);
                    writableMapCreateMap2.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, animationDriver.f18526b.f18673e);
                    writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                }
                sparseArray.removeAt(i3);
            } else {
                i3++;
            }
        }
        if (writableArrayCreateArray != null) {
            reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
        }
    }

    public final void q(AnimatedNode animatedNode) {
        ReactApplicationContext reactApplicationContext;
        WritableArray writableArrayCreateArray = null;
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f18629b;
            int size = sparseArray.size();
            reactApplicationContext = this.f18632e;
            if (i2 >= size) {
                break;
            }
            AnimationDriver animationDriver = (AnimationDriver) sparseArray.valueAt(i2);
            if (animatedNode.equals(animationDriver.f18526b)) {
                if (animationDriver.f18527c != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putBoolean("finished", false);
                    writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, animationDriver.f18526b.f18673e);
                    animationDriver.f18527c.invoke(writableMapCreateMap);
                } else if (reactApplicationContext != null) {
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    writableMapCreateMap2.putInt("animationId", animationDriver.f18528d);
                    writableMapCreateMap2.putBoolean("finished", false);
                    writableMapCreateMap2.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, animationDriver.f18526b.f18673e);
                    if (writableArrayCreateArray == null) {
                        writableArrayCreateArray = Arguments.createArray();
                    }
                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                }
                sparseArray.removeAt(i2);
                i2--;
            }
            i2++;
        }
        if (writableArrayCreateArray != null) {
            reactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
        }
    }

    public final void r(LinkedList linkedList) {
        ValueAnimatedNode valueAnimatedNode;
        AnimatedNodeValueListener animatedNodeValueListener;
        int i2 = this.f18633f;
        int i3 = i2 + 1;
        this.f18633f = i3;
        if (i3 == 0) {
            this.f18633f = i2 + 2;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            AnimatedNode animatedNode = (AnimatedNode) it.next();
            int i5 = animatedNode.f18523c;
            int i6 = this.f18633f;
            if (i5 != i6) {
                animatedNode.f18523c = i6;
                i4++;
                arrayDeque.add(animatedNode);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode2 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode2.f18521a != null) {
                for (int i7 = 0; i7 < animatedNode2.f18521a.size(); i7++) {
                    AnimatedNode animatedNode3 = (AnimatedNode) animatedNode2.f18521a.get(i7);
                    animatedNode3.f18522b++;
                    int i8 = animatedNode3.f18523c;
                    int i9 = this.f18633f;
                    if (i8 != i9) {
                        animatedNode3.f18523c = i9;
                        i4++;
                        arrayDeque.add(animatedNode3);
                    }
                }
            }
        }
        int i10 = this.f18633f;
        int i11 = i10 + 1;
        this.f18633f = i11;
        if (i11 == 0) {
            this.f18633f = i10 + 2;
        }
        Iterator it2 = linkedList.iterator();
        int i12 = 0;
        while (it2.hasNext()) {
            AnimatedNode animatedNode4 = (AnimatedNode) it2.next();
            if (animatedNode4.f18522b == 0) {
                int i13 = animatedNode4.f18523c;
                int i14 = this.f18633f;
                if (i13 != i14) {
                    animatedNode4.f18523c = i14;
                    i12++;
                    arrayDeque.add(animatedNode4);
                }
            }
        }
        int i15 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode5 = (AnimatedNode) arrayDeque.poll();
            try {
                animatedNode5.e();
                if (animatedNode5 instanceof PropsAnimatedNode) {
                    ((PropsAnimatedNode) animatedNode5).f();
                }
            } catch (JSApplicationCausedNativeException e2) {
                FLog.h("NativeAnimatedNodesManager", "Native animation workaround, frame lost as result of race condition", e2);
            }
            if ((animatedNode5 instanceof ValueAnimatedNode) && (animatedNodeValueListener = (valueAnimatedNode = (ValueAnimatedNode) animatedNode5).f18675g) != null) {
                animatedNodeValueListener.a(valueAnimatedNode.g());
            }
            if (animatedNode5.f18521a != null) {
                for (int i16 = 0; i16 < animatedNode5.f18521a.size(); i16++) {
                    AnimatedNode animatedNode6 = (AnimatedNode) animatedNode5.f18521a.get(i16);
                    int i17 = animatedNode6.f18522b - 1;
                    animatedNode6.f18522b = i17;
                    int i18 = animatedNode6.f18523c;
                    int i19 = this.f18633f;
                    if (i18 != i19 && i17 == 0) {
                        animatedNode6.f18523c = i19;
                        i12++;
                        arrayDeque.add(animatedNode6);
                    } else if (i18 == i19) {
                        i15++;
                    }
                }
            }
        }
        if (i4 == i12) {
            this.f18637j = false;
            return;
        }
        if (this.f18637j) {
            return;
        }
        this.f18637j = true;
        FLog.g("NativeAnimatedNodesManager", "Detected animation cycle or disconnected graph. ");
        Iterator it3 = linkedList.iterator();
        while (it3.hasNext()) {
            AnimatedNode animatedNode7 = (AnimatedNode) it3.next();
            ArrayList arrayList = animatedNode7.f18521a;
            String strE = arrayList != null ? CollectionsKt.E(arrayList, StringUtils.SPACE, null, null, null, 62) : null;
            FLog.g("NativeAnimatedNodesManager", animatedNode7.d() + ((strE == null || StringsKt.z(strE)) ? "" : " children: ".concat(strE)));
        }
        IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + (i15 > 0 ? b.g(i15, "cycles (", ")") : "disconnected regions") + ", there are " + i4 + " but toposort visited only " + i12);
        boolean z = this.f18635h;
        if (z && i15 == 0) {
            ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException(illegalStateException));
        } else if (z) {
            ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException(illegalStateException));
        }
    }
}
