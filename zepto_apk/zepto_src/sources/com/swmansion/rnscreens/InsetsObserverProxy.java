package com.swmansion.rnscreens;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class InsetsObserverProxy implements OnApplyWindowInsetsListener, LifecycleEventListener {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f46930d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f46931e;

    /* renamed from: a, reason: collision with root package name */
    public static final InsetsObserverProxy f46927a = new InsetsObserverProxy();

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet f46928b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public static WeakReference f46929c = new WeakReference(null);

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f46932f = true;

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!f46930d || f46929c.get() == null) {
            ViewCompat.H(view, this);
            f46929c = new WeakReference(view);
            f46930d = true;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat b(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompatT = f46932f ? ViewCompat.t(v, insets) : insets;
        Intrinsics.c(windowInsetsCompatT);
        Iterator it = f46928b.iterator();
        while (it.hasNext()) {
            windowInsetsCompatT = ((OnApplyWindowInsetsListener) it.next()).b(v, insets);
        }
        return windowInsetsCompatT;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() {
        View view = (View) f46929c.get();
        if (f46930d && view != null) {
            ViewCompat.H(view, null);
            f46930d = false;
            f46929c.clear();
        }
        f46931e = false;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
    }
}
