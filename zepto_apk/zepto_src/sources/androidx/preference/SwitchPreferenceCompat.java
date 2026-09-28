package androidx.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes3.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final Listener F;
    public final String G;
    public final String H;

    public class Listener implements CompoundButton.OnCheckedChangeListener {
        public Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SwitchPreferenceCompat switchPreferenceCompat = SwitchPreferenceCompat.this;
            switchPreferenceCompat.getClass();
            switchPreferenceCompat.r(z);
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        this.F = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreferenceCompat, i2, 0);
        int i3 = R.styleable.SwitchPreferenceCompat_summaryOn;
        int i4 = R.styleable.SwitchPreferenceCompat_android_summaryOn;
        String string = typedArrayObtainStyledAttributes.getString(i3);
        this.B = string == null ? typedArrayObtainStyledAttributes.getString(i4) : string;
        if (this.A) {
            d();
        }
        int i5 = R.styleable.SwitchPreferenceCompat_summaryOff;
        int i6 = R.styleable.SwitchPreferenceCompat_android_summaryOff;
        String string2 = typedArrayObtainStyledAttributes.getString(i5);
        this.C = string2 == null ? typedArrayObtainStyledAttributes.getString(i6) : string2;
        if (!this.A) {
            d();
        }
        int i7 = R.styleable.SwitchPreferenceCompat_switchTextOn;
        int i8 = R.styleable.SwitchPreferenceCompat_android_switchTextOn;
        String string3 = typedArrayObtainStyledAttributes.getString(i7);
        this.G = string3 == null ? typedArrayObtainStyledAttributes.getString(i8) : string3;
        d();
        int i9 = R.styleable.SwitchPreferenceCompat_switchTextOff;
        int i10 = R.styleable.SwitchPreferenceCompat_android_switchTextOff;
        String string4 = typedArrayObtainStyledAttributes.getString(i9);
        this.H = string4 == null ? typedArrayObtainStyledAttributes.getString(i10) : string4;
        d();
        this.E = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SwitchPreferenceCompat_disableDependentsState, typedArrayObtainStyledAttributes.getBoolean(R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void g(PreferenceViewHolder preferenceViewHolder) throws Resources.NotFoundException {
        super.g(preferenceViewHolder);
        t(preferenceViewHolder.q(R.id.switchWidget));
        s(preferenceViewHolder.q(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void n(View view) throws Resources.NotFoundException {
        super.n(view);
        if (((AccessibilityManager) this.f11080a.getSystemService("accessibility")).isEnabled()) {
            t(view.findViewById(R.id.switchWidget));
            s(view.findViewById(android.R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(View view) throws Resources.NotFoundException {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.A);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.G);
            switchCompat.setTextOff(this.H);
            switchCompat.setOnCheckedChangeListener(this.F);
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }
}
