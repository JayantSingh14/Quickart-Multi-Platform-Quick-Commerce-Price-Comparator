package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f148a = LazyKt.b(ImmLeaksCleaner$Companion$cleaner$2.f149c);

    @Metadata
    public static abstract class Cleaner {
    }

    @Metadata
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static final class Companion {
    }

    @Metadata
    public static final class FailedInitialization extends Cleaner {

        /* renamed from: a, reason: collision with root package name */
        public static final FailedInitialization f150a = new FailedInitialization();
    }

    @Metadata
    public static final class ValidCleaner extends Cleaner {
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            throw null;
        }
    }
}
