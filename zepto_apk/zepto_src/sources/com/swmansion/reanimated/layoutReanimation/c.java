package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.uimanager.ViewGroupManager;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46911a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f46912b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f46913c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f46914d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f46915e;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f46911a = i2;
        this.f46912b = obj;
        this.f46913c = obj2;
        this.f46914d = obj3;
        this.f46915e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f46911a) {
            case 0:
                ReanimatedNativeHierarchyManager.lambda$manageChildren$0((ArrayList) this.f46912b, (View) this.f46913c, (ViewGroupManager) this.f46914d, (ViewGroup) this.f46915e);
                break;
            default:
                Window window = (Window) this.f46912b;
                View viewPeekDecorView = window.peekDecorView();
                if (viewPeekDecorView != null) {
                    window.setCallback((Window.Callback) this.f46913c);
                    FirstDrawDoneListener.b(viewPeekDecorView, (Runnable) this.f46914d, (BuildInfoProvider) this.f46915e);
                    break;
                }
                break;
        }
    }
}
