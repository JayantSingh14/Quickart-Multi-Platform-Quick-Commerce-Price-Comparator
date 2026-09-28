package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f151a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f152b;

    /* renamed from: c, reason: collision with root package name */
    public OnBackPressedCallback f153c;

    /* renamed from: d, reason: collision with root package name */
    public final OnBackInvokedCallback f154d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedDispatcher f155e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f156f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f157g;

    @RequiresApi
    @Metadata
    public static final class Api33Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api33Impl f163a = new Api33Impl();

        @DoNotInline
        @NotNull
        public final OnBackInvokedCallback a(@NotNull final Function0<Unit> onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.l
                public final void onBackInvoked() {
                    Function0 onBackInvoked2 = onBackInvoked;
                    Intrinsics.checkNotNullParameter(onBackInvoked2, "$onBackInvoked");
                    onBackInvoked2.invoke();
                }
            };
        }

        @DoNotInline
        public final void b(@NotNull Object dispatcher, int i2, @NotNull Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) callback);
        }

        @DoNotInline
        public final void c(@NotNull Object dispatcher, @NotNull Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    @RequiresApi
    @Metadata
    /* loaded from: classes3.dex */
    public static final class Api34Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Api34Impl f164a = new Api34Impl();

        @DoNotInline
        @NotNull
        public final OnBackInvokedCallback a(@NotNull final Function1<? super BackEventCompat, Unit> onBackStarted, @NotNull final Function1<? super BackEventCompat, Unit> onBackProgressed, @NotNull final Function0<Unit> onBackInvoked, @NotNull final Function0<Unit> onBackCancelled) {
            Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public final void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                public final void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public final void onBackProgressed(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public final void onBackStarted(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackStarted.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    @Metadata
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f169a;

        /* renamed from: b, reason: collision with root package name */
        public final OnBackPressedCallback f170b;

        /* renamed from: c, reason: collision with root package name */
        public Cancellable f171c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f172d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.f172d = onBackPressedDispatcher;
            this.f169a = lifecycle;
            this.f170b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void a(LifecycleOwner source, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f171c = this.f172d.b(this.f170b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                Cancellable cancellable = this.f171c;
                if (cancellable != null) {
                    ((OnBackPressedCancellable) cancellable).cancel();
                }
            }
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            this.f169a.c(this);
            this.f170b.removeCancellable(this);
            Cancellable cancellable = this.f171c;
            if (cancellable != null) {
                ((OnBackPressedCancellable) cancellable).cancel();
            }
            this.f171c = null;
        }
    }

    @Metadata
    public final class OnBackPressedCancellable implements Cancellable {

        /* renamed from: a, reason: collision with root package name */
        public final OnBackPressedCallback f173a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f174b;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.f174b = onBackPressedDispatcher;
            this.f173a = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f174b;
            ArrayDeque arrayDeque = onBackPressedDispatcher.f152b;
            OnBackPressedCallback onBackPressedCallback = this.f173a;
            arrayDeque.remove(onBackPressedCallback);
            if (Intrinsics.b(onBackPressedDispatcher.f153c, onBackPressedCallback)) {
                onBackPressedCallback.handleOnBackCancelled();
                onBackPressedDispatcher.f153c = null;
            }
            onBackPressedCallback.removeCancellable(this);
            Function0<Unit> enabledChangedCallback$activity_release = onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f151a = runnable;
        this.f152b = new ArrayDeque();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.f154d = i2 >= 34 ? Api34Impl.f164a.a(new Function1<BackEventCompat, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object objPrevious;
                    BackEventCompat backEvent = (BackEventCompat) obj;
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                    ArrayDeque arrayDeque = onBackPressedDispatcher.f152b;
                    ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.b());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            objPrevious = null;
                            break;
                        }
                        objPrevious = listIterator.previous();
                        if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                            break;
                        }
                    }
                    OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) objPrevious;
                    if (onBackPressedDispatcher.f153c != null) {
                        onBackPressedDispatcher.c();
                    }
                    onBackPressedDispatcher.f153c = onBackPressedCallback;
                    if (onBackPressedCallback != null) {
                        onBackPressedCallback.handleOnBackStarted(backEvent);
                    }
                    return Unit.f53572a;
                }
            }, new Function1<BackEventCompat, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object objPrevious;
                    BackEventCompat backEvent = (BackEventCompat) obj;
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                    OnBackPressedCallback onBackPressedCallback = onBackPressedDispatcher.f153c;
                    if (onBackPressedCallback == null) {
                        ArrayDeque arrayDeque = onBackPressedDispatcher.f152b;
                        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.b());
                        while (true) {
                            if (!listIterator.hasPrevious()) {
                                objPrevious = null;
                                break;
                            }
                            objPrevious = listIterator.previous();
                            if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                                break;
                            }
                        }
                        onBackPressedCallback = (OnBackPressedCallback) objPrevious;
                    }
                    if (onBackPressedCallback != null) {
                        onBackPressedCallback.handleOnBackProgressed(backEvent);
                    }
                    return Unit.f53572a;
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    OnBackPressedDispatcher.this.d();
                    return Unit.f53572a;
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    OnBackPressedDispatcher.this.c();
                    return Unit.f53572a;
                }
            }) : Api33Impl.f163a.a(new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    OnBackPressedDispatcher.this.d();
                    return Unit.f53572a;
                }
            });
        }
    }

    public final void a(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.f4805a) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        f();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(0, this, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0));
    }

    public final Cancellable b(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f152b.addLast(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        f();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(0, this, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0));
        return onBackPressedCancellable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void c() {
        OnBackPressedCallback onBackPressedCallbackPrevious;
        OnBackPressedCallback onBackPressedCallback = this.f153c;
        if (onBackPressedCallback == null) {
            ArrayDeque arrayDeque = this.f152b;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = 0;
                    break;
                } else {
                    onBackPressedCallbackPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallbackPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        this.f153c = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackCancelled();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void d() {
        OnBackPressedCallback onBackPressedCallbackPrevious;
        OnBackPressedCallback onBackPressedCallback = this.f153c;
        if (onBackPressedCallback == null) {
            ArrayDeque arrayDeque = this.f152b;
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    onBackPressedCallbackPrevious = 0;
                    break;
                } else {
                    onBackPressedCallbackPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) onBackPressedCallbackPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = onBackPressedCallbackPrevious;
        }
        this.f153c = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f151a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void e(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f155e;
        OnBackInvokedCallback onBackInvokedCallback = this.f154d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        Api33Impl api33Impl = Api33Impl.f163a;
        if (z && !this.f156f) {
            api33Impl.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f156f = true;
        } else {
            if (z || !this.f156f) {
                return;
            }
            api33Impl.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f156f = false;
        }
    }

    public final void f() {
        boolean z = this.f157g;
        boolean z2 = false;
        ArrayDeque arrayDeque = this.f152b;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((OnBackPressedCallback) it.next()).isEnabled()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.f157g = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        e(z2);
    }

    @JvmOverloads
    public OnBackPressedDispatcher() {
        this(null);
    }
}
