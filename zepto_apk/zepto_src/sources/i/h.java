package i;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import com.amazon.identity.auth.device.api.InvalidIntegrationException;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.amazon.identity.auth.device.interactive.WorkflowFragment;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f48446a;

    public h(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("activity must be non-null");
        }
        this.f48446a = new WeakReference(activity);
    }

    @Override // i.g
    public final void a(InteractiveRequestRecord interactiveRequestRecord) throws ClassNotFoundException {
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
        return this.f48446a.get();
    }

    @Override // i.g
    public final b c() throws ClassNotFoundException {
        Activity activity = (Activity) this.f48446a.get();
        if (activity == null) {
            return null;
        }
        try {
            Class.forName("android.app.Fragment", false, h.class.getClassLoader());
            FragmentManager fragmentManager = activity.getFragmentManager();
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
        } catch (ClassNotFoundException e2) {
            throw new InvalidIntegrationException("android.app.Fragment not found. To make a request from an activity, use minSdkVersion of at least 11, or use FragmentActivity from Android Support Library v4", e2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        WeakReference weakReference = this.f48446a;
        WeakReference weakReference2 = ((h) obj).f48446a;
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
            } else if (!((Activity) weakReference.get()).equals(weakReference2.get())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        WeakReference weakReference = this.f48446a;
        return 31 + ((weakReference == null || weakReference.get() == null) ? 0 : ((Activity) weakReference.get()).hashCode());
    }

    @Override // i.g
    public final Context a() {
        return (Context) this.f48446a.get();
    }
}
