package com.google.android.material.textfield;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41381a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f41382b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f41381a = i2;
        this.f41382b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f41381a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f41382b).t(true);
                break;
            case 1:
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.f41382b;
                boolean zIsPopupShowing = dropdownMenuEndIconDelegate.f41277h.isPopupShowing();
                dropdownMenuEndIconDelegate.t(zIsPopupShowing);
                dropdownMenuEndIconDelegate.f41282m = zIsPopupShowing;
                break;
            default:
                ((TextInputLayout) this.f41382b).f41357d.requestLayout();
                break;
        }
    }
}
