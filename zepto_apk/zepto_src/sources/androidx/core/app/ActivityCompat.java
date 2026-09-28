package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {

    /* renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        public static void a(FragmentActivity fragmentActivity) {
            fragmentActivity.finishAfterTransition();
        }

        public static void b(FragmentActivity fragmentActivity) {
            fragmentActivity.postponeEnterTransition();
        }

        public static void c(FragmentActivity fragmentActivity, android.app.SharedElementCallback sharedElementCallback) {
            fragmentActivity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void d(FragmentActivity fragmentActivity, android.app.SharedElementCallback sharedElementCallback) {
            fragmentActivity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void e(FragmentActivity fragmentActivity) {
            fragmentActivity.startPostponedEnterTransition();
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api22Impl {
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api23Impl {
        public static void a(Activity activity, String[] strArr, int i2) {
            activity.requestPermissions(strArr, i2);
        }

        public static boolean b(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api28Impl {
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api30Impl {
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api31Impl {
        public static boolean a(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api32Impl {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface OnRequestPermissionsResultCallback {
    }

    /* loaded from: classes3.dex */
    public interface PermissionCompatDelegate {
    }

    @RestrictTo
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i2);
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {

        /* renamed from: a, reason: collision with root package name */
        public final SharedElementCallback f2591a;

        public SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f2591a = sharedElementCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
        @Override // android.app.SharedElementCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.os.Parcelable onCaptureSharedElementSnapshot(android.view.View r19, android.graphics.Matrix r20, android.graphics.RectF r21) {
            /*
                Method dump skipped, instructions count: 270
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.ActivityCompat.SharedElementCallback21Impl.onCaptureSharedElementSnapshot(android.view.View, android.graphics.Matrix, android.graphics.RectF):android.os.Parcelable");
        }

        @Override // android.app.SharedElementCallback
        public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
            this.f2591a.getClass();
            if (!(parcelable instanceof Bundle)) {
                if (!(parcelable instanceof Bitmap)) {
                    return null;
                }
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap((Bitmap) parcelable);
                return imageView;
            }
            Bundle bundle = (Bundle) parcelable;
            Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
            if (bitmap == null) {
                return null;
            }
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageBitmap(bitmap);
            imageView2.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
            if (imageView2.getScaleType() == ImageView.ScaleType.MATRIX) {
                float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
                Matrix matrix = new Matrix();
                matrix.setValues(floatArray);
                imageView2.setImageMatrix(matrix);
            }
            return imageView2;
        }

        @Override // android.app.SharedElementCallback
        public final void onMapSharedElements(List list, Map map) {
            this.f2591a.getClass();
        }

        @Override // android.app.SharedElementCallback
        public final void onRejectSharedElements(List list) {
            this.f2591a.getClass();
        }

        @Override // android.app.SharedElementCallback
        public final void onSharedElementEnd(List list, List list2, List list3) {
            this.f2591a.getClass();
        }

        @Override // android.app.SharedElementCallback
        public final void onSharedElementStart(List list, List list2, List list3) {
            this.f2591a.getClass();
        }

        @Override // android.app.SharedElementCallback
        public final void onSharedElementsArrived(List list, List list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f2591a.getClass();
            onSharedElementsReadyListener.onSharedElementsReady();
        }
    }

    public static void g(FragmentActivity fragmentActivity) {
        Api21Impl.a(fragmentActivity);
    }

    public static void h(FragmentActivity fragmentActivity) {
        Api21Impl.b(fragmentActivity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(Activity activity, String[] strArr, int i2) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                throw new IllegalArgumentException(b.r(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (!hashSet.contains(Integer.valueOf(i5))) {
                    strArr2[i4] = strArr[i5];
                    i4++;
                }
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i2);
        }
        Api23Impl.a(activity, strArr, i2);
    }

    public static void j(FragmentActivity fragmentActivity, SharedElementCallback sharedElementCallback) {
        Api21Impl.c(fragmentActivity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static void k(FragmentActivity fragmentActivity, SharedElementCallback sharedElementCallback) {
        Api21Impl.d(fragmentActivity, sharedElementCallback != null ? new SharedElementCallback21Impl(sharedElementCallback) : null);
    }

    public static boolean l(Activity activity, String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i2 >= 32 ? Api32Impl.a(activity, str) : i2 == 31 ? Api31Impl.a(activity, str) : Api23Impl.b(activity, str);
        }
        return false;
    }

    public static void m(FragmentActivity fragmentActivity) {
        Api21Impl.e(fragmentActivity);
    }
}
