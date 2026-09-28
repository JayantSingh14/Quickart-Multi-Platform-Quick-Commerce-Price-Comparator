package androidx.core.view;

import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes3.dex */
public class KeyEventDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3042a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Method f3043b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3044c = false;

    /* renamed from: d, reason: collision with root package name */
    public static Field f3045d;

    /* loaded from: classes.dex */
    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        WeakReference weakReference;
        int iIndexOfKey;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ViewCompat.UnhandledKeyEventManager unhandledKeyEventManagerA = ViewCompat.UnhandledKeyEventManager.a(view);
        WeakReference weakReference2 = unhandledKeyEventManagerA.f3097c;
        if (weakReference2 == null || weakReference2.get() != keyEvent) {
            unhandledKeyEventManagerA.f3097c = new WeakReference(keyEvent);
            if (unhandledKeyEventManagerA.f3096b == null) {
                unhandledKeyEventManagerA.f3096b = new SparseArray();
            }
            SparseArray sparseArray = unhandledKeyEventManagerA.f3096b;
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                sparseArray.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
            }
            if (weakReference != null) {
                View view2 = (View) weakReference.get();
                if (view2 != null && view2.isAttachedToWindow()) {
                    ViewCompat.UnhandledKeyEventManager.d(view2, keyEvent);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(androidx.core.view.KeyEventDispatcher.Component r7, android.view.View r8, android.view.Window.Callback r9, android.view.KeyEvent r10) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.KeyEventDispatcher.b(androidx.core.view.KeyEventDispatcher$Component, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }
}
