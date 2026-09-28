package com.facebook.react.modules.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.R;
import com.facebook.react.modules.dialog.DialogModule;

@Nullsafe
/* loaded from: classes3.dex */
public class AlertFragment extends DialogFragment implements DialogInterface.OnClickListener {
    public final DialogModule.AlertFragmentListener Q;

    public AlertFragment() {
        this.Q = null;
    }

    public static View z(FragmentActivity fragmentActivity, String str) {
        View viewInflate = LayoutInflater.from(fragmentActivity).inflate(R.layout.alert_title_layout, (ViewGroup) null);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.alert_title);
        Assertions.c(textView);
        textView.setText(str);
        textView.setFocusable(true);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setAccessibilityHeading(true);
            return viewInflate;
        }
        ViewCompat.z(textView, new AccessibilityDelegateCompat() { // from class: com.facebook.react.modules.dialog.AlertFragment.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(textView, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.r(true);
            }
        });
        return viewInflate;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        DialogModule.AlertFragmentListener alertFragmentListener = this.Q;
        if (alertFragmentListener != null) {
            alertFragmentListener.onClick(dialogInterface, i2);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Bundle bundleRequireArguments = requireArguments();
        TypedArray typedArrayObtainStyledAttributes = fragmentActivityRequireActivity.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar);
        typedArrayObtainStyledAttributes.recycle();
        if (!zHasValue) {
            AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivityRequireActivity);
            if (bundleRequireArguments.containsKey("title")) {
                String string = bundleRequireArguments.getString("title");
                Assertions.c(string);
                builder.setCustomTitle(z(fragmentActivityRequireActivity, string));
            }
            if (bundleRequireArguments.containsKey("button_positive")) {
                builder.setPositiveButton(bundleRequireArguments.getString("button_positive"), this);
            }
            if (bundleRequireArguments.containsKey("button_negative")) {
                builder.setNegativeButton(bundleRequireArguments.getString("button_negative"), this);
            }
            if (bundleRequireArguments.containsKey("button_neutral")) {
                builder.setNeutralButton(bundleRequireArguments.getString("button_neutral"), this);
            }
            if (bundleRequireArguments.containsKey(APayConstants.Error.MESSAGE)) {
                builder.setMessage(bundleRequireArguments.getString(APayConstants.Error.MESSAGE));
            }
            if (bundleRequireArguments.containsKey("items")) {
                builder.setItems(bundleRequireArguments.getCharSequenceArray("items"), this);
            }
            return builder.create();
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(fragmentActivityRequireActivity);
        boolean zContainsKey = bundleRequireArguments.containsKey("title");
        AlertController.AlertParams alertParams = builder2.f282a;
        if (zContainsKey) {
            String string2 = bundleRequireArguments.getString("title");
            Assertions.c(string2);
            alertParams.f262e = z(fragmentActivityRequireActivity, string2);
        }
        if (bundleRequireArguments.containsKey("button_positive")) {
            builder2.d(bundleRequireArguments.getString("button_positive"), this);
        }
        if (bundleRequireArguments.containsKey("button_negative")) {
            builder2.c(bundleRequireArguments.getString("button_negative"), this);
        }
        if (bundleRequireArguments.containsKey("button_neutral")) {
            alertParams.f268k = bundleRequireArguments.getString("button_neutral");
            alertParams.f269l = this;
        }
        if (bundleRequireArguments.containsKey(APayConstants.Error.MESSAGE)) {
            alertParams.f263f = bundleRequireArguments.getString(APayConstants.Error.MESSAGE);
        }
        if (bundleRequireArguments.containsKey("items")) {
            alertParams.n = bundleRequireArguments.getCharSequenceArray("items");
            alertParams.p = this;
        }
        return builder2.create();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogModule.AlertFragmentListener alertFragmentListener = this.Q;
        if (alertFragmentListener != null) {
            alertFragmentListener.onDismiss(dialogInterface);
        }
    }

    public AlertFragment(DialogModule.AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.Q = alertFragmentListener;
        setArguments(bundle);
    }
}
