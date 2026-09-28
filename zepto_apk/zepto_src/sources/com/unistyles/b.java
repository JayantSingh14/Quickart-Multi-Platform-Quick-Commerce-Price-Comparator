package com.unistyles;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f47295b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Platform f47296c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f47297d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f47298e;

    public /* synthetic */ b(KeyEvent.Callback callback, Platform platform, String str, float f2, int i2) {
        this.f47294a = i2;
        this.f47295b = callback;
        this.f47296c = platform;
        this.f47297d = str;
        this.f47298e = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f47294a) {
            case 0:
                Platform.onSetNavigationBarColor$lambda$3$lambda$2((Activity) this.f47295b, this.f47296c, this.f47297d, this.f47298e);
                break;
            case 1:
                Platform.onSetStatusBarColor$lambda$13$lambda$12((Activity) this.f47295b, this.f47296c, this.f47297d, this.f47298e);
                break;
            default:
                Platform.onSetRootViewBackgroundColor$lambda$16$lambda$15$lambda$14((View) this.f47295b, this.f47296c, this.f47297d, this.f47298e);
                break;
        }
    }
}
