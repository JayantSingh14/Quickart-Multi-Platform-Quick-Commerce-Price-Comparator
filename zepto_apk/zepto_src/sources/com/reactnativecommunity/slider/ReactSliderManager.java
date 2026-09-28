package com.reactnativecommunity.slider;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.widget.SeekBar;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNodeJNIBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class ReactSliderManager extends SimpleViewManager<ReactSlider> {
    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new AnonymousClass1();

    /* renamed from: com.reactnativecommunity.slider.ReactSliderManager$1, reason: invalid class name */
    public class AnonymousClass1 implements SeekBar.OnSeekBarChangeListener {
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            ReactSlider reactSlider = (ReactSlider) seekBar;
            if (i2 < reactSlider.getLowerLimit()) {
                i2 = reactSlider.getLowerLimit();
            } else if (i2 > reactSlider.getUpperLimit()) {
                i2 = reactSlider.getUpperLimit();
            }
            seekBar.setProgress(i2);
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            if (z) {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().g(new ReactSliderEvent(seekBar.getId(), reactSlider.a(i2)));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.f46211e = true;
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().g(new ReactSlidingStartEvent(seekBar.getId(), reactSlider.a(seekBar.getProgress())));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.f46211e = false;
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().g(new ReactSlidingCompleteEvent(seekBar.getId(), reactSlider.a(seekBar.getProgress())));
        }
    }

    public static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        public int z;

        @Override // com.facebook.yoga.YogaMeasureFunction
        public final long h(YogaNodeJNIBase yogaNodeJNIBase, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
            ThemedReactContext themedReactContext = this.f19459d;
            Assertions.c(themedReactContext);
            ReactSlider reactSlider = new ReactSlider(themedReactContext, null);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            reactSlider.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.z = reactSlider.getMeasuredWidth();
            return YogaMeasureOutput.a(this.z, reactSlider.getMeasuredHeight());
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.c("topChange", MapBuilder.c("registrationName", "topChange"));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.d("onRNCSliderSlidingStart", MapBuilder.c("registrationName", "onRNCSliderSlidingStart"), "onRNCSliderSlidingComplete", MapBuilder.c("registrationName", "onRNCSliderSlidingComplete"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCSlider";
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    @ReactProp(name = "accessibilityIncrements")
    public void setAccessibilityIncrements(ReactSlider reactSlider, ReadableArray readableArray) {
        ArrayList<Object> arrayList = readableArray.toArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) it.next());
        }
        reactSlider.setAccessibilityIncrements(arrayList2);
    }

    @ReactProp(name = "accessibilityUnits")
    public void setAccessibilityUnits(ReactSlider reactSlider, String str) {
        reactSlider.setAccessibilityUnits(str);
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSlider reactSlider, boolean z) {
        reactSlider.setEnabled(!z);
    }

    @ReactProp(defaultBoolean = false, name = "inverted")
    public void setInverted(ReactSlider reactSlider, boolean z) {
        if (z) {
            reactSlider.setScaleX(-1.0f);
        } else {
            reactSlider.setScaleX(1.0f);
        }
    }

    @ReactProp(name = "lowerLimit")
    public void setLowerLimit(ReactSlider reactSlider, double d2) {
        reactSlider.setLowerLimit(d2);
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable drawableFindDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(android.R.id.background);
        if (num == null) {
            drawableFindDrawableByLayerId.clearColorFilter();
        } else if (Build.VERSION.SDK_INT > 28) {
            drawableFindDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableFindDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d2) {
        reactSlider.setMaxValue(d2);
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable drawableFindDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(android.R.id.progress);
        if (num == null) {
            drawableFindDrawableByLayerId.clearColorFilter();
        } else if (Build.VERSION.SDK_INT > 28) {
            drawableFindDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableFindDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d2) {
        reactSlider.setMinValue(d2);
    }

    @ReactProp(defaultDouble = 0.0d, name = "step")
    public void setStep(ReactSlider reactSlider, double d2) {
        reactSlider.setStep(d2);
    }

    @ReactProp(name = "thumbImage")
    public void setThumbImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
        reactSlider.setThumbImage(readableMap != null ? readableMap.getString("uri") : null);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        if (reactSlider.getThumb() != null) {
            if (num == null) {
                reactSlider.getThumb().clearColorFilter();
            } else {
                reactSlider.getThumb().setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    @ReactProp(name = "upperLimit")
    public void setUpperLimit(ReactSlider reactSlider, float f2) {
        reactSlider.setUpperLimit(f2);
    }

    @ReactProp(defaultFloat = 0.0f, name = CLConstants.FIELD_PAY_INFO_VALUE)
    public void setValue(ReactSlider reactSlider, float f2) {
        double d2 = f2;
        if (reactSlider.f46211e) {
            return;
        }
        reactSlider.setValue(d2);
        if (!reactSlider.isAccessibilityFocused() || Build.VERSION.SDK_INT <= 29) {
            return;
        }
        reactSlider.setupAccessibility((int) d2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        ReactSliderShadowNode reactSliderShadowNode = new ReactSliderShadowNode();
        reactSliderShadowNode.u.X(reactSliderShadowNode);
        return reactSliderShadowNode;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        ReactSlider reactSlider = new ReactSlider(themedReactContext, null);
        reactSlider.setSplitTrack(false);
        return reactSlider;
    }
}
