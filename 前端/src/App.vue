<template>
  <div id="app">
    <Navbar />
    <div id="app-body" class="container">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'
export default {
  name: "App",
  components: {
    Navbar
  }
  
}
</script>

<style lang="scss">

  * {
    margin: 0;
    padding: 0;
  }

  body {
    background-color: #f5f8f9;
  }

#app-body {
  margin-top: 60px;
  a {
    text-decoration: none;
    color: #222;
    cursor:pointer;
  }
  a:hover {
    text-decoration: none;
    color: #00a1d6;
  }
}

.router-link-active {
	font-size: 18px;
}


</style>
