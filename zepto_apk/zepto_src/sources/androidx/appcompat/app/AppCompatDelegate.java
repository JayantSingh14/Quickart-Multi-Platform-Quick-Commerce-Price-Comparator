package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppLocalesMetadataHolderService;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import androidx.collection.IndexBasedArrayIterator;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialExecutor f286a = new SerialExecutor(new ThreadPerTaskExecutor());

    /* renamed from: b, reason: collision with root package name */
    public static int f287b = -100;

    /* renamed from: c, reason: collision with root package name */
    public static LocaleListCompat f288c = null;

    /* renamed from: d, reason: collision with root package name */
    public static LocaleListCompat f289d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f290e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f291f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final ArraySet f292g = new ArraySet();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f293h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final Object f294i = new Object();

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        @DoNotInline
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api33Impl {
        @DoNotInline
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface NightMode {
    }

    public static class SerialExecutor implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Object f295a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayDeque f296b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        public final Executor f297c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f298d;

        public SerialExecutor(Executor executor) {
            this.f297c = executor;
        }

        public final void a() {
            synchronized (this.f295a) {
                try {
                    Runnable runnable = (Runnable) this.f296b.poll();
                    this.f298d = runnable;
                    if (runnable != null) {
                        ((ThreadPerTaskExecutor) this.f297c).execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public final void execute(final Runnable runnable) {
            synchronized (this.f295a) {
                try {
                    this.f296b.add(new Runnable() { // from class: androidx.appcompat.app.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            Runnable runnable2 = runnable;
                            AppCompatDelegate.SerialExecutor serialExecutor = this.f413a;
                            serialExecutor.getClass();
                            try {
                                runnable2.run();
                            } finally {
                                serialExecutor.a();
                            }
                        }
                    });
                    if (this.f298d == null) {
                        a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class ThreadPerTaskExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static void A(int i2) {
        if (i2 != -1 && i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
            return;
        }
        if (f287b != i2) {
            f287b = i2;
            synchronized (f293h) {
                try {
                    Iterator it = f292g.iterator();
                    while (true) {
                        IndexBasedArrayIterator indexBasedArrayIterator = (IndexBasedArrayIterator) it;
                        if (indexBasedArrayIterator.hasNext()) {
                            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) indexBasedArrayIterator.next()).get();
                            if (appCompatDelegate != null) {
                                appCompatDelegate.d();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean n(Context context) {
        if (f290e == null) {
            try {
                int i2 = AppLocalesMetadataHolderService.f357a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), AppLocalesMetadataHolderService.Api24Impl.a() | 128).metaData;
                if (bundle != null) {
                    f290e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f290e = Boolean.FALSE;
            }
        }
        return f290e.booleanValue();
    }

    public static void v(AppCompatDelegate appCompatDelegate) {
        synchronized (f293h) {
            try {
                Iterator it = f292g.iterator();
                while (true) {
                    IndexBasedArrayIterator indexBasedArrayIterator = (IndexBasedArrayIterator) it;
                    if (indexBasedArrayIterator.hasNext()) {
                        AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) ((WeakReference) indexBasedArrayIterator.next()).get();
                        if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                            indexBasedArrayIterator.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void B(Toolbar toolbar);

    public void C(int i2) {
    }

    public abstract void D(CharSequence charSequence);

    public abstract ActionMode E(ActionMode.Callback callback);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean d();

    public Context e(Context context) {
        return context;
    }

    public abstract View f(int i2);

    public Context g() {
        return null;
    }

    public abstract ActionBarDrawerToggle.Delegate h();

    public int i() {
        return -100;
    }

    public abstract MenuInflater j();

    public abstract ActionBar k();

    public abstract void l();

    public abstract void m();

    public abstract void o(Configuration configuration);

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u();

    public abstract boolean w(int i2);

    public abstract void x(int i2);

    public abstract void y(View view);

    public abstract void z(View view, ViewGroup.LayoutParams layoutParams);
}
