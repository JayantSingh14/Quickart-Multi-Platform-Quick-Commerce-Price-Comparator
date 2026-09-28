package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.ViewManagersPropertyCache;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ViewManagerPropertyUpdater {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f19597a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f19598b = new HashMap();

    public static class FallbackShadowNodeSetter<T extends ReactShadowNode> implements ShadowNodeSetter<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f19599a;

        public FallbackShadowNodeSetter(Class cls) {
            this.f19599a = ViewManagersPropertyCache.c(cls);
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter
        public final void a(ReactShadowNodeImpl reactShadowNodeImpl, String str, Object obj) {
            Object[] objArr;
            ViewManagersPropertyCache.PropSetter propSetter = (ViewManagersPropertyCache.PropSetter) this.f19599a.get(str);
            if (propSetter != null) {
                Integer num = propSetter.f19619d;
                try {
                    if (num == null) {
                        objArr = (Object[]) ViewManagersPropertyCache.PropSetter.f19614g.get();
                        ThemedReactContext themedReactContext = reactShadowNodeImpl.f19459d;
                        Assertions.c(themedReactContext);
                        objArr[0] = propSetter.a(obj, themedReactContext);
                    } else {
                        Object[] objArr2 = (Object[]) ViewManagersPropertyCache.PropSetter.f19615h.get();
                        objArr2[0] = num;
                        ThemedReactContext themedReactContext2 = reactShadowNodeImpl.f19459d;
                        Assertions.c(themedReactContext2);
                        objArr2[1] = propSetter.a(obj, themedReactContext2);
                        objArr = objArr2;
                    }
                    propSetter.f19618c.invoke(reactShadowNodeImpl, objArr);
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder("Error while updating prop ");
                    String str2 = propSetter.f19616a;
                    sb.append(str2);
                    FLog.f(ViewManager.class, sb.toString(), th);
                    StringBuilder sbY = android.support.v4.media.b.y("Error while updating property '", str2, "' in shadow node of type: ");
                    String str3 = reactShadowNodeImpl.f19457b;
                    Assertions.c(str3);
                    sbY.append(str3);
                    throw new JSApplicationIllegalArgumentException(sbY.toString(), th);
                }
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public final void b(HashMap map) {
            for (ViewManagersPropertyCache.PropSetter propSetter : this.f19599a.values()) {
                map.put(propSetter.f19616a, propSetter.f19617b);
            }
        }
    }

    public static class FallbackViewManagerSetter<T extends ViewManager, V extends View> implements ViewManagerSetter<T, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f19600a;

        public FallbackViewManagerSetter(Class cls) {
            this.f19600a = ViewManagersPropertyCache.d(cls);
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public final void b(HashMap map) {
            for (ViewManagersPropertyCache.PropSetter propSetter : this.f19600a.values()) {
                map.put(propSetter.f19616a, propSetter.f19617b);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter
        public final void c(ViewManager viewManager, View view, String str, Object obj) {
            Object[] objArr;
            ViewManagersPropertyCache.PropSetter propSetter = (ViewManagersPropertyCache.PropSetter) this.f19600a.get(str);
            if (propSetter != null) {
                Integer num = propSetter.f19619d;
                try {
                    if (num == null) {
                        objArr = (Object[]) ViewManagersPropertyCache.PropSetter.f19612e.get();
                        objArr[0] = view;
                        objArr[1] = propSetter.a(obj, view.getContext());
                    } else {
                        Object[] objArr2 = (Object[]) ViewManagersPropertyCache.PropSetter.f19613f.get();
                        objArr2[0] = view;
                        objArr2[1] = num;
                        objArr2[2] = propSetter.a(obj, view.getContext());
                        objArr = objArr2;
                    }
                    propSetter.f19618c.invoke(viewManager, objArr);
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder("Error while updating prop ");
                    String str2 = propSetter.f19616a;
                    sb.append(str2);
                    FLog.f(ViewManager.class, sb.toString(), th);
                    StringBuilder sbY = android.support.v4.media.b.y("Error while updating property '", str2, "' of a view managed by: ");
                    sbY.append(viewManager.getName());
                    throw new JSApplicationIllegalArgumentException(sbY.toString(), th);
                }
            }
        }
    }

    public interface Settable {
        void b(HashMap map);
    }

    public interface ShadowNodeSetter<T extends ReactShadowNode> extends Settable {
        void a(ReactShadowNodeImpl reactShadowNodeImpl, String str, Object obj);
    }

    public interface ViewManagerSetter<T extends ViewManager, V extends View> extends Settable {
        void c(ViewManager viewManager, View view, String str, Object obj);
    }

    public static void a() {
        ViewManagersPropertyCache.f19604a.clear();
        ViewManagersPropertyCache.f19605b.clear();
        f19597a.clear();
        f19598b.clear();
    }

    public static Object b(Class cls) {
        String name = cls.getName();
        try {
            return Class.forName(name.concat("$$PropsSetter")).newInstance();
        } catch (ClassNotFoundException unused) {
            FLog.q("ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException("Unable to instantiate methods getter for ".concat(name), e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException("Unable to instantiate methods getter for ".concat(name), e);
        }
    }

    public static ViewManagerSetter c(Class cls) {
        HashMap map = f19597a;
        ViewManagerSetter fallbackViewManagerSetter = (ViewManagerSetter) map.get(cls);
        if (fallbackViewManagerSetter == null) {
            fallbackViewManagerSetter = (ViewManagerSetter) b(cls);
            if (fallbackViewManagerSetter == null) {
                fallbackViewManagerSetter = new FallbackViewManagerSetter(cls);
            }
            map.put(cls, fallbackViewManagerSetter);
        }
        return fallbackViewManagerSetter;
    }

    public static ShadowNodeSetter d(Class cls) {
        HashMap map = f19598b;
        ShadowNodeSetter fallbackShadowNodeSetter = (ShadowNodeSetter) map.get(cls);
        if (fallbackShadowNodeSetter == null) {
            fallbackShadowNodeSetter = (ShadowNodeSetter) b(cls);
            if (fallbackShadowNodeSetter == null) {
                fallbackShadowNodeSetter = new FallbackShadowNodeSetter(cls);
            }
            map.put(cls, fallbackShadowNodeSetter);
        }
        return fallbackShadowNodeSetter;
    }
}
