package id.renaldirey.daggermvp.ui.base;

import android.content.Context;

/**
 * Created by Kwikku on 15/05/2018.
 */

public interface BaseView {

    Context getContext();
    void isError(String message);

}