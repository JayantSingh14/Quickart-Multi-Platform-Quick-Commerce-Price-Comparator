package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import com.google.android.tv.ads.controls.SideDrawerFragment;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SupportRequestManagerFragment extends Fragment {
    public RequestManager A0;
    public SideDrawerFragment B0;
    public final ActivityFragmentLifecycle Q;
    public final RequestManagerTreeNode X;
    public final HashSet Y;
    public SupportRequestManagerFragment Z;

    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public SupportFragmentRequestManagerTreeNode() {
        }

        public final String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        ActivityFragmentLifecycle activityFragmentLifecycle = new ActivityFragmentLifecycle();
        this.X = new SupportFragmentRequestManagerTreeNode();
        this.Y = new HashSet();
        this.Q = activityFragmentLifecycle;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = this;
        while (parentFragment.getParentFragment() != null) {
            parentFragment = parentFragment.getParentFragment();
        }
        FragmentManager fragmentManager = parentFragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                y(getContext(), fragmentManager);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ActivityFragmentLifecycle activityFragmentLifecycle = this.Q;
        activityFragmentLifecycle.f16400c = true;
        Iterator it = Util.d(activityFragmentLifecycle.f16398a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        SupportRequestManagerFragment supportRequestManagerFragment = this.Z;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.Y.remove(this);
            this.Z = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.B0 = null;
        SupportRequestManagerFragment supportRequestManagerFragment = this.Z;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.Y.remove(this);
            this.Z = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.Q.c();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ActivityFragmentLifecycle activityFragmentLifecycle = this.Q;
        activityFragmentLifecycle.f16399b = false;
        Iterator it = Util.d(activityFragmentLifecycle.f16398a).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.B0;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    public final void y(Context context, FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.Z;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.Y.remove(this);
            this.Z = null;
        }
        RequestManagerRetriever requestManagerRetriever = Glide.b(context).f15653f;
        requestManagerRetriever.getClass();
        SupportRequestManagerFragment supportRequestManagerFragmentD = requestManagerRetriever.d(fragmentManager, null, RequestManagerRetriever.e(context));
        this.Z = supportRequestManagerFragmentD;
        if (equals(supportRequestManagerFragmentD)) {
            return;
        }
        this.Z.Y.add(this);
    }
}
