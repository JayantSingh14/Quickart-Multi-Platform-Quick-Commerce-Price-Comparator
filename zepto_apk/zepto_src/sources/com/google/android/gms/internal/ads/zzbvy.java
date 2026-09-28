package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzbvy implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f25629a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f25630b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbwa f25631c;

    public zzbvy(zzbwa zzbwaVar, String str, String str2) {
        this.f25629a = str;
        this.f25630b = str2;
        this.f25631c = zzbwaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) throws JSONException {
        zzbwa zzbwaVar = this.f25631c;
        DownloadManager downloadManager = (DownloadManager) zzbwaVar.f25634d.getSystemService("download");
        try {
            String str = this.f25629a;
            String str2 = this.f25630b;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            zzbwaVar.b("Could not store picture.");
        }
    }
}
