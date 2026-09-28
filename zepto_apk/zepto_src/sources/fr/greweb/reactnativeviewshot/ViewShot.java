package fr.greweb.reactnativeviewshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.b;
import android.util.Base64;
import android.util.Log;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.fragment.app.e;
import com.facebook.react.bridge.Promise;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class ViewShot implements UIBlock, com.facebook.react.fabric.interop.UIBlock {
    public static byte[] n = new byte[65536];
    public static final Object o = new Object();
    public static final Set p = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a, reason: collision with root package name */
    public final int f48370a;

    /* renamed from: b, reason: collision with root package name */
    public final String f48371b;

    /* renamed from: c, reason: collision with root package name */
    public final int f48372c;

    /* renamed from: d, reason: collision with root package name */
    public final double f48373d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f48374e;

    /* renamed from: f, reason: collision with root package name */
    public final Integer f48375f;

    /* renamed from: g, reason: collision with root package name */
    public final File f48376g;

    /* renamed from: h, reason: collision with root package name */
    public final String f48377h;

    /* renamed from: i, reason: collision with root package name */
    public final Promise f48378i;

    /* renamed from: j, reason: collision with root package name */
    public final Boolean f48379j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f48380k;

    /* renamed from: l, reason: collision with root package name */
    public final Activity f48381l;

    /* renamed from: m, reason: collision with root package name */
    public final Executor f48382m;

    /* renamed from: fr.greweb.reactnativeviewshot.ViewShot$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIBlockViewResolver f48383a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NativeViewHierarchyManager f48384b;

        public AnonymousClass1(UIBlockViewResolver uIBlockViewResolver, NativeViewHierarchyManager nativeViewHierarchyManager) {
            this.f48383a = uIBlockViewResolver;
            this.f48384b = nativeViewHierarchyManager;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View viewResolveView;
            ViewShot viewShot = ViewShot.this;
            try {
                int i2 = viewShot.f48370a;
                int i3 = viewShot.f48370a;
                String str = viewShot.f48377h;
                if (i2 == -1) {
                    viewResolveView = viewShot.f48381l.getWindow().getDecorView().findViewById(android.R.id.content);
                } else {
                    UIBlockViewResolver uIBlockViewResolver = this.f48383a;
                    viewResolveView = uIBlockViewResolver != null ? uIBlockViewResolver.resolveView(i2) : this.f48384b.resolveView(i2);
                }
                Promise promise = viewShot.f48378i;
                if (viewResolveView == null) {
                    byte[] bArr = ViewShot.n;
                    Log.e("ViewShot", "No view found with reactTag: " + i3, new AssertionError());
                    promise.reject("E_UNABLE_TO_SNAPSHOT", "No view found with reactTag: " + i3);
                    return;
                }
                ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(ViewShot.n);
                reusableByteArrayOutputStream.c(Math.min(viewResolveView.getHeight() * viewResolveView.getWidth() * 4, 32));
                ViewShot.n = reusableByteArrayOutputStream.b();
                boolean zEquals = "tmpfile".equals(str);
                int i4 = viewShot.f48372c;
                if (zEquals && -1 == i4) {
                    ViewShot.c(viewShot, viewResolveView);
                    return;
                }
                if (!"tmpfile".equals(str) || -1 == i4) {
                    if (!"base64".equals(str) && !"zip-base64".equals(str)) {
                        if ("data-uri".equals(str)) {
                            ViewShot.b(viewShot, viewResolveView);
                            return;
                        }
                        return;
                    }
                    ViewShot.a(viewShot, viewResolveView);
                    return;
                }
                File file = viewShot.f48376g;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    viewShot.e(viewResolveView, fileOutputStream);
                    fileOutputStream.close();
                    promise.resolve(Uri.fromFile(file).toString());
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                byte[] bArr2 = ViewShot.n;
                Log.e("ViewShot", "Failed to capture view snapshot", th2);
                viewShot.f48378i.reject("E_UNABLE_TO_SNAPSHOT", "Failed to capture view snapshot");
            }
        }
    }

    public @interface Formats {

        /* renamed from: a, reason: collision with root package name */
        public static final Bitmap.CompressFormat[] f48393a = {Bitmap.CompressFormat.JPEG, Bitmap.CompressFormat.PNG, Bitmap.CompressFormat.WEBP};
    }

    public @interface Results {
    }

    public static class ReusableByteArrayOutputStream extends ByteArrayOutputStream {
        public ReusableByteArrayOutputStream(byte[] bArr) {
            super(0);
            ((ByteArrayOutputStream) this).buf = bArr;
        }

        public final ByteBuffer a(int i2) {
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            if (bArr.length < i2) {
                int length = bArr.length << 1;
                if (length - i2 < 0) {
                    length = i2;
                }
                if (length - 2147483639 > 0) {
                    if (i2 < 0) {
                        throw new OutOfMemoryError();
                    }
                    length = i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
                }
                ((ByteArrayOutputStream) this).buf = Arrays.copyOf(bArr, length);
            }
            return ByteBuffer.wrap(((ByteArrayOutputStream) this).buf);
        }

        public final byte[] b() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public final void c(int i2) {
            ((ByteArrayOutputStream) this).count = i2;
        }
    }

    public ViewShot(int i2, String str, int i3, double d2, Integer num, Integer num2, File file, String str2, Boolean bool, Activity activity, boolean z, Promise promise, Executor executor) {
        this.f48370a = i2;
        this.f48371b = str;
        this.f48372c = i3;
        this.f48373d = d2;
        this.f48374e = num;
        this.f48375f = num2;
        this.f48376g = file;
        this.f48377h = str2;
        this.f48379j = bool;
        this.f48381l = activity;
        this.f48380k = z;
        this.f48378i = promise;
        this.f48382m = executor;
    }

    public static void a(ViewShot viewShot, View view) throws IOException {
        String string;
        boolean z = -1 == viewShot.f48372c;
        boolean zEquals = "zip-base64".equals(viewShot.f48377h);
        ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(n);
        try {
            Point pointE = viewShot.e(view, reusableByteArrayOutputStream);
            reusableByteArrayOutputStream.close();
            n = reusableByteArrayOutputStream.b();
            int size = reusableByteArrayOutputStream.size();
            Locale locale = Locale.US;
            String str = pointE.x + ":" + pointE.y + CLConstants.SALT_DELIMETER;
            if (!z) {
                str = "";
            }
            if (zEquals) {
                Deflater deflater = new Deflater();
                deflater.setInput(n, 0, size);
                deflater.finish();
                ReusableByteArrayOutputStream reusableByteArrayOutputStream2 = new ReusableByteArrayOutputStream(new byte[32]);
                byte[] bArr = new byte[1024];
                while (!deflater.finished()) {
                    reusableByteArrayOutputStream2.write(bArr, 0, deflater.deflate(bArr));
                }
                StringBuilder sbW = b.w(str);
                sbW.append(Base64.encodeToString(reusableByteArrayOutputStream2.b(), 0, reusableByteArrayOutputStream2.size(), 2));
                string = sbW.toString();
            } else {
                StringBuilder sbW2 = b.w(str);
                sbW2.append(Base64.encodeToString(n, 0, size, 2));
                string = sbW2.toString();
            }
            viewShot.f48378i.resolve(string);
        } catch (Throwable th) {
            reusableByteArrayOutputStream.close();
            throw th;
        }
    }

    public static void b(ViewShot viewShot, View view) throws IOException {
        viewShot.getClass();
        ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(n);
        try {
            viewShot.e(view, reusableByteArrayOutputStream);
            reusableByteArrayOutputStream.close();
            n = reusableByteArrayOutputStream.b();
            String strEncodeToString = Base64.encodeToString(n, 0, reusableByteArrayOutputStream.size(), 2);
            String str = viewShot.f48371b;
            if ("jpg".equals(str)) {
                str = "jpeg";
            }
            viewShot.f48378i.resolve(e.p("data:image/", str, ";base64,", strEncodeToString));
        } catch (Throwable th) {
            reusableByteArrayOutputStream.close();
            throw th;
        }
    }

    public static void c(ViewShot viewShot, View view) throws IOException {
        File file = viewShot.f48376g;
        String string = Uri.fromFile(file).toString();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ReusableByteArrayOutputStream reusableByteArrayOutputStream = new ReusableByteArrayOutputStream(n);
        try {
            Point pointE = viewShot.e(view, reusableByteArrayOutputStream);
            reusableByteArrayOutputStream.close();
            n = reusableByteArrayOutputStream.b();
            int size = reusableByteArrayOutputStream.size();
            Locale locale = Locale.US;
            fileOutputStream.write((pointE.x + ":" + pointE.y + CLConstants.SALT_DELIMETER).getBytes(Charset.forName("US-ASCII")));
            fileOutputStream.write(n, 0, size);
            fileOutputStream.close();
            viewShot.f48378i.resolve(string);
        } catch (Throwable th) {
            reusableByteArrayOutputStream.close();
            throw th;
        }
    }

    public static Matrix d(Canvas canvas, View view, View view2) {
        Matrix matrix = new Matrix();
        LinkedList linkedList = new LinkedList();
        View view3 = view2;
        do {
            linkedList.add(view3);
            view3 = (View) view3.getParent();
        } while (view3 != view);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            View view4 = (View) it.next();
            canvas.save();
            int paddingTop = 0;
            float translationX = view4.getTranslationX() + view4.getLeft() + (view4 != view2 ? view4.getPaddingLeft() : 0);
            int top = view4.getTop();
            if (view4 != view2) {
                paddingTop = view4.getPaddingTop();
            }
            float translationY = view4.getTranslationY() + top + paddingTop;
            canvas.translate(translationX, translationY);
            canvas.rotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            canvas.scale(view4.getScaleX(), view4.getScaleY());
            matrix.postTranslate(translationX, translationY);
            matrix.postRotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            matrix.postScale(view4.getScaleX(), view4.getScaleY());
        }
        return matrix;
    }

    public static ArrayList f(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            arrayList2.addAll(f(viewGroup.getChildAt(i2)));
        }
        return arrayList2;
    }

    public static Bitmap g(int i2, int i3) {
        synchronized (o) {
            try {
                for (Bitmap bitmap : p) {
                    if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
                        p.remove(bitmap);
                        bitmap.eraseColor(0);
                        return bitmap;
                    }
                }
                return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(Bitmap bitmap) {
        synchronized (o) {
            p.add(bitmap);
        }
    }

    public final Point e(View view, OutputStream outputStream) throws InterruptedException {
        int i2;
        Bitmap bitmapCreateBitmap;
        SurfaceView surfaceView;
        final SurfaceView surfaceView2;
        final View view2 = view;
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Impossible to snapshot the view: view is invalid");
        }
        boolean z = false;
        if (this.f48379j.booleanValue()) {
            ScrollView scrollView = (ScrollView) view2;
            int height2 = 0;
            for (int i3 = 0; i3 < scrollView.getChildCount(); i3++) {
                height2 += scrollView.getChildAt(i3).getHeight();
            }
            i2 = height2;
        } else {
            i2 = height;
        }
        Point point = new Point(width, i2);
        synchronized (o) {
            try {
                Iterator it = p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bitmapCreateBitmap = Bitmap.createBitmap(width, i2, Bitmap.Config.ARGB_8888);
                        break;
                    }
                    bitmapCreateBitmap = (Bitmap) it.next();
                    if (bitmapCreateBitmap.getWidth() == width && bitmapCreateBitmap.getHeight() == i2) {
                        p.remove(bitmapCreateBitmap);
                        bitmapCreateBitmap.eraseColor(0);
                        break;
                    }
                }
            } finally {
            }
        }
        Bitmap bitmap = bitmapCreateBitmap;
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        final Canvas canvas = new Canvas(bitmap);
        view2.draw(canvas);
        Iterator it2 = f(view2).iterator();
        while (it2.hasNext()) {
            View view3 = (View) it2.next();
            if (view3 instanceof TextureView) {
                if (view3.getVisibility() == 0) {
                    TextureView textureView = (TextureView) view3;
                    textureView.setOpaque(z);
                    Bitmap bitmap2 = textureView.getBitmap(g(view3.getWidth(), view3.getHeight()));
                    int iSave = canvas.save();
                    d(canvas, view2, view3);
                    canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
                    canvas.restoreToCount(iSave);
                    h(bitmap2);
                }
            } else if ((view3 instanceof SurfaceView) && this.f48380k) {
                SurfaceView surfaceView3 = (SurfaceView) view3;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Bitmap bitmapG = g(view3.getWidth(), view3.getHeight());
                try {
                    surfaceView2 = (SurfaceView) view3;
                    surfaceView = surfaceView3;
                } catch (Exception e2) {
                    e = e2;
                    surfaceView = surfaceView3;
                }
                try {
                    PixelCopy.request(surfaceView, bitmapG, new PixelCopy.OnPixelCopyFinishedListener() { // from class: fr.greweb.reactnativeviewshot.ViewShot.2
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public final void onPixelCopyFinished(int i4) {
                            Canvas canvas2 = canvas;
                            int iSave2 = canvas2.save();
                            byte[] bArr = ViewShot.n;
                            View view4 = view2;
                            ViewShot.this.getClass();
                            ViewShot.d(canvas2, view4, surfaceView2);
                            Paint paint2 = paint;
                            Bitmap bitmap3 = bitmapG;
                            canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, paint2);
                            canvas2.restoreToCount(iSave2);
                            ViewShot.h(bitmap3);
                            countDownLatch.countDown();
                        }
                    }, new Handler(Looper.getMainLooper()));
                    countDownLatch.await(5L, TimeUnit.SECONDS);
                } catch (Exception e3) {
                    e = e3;
                    Log.e("ViewShot", "Cannot PixelCopy for " + surfaceView, e);
                    view2 = view;
                    z = false;
                }
            }
            view2 = view;
            z = false;
        }
        Integer num = this.f48374e;
        if (num != null && this.f48375f != null && (num.intValue() != width || this.f48375f.intValue() != i2)) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, this.f48374e.intValue(), this.f48375f.intValue(), true);
            h(bitmap);
            bitmap = bitmapCreateScaledBitmap;
        }
        int i4 = this.f48372c;
        if (-1 == i4 && (outputStream instanceof ReusableByteArrayOutputStream)) {
            int i5 = width * i2 * 4;
            ReusableByteArrayOutputStream reusableByteArrayOutputStream = (ReusableByteArrayOutputStream) outputStream;
            bitmap.copyPixelsToBuffer(reusableByteArrayOutputStream.a(i5));
            reusableByteArrayOutputStream.c(i5);
        } else {
            bitmap.compress(Formats.f48393a[i4], (int) (this.f48373d * 100.0d), outputStream);
        }
        h(bitmap);
        return point;
    }

    @Override // com.facebook.react.fabric.interop.UIBlock
    public final void execute(UIBlockViewResolver uIBlockViewResolver) {
        this.f48382m.execute(new AnonymousClass1(uIBlockViewResolver, null));
    }

    @Override // com.facebook.react.uimanager.UIBlock
    public final void i(NativeViewHierarchyManager nativeViewHierarchyManager) {
        this.f48382m.execute(new AnonymousClass1(null, nativeViewHierarchyManager));
    }
}
