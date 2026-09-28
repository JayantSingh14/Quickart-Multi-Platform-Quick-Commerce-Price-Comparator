package androidx.transition;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi
/* loaded from: classes3.dex */
class GhostViewPlatform implements GhostView {

    /* renamed from: b, reason: collision with root package name */
    public static Class f12083b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12084c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f12085d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12086e;

    /* renamed from: f, reason: collision with root package name */
    public static Method f12087f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f12088g;

    /* renamed from: a, reason: collision with root package name */
    public final View f12089a;

    public GhostViewPlatform(View view) {
        this.f12089a = view;
    }

    public static void b() {
        if (f12084c) {
            return;
        }
        try {
            f12083b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        f12084c = true;
    }

    @Override // androidx.transition.GhostView
    public final void setVisibility(int i2) {
        this.f12089a.setVisibility(i2);
    }

    @Override // androidx.transition.GhostView
    public final void a(View view, ViewGroup viewGroup) {
    }
}
