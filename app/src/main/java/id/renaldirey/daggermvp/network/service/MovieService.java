package id.renaldirey.daggermvp.network.service;

import java.util.List;

import id.renaldirey.daggermvp.network.response.Response;
import id.renaldirey.daggermvp.network.response.ResponsePopular;
import id.renaldirey.daggermvp.holder.AppConstants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Kwikku on 13/05/2018.
 */

public interface MovieService {

    @GET(AppConstants.API_POPULAR)
    Observable<Response<List<ResponsePopular>>> popularService(
            @Query("api_key") String api_key,
            @Query("page") int page
    );

    @GET(AppConstants.API_TOP_RATED)
    Observable<Response<List<ResponsePopular>>> topRatedService(
            @Query("api_key") String api_key,
            @Query("page") int page
    );

    @GET(AppConstants.API_DETAIL)
    Observable<Response<List<ResponsePopular>>> detailMovieService(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key,
            @Query("language") String language
    );

}
