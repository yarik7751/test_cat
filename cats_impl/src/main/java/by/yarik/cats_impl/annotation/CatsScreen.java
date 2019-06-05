package by.yarik.cats_impl.annotation;

import androidx.annotation.IntDef;

@IntDef({CatsScreen.ALL_CATS, CatsScreen.FAVORITE_CATS})
public @interface CatsScreen {

    int ALL_CATS = 1;
    int FAVORITE_CATS = 2;
}
