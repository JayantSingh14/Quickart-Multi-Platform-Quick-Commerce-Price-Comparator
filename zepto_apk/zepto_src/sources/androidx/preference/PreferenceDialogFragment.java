package androidx.preference;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.DialogPreference;

@Deprecated
/* loaded from: classes3.dex */
public abstract class PreferenceDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public DialogPreference f11095a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f11096b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f11097c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f11098d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f11099e;

    /* renamed from: f, reason: collision with root package name */
    public int f11100f;

    /* renamed from: g, reason: collision with root package name */
    public BitmapDrawable f11101g;

    /* renamed from: h, reason: collision with root package name */
    public int f11102h;

    @Deprecated
    public PreferenceDialogFragment() {
    }

    public final DialogPreference a() {
        if (this.f11095a == null) {
            getArguments().getString("key");
            ((DialogPreference.TargetFragment) getTargetFragment()).s();
            this.f11095a = null;
        }
        return this.f11095a;
    }

    public void b(View view) {
        int i2;
        View viewFindViewById = view.findViewById(android.R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f11099e;
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

    public abstract void c(boolean z);

    public void d(AlertDialog.Builder builder) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f11102h = i2;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentCallbacks2 targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.TargetFragment)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.TargetFragment targetFragment2 = (DialogPreference.TargetFragment) targetFragment;
        getArguments().getString("key");
        if (bundle == null) {
            targetFragment2.s();
            this.f11095a = null;
            throw null;
        }
        this.f11096b = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.f11097c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.f11098d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.f11099e = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.f11100f = bundle.getInt("PreferenceDialogFragment.layout", 0);
        Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.f11101g = new BitmapDrawable(getResources(), bitmap);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Activity activity = getActivity();
        this.f11102h = -2;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity).setTitle(this.f11096b).setIcon(this.f11101g).setPositiveButton(this.f11097c, this).setNegativeButton(this.f11098d, this);
        int i2 = this.f11100f;
        View viewInflate = i2 != 0 ? LayoutInflater.from(activity).inflate(i2, (ViewGroup) null) : null;
        if (viewInflate != null) {
            b(viewInflate);
            negativeButton.setView(viewInflate);
        } else {
            negativeButton.setMessage(this.f11099e);
        }
        d(negativeButton);
        AlertDialog alertDialogCreate = negativeButton.create();
        if (this instanceof EditTextPreferenceDialogFragment) {
            alertDialogCreate.getWindow().setSoftInputMode(5);
        }
        return alertDialogCreate;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        c(this.f11102h == -1);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f11096b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f11097c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f11098d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f11099e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f11100f);
        BitmapDrawable bitmapDrawable = this.f11101g;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
