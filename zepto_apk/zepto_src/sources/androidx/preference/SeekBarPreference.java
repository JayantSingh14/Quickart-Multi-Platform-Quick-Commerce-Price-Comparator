package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes3.dex */
public class SeekBarPreference extends Preference {
    public int A;
    public final int B;
    public final int C;
    public int D;
    public boolean E;
    public SeekBar F;
    public TextView G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final SeekBar.OnSeekBarChangeListener K;
    public final View.OnKeyListener L;

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final int f11136a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11137b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11138c;

        /* renamed from: androidx.preference.SeekBarPreference$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f11136a = parcel.readInt();
            this.f11137b = parcel.readInt();
            this.f11138c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f11136a);
            parcel.writeInt(this.f11137b);
            parcel.writeInt(this.f11138c);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0);
        this.K = new SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (z && (seekBarPreference.J || !seekBarPreference.E)) {
                    seekBarPreference.r(seekBar);
                    return;
                }
                int i4 = i3 + seekBarPreference.B;
                TextView textView = seekBarPreference.G;
                if (textView != null) {
                    textView.setText(String.valueOf(i4));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.E = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                seekBarPreference.E = false;
                if (seekBar.getProgress() + seekBarPreference.B != seekBarPreference.A) {
                    seekBarPreference.r(seekBar);
                }
            }
        };
        this.L = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.H && (i3 == 21 || i3 == 22)) || i3 == 23 || i3 == 66) {
                    return false;
                }
                SeekBar seekBar = seekBarPreference.F;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i3, keyEvent);
                }
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i2, 0);
        this.B = typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100);
        int i4 = this.B;
        i3 = i3 < i4 ? i4 : i3;
        if (i3 != this.C) {
            this.C = i3;
            d();
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0);
        if (i5 != this.D) {
            this.D = Math.min(this.C - this.B, Math.abs(i5));
            d();
        }
        this.H = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.I = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.J = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void g(PreferenceViewHolder preferenceViewHolder) {
        super.g(preferenceViewHolder);
        preferenceViewHolder.f11653a.setOnKeyListener(this.L);
        this.F = (SeekBar) preferenceViewHolder.q(R.id.seekbar);
        TextView textView = (TextView) preferenceViewHolder.q(R.id.seekbar_value);
        this.G = textView;
        if (this.I) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.G = null;
        }
        SeekBar seekBar = this.F;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.K);
        this.F.setMax(this.C - this.B);
        int i2 = this.D;
        if (i2 != 0) {
            this.F.setKeyProgressIncrement(i2);
        } else {
            this.D = this.F.getKeyProgressIncrement();
        }
        this.F.setProgress(this.A - this.B);
        int i3 = this.A;
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i3));
        }
        this.F.setEnabled(c());
    }

    @Override // androidx.preference.Preference
    public final Object i(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    public final void r(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.B;
        int i2 = this.A;
        if (progress != i2) {
            int i3 = this.B;
            if (progress < i3) {
                progress = i3;
            }
            int i4 = this.C;
            if (progress > i4) {
                progress = i4;
            }
            if (progress != i2) {
                this.A = progress;
                TextView textView = this.G;
                if (textView != null) {
                    textView.setText(String.valueOf(progress));
                }
            }
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }
}
