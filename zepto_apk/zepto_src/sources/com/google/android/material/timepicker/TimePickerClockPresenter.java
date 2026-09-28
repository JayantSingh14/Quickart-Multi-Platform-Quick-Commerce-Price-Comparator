package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.WeakHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f41422f = {"12", "1", "2", "3", "4", "5", CLConstants.CREDTYPE_DEBIT_DLENGTH, "7", "8", "9", "10", "11"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f41423g = {"00", "1", "2", "3", "4", "5", CLConstants.CREDTYPE_DEBIT_DLENGTH, "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f41424h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: a, reason: collision with root package name */
    public final TimePickerView f41425a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModel f41426b;

    /* renamed from: c, reason: collision with root package name */
    public float f41427c;

    /* renamed from: d, reason: collision with root package name */
    public float f41428d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f41429e = false;

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.f41425a = timePickerView;
        this.f41426b = timeModel;
        if (timeModel.f41417c == 0) {
            timePickerView.u.setVisibility(0);
        }
        timePickerView.s.f41407j.add(this);
        timePickerView.x = this;
        timePickerView.w = this;
        timePickerView.s.r = this;
        String[] strArr = f41422f;
        for (int i2 = 0; i2 < 12; i2++) {
            strArr[i2] = TimeModel.a(this.f41425a.getResources(), strArr[i2], "%d");
        }
        String[] strArr2 = f41424h;
        for (int i3 = 0; i3 < 12; i3++) {
            strArr2[i3] = TimeModel.a(this.f41425a.getResources(), strArr2[i3], "%02d");
        }
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void a() {
        this.f41425a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public final void b(float f2, boolean z) {
        if (this.f41429e) {
            return;
        }
        TimeModel timeModel = this.f41426b;
        int i2 = timeModel.f41418d;
        int i3 = timeModel.f41419e;
        int iRound = Math.round(f2);
        int i4 = timeModel.f41420f;
        TimePickerView timePickerView = this.f41425a;
        if (i4 == 12) {
            timeModel.f41419e = ((iRound + 3) / 6) % 60;
            this.f41427c = (float) Math.floor(r8 * 6);
        } else {
            int i5 = (iRound + 15) / 30;
            if (timeModel.f41417c == 1) {
                i5 %= 12;
                if (timePickerView.t.t.u == 2) {
                    i5 += 12;
                }
            }
            timeModel.c(i5);
            this.f41428d = (timeModel.b() * 30) % 360;
        }
        if (z) {
            return;
        }
        e();
        if (timeModel.f41419e == i3 && timeModel.f41418d == i2) {
            return;
        }
        timePickerView.performHapticFeedback(4);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void c() {
        this.f41425a.setVisibility(8);
    }

    public final void d(int i2, boolean z) {
        boolean z2 = i2 == 12;
        TimePickerView timePickerView = this.f41425a;
        timePickerView.s.f41401d = z2;
        TimeModel timeModel = this.f41426b;
        timeModel.f41420f = i2;
        int i3 = timeModel.f41417c;
        String[] strArr = z2 ? f41424h : i3 == 1 ? f41423g : f41422f;
        int i4 = z2 ? R.string.material_minute_suffix : i3 == 1 ? R.string.material_hour_24h_suffix : R.string.material_hour_suffix;
        ClockFaceView clockFaceView = timePickerView.t;
        clockFaceView.s(i4, strArr);
        int i5 = (timeModel.f41420f == 10 && i3 == 1 && timeModel.f41418d >= 12) ? 2 : 1;
        ClockHandView clockHandView = clockFaceView.t;
        clockHandView.u = i5;
        clockHandView.invalidate();
        timePickerView.s.c(z2 ? this.f41427c : this.f41428d, z);
        boolean z3 = i2 == 12;
        Chip chip = timePickerView.q;
        chip.setChecked(z3);
        int i6 = z3 ? 2 : 0;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        chip.setAccessibilityLiveRegion(i6);
        boolean z4 = i2 == 10;
        Chip chip2 = timePickerView.r;
        chip2.setChecked(z4);
        chip2.setAccessibilityLiveRegion(z4 ? 2 : 0);
        ViewCompat.z(chip2, new ClickActionDelegate(timePickerView.getContext(), R.string.material_hour_selection) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.1
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                Resources resources = view.getResources();
                TimeModel timeModel2 = TimePickerClockPresenter.this.f41426b;
                accessibilityNodeInfoCompat.q(resources.getString(timeModel2.f41417c == 1 ? R.string.material_hour_24h_suffix : R.string.material_hour_suffix, String.valueOf(timeModel2.b())));
            }
        });
        ViewCompat.z(chip, new ClickActionDelegate(timePickerView.getContext(), R.string.material_minute_selection) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.2
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.q(view.getResources().getString(R.string.material_minute_suffix, String.valueOf(TimePickerClockPresenter.this.f41426b.f41419e)));
            }
        });
    }

    public final void e() {
        TimeModel timeModel = this.f41426b;
        int i2 = timeModel.f41421g;
        int iB = timeModel.b();
        int i3 = timeModel.f41419e;
        TimePickerView timePickerView = this.f41425a;
        timePickerView.getClass();
        timePickerView.u.b(i2 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button, true);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i3));
        String str2 = String.format(locale, "%02d", Integer.valueOf(iB));
        Chip chip = timePickerView.q;
        if (!TextUtils.equals(chip.getText(), str)) {
            chip.setText(str);
        }
        Chip chip2 = timePickerView.r;
        if (TextUtils.equals(chip2.getText(), str2)) {
            return;
        }
        chip2.setText(str2);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void invalidate() {
        TimeModel timeModel = this.f41426b;
        this.f41428d = (timeModel.b() * 30) % 360;
        this.f41427c = timeModel.f41419e * 6;
        d(timeModel.f41420f, false);
        e();
    }
}
