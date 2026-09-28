package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.support.v4.media.b;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.media3.exoplayer.analytics.d;
import androidx.work.impl.c;
import androidx.work.impl.model.a;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import in.juspay.hyper.constants.LogSubCategory;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.ITransaction;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import io.sentry.TransactionContext;
import io.sentry.TransactionOptions;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.UiElement;
import io.sentry.protocol.TransactionNameSource;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryGestureListener implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f52263a;

    /* renamed from: b, reason: collision with root package name */
    public final HubAdapter f52264b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryAndroidOptions f52265c;

    /* renamed from: d, reason: collision with root package name */
    public UiElement f52266d = null;

    /* renamed from: e, reason: collision with root package name */
    public ITransaction f52267e = null;

    /* renamed from: f, reason: collision with root package name */
    public GestureType f52268f;

    /* renamed from: g, reason: collision with root package name */
    public final ScrollState f52269g;

    /* renamed from: io.sentry.android.core.internal.gestures.SentryGestureListener$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52270a;

        static {
            int[] iArr = new int[GestureType.values().length];
            f52270a = iArr;
            try {
                iArr[GestureType.Click.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52270a[GestureType.Scroll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52270a[GestureType.Swipe.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52270a[GestureType.Unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum GestureType {
        Click,
        Scroll,
        Swipe,
        Unknown
    }

    /* loaded from: classes3.dex */
    public static final class ScrollState {

        /* renamed from: a, reason: collision with root package name */
        public GestureType f52271a;

        /* renamed from: b, reason: collision with root package name */
        public UiElement f52272b;

        /* renamed from: c, reason: collision with root package name */
        public float f52273c;

        /* renamed from: d, reason: collision with root package name */
        public float f52274d;
    }

    public SentryGestureListener(Activity activity, HubAdapter hubAdapter, SentryAndroidOptions sentryAndroidOptions) {
        GestureType gestureType = GestureType.Unknown;
        this.f52268f = gestureType;
        ScrollState scrollState = new ScrollState();
        scrollState.f52271a = gestureType;
        scrollState.f52273c = 0.0f;
        scrollState.f52274d = 0.0f;
        this.f52269g = scrollState;
        this.f52263a = new WeakReference(activity);
        this.f52264b = hubAdapter;
        this.f52265c = sentryAndroidOptions;
    }

    public final void a(UiElement uiElement, GestureType gestureType, Map map, MotionEvent motionEvent) {
        if (this.f52265c.isEnableUserInteractionBreadcrumbs()) {
            int i2 = AnonymousClass1.f52270a[gestureType.ordinal()];
            String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? zzck.UNKNOWN_CONTENT_TYPE : "swipe" : "scroll" : "click";
            Hint hint = new Hint();
            hint.c(motionEvent, "android:motionEvent");
            hint.c(uiElement.e(), "android:view");
            String strD = uiElement.d();
            String strA = uiElement.a();
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.f51558d = LogSubCategory.Action.USER;
            breadcrumb.f51560f = "ui.".concat(str);
            if (strD != null) {
                breadcrumb.b(strD, "view.id");
            }
            if (strA != null) {
                breadcrumb.b(strA, "view.class");
            }
            for (Map.Entry entry : map.entrySet()) {
                breadcrumb.f51559e.put((String) entry.getKey(), entry.getValue());
            }
            breadcrumb.f51562h = SentryLevel.INFO;
            this.f52264b.b(breadcrumb, hint);
        }
    }

    public final View b(String str) {
        Activity activity = (Activity) this.f52263a.get();
        SentryAndroidOptions sentryAndroidOptions = this.f52265c;
        if (activity == null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, b.D("Activity is null in ", str, ". No breadcrumb captured."), new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, b.D("Window is null in ", str, ". No breadcrumb captured."), new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, b.D("DecorView is null in ", str, ". No breadcrumb captured."), new Object[0]);
        return null;
    }

    public final void c(UiElement uiElement, GestureType gestureType) {
        boolean z = gestureType == GestureType.Click || !(gestureType == this.f52268f && uiElement.equals(this.f52266d));
        SentryAndroidOptions sentryAndroidOptions = this.f52265c;
        boolean zIsTracingEnabled = sentryAndroidOptions.isTracingEnabled();
        HubAdapter hubAdapter = this.f52264b;
        if (!zIsTracingEnabled || !sentryAndroidOptions.isEnableUserInteractionTracing()) {
            if (z) {
                a aVar = new a(27);
                hubAdapter.getClass();
                Sentry.c(aVar);
                this.f52266d = uiElement;
                this.f52268f = gestureType;
                return;
            }
            return;
        }
        Activity activity = (Activity) this.f52263a.get();
        if (activity == null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        String strB = uiElement.b();
        ITransaction iTransaction = this.f52267e;
        if (iTransaction != null) {
            if (!z && !iTransaction.b()) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, b.D("The view with id: ", strB, " already has an ongoing transaction assigned. Rescheduling finish"), new Object[0]);
                if (sentryAndroidOptions.getIdleTimeout() != null) {
                    this.f52267e.n();
                    return;
                }
                return;
            }
            d(SpanStatus.OK);
        }
        String str = activity.getClass().getSimpleName() + CLConstants.DOT_SALT_DELIMETER + strB;
        int i2 = AnonymousClass1.f52270a[gestureType.ordinal()];
        String strConcat = "ui.action.".concat(i2 != 1 ? i2 != 2 ? i2 != 3 ? zzck.UNKNOWN_CONTENT_TYPE : "swipe" : "scroll" : "click");
        TransactionOptions transactionOptions = new TransactionOptions();
        transactionOptions.h();
        transactionOptions.d();
        transactionOptions.e(sentryAndroidOptions.getIdleTimeout());
        transactionOptions.a();
        ITransaction iTransactionB = hubAdapter.B(new TransactionContext(str, TransactionNameSource.COMPONENT, strConcat), transactionOptions);
        iTransactionB.o().f51929i = "auto.ui.gesture_listener." + uiElement.c();
        Sentry.c(new d(21, this, iTransactionB));
        this.f52267e = iTransactionB;
        this.f52266d = uiElement;
        this.f52268f = gestureType;
    }

    public final void d(SpanStatus spanStatus) {
        ITransaction iTransaction = this.f52267e;
        if (iTransaction != null) {
            if (iTransaction.getStatus() == null) {
                this.f52267e.j(spanStatus);
            } else {
                this.f52267e.c();
            }
        }
        c cVar = new c(this, 8);
        this.f52264b.getClass();
        Sentry.c(cVar);
        this.f52267e = null;
        if (this.f52266d != null) {
            this.f52266d = null;
        }
        this.f52268f = GestureType.Unknown;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        ScrollState scrollState = this.f52269g;
        scrollState.f52272b = null;
        scrollState.f52271a = GestureType.Unknown;
        scrollState.f52273c = 0.0f;
        scrollState.f52274d = 0.0f;
        scrollState.f52273c = motionEvent.getX();
        scrollState.f52274d = motionEvent.getY();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f52269g.f52271a = GestureType.Swipe;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        View viewB = b("onScroll");
        if (viewB != null && motionEvent != null) {
            ScrollState scrollState = this.f52269g;
            if (scrollState.f52271a == GestureType.Unknown) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                UiElement.Type type = UiElement.Type.SCROLLABLE;
                SentryAndroidOptions sentryAndroidOptions = this.f52265c;
                UiElement uiElementA = ViewUtils.a(sentryAndroidOptions, viewB, x, y, type);
                if (uiElementA == null) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                    return false;
                }
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Scroll target found: " + uiElementA.b(), new Object[0]);
                scrollState.f52272b = uiElementA;
                scrollState.f52271a = GestureType.Scroll;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        View viewB = b("onSingleTapUp");
        if (viewB != null && motionEvent != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            UiElement.Type type = UiElement.Type.CLICKABLE;
            SentryAndroidOptions sentryAndroidOptions = this.f52265c;
            UiElement uiElementA = ViewUtils.a(sentryAndroidOptions, viewB, x, y, type);
            if (uiElementA == null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            GestureType gestureType = GestureType.Click;
            a(uiElementA, gestureType, Collections.EMPTY_MAP, motionEvent);
            c(uiElementA, gestureType);
        }
        return false;
    }
}
