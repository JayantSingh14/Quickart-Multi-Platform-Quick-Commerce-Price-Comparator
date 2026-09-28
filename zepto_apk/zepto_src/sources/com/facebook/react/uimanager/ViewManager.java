package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaMeasureMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

@ReactPropertyHolder
/* loaded from: classes.dex */
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule {
    private static final String NAME = "ViewManager";

    @Nullable
    private HashMap<Integer, Stack<T>> mRecyclableViews;

    public ViewManager() {
        super(null);
        this.mRecyclableViews = null;
    }

    @Nullable
    private Stack<T> getRecyclableViewStack(int i2, boolean z) {
        HashMap<Integer, Stack<T>> map = this.mRecyclableViews;
        if (map == null) {
            return null;
        }
        if (z && !map.containsKey(Integer.valueOf(i2))) {
            this.mRecyclableViews.put(Integer.valueOf(i2), new Stack<>());
        }
        return this.mRecyclableViews.get(Integer.valueOf(i2));
    }

    public void addEventEmitters(@NonNull ThemedReactContext themedReactContext, @NonNull T t) {
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    @NonNull
    public T createView(int i2, @NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
        T t = (T) createViewInstance(i2, themedReactContext, reactStylesDiffMap, stateWrapper);
        if (t instanceof ReactInterceptingViewGroup) {
            ((ReactInterceptingViewGroup) t).setOnInterceptTouchEventListener(jSResponderHandler);
        }
        return t;
    }

    @NonNull
    public T createViewInstance(int i2, @NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Object objUpdateState;
        Stack<T> recyclableViewStack = getRecyclableViewStack(themedReactContext.f19481c, true);
        T t = (recyclableViewStack == null || recyclableViewStack.empty()) ? (T) createViewInstance(themedReactContext) : (T) recycleView(themedReactContext, recyclableViewStack.pop());
        t.setId(i2);
        addEventEmitters(themedReactContext, t);
        if (reactStylesDiffMap != null) {
            updateProperties(t, reactStylesDiffMap);
        }
        if (stateWrapper != null && (objUpdateState = updateState(t, reactStylesDiffMap, stateWrapper)) != null) {
            updateExtraData(t, objUpdateState);
        }
        return t;
    }

    @NonNull
    public abstract T createViewInstance(@NonNull ThemedReactContext themedReactContext);

    @UnstableReactNativeAPI
    public boolean experimental_isPrefetchingEnabled() {
        return ReactNativeFeatureFlags.f18968a.enableImagePrefetchingAndroid();
    }

    @UnstableReactNativeAPI
    public void experimental_prefetchResource(ReactContext reactContext, int i2, int i3, MapBuffer mapBuffer) {
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    @Nullable
    public ViewManagerDelegate<T> getDelegate() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public abstract String getName();

    public Map<String, String> getNativeProps() {
        Class<?> cls = getClass();
        Class<? extends C> shadowNodeClass = getShadowNodeClass();
        HashMap map = ViewManagerPropertyUpdater.f19597a;
        HashMap map2 = new HashMap();
        ViewManagerPropertyUpdater.c(cls).b(map2);
        ViewManagerPropertyUpdater.d(shadowNodeClass).b(map2);
        return map2;
    }

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, @Nullable float[] fArr) {
        return 0L;
    }

    public void onAfterUpdateTransaction(@NonNull T t) {
    }

    public void onDropViewInstance(@NonNull T t) {
        View viewPrepareToRecycleView;
        Context context = t.getContext();
        if (context == null) {
            FLog.g(NAME, "onDropViewInstance: view [" + t.getId() + "] has a null context");
            return;
        }
        if (context instanceof ThemedReactContext) {
            ThemedReactContext themedReactContext = (ThemedReactContext) context;
            Stack<T> recyclableViewStack = getRecyclableViewStack(themedReactContext.f19481c, false);
            if (recyclableViewStack == null || (viewPrepareToRecycleView = prepareToRecycleView(themedReactContext, t)) == null) {
                return;
            }
            recyclableViewStack.push(viewPrepareToRecycleView);
            return;
        }
        FLog.g(NAME, "onDropViewInstance: view [" + t.getId() + "] has a context that is not a ThemedReactContext: " + context);
    }

    public void onSurfaceStopped(int i2) {
        HashMap<Integer, Stack<T>> map = this.mRecyclableViews;
        if (map != null) {
            map.remove(Integer.valueOf(i2));
        }
    }

    @Nullable
    public abstract T prepareToRecycleView(@NonNull ThemedReactContext themedReactContext, @NonNull T t);

    @Deprecated
    public void receiveCommand(@NonNull T t, int i2, @Nullable ReadableArray readableArray) {
    }

    public T recycleView(@NonNull ThemedReactContext themedReactContext, @NonNull T t) {
        return t;
    }

    public void setPadding(T t, int i2, int i3, int i4, int i5) {
    }

    public void setupViewRecycling() {
        if (ReactNativeFeatureFlags.f18968a.enableViewRecycling()) {
            this.mRecyclableViews = new HashMap<>();
        }
    }

    public void trimMemory() {
        if (this.mRecyclableViews != null) {
            this.mRecyclableViews = new HashMap<>();
        }
    }

    public abstract void updateExtraData(@NonNull T t, Object obj);

    public void updateProperties(@NonNull T t, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerDelegate<T> delegate = getDelegate();
        if (delegate != null) {
            HashMap map = ViewManagerPropertyUpdater.f19597a;
            Iterator<Map.Entry<String, Object>> entryIterator = reactStylesDiffMap.f19469a.getEntryIterator();
            while (entryIterator.hasNext()) {
                Map.Entry<String, Object> next = entryIterator.next();
                delegate.a(t, next.getKey(), next.getValue());
            }
        } else {
            HashMap map2 = ViewManagerPropertyUpdater.f19597a;
            ViewManagerPropertyUpdater.ViewManagerSetter viewManagerSetterC = ViewManagerPropertyUpdater.c(getClass());
            Iterator<Map.Entry<String, Object>> entryIterator2 = reactStylesDiffMap.f19469a.getEntryIterator();
            while (entryIterator2.hasNext()) {
                Map.Entry<String, Object> next2 = entryIterator2.next();
                viewManagerSetterC.c(this, t, next2.getKey(), next2.getValue());
            }
        }
        onAfterUpdateTransaction(t);
    }

    @Nullable
    public Object updateState(@NonNull T t, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        return null;
    }

    @NonNull
    public C createShadowNodeInstance(@NonNull ReactApplicationContext reactApplicationContext) {
        return (C) createShadowNodeInstance();
    }

    public long measure(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, @Nullable MapBuffer mapBuffer3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, @Nullable float[] fArr) {
        return 0L;
    }

    public void receiveCommand(@NonNull T t, String str, @Nullable ReadableArray readableArray) {
        ViewManagerDelegate<T> delegate = getDelegate();
        if (delegate != null) {
            delegate.b(t, str, readableArray);
        }
    }

    public ViewManager(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRecyclableViews = null;
    }
}
