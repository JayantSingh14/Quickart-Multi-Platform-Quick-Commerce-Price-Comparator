package coil3;

import android.graphics.Canvas;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public interface Image {
    void draw(@NotNull Canvas canvas);

    int getHeight();

    boolean getShareable();

    long getSize();

    int getWidth();
}
