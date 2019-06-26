package com.rustfisher.githubonandroid.network.service;

import android.support.annotation.Nullable;

import com.rustfisher.githubonandroid.network.NetworkCenter;
import com.rustfisher.githubonandroid.network.bean.GitHubContributor;
import com.rustfisher.githubonandroid.network.bean.Repo;
import com.rustfisher.githubonandroid.network.bean.UserInfo;
import com.rustfisher.githubonandroid.network.bean.UserRepo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Provide Github network service
 */
public interface IGitHubService {
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<GitHubContributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/contributors")
    Observable<List<GitHubContributor>> rxContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    /**
     * Get repos by owner name
     *
     * @param owner    name
     * @param sortType "pushed"
     */
    @GET("users/{owner}/repos")
    Observable<List<UserRepo>> userRepo(
            @Header(NetworkCenter.HEADER_ACT_NAME) @Nullable String actName,
            @Path("owner") String owner,
            @Query("sort") String sortType);

    @GET("repos/{owner}/{repo}")
    Observable<Repo> repo(
            @Path("owner") String owner,
            @Path("repo") String repo);

    // Get user information
    @GET("users/{username}")
    Observable<UserInfo> userInfo(@Path("username") String username);

}
