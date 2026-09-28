package androidx.core.view.insets;

import androidx.core.graphics.Insets;
import androidx.core.view.insets.SystemBarStateMonitor;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class ProtectionGroup implements SystemBarStateMonitor.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3230a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final SystemBarStateMonitor f3231b;

    /* renamed from: c, reason: collision with root package name */
    public int f3232c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3233d;

    public ProtectionGroup(SystemBarStateMonitor systemBarStateMonitor, ArrayList arrayList) {
        f(arrayList, false);
        f(arrayList, true);
        ArrayList arrayList2 = systemBarStateMonitor.f3238b;
        if (!arrayList2.contains(this)) {
            arrayList2.add(this);
            b(systemBarStateMonitor.f3239c, systemBarStateMonitor.f3240d);
            e(systemBarStateMonitor.f3241e);
        }
        this.f3231b = systemBarStateMonitor;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public final void a() {
        int i2 = this.f3232c;
        boolean z = i2 > 0;
        int i3 = i2 - 1;
        this.f3232c = i3;
        if (z && i3 == 0) {
            ArrayList arrayList = this.f3230a;
            int size = arrayList.size() - 1;
            if (size < 0) {
                return;
            }
            ((Protection) arrayList.get(size)).getClass();
            throw null;
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public final void b(Insets insets, Insets insets2) {
        ArrayList arrayList = this.f3230a;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        ((Protection) arrayList.get(size)).getClass();
        throw null;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public final void c() {
        this.f3232c++;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public final void d() {
        ArrayList arrayList = this.f3230a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Protection) arrayList.get(size)).getClass();
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public final void e(int i2) {
        ArrayList arrayList = this.f3230a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Protection) arrayList.get(size)).a(i2);
        }
    }

    public final void f(ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protection protection = (Protection) arrayList.get(i2);
            protection.getClass();
            if ((protection instanceof ColorProtection) == z) {
                Object obj = protection.f3229a;
                if (obj != null) {
                    throw new IllegalStateException(protection + " is already controlled by " + obj);
                }
                protection.f3229a = this;
                this.f3230a.add(protection);
            }
        }
    }
}
