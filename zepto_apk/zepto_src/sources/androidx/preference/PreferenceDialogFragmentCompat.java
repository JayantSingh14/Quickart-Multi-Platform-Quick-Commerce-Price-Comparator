package androidx.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.DialogPreference;

/* loaded from: classes3.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {
    public CharSequence A0;
    public int B0;
    public BitmapDrawable C0;
    public int D0;
    public DialogPreference Q;
    public CharSequence X;
    public CharSequence Y;
    public CharSequence Z;

    public void A(View view) {
        int i2;
        View viewFindViewById = view.findViewById(android.R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.A0;
            if (TextUtils.isEmpty(charSequence)) {
                i2 = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (viewFindViewById.getVisibility() != i2) {
                viewFindViewById.setVisibility(i2);
            }
        }
    }

    public abstract void B(boolean z);

    public void C(AlertDialog.Builder builder) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.D0 = i2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResultCaller targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.TargetFragment)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.TargetFragment targetFragment2 = (DialogPreference.TargetFragment) targetFragment;
        getArguments().getString("key");
        if (bundle == null) {
            targetFragment2.s();
            this.Q = null;
            throw null;
        }
        this.X = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.Y = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.Z = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.A0 = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.B0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
        Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.C0 = new BitmapDrawable(getResources(), bitmap);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.D0 = -2;
        AlertDialog.Builder builderC = new AlertDialog.Builder(activity).setTitle(this.X).a(this.C0).d(this.Y, this).c(this.Z, this);
        int i2 = this.B0;
        View viewInflate = i2 != 0 ? getLayoutInflater().inflate(i2, (ViewGroup) null) : null;
        if (viewInflate != null) {
            A(viewInflate);
            builderC.setView(viewInflate);
        } else {
            builderC.b(this.A0);
        }
        C(builderC);
        AlertDialog alertDialogCreate = builderC.create();
        if (this instanceof EditTextPreferenceDialogFragmentCompat) {
            alertDialogCreate.getWindow().setSoftInputMode(5);
        }
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        B(this.D0 == -1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.X);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.Y);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.Z);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.A0);
        bundle.putInt("PreferenceDialogFragment.layout", this.B0);
        BitmapDrawable bitmapDrawable = this.C0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public final DialogPreference z() {
        if (this.Q == null) {
            getArguments().getString("key");
            ((DialogPreference.TargetFragment) getTargetFragment()).s();
            this.Q = null;
        }
        return this.Q;
    }
}
