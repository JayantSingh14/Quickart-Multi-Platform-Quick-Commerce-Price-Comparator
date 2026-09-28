package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import com.google.android.tv.ads.controls.SideDrawerFragment;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    public static final RequestManagerFactory f16413f = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public volatile RequestManager f16414a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f16415b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f16416c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Handler f16417d;

    /* renamed from: e, reason: collision with root package name */
    public final RequestManagerFactory f16418e;

    /* renamed from: com.bumptech.glide.manager.RequestManagerRetriever$1, reason: invalid class name */
    public class AnonymousClass1 implements RequestManagerFactory {
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public final RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public interface RequestManagerFactory {
        RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever() {
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.f16418e = f16413f;
        this.f16417d = new Handler(Looper.getMainLooper(), this);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean e(Context context) {
        Activity activityA = a(context);
        return activityA == null || !activityA.isFinishing();
    }

    public final RequestManager b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = Util.f16528a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                if (!(Looper.myLooper() == Looper.getMainLooper())) {
                    return b(fragmentActivity.getApplicationContext());
                }
                if (fragmentActivity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                SupportRequestManagerFragment supportRequestManagerFragmentD = d(fragmentActivity.getSupportFragmentManager(), null, e(fragmentActivity));
                RequestManager requestManager = supportRequestManagerFragmentD.A0;
                if (requestManager != null) {
                    return requestManager;
                }
                RequestManager requestManagerA = this.f16418e.a(Glide.b(fragmentActivity), supportRequestManagerFragmentD.Q, supportRequestManagerFragmentD.X, fragmentActivity);
                supportRequestManagerFragmentD.A0 = requestManagerA;
                return requestManagerA;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!(Looper.myLooper() == Looper.getMainLooper())) {
                    return b(activity.getApplicationContext());
                }
                if (activity.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                RequestManagerFragment requestManagerFragmentC = c(activity.getFragmentManager(), e(activity));
                RequestManager requestManager2 = requestManagerFragmentC.f16410d;
                if (requestManager2 != null) {
                    return requestManager2;
                }
                RequestManager requestManagerA2 = this.f16418e.a(Glide.b(activity), requestManagerFragmentC.f16407a, requestManagerFragmentC.f16408b, activity);
                requestManagerFragmentC.f16410d = requestManagerA2;
                return requestManagerA2;
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f16414a == null) {
            synchronized (this) {
                try {
                    if (this.f16414a == null) {
                        this.f16414a = this.f16418e.a(Glide.b(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f16414a;
    }

    public final RequestManagerFragment c(FragmentManager fragmentManager, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        HashMap map = this.f16415b;
        RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) map.get(fragmentManager);
        if (requestManagerFragment2 == null) {
            requestManagerFragment2 = new RequestManagerFragment();
            if (z) {
                requestManagerFragment2.f16407a.c();
            }
            map.put(fragmentManager, requestManagerFragment2);
            fragmentManager.beginTransaction().add(requestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f16417d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment2;
    }

    public final SupportRequestManagerFragment d(androidx.fragment.app.FragmentManager fragmentManager, SideDrawerFragment sideDrawerFragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.E("com.bumptech.glide.manager");
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        HashMap map = this.f16416c;
        SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) map.get(fragmentManager);
        if (supportRequestManagerFragment2 == null) {
            supportRequestManagerFragment2 = new SupportRequestManagerFragment();
            supportRequestManagerFragment2.B0 = sideDrawerFragment;
            if (sideDrawerFragment != null && sideDrawerFragment.getContext() != null) {
                Fragment parentFragment = sideDrawerFragment;
                while (parentFragment.getParentFragment() != null) {
                    parentFragment = parentFragment.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = parentFragment.getFragmentManager();
                if (fragmentManager2 != null) {
                    supportRequestManagerFragment2.y(sideDrawerFragment.getContext(), fragmentManager2);
                }
            }
            if (z) {
                supportRequestManagerFragment2.Q.c();
            }
            map.put(fragmentManager, supportRequestManagerFragment2);
            FragmentTransaction fragmentTransactionD = fragmentManager.d();
            fragmentTransactionD.h(0, supportRequestManagerFragment2, "com.bumptech.glide.manager", 1);
            fragmentTransactionD.d();
            this.f16417d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment2;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        Object obj3;
        int i2 = message.what;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.f16415b.remove(obj);
        } else {
            if (i2 != 2) {
                obj3 = null;
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            objRemove = this.f16416c.remove(obj);
        }
        Object obj4 = objRemove;
        obj2 = obj;
        obj3 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
