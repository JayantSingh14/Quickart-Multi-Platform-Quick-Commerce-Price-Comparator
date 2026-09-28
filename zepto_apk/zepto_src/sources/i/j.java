package i;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.amazon.identity.auth.device.interactive.WorkflowFragment;
import java.lang.ref.WeakReference;
import java.util.Objects;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public final class j implements g {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f48448a;

    public j(Fragment fragment) {
        if (fragment == null) {
            throw new IllegalArgumentException("fragment must be non-null");
        }
        this.f48448a = new WeakReference(fragment);
    }

    @Override // i.g
    public final void a(InteractiveRequestRecord interactiveRequestRecord) {
        Fragment fragment = (Fragment) this.f48448a.get();
        if (fragment != null) {
            FragmentManager fragmentManager = fragment.getFragmentManager();
            try {
                String str = e.x0;
                e eVar = (e) fragmentManager.findFragmentByTag(str);
                e eVar2 = eVar;
                if (eVar == null) {
                    WorkflowFragment workflowFragment = new WorkflowFragment();
                    fragmentManager.beginTransaction().add(workflowFragment, str).commit();
                    eVar2 = workflowFragment;
                }
                Bundle bundle = new Bundle();
                fragmentManager.putFragment(bundle, "wrappedFragment", fragment);
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
        return this.f48448a.get();
    }

    @Override // i.g
    public final b c() {
        Fragment fragment = (Fragment) this.f48448a.get();
        if (fragment == null) {
            return null;
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        try {
            String str = e.x0;
            e eVar = (e) fragmentManager.findFragmentByTag(str);
            e eVar2 = eVar;
            if (eVar == null) {
                WorkflowFragment workflowFragment = new WorkflowFragment();
                fragmentManager.beginTransaction().add(workflowFragment, str).commit();
                eVar2 = workflowFragment;
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
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        WeakReference weakReference = this.f48448a;
        WeakReference weakReference2 = ((j) obj).f48448a;
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
        WeakReference weakReference = this.f48448a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((Fragment) weakReference.get()).hashCode());
    }

    @Override // i.g
    public final Context a() {
        return ((Fragment) this.f48448a.get()).getActivity();
    }
}
