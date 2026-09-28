package com.facebook.react.views.textinput;

import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.view.MeasureUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNodeJNIBase;
import java.util.WeakHashMap;

@VisibleForTesting
/* loaded from: classes.dex */
public class ReactTextInputShadowNode extends ReactBaseTextShadowNode implements YogaMeasureFunction {
    public int a0;
    public EditText b0;
    public ReactTextInputLocalData c0;
    public String d0;
    public String e0;

    public ReactTextInputShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        this.a0 = -1;
        this.d0 = null;
        this.e0 = null;
        this.J = 1;
        this.u.X(this);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public final boolean b0() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public final void d0(UIViewOperationQueue uIViewOperationQueue) {
        if (this.a0 != -1) {
            uIViewOperationQueue.c(this.f19456a, new ReactTextUpdate(o0(this, this.d0, false, null), this.a0, this.Y, Y(0), Y(1), Y(2), Y(3), this.I, this.J, this.K));
        }
    }

    @Override // com.facebook.yoga.YogaMeasureFunction
    public final long h(YogaNodeJNIBase yogaNodeJNIBase, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
        EditText editText = this.b0;
        Assertions.c(editText);
        ReactTextInputLocalData reactTextInputLocalData = this.c0;
        if (reactTextInputLocalData != null) {
            editText.setText(reactTextInputLocalData.f20199a);
            editText.setTextSize(0, reactTextInputLocalData.f20200b);
            editText.setMinLines(reactTextInputLocalData.f20201c);
            editText.setMaxLines(reactTextInputLocalData.f20202d);
            editText.setInputType(reactTextInputLocalData.f20203e);
            editText.setHint(reactTextInputLocalData.f20205g);
            editText.setBreakStrategy(reactTextInputLocalData.f20204f);
        } else {
            editText.setTextSize(0, this.A.a());
            int i2 = this.H;
            if (i2 != -1) {
                editText.setLines(i2);
            }
            int breakStrategy = editText.getBreakStrategy();
            int i3 = this.J;
            if (breakStrategy != i3) {
                editText.setBreakStrategy(i3);
            }
        }
        editText.setHint(this.e0);
        editText.measure(MeasureUtil.a(f2, yogaMeasureMode), MeasureUtil.a(f3, yogaMeasureMode2));
        return YogaMeasureOutput.a(editText.getMeasuredWidth(), editText.getMeasuredHeight());
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void n(ThemedReactContext themedReactContext) {
        this.f19459d = themedReactContext;
        ThemedReactContext themedReactContext2 = this.f19459d;
        Assertions.c(themedReactContext2);
        EditText editText = new EditText(new ContextThemeWrapper(themedReactContext2, R.style.Theme_ReactNative_TextInput_DefaultBackground));
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        float paddingStart = editText.getPaddingStart();
        Spacing spacing = this.r;
        spacing.b(paddingStart, 4);
        l0();
        spacing.b(editText.getPaddingTop(), 1);
        l0();
        spacing.b(editText.getPaddingEnd(), 5);
        l0();
        spacing.b(editText.getPaddingBottom(), 3);
        l0();
        this.b0 = editText;
        editText.setPadding(0, 0, 0, 0);
        this.b0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void q(Object obj) {
        Assertions.a(obj instanceof ReactTextInputLocalData);
        this.c0 = (ReactTextInputLocalData) obj;
        D();
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i2) {
        this.a0 = i2;
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(@Nullable String str) {
        this.e0 = str;
        c0();
    }

    @ReactProp(name = "text")
    public void setText(@Nullable String str) {
        this.d0 = str;
        c0();
    }

    @Override // com.facebook.react.views.text.ReactBaseTextShadowNode
    public final void setTextBreakStrategy(String str) {
        if (str == null || "simple".equals(str)) {
            this.J = 0;
            return;
        }
        if ("highQuality".equals(str)) {
            this.J = 1;
        } else if ("balanced".equals(str)) {
            this.J = 2;
        } else {
            FLog.q("ReactNative", "Invalid textBreakStrategy: ".concat(str));
            this.J = 0;
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public final void w(float f2, int i2) {
        super.w(f2, i2);
        c0();
    }

    public ReactTextInputShadowNode() {
        this(null);
    }
}
