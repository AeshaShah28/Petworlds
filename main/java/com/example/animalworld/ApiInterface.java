package com.example.animalworld;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface
{
    @GET(ApiConfig.URL_LIST_petworld)
    Call<PetResponse> URL_LIST_Animal();

    @GET(ApiConfig.URL_LIST_page)
    Call<PaginationResponse> URL_List_page(@Query("page") String page,
                                             @Query("limit") String limit);

    @GET(ApiConfig.URL_LIST_sortBy)
    Call<SortingResponse> URL_List_sortBy(@Query("sortBy") String sortBy,
                                             @Query("order") String order);
}
