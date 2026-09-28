package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import java.util.List;

/* loaded from: classes3.dex */
public class AccessibilityNodeProviderCompat {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeProvider f3203a;

    public static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final AccessibilityNodeProviderCompat f3204a;

        public AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f3204a = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatA = this.f3204a.a(i2);
            if (accessibilityNodeInfoCompatA == null) {
                return null;
            }
            return accessibilityNodeInfoCompatA.f3185a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List findAccessibilityNodeInfosByText(String str, int i2) {
            this.f3204a.getClass();
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo findFocus(int i2) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatB = this.f3204a.b(i2);
            if (accessibilityNodeInfoCompatB == null) {
                return null;
            }
            return accessibilityNodeInfoCompatB.f3185a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f3204a.d(i2, i3, bundle);
        }
    }

    @RequiresApi
    public static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f3204a.getClass();
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3203a = new AccessibilityNodeProviderApi26(this);
        } else {
            this.f3203a = new AccessibilityNodeProviderApi19(this);
        }
    }

    public AccessibilityNodeInfoCompat a(int i2) {
        return null;
    }

    public AccessibilityNodeInfoCompat b(int i2) {
        return null;
    }

    public final Object c() {
        return this.f3203a;
    }

    public boolean d(int i2, int i3, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.f3203a = accessibilityNodeProvider;
    }
}
