package school.community.prodiver;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import school.community.dto.AccessTokenDTO;
import school.community.dto.GithubUser;

import java.io.IOException;

/**
 * @Auther:cdx
 * @Date:2020-04-22
 * @Description:school.community.prodiver
 * @Version:1.0
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        //转换Json
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        //发送请求
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        //执行
        try (Response response = client.newCall(request).execute()) {
            //获得返回数据access_token=e72e16c7e42f292c6912e7710c838347ae178b4a&token_type=bearer
            String string = response.body().string();
            //分割数据access_token=e72e16c7e42f292c6912e7710c838347ae178b4a&token_type=bearer
            //获得e72e16c7e42f292c6912e7710c838347ae178b4a
            String token = string.split("&")[0].split("=")[1];
            //返回e72e16c7e42f292c6912e7710c838347ae178b4a
            return token;
        } catch (Exception e) {
            //log.error("getAccessToken error,{}", accessTokenDTO, e);
        }
        return null;
    }
    public GithubUser getUser(String accessToken){

        OkHttpClient client = new OkHttpClient();
        //发送请求
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            //执行
            Response response = client.newCall(request).execute();
            //获取用户信息
            String string = response.body().string();
            //得到一个GithubUser
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            //返回GithubUser
            return githubUser;
        } catch (Exception e) {
           // log.error("getUser error,{}", accessToken, e);
        }
        return null;

    }
}
