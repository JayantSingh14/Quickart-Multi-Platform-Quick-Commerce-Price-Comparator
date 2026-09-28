package androidx.core.view.insets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.core.R;
import androidx.core.view.insets.Protection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ProtectionLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f3234c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3235a;

    /* renamed from: b, reason: collision with root package name */
    public ProtectionGroup f3236b;

    /* renamed from: androidx.core.view.insets.ProtectionLayout$1, reason: invalid class name */
    class AnonymousClass1 implements Protection.Attributes.Callback {
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SystemBarStateMonitor getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            return (SystemBarStateMonitor) tag;
        }
        SystemBarStateMonitor systemBarStateMonitor = new SystemBarStateMonitor(viewGroup);
        viewGroup.setTag(R.id.tag_system_bar_state_monitor, systemBarStateMonitor);
        return systemBarStateMonitor;
    }

    public final void a() {
        ArrayList arrayList = this.f3235a;
        if (arrayList.isEmpty()) {
            return;
        }
        this.f3236b = new ProtectionGroup(getOrInstallSystemBarStateMonitor(), arrayList);
        getChildCount();
        if (this.f3236b.f3230a.size() <= 0) {
            return;
        }
        Protection protection = (Protection) this.f3236b.f3230a.get(0);
        getContext();
        protection.getClass();
        throw new IllegalArgumentException("Unexpected side: 0");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != f3234c) {
            ProtectionGroup protectionGroup = this.f3236b;
            int childCount = getChildCount() - (protectionGroup != null ? protectionGroup.f3230a.size() : 0);
            if (i2 > childCount || i2 < 0) {
                i2 = childCount;
            }
        }
        super.addView(view, i2, layoutParams);
    }

    public final void b() {
        if (this.f3236b != null) {
            removeViews(getChildCount() - this.f3236b.f3230a.size(), this.f3236b.f3230a.size());
            if (this.f3236b.f3230a.size() > 0) {
                ((Protection) this.f3236b.f3230a.get(0)).getClass();
                throw null;
            }
            ProtectionGroup protectionGroup = this.f3236b;
            if (!protectionGroup.f3233d) {
                protectionGroup.f3233d = true;
                protectionGroup.f3231b.f3238b.remove(protectionGroup);
                ArrayList arrayList = protectionGroup.f3230a;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Protection) arrayList.get(size)).f3229a = null;
                }
                arrayList.clear();
            }
            this.f3236b = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3236b != null) {
            b();
        }
        a();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            final SystemBarStateMonitor systemBarStateMonitor = (SystemBarStateMonitor) tag;
            if (systemBarStateMonitor.f3238b.isEmpty()) {
                systemBarStateMonitor.f3237a.post(new Runnable() { // from class: androidx.core.view.insets.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        View view = systemBarStateMonitor.f3237a;
                        ViewParent parent = view.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(view);
                        }
                    }
                });
                viewGroup.setTag(R.id.tag_system_bar_state_monitor, null);
            }
        }
    }

    public void setProtections(List<Protection> list) {
        ArrayList arrayList = this.f3235a;
        arrayList.clear();
        arrayList.addAll(list);
        if (isAttachedToWindow()) {
            b();
            a();
            requestApplyInsets();
        }
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, 0);
        this.f3235a = new ArrayList();
    }
}
