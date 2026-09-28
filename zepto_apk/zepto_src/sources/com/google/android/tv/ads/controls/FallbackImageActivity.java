package com.google.android.tv.ads.controls;

import android.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.internal.atv_ads_framework.zzf;
import com.google.android.gms.internal.atv_ads_framework.zzm;
import com.google.android.gms.internal.atv_ads_framework.zzn;
import com.google.android.tv.ads.IconClickFallbackImage;
import com.google.android.tv.ads.IconClickFallbackImages;

/* loaded from: classes4.dex */
public final class FallbackImageActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        Bundle bundle2 = new Bundle();
        if (extras != null) {
            bundle2.putBoolean("render_error_message", extras.getBoolean("render_error_message"));
            IconClickFallbackImages iconClickFallbackImages = (IconClickFallbackImages) extras.getParcelable("icon_click_fallback_images");
            if (iconClickFallbackImages == null || iconClickFallbackImages.b().isEmpty() || ((IconClickFallbackImage) iconClickFallbackImages.b().get(0)).e() == null) {
                zzf zzfVarA = zzf.a(this);
                zzm zzmVarK = zzn.k();
                zzmVarK.e();
                zzmVarK.g(2);
                zzmVarK.f(6);
                zzfVarA.b((zzn) zzmVarK.b());
                bundle2.putBoolean("render_error_message", true);
            } else {
                IconClickFallbackImage iconClickFallbackImage = (IconClickFallbackImage) iconClickFallbackImages.b().get(0);
                bundle2.putString("wta_uri", iconClickFallbackImage.e());
                bundle2.putString("wta_alt_text", iconClickFallbackImage.b());
            }
        } else {
            zzf zzfVarA2 = zzf.a(this);
            zzm zzmVarK2 = zzn.k();
            zzmVarK2.e();
            zzmVarK2.g(2);
            zzmVarK2.f(5);
            zzfVarA2.b((zzn) zzmVarK2.b());
            bundle2.putBoolean("render_error_message", true);
        }
        FragmentTransaction fragmentTransactionD = getSupportFragmentManager().d();
        fragmentTransactionD.r = true;
        FragmentFactory fragmentFactory = fragmentTransactionD.f4641a;
        if (fragmentFactory == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = fragmentTransactionD.f4642b;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment fragmentA = fragmentFactory.a(classLoader, SideDrawerFragment.class.getName());
        fragmentA.setArguments(bundle2);
        fragmentTransactionD.j(fragmentA, R.id.content);
        fragmentTransactionD.c();
    }
}
