package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MenuHostHelper {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f3046a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3047b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3048c = new HashMap();

    /* loaded from: classes3.dex */
    public static class LifecycleContainer {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f3049a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleEventObserver f3050b;

        public LifecycleContainer(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            this.f3049a = lifecycle;
            this.f3050b = lifecycleEventObserver;
            lifecycle.a(lifecycleEventObserver);
        }

        public final void a() {
            this.f3049a.c(this.f3050b);
            this.f3050b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.f3046a = runnable;
    }

    public final void a(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.f3047b.add(menuProvider);
        this.f3046a.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap map = this.f3048c;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) map.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        map.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.c
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void a(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Lifecycle.Event event2 = Lifecycle.Event.ON_DESTROY;
                MenuHostHelper menuHostHelper = this.f3209a;
                if (event == event2) {
                    menuHostHelper.c(menuProvider);
                } else {
                    menuHostHelper.getClass();
                }
            }
        }));
    }

    public final void b(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap map = this.f3048c;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) map.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        map.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.b
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void a(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper menuHostHelper = this.f3206a;
                menuHostHelper.getClass();
                Lifecycle.Event.Companion.getClass();
                Lifecycle.State state2 = state;
                Lifecycle.Event eventB = Lifecycle.Event.Companion.b(state2);
                Runnable runnable = menuHostHelper.f3046a;
                CopyOnWriteArrayList copyOnWriteArrayList = menuHostHelper.f3047b;
                MenuProvider menuProvider2 = menuProvider;
                if (event == eventB) {
                    copyOnWriteArrayList.add(menuProvider2);
                    runnable.run();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.c(menuProvider2);
                } else if (event == Lifecycle.Event.Companion.a(state2)) {
                    copyOnWriteArrayList.remove(menuProvider2);
                    runnable.run();
                }
            }
        }));
    }

    public final void c(MenuProvider menuProvider) {
        this.f3047b.remove(menuProvider);
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.f3048c.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
        }
        this.f3046a.run();
    }
}
