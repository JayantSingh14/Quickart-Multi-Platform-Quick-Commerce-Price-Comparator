package androidx.activity;

import android.media.session.MediaSessionManager;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class j {
    public static /* synthetic */ PrecomputedText.Params.Builder h(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ PrecomputedText j(Object obj) {
        return (PrecomputedText) obj;
    }

    public static /* synthetic */ void r(int i2, int i3, String str) {
        new MediaSessionManager.RemoteUserInfo(str, i2, i3);
    }

    public static /* bridge */ /* synthetic */ boolean w(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }

    public static /* bridge */ /* synthetic */ boolean x(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
