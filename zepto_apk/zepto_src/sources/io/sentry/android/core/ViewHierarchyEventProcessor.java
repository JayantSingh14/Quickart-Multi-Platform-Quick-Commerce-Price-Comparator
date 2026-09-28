package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import io.sentry.Attachment;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.gestures.ViewUtils;
import io.sentry.android.core.internal.util.ClassUtil;
import io.sentry.android.core.internal.util.Debouncer;
import io.sentry.internal.viewhierarchy.ViewHierarchyExporter;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import io.sentry.util.thread.IMainThreadChecker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ViewHierarchyEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final SentryAndroidOptions f52235a;

    /* renamed from: b, reason: collision with root package name */
    public final Debouncer f52236b;

    public ViewHierarchyEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52235a = sentryAndroidOptions;
        this.f52236b = new Debouncer(2000L, 3);
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            IntegrationUtils.a("ViewHierarchy");
        }
    }

    public static void d(View view, ViewHierarchyNode viewHierarchyNode, List list) {
        if (view instanceof ViewGroup) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ViewHierarchyExporter) it.next()).a()) {
                    return;
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(childCount);
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    ViewHierarchyNode viewHierarchyNodeF = f(childAt);
                    arrayList.add(viewHierarchyNodeF);
                    d(childAt, viewHierarchyNodeF, list);
                }
            }
            viewHierarchyNode.f52981k = arrayList;
        }
    }

    public static ViewHierarchy e(Activity activity, List list, IMainThreadChecker iMainThreadChecker, ILogger iLogger) {
        ILogger iLogger2;
        Throwable th;
        if (activity == null) {
            iLogger.c(SentryLevel.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            iLogger.c(SentryLevel.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            iLogger.c(SentryLevel.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            iLogger2 = iLogger;
        }
        if (iMainThreadChecker.a()) {
            try {
                ArrayList arrayList = new ArrayList(1);
                ViewHierarchy viewHierarchy = new ViewHierarchy("android_view_system", arrayList);
                ViewHierarchyNode viewHierarchyNodeF = f(viewPeekDecorView);
                arrayList.add(viewHierarchyNodeF);
                d(viewPeekDecorView, viewHierarchyNodeF, list);
                return viewHierarchy;
            } catch (Throwable th3) {
                th = th3;
                iLogger2 = iLogger;
                iLogger2.b(SentryLevel.ERROR, "Failed to process view hierarchy.", th);
                return null;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference(null);
        iLogger2 = iLogger;
        try {
            activity.runOnUiThread(new androidx.media3.exoplayer.audio.i(atomicReference, viewPeekDecorView, list, countDownLatch, iLogger2, 5));
            if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                return (ViewHierarchy) atomicReference.get();
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            iLogger2.b(SentryLevel.ERROR, "Failed to process view hierarchy.", th);
            return null;
        }
        return null;
    }

    public static ViewHierarchyNode f(View view) {
        ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
        viewHierarchyNode.f52972b = ClassUtil.a(view);
        try {
            viewHierarchyNode.f52973c = ViewUtils.b(view);
        } catch (Throwable unused) {
        }
        viewHierarchyNode.f52977g = Double.valueOf(view.getX());
        viewHierarchyNode.f52978h = Double.valueOf(view.getY());
        viewHierarchyNode.f52975e = Double.valueOf(view.getWidth());
        viewHierarchyNode.f52976f = Double.valueOf(view.getHeight());
        viewHierarchyNode.f52980j = Double.valueOf(view.getAlpha());
        int visibility = view.getVisibility();
        if (visibility == 0) {
            viewHierarchyNode.f52979i = "visible";
        } else if (visibility == 4) {
            viewHierarchyNode.f52979i = "invisible";
        } else if (visibility == 8) {
            viewHierarchyNode.f52979i = "gone";
        }
        return viewHierarchyNode;
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        if (sentryEvent.f()) {
            SentryAndroidOptions sentryAndroidOptions = this.f52235a;
            if (!sentryAndroidOptions.isAttachViewHierarchy()) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
                return sentryEvent;
            }
            if (!HintUtils.d(hint)) {
                boolean zA = this.f52236b.a();
                SentryAndroidOptions.BeforeCaptureCallback beforeViewHierarchyCaptureCallback = sentryAndroidOptions.getBeforeViewHierarchyCaptureCallback();
                if (beforeViewHierarchyCaptureCallback == null ? !zA : beforeViewHierarchyCaptureCallback.d()) {
                    WeakReference weakReference = CurrentActivityHolder.f52112b.f52113a;
                    ViewHierarchy viewHierarchyE = e(weakReference != null ? (Activity) weakReference.get() : null, sentryAndroidOptions.getViewHierarchyExporters(), sentryAndroidOptions.getMainThreadChecker(), sentryAndroidOptions.getLogger());
                    if (viewHierarchyE != null) {
                        hint.f51639d = Attachment.b(viewHierarchyE);
                    }
                }
            }
        }
        return sentryEvent;
    }

    @Override // io.sentry.EventProcessor
    public final SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }
}
