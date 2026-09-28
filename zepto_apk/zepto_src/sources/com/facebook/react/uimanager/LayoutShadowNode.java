package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaGutter;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

/* loaded from: classes.dex */
public class LayoutShadowNode extends ReactShadowNodeImpl {
    public final MutableYogaValue y = new MutableYogaValue();

    /* renamed from: com.facebook.react.uimanager.LayoutShadowNode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19388a;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            f19388a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19388a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19388a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19388a[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class MutableYogaValue {

        /* renamed from: a, reason: collision with root package name */
        public float f19389a;

        /* renamed from: b, reason: collision with root package name */
        public YogaUnit f19390b;

        public final void a(Dynamic dynamic) {
            boolean zIsNull = dynamic.isNull();
            YogaUnit yogaUnit = YogaUnit.UNDEFINED;
            if (zIsNull) {
                this.f19390b = yogaUnit;
                this.f19389a = Float.NaN;
                return;
            }
            if (dynamic.getType() != ReadableType.String) {
                if (dynamic.getType() == ReadableType.Number) {
                    this.f19390b = YogaUnit.POINT;
                    this.f19389a = PixelUtil.b((float) dynamic.asDouble());
                    return;
                } else {
                    this.f19390b = yogaUnit;
                    this.f19389a = Float.NaN;
                    return;
                }
            }
            String strAsString = dynamic.asString();
            if (strAsString.equals("auto")) {
                this.f19390b = YogaUnit.AUTO;
                this.f19389a = Float.NaN;
            } else if (strAsString.endsWith("%")) {
                this.f19390b = YogaUnit.PERCENT;
                this.f19389a = Float.parseFloat(strAsString.substring(0, strAsString.length() - 1));
            } else {
                FLog.q("ReactNative", "Unknown value: ".concat(strAsString));
                this.f19390b = yogaUnit;
                this.f19389a = Float.NaN;
            }
        }
    }

    public final int m0(int i2) {
        ThemedReactContext themedReactContext = this.f19459d;
        Assertions.c(themedReactContext);
        if (I18nUtil.a(themedReactContext)) {
            if (i2 == 0) {
                return 4;
            }
            if (i2 == 2) {
                return 5;
            }
        }
        return i2;
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(@Nullable String str) {
        if (J()) {
        }
        YogaAlign yogaAlign = YogaAlign.FLEX_START;
        if (str == null) {
            e0(yogaAlign);
            return;
        }
        switch (str) {
            case "stretch":
                e0(YogaAlign.STRETCH);
                break;
            case "baseline":
                e0(YogaAlign.BASELINE);
                break;
            case "center":
                e0(YogaAlign.CENTER);
                break;
            case "flex-start":
                e0(yogaAlign);
                break;
            case "auto":
                e0(YogaAlign.AUTO);
                break;
            case "space-between":
                e0(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                e0(YogaAlign.FLEX_END);
                break;
            case "space-around":
                e0(YogaAlign.SPACE_AROUND);
                break;
            case "space-evenly":
                e0(YogaAlign.SPACE_EVENLY);
                break;
            default:
                FLog.q("ReactNative", "invalid value for alignContent: ".concat(str));
                e0(yogaAlign);
                break;
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(@Nullable String str) {
        if (J()) {
        }
        YogaAlign yogaAlign = YogaAlign.STRETCH;
        if (str == null) {
            f0(yogaAlign);
            return;
        }
        switch (str) {
            case "stretch":
                f0(yogaAlign);
                break;
            case "baseline":
                f0(YogaAlign.BASELINE);
                break;
            case "center":
                f0(YogaAlign.CENTER);
                break;
            case "flex-start":
                f0(YogaAlign.FLEX_START);
                break;
            case "auto":
                f0(YogaAlign.AUTO);
                break;
            case "space-between":
                f0(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                f0(YogaAlign.FLEX_END);
                break;
            case "space-around":
                f0(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.q("ReactNative", "invalid value for alignItems: ".concat(str));
                f0(yogaAlign);
                break;
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(@Nullable String str) {
        if (J()) {
        }
        YogaAlign yogaAlign = YogaAlign.AUTO;
        if (str == null) {
            g0(yogaAlign);
            return;
        }
        switch (str) {
            case "stretch":
                g0(YogaAlign.STRETCH);
                break;
            case "baseline":
                g0(YogaAlign.BASELINE);
                break;
            case "center":
                g0(YogaAlign.CENTER);
                break;
            case "flex-start":
                g0(YogaAlign.FLEX_START);
                break;
            case "auto":
                g0(yogaAlign);
                break;
            case "space-between":
                g0(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                g0(YogaAlign.FLEX_END);
                break;
            case "space-around":
                g0(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.q("ReactNative", "invalid value for alignSelf: ".concat(str));
                g0(yogaAlign);
                break;
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f2) {
        this.u.w(f2);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i2, float f2) {
        if (J()) {
            return;
        }
        int iM0 = m0(ViewProps.f19620a[i2]);
        float fB = PixelUtil.b(f2);
        this.u.y(YogaEdge.a(iM0), fB);
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(boolean z) {
    }

    @ReactProp(name = "collapsableChildren")
    public void setCollapsableChildren(boolean z) {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "columnGap")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setColumnGap(com.facebook.react.bridge.Dynamic r6) {
        /*
            r5 = this;
            boolean r0 = r5.J()
            if (r0 == 0) goto L7
            return
        L7:
            com.facebook.react.uimanager.LayoutShadowNode$MutableYogaValue r0 = r5.y
            r0.a(r6)
            com.facebook.yoga.YogaUnit r1 = r0.f19390b
            int r1 = r1.ordinal()
            com.facebook.yoga.YogaNode r2 = r5.u
            com.facebook.yoga.YogaGutter r3 = com.facebook.yoga.YogaGutter.COLUMN
            if (r1 == 0) goto L28
            r4 = 1
            if (r1 == r4) goto L28
            r4 = 2
            if (r1 == r4) goto L22
            r4 = 3
            if (r1 == r4) goto L28
            goto L2d
        L22:
            float r0 = r0.f19389a
            r2.K(r3, r0)
            goto L2d
        L28:
            float r0 = r0.f19389a
            r2.J(r3, r0)
        L2d:
            r6.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.LayoutShadowNode.setColumnGap(com.facebook.react.bridge.Dynamic):void");
    }

    @ReactProp(name = "display")
    public void setDisplay(@Nullable String str) {
        YogaNode yogaNode = this.u;
        if (J()) {
            return;
        }
        YogaDisplay yogaDisplay = YogaDisplay.FLEX;
        if (str == null) {
            yogaNode.B(yogaDisplay);
            return;
        }
        if (str.equals("flex")) {
            yogaNode.B(yogaDisplay);
        } else if (str.equals("none")) {
            yogaNode.B(YogaDisplay.NONE);
        } else {
            FLog.q("ReactNative", "invalid value for display: ".concat(str));
            yogaNode.B(yogaDisplay);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f2) {
        if (J()) {
            return;
        }
        this.u.C(f2);
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        YogaNode yogaNode = this.u;
        if (iOrdinal == 0 || iOrdinal == 1) {
            yogaNode.D(mutableYogaValue.f19389a);
        } else if (iOrdinal == 2) {
            yogaNode.F(mutableYogaValue.f19389a);
        } else if (iOrdinal == 3) {
            yogaNode.E();
        }
        dynamic.recycle();
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(@Nullable String str) {
        if (J()) {
        }
        YogaFlexDirection yogaFlexDirection = YogaFlexDirection.COLUMN;
        if (str == null) {
            h0(yogaFlexDirection);
            return;
        }
        switch (str) {
            case "row-reverse":
                h0(YogaFlexDirection.ROW_REVERSE);
                break;
            case "column":
                h0(yogaFlexDirection);
                break;
            case "row":
                h0(YogaFlexDirection.ROW);
                break;
            case "column-reverse":
                h0(YogaFlexDirection.COLUMN_REVERSE);
                break;
            default:
                FLog.q("ReactNative", "invalid value for flexDirection: ".concat(str));
                h0(yogaFlexDirection);
                break;
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f2) {
        if (J()) {
            return;
        }
        this.u.H(f2);
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f2) {
        if (J()) {
            return;
        }
        this.u.I(f2);
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(@Nullable String str) {
        YogaNode yogaNode = this.u;
        if (J()) {
        }
        YogaWrap yogaWrap = YogaWrap.NO_WRAP;
        if (str == null) {
            yogaNode.o0(yogaWrap);
            return;
        }
        switch (str) {
            case "nowrap":
                yogaNode.o0(yogaWrap);
                break;
            case "wrap-reverse":
                yogaNode.o0(YogaWrap.WRAP_REVERSE);
                break;
            case "wrap":
                yogaNode.o0(YogaWrap.WRAP);
                break;
            default:
                FLog.q("ReactNative", "invalid value for flexWrap: ".concat(str));
                yogaNode.o0(yogaWrap);
                break;
        }
    }

    @ReactProp(name = "gap")
    public void setGap(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        YogaNode yogaNode = this.u;
        YogaGutter yogaGutter = YogaGutter.ALL;
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            yogaNode.J(yogaGutter, mutableYogaValue.f19389a);
        }
        dynamic.recycle();
    }

    @ReactProp(name = Snapshot.HEIGHT)
    public void setHeight(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            c(mutableYogaValue.f19389a);
        } else {
            YogaNode yogaNode = this.u;
            if (iOrdinal == 2) {
                yogaNode.O(mutableYogaValue.f19389a);
            } else if (iOrdinal == 3) {
                yogaNode.M();
            }
        }
        dynamic.recycle();
    }

    @ReactProp(name = "inset")
    public void setInset(Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetBlock", "insetBlockEnd", "insetBlockStart"})
    public void setInsetBlock(int i2, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetInline", "insetInlineEnd", "insetInlineStart"})
    public void setInsetInline(int i2, Dynamic dynamic) {
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(@Nullable String str) {
        if (J()) {
        }
        YogaJustify yogaJustify = YogaJustify.FLEX_START;
        if (str == null) {
            i0(yogaJustify);
            return;
        }
        switch (str) {
            case "center":
                i0(YogaJustify.CENTER);
                break;
            case "flex-start":
                i0(yogaJustify);
                break;
            case "space-between":
                i0(YogaJustify.SPACE_BETWEEN);
                break;
            case "flex-end":
                i0(YogaJustify.FLEX_END);
                break;
            case "space-around":
                i0(YogaJustify.SPACE_AROUND);
                break;
            case "space-evenly":
                i0(YogaJustify.SPACE_EVENLY);
                break;
            default:
                FLog.q("ReactNative", "invalid value for justifyContent: ".concat(str));
                i0(yogaJustify);
                break;
        }
    }

    @ReactPropGroup(names = {"marginBlock", "marginBlockEnd", "marginBlockStart"})
    public void setMarginBlock(int i2, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"marginInline", "marginInlineEnd", "marginInlineStart"})
    public void setMarginInline(int i2, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i2, Dynamic dynamic) {
        if (J()) {
            return;
        }
        int iM0 = m0(ViewProps.f19621b[i2]);
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            j0(mutableYogaValue.f19389a, iM0);
        } else {
            YogaNode yogaNode = this.u;
            if (iOrdinal == 2) {
                yogaNode.S(YogaEdge.a(iM0), mutableYogaValue.f19389a);
            } else if (iOrdinal == 3) {
                yogaNode.R(YogaEdge.a(iM0));
            }
        }
        dynamic.recycle();
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        YogaNode yogaNode = this.u;
        if (iOrdinal == 0 || iOrdinal == 1) {
            yogaNode.T(mutableYogaValue.f19389a);
        } else if (iOrdinal == 2) {
            yogaNode.U(mutableYogaValue.f19389a);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        YogaNode yogaNode = this.u;
        if (iOrdinal == 0 || iOrdinal == 1) {
            yogaNode.V(mutableYogaValue.f19389a);
        } else if (iOrdinal == 2) {
            yogaNode.W(mutableYogaValue.f19389a);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        YogaNode yogaNode = this.u;
        if (iOrdinal == 0 || iOrdinal == 1) {
            yogaNode.Y(mutableYogaValue.f19389a);
        } else if (iOrdinal == 2) {
            yogaNode.a0(mutableYogaValue.f19389a);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        YogaNode yogaNode = this.u;
        if (iOrdinal == 0 || iOrdinal == 1) {
            yogaNode.b0(mutableYogaValue.f19389a);
        } else if (iOrdinal == 2) {
            yogaNode.c0(mutableYogaValue.f19389a);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "overflow")
    public void setOverflow(@Nullable String str) {
        YogaNode yogaNode = this.u;
        if (J()) {
        }
        YogaOverflow yogaOverflow = YogaOverflow.VISIBLE;
        if (str == null) {
            yogaNode.d0(yogaOverflow);
            return;
        }
        switch (str) {
            case "hidden":
                yogaNode.d0(YogaOverflow.HIDDEN);
                break;
            case "scroll":
                yogaNode.d0(YogaOverflow.SCROLL);
                break;
            case "visible":
                yogaNode.d0(yogaOverflow);
                break;
            default:
                FLog.q("ReactNative", "invalid value for overflow: ".concat(str));
                yogaNode.d0(yogaOverflow);
                break;
        }
    }

    @ReactPropGroup(names = {"paddingBlock", "paddingBlockEnd", "paddingBlockStart"})
    public void setPaddingBlock(int i2, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingInline", "paddingInlineEnd", "paddingInlineStart"})
    public void setPaddingInline(int i2, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i2, Dynamic dynamic) {
        if (J()) {
            return;
        }
        int iM0 = m0(ViewProps.f19621b[i2]);
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            w(mutableYogaValue.f19389a, iM0);
        } else if (iOrdinal == 2) {
            this.s[iM0] = mutableYogaValue.f19389a;
            this.t[iM0] = !YogaConstants.a(r0);
            l0();
        }
        dynamic.recycle();
    }

    @ReactProp(name = "position")
    public void setPosition(@Nullable String str) {
        YogaNode yogaNode = this.u;
        if (J()) {
            return;
        }
        YogaPositionType yogaPositionType = YogaPositionType.RELATIVE;
        if (str == null) {
            yogaNode.i0(yogaPositionType);
            return;
        }
        if (str.equals("relative")) {
            yogaNode.i0(yogaPositionType);
        } else if (str.equals("absolute")) {
            yogaNode.i0(YogaPositionType.ABSOLUTE);
        } else {
            FLog.q("ReactNative", "invalid value for position: ".concat(str));
            yogaNode.i0(yogaPositionType);
        }
    }

    @ReactPropGroup(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i2, Dynamic dynamic) {
        YogaNode yogaNode = this.u;
        if (J()) {
            return;
        }
        int iM0 = m0(new int[]{4, 5, 0, 2, 1, 3}[i2]);
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            yogaNode.g0(YogaEdge.a(iM0), mutableYogaValue.f19389a);
        } else if (iOrdinal == 2) {
            yogaNode.h0(YogaEdge.a(iM0), mutableYogaValue.f19389a);
        }
        dynamic.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "rowGap")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setRowGap(com.facebook.react.bridge.Dynamic r6) {
        /*
            r5 = this;
            boolean r0 = r5.J()
            if (r0 == 0) goto L7
            return
        L7:
            com.facebook.react.uimanager.LayoutShadowNode$MutableYogaValue r0 = r5.y
            r0.a(r6)
            com.facebook.yoga.YogaUnit r1 = r0.f19390b
            int r1 = r1.ordinal()
            com.facebook.yoga.YogaNode r2 = r5.u
            com.facebook.yoga.YogaGutter r3 = com.facebook.yoga.YogaGutter.ROW
            if (r1 == 0) goto L28
            r4 = 1
            if (r1 == r4) goto L28
            r4 = 2
            if (r1 == r4) goto L22
            r4 = 3
            if (r1 == r4) goto L28
            goto L2d
        L22:
            float r0 = r0.f19389a
            r2.K(r3, r0)
            goto L2d
        L28:
            float r0 = r0.f19389a
            r2.J(r3, r0)
        L2d:
            r6.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.LayoutShadowNode.setRowGap(com.facebook.react.bridge.Dynamic):void");
    }

    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        this.f19460e = z;
    }

    @ReactProp(name = "onPointerEnter")
    public void setShouldNotifyPointerEnter(boolean z) {
    }

    @ReactProp(name = "onPointerLeave")
    public void setShouldNotifyPointerLeave(boolean z) {
    }

    @ReactProp(name = "onPointerMove")
    public void setShouldNotifyPointerMove(boolean z) {
    }

    @ReactProp(name = Snapshot.WIDTH)
    public void setWidth(Dynamic dynamic) {
        if (J()) {
            return;
        }
        MutableYogaValue mutableYogaValue = this.y;
        mutableYogaValue.a(dynamic);
        int iOrdinal = mutableYogaValue.f19390b.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            K(mutableYogaValue.f19389a);
        } else {
            YogaNode yogaNode = this.u;
            if (iOrdinal == 2) {
                yogaNode.m0(mutableYogaValue.f19389a);
            } else if (iOrdinal == 3) {
                yogaNode.k0();
            }
        }
        dynamic.recycle();
    }
}
