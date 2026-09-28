package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* loaded from: classes4.dex */
public class StreetViewPanoramaFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final zzap f38419a = new zzap(this);

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        ClassLoader classLoader = StreetViewPanoramaFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        zzap zzapVar = this.f38419a;
        zzapVar.f38604g = activity;
        zzapVar.n();
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f38419a.c(bundle);
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f38419a.d(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        this.f38419a.e();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        zzap zzapVar = this.f38419a;
        LifecycleDelegate lifecycleDelegate = zzapVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.T();
        } else {
            zzapVar.l(2);
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        zzap zzapVar = this.f38419a;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzapVar.f38604g = activity;
            zzapVar.n();
            zzapVar.f(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.f38419a.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
        super.onLowMemory();
    }

    @Override // android.app.Fragment
    public final void onPause() {
        this.f38419a.g();
        super.onPause();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f38419a.h();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        ClassLoader classLoader = StreetViewPanoramaFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.f38419a.i(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f38419a.j();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        zzap zzapVar = this.f38419a;
        LifecycleDelegate lifecycleDelegate = zzapVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.e();
        } else {
            zzapVar.l(4);
        }
        super.onStop();
    }
}
