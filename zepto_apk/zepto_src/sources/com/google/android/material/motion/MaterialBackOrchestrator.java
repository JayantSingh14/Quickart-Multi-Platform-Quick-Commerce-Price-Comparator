package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Objects;

@RestrictTo
/* loaded from: classes4.dex */
public final class MaterialBackOrchestrator {

    /* renamed from: a, reason: collision with root package name */
    public final Api33BackCallbackDelegate f40672a;

    /* renamed from: b, reason: collision with root package name */
    public final MaterialBackHandler f40673b;

    /* renamed from: c, reason: collision with root package name */
    public final View f40674c;

    @RequiresApi
    public static class Api33BackCallbackDelegate implements BackCallbackDelegate {

        /* renamed from: a, reason: collision with root package name */
        public OnBackInvokedCallback f40675a;

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        @DoNotInline
        public void a(@NonNull View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f40675a);
            this.f40675a = null;
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        @DoNotInline
        public void b(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f40675a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(materialBackHandler);
                this.f40675a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        public OnBackInvokedCallback c(final MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new OnBackInvokedCallback() { // from class: com.google.android.material.motion.a
                public final void onBackInvoked() {
                    materialBackHandler.e();
                }
            };
        }
    }

    @RequiresApi
    public static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        public final OnBackInvokedCallback c(final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator.Api34BackCallbackDelegate.1
                public final void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.f40675a != null) {
                        materialBackHandler.b();
                    }
                }

                public final void onBackInvoked() {
                    materialBackHandler.e();
                }

                public final void onBackProgressed(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.f40675a != null) {
                        materialBackHandler.d(new BackEventCompat(backEvent));
                    }
                }

                public final void onBackStarted(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.f40675a != null) {
                        materialBackHandler.c(new BackEventCompat(backEvent));
                    }
                }
            };
        }
    }

    public interface BackCallbackDelegate {
        void a(View view);

        void b(MaterialBackHandler materialBackHandler, View view, boolean z);
    }

    public MaterialBackOrchestrator(MaterialBackHandler materialBackHandler, View view) {
        int i2 = Build.VERSION.SDK_INT;
        this.f40672a = i2 >= 34 ? new Api34BackCallbackDelegate() : i2 >= 33 ? new Api33BackCallbackDelegate() : null;
        this.f40673b = materialBackHandler;
        this.f40674c = view;
    }

    public final void a(boolean z) {
        Api33BackCallbackDelegate api33BackCallbackDelegate = this.f40672a;
        if (api33BackCallbackDelegate != null) {
            api33BackCallbackDelegate.b(this.f40673b, this.f40674c, z);
        }
    }

    public final void b() {
        Api33BackCallbackDelegate api33BackCallbackDelegate = this.f40672a;
        if (api33BackCallbackDelegate != null) {
            api33BackCallbackDelegate.a(this.f40674c);
        }
    }
}
