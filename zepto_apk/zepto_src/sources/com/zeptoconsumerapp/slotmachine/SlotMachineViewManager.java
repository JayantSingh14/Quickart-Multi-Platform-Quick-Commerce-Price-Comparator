package com.zeptoconsumerapp.slotmachine;

import android.support.v4.media.b;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class SlotMachineViewManager extends SimpleViewManager<SlotMachineView> {
    private SlotMachineView slotMachineView;

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "SlotMachineView";
    }

    @ReactProp(name = "animateFromStart")
    public final void setAnimateFromStart(@NotNull SlotMachineView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAnimateFromStart(z);
    }

    @ReactProp(name = "color")
    public final void setColor(@NotNull SlotMachineView view, @NotNull String hex) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(hex, "hex");
        view.setColor(hex);
    }

    @ReactProp(name = "fixedCharWidth")
    public final void setFixedCharWidth(@NotNull SlotMachineView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFixedCharWidth(f2);
    }

    @ReactProp(name = "fontFamily")
    public final void setFontFamily(@NotNull SlotMachineView view, @NotNull String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
        view.setFontFamily(value);
    }

    @ReactProp(name = "fontSize")
    public final void setFontSize(@NotNull SlotMachineView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontSize(f2);
    }

    @ReactProp(name = "initialValue")
    public final void setInitialValue(@NotNull SlotMachineView view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setInitialValue(i2);
    }

    @ReactProp(name = "letterSpacing")
    public final void setLetterSpacing(@NotNull SlotMachineView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLetterSpacing(f2);
    }

    @ReactProp(name = "rupeeFormatted")
    public final void setRupeeFormatted(@NotNull SlotMachineView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.q = z;
    }

    @ReactProp(name = "separatorColor")
    public final void setSeparatorColor(@NotNull SlotMachineView view, @NotNull String separatorColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(separatorColor, "separatorColor");
        view.setSeparatorColor(separatorColor);
    }

    @ReactProp(name = "separatorWidth")
    public final void setSeparatorWidth(@NotNull SlotMachineView view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSeparatorWidth(f2);
    }

    @ReactProp(name = CLConstants.FIELD_PAY_INFO_VALUE)
    public final void setValue(@NotNull SlotMachineView view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setCurrentValue(i2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public SlotMachineView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        SlotMachineView slotMachineView = new SlotMachineView(reactContext);
        this.slotMachineView = slotMachineView;
        return slotMachineView;
    }

    @ReactProp(name = "isReady")
    public final void setColor(@NotNull SlotMachineView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.o = z;
        if (view.p && z) {
            if (view.q) {
                view.f(b.f(view.u, "₹"), view.b(view.f47817b));
            } else {
                view.f(String.valueOf(view.u), String.valueOf(view.f47817b));
            }
            view.e();
            view.h();
        }
    }
}
