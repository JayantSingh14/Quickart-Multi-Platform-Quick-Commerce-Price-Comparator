package com.facebook.react.views.text;

import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.internal.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactClickableSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTagSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.internal.span.SetSpanOperation;
import com.facebook.react.views.text.internal.span.ShadowStyleSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.zeptoconsumerapp.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public abstract class ReactBaseTextShadowNode extends LayoutShadowNode {
    public final TextAttributes A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public ReactAccessibilityDelegate.AccessibilityRole F;
    public ReactAccessibilityDelegate.Role G;
    public int H;
    public int I;
    public int J;
    public int K;
    public float L;
    public float M;
    public float N;
    public int O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public float T;
    public int U;
    public int V;
    public String W;
    public String X;
    public boolean Y;
    public HashMap Z;
    public final ReactTextViewManagerCallback z;

    public ReactBaseTextShadowNode() {
        this(null);
    }

    public static void n0(ReactBaseTextShadowNode reactBaseTextShadowNode, SpannableStringBuilder spannableStringBuilder, ArrayList arrayList, TextAttributes textAttributes, boolean z, HashMap map, int i2) {
        TextAttributes textAttributes2;
        float f2;
        float f3;
        if (textAttributes != null) {
            TextAttributes textAttributes3 = reactBaseTextShadowNode.A;
            textAttributes2 = new TextAttributes();
            textAttributes2.f20128a = textAttributes.f20128a;
            textAttributes2.f20129b = !Float.isNaN(textAttributes3.f20129b) ? textAttributes3.f20129b : textAttributes.f20129b;
            textAttributes2.f20130c = !Float.isNaN(textAttributes3.f20130c) ? textAttributes3.f20130c : textAttributes.f20130c;
            textAttributes2.f20131d = !Float.isNaN(textAttributes3.f20131d) ? textAttributes3.f20131d : textAttributes.f20131d;
            textAttributes2.f20132e = !Float.isNaN(textAttributes3.f20132e) ? textAttributes3.f20132e : textAttributes.f20132e;
            textAttributes2.f20133f = !Float.isNaN(textAttributes3.f20133f) ? textAttributes3.f20133f : textAttributes.f20133f;
            TextTransform textTransform = textAttributes3.f20134g;
            if (textTransform == TextTransform.f20142f) {
                textTransform = textAttributes.f20134g;
            }
            textAttributes2.f20134g = textTransform;
        } else {
            textAttributes2 = reactBaseTextShadowNode.A;
        }
        TextAttributes textAttributes4 = textAttributes2;
        int iF = reactBaseTextShadowNode.f();
        for (int i3 = 0; i3 < iF; i3++) {
            ReactShadowNodeImpl reactShadowNodeImplA = reactBaseTextShadowNode.a(i3);
            if (reactShadowNodeImplA instanceof ReactRawTextShadowNode) {
                spannableStringBuilder.append((CharSequence) TextTransform.a(((ReactRawTextShadowNode) reactShadowNodeImplA).y, textAttributes4.f20134g));
            } else {
                if (reactShadowNodeImplA instanceof ReactBaseTextShadowNode) {
                    n0((ReactBaseTextShadowNode) reactShadowNodeImplA, spannableStringBuilder, arrayList, textAttributes4, z, map, spannableStringBuilder.length());
                } else if (reactShadowNodeImplA instanceof ReactTextInlineImageShadowNode) {
                    spannableStringBuilder.append("0");
                    arrayList.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ((ReactTextInlineImageShadowNode) reactShadowNodeImplA).n0()));
                } else {
                    if (!z) {
                        throw new IllegalViewOperationException("Unexpected view type nested under a <Text> or <TextInput> node: " + reactShadowNodeImplA.getClass());
                    }
                    int i4 = reactShadowNodeImplA.f19456a;
                    YogaNode yogaNode = reactShadowNodeImplA.u;
                    YogaValue yogaValueK = yogaNode.k();
                    YogaValue yogaValueD = yogaNode.d();
                    YogaUnit yogaUnit = YogaUnit.POINT;
                    if (yogaValueK.f20426b == yogaUnit && yogaValueD.f20426b == yogaUnit) {
                        f3 = yogaValueK.f20425a;
                        f2 = yogaValueD.f20425a;
                    } else {
                        reactShadowNodeImplA.I();
                        float fH = yogaNode.h();
                        f2 = yogaNode.f();
                        f3 = fH;
                    }
                    spannableStringBuilder.append("0");
                    arrayList.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i4, (int) f3, (int) f2)));
                    map.put(Integer.valueOf(i4), reactShadowNodeImplA);
                }
                reactShadowNodeImplA.b();
            }
            reactShadowNodeImplA.b();
        }
        int length = spannableStringBuilder.length();
        if (length >= i2) {
            if (reactBaseTextShadowNode.B) {
                arrayList.add(new SetSpanOperation(i2, length, new ReactForegroundColorSpan(reactBaseTextShadowNode.C)));
            }
            if (reactBaseTextShadowNode.D) {
                arrayList.add(new SetSpanOperation(i2, length, new ReactBackgroundColorSpan(reactBaseTextShadowNode.E)));
            }
            ReactAccessibilityDelegate.Role role = reactBaseTextShadowNode.G;
            if (role == null ? reactBaseTextShadowNode.F == ReactAccessibilityDelegate.AccessibilityRole.f19442d : role == ReactAccessibilityDelegate.Role.f19452a) {
                arrayList.add(new SetSpanOperation(i2, length, new ReactClickableSpan(reactBaseTextShadowNode.f19456a)));
            }
            float fB = textAttributes4.b();
            if (!Float.isNaN(fB) && (textAttributes == null || textAttributes.b() != fB)) {
                arrayList.add(new SetSpanOperation(i2, length, new CustomLetterSpacingSpan(fB)));
            }
            int iA = textAttributes4.a();
            if (textAttributes == null || textAttributes.a() != iA) {
                arrayList.add(new SetSpanOperation(i2, length, new ReactAbsoluteSizeSpan(iA)));
            }
            if (reactBaseTextShadowNode.U != -1 || reactBaseTextShadowNode.V != -1 || reactBaseTextShadowNode.W != null) {
                int i5 = reactBaseTextShadowNode.U;
                int i6 = reactBaseTextShadowNode.V;
                String str = reactBaseTextShadowNode.X;
                String str2 = reactBaseTextShadowNode.W;
                ThemedReactContext themedReactContext = reactBaseTextShadowNode.f19459d;
                Assertions.c(themedReactContext);
                arrayList.add(new SetSpanOperation(i2, length, new CustomStyleSpan(i5, i6, str, str2, themedReactContext.getAssets())));
            }
            if (reactBaseTextShadowNode.P) {
                arrayList.add(new SetSpanOperation(i2, length, new ReactUnderlineSpan()));
            }
            if (reactBaseTextShadowNode.Q) {
                arrayList.add(new SetSpanOperation(i2, length, new ReactStrikethroughSpan()));
            }
            if ((reactBaseTextShadowNode.L != 0.0f || reactBaseTextShadowNode.M != 0.0f || reactBaseTextShadowNode.N != 0.0f) && Color.alpha(reactBaseTextShadowNode.O) != 0) {
                arrayList.add(new SetSpanOperation(i2, length, new ShadowStyleSpan(reactBaseTextShadowNode.L, reactBaseTextShadowNode.M, reactBaseTextShadowNode.N, reactBaseTextShadowNode.O)));
            }
            float fC = textAttributes4.c();
            if (!Float.isNaN(fC) && (textAttributes == null || textAttributes.c() != fC)) {
                arrayList.add(new SetSpanOperation(i2, length, new CustomLineHeightSpan(fC)));
            }
            arrayList.add(new SetSpanOperation(i2, length, new ReactTagSpan(reactBaseTextShadowNode.f19456a)));
        }
    }

    public final SpannableStringBuilder o0(ReactBaseTextShadowNode reactBaseTextShadowNode, String str, boolean z, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        int iB;
        Assertions.b((z && nativeViewHierarchyOptimizer == null) ? false : true, "nativeViewHierarchyOptimizer is required when inline views are supported");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        HashMap map = z ? new HashMap() : null;
        if (str != null) {
            spannableStringBuilder.append((CharSequence) TextTransform.a(str, reactBaseTextShadowNode.A.f20134g));
        }
        n0(reactBaseTextShadowNode, spannableStringBuilder, arrayList, null, z, map, 0);
        reactBaseTextShadowNode.Y = false;
        reactBaseTextShadowNode.Z = map;
        float f2 = Float.NaN;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            SetSpanOperation setSpanOperation = (SetSpanOperation) arrayList.get((arrayList.size() - i2) - 1);
            ReactSpan reactSpan = setSpanOperation.f20170c;
            boolean z2 = reactSpan instanceof TextInlineImageSpan;
            if (z2 || (reactSpan instanceof TextInlineViewPlaceholderSpan)) {
                if (z2) {
                    iB = ((TextInlineImageSpan) reactSpan).b();
                    reactBaseTextShadowNode.Y = true;
                } else {
                    TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = (TextInlineViewPlaceholderSpan) reactSpan;
                    int i3 = textInlineViewPlaceholderSpan.f20178c;
                    ReactShadowNode reactShadowNode = (ReactShadowNode) map.get(Integer.valueOf(textInlineViewPlaceholderSpan.f20176a));
                    nativeViewHierarchyOptimizer.getClass();
                    if (reactShadowNode.V()) {
                        nativeViewHierarchyOptimizer.h(reactShadowNode, null);
                    }
                    reactShadowNode.o(reactBaseTextShadowNode);
                    iB = i3;
                }
                if (Float.isNaN(f2) || iB > f2) {
                    f2 = iB;
                }
            }
            setSpanOperation.a(spannableStringBuilder, i2);
        }
        reactBaseTextShadowNode.A.f20133f = f2;
        ReactTextViewManagerCallback reactTextViewManagerCallback = this.z;
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.a();
        }
        return spannableStringBuilder;
    }

    @ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(@Nullable String str) {
        if (J()) {
            this.F = ReactAccessibilityDelegate.AccessibilityRole.a(str);
            c0();
        }
    }

    @ReactProp(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(boolean z) {
        if (z != this.S) {
            this.S = z;
            c0();
        }
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z) {
        TextAttributes textAttributes = this.A;
        if (z != textAttributes.f20128a) {
            textAttributes.f20128a = z;
            c0();
        }
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(@Nullable Integer num) {
        if (J()) {
            boolean z = num != null;
            this.D = z;
            if (z) {
                this.E = num.intValue();
            }
            c0();
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(@Nullable Integer num) {
        boolean z = num != null;
        this.B = z;
        if (z) {
            this.C = num.intValue();
        }
        c0();
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(@Nullable String str) {
        this.W = str;
        c0();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "fontSize")
    public void setFontSize(float f2) {
        this.A.f20129b = f2;
        c0();
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(@Nullable String str) {
        int iB = ReactTypefaceUtils.b(str);
        if (iB != this.U) {
            this.U = iB;
            c0();
        }
    }

    @ReactProp(name = "fontVariant")
    public void setFontVariant(@Nullable ReadableArray readableArray) {
        String strC = ReactTypefaceUtils.c(readableArray);
        if (TextUtils.equals(strC, this.X)) {
            return;
        }
        this.X = strC;
        c0();
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(@Nullable String str) {
        int iD = ReactTypefaceUtils.d(str);
        if (iD != this.V) {
            this.V = iD;
            c0();
        }
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z) {
        this.R = z;
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(float f2) {
        this.A.f20131d = f2;
        c0();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "lineHeight")
    public void setLineHeight(float f2) {
        this.A.f20130c = f2;
        c0();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(float f2) {
        TextAttributes textAttributes = this.A;
        if (f2 != textAttributes.f20132e) {
            if (f2 == 0.0f || f2 >= 1.0f) {
                textAttributes.f20132e = f2;
            } else {
                FLog.q("ReactNative", "maxFontSizeMultiplier must be NaN, 0, or >= 1");
                textAttributes.f20132e = Float.NaN;
            }
            c0();
        }
    }

    @ReactProp(name = "minimumFontScale")
    public void setMinimumFontScale(float f2) {
        if (f2 != this.T) {
            this.T = f2;
            c0();
        }
    }

    @ReactProp(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = -1;
        }
        this.H = i2;
        c0();
    }

    @ReactProp(name = "role")
    public void setRole(@Nullable String str) {
        ReactAccessibilityDelegate.Role role;
        if (J()) {
            ReactAccessibilityDelegate.Role[] roleArrValues = ReactAccessibilityDelegate.Role.values();
            int length = roleArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    role = null;
                    break;
                }
                role = roleArrValues[i2];
                if (role.name().equalsIgnoreCase(str)) {
                    break;
                } else {
                    i2++;
                }
            }
            this.G = role;
            c0();
        }
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(@Nullable String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.K = 1;
            }
            this.I = 3;
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                this.K = 0;
            }
            if (str == null || "auto".equals(str)) {
                this.I = 0;
            } else if ("left".equals(str)) {
                this.I = 3;
            } else if ("right".equals(str)) {
                this.I = 5;
            } else if ("center".equals(str)) {
                this.I = 1;
            } else {
                FLog.q("ReactNative", "Invalid textAlign: ".concat(str));
                this.I = 0;
            }
        }
        c0();
    }

    @ReactProp(name = "textBreakStrategy")
    public void setTextBreakStrategy(@Nullable String str) {
        if (str == null || "highQuality".equals(str)) {
            this.J = 1;
        } else if ("simple".equals(str)) {
            this.J = 0;
        } else if ("balanced".equals(str)) {
            this.J = 2;
        } else {
            FLog.q("ReactNative", "Invalid textBreakStrategy: ".concat(str));
            this.J = 1;
        }
        c0();
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(@Nullable String str) {
        this.P = false;
        this.Q = false;
        if (str != null) {
            for (String str2 : str.split(StringUtils.SPACE)) {
                if ("underline".equals(str2)) {
                    this.P = true;
                } else if ("line-through".equals(str2)) {
                    this.Q = true;
                }
            }
        }
        c0();
    }

    @ReactProp(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i2) {
        if (i2 != this.O) {
            this.O = i2;
            c0();
        }
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.L = 0.0f;
        this.M = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey(Snapshot.WIDTH) && !readableMap.isNull(Snapshot.WIDTH)) {
                this.L = PixelUtil.b((float) readableMap.getDouble(Snapshot.WIDTH));
            }
            if (readableMap.hasKey(Snapshot.HEIGHT) && !readableMap.isNull(Snapshot.HEIGHT)) {
                this.M = PixelUtil.b((float) readableMap.getDouble(Snapshot.HEIGHT));
            }
        }
        c0();
    }

    @ReactProp(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f2) {
        if (f2 != this.N) {
            this.N = f2;
            c0();
        }
    }

    @ReactProp(name = "textTransform")
    public void setTextTransform(@Nullable String str) {
        TextAttributes textAttributes = this.A;
        if (str == null) {
            textAttributes.f20134g = TextTransform.f20142f;
        } else if ("none".equals(str)) {
            textAttributes.f20134g = TextTransform.f20138b;
        } else if ("uppercase".equals(str)) {
            textAttributes.f20134g = TextTransform.f20139c;
        } else if ("lowercase".equals(str)) {
            textAttributes.f20134g = TextTransform.f20140d;
        } else if ("capitalize".equals(str)) {
            textAttributes.f20134g = TextTransform.f20141e;
        } else {
            FLog.q("ReactNative", "Invalid textTransform: ".concat(str));
            textAttributes.f20134g = TextTransform.f20142f;
        }
        c0();
    }

    public ReactBaseTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.B = false;
        this.D = false;
        this.F = null;
        this.G = null;
        this.H = -1;
        this.I = 0;
        this.J = 1;
        this.K = 0;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = 1426063360;
        this.P = false;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.T = 0.0f;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = false;
        this.A = new TextAttributes();
        this.z = reactTextViewManagerCallback;
    }
}
