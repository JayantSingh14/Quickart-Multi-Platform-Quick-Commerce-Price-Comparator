package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class WebViewGlueCommunicator {

    public static class LAZY_COMPAT_CONVERTER_HOLDER {

        /* renamed from: a, reason: collision with root package name */
        public static final WebkitToCompatConverter f12461a = new WebkitToCompatConverter(LAZY_FACTORY_HOLDER.f12462a.getWebkitToCompatConverter());
    }

    public static class LAZY_FACTORY_HOLDER {

        /* renamed from: a, reason: collision with root package name */
        public static final WebViewProviderFactory f12462a;

        static {
            WebViewProviderFactory incompatibleApkWebViewProviderFactory;
            try {
                incompatibleApkWebViewProviderFactory = new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebViewProviderFactoryBoundaryInterface.class, WebViewGlueCommunicator.a()));
            } catch (ClassNotFoundException unused) {
                incompatibleApkWebViewProviderFactory = new IncompatibleApkWebViewProviderFactory();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
            f12462a = incompatibleApkWebViewProviderFactory;
        }
    }

    public static InvocationHandler a() throws NoSuchMethodException, SecurityException {
        ClassLoader classLoader;
        if (Build.VERSION.SDK_INT >= 28) {
            classLoader = WebView.getWebViewClassLoader();
        } else {
            try {
                Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
                declaredMethod.setAccessible(true);
                classLoader = declaredMethod.invoke(null, null).getClass().getClassLoader();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, classLoader).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static WebkitToCompatConverter b() {
        return LAZY_COMPAT_CONVERTER_HOLDER.f12461a;
    }

    public static WebViewProviderFactory c() {
        return LAZY_FACTORY_HOLDER.f12462a;
    }
}
