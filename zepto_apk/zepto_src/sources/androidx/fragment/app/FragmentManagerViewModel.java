package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class FragmentManagerViewModel extends ViewModel {

    /* renamed from: h, reason: collision with root package name */
    public static final ViewModelProvider.Factory f4598h = new AnonymousClass1();

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4602e;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f4599b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f4600c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f4601d = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f4603f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4604g = false;

    /* renamed from: androidx.fragment.app.FragmentManagerViewModel$1, reason: invalid class name */
    public class AnonymousClass1 implements ViewModelProvider.Factory {
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel c(Class cls) {
            return new FragmentManagerViewModel(true);
        }
    }

    public FragmentManagerViewModel(boolean z) {
        this.f4602e = z;
    }

    @Override // androidx.lifecycle.ViewModel
    public final void d() {
        if (FragmentManager.O(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f4603f = true;
    }

    public final void e(Fragment fragment) {
        if (this.f4604g) {
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap map = this.f4599b;
        if (map.containsKey(fragment.mWho)) {
            return;
        }
        map.put(fragment.mWho, fragment);
        if (FragmentManager.O(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FragmentManagerViewModel.class == obj.getClass()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
            if (this.f4599b.equals(fragmentManagerViewModel.f4599b) && this.f4600c.equals(fragmentManagerViewModel.f4600c) && this.f4601d.equals(fragmentManagerViewModel.f4601d)) {
                return true;
            }
        }
        return false;
    }

    public final void f(Fragment fragment, boolean z) {
        if (FragmentManager.O(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        h(fragment.mWho, z);
    }

    public final void g(String str, boolean z) {
        if (FragmentManager.O(3)) {
            android.support.v4.media.a.t("Clearing non-config state for saved state of Fragment ", str, "FragmentManager");
        }
        h(str, z);
    }

    public final void h(String str, boolean z) {
        HashMap map = this.f4600c;
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) map.get(str);
        if (fragmentManagerViewModel != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(fragmentManagerViewModel.f4600c.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    fragmentManagerViewModel.g((String) it.next(), true);
                }
            }
            fragmentManagerViewModel.d();
            map.remove(str);
        }
        HashMap map2 = this.f4601d;
        ViewModelStore viewModelStore = (ViewModelStore) map2.get(str);
        if (viewModelStore != null) {
            viewModelStore.a();
            map2.remove(str);
        }
    }

    public final int hashCode() {
        return this.f4601d.hashCode() + ((this.f4600c.hashCode() + (this.f4599b.hashCode() * 31)) * 31);
    }

    public final void i(Fragment fragment) {
        if (this.f4604g) {
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f4599b.remove(fragment.mWho) == null || !FragmentManager.O(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f4599b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f4600c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f4601d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
