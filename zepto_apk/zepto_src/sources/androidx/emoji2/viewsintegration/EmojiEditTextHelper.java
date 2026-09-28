package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class EmojiEditTextHelper {

    /* renamed from: a, reason: collision with root package name */
    public final HelperInternal19 f4392a;

    public static class HelperInternal {
    }

    @RequiresApi
    public static class HelperInternal19 extends HelperInternal {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f4393a;

        /* renamed from: b, reason: collision with root package name */
        public final EmojiTextWatcher f4394b;

        public HelperInternal19(EditText editText) {
            this.f4393a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
            this.f4394b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            if (EmojiEditableFactory.f4396b == null) {
                synchronized (EmojiEditableFactory.f4395a) {
                    try {
                        if (EmojiEditableFactory.f4396b == null) {
                            EmojiEditableFactory emojiEditableFactory = new EmojiEditableFactory();
                            try {
                                EmojiEditableFactory.f4397c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
                            } catch (Throwable unused) {
                            }
                            EmojiEditableFactory.f4396b = emojiEditableFactory;
                        }
                    } finally {
                    }
                }
            }
            editText.setEditableFactory(EmojiEditableFactory.f4396b);
        }
    }

    public EmojiEditTextHelper(EditText editText) {
        this.f4392a = new HelperInternal19(editText);
    }

    public final KeyListener a(KeyListener keyListener) {
        this.f4392a.getClass();
        if (keyListener instanceof EmojiKeyListener) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
    }

    public final InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        HelperInternal19 helperInternal19 = this.f4392a;
        helperInternal19.getClass();
        return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(helperInternal19.f4393a, inputConnection, editorInfo);
    }

    public final void c(boolean z) {
        EmojiTextWatcher emojiTextWatcher = this.f4392a.f4394b;
        if (emojiTextWatcher.f4413c != z) {
            if (emojiTextWatcher.f4412b != null) {
                EmojiCompat emojiCompatA = EmojiCompat.a();
                EmojiCompat.InitCallback initCallback = emojiTextWatcher.f4412b;
                emojiCompatA.getClass();
                Preconditions.c(initCallback, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = emojiCompatA.f4295a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    emojiCompatA.f4296b.remove(initCallback);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            emojiTextWatcher.f4413c = z;
            if (z) {
                EmojiTextWatcher.a(emojiTextWatcher.f4411a, EmojiCompat.a().b());
            }
        }
    }
}
