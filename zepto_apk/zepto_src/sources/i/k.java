package i;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.amazon.identity.auth.device.interactive.WorkflowSupportFragment;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class k implements g {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f48449a;

    public k(Fragment fragment) {
        if (fragment == null) {
            throw new IllegalArgumentException("fragment must be non-null");
        }
        this.f48449a = new WeakReference(fragment);
    }

    @Override // i.g
    public final void a(InteractiveRequestRecord interactiveRequestRecord) {
        Fragment fragment = (Fragment) this.f48449a.get();
        if (fragment != null) {
            FragmentManager fragmentManager = fragment.getFragmentManager();
            try {
                String str = e.x0;
                e eVar = (e) fragmentManager.E(str);
                e eVar2 = eVar;
                if (eVar == null) {
                    WorkflowSupportFragment workflowSupportFragment = new WorkflowSupportFragment();
                    FragmentTransaction fragmentTransactionD = fragmentManager.d();
                    fragmentTransactionD.h(0, workflowSupportFragment, str, 1);
                    fragmentTransactionD.c();
                    eVar2 = workflowSupportFragment;
                }
                Bundle bundle = new Bundle();
                fragmentManager.Y(bundle, "wrappedFragment", fragment);
                interactiveRequestRecord.f15241c = bundle;
                b bVarA = eVar2.a();
                synchronized (bVarA) {
                    Objects.toString(bVarA.f48443e);
                    interactiveRequestRecord.getRequestId();
                    bVarA.f48441c.add(interactiveRequestRecord);
                }
            } catch (ClassCastException unused) {
                String str2 = e.x0;
            }
        }
    }

    @Override // i.g
    public final Object b() {
        return this.f48449a.get();
    }

    @Override // i.g
    public final b c() {
        Fragment fragment = (Fragment) this.f48449a.get();
        if (fragment == null) {
            return null;
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        try {
            String str = e.x0;
            e eVar = (e) fragmentManager.E(str);
            e eVar2 = eVar;
            if (eVar == null) {
                WorkflowSupportFragment workflowSupportFragment = new WorkflowSupportFragment();
                FragmentTransaction fragmentTransactionD = fragmentManager.d();
                fragmentTransactionD.h(0, workflowSupportFragment, str, 1);
                fragmentTransactionD.c();
                eVar2 = workflowSupportFragment;
            }
            return eVar2.a();
        } catch (ClassCastException unused) {
            String str2 = e.x0;
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        WeakReference weakReference = this.f48449a;
        WeakReference weakReference2 = ((k) obj).f48449a;
        if (weakReference == null) {
            if (weakReference2 != null) {
                return false;
            }
        } else {
            if (weakReference2 == null) {
                return false;
            }
            if (weakReference.get() == null) {
                if (weakReference2.get() != null) {
                    return false;
                }
            } else if (!((Fragment) weakReference.get()).equals(weakReference2.get())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        WeakReference weakReference = this.f48449a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((Fragment) weakReference.get()).hashCode());
    }

    @Override // i.g
    public final Context a() {
        return ((Fragment) this.f48449a.get()).getActivity();
    }
}
