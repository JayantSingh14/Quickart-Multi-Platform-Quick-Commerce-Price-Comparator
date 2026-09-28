package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.activity.j;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public class PrecomputedTextCompat implements Spannable {

    @RequiresApi
    public static class Api28Impl {
    }

    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            @Override // java.util.concurrent.Callable
            public final PrecomputedTextCompat call() {
                throw null;
            }
        }
    }

    public final PrecomputedText a() {
        if (j.x(null)) {
            return j.j(null);
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i2, int i3, Class cls) {
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        ((PrecomputedText) null).getSpans(i2, i3, cls);
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i2, int i3, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        ((PrecomputedText) null).removeSpan(obj);
        throw null;
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT < 29) {
            throw null;
        }
        ((PrecomputedText) null).setSpan(obj, i2, i3, i4);
        throw null;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        throw null;
    }

    public static final class Params {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f2953a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f2954b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2955c;

        /* renamed from: d, reason: collision with root package name */
        public final int f2956d;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public final TextPaint f2957a;

            /* renamed from: c, reason: collision with root package name */
            public int f2959c = 1;

            /* renamed from: d, reason: collision with root package name */
            public int f2960d = 1;

            /* renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f2958b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public Builder(TextPaint textPaint) {
                this.f2957a = textPaint;
            }

            public final Params a() {
                return new Params(this.f2957a, this.f2958b, this.f2959c, this.f2960d);
            }

            public final void b(int i2) {
                this.f2959c = i2;
            }

            public final void c(int i2) {
                this.f2960d = i2;
            }

            public final void d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2958b = textDirectionHeuristic;
            }
        }

        public Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                j.h(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            }
            this.f2953a = textPaint;
            this.f2954b = textDirectionHeuristic;
            this.f2955c = i2;
            this.f2956d = i3;
        }

        public final boolean a(Params params) {
            if (this.f2955c != params.f2955c || this.f2956d != params.f2956d) {
                return false;
            }
            TextPaint textPaint = this.f2953a;
            if (textPaint.getTextSize() != params.f2953a.getTextSize()) {
                return false;
            }
            float textScaleX = textPaint.getTextScaleX();
            TextPaint textPaint2 = params.f2953a;
            if (textScaleX == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales())) {
                return textPaint.getTypeface() == null ? textPaint2.getTypeface() == null : textPaint.getTypeface().equals(textPaint2.getTypeface());
            }
            return false;
        }

        public final int b() {
            return this.f2955c;
        }

        public final int c() {
            return this.f2956d;
        }

        public final TextDirectionHeuristic d() {
            return this.f2954b;
        }

        public final TextPaint e() {
            return this.f2953a;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return a(params) && this.f2954b == params.f2954b;
        }

        public final int hashCode() {
            TextPaint textPaint = this.f2953a;
            return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f2954b, Integer.valueOf(this.f2955c), Integer.valueOf(this.f2956d));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder("textSize=");
            TextPaint textPaint = this.f2953a;
            sb2.append(textPaint.getTextSize());
            sb.append(sb2.toString());
            sb.append(", textScaleX=" + textPaint.getTextScaleX());
            sb.append(", textSkewX=" + textPaint.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
            sb.append(", textLocale=" + textPaint.getTextLocales());
            sb.append(", typeface=" + textPaint.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2954b);
            sb.append(", breakStrategy=" + this.f2955c);
            sb.append(", hyphenationFrequency=" + this.f2956d);
            sb.append("}");
            return sb.toString();
        }

        public Params(PrecomputedText.Params params) {
            this.f2953a = params.getTextPaint();
            this.f2954b = params.getTextDirection();
            this.f2955c = params.getBreakStrategy();
            this.f2956d = params.getHyphenationFrequency();
        }
    }
}
