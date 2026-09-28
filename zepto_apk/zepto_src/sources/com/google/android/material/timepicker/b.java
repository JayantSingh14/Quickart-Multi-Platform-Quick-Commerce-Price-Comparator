package com.google.android.material.timepicker;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41454a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f41455b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f41454a = i2;
        this.f41455b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f41454a) {
            case 0:
                Object obj = ((MaterialTimePicker) this.f41455b).E0;
                if (obj instanceof TimePickerTextInputPresenter) {
                    ((TimePickerTextInputPresenter) obj).d();
                    break;
                }
                break;
            default:
                ((RadialViewGroup) this.f41455b).q();
                break;
        }
    }
}
