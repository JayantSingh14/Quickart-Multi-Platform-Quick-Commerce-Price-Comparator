package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4730a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4731b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f4730a = i2;
        this.f4731b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle a() {
        Object obj = this.f4731b;
        switch (this.f4730a) {
            case 0:
                String str = FragmentActivity.LIFECYCLE_TAG;
                FragmentActivity fragmentActivity = (FragmentActivity) obj;
                fragmentActivity.markFragmentsCreated();
                fragmentActivity.mFragmentLifecycleRegistry.f(Lifecycle.Event.ON_STOP);
                return new Bundle();
            default:
                return ((FragmentManager) obj).d0();
        }
    }
}
