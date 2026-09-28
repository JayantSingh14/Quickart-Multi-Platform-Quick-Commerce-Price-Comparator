package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* loaded from: classes4.dex */
public class MapFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final zzaf f38410a = new zzaf(this);

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        ClassLoader classLoader = MapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        zzaf zzafVar = this.f38410a;
        zzafVar.f38588g = activity;
        zzafVar.n();
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f38410a.c(bundle);
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayoutD = this.f38410a.d(layoutInflater, viewGroup, bundle);
        frameLayoutD.setClickable(true);
        return frameLayoutD;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        this.f38410a.e();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        zzaf zzafVar = this.f38410a;
        LifecycleDelegate lifecycleDelegate = zzafVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.T();
        } else {
            zzafVar.l(2);
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        zzaf zzafVar = this.f38410a;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzafVar.f38588g = activity;
            zzafVar.n();
            GoogleMapOptions googleMapOptionsR = GoogleMapOptions.r(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", googleMapOptionsR);
            zzafVar.f(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.f38410a.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
        super.onLowMemory();
    }

    @Override // android.app.Fragment
    public final void onPause() {
        this.f38410a.g();
        super.onPause();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f38410a.h();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        ClassLoader classLoader = MapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.f38410a.i(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f38410a.j();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        zzaf zzafVar = this.f38410a;
        LifecycleDelegate lifecycleDelegate = zzafVar.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.e();
        } else {
            zzafVar.l(4);
        }
        super.onStop();
    }
}
