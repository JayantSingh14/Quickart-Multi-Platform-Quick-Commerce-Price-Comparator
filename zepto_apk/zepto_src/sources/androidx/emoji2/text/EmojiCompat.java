package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@AnyThread
/* loaded from: classes.dex */
public class EmojiCompat {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f4293j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile EmojiCompat f4294k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f4295a;

    /* renamed from: b, reason: collision with root package name */
    public final ArraySet f4296b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f4297c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f4298d;

    /* renamed from: e, reason: collision with root package name */
    public final CompatInternal19 f4299e;

    /* renamed from: f, reason: collision with root package name */
    public final MetadataRepoLoader f4300f;

    /* renamed from: g, reason: collision with root package name */
    public final DefaultSpanFactory f4301g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4302h;

    /* renamed from: i, reason: collision with root package name */
    public final GlyphChecker f4303i;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface CodepointSequenceMatchResult {
    }

    public static class CompatInternal {

        /* renamed from: a, reason: collision with root package name */
        public final EmojiCompat f4304a;

        public CompatInternal(EmojiCompat emojiCompat) {
            this.f4304a = emojiCompat;
        }
    }

    @RequiresApi
    public static final class CompatInternal19 extends CompatInternal {

        /* renamed from: b, reason: collision with root package name */
        public volatile EmojiProcessor f4305b;

        /* renamed from: c, reason: collision with root package name */
        public volatile MetadataRepo f4306c;

        /* renamed from: androidx.emoji2.text.EmojiCompat$CompatInternal19$1, reason: invalid class name */
        class AnonymousClass1 extends MetadataRepoLoaderCallback {
            public AnonymousClass1() {
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public final void a(Throwable th) {
                CompatInternal19.this.f4304a.f(th);
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public final void b(MetadataRepo metadataRepo) {
                CompatInternal19 compatInternal19 = CompatInternal19.this;
                compatInternal19.f4306c = metadataRepo;
                MetadataRepo metadataRepo2 = compatInternal19.f4306c;
                EmojiCompat emojiCompat = compatInternal19.f4304a;
                compatInternal19.f4305b = new EmojiProcessor(metadataRepo2, emojiCompat.f4301g, emojiCompat.f4303i, EmojiExclusions.a());
                EmojiCompat emojiCompat2 = compatInternal19.f4304a;
                emojiCompat2.getClass();
                ArrayList arrayList = new ArrayList();
                emojiCompat2.f4295a.writeLock().lock();
                try {
                    emojiCompat2.f4297c = 1;
                    arrayList.addAll(emojiCompat2.f4296b);
                    emojiCompat2.f4296b.clear();
                    emojiCompat2.f4295a.writeLock().unlock();
                    emojiCompat2.f4298d.post(new ListenerDispatcher(arrayList, emojiCompat2.f4297c, null));
                } catch (Throwable th) {
                    emojiCompat2.f4295a.writeLock().unlock();
                    throw th;
                }
            }
        }
    }

    public static abstract class Config {

        /* renamed from: a, reason: collision with root package name */
        public final MetadataRepoLoader f4308a;

        /* renamed from: b, reason: collision with root package name */
        public int f4309b = 0;

        /* renamed from: c, reason: collision with root package name */
        public final GlyphChecker f4310c = new DefaultGlyphChecker();

        public Config(MetadataRepoLoader metadataRepoLoader) {
            this.f4308a = metadataRepoLoader;
        }
    }

    @RestrictTo
    public static class DefaultSpanFactory implements SpanFactory {
    }

    public interface GlyphChecker {
    }

    public static class ListenerDispatcher implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f4311a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4312b;

        public ListenerDispatcher(List list, int i2, Throwable th) {
            Preconditions.c(list, "initCallbacks cannot be null");
            this.f4311a = new ArrayList(list);
            this.f4312b = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = this.f4311a;
            int size = arrayList.size();
            int i2 = 0;
            if (this.f4312b != 1) {
                while (i2 < size) {
                    ((InitCallback) arrayList.get(i2)).a();
                    i2++;
                }
            } else {
                while (i2 < size) {
                    ((InitCallback) arrayList.get(i2)).b();
                    i2++;
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void a(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(Throwable th);

        public abstract void b(MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface ReplaceStrategy {
    }

    public interface SpanFactory {
    }

    public EmojiCompat(Config config) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f4295a = reentrantReadWriteLock;
        this.f4297c = 3;
        MetadataRepoLoader metadataRepoLoader = config.f4308a;
        this.f4300f = metadataRepoLoader;
        int i2 = config.f4309b;
        this.f4302h = i2;
        this.f4303i = config.f4310c;
        this.f4298d = new Handler(Looper.getMainLooper());
        this.f4296b = new ArraySet();
        this.f4301g = new DefaultSpanFactory();
        CompatInternal19 compatInternal19 = new CompatInternal19(this);
        this.f4299e = compatInternal19;
        reentrantReadWriteLock.writeLock().lock();
        if (i2 == 0) {
            try {
                this.f4297c = 0;
            } catch (Throwable th) {
                this.f4295a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                metadataRepoLoader.a(compatInternal19.new AnonymousClass1());
            } catch (Throwable th2) {
                f(th2);
            }
        }
    }

    public static EmojiCompat a() {
        EmojiCompat emojiCompat;
        synchronized (f4293j) {
            try {
                emojiCompat = f4294k;
                if (!(emojiCompat != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return emojiCompat;
    }

    public static boolean c(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z) {
        return EmojiProcessor.b(inputConnection, editable, i2, i3, z);
    }

    public static boolean d(Editable editable, int i2, KeyEvent keyEvent) {
        return EmojiProcessor.c(editable, i2, keyEvent);
    }

    public final int b() {
        this.f4295a.readLock().lock();
        try {
            return this.f4297c;
        } finally {
            this.f4295a.readLock().unlock();
        }
    }

    public final void e() {
        if (!(this.f4302h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f4295a.writeLock().lock();
        try {
            if (this.f4297c == 0) {
                return;
            }
            this.f4297c = 0;
            this.f4295a.writeLock().unlock();
            CompatInternal19 compatInternal19 = this.f4299e;
            EmojiCompat emojiCompat = compatInternal19.f4304a;
            try {
                emojiCompat.f4300f.a(compatInternal19.new AnonymousClass1());
            } catch (Throwable th) {
                emojiCompat.f(th);
            }
        } finally {
            this.f4295a.writeLock().unlock();
        }
    }

    public final void f(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f4295a.writeLock().lock();
        try {
            this.f4297c = 2;
            arrayList.addAll(this.f4296b);
            this.f4296b.clear();
            this.f4295a.writeLock().unlock();
            this.f4298d.post(new ListenerDispatcher(arrayList, this.f4297c, th));
        } catch (Throwable th2) {
            this.f4295a.writeLock().unlock();
            throw th2;
        }
    }

    public final CharSequence g(CharSequence charSequence, int i2, int i3) {
        if (!(b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        Preconditions.a(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.a(i2 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.a(i3 <= charSequence.length(), "end should be < than charSequence length");
        return (charSequence.length() == 0 || i2 == i3) ? charSequence : this.f4299e.f4305b.e(charSequence, i2, i3, false);
    }

    public final void h(InitCallback initCallback) {
        Preconditions.c(initCallback, "initCallback cannot be null");
        this.f4295a.writeLock().lock();
        try {
            if (this.f4297c == 1 || this.f4297c == 2) {
                this.f4298d.post(new ListenerDispatcher(Arrays.asList(initCallback), this.f4297c, null));
            } else {
                this.f4296b.add(initCallback);
            }
            this.f4295a.writeLock().unlock();
        } catch (Throwable th) {
            this.f4295a.writeLock().unlock();
            throw th;
        }
    }

    public final void i(EditorInfo editorInfo) {
        if (b() != 1 || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        CompatInternal19 compatInternal19 = this.f4299e;
        compatInternal19.getClass();
        editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", compatInternal19.f4306c.a());
        Bundle bundle = editorInfo.extras;
        compatInternal19.f4304a.getClass();
        bundle.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }

    /* loaded from: classes3.dex */
    public static abstract class InitCallback {
        public void b() {
        }

        public void a() {
        }
    }
}
