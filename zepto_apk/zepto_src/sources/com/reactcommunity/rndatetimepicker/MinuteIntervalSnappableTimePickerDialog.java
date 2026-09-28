package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import androidx.fragment.app.FragmentActivity;
import com.reactcommunity.rndatetimepicker.TimePickerModule;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
class MinuteIntervalSnappableTimePickerDialog extends TimePickerDialog {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f46138h = 0;

    /* renamed from: a, reason: collision with root package name */
    public TimePicker f46139a;

    /* renamed from: b, reason: collision with root package name */
    public final int f46140b;

    /* renamed from: c, reason: collision with root package name */
    public final RNTimePickerDisplay f46141c;

    /* renamed from: d, reason: collision with root package name */
    public final TimePickerDialog.OnTimeSetListener f46142d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f46143e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f46144f;

    /* renamed from: g, reason: collision with root package name */
    public final FragmentActivity f46145g;

    public MinuteIntervalSnappableTimePickerDialog(FragmentActivity fragmentActivity, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(fragmentActivity, onTimeSetListener, i2, i3, z);
        this.f46143e = new Handler();
        this.f46140b = i4;
        this.f46142d = onTimeSetListener;
        this.f46141c = rNTimePickerDisplay;
        this.f46145g = fragmentActivity;
    }

    public final boolean a() {
        return this.f46141c == RNTimePickerDisplay.f46154a;
    }

    public final int b(int i2) {
        int i3 = this.f46140b;
        int iRound = Math.round(i2 / i3) * i3;
        return iRound == 60 ? iRound - i3 : iRound;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FragmentActivity fragmentActivity = this.f46145g;
        TimePicker timePicker = (TimePicker) findViewById(fragmentActivity.getResources().getIdentifier("timePicker", CLConstants.SHARED_PREFERENCE_ITEM_ID, LogSubCategory.LifeCycle.ANDROID));
        this.f46139a = timePicker;
        if (this.f46140b != 1) {
            if (timePicker == null) {
                Log.e("RN-datetimepicker", "time picker was null");
                return;
            }
            int iIntValue = timePicker.getCurrentMinute().intValue();
            if (!a()) {
                this.f46139a.setCurrentMinute(Integer.valueOf(b(iIntValue)));
                return;
            }
            NumberPicker numberPicker = (NumberPicker) findViewById(fragmentActivity.getResources().getIdentifier("minute", CLConstants.SHARED_PREFERENCE_ITEM_ID, LogSubCategory.LifeCycle.ANDROID));
            numberPicker.setMinValue(0);
            int i2 = this.f46140b;
            int i3 = 60 / i2;
            numberPicker.setMaxValue(i3 - 1);
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 < 60; i4 += i2) {
                arrayList.add(String.format("%02d", Integer.valueOf(i4)));
            }
            numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
            this.f46139a.setCurrentMinute(Integer.valueOf(b(iIntValue) / i2));
        }
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        boolean z = this.f46140b != 1 || a();
        TimePicker timePicker = this.f46139a;
        if (timePicker == null || i2 != -1 || !z) {
            super.onClick(dialogInterface, i2);
            return;
        }
        timePicker.clearFocus();
        int iIntValue = this.f46139a.getCurrentHour().intValue();
        int iIntValue2 = this.f46139a.getCurrentMinute().intValue();
        if (a()) {
            iIntValue2 *= this.f46140b;
        }
        if (this.f46140b != 1) {
            iIntValue2 = b(iIntValue2);
        }
        TimePickerDialog.OnTimeSetListener onTimeSetListener = this.f46142d;
        if (onTimeSetListener != null) {
            ((TimePickerModule.TimePickerDialogListener) onTimeSetListener).onTimeSet(this.f46139a, iIntValue, iIntValue2);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f46143e.removeCallbacks(this.f46144f);
        super.onDetachedFromWindow();
    }

    @Override // android.app.TimePickerDialog, android.widget.TimePicker.OnTimeChangedListener
    public void onTimeChanged(final TimePicker timePicker, final int i2, int i3) {
        int i4 = a() ? this.f46140b * i3 : i3;
        Handler handler = this.f46143e;
        handler.removeCallbacks(this.f46144f);
        if (!a()) {
            if (a()) {
                throw new RuntimeException("minutesNeedCorrection is not intended to be used with spinner, spinner won't allow picking invalid values");
            }
            if (this.f46140b != 1 && i4 != b(i4)) {
                final int iB = b(i4);
                if (a()) {
                    throw new RuntimeException("spinner never needs to be corrected because wrong values are not offered to user (both in scrolling and textInput mode)!");
                }
                Runnable runnable = new Runnable() { // from class: com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MinuteIntervalSnappableTimePickerDialog minuteIntervalSnappableTimePickerDialog = MinuteIntervalSnappableTimePickerDialog.this;
                        View viewFindViewById = minuteIntervalSnappableTimePickerDialog.findViewById(minuteIntervalSnappableTimePickerDialog.f46145g.getResources().getIdentifier("input_mode", CLConstants.SHARED_PREFERENCE_ITEM_ID, LogSubCategory.LifeCycle.ANDROID));
                        int i5 = i2;
                        TimePicker timePicker2 = timePicker;
                        int i6 = iB;
                        if (viewFindViewById == null || !viewFindViewById.hasFocus()) {
                            timePicker2.setHour(i5);
                            timePicker2.setMinute(i6);
                        } else if (i6 > 5) {
                            timePicker2.setHour(i5);
                            timePicker2.setMinute(i6);
                            View viewFindFocus = timePicker2.findFocus();
                            if (!(viewFindFocus instanceof EditText)) {
                                Log.e("RN-datetimepicker", "could not set selection on time picker, this is a known issue on some Huawei devices");
                            } else {
                                EditText editText = (EditText) viewFindFocus;
                                editText.setSelection(editText.getText().length());
                            }
                        }
                    }
                };
                this.f46144f = runnable;
                handler.postDelayed(runnable, 500L);
                return;
            }
        }
        super.onTimeChanged(timePicker, i2, i3);
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i2, int i3) {
        if (this.f46140b == 1) {
            super.updateTime(i2, i3);
            return;
        }
        if (!a()) {
            super.updateTime(i2, b(i3));
            return;
        }
        int iIntValue = this.f46139a.getCurrentMinute().intValue();
        if (a()) {
            iIntValue *= this.f46140b;
        }
        super.updateTime(i2, b(iIntValue) / this.f46140b);
    }

    public MinuteIntervalSnappableTimePickerDialog(FragmentActivity fragmentActivity, int i2, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i3, int i4, int i5, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(fragmentActivity, i2, onTimeSetListener, i3, i4, z);
        this.f46143e = new Handler();
        this.f46140b = i5;
        this.f46142d = onTimeSetListener;
        this.f46141c = rNTimePickerDisplay;
        this.f46145g = fragmentActivity;
    }
}
