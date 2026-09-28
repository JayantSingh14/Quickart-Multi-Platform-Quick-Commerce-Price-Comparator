package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class MockView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f2333a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f2334b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f2335c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2336d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2337e;

    /* renamed from: f, reason: collision with root package name */
    public String f2338f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f2339g;

    /* renamed from: h, reason: collision with root package name */
    public int f2340h;

    /* renamed from: i, reason: collision with root package name */
    public int f2341i;

    /* renamed from: j, reason: collision with root package name */
    public int f2342j;

    /* renamed from: k, reason: collision with root package name */
    public int f2343k;

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2333a = new Paint();
        this.f2334b = new Paint();
        this.f2335c = new Paint();
        this.f2336d = true;
        this.f2337e = true;
        this.f2338f = null;
        this.f2339g = new Rect();
        this.f2340h = Color.argb(255, 0, 0, 0);
        this.f2341i = Color.argb(255, 200, 200, 200);
        this.f2342j = Color.argb(255, 50, 50, 50);
        this.f2343k = 4;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MockView_mock_label) {
                    this.f2338f = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f2336d = typedArrayObtainStyledAttributes.getBoolean(index, this.f2336d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f2340h = typedArrayObtainStyledAttributes.getColor(index, this.f2340h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f2342j = typedArrayObtainStyledAttributes.getColor(index, this.f2342j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f2341i = typedArrayObtainStyledAttributes.getColor(index, this.f2341i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f2337e = typedArrayObtainStyledAttributes.getBoolean(index, this.f2337e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f2338f == null) {
            try {
                this.f2338f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        int i3 = this.f2340h;
        Paint paint = this.f2333a;
        paint.setColor(i3);
        paint.setAntiAlias(true);
        int i4 = this.f2341i;
        Paint paint2 = this.f2334b;
        paint2.setColor(i4);
        paint2.setAntiAlias(true);
        this.f2335c.setColor(this.f2342j);
        this.f2343k = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f2343k);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2336d) {
            width--;
            height--;
            float f2 = width;
            float f3 = height;
            canvas2 = canvas;
            canvas2.drawLine(0.0f, 0.0f, f2, f3, this.f2333a);
            canvas2.drawLine(0.0f, f3, f2, 0.0f, this.f2333a);
            canvas2.drawLine(0.0f, 0.0f, f2, 0.0f, this.f2333a);
            canvas2.drawLine(f2, 0.0f, f2, f3, this.f2333a);
            canvas2.drawLine(f2, f3, 0.0f, f3, this.f2333a);
            canvas2.drawLine(0.0f, f3, 0.0f, 0.0f, this.f2333a);
        } else {
            canvas2 = canvas;
        }
        String str = this.f2338f;
        if (str == null || !this.f2337e) {
            return;
        }
        int length = str.length();
        Paint paint = this.f2334b;
        Rect rect = this.f2339g;
        paint.getTextBounds(str, 0, length, rect);
        float fWidth = (width - rect.width()) / 2.0f;
        float fHeight = ((height - rect.height()) / 2.0f) + rect.height();
        rect.offset((int) fWidth, (int) fHeight);
        int i2 = rect.left;
        int i3 = this.f2343k;
        rect.set(i2 - i3, rect.top - i3, rect.right + i3, rect.bottom + i3);
        canvas2.drawRect(rect, this.f2335c);
        canvas2.drawText(this.f2338f, fWidth, fHeight, paint);
    }

    public MockView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2333a = new Paint();
        this.f2334b = new Paint();
        this.f2335c = new Paint();
        this.f2336d = true;
        this.f2337e = true;
        this.f2338f = null;
        this.f2339g = new Rect();
        this.f2340h = Color.argb(255, 0, 0, 0);
        this.f2341i = Color.argb(255, 200, 200, 200);
        this.f2342j = Color.argb(255, 50, 50, 50);
        this.f2343k = 4;
        a(context, attributeSet);
    }
}
