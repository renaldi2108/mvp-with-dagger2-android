package id.renaldirey.daggermvp.holder;

import id.renaldirey.daggermvp.BuildConfig;

/**
 * Created by Kwikku on 13/05/2018.
 */

public class AppConstants {

    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static final String API_KEY = BuildConfig.AUTH_KEY;

    // TODO : API
    public static final String API_POPULAR = "popular";
    public static final String API_TOP_RATED = "top_rated";
    public static final String API_DETAIL = "{movie_id}";

    // TODO : PARAM
    public static final String PARAM_PAGE = "popularmovie.db";

}
