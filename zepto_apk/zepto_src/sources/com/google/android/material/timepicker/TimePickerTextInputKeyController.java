package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: classes4.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final ChipTextInputComboView f41432a;

    /* renamed from: b, reason: collision with root package name */
    public final ChipTextInputComboView f41433b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeModel f41434c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f41435d = false;

    public TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f41432a = chipTextInputComboView;
        this.f41433b = chipTextInputComboView2;
        this.f41434c = timeModel;
    }

    public final void a(int i2) {
        this.f41433b.setChecked(i2 == 12);
        this.f41432a.setChecked(i2 == 10);
        this.f41434c.f41420f = i2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z = i2 == 5;
        if (z) {
            a(12);
        }
        return z;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (this.f41435d) {
            return false;
        }
        boolean z = true;
        this.f41435d = true;
        EditText editText = (EditText) view;
        if (this.f41434c.f41420f != 12) {
            Editable text = editText.getText();
            if (text == null) {
                z = false;
            } else if (i2 >= 7 && i2 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                a(12);
            } else {
                if (editText.getSelectionStart() == 0 && editText.length() == 2) {
                    editText.getText().clear();
                }
                z = false;
            }
        } else if (i2 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            a(10);
        } else {
            if (editText.getSelectionStart() == 0 && editText.length() == 2) {
                editText.getText().clear();
            }
            z = false;
        }
        this.f41435d = false;
        return z;
    }
}
