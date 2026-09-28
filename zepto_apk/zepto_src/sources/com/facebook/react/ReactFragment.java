package com.facebook.react;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

/* loaded from: classes3.dex */
public class ReactFragment extends Fragment implements PermissionAwareActivity {
    public ReactDelegate Q;
    public boolean X;
    public PermissionListener Y;

    public static class Builder {
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public final void d(String[] strArr, int i2, PermissionListener permissionListener) {
        this.Y = permissionListener;
        requestPermissions(strArr, i2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.Q.c(i2, i3, intent, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Boolean boolValueOf;
        String str;
        Bundle bundle2;
        super.onCreate(bundle);
        if (getArguments() != null) {
            String string = getArguments().getString("arg_component_name");
            Bundle bundle3 = getArguments().getBundle("arg_launch_options");
            boolValueOf = Boolean.valueOf(getArguments().getBoolean("arg_fabric_enabled"));
            this.X = getArguments().getBoolean("arg_disable_host_lifecycle_events");
            str = string;
            bundle2 = bundle3;
        } else {
            boolValueOf = null;
            str = null;
            bundle2 = null;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot loadApp if component name is null");
        }
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            FragmentActivity activity = getActivity();
            ReactApplication reactApplication = (ReactApplication) getActivity().getApplication();
            this.Q = new ReactDelegate(activity, reactApplication != null ? reactApplication.b() : null, str, bundle2);
        } else {
            FragmentActivity activity2 = getActivity();
            ReactApplication reactApplication2 = (ReactApplication) getActivity().getApplication();
            this.Q = new ReactDelegate(activity2, reactApplication2 != null ? reactApplication2.a() : null, str, bundle2, boolValueOf.booleanValue());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ReactDelegate reactDelegate = this.Q;
        reactDelegate.b(reactDelegate.f18447c);
        ReactDelegate reactDelegate2 = this.Q;
        reactDelegate2.getClass();
        if (!ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            return reactDelegate2.f18446b;
        }
        ReactSurface reactSurface = reactDelegate2.f18452h;
        if (reactSurface != null) {
            return (ReactRootView) reactSurface.getView();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (!this.X) {
            this.Q.d();
            return;
        }
        ReactDelegate reactDelegate = this.Q;
        reactDelegate.getClass();
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            ReactSurface reactSurface = reactDelegate.f18452h;
            if (reactSurface != null) {
                reactSurface.stop();
                reactDelegate.f18452h = null;
                return;
            }
            return;
        }
        ReactRootView reactRootView = reactDelegate.f18446b;
        if (reactRootView != null) {
            reactRootView.n();
            reactDelegate.f18446b = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.X) {
            return;
        }
        this.Q.e();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        PermissionListener permissionListener = this.Y;
        if (permissionListener == null || !permissionListener.onRequestPermissionsResult(i2, strArr, iArr)) {
            return;
        }
        this.Y = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.X) {
            return;
        }
        this.Q.f();
    }
}
