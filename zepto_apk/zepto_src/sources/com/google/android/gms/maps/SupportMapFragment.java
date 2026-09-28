package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* loaded from: classes4.dex */
public class SupportMapFragment extends Fragment {
    public final zzaw Q = new zzaw(this);

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        zzaw zzawVar = this.Q;
        zzawVar.f38619g = activity;
        zzawVar.n();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onCreate(bundle);
            this.Q.c(bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayoutD = this.Q.d(layoutInflater, viewGroup, bundle);
        frameLayoutD.setClickable(true);
        return frameLayoutD;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.Q.e();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        zzaw zzawVar = this.Q;
        LifecycleDelegate lifecycleDelegate = zzawVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.T();
        } else {
            zzawVar.l(2);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        zzaw zzawVar = this.Q;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzawVar.f38619g = activity;
            zzawVar.n();
            GoogleMapOptions googleMapOptionsR = GoogleMapOptions.r(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", googleMapOptionsR);
            zzawVar.f(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.Q.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        this.Q.g();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.Q.h();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.Q.i(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.Q.j();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        zzaw zzawVar = this.Q;
        LifecycleDelegate lifecycleDelegate = zzawVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.e();
        } else {
            zzawVar.l(4);
        }
        super.onStop();
    }
}
