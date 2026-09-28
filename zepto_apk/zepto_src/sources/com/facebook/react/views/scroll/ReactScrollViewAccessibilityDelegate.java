package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.react.R;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ReactScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: a, reason: collision with root package name */
    public final String f20054a;

    public ReactScrollViewAccessibilityDelegate() {
        Intrinsics.checkNotNullExpressionValue("ReactScrollViewAccessibilityDelegate", "getSimpleName(...)");
        this.f20054a = "ReactScrollViewAccessibilityDelegate";
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        boolean zI;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(host, event);
        if (!(host instanceof ReactScrollView) && !(host instanceof ReactHorizontalScrollView)) {
            ReactSoftExceptionLogger.logSoftException(this.f20054a, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactScrollView or ReactHorizontalScrollView, not with class: ".concat(host.getClass().getSimpleName())));
            return;
        }
        Object tag = host.getTag(R.id.accessibility_collection);
        Integer numValueOf = null;
        ReadableMap readableMap = tag instanceof ReadableMap ? (ReadableMap) tag : null;
        if (readableMap == null) {
            return;
        }
        event.setItemCount(readableMap.getInt(PaymentConstants.ITEM_COUNT));
        ViewGroup viewGroup = host instanceof ViewGroup ? (ViewGroup) host : null;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup2 == null) {
            return;
        }
        int childCount = viewGroup2.getChildCount();
        Integer numValueOf2 = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = viewGroup2.getChildAt(i2);
            if (host instanceof ReactScrollView) {
                zI = ((ReactScrollView) host).i(childAt2);
            } else {
                if (!(host instanceof ReactHorizontalScrollView)) {
                    return;
                }
                ReactHorizontalScrollView reactHorizontalScrollView = (ReactHorizontalScrollView) host;
                int iH = reactHorizontalScrollView.h(childAt2);
                Rect rect = reactHorizontalScrollView.J;
                childAt2.getDrawingRect(rect);
                zI = iH != 0 && Math.abs(iH) < rect.width();
            }
            Object tag2 = childAt2.getTag(R.id.accessibility_collection_item);
            Intrinsics.d(tag2, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
            ReadableMap readableMap2 = (ReadableMap) tag2;
            if (!(childAt2 instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) childAt2).getChildCount();
            if (zI) {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(readableMap2.getInt("itemIndex"));
                }
                numValueOf2 = Integer.valueOf(readableMap2.getInt("itemIndex"));
            }
            if (numValueOf != null && numValueOf2 != null) {
                event.setFromIndex(numValueOf.intValue());
                event.setToIndex(numValueOf2.intValue());
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        if (!(host instanceof ReactScrollView) && !(host instanceof ReactHorizontalScrollView)) {
            ReactSoftExceptionLogger.logSoftException(this.f20054a, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactScrollView or ReactHorizontalScrollView, not with class: ".concat(host.getClass().getSimpleName())));
            return;
        }
        ReactAccessibilityDelegate.AccessibilityRole accessibilityRoleB = ReactAccessibilityDelegate.AccessibilityRole.b(host);
        if (accessibilityRoleB != null) {
            ReactAccessibilityDelegate.t(info, accessibilityRoleB, host.getContext());
        }
        Object tag = host.getTag(R.id.accessibility_collection);
        ReadableMap readableMap = tag instanceof ReadableMap ? (ReadableMap) tag : null;
        if (readableMap != null) {
            info.o(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(readableMap.getInt("rowCount"), readableMap.getInt("columnCount"), readableMap.getBoolean("hierarchical")));
        }
        if (host instanceof ReactScrollView) {
            info.u(((ReactScrollView) host).getScrollEnabled());
        } else if (host instanceof ReactHorizontalScrollView) {
            info.u(((ReactHorizontalScrollView) host).getScrollEnabled());
        }
    }
}
