package androidx.loader.app;

import android.os.Looper;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayCompatKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.internal.zbc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoaderManagerImpl extends LoaderManager {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4973a;

    /* renamed from: b, reason: collision with root package name */
    public final LoaderViewModel f4974b;

    /* loaded from: classes3.dex */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: l, reason: collision with root package name */
        public final Loader f4975l;

        /* renamed from: m, reason: collision with root package name */
        public Object f4976m;
        public LoaderObserver n;

        public LoaderInfo(Loader loader) {
            this.f4975l = loader;
            if (loader.f4989a != null) {
                throw new IllegalStateException("There is already a listener registered");
            }
            loader.f4989a = this;
        }

        @Override // androidx.lifecycle.LiveData
        public final void g() {
            Loader loader = this.f4975l;
            loader.f4991c = true;
            loader.f4993e = false;
            loader.f4992d = false;
            loader.e();
        }

        @Override // androidx.lifecycle.LiveData
        public final void h() {
            Loader loader = this.f4975l;
            loader.f4991c = false;
            loader.f();
        }

        @Override // androidx.lifecycle.LiveData
        public final void j(Observer observer) {
            super.j(observer);
            this.f4976m = null;
            this.n = null;
        }

        public final void l() {
            Loader loader = this.f4975l;
            loader.c();
            loader.f4992d = true;
            LoaderObserver loaderObserver = this.n;
            if (loaderObserver != null) {
                j(loaderObserver);
            }
            LoaderInfo<D> loaderInfo = loader.f4989a;
            if (loaderInfo == null) {
                throw new IllegalStateException("No listener register");
            }
            if (loaderInfo != this) {
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            loader.f4989a = null;
            if (loaderObserver != null) {
                boolean z = loaderObserver.f4978b;
            }
            loader.d();
            loader.f4993e = true;
            loader.f4991c = false;
            loader.f4992d = false;
            loader.f4994f = false;
            loader.f4995g = false;
        }

        public final void m(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str);
            printWriter.print("mLoader=");
            Loader loader = this.f4975l;
            printWriter.println(loader);
            loader.b(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.n);
                LoaderObserver loaderObserver = this.n;
                loaderObserver.getClass();
                printWriter.print(str + "  ");
                printWriter.print("mDeliveredData=");
                printWriter.println(loaderObserver.f4978b);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            Object objD = d();
            StringBuilder sb = new StringBuilder(64);
            if (objD == null) {
                sb.append("null");
            } else {
                Class<?> cls = objD.getClass();
                sb.append(cls.getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(cls)));
                sb.append("}");
            }
            printWriter.println(sb.toString());
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(this.f4833c > 0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.LifecycleOwner, java.lang.Object] */
        public final void n() {
            ?? r0 = this.f4976m;
            LoaderObserver loaderObserver = this.n;
            if (r0 == 0 || loaderObserver == null) {
                return;
            }
            super.j(loaderObserver);
            e(r0, loaderObserver);
        }

        public final void o(Object obj) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.k(obj);
            } else {
                i(obj);
            }
        }

        public final Loader p(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks loaderCallbacks) {
            Loader loader = this.f4975l;
            LoaderObserver loaderObserver = new LoaderObserver(loader, loaderCallbacks);
            e(lifecycleOwner, loaderObserver);
            LoaderObserver loaderObserver2 = this.n;
            if (loaderObserver2 != null) {
                j(loaderObserver2);
            }
            this.f4976m = lifecycleOwner;
            this.n = loaderObserver;
            return loader;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #0 : ");
            Class<?> cls = this.f4975l.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(cls)));
            sb.append("}}");
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class LoaderObserver<D> implements Observer<D> {

        /* renamed from: a, reason: collision with root package name */
        public final LoaderManager.LoaderCallbacks f4977a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4978b = false;

        public LoaderObserver(Loader loader, LoaderManager.LoaderCallbacks loaderCallbacks) {
            this.f4977a = loaderCallbacks;
        }

        @Override // androidx.lifecycle.Observer
        public final void a(Object obj) {
            this.f4978b = true;
            this.f4977a.a(obj);
        }

        public final String toString() {
            return this.f4977a.toString();
        }
    }

    public static class LoaderViewModel extends ViewModel {

        /* renamed from: d, reason: collision with root package name */
        public static final ViewModelProvider.Factory f4979d = new AnonymousClass1();

        /* renamed from: b, reason: collision with root package name */
        public final SparseArrayCompat f4980b = new SparseArrayCompat();

        /* renamed from: c, reason: collision with root package name */
        public boolean f4981c = false;

        /* renamed from: androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1, reason: invalid class name */
        public static class AnonymousClass1 implements ViewModelProvider.Factory {
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public final ViewModel c(Class cls) {
                return new LoaderViewModel();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public final void d() {
            SparseArrayCompat sparseArrayCompat = this.f4980b;
            int i2 = sparseArrayCompat.f1608c;
            for (int i3 = 0; i3 < i2; i3++) {
                ((LoaderInfo) sparseArrayCompat.f1607b[i3]).l();
            }
            int i4 = sparseArrayCompat.f1608c;
            Object[] objArr = sparseArrayCompat.f1607b;
            for (int i5 = 0; i5 < i4; i5++) {
                objArr[i5] = null;
            }
            sparseArrayCompat.f1608c = 0;
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f4973a = lifecycleOwner;
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, LoaderViewModel.f4979d);
        Intrinsics.checkNotNullParameter(LoaderViewModel.class, "modelClass");
        Intrinsics.checkNotNullParameter(LoaderViewModel.class, "<this>");
        this.f4974b = (LoaderViewModel) viewModelProvider.a(Reflection.a(LoaderViewModel.class));
    }

    @Override // androidx.loader.app.LoaderManager
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        SparseArrayCompat sparseArrayCompat = this.f4974b.f4980b;
        if (sparseArrayCompat.f1608c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < sparseArrayCompat.f1608c; i2++) {
                LoaderInfo loaderInfo = (LoaderInfo) sparseArrayCompat.f1607b[i2];
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(sparseArrayCompat.f1606a[i2]);
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.m(str2, fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.lifecycle.LifecycleOwner, java.lang.Object] */
    @Override // androidx.loader.app.LoaderManager
    public final Loader c(LoaderManager.LoaderCallbacks loaderCallbacks) {
        LoaderViewModel loaderViewModel = this.f4974b;
        if (loaderViewModel.f4981c) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        SparseArrayCompat sparseArrayCompat = loaderViewModel.f4980b;
        sparseArrayCompat.getClass();
        LoaderInfo loaderInfo = (LoaderInfo) SparseArrayCompatKt.a(sparseArrayCompat, 0);
        ?? r4 = this.f4973a;
        if (loaderInfo != 0) {
            return loaderInfo.p(r4, loaderCallbacks);
        }
        try {
            loaderViewModel.f4981c = true;
            zbc zbcVarB = loaderCallbacks.b();
            if (zbc.class.isMemberClass() && !Modifier.isStatic(zbc.class.getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + zbcVarB);
            }
            LoaderInfo loaderInfo2 = new LoaderInfo(zbcVarB);
            loaderViewModel.f4980b.c(0, loaderInfo2);
            loaderViewModel.f4981c = false;
            return loaderInfo2.p(r4, loaderCallbacks);
        } catch (Throwable th) {
            loaderViewModel.f4981c = false;
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public final void d() {
        SparseArrayCompat sparseArrayCompat = this.f4974b.f4980b;
        int i2 = sparseArrayCompat.f1608c;
        for (int i3 = 0; i3 < i2; i3++) {
            ((LoaderInfo) sparseArrayCompat.f1607b[i3]).n();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Class<?> cls = this.f4973a.getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append("}}");
        return sb.toString();
    }
}
