package com.amazon.android.apay.commonlibrary.browsinglib.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes3.dex */
public class RedirectUriReceiverActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) BrowsingActivity.class);
        intent.setData(getIntent().getData());
        intent.setFlags(603979776);
        finish();
        startActivity(intent);
    }
}
