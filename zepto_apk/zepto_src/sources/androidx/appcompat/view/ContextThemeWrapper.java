package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f469f;

    /* renamed from: a, reason: collision with root package name */
    public int f470a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f471b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f472c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f473d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f474e;

    public ContextThemeWrapper() {
        super(null);
    }

    public final void a(Configuration configuration) {
        if (this.f474e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f473d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f473d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f471b == null) {
            this.f471b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f471b.setTo(theme);
            }
        }
        this.f471b.applyStyle(this.f470a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f474e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f473d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = androidx.appcompat.view.ContextThemeWrapper.f469f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            androidx.appcompat.view.ContextThemeWrapper.f469f = r1
        L1c:
            android.content.res.Configuration r1 = androidx.appcompat.view.ContextThemeWrapper.f469f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f473d
            android.content.Context r0 = r3.createConfigurationContext(r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f474e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f474e = r0
        L38:
            android.content.res.Resources r0 = r3.f474e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.ContextThemeWrapper.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f472c == null) {
            this.f472c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f472c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f471b;
        if (theme != null) {
            return theme;
        }
        if (this.f470a == 0) {
            this.f470a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f471b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i2) {
        if (this.f470a != i2) {
            this.f470a = i2;
            b();
        }
    }

    public ContextThemeWrapper(Context context, int i2) {
        super(context);
        this.f470a = i2;
    }
}
