package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: classes3.dex */
public final class CustomTabColorSchemeParams {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f1302a;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Integer f1303a;
    }

    public CustomTabColorSchemeParams(Integer num) {
        this.f1302a = num;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1302a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        return bundle;
    }
}
