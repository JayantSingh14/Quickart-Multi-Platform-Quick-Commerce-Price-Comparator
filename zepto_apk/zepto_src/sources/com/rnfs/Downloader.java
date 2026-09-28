package com.rnfs;

import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.rnfs.DownloadParams;
import com.rnfs.RNFSManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> {

    /* renamed from: a, reason: collision with root package name */
    public DownloadParams f46422a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f46423b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public DownloadResult f46424c;

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.rnfs.DownloadParams r31, com.rnfs.DownloadResult r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Downloader.a(com.rnfs.DownloadParams, com.rnfs.DownloadResult):void");
    }

    public final void b() {
        this.f46423b.set(true);
    }

    @Override // android.os.AsyncTask
    public final DownloadResult doInBackground(DownloadParams[] downloadParamsArr) {
        this.f46422a = downloadParamsArr[0];
        this.f46424c = new DownloadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Downloader.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                Downloader downloader = Downloader.this;
                try {
                    downloader.a(downloader.f46422a, downloader.f46424c);
                    ((RNFSManager.AnonymousClass3) downloader.f46422a.f46416h).a(downloader.f46424c);
                } catch (Exception e2) {
                    DownloadResult downloadResult = downloader.f46424c;
                    downloadResult.f46421c = e2;
                    ((RNFSManager.AnonymousClass3) downloader.f46422a.f46416h).a(downloadResult);
                }
            }
        }).start();
        return this.f46424c;
    }

    @Override // android.os.AsyncTask
    public final void onProgressUpdate(long[][] jArr) {
        long[][] jArr2 = jArr;
        super.onProgressUpdate(jArr2);
        DownloadParams.OnDownloadProgress onDownloadProgress = this.f46422a.f46418j;
        if (onDownloadProgress != null) {
            long[] jArr3 = jArr2[0];
            long j2 = jArr3[0];
            long j3 = jArr3[1];
            RNFSManager.AnonymousClass5 anonymousClass5 = (RNFSManager.AnonymousClass5) onDownloadProgress;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("jobId", anonymousClass5.f46440a);
            writableMapCreateMap.putDouble("contentLength", j2);
            writableMapCreateMap.putDouble("bytesWritten", j3);
            RNFSManager rNFSManager = RNFSManager.this;
            rNFSManager.sendEvent(rNFSManager.getReactApplicationContext(), "DownloadProgress", writableMapCreateMap);
        }
    }
}
