package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.res.TypedArrayUtils;

/* loaded from: classes3.dex */
public class SwitchPreference extends TwoStatePreference {
    public final Listener F;
    public final String G;
    public final String H;

    public class Listener implements CompoundButton.OnCheckedChangeListener {
        public Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SwitchPreference switchPreference = SwitchPreference.this;
            switchPreference.getClass();
            switchPreference.r(z);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        this.F = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, i2, 0);
        int i3 = R.styleable.SwitchPreference_summaryOn;
        int i4 = R.styleable.SwitchPreference_android_summaryOn;
        String string = typedArrayObtainStyledAttributes.getString(i3);
        this.B = string == null ? typedArrayObtainStyledAttributes.getString(i4) : string;
        if (this.A) {
            d();
        }
        int i5 = R.styleable.SwitchPreference_summaryOff;
        int i6 = R.styleable.SwitchPreference_android_summaryOff;
        String string2 = typedArrayObtainStyledAttributes.getString(i5);
        this.C = string2 == null ? typedArrayObtainStyledAttributes.getString(i6) : string2;
        if (!this.A) {
            d();
        }
        int i7 = R.styleable.SwitchPreference_switchTextOn;
        int i8 = R.styleable.SwitchPreference_android_switchTextOn;
        String string3 = typedArrayObtainStyledAttributes.getString(i7);
        this.G = string3 == null ? typedArrayObtainStyledAttributes.getString(i8) : string3;
        d();
        int i9 = R.styleable.SwitchPreference_switchTextOff;
        int i10 = R.styleable.SwitchPreference_android_switchTextOff;
        String string4 = typedArrayObtainStyledAttributes.getString(i9);
        this.H = string4 == null ? typedArrayObtainStyledAttributes.getString(i10) : string4;
        d();
        this.E = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SwitchPreference_disableDependentsState, typedArrayObtainStyledAttributes.getBoolean(R.styleable.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void g(PreferenceViewHolder preferenceViewHolder) {
        super.g(preferenceViewHolder);
        t(preferenceViewHolder.q(android.R.id.switch_widget));
        s(preferenceViewHolder.q(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void n(View view) {
        super.n(view);
        if (((AccessibilityManager) this.f11080a.getSystemService("accessibility")).isEnabled()) {
            t(view.findViewById(android.R.id.switch_widget));
            s(view.findViewById(android.R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.A);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.G);
            r4.setTextOff(this.H);
            r4.setOnCheckedChangeListener(this.F);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle));
    }
}
