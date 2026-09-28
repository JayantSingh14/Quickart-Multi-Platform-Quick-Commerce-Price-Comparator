package androidx.media3.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.LanguageFeatureSpan;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public List f10959a;

    /* renamed from: b, reason: collision with root package name */
    public CaptionStyleCompat f10960b;

    /* renamed from: c, reason: collision with root package name */
    public int f10961c;

    /* renamed from: d, reason: collision with root package name */
    public float f10962d;

    /* renamed from: e, reason: collision with root package name */
    public float f10963e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10964f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10965g;

    /* renamed from: h, reason: collision with root package name */
    public int f10966h;

    /* renamed from: i, reason: collision with root package name */
    public Output f10967i;

    /* renamed from: j, reason: collision with root package name */
    public View f10968j;

    public interface Output {
        void a(List list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10959a = Collections.EMPTY_LIST;
        this.f10960b = CaptionStyleCompat.f10829g;
        this.f10961c = 0;
        this.f10962d = 0.0533f;
        this.f10963e = 0.08f;
        this.f10964f = true;
        this.f10965g = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.f10967i = canvasSubtitleOutput;
        this.f10968j = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.f10966h = 1;
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f10964f && this.f10965g) {
            return this.f10959a;
        }
        ArrayList arrayList = new ArrayList(this.f10959a.size());
        for (int i2 = 0; i2 < this.f10959a.size(); i2++) {
            Cue.Builder builderA = ((Cue) this.f10959a.get(i2)).a();
            if (!this.f10964f) {
                builderA.n = false;
                CharSequence charSequence = builderA.f5625a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        builderA.f5625a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = builderA.f5625a;
                    charSequence2.getClass();
                    Spannable spannable = (Spannable) charSequence2;
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof LanguageFeatureSpan)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                SubtitleViewUtils.a(builderA);
            } else if (!this.f10965g) {
                SubtitleViewUtils.a(builderA);
            }
            arrayList.add(builderA.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        CaptioningManager captioningManager;
        boolean zIsInEditMode = isInEditMode();
        CaptionStyleCompat captionStyleCompat = CaptionStyleCompat.f10829g;
        if (zIsInEditMode || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return captionStyleCompat;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (Util.f5744a >= 21) {
            return new CaptionStyleCompat(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : -16777216, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
        }
        return new CaptionStyleCompat(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
    }

    private <T extends View & Output> void setView(T t) {
        removeView(this.f10968j);
        View view = this.f10968j;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).f10985b.destroy();
        }
        this.f10968j = t;
        this.f10967i = t;
        addView(t);
    }

    public final void a() {
        setStyle(getUserCaptionStyle());
    }

    public final void b() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void c() {
        this.f10967i.a(getCuesWithStylingPreferencesApplied(), this.f10960b, this.f10962d, this.f10961c, this.f10963e);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.f10965g = z;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.f10964f = z;
        c();
    }

    public void setBottomPaddingFraction(float f2) {
        this.f10963e = f2;
        c();
    }

    public void setCues(@Nullable List<Cue> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f10959a = list;
        c();
    }

    public void setFractionalTextSize(float f2) {
        this.f10961c = 0;
        this.f10962d = f2;
        c();
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.f10960b = captionStyleCompat;
        c();
    }

    public void setViewType(int i2) {
        if (this.f10966h == i2) {
            return;
        }
        if (i2 == 1) {
            setView(new CanvasSubtitleOutput(getContext(), null));
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new WebViewSubtitleOutput(getContext(), null));
        }
        this.f10966h = i2;
    }
}
