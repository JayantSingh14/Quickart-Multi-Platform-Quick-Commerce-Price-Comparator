package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.auth.api.phone.SmsCodeBrowserClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* loaded from: classes4.dex */
public final class zzad extends GoogleApi implements SmsCodeBrowserClient {
    static {
        new Api("SmsCodeBrowser.API", new zzab(), new Api.ClientKey());
    }
}
