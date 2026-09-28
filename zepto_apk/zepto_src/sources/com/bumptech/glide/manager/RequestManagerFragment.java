package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Iterator;

@Deprecated
/* loaded from: classes3.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final ActivityFragmentLifecycle f16407a;

    /* renamed from: b, reason: collision with root package name */
    public final RequestManagerTreeNode f16408b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f16409c;

    /* renamed from: d, reason: collision with root package name */
    public RequestManager f16410d;

    /* renamed from: e, reason: collision with root package name */
    public RequestManagerFragment f16411e;

    public class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public FragmentRequestManagerTreeNode() {
        }

        public final String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        ActivityFragmentLifecycle activityFragmentLifecycle = new ActivityFragmentLifecycle();
        this.f16408b = new FragmentRequestManagerTreeNode();
        this.f16409c = new HashSet();
        this.f16407a = activityFragmentLifecycle;
    }

    public final void a(Activity activity) {
        RequestManagerFragment requestManagerFragment = this.f16411e;
        if (requestManagerFragment != null) {
            requestManagerFragment.f16409c.remove(this);
            this.f16411e = null;
        }
        RequestManagerRetriever requestManagerRetriever = Glide.b(activity).f15653f;
        requestManagerRetriever.getClass();
        RequestManagerFragment requestManagerFragmentC = requestManagerRetriever.c(activity.getFragmentManager(), RequestManagerRetriever.e(activity));
        this.f16411e = requestManagerFragmentC;
        if (equals(requestManagerFragmentC)) {
            return;
        }
        this.f16411e.f16409c.add(this);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ActivityFragmentLifecycle activityFragmentLifecycle = this.f16407a;
        activityFragmentLifecycle.f16400c = true;
        Iterator it = Util.d(activityFragmentLifecycle.f16398a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        RequestManagerFragment requestManagerFragment = this.f16411e;
        if (requestManagerFragment != null) {
            requestManagerFragment.f16409c.remove(this);
            this.f16411e = null;
        }
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        RequestManagerFragment requestManagerFragment = this.f16411e;
        if (requestManagerFragment != null) {
            requestManagerFragment.f16409c.remove(this);
            this.f16411e = null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f16407a.c();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        ActivityFragmentLifecycle activityFragmentLifecycle = this.f16407a;
        activityFragmentLifecycle.f16399b = false;
        Iterator it = Util.d(activityFragmentLifecycle.f16398a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).e();
        }
    }

    @Override // android.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = null;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
