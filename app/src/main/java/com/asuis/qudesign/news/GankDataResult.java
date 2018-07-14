package com.asuis.qudesign.news;

import java.util.List;

/**
 * Created by 15988440973 on 2017/12/22.
 * desciption:
 */

public class GankDataResult {

    /**
     * error : false
     * results : [{"_id":"5a30a105421aa90fe2f02cd8","createdAt":"2017-12-13T11:39:49.295Z","desc":"图解ConcurrentHashMap","publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488667&idx=1&sn=9f17d205c9deff7b571c3280ca2b1e10","used":true,"who":"陈宇明"},{"_id":"5a33790f421aa90fe2f02ce0","createdAt":"2017-12-15T15:26:07.407Z","desc":"Android城市选择器源码实现","publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/ndc2vSlQ0cG7uxj_eV5M1w","used":true,"who":"D_clock"},{"_id":"5a35f607421aa90fe2f02ce3","createdAt":"2017-12-17T12:43:51.659Z","desc":"图解RxJava2(一)","images":["http://img.gank.io/403efc72-288f-4c5d-9d6b-ab464e004ede"],"publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"http://rkhcy.github.io/2017/12/13/%E5%9B%BE%E8%A7%A3RxJava2(%E4%B8%80)/","used":true,"who":"HuYounger"},{"_id":"5a373497421aa90fe50c028d","createdAt":"2017-12-18T11:23:03.192Z","desc":"一个能让微信 Material Design 化的 Xposed 模块","images":["http://img.gank.io/061bc21f-be86-40a5-ab6a-ab7c26a8bc36"],"publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"https://github.com/Blankeer/MDWechat","used":true,"who":null},{"_id":"5a37a94a421aa90fef2035a9","createdAt":"2017-12-18T19:40:58.803Z","desc":"基于QQ、微信和微博原生api文档，整合的第三方分享和登陆框架","publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"https://github.com/arvinljw/SocialHelper","used":true,"who":"arvinljw"},{"_id":"5a37de68421aa90fe72536c3","createdAt":"2017-12-18T23:27:36.605Z","desc":"Android APP性能优化的一些思考","publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/vFPMFd8pT1X9oq46waoLGA","used":true,"who":"D_clock"},{"_id":"5a3875e6421aa90fe72536c4","createdAt":"2017-12-19T10:13:58.688Z","desc":"酷酷的Android Loading动画，让用户摆脱无聊等待","publishedAt":"2017-12-19T12:00:28.893Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s/S6NCv-o_kp22hFtwn-84Mg","used":true,"who":"D_clock"},{"_id":"5a2e4011421aa90fe2f02cd1","createdAt":"2017-12-11T16:21:37.459Z","desc":"我打赌你一定没搞明白的Activity启动模式","publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488588&idx=1&sn=3f7c59654835ec8d560610ba97d10fc0","used":true,"who":"陈宇明"},{"_id":"5a2e6a38421aa90fe72536b0","createdAt":"2017-12-11T19:21:28.577Z","desc":"safe adb：在多设备时更方便地操作 adb，支持批量操作。","images":["http://img.gank.io/27c7d4a1-9c3e-42ed-9a21-051cd9f77798"],"publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"https://github.com/linroid/sadb","used":true,"who":"drakeet"},{"_id":"5a2e80d4421aa90fe50c0272","createdAt":"2017-12-11T20:57:56.667Z","desc":"图解ConcurretHashMap","images":["http://img.gank.io/d00aec87-7573-45a0-87bc-f3046ad442d4"],"publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"Android","url":"http://rkhcy.github.io/2017/12/06/%E5%9B%BE%E8%A7%A3ConcurrentHashMap/","used":true,"who":"HuYounger"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5a30a105421aa90fe2f02cd8
         * createdAt : 2017-12-13T11:39:49.295Z
         * desc : 图解ConcurrentHashMap
         * publishedAt : 2017-12-19T12:00:28.893Z
         * source : web
         * type : Android
         * url : https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247488667&idx=1&sn=9f17d205c9deff7b571c3280ca2b1e10
         * used : true
         * who : 陈宇明
         * images : ["http://img.gank.io/403efc72-288f-4c5d-9d6b-ab464e004ede"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ResultsBean)) return false;

            ResultsBean that = (ResultsBean) o;

            if (isUsed() != that.isUsed()) return false;
            if (get_id() != null ? !get_id().equals(that.get_id()) : that.get_id() != null)
                return false;
            if (getCreatedAt() != null ? !getCreatedAt().equals(that.getCreatedAt()) : that.getCreatedAt() != null)
                return false;
            if (getDesc() != null ? !getDesc().equals(that.getDesc()) : that.getDesc() != null)
                return false;
            if (getPublishedAt() != null ? !getPublishedAt().equals(that.getPublishedAt()) : that.getPublishedAt() != null)
                return false;
            if (getSource() != null ? !getSource().equals(that.getSource()) : that.getSource() != null)
                return false;
            if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null)
                return false;
            if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null)
                return false;
            if (getWho() != null ? !getWho().equals(that.getWho()) : that.getWho() != null)
                return false;
            return getImages() != null ? getImages().equals(that.getImages()) : that.getImages() == null;
        }

        @Override
        public int hashCode() {
            int result = get_id() != null ? get_id().hashCode() : 0;
            result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
            result = 31 * result + (getDesc() != null ? getDesc().hashCode() : 0);
            result = 31 * result + (getPublishedAt() != null ? getPublishedAt().hashCode() : 0);
            result = 31 * result + (getSource() != null ? getSource().hashCode() : 0);
            result = 31 * result + (getType() != null ? getType().hashCode() : 0);
            result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
            result = 31 * result + (isUsed() ? 1 : 0);
            result = 31 * result + (getWho() != null ? getWho().hashCode() : 0);
            result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
            return result;
        }
    }
}
