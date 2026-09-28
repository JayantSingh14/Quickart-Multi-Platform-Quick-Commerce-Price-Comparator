package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@AnyThread
@RestrictTo
/* loaded from: classes.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f4291b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f4292a;

    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.f4292a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
