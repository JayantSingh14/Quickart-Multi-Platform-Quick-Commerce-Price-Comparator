package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.client.android.R;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ViewfinderView extends View {

    /* renamed from: m, reason: collision with root package name */
    protected static final int[] f49021m = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: a, reason: collision with root package name */
    protected final Paint f49022a;

    /* renamed from: b, reason: collision with root package name */
    protected Bitmap f49023b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f49024c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f49025d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f49026e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f49027f;

    /* renamed from: g, reason: collision with root package name */
    protected int f49028g;

    /* renamed from: h, reason: collision with root package name */
    protected List<ResultPoint> f49029h;

    /* renamed from: i, reason: collision with root package name */
    protected List<ResultPoint> f49030i;

    /* renamed from: j, reason: collision with root package name */
    protected in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a f49031j;

    /* renamed from: k, reason: collision with root package name */
    protected Rect f49032k;

    /* renamed from: l, reason: collision with root package name */
    protected Rect f49033l;

    public class a implements a.f {
        public a() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void a() {
            ViewfinderView.this.a();
            ViewfinderView.this.invalidate();
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void b() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void d() {
        }

        @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a.f
        public void a(Exception exc) {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49022a = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_finder);
        this.f49024c = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R.color.zxing_viewfinder_mask));
        this.f49025d = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_result_view, resources.getColor(R.color.zxing_result_view));
        this.f49026e = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R.color.zxing_viewfinder_laser));
        this.f49027f = typedArrayObtainStyledAttributes.getColor(R.styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R.color.zxing_possible_result_points));
        typedArrayObtainStyledAttributes.recycle();
        this.f49028g = 0;
        this.f49029h = new ArrayList(20);
        this.f49030i = new ArrayList(20);
    }

    public void a() {
        in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a aVar = this.f49031j;
        if (aVar == null) {
            return;
        }
        Rect framingRect = aVar.getFramingRect();
        Rect previewFramingRect = this.f49031j.getPreviewFramingRect();
        if (framingRect == null || previewFramingRect == null) {
            return;
        }
        this.f49032k = framingRect;
        this.f49033l = previewFramingRect;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        a();
        Rect rect2 = this.f49032k;
        if (rect2 == null || (rect = this.f49033l) == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f49022a.setColor(this.f49023b != null ? this.f49025d : this.f49024c);
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, rect2.top, this.f49022a);
        canvas.drawRect(0.0f, rect2.top, rect2.left, rect2.bottom + 1, this.f49022a);
        canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.f49022a);
        canvas.drawRect(0.0f, rect2.bottom + 1, f2, height, this.f49022a);
        if (this.f49023b != null) {
            this.f49022a.setAlpha(160);
            canvas.drawBitmap(this.f49023b, (Rect) null, rect2, this.f49022a);
            return;
        }
        this.f49022a.setColor(this.f49026e);
        Paint paint = this.f49022a;
        int[] iArr = f49021m;
        paint.setAlpha(iArr[this.f49028g]);
        this.f49028g = (this.f49028g + 1) % iArr.length;
        int iHeight = (rect2.height() / 2) + rect2.top;
        canvas.drawRect(rect2.left + 2, iHeight - 1, rect2.right - 1, iHeight + 2, this.f49022a);
        float fWidth = rect2.width() / rect.width();
        float fHeight = rect2.height() / rect.height();
        int i2 = rect2.left;
        int i3 = rect2.top;
        if (!this.f49030i.isEmpty()) {
            this.f49022a.setAlpha(80);
            this.f49022a.setColor(this.f49027f);
            for (ResultPoint resultPoint : this.f49030i) {
                canvas.drawCircle(((int) (resultPoint.getX() * fWidth)) + i2, ((int) (resultPoint.getY() * fHeight)) + i3, 3.0f, this.f49022a);
            }
            this.f49030i.clear();
        }
        if (!this.f49029h.isEmpty()) {
            this.f49022a.setAlpha(160);
            this.f49022a.setColor(this.f49027f);
            for (ResultPoint resultPoint2 : this.f49029h) {
                canvas.drawCircle(((int) (resultPoint2.getX() * fWidth)) + i2, ((int) (resultPoint2.getY() * fHeight)) + i3, 6.0f, this.f49022a);
            }
            List<ResultPoint> list = this.f49029h;
            List<ResultPoint> list2 = this.f49030i;
            this.f49029h = list2;
            this.f49030i = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect2.left - 6, rect2.top - 6, rect2.right + 6, rect2.bottom + 6);
    }

    public void setCameraPreview(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.a aVar) {
        this.f49031j = aVar;
        aVar.addStateListener(new a());
    }

    public void a(ResultPoint resultPoint) {
        if (this.f49029h.size() < 20) {
            this.f49029h.add(resultPoint);
        }
    }
}
