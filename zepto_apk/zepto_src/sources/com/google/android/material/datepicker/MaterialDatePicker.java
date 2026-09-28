package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    public int A0;
    public DateSelector B0;
    public PickerFragment C0;
    public CalendarConstraints D0;
    public DayViewDecorator E0;
    public MaterialCalendar F0;
    public int G0;
    public CharSequence H0;
    public boolean I0;
    public int J0;
    public int K0;
    public CharSequence L0;
    public int M0;
    public CharSequence N0;
    public int O0;
    public CharSequence P0;
    public int Q0;
    public CharSequence R0;
    public TextView S0;
    public TextView T0;
    public CheckableImageButton U0;
    public MaterialShapeDrawable V0;
    public Button W0;
    public boolean X0;
    public CharSequence Y0;
    public CharSequence Z0;
    public final LinkedHashSet Q = new LinkedHashSet();
    public final LinkedHashSet X = new LinkedHashSet();
    public final LinkedHashSet Y = new LinkedHashSet();
    public final LinkedHashSet Z = new LinkedHashSet();

    public static final class Builder<S> {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface InputMode {
    }

    public static int A(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month month = new Month(UtcDates.f());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int i2 = month.f40347d;
        return android.support.v4.media.a.c(i2, 1, dimensionPixelOffset2, (dimensionPixelSize * i2) + (dimensionPixelOffset * 2));
    }

    public static boolean B(int i2, Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.c(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()).data, new int[]{i2});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.fragment.app.Fragment, com.google.android.material.datepicker.MaterialTextInputPicker] */
    public final void C() {
        Context contextRequireContext = requireContext();
        int iW1 = this.A0;
        if (iW1 == 0) {
            iW1 = z().w1(contextRequireContext);
        }
        DateSelector dateSelectorZ = z();
        CalendarConstraints calendarConstraints = this.D0;
        DayViewDecorator dayViewDecorator = this.E0;
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", iW1);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelectorZ);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.f40278d);
        materialCalendar.setArguments(bundle);
        this.F0 = materialCalendar;
        if (this.J0 == 1) {
            DateSelector dateSelectorZ2 = z();
            CalendarConstraints calendarConstraints2 = this.D0;
            ?? materialTextInputPicker = new MaterialTextInputPicker();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", iW1);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelectorZ2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            materialTextInputPicker.setArguments(bundle2);
            materialCalendar = materialTextInputPicker;
        }
        this.C0 = materialCalendar;
        this.S0.setText((this.J0 == 1 && getResources().getConfiguration().orientation == 2) ? this.Z0 : this.Y0);
        String strY3 = z().y3(getContext());
        this.T0.setContentDescription(z().j1(requireContext()));
        this.T0.setText(strY3);
        FragmentTransaction fragmentTransactionD = getChildFragmentManager().d();
        fragmentTransactionD.j(this.C0, R.id.mtrl_calendar_frame);
        fragmentTransactionD.e();
        this.C0.y(new OnSelectionChangedListener<Object>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public final void a() {
                MaterialDatePicker.this.W0.setEnabled(false);
            }

            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public final void b(Object obj) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                String strY32 = materialDatePicker.z().y3(materialDatePicker.getContext());
                materialDatePicker.T0.setContentDescription(materialDatePicker.z().j1(materialDatePicker.requireContext()));
                materialDatePicker.T0.setText(strY32);
                materialDatePicker.W0.setEnabled(materialDatePicker.z().y5());
            }
        });
    }

    public final void D(CheckableImageButton checkableImageButton) {
        this.U0.setContentDescription(this.J0 == 1 ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.Y.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.A0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.B0 = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.D0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.E0 = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.G0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.H0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.J0 = bundle.getInt("INPUT_MODE_KEY");
        this.K0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.L0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.M0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.N0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.O0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.P0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.Q0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.R0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.H0;
        if (text == null) {
            text = requireContext().getResources().getText(this.G0);
        }
        this.Y0 = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), StringUtils.LF);
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.Z0 = text;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int iW1 = this.A0;
        if (iW1 == 0) {
            iW1 = z().w1(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, iW1);
        Context context = dialog.getContext();
        this.I0 = B(android.R.attr.windowFullscreen, context);
        this.V0 = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialCalendar, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.V0.k(context);
        this.V0.m(ColorStateList.valueOf(color));
        this.V0.l(ViewCompat.j(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.I0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.I0) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(A(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(A(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.T0 = textView;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        textView.setAccessibilityLiveRegion(1);
        this.U0 = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.S0 = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.U0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.U0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.b(R.drawable.material_ic_calendar_black_24dp, context));
        stateListDrawable.addState(new int[0], AppCompatResources.b(R.drawable.material_ic_edit_black_24dp, context));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.U0.setChecked(this.J0 != 0);
        ViewCompat.z(this.U0, null);
        D(this.U0);
        this.U0.setOnClickListener(new d(this, 0));
        this.W0 = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (z().y5()) {
            this.W0.setEnabled(true);
        } else {
            this.W0.setEnabled(false);
        }
        this.W0.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.L0;
        if (charSequence != null) {
            this.W0.setText(charSequence);
        } else {
            int i2 = this.K0;
            if (i2 != 0) {
                this.W0.setText(i2);
            }
        }
        CharSequence charSequence2 = this.N0;
        if (charSequence2 != null) {
            this.W0.setContentDescription(charSequence2);
        } else if (this.M0 != 0) {
            this.W0.setContentDescription(getContext().getResources().getText(this.M0));
        }
        this.W0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                Iterator it = materialDatePicker.Q.iterator();
                while (it.hasNext()) {
                    MaterialPickerOnPositiveButtonClickListener materialPickerOnPositiveButtonClickListener = (MaterialPickerOnPositiveButtonClickListener) it.next();
                    materialDatePicker.z().getClass();
                    materialPickerOnPositiveButtonClickListener.a();
                }
                materialDatePicker.dismiss();
            }
        });
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.P0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i3 = this.O0;
            if (i3 != 0) {
                button.setText(i3);
            }
        }
        CharSequence charSequence4 = this.R0;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.Q0 != 0) {
            button.setContentDescription(getContext().getResources().getText(this.Q0));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                Iterator it = materialDatePicker.X.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                materialDatePicker.dismiss();
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.Z.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.A0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.B0);
        CalendarConstraints calendarConstraints = this.D0;
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder();
        int i2 = CalendarConstraints.Builder.f40282c;
        int i3 = CalendarConstraints.Builder.f40282c;
        builder.f40284b = new DateValidatorPointForward(Long.MIN_VALUE);
        long j2 = calendarConstraints.f40275a.f40349f;
        long j3 = calendarConstraints.f40276b.f40349f;
        builder.f40283a = Long.valueOf(calendarConstraints.f40278d.f40349f);
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.f40277c;
        builder.f40284b = dateValidator;
        MaterialCalendar materialCalendar = this.F0;
        Month month = materialCalendar == null ? null : materialCalendar.B0;
        if (month != null) {
            builder.f40283a = Long.valueOf(month.f40349f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month monthB = Month.b(j2);
        Month monthB2 = Month.b(j3);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l2 = builder.f40283a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthB, monthB2, dateValidator2, l2 != null ? Month.b(l2.longValue()) : null, calendarConstraints.f40279e));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.E0);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.G0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.H0);
        bundle.putInt("INPUT_MODE_KEY", this.J0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.K0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.L0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.M0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.N0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.O0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.P0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.Q0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.R0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() throws Resources.NotFoundException {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.I0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.V0);
            if (!this.X0) {
                final View viewFindViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListD = DrawableUtils.d(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListD != null ? Integer.valueOf(colorStateListD.getDefaultColor()) : null;
                int i2 = Build.VERSION.SDK_INT;
                boolean z = false;
                boolean z2 = numValueOf == null || numValueOf.intValue() == 0;
                int iC = MaterialColors.c(window.getContext(), android.R.attr.colorBackground, -16777216);
                if (z2) {
                    numValueOf = Integer.valueOf(iC);
                }
                WindowCompat.b(window, false);
                window.getContext();
                int iK = i2 < 27 ? ColorUtils.k(MaterialColors.c(window.getContext(), android.R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(iK);
                new WindowInsetsControllerCompat(window, window.getDecorView()).e(MaterialColors.f(0) || MaterialColors.f(numValueOf.intValue()));
                boolean zF = MaterialColors.f(iC);
                if (MaterialColors.f(iK) || (iK == 0 && zF)) {
                    z = true;
                }
                new WindowInsetsControllerCompat(window, window.getDecorView()).d(z);
                final int paddingTop = viewFindViewById.getPaddingTop();
                final int i3 = viewFindViewById.getLayoutParams().height;
                ViewCompat.H(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                        int i4 = windowInsetsCompat.d(519).f2809b;
                        View view2 = viewFindViewById;
                        int i5 = i3;
                        if (i5 >= 0) {
                            view2.getLayoutParams().height = i5 + i4;
                            view2.setLayoutParams(view2.getLayoutParams());
                        }
                        view2.setPadding(view2.getPaddingLeft(), paddingTop + i4, view2.getPaddingRight(), view2.getPaddingBottom());
                        return windowInsetsCompat;
                    }
                });
                this.X0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.V0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        C();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        this.C0.Q.clear();
        super.onStop();
    }

    public final DateSelector z() {
        if (this.B0 == null) {
            this.B0 = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.B0;
    }
}
