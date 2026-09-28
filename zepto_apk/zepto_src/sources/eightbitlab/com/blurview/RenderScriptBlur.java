package eightbitlab.com.blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

@Deprecated
/* loaded from: classes4.dex */
public class RenderScriptBlur implements BlurAlgorithm {

    /* renamed from: b, reason: collision with root package name */
    public final RenderScript f48346b;

    /* renamed from: c, reason: collision with root package name */
    public final ScriptIntrinsicBlur f48347c;

    /* renamed from: d, reason: collision with root package name */
    public Allocation f48348d;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f48345a = new Paint(2);

    /* renamed from: e, reason: collision with root package name */
    public int f48349e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f48350f = -1;

    public RenderScriptBlur(Context context) {
        RenderScript renderScriptCreate = RenderScript.create(context);
        this.f48346b = renderScriptCreate;
        this.f48347c = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void a() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void b(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f48345a);
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final Bitmap c(Bitmap bitmap, float f2) {
        RenderScript renderScript = this.f48346b;
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap);
        if (bitmap.getHeight() != this.f48350f || bitmap.getWidth() != this.f48349e) {
            Allocation allocation = this.f48348d;
            if (allocation != null) {
                allocation.destroy();
            }
            this.f48348d = Allocation.createTyped(renderScript, allocationCreateFromBitmap.getType());
            this.f48349e = bitmap.getWidth();
            this.f48350f = bitmap.getHeight();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f48347c;
        scriptIntrinsicBlur.setRadius(f2);
        scriptIntrinsicBlur.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlur.forEach(this.f48348d);
        this.f48348d.copyTo(bitmap);
        allocationCreateFromBitmap.destroy();
        return bitmap;
    }

    @Override // eightbitlab.com.blurview.BlurAlgorithm
    public final void destroy() {
        this.f48347c.destroy();
        this.f48346b.destroy();
        Allocation allocation = this.f48348d;
        if (allocation != null) {
            allocation.destroy();
        }
    }
}
