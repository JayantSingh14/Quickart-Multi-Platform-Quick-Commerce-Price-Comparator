package com.truecaller.android.sdk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
@JvmName
/* loaded from: classes4.dex */
public final class SdkUtils {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference f47190a;

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f47191b = Pattern.compile("^[0-9]+$");

    public static final void a(FragmentActivity activity) {
        WeakReference weakReference;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(activity, "activity");
        View viewFindViewById = activity.findViewById(R.id.textDisclaimerContainer);
        if (viewFindViewById == null || (weakReference = f47190a) == null || (viewGroup = (ViewGroup) weakReference.get()) == null) {
            return;
        }
        viewGroup.removeView(viewFindViewById);
    }

    public static final String b(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SharedPreferences sharedPreferences = activity.getSharedPreferences("com.truecaller.sdk.sharedPreference.VerificationClient", 0);
        String string = sharedPreferences.getString("verification_guid", null);
        if (string != null && string.length() != 0) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferences.edit().putString("verification_guid", string2).apply();
        return string2;
    }

    public static final void c(final FragmentActivity fragmentActivity) {
        Window window;
        ViewGroup viewGroup;
        if (fragmentActivity == null || (window = fragmentActivity.getWindow()) == null) {
            return;
        }
        WeakReference weakReference = new WeakReference(window.getDecorView().findViewById(android.R.id.content));
        f47190a = weakReference;
        ViewGroup viewGroup2 = (ViewGroup) weakReference.get();
        if ((viewGroup2 != null ? viewGroup2.findViewById(R.id.textDisclaimerContainer) : null) == null) {
            LayoutInflater layoutInflater = fragmentActivity.getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
            View viewInflate = layoutInflater.inflate(R.layout.truesdk_privacy_policy_dialog, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.textDisclaimer);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.buttonDismiss);
            String string = fragmentActivity.getString(R.string.sdk_disclaimer_text);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int iX = StringsKt.x(string, "*", 0, false, 6);
            int iC = StringsKt.C(string, "*", 0, 6);
            SpannableString spannableString = new SpannableString(StringsKt.K(string, "*", ""));
            spannableString.setSpan(new StyleSpan(1), iX, iC - 1, 0);
            textView.setText(spannableString);
            final int i2 = 0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.truecaller.android.sdk.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentActivity fragmentActivity2 = fragmentActivity;
                    switch (i2) {
                        case 0:
                            SdkUtils.a(fragmentActivity2);
                            break;
                        default:
                            WeakReference weakReference2 = SdkUtils.f47190a;
                            fragmentActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(fragmentActivity2.getString(R.string.sdk_disclaimer_url))));
                            break;
                    }
                }
            });
            final int i3 = 1;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.truecaller.android.sdk.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentActivity fragmentActivity2 = fragmentActivity;
                    switch (i3) {
                        case 0:
                            SdkUtils.a(fragmentActivity2);
                            break;
                        default:
                            WeakReference weakReference2 = SdkUtils.f47190a;
                            fragmentActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(fragmentActivity2.getString(R.string.sdk_disclaimer_url))));
                            break;
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            viewInflate.setLayoutParams(layoutParams);
            WeakReference weakReference2 = f47190a;
            if (weakReference2 == null || (viewGroup = (ViewGroup) weakReference2.get()) == null) {
                return;
            }
            viewGroup.addView(viewInflate);
        }
    }
}
