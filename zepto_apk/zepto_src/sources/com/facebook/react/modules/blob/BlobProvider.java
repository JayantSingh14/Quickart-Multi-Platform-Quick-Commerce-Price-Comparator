package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.react.ReactApplication;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class BlobProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f19037a = Executors.newSingleThreadExecutor();

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws IOException {
        if (!str.equals("r")) {
            throw new FileNotFoundException("Cannot open " + uri.toString() + " in mode '" + str + "'");
        }
        Object applicationContext = getContext().getApplicationContext();
        BlobModule blobModule = applicationContext instanceof ReactApplication ? (BlobModule) ((ReactApplication) applicationContext).a().f().f().getNativeModule(BlobModule.class) : null;
        if (blobModule == null) {
            throw new RuntimeException("No blob module associated with BlobProvider");
        }
        final byte[] bArrResolve = blobModule.resolve(uri);
        if (bArrResolve == null) {
            throw new FileNotFoundException("Cannot open " + uri + ", blob not found.");
        }
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
            final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptorArrCreatePipe[1];
            if (bArrResolve.length > 65536) {
                this.f19037a.submit(new Runnable() { // from class: com.facebook.react.modules.blob.BlobProvider.1
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        try {
                            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
                            try {
                                autoCloseOutputStream.write(bArrResolve);
                                autoCloseOutputStream.close();
                            } finally {
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
                return parcelFileDescriptor;
            }
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
            try {
                autoCloseOutputStream.write(bArrResolve);
                autoCloseOutputStream.close();
                return parcelFileDescriptor;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
