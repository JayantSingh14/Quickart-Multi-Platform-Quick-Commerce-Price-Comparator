package com.google.android.material.textfield;

import android.view.View;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41377a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f41378b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i2) {
        this.f41377a = i2;
        this.f41378b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f41377a) {
            case 0:
                ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) this.f41378b;
                clearTextEndIconDelegate.t(clearTextEndIconDelegate.u());
                break;
            default:
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.f41378b;
                dropdownMenuEndIconDelegate.f41281l = z;
                dropdownMenuEndIconDelegate.q();
                if (!z) {
                    dropdownMenuEndIconDelegate.t(false);
                    dropdownMenuEndIconDelegate.f41282m = false;
                    break;
                }
                break;
        }
    }
}
