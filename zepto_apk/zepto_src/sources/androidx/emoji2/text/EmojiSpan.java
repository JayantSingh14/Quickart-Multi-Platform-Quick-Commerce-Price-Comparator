package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataItem;

@RequiresApi
/* loaded from: classes3.dex */
public abstract class EmojiSpan extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final TypefaceEmojiRasterizer f4330b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f4329a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public short f4331c = -1;

    /* renamed from: d, reason: collision with root package name */
    public float f4332d = 1.0f;

    public EmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.c(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.f4330b = typefaceEmojiRasterizer;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f4329a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.f4330b;
        this.f4332d = fAbs / (typefaceEmojiRasterizer.b().a(14) != 0 ? r8.f4386b.getShort(r1 + r8.f4385a) : (short) 0);
        MetadataItem metadataItemB = typefaceEmojiRasterizer.b();
        int iA = metadataItemB.a(14);
        if (iA != 0) {
            metadataItemB.f4386b.getShort(iA + metadataItemB.f4385a);
        }
        short s = (short) ((typefaceEmojiRasterizer.b().a(12) != 0 ? r5.f4386b.getShort(r7 + r5.f4385a) : (short) 0) * this.f4332d);
        this.f4331c = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
