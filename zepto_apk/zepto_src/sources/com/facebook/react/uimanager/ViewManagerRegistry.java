package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class ViewManagerRegistry implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f19601a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewManagerResolver f19602b;

    public ViewManagerRegistry(ViewManagerResolver viewManagerResolver) {
        this.f19601a = new HashMap();
        this.f19602b = viewManagerResolver;
    }

    public final synchronized ViewManager a(String str) {
        try {
            ViewManager viewManager = (ViewManager) this.f19601a.get(str);
            if (viewManager != null) {
                return viewManager;
            }
            String str2 = "RCT" + str;
            ViewManager viewManager2 = (ViewManager) this.f19601a.get(str2);
            if (viewManager2 != null) {
                return viewManager2;
            }
            ViewManagerResolver viewManagerResolver = this.f19602b;
            if (viewManagerResolver == null) {
                throw new IllegalViewOperationException("No ViewManager found for class " + str);
            }
            ViewManager viewManagerB = viewManagerResolver.b(str);
            if (viewManagerB != null) {
                this.f19601a.put(str, viewManagerB);
            }
            if (viewManagerB != null) {
                return viewManagerB;
            }
            ViewManager viewManagerB2 = this.f19602b.b(str2);
            if (viewManagerB2 != null) {
                this.f19601a.put(str2, viewManagerB2);
            }
            if (viewManagerB2 != null) {
                return viewManagerB2;
            }
            throw new IllegalViewOperationException("ViewManagerResolver returned null for either " + str + " or " + str2 + ", existing names are: " + this.f19602b.a());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f19601a.values());
        }
        androidx.constraintlayout.helper.widget.a aVar = new androidx.constraintlayout.helper.widget.a(arrayList, 19);
        if (UiThreadUtil.isOnUiThread()) {
            aVar.run();
        } else {
            UiThreadUtil.runOnUiThread(aVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        onTrimMemory(0);
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f19601a.values());
        }
        Runnable runnable = new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry.1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ViewManager) it.next()).trimMemory();
                }
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }

    public ViewManagerRegistry(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ViewManager viewManager = (ViewManager) it.next();
            map.put(viewManager.getName(), viewManager);
        }
        this.f19601a = map;
        this.f19602b = null;
    }
}
