package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class DoubleTapReloadRecognizer {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18842a;

    @Metadata
    public static final class Companion {
    }

    public final boolean a(int i2, View view) {
        if (i2 == 46 && !(view instanceof EditText)) {
            if (this.f18842a) {
                this.f18842a = false;
                return true;
            }
            this.f18842a = true;
            new Handler(Looper.getMainLooper()).postDelayed(new m(this, 4), 200L);
        }
        return false;
    }
}
