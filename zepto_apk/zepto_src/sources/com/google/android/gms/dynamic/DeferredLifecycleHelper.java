package com.google.android.gms.dynamic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

@KeepForSdk
/* loaded from: classes4.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {

    /* renamed from: a, reason: collision with root package name */
    public LifecycleDelegate f22295a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f22296b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList f22297c;

    /* renamed from: d, reason: collision with root package name */
    public final OnDelegateCreatedListener f22298d = new zaa(this);

    @KeepForSdk
    public DeferredLifecycleHelper() {
    }

    public static void k(FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        String strZac = com.google.android.gms.common.internal.zac.zac(context, iIsGooglePlayServicesAvailable);
        String strZab = com.google.android.gms.common.internal.zac.zab(context, iIsGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strZac);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, iIsGooglePlayServicesAvailable, null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strZab);
            linearLayout.addView(button);
            button.setOnClickListener(new zae(context, errorResolutionIntent));
        }
    }

    public abstract void a(OnDelegateCreatedListener onDelegateCreatedListener);

    public final LifecycleDelegate b() {
        return this.f22295a;
    }

    public final void c(Bundle bundle) {
        m(bundle, new zac(this, bundle));
    }

    public final FrameLayout d(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m(bundle, new zad(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f22295a == null) {
            k(frameLayout);
        }
        return frameLayout;
    }

    public final void e() {
        LifecycleDelegate lifecycleDelegate = this.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
        } else {
            l(1);
        }
    }

    public final void f(Activity activity, Bundle bundle, Bundle bundle2) {
        m(bundle2, new zab(this, activity, bundle, bundle2));
    }

    public final void g() {
        LifecycleDelegate lifecycleDelegate = this.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
        } else {
            l(5);
        }
    }

    public final void h() {
        m(null, new zag(this));
    }

    public final void i(Bundle bundle) {
        LifecycleDelegate lifecycleDelegate = this.f22295a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.s(bundle);
            return;
        }
        Bundle bundle2 = this.f22296b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public final void j() {
        m(null, new zaf(this));
    }

    public final void l(int i2) {
        while (!this.f22297c.isEmpty() && ((zah) this.f22297c.getLast()).zaa() >= i2) {
            this.f22297c.removeLast();
        }
    }

    public final void m(Bundle bundle, zah zahVar) {
        if (this.f22295a != null) {
            zahVar.zab();
            return;
        }
        if (this.f22297c == null) {
            this.f22297c = new LinkedList();
        }
        this.f22297c.add(zahVar);
        if (bundle != null) {
            Bundle bundle2 = this.f22296b;
            if (bundle2 == null) {
                this.f22296b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f22298d);
    }
}
