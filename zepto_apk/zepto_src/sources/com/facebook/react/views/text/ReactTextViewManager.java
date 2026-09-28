package com.facebook.react.views.text;

import android.os.Trace;
import android.text.Spannable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.react.R;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.internal.SystraceSection;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.internal.span.ReactClickableSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = ReactTextViewManager.REACT_CLASS)
/* loaded from: classes.dex */
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode> implements IViewManagerWithChildren {

    @VisibleForTesting
    public static final String REACT_CLASS = "RCTText";
    private static final String TAG = "ReactTextViewManager";
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_HASH = 2;
    private static final short TX_STATE_KEY_MOST_RECENT_EVENT_COUNT = 3;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;

    @Nullable
    protected ReactTextViewManagerCallback mReactTextViewManagerCallback;

    public ReactTextViewManager() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getReactTextUpdate(com.facebook.react.views.text.ReactTextView r12, com.facebook.react.uimanager.ReactStylesDiffMap r13, com.facebook.react.common.mapbuffer.MapBuffer r14) {
        /*
            r11 = this;
            r0 = 0
            com.facebook.react.common.mapbuffer.MapBuffer r1 = r14.j0(r0)
            r2 = 1
            com.facebook.react.common.mapbuffer.MapBuffer r14 = r14.j0(r2)
            android.content.Context r3 = r12.getContext()
            com.facebook.react.views.text.ReactTextViewManagerCallback r4 = r11.mReactTextViewManagerCallback
            android.text.Spannable r6 = com.facebook.react.views.text.TextLayoutManager.d(r3, r1, r4)
            r12.setSpanned(r6)
            r3 = 6
            double r3 = r14.getDouble(r3)     // Catch: java.lang.IllegalArgumentException -> L70
            float r3 = (float) r3     // Catch: java.lang.IllegalArgumentException -> L70
            r12.setMinimumFontSize(r3)     // Catch: java.lang.IllegalArgumentException -> L70
            r3 = 2
            java.lang.String r14 = r14.getString(r3)
            int r9 = com.facebook.react.views.text.TextAttributeProps.m(r14)
            int r14 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r14 >= r3) goto L31
            r14 = r0
            goto L35
        L31:
            int r14 = androidx.core.view.accessibility.b.b(r12)
        L35:
            com.facebook.react.views.text.ReactTextUpdate r5 = new com.facebook.react.views.text.ReactTextUpdate
            int r12 = r12.getGravityHorizontal()
            java.lang.String r3 = com.facebook.react.views.text.TextLayoutManager.f(r1)
            android.text.Layout$Alignment r1 = com.facebook.react.views.text.TextLayoutManager.e(r1, r6, r3)
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            int r4 = r6.length()
            boolean r0 = r3.isRtl(r6, r0, r4)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            r4 = 3
            r7 = 5
            if (r1 != r3) goto L59
            if (r0 == 0) goto L57
        L55:
            r8 = r7
            goto L67
        L57:
            r8 = r4
            goto L67
        L59:
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            if (r1 != r3) goto L60
            if (r0 == 0) goto L55
            goto L57
        L60:
            android.text.Layout$Alignment r0 = android.text.Layout.Alignment.ALIGN_CENTER
            if (r1 != r0) goto L66
            r8 = r2
            goto L67
        L66:
            r8 = r12
        L67:
            int r10 = com.facebook.react.views.text.TextAttributeProps.h(r14, r13)
            r7 = -1
            r5.<init>(r6, r7, r8, r9, r10)
            return r5
        L70:
            r0 = move-exception
            r12 = r0
            if (r14 == 0) goto L79
            java.lang.String r13 = r14.toString()
            goto L7b
        L79:
            java.lang.String r13 = "<empty>"
        L7b:
            java.lang.Object[] r13 = new java.lang.Object[]{r13}
            java.lang.String r14 = "ReactTextViewManager"
            java.lang.String r0 = "Paragraph Attributes: %s"
            com.facebook.common.logging.FLog.i(r14, r0, r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextViewManager.getReactTextUpdate(com.facebook.react.views.text.ReactTextView, com.facebook.react.uimanager.ReactStylesDiffMap, com.facebook.react.common.mapbuffer.MapBuffer):java.lang.Object");
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.d("topTextLayout", MapBuilder.c("registrationName", "onTextLayout"), "topInlineViewLayout", MapBuilder.c("registrationName", "onInlineViewLayout")));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0132  */
    @Override // com.facebook.react.uimanager.ViewManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long measure(android.content.Context r19, com.facebook.react.common.mapbuffer.MapBuffer r20, com.facebook.react.common.mapbuffer.MapBuffer r21, @androidx.annotation.Nullable com.facebook.react.common.mapbuffer.MapBuffer r22, float r23, com.facebook.yoga.YogaMeasureMode r24, float r25, com.facebook.yoga.YogaMeasureMode r26, @androidx.annotation.Nullable float[] r27) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextViewManager.measure(android.content.Context, com.facebook.react.common.mapbuffer.MapBuffer, com.facebook.react.common.mapbuffer.MapBuffer, com.facebook.react.common.mapbuffer.MapBuffer, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, float[]):long");
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactTextView reactTextView, @Nullable String str) {
        reactTextView.setOverflow(str);
    }

    public ReactTextViewManager(@Nullable ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.mReactTextViewManagerCallback = reactTextViewManagerCallback;
        setupViewRecycling();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactTextShadowNode createShadowNodeInstance() {
        return new ReactTextShadowNode(this.mReactTextViewManagerCallback);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactTextView createViewInstance(ThemedReactContext themedReactContext) {
        ReactTextView reactTextView = new ReactTextView(themedReactContext, null);
        reactTextView.s = Overflow.f19918b;
        reactTextView.s();
        return reactTextView;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactTextView reactTextView) {
        super.onAfterUpdateTransaction((ReactTextViewManager) reactTextView);
        reactTextView.setEllipsize((reactTextView.f20110i == Integer.MAX_VALUE || reactTextView.f20112k) ? null : reactTextView.f20111j);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public ReactTextView prepareToRecycleView(@NonNull ThemedReactContext themedReactContext, ReactTextView reactTextView) {
        ReactTextView reactTextView2 = (ReactTextView) super.prepareToRecycleView(themedReactContext, (ThemedReactContext) reactTextView);
        if (reactTextView2 != null) {
            reactTextView2.u();
            setSelectionColor(reactTextView2, null);
        }
        return reactTextView;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(ReactTextView reactTextView, int i2, int i3, int i4, int i5) {
        reactTextView.setPadding(i2, i3, i4, i5);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ReactTextView reactTextView, Object obj) {
        new SystraceSection("ReactTextViewManager.updateExtraData");
        try {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            Spannable spannable = reactTextUpdate.f20099a;
            if (reactTextUpdate.f20101c) {
                int i2 = TextInlineImageSpan.f20175a;
                TextInlineImageSpan.Companion.a(spannable, reactTextView);
            }
            reactTextView.setText(reactTextUpdate);
            ReactClickableSpan[] reactClickableSpanArr = (ReactClickableSpan[]) spannable.getSpans(0, reactTextUpdate.f20099a.length(), ReactClickableSpan.class);
            if (reactClickableSpanArr.length > 0) {
                reactTextView.setTag(R.id.accessibility_links, new ReactAccessibilityDelegate.AccessibilityLinks(reactClickableSpanArr, spannable));
                ViewCompat.z(reactTextView, new ReactAccessibilityDelegate(reactTextView.getImportantForAccessibility(), reactTextView, reactTextView.isFocusable()));
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactTextView reactTextView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        new SystraceSection("ReactTextViewManager.updateState");
        try {
            ReadableMapBuffer stateDataMapBuffer = stateWrapper.getStateDataMapBuffer();
            if (stateDataMapBuffer == null) {
                Trace.endSection();
                return null;
            }
            Object reactTextUpdate = getReactTextUpdate(reactTextView, reactStylesDiffMap, stateDataMapBuffer);
            Trace.endSection();
            return reactTextUpdate;
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public ReactTextShadowNode createShadowNodeInstance(@Nullable ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextShadowNode(reactTextViewManagerCallback);
    }
}
