package com.google.android.material.datepicker;

import android.view.View;
import com.swmansion.rnscreens.CustomSearchView;
import com.swmansion.rnscreens.ScreenStackHeaderConfig;
import com.swmansion.rnscreens.SearchBarView;
import in.juspay.hypernfc.NfcActivity;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40393a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f40394b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f40393a = i2;
        this.f40394b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f40393a) {
            case 0:
                MaterialDatePicker materialDatePicker = (MaterialDatePicker) this.f40394b;
                materialDatePicker.W0.setEnabled(materialDatePicker.z().y5());
                materialDatePicker.U0.toggle();
                materialDatePicker.J0 = materialDatePicker.J0 == 1 ? 0 : 1;
                materialDatePicker.D(materialDatePicker.U0);
                materialDatePicker.C();
                break;
            case 1:
                CustomSearchView customSearchView = (CustomSearchView) this.f40394b;
                View.OnClickListener onClickListener = customSearchView.W0;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                customSearchView.X0.a();
                break;
            case 2:
                ScreenStackHeaderConfig.a((ScreenStackHeaderConfig) this.f40394b);
                break;
            case 3:
                SearchBarView.l((SearchBarView) this.f40394b);
                break;
            default:
                NfcActivity.onCreate$lambda$1((NfcActivity) this.f40394b, view);
                break;
        }
    }
}
