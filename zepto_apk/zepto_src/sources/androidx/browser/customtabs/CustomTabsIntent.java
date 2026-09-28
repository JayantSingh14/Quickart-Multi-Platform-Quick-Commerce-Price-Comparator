package androidx.browser.customtabs;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.support.customtabs.ICustomTabsCallback;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class CustomTabsIntent {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f1341a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f1342b;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ActivityHeightResizeBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ActivitySideSheetDecorationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ActivitySideSheetPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ActivitySideSheetRoundedCornersPosition {
    }

    @RequiresApi
    public static class Api21Impl {
        @Nullable
        @DoNotInline
        public static Locale a(Intent intent) {
            String stringExtra = intent.getStringExtra("androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG");
            if (stringExtra != null) {
                return Locale.forLanguageTag(stringExtra);
            }
            return null;
        }

        @DoNotInline
        public static void b(Intent intent, Locale locale) {
            intent.putExtra("androidx.browser.customtabs.extra.TRANSLATE_LANGUAGE_TAG", locale.toLanguageTag());
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @Nullable
        @DoNotInline
        public static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        public static void a(ActivityOptions activityOptions, boolean z) {
            activityOptions.setShareIdentityEnabled(z);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface CloseButtonPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ColorScheme {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ShareState {
    }

    public CustomTabsIntent(Intent intent, Bundle bundle) {
        this.f1341a = intent;
        this.f1342b = bundle;
    }

    public final void a(Context context, Uri uri) {
        Intent intent = this.f1341a;
        intent.setData(uri);
        context.startActivity(intent, this.f1342b);
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f1343a;

        /* renamed from: b, reason: collision with root package name */
        public final CustomTabColorSchemeParams.Builder f1344b;

        /* renamed from: c, reason: collision with root package name */
        public ActivityOptions f1345c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f1346d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f1347e;

        public Builder() {
            this.f1343a = new Intent("android.intent.action.VIEW");
            this.f1344b = new CustomTabColorSchemeParams.Builder();
            this.f1347e = true;
        }

        public final CustomTabsIntent a() {
            Intent intent = this.f1343a;
            if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                intent.putExtras(bundle);
            }
            intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1347e);
            intent.putExtras(new CustomTabColorSchemeParams(this.f1344b.f1303a).a());
            Bundle bundle2 = this.f1346d;
            if (bundle2 != null) {
                intent.putExtras(bundle2);
            }
            intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
            int i2 = Build.VERSION.SDK_INT;
            String strA = Api24Impl.a();
            if (!TextUtils.isEmpty(strA)) {
                Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
                if (!bundleExtra.containsKey("Accept-Language")) {
                    bundleExtra.putString("Accept-Language", strA);
                    intent.putExtra("com.android.browser.headers", bundleExtra);
                }
            }
            if (i2 >= 34) {
                if (this.f1345c == null) {
                    this.f1345c = Api23Impl.a();
                }
                Api34Impl.a(this.f1345c, false);
            }
            ActivityOptions activityOptions = this.f1345c;
            return new CustomTabsIntent(intent, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public Builder(CustomTabsSession customTabsSession) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f1343a = intent;
            this.f1344b = new CustomTabColorSchemeParams.Builder();
            this.f1347e = true;
            if (customTabsSession != null) {
                intent.setPackage(customTabsSession.f1355d.getPackageName());
                ICustomTabsCallback.Stub stub = (ICustomTabsCallback.Stub) customTabsSession.f1354c;
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", stub);
                intent.putExtras(bundle);
            }
        }
    }
}
