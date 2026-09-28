package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class FragmentStore {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4633a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4634b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f4635c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public FragmentManagerViewModel f4636d;

    public final void a(Fragment fragment) {
        if (this.f4633a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f4633a) {
            this.f4633a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final Fragment b(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) this.f4634b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.f4621c;
        }
        return null;
    }

    public final Fragment c(String str) {
        Fragment fragmentFindFragmentByWho;
        for (FragmentStateManager fragmentStateManager : this.f4634b.values()) {
            if (fragmentStateManager != null && (fragmentFindFragmentByWho = fragmentStateManager.f4621c.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.f4634b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.f4634b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.f4621c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f4633a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f4633a) {
            arrayList = new ArrayList(this.f4633a);
        }
        return arrayList;
    }

    public final void g(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.f4621c;
        String str = fragment.mWho;
        HashMap map = this.f4634b;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, fragmentStateManager);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.f4636d.e(fragment);
            } else {
                this.f4636d.i(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public final void h(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.f4621c;
        if (fragment.mRetainInstance) {
            this.f4636d.i(fragment);
        }
        HashMap map = this.f4634b;
        if (map.get(fragment.mWho) == fragmentStateManager && ((FragmentStateManager) map.put(fragment.mWho, null)) != null && FragmentManager.O(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public final Bundle i(Bundle bundle, String str) {
        HashMap map = this.f4635c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }
}
