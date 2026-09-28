package in.juspay.hypersdk.core;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class OverrideClass {
    private InflateJSON infl;

    public OverrideClass(InflateJSON inflateJSON) {
        this.infl = inflateJSON;
    }

    public void addListener(final Object obj, @NonNull String str, @NonNull final JSONObject jSONObject) {
        if (str.equals("setAccessibilityDelegate") && (obj instanceof View)) {
            ViewCompat.z((View) obj, new AccessibilityDelegateCompat() { // from class: in.juspay.hypersdk.core.OverrideClass.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    OverrideClass.this.callOverriddenMethod(obj, jSONObject, "onInitializeAccessibilityEvent", new Object[]{view, accessibilityEvent}, null);
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    OverrideClass.this.callOverriddenMethod(obj, jSONObject, "onInitializeAccessibilityNodeInfo", new Object[]{view, accessibilityNodeInfoCompat}, null);
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
                    return ((Boolean) OverrideClass.this.callOverriddenMethod(obj, jSONObject, "onRequestSendAccessibilityEvent", new Object[]{viewGroup, accessibilityEvent}, Boolean.valueOf(super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent)))).booleanValue();
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean performAccessibilityAction(@NonNull View view, int i2, Bundle bundle) {
                    return ((Boolean) OverrideClass.this.callOverriddenMethod(obj, jSONObject, "performAccessibilityAction", new Object[]{view, Integer.valueOf(i2), bundle}, Boolean.valueOf(super.performAccessibilityAction(view, i2, bundle)))).booleanValue();
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void sendAccessibilityEvent(@NonNull View view, int i2) {
                    super.sendAccessibilityEvent(view, i2);
                    OverrideClass.this.callOverriddenMethod(obj, jSONObject, "sendAccessibilityEvent", new Object[]{view, Integer.valueOf(i2)}, null);
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void sendAccessibilityEventUnchecked(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
                    super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                    OverrideClass.this.callOverriddenMethod(obj, jSONObject, "sendAccessibilityEventUnchecked", new Object[]{view, accessibilityEvent}, null);
                }
            });
        }
    }

    public Object callOverriddenMethod(Object obj, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull Object[] objArr, Object obj2) {
        try {
            if (jSONObject.has(str)) {
                this.infl.putInState("args", objArr);
                return this.infl.runProps(jSONObject, str, obj);
            }
        } catch (Exception e2) {
            this.infl.getDUI().getLogger().e(MerchantConstants.ERROR, "error in callOverriddenMethod" + e2.getMessage());
        }
        return obj2;
    }
}
