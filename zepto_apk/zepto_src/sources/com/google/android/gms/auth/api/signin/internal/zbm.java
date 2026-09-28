package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zbm {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f22216a = new Logger("GoogleSignInCommon", new String[0]);

    public static void a(Context context) {
        zbn.a(context).b();
        Iterator<GoogleApiClient> it = GoogleApiClient.getAllClients().iterator();
        while (it.hasNext()) {
            it.next().maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
    }
}
