<template>
    <form class="form-grop row" id="submit-form" action="http://localhost:8081/api/upload" method="post">
        <div class="alert" v-bind:class="{'alert-success':result.state==200,'alert-danger':result.state==500}" v-show="result.state!=undefined">
            <!-- <strong>成功!</strong> -->
            {{ result.msg }}
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">标题</span>
            </div>
            <input type="text" class="form-control" placeholder="请输入视频标题" v-model="formObj.title">
        </div>
        
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">地址</span>
            </div>
            <input type="text" class="form-control" placeholder="请输入视频地址" v-model="formObj.url">
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">简介</span>
            </div>
            <textarea class="form-control" rows="2" id="comment" placeholder="请输入视频简介" v-model="formObj.introduction"></textarea>
        </div>
        
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">封面</span>
            </div>
            <input id="avatar" name="avarat" @change="changeImg($event)" type="file" />
        </div>

        <input type="button" class="btn btn-primary" value="立即投稿" style="margin-left: 58px;" @click="submit">
    </form>
</template>

<script>
export default {
    name: "Submit",
    data() {
        return {
                formObj: {
                title: '',
                url: '',
                introduction: '',
                avatar: ''
            },
            result: {}
        }
    },
    methods: {
            submit: function() {
            var formData = new window.FormData()
            var formObj = this.$data.formObj
            var that = this;
            formData.append("title", formObj.title)
            formData.append("url", formObj.url)
            formData.append("introduction", formObj.introduction)
            formData.append("avatar", formObj.avatar)
            this.$http.post('http://127.0.0.1:8081/api/submit', formData).then(function(res) {
                that.$data.result = res.data
                console.log(res)
            }, function(res) {
                console.log(res)
                that.$data.result = res.data
            });
        },
        changeImg: function(event) {
            this.$data.formObj.avatar = event.target.files[0]
        }
    }
}
</script>

<style scoped>

    .submit-video h2 {
        display: block;
        font-size: 1.5em;
        margin-block-start: 0.83em;
        margin-block-end: 0.83em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
    }

    .form-item label {
        width: 80px;
        height: 40px;
        font-size: 14px;
        color: #606266;
        padding: 0 12px 0 0;
        float: left;
        text-align: right;
    }

    .form-item input {
        display: inline-block;
        position: relative;
        margin-left: 80px;
        width: 100%;
        font-family: inherit;
        font-size: inherit;
        line-height: inherit;
        
        -webkit-appearance: none;
        background-color: #fff;
        background-image: none;
        border-radius: 4px;
        border: 1px solid #dcdfe6;
    }

</style>