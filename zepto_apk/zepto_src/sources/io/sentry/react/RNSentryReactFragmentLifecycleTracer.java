package io.sentry.react;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;

/* loaded from: classes3.dex */
public class RNSentryReactFragmentLifecycleTracer extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final BuildInfoProvider f53007a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.a f53008b;

    /* renamed from: c, reason: collision with root package name */
    public final AndroidLogger f53009c;

    public RNSentryReactFragmentLifecycleTracer(BuildInfoProvider buildInfoProvider, androidx.lifecycle.a aVar) {
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        this.f53007a = buildInfoProvider;
        this.f53008b = aVar;
        this.f53009c = androidLogger;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        boolean zEquals = "com.swmansion.rnscreens.ScreenStackFragment".equals(fragment.getClass().getCanonicalName());
        AndroidLogger androidLogger = this.f53009c;
        if (!zEquals) {
            androidLogger.c(SentryLevel.DEBUG, "Fragment is not a ScreenStackFragment, won't listen for the first draw.", new Object[0]);
            return;
        }
        if (!(view instanceof ViewGroup)) {
            androidLogger.c(SentryLevel.WARNING, "Fragment view is not a ViewGroup, won't listen for the first draw.", new Object[0]);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() == 0) {
            androidLogger.c(SentryLevel.WARNING, "Fragment view has no children, won't listen for the first draw.", new Object[0]);
            return;
        }
        View childAt = viewGroup.getChildAt(0);
        if (childAt == null || !(childAt.getContext() instanceof ReactContext)) {
            androidLogger.c(SentryLevel.WARNING, "Fragment view has no ReactContext, won't listen for the first draw.", new Object[0]);
            return;
        }
        int id = childAt.getId();
        if (id == -1) {
            androidLogger.c(SentryLevel.WARNING, "Screen has no id, won't listen for the first draw.", new Object[0]);
            return;
        }
        final EventDispatcher eventDispatcherB = UIManagerHelper.b(UIManagerHelper.c(childAt), id);
        if (eventDispatcherB == null) {
            androidLogger.c(SentryLevel.WARNING, "Screen has no event dispatcher, won't listen for the first draw.", new Object[0]);
            return;
        }
        final androidx.lifecycle.a aVar = this.f53008b;
        final ViewGroup viewGroup2 = (ViewGroup) view;
        eventDispatcherB.e(new EventDispatcherListener() { // from class: io.sentry.react.RNSentryReactFragmentLifecycleTracer.1
            @Override // com.facebook.react.uimanager.events.EventDispatcherListener
            public final void onEventDispatch(Event event) {
                if ("com.swmansion.rnscreens.events.ScreenAppearEvent".equals(event.getClass().getCanonicalName())) {
                    eventDispatcherB.d(this);
                    FirstDrawDoneListener.b(viewGroup2, aVar, RNSentryReactFragmentLifecycleTracer.this.f53007a);
                }
            }
        });
    }
}
