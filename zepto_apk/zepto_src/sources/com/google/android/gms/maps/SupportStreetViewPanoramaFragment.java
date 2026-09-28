package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* loaded from: classes4.dex */
public class SupportStreetViewPanoramaFragment extends Fragment {
    public final zzaz Q = new zzaz(this);

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        ClassLoader classLoader = SupportStreetViewPanoramaFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        zzaz zzazVar = this.Q;
        zzazVar.f38626g = activity;
        zzazVar.n();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Q.c(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.Q.d(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.Q.e();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        zzaz zzazVar = this.Q;
        LifecycleDelegate lifecycleDelegate = zzazVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.T();
        } else {
            zzazVar.l(2);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        zzaz zzazVar = this.Q;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzazVar.f38626g = activity;
            zzazVar.n();
            zzazVar.f(activity, new Bundle(), bundle);
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
        ClassLoader classLoader = SupportStreetViewPanoramaFragment.class.getClassLoader();
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
        zzaz zzazVar = this.Q;
        LifecycleDelegate lifecycleDelegate = zzazVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.e();
        } else {
            zzazVar.l(4);
        }
        super.onStop();
    }
}
