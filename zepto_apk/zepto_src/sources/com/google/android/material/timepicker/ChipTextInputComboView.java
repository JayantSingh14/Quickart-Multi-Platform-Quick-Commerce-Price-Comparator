package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.d;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f41388f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Chip f41389a;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f41390b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f41391c;

    /* renamed from: d, reason: collision with root package name */
    public final TextWatcher f41392d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f41393e;

    public class TextFormatter extends TextWatcherAdapter {
        public TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            boolean zIsEmpty = TextUtils.isEmpty(editable);
            ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
            Chip chip = chipTextInputComboView.f41389a;
            if (zIsEmpty) {
                chip.setText(TimeModel.a(chipTextInputComboView.getResources(), "00", "%02d"));
                return;
            }
            int i2 = ChipTextInputComboView.f41388f;
            String strA = TimeModel.a(chipTextInputComboView.getResources(), editable, "%02d");
            if (TextUtils.isEmpty(strA)) {
                strA = TimeModel.a(chipTextInputComboView.getResources(), "00", "%02d");
            }
            chip.setText(strA);
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f41389a.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f41391c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        Chip chip = this.f41389a;
        chip.setChecked(z);
        int i2 = z ? 0 : 4;
        EditText editText = this.f41391c;
        editText.setVisibility(i2);
        chip.setVisibility(z ? 8 : 0);
        if (chip.isChecked()) {
            editText.requestFocus();
            editText.post(new d(2, editText));
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f41389a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i2, Object obj) {
        this.f41389a.setTag(i2, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f41389a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f41389a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.f41390b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f41391c = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.f41392d = textFormatter;
        editText.addTextChangedListener(textFormatter);
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R.id.material_label);
        this.f41393e = textView;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        editText.setId(View.generateViewId());
        textView.setLabelFor(editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
