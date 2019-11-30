package com.rwt.arknights.common.bilibili;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

public class BiliClient {

    private static final String uploaderUrl = "https://api.bilibili.com/x/space/acc/info?mid=";
    private static final String videoUrl = "https://api.bilibili.com/x/web-interface/view?aid=";


    private static String getVideoUrl(int av) {
        return videoUrl + av;
    }
    private static String getUploaderUrl(int uid) {
        return uploaderUrl + uid;
    }

    public static String doGet(String url) {
        // 创建Httpclient对象,相当于打开了浏览器
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建HttpGet请求，相当于在浏览器输入地址
//        HttpGet httpGet = new HttpGet();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        String content = null;
        try {
            // 执行请求，相当于敲完地址后按下回车。获取响应
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("访问b站接口异常：" + url);
        } finally {
            if (response != null) {
                // 关闭资源
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭浏览器
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public static VideoInfoDTO getVideoInfoDTO(int av) {
        String json = doGet(getVideoUrl(av));
        Map map = (Map<String, Object>) JSONUtils.parse(json);
        Map data = (Map<String, Object>) map.get("data");
        VideoInfoDTO dto = new VideoInfoDTO();
        dto.setAvId(av);
        dto.setTitle((String) data.get("title"));
        dto.setPic((String) data.get("pic"));
        dto.setDesc((String) data.get("desc"));
        Map owner = (Map) data.get("owner");
        dto.setUpName((String) owner.get("name"));
        return dto;
    }

    public static void main(String[] args) {
        VideoInfoDTO videoInfoDTO = getVideoInfoDTO(77229177);
        int cc = 1;
    }
}
