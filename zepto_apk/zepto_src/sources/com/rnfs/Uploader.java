package com.rnfs;

import android.os.AsyncTask;
import com.rnfs.RNFSManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {

    /* renamed from: a, reason: collision with root package name */
    public UploadParams f46465a;

    /* renamed from: b, reason: collision with root package name */
    public UploadResult f46466b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f46467c = new AtomicBoolean(false);

    /* JADX WARN: Removed duplicated region for block: B:112:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0383  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.rnfs.Uploader r33, com.rnfs.UploadParams r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.a(com.rnfs.Uploader, com.rnfs.UploadParams):void");
    }

    public final void b() {
        this.f46467c.set(true);
    }

    @Override // android.os.AsyncTask
    public final UploadResult doInBackground(UploadParams[] uploadParamsArr) {
        this.f46465a = uploadParamsArr[0];
        this.f46466b = new UploadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Uploader.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                Uploader uploader = Uploader.this;
                try {
                    Uploader.a(uploader, uploader.f46465a);
                    ((RNFSManager.AnonymousClass6) uploader.f46465a.f46458g).a(uploader.f46466b);
                } catch (Exception e2) {
                    UploadResult uploadResult = uploader.f46466b;
                    uploadResult.f46463c = e2;
                    ((RNFSManager.AnonymousClass6) uploader.f46465a.f46458g).a(uploadResult);
                }
            }
        }).start();
        return this.f46466b;
    }
}
