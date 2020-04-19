<template>
    <nav id="Navbar" class="navbar navbar-inner navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="/"><b>Geligeli</b>.com</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <router-link class="nav-link" to="/home">首页</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" to="/submit">视频投稿</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" to="/about">关于我们</router-link>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" aria-label="Search" placeholder="请输入搜索内容" v-model="s">
                    <button @click="search(s)" class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
                </form>
            </div>
        </div>
    </nav>
</template>


<script>

export default {
  name: 'Navbar',
  data() {
    return {
        s: ''
    }
  },
  methods: {
      search: function(s) {
          if(this.$route.name == 'Home'){
              window.location.href="#/Home/" + s
              window.location.reload()
              console.log(this.$route)
          } 
          this.$router.push({
                name: 'Home',
                params: {
                    s
                }
            })
      }
  }
}
</script>

<style lang="scss" scoped>

#Navbar{

.router-link-active {
    font-size: 18px;
    color: #222;
}

.navbar-brand {
    animation: navbar-up 2s 1;
    text-decoration: underline;
    color: #66ccff;
}

.navbar-brand:hover{
    text-decoration: none;
}

@keyframes navbar-up {
    0% {
        transform: translateX(-200%) rotate(-360deg);
        text-decoration: none;
        opacity: .5;
    }
    80%{
        transform: translateX(-50%) rotate(0);
        text-decoration: none;
        opacity: .5;
    }
    100% {
        transform: translateX(0);
        text-decoration: underline;
        opacity: 1;
    }
}

@keyframes navbar-up1 {
    0% {
        transform: translateX(-100%);
    }
    12%{
        transform: translateX(-50%);
    }
    25%{
        transform: translateX(-100%);
    }
    37%{
        transform: translateX(-50%);
    }
    50% {
        transform: translateX(-100%);
    }
    60%{
        transform: translateX(-50%);
    }
    85% {
        transform: translateX(-100%);
    }
    100%{
        transform: translateX(0);

    }
}

}

</style>