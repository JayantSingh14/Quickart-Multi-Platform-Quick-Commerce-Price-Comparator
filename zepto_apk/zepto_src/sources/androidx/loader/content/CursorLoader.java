package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: k, reason: collision with root package name */
    public final Loader.ForceLoadContentObserver f4986k;

    /* renamed from: l, reason: collision with root package name */
    public final Uri f4987l;

    /* renamed from: m, reason: collision with root package name */
    public final String[] f4988m;
    public final String n;
    public final String[] o;
    public Cursor p;
    public CancellationSignal q;

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2) {
        super(context);
        this.f4986k = new Loader.ForceLoadContentObserver(this);
        this.f4987l = uri;
        this.f4988m = strArr;
        this.n = str;
        this.o = strArr2;
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    public final void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.b(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f4987l);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f4988m));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.o));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println((String) null);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.p);
    }

    @Override // androidx.loader.content.Loader
    public final void d() {
        c();
        Cursor cursor = this.p;
        if (cursor != null && !cursor.isClosed()) {
            this.p.close();
        }
        this.p = null;
    }

    @Override // androidx.loader.content.Loader
    public final void e() {
        Cursor cursor = this.p;
        if (cursor != null) {
            a(cursor);
        }
        boolean z = this.f4994f;
        this.f4994f = false;
        this.f4995g |= z;
        if (z || this.p == null) {
            k();
        }
    }

    @Override // androidx.loader.content.Loader
    public final void f() {
        c();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final void g() {
        synchronized (this) {
            try {
                CancellationSignal cancellationSignal = this.q;
                if (cancellationSignal != null) {
                    cancellationSignal.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public final void j(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void a(Cursor cursor) {
        if (this.f4993e) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.p;
        this.p = cursor;
        if (this.f4991c) {
            super.a(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final Cursor i() {
        synchronized (this) {
            if (this.f4984j != null) {
                throw new OperationCanceledException();
            }
            this.q = new CancellationSignal();
        }
        try {
            Cursor cursorA = ContentResolverCompat.a(this.f4990b.getContentResolver(), this.f4987l, this.f4988m, this.n, this.o, this.q);
            if (cursorA != null) {
                try {
                    cursorA.getCount();
                    cursorA.registerContentObserver(this.f4986k);
                } catch (RuntimeException e2) {
                    cursorA.close();
                    throw e2;
                }
            }
            synchronized (this) {
                this.q = null;
            }
            return cursorA;
        } catch (Throwable th) {
            synchronized (this) {
                this.q = null;
                throw th;
            }
        }
    }
}
