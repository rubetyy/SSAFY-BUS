<template>
  <div class="container">
    <div class="card">
      <div class="box">
        <div class="content">
          <i class="fas fa-circle online"></i>
          <h3>{{profileDetail.nickname}}</h3>
          <p>{{profileDetail.generation}}기 {{profileDetail.classNum}}반</p>
          <p>{{profileDetail.position}}</p>
          <a href="#" @click="QBoardClick()">무물</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions} from 'vuex'
const boardStore = 'boardStore'
export default {
  props: {
    profileDetail:{
      type: Object,
      required:true
    }
  },
  data() {
    return {

    }
  },
  computed: {
  },
  methods: {
    ...mapActions(boardStore, ['getQBoard']),

    QBoardClick() {
      this.getQBoard(this.profileDetail.userId)
      .then(()=>{
        this.$router.push({name:"QBoard", params: { userid: this.profileDetail.userId}})
      })
    },
  },
}
</script>

<style lang="scss" scoped>
// @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;800&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  // font-family: "Poppins", sans-serif;
}

// body {
//   display: flex;
//   justify-content: center;
//   align-items: center;
//   flex-wrap: wrap;
//   min-height: 100vh;
//   background: #232427;
// }

.container {
  display: flex;
  justify-content: center;
  // align-items: center;
  // flex-wrap: wrap;
  max-width:220px;
  margin: 10px 20px;
  // min-width: 220px;
}

.container .card {
  position: relative;
  min-width: 220px;
  height: 300px;
  background-color: #fff;
  box-shadow: inset 5px 5px 5px rgba(0, 0, 0, 0.2),
    inset -5px -5px 15px rgba(255, 255, 255, 0.1),
    5px 5px 15px rgba(0, 0, 0, 0.3), -5px -5px 15px rgba(255, 255, 255, 0.1);
  border-radius: 15px;
  margin: 30px;
  transition: 0.5s;
}

.container .card:nth-child(1) .box .content a {
  background: #2196f3;
}

.container .card:nth-child(2) .box .content a {
  background: #e91e63;
}

.container .card:nth-child(3) .box .content a {
  background: #23c186;
}
.container .card .box {
  position: absolute;
  top: 15px;
  left: 15px;
  right: 15px;
  bottom: 15px;
  background: #2a2b2f;
  border-radius: 15px;
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  transition: 0.5s;
}

.container .card .box:hover {
  transform: translateY(-20px);
}

.container .card .box:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  // width: 50%;
  height: 100%;
  background: rgba(255, 255, 255, 0.03);
}

.container .card .box .content {
  padding: 20px;
  text-align: center;
}

// .container .card .box .content h2 {
//   position: absolute;
//   top: -10px;
//   right: 30px;
//   font-size: 8rem;
//   color: rgba(255, 255, 255, 0.1);
// }

.container .card .box .content h3 {
  font-size: 1.8rem;
  color: #fff;
  z-index: 1;
  transition: 0.5s;
  margin-bottom: 15px;
}

.container .card .box .content p {
  font-size: 1rem;
  font-weight: 300;
  color: rgba(255, 255, 255, 0.9);
  z-index: 1;
  transition: 0.5s;
  margin-bottom: 8px;
}

.container .card .box .content a {
  position: relative;
  display: inline-block;
  padding: 8px 20px;
  background: black;
  border-radius: 5px;
  text-decoration: none;
  color: white;
  margin-top: 20px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
  transition: 0.5s;
}
.container .card .box .content a:hover {
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.6);
  background: #fff;
  color: #000;
}

.online {
  // background-color: green;
  color: rgb(5, 214, 5);
}
</style>>
