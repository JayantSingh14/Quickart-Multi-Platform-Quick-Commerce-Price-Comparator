package i;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.amazon.identity.auth.device.interactive.WorkflowSupportFragment;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f48447a;

    public i(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("activity must be non-null");
        }
        this.f48447a = new WeakReference(fragmentActivity);
    }

    @Override // i.g
    public final void a(InteractiveRequestRecord interactiveRequestRecord) {
        b bVarC = c();
        if (bVarC != null) {
            synchronized (bVarC) {
                Objects.toString(bVarC.f48443e);
                interactiveRequestRecord.getRequestId();
                bVarC.f48441c.add(interactiveRequestRecord);
            }
        }
    }

    @Override // i.g
    public final Object b() {
        return this.f48447a.get();
    }

    @Override // i.g
    public final b c() {
        FragmentActivity fragmentActivity = (FragmentActivity) this.f48447a.get();
        if (fragmentActivity == null) {
            return null;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            String str = e.x0;
            e eVar = (e) supportFragmentManager.E(str);
            e eVar2 = eVar;
            if (eVar == null) {
                WorkflowSupportFragment workflowSupportFragment = new WorkflowSupportFragment();
                FragmentTransaction fragmentTransactionD = supportFragmentManager.d();
                fragmentTransactionD.h(0, workflowSupportFragment, str, 1);
                fragmentTransactionD.d();
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
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        WeakReference weakReference = this.f48447a;
        WeakReference weakReference2 = ((i) obj).f48447a;
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
            } else if (!((FragmentActivity) weakReference.get()).equals(weakReference2.get())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        WeakReference weakReference = this.f48447a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((FragmentActivity) weakReference.get()).hashCode());
    }

    @Override // i.g
    public final Context a() {
        return (Context) this.f48447a.get();
    }
}
