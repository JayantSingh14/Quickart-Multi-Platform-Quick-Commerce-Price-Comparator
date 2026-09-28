package androidx.media3.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.media3.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class CanvasSubtitleOutput extends View implements SubtitleView.Output {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10823a;

    /* renamed from: b, reason: collision with root package name */
    public List f10824b;

    /* renamed from: c, reason: collision with root package name */
    public int f10825c;

    /* renamed from: d, reason: collision with root package name */
    public float f10826d;

    /* renamed from: e, reason: collision with root package name */
    public CaptionStyleCompat f10827e;

    /* renamed from: f, reason: collision with root package name */
    public float f10828f;

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10823a = new ArrayList();
        this.f10824b = Collections.EMPTY_LIST;
        this.f10825c = 0;
        this.f10826d = 0.0533f;
        this.f10827e = CaptionStyleCompat.f10829g;
        this.f10828f = 0.08f;
    }

    @Override // androidx.media3.ui.SubtitleView.Output
    public final void a(List list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3) {
        this.f10824b = list;
        this.f10827e = captionStyleCompat;
        this.f10826d = f2;
        this.f10825c = i2;
        this.f10828f = f3;
        while (true) {
            ArrayList arrayList = this.f10823a;
            if (arrayList.size() >= list.size()) {
                invalidate();
                return;
            }
            arrayList.add(new SubtitlePainter(getContext()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x046d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r37) {
        /*
            Method dump skipped, instructions count: 1179
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.CanvasSubtitleOutput.dispatchDraw(android.graphics.Canvas):void");
    }
}
