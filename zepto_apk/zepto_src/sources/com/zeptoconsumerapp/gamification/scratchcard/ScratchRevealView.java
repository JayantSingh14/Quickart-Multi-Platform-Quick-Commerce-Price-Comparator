package com.zeptoconsumerapp.gamification.scratchcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.motion.b;
import com.zeptoconsumerapp.gamification.constants.AnimationType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ScratchRevealView extends ReactViewGroup {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f47600l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Path f47601a;

    /* renamed from: b, reason: collision with root package name */
    public float f47602b;

    /* renamed from: c, reason: collision with root package name */
    public float f47603c;

    /* renamed from: d, reason: collision with root package name */
    public float f47604d;

    /* renamed from: e, reason: collision with root package name */
    public float f47605e;

    /* renamed from: f, reason: collision with root package name */
    public float f47606f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47607g;

    /* renamed from: h, reason: collision with root package name */
    public final ReactContext f47608h;

    /* renamed from: i, reason: collision with root package name */
    public String f47609i;

    /* renamed from: j, reason: collision with root package name */
    public long f47610j;

    /* renamed from: k, reason: collision with root package name */
    public final Paint f47611k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScratchRevealView(ThemedReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new Paint();
        this.f47601a = new Path();
        this.f47604d = 10.0f;
        this.f47605e = 10.0f;
        this.f47608h = context;
        this.f47609i = AnimationType.f47596b.a();
        this.f47610j = 800L;
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setAntiAlias(true);
        this.f47611k = paint;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(canvas);
        Paint paint = this.f47611k;
        paint.setStrokeWidth(this.f47605e);
        canvas.drawPath(this.f47601a, paint);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        final float f2;
        Intrinsics.checkNotNullParameter(event, "event");
        float x = event.getX();
        float y = event.getY();
        if (!this.f47607g) {
            int action = event.getAction();
            Path path = this.f47601a;
            if (action == 0) {
                path.moveTo(x, y);
                this.f47602b = x;
                this.f47603c = y;
                invalidate();
                return true;
            }
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                float f3 = this.f47602b;
                float f4 = this.f47603c;
                float f5 = 2;
                path.quadTo(f3, f4, (x + f3) / f5, (y + f4) / f5);
                this.f47602b = x;
                this.f47603c = y;
                invalidate();
                return true;
            }
            int width = getWidth() / 10;
            int height = getHeight() / 10;
            if (width <= 0 || height <= 0) {
                f2 = 0.0f;
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Matrix matrix = new Matrix();
                matrix.setScale(0.1f, 0.1f);
                Path path2 = new Path();
                path.transform(matrix, path2);
                canvas.drawColor(-16777216);
                Paint paint = new Paint();
                paint.setColor(-1);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(this.f47605e * 0.1f);
                Paint paint2 = this.f47611k;
                paint.setStrokeCap(paint2.getStrokeCap());
                paint.setStrokeJoin(paint2.getStrokeJoin());
                paint.setAntiAlias(true);
                canvas.drawPath(path2, paint);
                int i2 = width * height;
                bitmapCreateBitmap.getPixels(new int[i2], 0, width, 0, 0, width, height);
                double dRed = 0.0d;
                for (int i3 = 0; i3 < i2; i3++) {
                    dRed += Color.red(r7[i3]) / 255.0f;
                }
                f2 = (((float) dRed) / i2) * 100;
                bitmapCreateBitmap.recycle();
            }
            if (f2 >= this.f47606f) {
                if (Intrinsics.b(this.f47609i, AnimationType.f47596b.a())) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f47604d, (float) Math.sqrt((getHeight() * getHeight()) + (getWidth() * getWidth())));
                    valueAnimatorOfFloat.setDuration(this.f47610j);
                    valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    valueAnimatorOfFloat.addUpdateListener(new b(this, 3));
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.zeptoconsumerapp.gamification.scratchcard.ScratchRevealView$animateStrokeWidth$1$2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            float f6 = f2;
                            ScratchRevealView scratchRevealView = this.f47612a;
                            scratchRevealView.setOnScratchComplete(f6);
                            scratchRevealView.f47607g = true;
                        }
                    });
                    valueAnimatorOfFloat.start();
                    return true;
                }
                setOnScratchComplete(f2);
                this.f47607g = true;
            }
        }
        return true;
    }

    public final void setOnScratchComplete(float f2) {
        EventDispatcher eventDispatcher;
        UIManagerModule uIManagerModule = (UIManagerModule) this.f47608h.getNativeModule(UIManagerModule.class);
        if (uIManagerModule == null || (eventDispatcher = uIManagerModule.getEventDispatcher()) == null) {
            return;
        }
        final WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("areaScratched", String.valueOf(f2));
        eventDispatcher.g(new Event<Event<?>>(getId()) { // from class: com.zeptoconsumerapp.gamification.scratchcard.ScratchRevealView.setOnScratchComplete.1
            @Override // com.facebook.react.uimanager.events.Event
            public final void dispatch(RCTEventEmitter rctEventEmitter) {
                Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
                rctEventEmitter.receiveEvent(getViewTag(), "onScratchComplete", writableMapCreateMap);
            }

            @Override // com.facebook.react.uimanager.events.Event
            public final String getEventName() {
                return "onScratchComplete";
            }
        });
    }
}
