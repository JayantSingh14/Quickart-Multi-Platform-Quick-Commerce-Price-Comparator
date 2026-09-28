package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
class ViewOffsetHelper {

    /* renamed from: a, reason: collision with root package name */
    public final View f39903a;

    /* renamed from: b, reason: collision with root package name */
    public int f39904b;

    /* renamed from: c, reason: collision with root package name */
    public int f39905c;

    /* renamed from: d, reason: collision with root package name */
    public int f39906d;

    public ViewOffsetHelper(View view) {
        this.f39903a = view;
    }

    public final void a() {
        int i2 = this.f39906d;
        View view = this.f39903a;
        int top = i2 - (view.getTop() - this.f39904b);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f39905c));
    }

    public final boolean b(int i2) {
        if (this.f39906d == i2) {
            return false;
        }
        this.f39906d = i2;
        a();
        return true;
    }
}
