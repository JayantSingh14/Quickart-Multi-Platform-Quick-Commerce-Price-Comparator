package com.amazon.identity.auth.device.authorization;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.ResponseManager;
import com.amazon.identity.auth.device.a;
import com.amazon.identity.auth.device.b;
import com.amazon.identity.auth.internal.BrowsingExperienceManager;

@SuppressLint({"Registered"})
/* loaded from: classes3.dex */
public class AuthorizationActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b bVar;
        super.onCreate(bundle);
        try {
            Uri data = getIntent().getData();
            String strA = b.a(getIntent().getData());
            if (data != null) {
                try {
                    if (b.c(data)) {
                        ResponseManager.a().b(data, strA);
                    } else {
                        Context applicationContext = getApplicationContext();
                        synchronized (b.class) {
                            try {
                                if (b.f15200c == null) {
                                    b.f15200c = new b(BrowsingExperienceManager.getInstance(applicationContext));
                                }
                                bVar = b.f15200c;
                            } finally {
                            }
                        }
                        Context applicationContext2 = getApplicationContext();
                        bVar.getClass();
                        String strA2 = b.a(data);
                        data.toString();
                        a aVar = (a) bVar.f15201a.remove(strA2);
                        if (aVar == null) {
                            data.toString();
                        } else if (!aVar.handleResponse(data, applicationContext2)) {
                            bVar.b(aVar, applicationContext2);
                        }
                    }
                } catch (AuthError unused) {
                    data.toString();
                }
            }
        } catch (AuthError unused2) {
            getIntent().getData().toString();
        }
        finish();
    }
}
