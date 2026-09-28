package com.swmansion.reanimated;

import android.view.View;
import com.swmansion.reanimated.keyboard.WindowsInsetsManager;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46902a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f46903b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f46904c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f46905d;

    public /* synthetic */ a(Object obj, int i2, int i3, int i4) {
        this.f46902a = i4;
        this.f46903b = obj;
        this.f46904c = i2;
        this.f46905d = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f46902a) {
            case 0:
                NativeMethodsHelper.lambda$scrollTo$0((View) this.f46903b, this.f46904c, this.f46905d);
                break;
            case 1:
                NativeMethodsHelper.lambda$scrollTo$1((View) this.f46903b, this.f46904c, this.f46905d);
                break;
            default:
                ((WindowsInsetsManager) this.f46903b).lambda$updateInsets$1(this.f46904c, this.f46905d);
                break;
        }
    }
}
