package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {

    /* renamed from: a, reason: collision with root package name */
    public final CanvasSubtitleOutput f10984a;

    /* renamed from: b, reason: collision with root package name */
    public final WebView f10985b;

    /* renamed from: c, reason: collision with root package name */
    public List f10986c;

    /* renamed from: d, reason: collision with root package name */
    public CaptionStyleCompat f10987d;

    /* renamed from: e, reason: collision with root package name */
    public float f10988e;

    /* renamed from: f, reason: collision with root package name */
    public int f10989f;

    /* renamed from: g, reason: collision with root package name */
    public float f10990g;

    /* renamed from: androidx.media3.ui.WebViewSubtitleOutput$1, reason: invalid class name */
    public class AnonymousClass1 extends WebView {
        @Override // android.webkit.WebView, android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* renamed from: androidx.media3.ui.WebViewSubtitleOutput$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10991a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f10991a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10991a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10991a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10986c = Collections.EMPTY_LIST;
        this.f10987d = CaptionStyleCompat.f10829g;
        this.f10988e = 0.0533f;
        this.f10989f = 0;
        this.f10990g = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.f10984a = canvasSubtitleOutput;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, attributeSet);
        this.f10985b = anonymousClass1;
        anonymousClass1.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(anonymousClass1);
    }

    @Override // androidx.media3.ui.SubtitleView.Output
    public final void a(List list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3) {
        this.f10987d = captionStyleCompat;
        this.f10988e = f2;
        this.f10989f = i2;
        this.f10990g = f3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Cue cue = (Cue) list.get(i3);
            if (cue.f5615d != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.f10986c.isEmpty() || !arrayList2.isEmpty()) {
            this.f10986c = arrayList2;
            c();
        }
        this.f10984a.a(arrayList, captionStyleCompat, f2, i2, f3);
        invalidate();
    }

    public final String b(float f2, int i2) {
        float fB = SubtitleViewUtils.b(f2, i2, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (fB == -3.4028235E38f) {
            return "unset";
        }
        Object[] objArr = {Float.valueOf(fB / getContext().getResources().getDisplayMetrics().density)};
        int i3 = Util.f5744a;
        return String.format(Locale.US, "%.2fpx", objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0530 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 1789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.WebViewSubtitleOutput.c():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!z || this.f10986c.isEmpty()) {
            return;
        }
        c();
    }
}
