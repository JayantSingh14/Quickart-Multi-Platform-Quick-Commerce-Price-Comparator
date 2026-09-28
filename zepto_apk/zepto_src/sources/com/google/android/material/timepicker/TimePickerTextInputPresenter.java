package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes4.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f41436a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeModel f41437b;

    /* renamed from: c, reason: collision with root package name */
    public final TextWatcher f41438c;

    /* renamed from: d, reason: collision with root package name */
    public final TextWatcher f41439d;

    /* renamed from: e, reason: collision with root package name */
    public final ChipTextInputComboView f41440e;

    /* renamed from: f, reason: collision with root package name */
    public final ChipTextInputComboView f41441f;

    /* renamed from: g, reason: collision with root package name */
    public final EditText f41442g;

    /* renamed from: h, reason: collision with root package name */
    public final EditText f41443h;

    /* renamed from: i, reason: collision with root package name */
    public final MaterialButtonToggleGroup f41444i;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, final TimeModel timeModel) {
        TextWatcherAdapter textWatcherAdapter = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) throws NumberFormatException {
                try {
                    boolean zIsEmpty = TextUtils.isEmpty(editable);
                    TimePickerTextInputPresenter timePickerTextInputPresenter = TimePickerTextInputPresenter.this;
                    if (zIsEmpty) {
                        timePickerTextInputPresenter.f41437b.f41419e = 0;
                        return;
                    }
                    timePickerTextInputPresenter.f41437b.f41419e = Integer.parseInt(editable.toString()) % 60;
                } catch (NumberFormatException unused) {
                }
            }
        };
        this.f41438c = textWatcherAdapter;
        TextWatcherAdapter textWatcherAdapter2 = new TextWatcherAdapter() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.2
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void afterTextChanged(Editable editable) throws NumberFormatException {
                try {
                    boolean zIsEmpty = TextUtils.isEmpty(editable);
                    TimePickerTextInputPresenter timePickerTextInputPresenter = TimePickerTextInputPresenter.this;
                    if (zIsEmpty) {
                        timePickerTextInputPresenter.f41437b.c(0);
                    } else {
                        timePickerTextInputPresenter.f41437b.c(Integer.parseInt(editable.toString()));
                    }
                } catch (NumberFormatException unused) {
                }
            }
        };
        this.f41439d = textWatcherAdapter2;
        this.f41436a = linearLayout;
        this.f41437b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f41440e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f41441f = chipTextInputComboView2;
        TextView textView = (TextView) chipTextInputComboView.findViewById(R.id.material_label);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(R.id.material_label);
        textView.setText(resources.getString(R.string.material_timepicker_minute));
        textView2.setText(resources.getString(R.string.material_timepicker_hour));
        chipTextInputComboView.setTag(R.id.selection_type, 12);
        chipTextInputComboView2.setTag(R.id.selection_type, 10);
        if (timeModel.f41417c == 0) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) linearLayout.findViewById(R.id.material_clock_period_toggle);
            this.f41444i = materialButtonToggleGroup;
            materialButtonToggleGroup.f40102c.add(new c(this, 0));
            this.f41444i.setVisibility(0);
            f();
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerTextInputPresenter.this.b(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(onClickListener);
        chipTextInputComboView.setOnClickListener(onClickListener);
        EditText editText = chipTextInputComboView2.f41391c;
        InputFilter[] filters = editText.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = timeModel.f41416b;
        editText.setFilters(inputFilterArr);
        EditText editText2 = chipTextInputComboView.f41391c;
        InputFilter[] filters2 = editText2.getFilters();
        InputFilter[] inputFilterArr2 = (InputFilter[]) Arrays.copyOf(filters2, filters2.length + 1);
        inputFilterArr2[filters2.length] = timeModel.f41415a;
        editText2.setFilters(inputFilterArr2);
        TextInputLayout textInputLayout = chipTextInputComboView2.f41390b;
        EditText editText3 = textInputLayout.getEditText();
        this.f41442g = editText3;
        TextInputLayout textInputLayout2 = chipTextInputComboView.f41390b;
        EditText editText4 = textInputLayout2.getEditText();
        this.f41443h = editText4;
        TimePickerTextInputKeyController timePickerTextInputKeyController = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        ViewCompat.z(chipTextInputComboView2.f41389a, new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection) { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.4
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                Resources resources2 = view.getResources();
                TimeModel timeModel2 = timeModel;
                accessibilityNodeInfoCompat.q(resources2.getString(timeModel2.f41417c == 1 ? R.string.material_hour_24h_suffix : R.string.material_hour_suffix, String.valueOf(timeModel2.b())));
            }
        });
        ViewCompat.z(chipTextInputComboView.f41389a, new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection) { // from class: com.google.android.material.timepicker.TimePickerTextInputPresenter.5
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.q(view.getResources().getString(R.string.material_minute_suffix, String.valueOf(timeModel.f41419e)));
            }
        });
        editText3.addTextChangedListener(textWatcherAdapter2);
        editText4.addTextChangedListener(textWatcherAdapter);
        e(timeModel);
        EditText editText5 = textInputLayout.getEditText();
        EditText editText6 = textInputLayout2.getEditText();
        editText5.setImeOptions(268435461);
        editText6.setImeOptions(268435462);
        editText5.setOnEditorActionListener(timePickerTextInputKeyController);
        editText5.setOnKeyListener(timePickerTextInputKeyController);
        editText6.setOnKeyListener(timePickerTextInputKeyController);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void a() {
        this.f41436a.setVisibility(0);
        b(this.f41437b.f41420f);
    }

    public final void b(int i2) {
        this.f41437b.f41420f = i2;
        this.f41440e.setChecked(i2 == 12);
        this.f41441f.setChecked(i2 == 10);
        f();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void c() {
        LinearLayout linearLayout = this.f41436a;
        View focusedChild = linearLayout.getFocusedChild();
        if (focusedChild != null) {
            ViewUtils.g(focusedChild, false);
        }
        linearLayout.setVisibility(8);
    }

    public final void d() {
        TimeModel timeModel = this.f41437b;
        this.f41440e.setChecked(timeModel.f41420f == 12);
        this.f41441f.setChecked(timeModel.f41420f == 10);
    }

    public final void e(TimeModel timeModel) {
        TextWatcher textWatcher = this.f41439d;
        EditText editText = this.f41442g;
        editText.removeTextChangedListener(textWatcher);
        TextWatcher textWatcher2 = this.f41438c;
        EditText editText2 = this.f41443h;
        editText2.removeTextChangedListener(textWatcher2);
        Locale locale = this.f41436a.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.f41419e));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.b()));
        ChipTextInputComboView chipTextInputComboView = this.f41440e;
        String strA = TimeModel.a(chipTextInputComboView.getResources(), str, "%02d");
        chipTextInputComboView.f41389a.setText(strA);
        if (!TextUtils.isEmpty(strA)) {
            TextWatcher textWatcher3 = chipTextInputComboView.f41392d;
            EditText editText3 = chipTextInputComboView.f41391c;
            editText3.removeTextChangedListener(textWatcher3);
            editText3.setText(strA);
            editText3.addTextChangedListener(textWatcher3);
        }
        ChipTextInputComboView chipTextInputComboView2 = this.f41441f;
        String strA2 = TimeModel.a(chipTextInputComboView2.getResources(), str2, "%02d");
        chipTextInputComboView2.f41389a.setText(strA2);
        if (!TextUtils.isEmpty(strA2)) {
            TextWatcher textWatcher4 = chipTextInputComboView2.f41392d;
            EditText editText4 = chipTextInputComboView2.f41391c;
            editText4.removeTextChangedListener(textWatcher4);
            editText4.setText(strA2);
            editText4.addTextChangedListener(textWatcher4);
        }
        editText.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher2);
        f();
    }

    public final void f() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f41444i;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.b(this.f41437b.f41421g == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button, true);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public final void invalidate() {
        e(this.f41437b);
    }
}
