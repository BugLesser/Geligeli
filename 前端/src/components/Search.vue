<template>
		<div id="Search-frame" style="margin-top: 60px;">
			<div class="row">
				<div id="video-item" class="col-lg-4 col-md-4 col-sm-6 col-xs-12 video-item" v-for="video in pageInfo.list" v-bind:key="video.id">
					<a @click="goVideo(video)">
						<div class="video-content">
							<div class="video-img">
								<!-- :src="video.avatar" -->
								<img class="video-avatar w-100 h-100 img-fluid" src="../assets/avatar.png" >
								<!-- 不显示视频时长 -->
								<span>06:32:18</span>
							</div>
							<div class="video-info">
								<p class="video-title" href="#" :title="video.title">{{ video.title }}</p>
								<div class="video-tags">
									<i class="fa fa-play-circle-o watch" title="播放量"><span>{{ video.watch }}</span></i>
									<i class="fa fa-clock-o time" title="上传时间"><span>{{ video.time }}</span></i>
									<i class="fa fa-user-o user" title="作者"><span>{{ video.user + video.id }}</span></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<nav style="margin-top: 2rem; margin-bottom: 2rem;">
				<ul class="pagination justify-content-center">
					<li class="page-item" v-bind:class="{disabled:pageInfo.isFirstPage}"><a class="page-link" @click="goPage(1)">首页</a></li>
					<li class="page-item" v-bind:class="{disabled:!pageInfo.hasPreviousPage}"><a class="page-link" @click="goPage(pageInfo.prePage)">上一页</a></li>
					<div v-for="pageNum in pageInfo.navigatepageNums" v-bind:key="pageNum">
						<li class="page-item" v-bind:class="{active:pageNum==pageInfo.pageNum}"><a class="page-link" @click="goPage(pageNum)">{{ pageNum }}</a></li>
					</div>
					<li class="page-item" v-bind:class="{disabled:!pageInfo.hasNextPage}"><a class="page-link" @click="goPage(pageInfo.nextPage)">下一页</a></li>
					<li class="page-item" v-bind:class="{disabled:pageInfo.isLastPage}"><a class="page-link" @click="goPage(pageInfo.pages)">尾页</a></li>
				</ul>
			</nav>
		</div>
</template>

<script>
export default {
    name: "Search",
    data() {
        return {
			pageInfo: {
				list:[]
			},
			s:''
        }
	},
	created() {
		console.log("我是搜索页面。。。")
		console.log(this.$route.params.s)
		this.$data.pageInfo = this.$route.params.pageInfo == undefined ? {list:[]} :  this.$route.params.pageInfo ;
		this.$data.s = this.$route.params.s
		if(this.$route.params.s == undefined) {
			alert('s is null')
			this.$router.push({
				name: 'Home'
			})
			return;
		}
		this.goPage(1)
	},
	methods: {
		goPage: function(pageNum) {
			console.log("goPage: " + pageNum)
			//发送 post 请求
			if(this.$data.s=='') {
				this.$router.push({
					name: 'Home'
				})
				return;
			}
			var data = {
				s:this.$data.s,
				page: pageNum,
				size: 6
			}
			this.$http.post('http://127.0.0.1:8081/api/search', data, {
				emulateJSON: true
			}).then(function(res) {
				this.$data.pageInfo = res.body;
				console.log('success\t' + res.body)
			}, function(res) {
				console.log('error： ' + res)
			});
		},
		goVideo: function(videoInfo) {
			console.log(videoInfo)
			this.$router.push({
				name: 'Video',
				params: {
					videoInfo
				}
			})
		}
	}
}
</script>

<style scoped>

.video-item {
	float: left;
	height: auto;
	padding: 5px;
}

.video-content {
	float: left;
	padding: 10px;
	box-shadow: 0 2px 10px 0 rgba(0,0,0,.1);
}

.video-img {
	position: relative;
	overflow: hidden;
	border-radius: 5px;
}

.video-img span {
	position: absolute;
	right: 0;
	bottom: 0;
	line-height: 18px;
	padding: 0 5px;
	color: #fff;
	background-color: rgba(0,0,0,.5);
}

.video-info {
	padding: 5px;
}

.video-title {
	font-size: 16px;
	line-height: 20px;
	height: 40px;
	color: #303133;
	margin-bottom: 12px;
	overflow : hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
}

.keyword {
	color: #f25d8e;
}

.video-tags i {
	float: left;
	color: #303133;
	font-size: 14px;
	margin-right: 8px;
	margin-bottom: 12px;
}

.video-tags span {
	margin-left: 3px;
}

.video-tags .watch {
	width: 100px;
}


.video-tags .time {
	width: 150px
}


.video-tags .user {
	width: 100%;
}

.fa {
	margin-right: 10px;
}

</style>