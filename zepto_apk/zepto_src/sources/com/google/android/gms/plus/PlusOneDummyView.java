package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

@Deprecated
/* loaded from: classes4.dex */
public class PlusOneDummyView extends FrameLayout {

    public static class zza implements zzd {

        /* renamed from: a, reason: collision with root package name */
        public Context f39689a;

        @Override // com.google.android.gms.plus.PlusOneDummyView.zzd
        public final Drawable a(int i2) {
            return this.f39689a.getResources().getDrawable(android.R.drawable.btn_default);
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.zzd
        public final boolean b() {
            return true;
        }
    }

    public static class zzb implements zzd {

        /* renamed from: a, reason: collision with root package name */
        public Context f39690a;

        @Override // com.google.android.gms.plus.PlusOneDummyView.zzd
        public final Drawable a(int i2) {
            try {
                Resources resources = this.f39690a.createPackageContext("com.google.android.gms", 4).getResources();
                return resources.getDrawable(resources.getIdentifier(i2 != 0 ? i2 != 1 ? i2 != 2 ? "ic_plusone_standard" : "ic_plusone_tall" : "ic_plusone_medium" : "ic_plusone_small", "drawable", "com.google.android.gms"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.zzd
        public final boolean b() {
            try {
                this.f39690a.createPackageContext("com.google.android.gms", 4).getResources();
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
    }

    public static class zzc implements zzd {

        /* renamed from: a, reason: collision with root package name */
        public Context f39691a;

        @Override // com.google.android.gms.plus.PlusOneDummyView.zzd
        public final Drawable a(int i2) {
            String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? "ic_plusone_standard_off_client" : "ic_plusone_tall_off_client" : "ic_plusone_medium_off_client" : "ic_plusone_small_off_client";
            Context context = this.f39691a;
            return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
        }

        @Override // com.google.android.gms.plus.PlusOneDummyView.zzd
        public final boolean b() {
            Context context = this.f39691a;
            return (context.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", context.getPackageName()) == 0 || context.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", context.getPackageName()) == 0 || context.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", context.getPackageName()) == 0 || context.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", context.getPackageName()) == 0) ? false : true;
        }
    }

    public interface zzd {
        Drawable a(int i2);

        boolean b();
    }
}
