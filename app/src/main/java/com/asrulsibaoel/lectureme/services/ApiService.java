package com.asrulsibaoel.lectureme.services;

import com.asrulsibaoel.lectureme.models.response.Category.CategoryResponse;
import com.asrulsibaoel.lectureme.models.response.CharRoomListResponse.ListChatResponse;
import com.asrulsibaoel.lectureme.models.response.ChatHistory.ChatHistory;
import com.asrulsibaoel.lectureme.models.response.ChatResponse.ChatResponse;
import com.asrulsibaoel.lectureme.models.response.ImageResponse.ImageResponse;
import com.asrulsibaoel.lectureme.models.response.Login.LoginResponse;
import com.asrulsibaoel.lectureme.models.response.Profile.ProfileResponse;
import com.asrulsibaoel.lectureme.models.response.RegisterResponse;
import com.asrulsibaoel.lectureme.models.response.Timeline.TimelineResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by asrulsibaoel on 9/6/16.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("/account/login")
    Call<LoginResponse> connectLogin(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("/account/register")
    Call<RegisterResponse> connectRegister(@Field("email") String email, @Field("password") String password, @Field("name") String name);

    @FormUrlEncoded
    @POST("/api/chat/create")
    Call<ChatResponse> sendMessage(@Field("text") String message, @Field("receiver_id") Integer receiverId, @Field("products_id") Integer productd);

    @GET("/api/chats_room/?q=&page=1&sortby=created_at&order=desc&filters[name]=&filters[id]=")
    Call<ListChatResponse> getListChat();

    @GET("/api/chat/")
    Call<ChatHistory> getChatHistory(@Query("filters[chats_rooms_id]") Integer chatRoomId);

    @GET("/api/product/?sortby=created_at&order=desc")
    Call<TimelineResponse> getTimeline();

    @GET("/api/account/profile")
    Call<ProfileResponse> getProfile();


    @GET("api/category")
    Call<CategoryResponse> getCategory();

    @Multipart
    @POST("api/image/upload")
    Call<ImageResponse> postImage(
            @Part MultipartBody.Part image,
            @Part("name") RequestBody name);


}
