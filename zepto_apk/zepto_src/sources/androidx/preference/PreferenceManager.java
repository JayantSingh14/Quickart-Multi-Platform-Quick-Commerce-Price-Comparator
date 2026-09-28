package androidx.preference;

import android.content.Context;

/* loaded from: classes3.dex */
public class PreferenceManager {

    /* renamed from: a, reason: collision with root package name */
    public Object f11127a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11128b;

    /* renamed from: c, reason: collision with root package name */
    public Object f11129c;

    public interface OnDisplayPreferenceDialogListener {
    }

    public interface OnNavigateToScreenListener {
    }

    public interface OnPreferenceTreeClickListener {
    }

    public static abstract class PreferenceComparisonCallback {
    }

    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
    }

    public PreferenceManager(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append("_preferences");
    }
}
