package com.google.android.material.timepicker;

import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41456a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f41457b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f41456a = i2;
        this.f41457b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void a(int i2, boolean z) {
        Object obj = this.f41457b;
        switch (this.f41456a) {
            case 0:
                TimePickerTextInputPresenter timePickerTextInputPresenter = (TimePickerTextInputPresenter) obj;
                timePickerTextInputPresenter.getClass();
                if (z) {
                    timePickerTextInputPresenter.f41437b.d(i2 == R.id.material_clock_period_pm_button ? 1 : 0);
                    break;
                }
                break;
            default:
                TimePickerView timePickerView = (TimePickerView) obj;
                if (!z) {
                    int i3 = TimePickerView.z;
                    break;
                } else {
                    TimePickerClockPresenter timePickerClockPresenter = timePickerView.w;
                    if (timePickerClockPresenter != null) {
                        timePickerClockPresenter.f41426b.d(i2 == R.id.material_clock_period_pm_button ? 1 : 0);
                        break;
                    }
                }
                break;
        }
    }
}
