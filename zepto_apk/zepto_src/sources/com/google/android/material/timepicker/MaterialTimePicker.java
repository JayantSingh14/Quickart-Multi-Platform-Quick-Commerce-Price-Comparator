package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public TimePickerView A0;
    public ViewStub B0;
    public TimePickerClockPresenter C0;
    public TimePickerTextInputPresenter D0;
    public Object E0;
    public int F0;
    public int G0;
    public CharSequence I0;
    public CharSequence K0;
    public CharSequence M0;
    public MaterialButton N0;
    public Button O0;
    public TimeModel Q0;
    public final LinkedHashSet Q = new LinkedHashSet();
    public final LinkedHashSet X = new LinkedHashSet();
    public final LinkedHashSet Y = new LinkedHashSet();
    public final LinkedHashSet Z = new LinkedHashSet();
    public int H0 = 0;
    public int J0 = 0;
    public int L0 = 0;
    public int P0 = 0;
    public int R0 = 0;

    public static final class Builder {
        public Builder() {
            new TimeModel();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.Y.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.Q0 = timeModel;
        if (timeModel == null) {
            this.Q0 = new TimeModel();
        }
        this.P0 = bundle.getInt("TIME_PICKER_INPUT_MODE", this.Q0.f41417c != 1 ? 0 : 1);
        this.H0 = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.I0 = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.J0 = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.K0 = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.L0 = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.M0 = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.R0 = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        int i2 = this.R0;
        if (i2 == 0) {
            TypedValue typedValueA = MaterialAttributes.a(R.attr.materialTimePickerTheme, requireContext());
            i2 = typedValueA == null ? 0 : typedValueA.data;
        }
        Dialog dialog = new Dialog(contextRequireContext, i2);
        Context context = dialog.getContext();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.G0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.F0 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialTimePicker_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        materialShapeDrawable.k(context);
        materialShapeDrawable.m(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.l(ViewCompat.j(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.A0 = timePickerView;
        timePickerView.y = this;
        this.B0 = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.N0 = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        int i2 = this.H0;
        if (i2 != 0) {
            textView.setText(i2);
        } else if (!TextUtils.isEmpty(this.I0)) {
            textView.setText(this.I0);
        }
        z(this.N0);
        Button button = (Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                Iterator it = materialTimePicker.Q.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                materialTimePicker.dismiss();
            }
        });
        int i3 = this.J0;
        if (i3 != 0) {
            button.setText(i3);
        } else if (!TextUtils.isEmpty(this.K0)) {
            button.setText(this.K0);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button);
        this.O0 = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                Iterator it = materialTimePicker.X.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                materialTimePicker.dismiss();
            }
        });
        int i4 = this.L0;
        if (i4 != 0) {
            this.O0.setText(i4);
        } else if (!TextUtils.isEmpty(this.M0)) {
            this.O0.setText(this.M0);
        }
        Button button3 = this.O0;
        if (button3 != null) {
            button3.setVisibility(isCancelable() ? 0 : 8);
        }
        this.N0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.timepicker.MaterialTimePicker.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.P0 = materialTimePicker.P0 == 0 ? 1 : 0;
                materialTimePicker.z(materialTimePicker.N0);
            }
        });
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.E0 = null;
        this.C0 = null;
        this.D0 = null;
        TimePickerView timePickerView = this.A0;
        if (timePickerView != null) {
            timePickerView.y = null;
            this.A0 = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.Z.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.Q0);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.P0);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.H0);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.I0);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.J0);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.K0);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.L0);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.M0);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.R0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.E0 instanceof TimePickerTextInputPresenter) {
            view.postDelayed(new b(this, 0), 100L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        Button button = this.O0;
        if (button != null) {
            button.setVisibility(isCancelable() ? 0 : 8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.google.android.material.timepicker.TimePickerPresenter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.timepicker.TimePickerPresenter, java.lang.Object] */
    public final void z(MaterialButton materialButton) {
        TimePickerTextInputPresenter timePickerTextInputPresenter;
        Pair pair;
        if (materialButton == null || this.A0 == null || this.B0 == null) {
            return;
        }
        ?? r0 = this.E0;
        if (r0 != 0) {
            r0.c();
        }
        int i2 = this.P0;
        TimePickerView timePickerView = this.A0;
        ViewStub viewStub = this.B0;
        if (i2 == 0) {
            TimePickerClockPresenter timePickerClockPresenter = this.C0;
            TimePickerClockPresenter timePickerClockPresenter2 = timePickerClockPresenter;
            if (timePickerClockPresenter == null) {
                timePickerClockPresenter2 = new TimePickerClockPresenter(timePickerView, this.Q0);
            }
            this.C0 = timePickerClockPresenter2;
            timePickerTextInputPresenter = timePickerClockPresenter2;
        } else {
            if (this.D0 == null) {
                this.D0 = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.Q0);
            }
            TimePickerTextInputPresenter timePickerTextInputPresenter2 = this.D0;
            timePickerTextInputPresenter2.f41440e.setChecked(false);
            timePickerTextInputPresenter2.f41441f.setChecked(false);
            timePickerTextInputPresenter = this.D0;
        }
        this.E0 = timePickerTextInputPresenter;
        timePickerTextInputPresenter.a();
        this.E0.invalidate();
        int i3 = this.P0;
        if (i3 == 0) {
            pair = new Pair(Integer.valueOf(this.F0), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        } else {
            if (i3 != 1) {
                throw new IllegalArgumentException(android.support.v4.media.b.f(i3, "no icon for mode: "));
            }
            pair = new Pair(Integer.valueOf(this.G0), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        materialButton.setIconResource(((Integer) pair.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pair.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }
}
