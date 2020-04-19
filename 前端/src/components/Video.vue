<template>
  <div id="video-frame">
    <div class="video-top">
      <h2>{{vinfo.title}}</h2>
      <p>2019-07-21 11:50:46创建 · 1561观赏</p>
    </div>
    <video id="video-player" class="video-js vjs-default-skin vjs-big-play-centered vjs-16-9" webkit-playsinline="true" playsinline="true">
      <source ref="source" v-bind:src="vinfo.url" type="video/mp4" />
      <p class="vjs-no-js">
        你的浏览器禁用了JavaScript, 请自行百度解除禁用并刷新此页面~
        <a
          href="//www.baidu.com"
          target="_blank"
        >supports HTML5 video</a>
      </p>
    </video>
    <div class="video-bottom">
      摄影：绯山圣瞳九命猫
      后期：Kyokyo
      我是简介
      我是简介
      我是简介
      我是简介
      我是简介
      我是简介
      我是简介
      我是简介
      我是简介
      我是简介我是简介
      我是简介
      我是简介
      我是简介
      我是简介我是简介
      我是简介
      我是简介
      我是简介
      我是简介我是简介
      我是简介
      我是简介
      我是简介
      我是简介
    </div>
  </div>
</template>

<script>
export default {
  name: "Video",
  data() {
    return {
      vinfo: {}
    };
  },
  mounted() {
    // this.$data.vinfo = this.getVideoInfo(this.$route.params)
    this.$data.vinfo = this.$route.params.videoInfo;
    this.$refs.source.src = this.$data.vinfo.url;
    this.initVideo();
  },
  methods: {
    initVideo() {
      this.$video(document.getElementById("video-player"), {
        controls: true,
        autoplay: false,
        preload: "auto",
        width: "1920px",
        height: "1080px",
        controlBar: {
          playToggle: true
        },
        language:"zh-CN"
      });
      // console.log(player)
    }
  }
};
</script>

<style>

.video-top {
    padding-top: 10px;
}

.video-top h2{
    color: #212121;
    font-size: 18px;
    font-weight: 500;
    overflow: hidden;
    line-height: 26px;
}

.video-top p {
    font-size: 14px;
    color: #999;
}

.video-bottom {
    border-top: 1px solid #a9a9a9;
    margin-top: 5px;
    padding-top: 5px;
    padding-bottom: 30px;
    color: #212121;
    font-size: 12px;

}
</style>