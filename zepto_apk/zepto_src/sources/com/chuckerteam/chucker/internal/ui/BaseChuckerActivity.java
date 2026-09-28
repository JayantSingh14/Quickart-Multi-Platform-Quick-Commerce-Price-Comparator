package com.chuckerteam.chucker.internal.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class BaseChuckerActivity extends AppCompatActivity {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f16848i;

    @Metadata
    public static final class Companion {
    }

    public static void l(BaseChuckerActivity baseChuckerActivity, String message) {
        baseChuckerActivity.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(baseChuckerActivity.getApplicationContext(), message, 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        RepositoryProvider.a(applicationContext);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        f16848i = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        f16848i = true;
    }
}
