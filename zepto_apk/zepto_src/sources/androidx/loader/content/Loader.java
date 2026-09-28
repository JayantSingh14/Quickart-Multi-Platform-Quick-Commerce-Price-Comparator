package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.loader.app.LoaderManagerImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class Loader<D> {

    /* renamed from: a, reason: collision with root package name */
    public LoaderManagerImpl.LoaderInfo f4989a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4990b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4991c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4992d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4993e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4994f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4995g;

    public final class ForceLoadContentObserver extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CursorLoader f4996a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForceLoadContentObserver(CursorLoader cursorLoader) {
            super(new Handler());
            this.f4996a = cursorLoader;
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            CursorLoader cursorLoader = this.f4996a;
            if (cursorLoader.f4991c) {
                cursorLoader.k();
            } else {
                cursorLoader.f4994f = true;
            }
        }
    }

    public interface OnLoadCanceledListener<D> {
    }

    public interface OnLoadCompleteListener<D> {
    }

    public void a(Object obj) {
        LoaderManagerImpl.LoaderInfo loaderInfo = this.f4989a;
        if (loaderInfo != null) {
            loaderInfo.o(obj);
        }
    }

    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(0);
        printWriter.print(" mListener=");
        printWriter.println(this.f4989a);
        if (this.f4991c || this.f4994f || this.f4995g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f4991c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f4994f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f4995g);
        }
        if (this.f4992d || this.f4993e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f4992d);
            printWriter.print(" mReset=");
            printWriter.println(this.f4993e);
        }
    }

    public boolean c() {
        return false;
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        Class<?> cls = getClass();
        sb.append(cls.getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(cls)));
        sb.append(" id=0}");
        return sb.toString();
    }
}
