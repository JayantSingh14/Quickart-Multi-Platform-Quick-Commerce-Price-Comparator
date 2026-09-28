package eightbitlab.com.blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import androidx.annotation.RequiresApi;
import com.google.android.material.textfield.h;

@RequiresApi
/* loaded from: classes4.dex */
public class RenderEffectBlur implements BlurAlgorithm {

    /* renamed from: b, reason: collision with root package name */
    public int f48340b;

    /* renamed from: c, reason: collision with root package name */
    public int f48341c;

    /* renamed from: e, reason: collision with root package name */
    public RenderScriptBlur f48343e;

    /* renamed from: f, reason: collision with root package name */
    public Context f48344f;

    /* renamed from: a, reason: collision with root package name */
    public final RenderNode f48339a = h.c();

    /* renamed from: d, reason: collision with root package name */
    public float f48342d = 1.0f;

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void a() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void b(Canvas canvas, Bitmap bitmap) {
        if (canvas.isHardwareAccelerated()) {
            canvas.drawRenderNode(this.f48339a);
            return;
        }
        if (this.f48343e == null) {
            this.f48343e = new RenderScriptBlur(this.f48344f);
        }
        this.f48343e.c(bitmap, this.f48342d);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f48343e.f48345a);
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final Bitmap c(Bitmap bitmap, float f2) {
        this.f48342d = f2;
        if (bitmap.getHeight() != this.f48340b || bitmap.getWidth() != this.f48341c) {
            this.f48340b = bitmap.getHeight();
            int width = bitmap.getWidth();
            this.f48341c = width;
            this.f48339a.setPosition(0, 0, width, this.f48340b);
        }
        this.f48339a.beginRecording().drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.f48339a.endRecording();
        RenderNode renderNode = this.f48339a;
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        renderNode.setRenderEffect(RenderEffect.createBlurEffect(f2, f2, Shader.TileMode.MIRROR));
        return bitmap;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void destroy() {
        this.f48339a.discardDisplayList();
        RenderScriptBlur renderScriptBlur = this.f48343e;
        if (renderScriptBlur != null) {
            renderScriptBlur.destroy();
        }
    }
}
