package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;

@RequiresApi
/* loaded from: classes3.dex */
class CardViewApi21Impl implements CardViewImpl {
    public final void a(CardViewDelegate cardViewDelegate, float f2) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((CardView.AnonymousClass1) cardViewDelegate).f1374a;
        CardView cardView = CardView.this;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (f2 != roundRectDrawable.f1380e || roundRectDrawable.f1381f != useCompatPadding || roundRectDrawable.f1382g != preventCornerOverlap) {
            roundRectDrawable.f1380e = f2;
            roundRectDrawable.f1381f = useCompatPadding;
            roundRectDrawable.f1382g = preventCornerOverlap;
            roundRectDrawable.b(null);
            roundRectDrawable.invalidateSelf();
        }
        b(cardViewDelegate);
    }

    public final void b(CardViewDelegate cardViewDelegate) {
        if (!CardView.this.getUseCompatPadding()) {
            ((CardView.AnonymousClass1) cardViewDelegate).a(0, 0, 0, 0);
            return;
        }
        CardView.AnonymousClass1 anonymousClass1 = (CardView.AnonymousClass1) cardViewDelegate;
        Drawable drawable = anonymousClass1.f1374a;
        float f2 = ((RoundRectDrawable) drawable).f1380e;
        float f3 = ((RoundRectDrawable) drawable).f1376a;
        CardView cardView = CardView.this;
        int iCeil = (int) Math.ceil(RoundRectDrawableWithShadow.a(f2, f3, cardView.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(RoundRectDrawableWithShadow.b(f2, f3, cardView.getPreventCornerOverlap()));
        anonymousClass1.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
