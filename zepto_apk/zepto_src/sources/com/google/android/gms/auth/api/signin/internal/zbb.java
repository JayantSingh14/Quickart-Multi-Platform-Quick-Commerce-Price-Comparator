package com.google.android.gms.auth.api.signin.internal;

import coil3.network.internal.UtilsKt;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes4.dex */
public final class zbb implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f22207c = new Logger("RevokeAccessOperation", new String[0]);

    /* renamed from: a, reason: collision with root package name */
    public final String f22208a;

    /* renamed from: b, reason: collision with root package name */
    public final StatusPendingResult f22209b = new StatusPendingResult((GoogleApiClient) null);

    public zbb(String str) {
        this.f22208a = Preconditions.checkNotEmpty(str);
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Logger logger = f22207c;
        Status status = Status.RESULT_INTERNAL_ERROR;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.f22208a).openConnection();
            httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.RESULT_SUCCESS;
            } else {
                logger.e("Unable to revoke access!", new Object[0]);
            }
            logger.d("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e2) {
            logger.e("IOException when revoking access: ".concat(String.valueOf(e2.toString())), new Object[0]);
        } catch (Exception e3) {
            logger.e("Exception when revoking access: ".concat(String.valueOf(e3.toString())), new Object[0]);
        }
        this.f22209b.setResult(status);
    }
}
