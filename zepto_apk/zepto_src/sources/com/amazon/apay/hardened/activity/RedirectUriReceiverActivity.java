package com.amazon.apay.hardened.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class RedirectUriReceiverActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) APayBrowserActivity.class);
        intent.setData(getIntent().getData());
        intent.addFlags(603979776);
        Timber.c("RedirectUriReceiverActivity: onCreate called with data : %s", getIntent().getData());
        finish();
        startActivity(intent);
    }
}
