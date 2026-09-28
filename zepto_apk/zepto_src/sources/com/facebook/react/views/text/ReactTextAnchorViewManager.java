package com.facebook.react.views.text;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.google.android.gms.common.api.Api;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.zeptoconsumerapp.BuildConfig;

/* loaded from: classes.dex */
public abstract class ReactTextAnchorViewManager<T extends View, C extends ReactBaseTextShadowNode> extends BaseViewManager<T, C> {
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};
    private static final String TAG = "ReactTextAnchorViewManager";

    @ReactProp(name = "accessible")
    public void setAccessible(ReactTextView reactTextView, boolean z) {
        reactTextView.setFocusable(z);
    }

    @ReactProp(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(ReactTextView reactTextView, boolean z) {
        reactTextView.setAdjustFontSizeToFit(z);
    }

    @ReactProp(name = "android_hyphenationFrequency")
    public void setAndroidHyphenationFrequency(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || str.equals("none")) {
            reactTextView.setHyphenationFrequency(0);
            return;
        }
        if (str.equals("full")) {
            reactTextView.setHyphenationFrequency(2);
        } else if (str.equals("normal")) {
            reactTextView.setHyphenationFrequency(1);
        } else {
            FLog.q("ReactNative", "Invalid android_hyphenationFrequency: ".concat(str));
            reactTextView.setHyphenationFrequency(0);
        }
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactTextView reactTextView, int i2, @Nullable Integer num) {
        BackgroundStyleApplicator.k(reactTextView, LogicalEdge.f19899b, num);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {Snapshot.BORDER_RADIUS, Snapshot.BORDER_TOP_LEFT_RADIUS, Snapshot.BORDER_TOP_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(ReactTextView reactTextView, int i2, float f2) {
        BackgroundStyleApplicator.l(reactTextView, BorderRadiusProp.values()[i2], Float.isNaN(f2) ? null : new LengthPercentage(f2, LengthPercentageType.f19394a));
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactTextView reactTextView, @Nullable String str) {
        BackgroundStyleApplicator.m(reactTextView, str == null ? null : BorderStyle.a(str));
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(ReactTextView reactTextView, int i2, float f2) {
        BackgroundStyleApplicator.n(reactTextView, LogicalEdge.values()[i2], Float.valueOf(f2));
    }

    @ReactProp(name = "dataDetectorType")
    public void setDataDetectorType(ReactTextView reactTextView, @Nullable String str) {
        if (str != null) {
            switch (str) {
                case "phoneNumber":
                    reactTextView.setLinkifyMask(4);
                    break;
                case "all":
                    reactTextView.setLinkifyMask(15);
                    break;
                case "link":
                    reactTextView.setLinkifyMask(1);
                    break;
                case "email":
                    reactTextView.setLinkifyMask(2);
                    break;
            }
            return;
        }
        reactTextView.setLinkifyMask(0);
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactTextView reactTextView, boolean z) {
        reactTextView.setEnabled(!z);
    }

    @ReactProp(name = "ellipsizeMode")
    public void setEllipsizeMode(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || str.equals("tail")) {
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.END);
            return;
        }
        if (str.equals("head")) {
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.START);
            return;
        }
        if (str.equals("middle")) {
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.MIDDLE);
        } else if (str.equals("clip")) {
            reactTextView.setEllipsizeLocation(null);
        } else {
            FLog.q("ReactNative", "Invalid ellipsizeMode: ".concat(str));
            reactTextView.setEllipsizeLocation(TextUtils.TruncateAt.END);
        }
    }

    @ReactProp(name = "fontSize")
    public void setFontSize(ReactTextView reactTextView, float f2) {
        reactTextView.setFontSize(f2);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactTextView reactTextView, boolean z) {
        reactTextView.setIncludeFontPadding(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactTextView reactTextView, float f2) {
        reactTextView.setLetterSpacing(f2);
    }

    @ReactProp(name = "onInlineViewLayout")
    public void setNotifyOnInlineViewLayout(ReactTextView reactTextView, boolean z) {
        reactTextView.setNotifyOnInlineViewLayout(z);
    }

    @ReactProp(defaultInt = Api.BaseClientBuilder.API_PRIORITY_OTHER, name = "numberOfLines")
    public void setNumberOfLines(ReactTextView reactTextView, int i2) {
        reactTextView.setNumberOfLines(i2);
    }

    @ReactProp(name = "selectable")
    public void setSelectable(ReactTextView reactTextView, boolean z) {
        reactTextView.setTextIsSelectable(z);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactTextView reactTextView, @Nullable Integer num) {
        if (num == null) {
            reactTextView.setHighlightColor(DefaultStyleValuesUtil.c(reactTextView.getContext()));
        } else {
            reactTextView.setHighlightColor(num.intValue());
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactTextView.setGravityVertical(0);
            return;
        }
        if ("top".equals(str)) {
            reactTextView.setGravityVertical(48);
            return;
        }
        if ("bottom".equals(str)) {
            reactTextView.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactTextView.setGravityVertical(16);
        } else {
            FLog.q("ReactNative", "Invalid textAlignVertical: ".concat(str));
            reactTextView.setGravityVertical(0);
        }
    }
}
