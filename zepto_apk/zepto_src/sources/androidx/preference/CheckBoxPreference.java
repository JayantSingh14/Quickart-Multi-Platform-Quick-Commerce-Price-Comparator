package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.content.res.TypedArrayUtils;

/* loaded from: classes3.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final Listener F;

    public class Listener implements CompoundButton.OnCheckedChangeListener {
        public Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CheckBoxPreference checkBoxPreference = CheckBoxPreference.this;
            checkBoxPreference.getClass();
            checkBoxPreference.r(z);
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        this.F = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckBoxPreference, i2, 0);
        int i3 = R.styleable.CheckBoxPreference_summaryOn;
        int i4 = R.styleable.CheckBoxPreference_android_summaryOn;
        String string = typedArrayObtainStyledAttributes.getString(i3);
        this.B = string == null ? typedArrayObtainStyledAttributes.getString(i4) : string;
        if (this.A) {
            d();
        }
        int i5 = R.styleable.CheckBoxPreference_summaryOff;
        int i6 = R.styleable.CheckBoxPreference_android_summaryOff;
        String string2 = typedArrayObtainStyledAttributes.getString(i5);
        this.C = string2 == null ? typedArrayObtainStyledAttributes.getString(i6) : string2;
        if (!this.A) {
            d();
        }
        this.E = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CheckBoxPreference_disableDependentsState, typedArrayObtainStyledAttributes.getBoolean(R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void g(PreferenceViewHolder preferenceViewHolder) {
        super.g(preferenceViewHolder);
        t(preferenceViewHolder.q(android.R.id.checkbox));
        s(preferenceViewHolder.q(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void n(View view) {
        super.n(view);
        if (((AccessibilityManager) this.f11080a.getSystemService("accessibility")).isEnabled()) {
            t(view.findViewById(android.R.id.checkbox));
            s(view.findViewById(android.R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.A);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.F);
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle));
    }
}
