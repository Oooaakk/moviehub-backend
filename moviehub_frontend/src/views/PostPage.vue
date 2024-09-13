
<template>

  <div class="common-layout">
      <el-container>
        <el-header class="header" >
          <AvatarIcon/>
        </el-header>
        <el-main class="main">

        <div class="posthere">  Post here </div>  
        </el-main>
        <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-position="left"
        label-width="100px"
        class="login-from">
        
        <el-form-item label = "Movie title: " class="movietitle">
          <el-select @change="choosetitle"
          v-model="form.imdbmovietitle" class="select" placeholder="choose movie title">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"

    />
  </el-select>
        </el-form-item >
        <el-form-item label = "Movie genre: " class="genre">
        <el-select v-model="form.genre" class="select" placeholder="horror">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"

    />
  </el-select>
</el-form-item>
        <el-form-item label = "Review: " class="labelcolor">
        <el-input
        v-model="textarea"
        :rows="3"
         type="textarea"
        placeholder="Please input movie review"
        class="textinput"
        
        />
      </el-form-item>
        <el-form-item label = "Rating: " class="labelcolor">
        <el-rate
          v-model="rating"
          :texts="['oops', 'disappointed', 'normal', 'good', 'great']"
          text-color = 'orange'
          show-text
          class="star"
        ></el-rate>
        
      </el-form-item>
      <el-form-item label = "upload poster: " class="poster">
          <el-input style = "width: 300px" v-model="poster" placeholder="Please input poster link" />
        </el-form-item >
      
      
    </el-form>
    <el-button type="warning" round class="LRbutton" @click="$router.push('/moviehub/dashboard/1234')">Save</el-button> 
  </el-container>
      
    </div>
    
   <HubIcon/>
  </template>


  <script>
import { ref } from 'vue'
import HubIcon from '@/components/HubIcon.vue';
import AvatarIcon from '../components/AvatarIcon.vue';
import request2 from "@/utils/Request2.js";
import request from '@/utils/RequestFile';
export default {
  data() {
    return {
      components: {
              HubIcon
          },
      rules: {
        imdbmovietitle: [
                    { required: true, message: "choose title!!", trigger: "blur" },
        ],
        genre: [
              { required: true, message: "choose gnere!!", trigger: "blur" },
        ],
        textarea: [
              { required: true, message: "review cannot be blank", trigger: "blur" },
        ],
        rating: [
              { required: true, message: "rate the movie please!!", trigger: "blur" },
        ],
        poster: [
              { required: true, message: "choose title first!!", trigger: "blur" },
        ],
      },
      form: {
        imdbmovietitle: "",
        genre: "",
        textarea: "",
        rating: "",
        poster: ""        
      },
      options: [
      {
        value: 'Drama',
        label: 'Drama',
      },
      {
        value: 'Comedy',
        label: 'Comedy',
      },
      {
        value: 'Horror',
        label: 'Horror',
      },
      {
        value: 'Thriller',
        label: 'Thriller',
      },
      {
        value: 'Action',
        label: 'Action',
      },
      {
        value: 'Sci-fi',
        label: 'Sci-fi',
      },
      {
        value: 'Crime',
        label: 'Crime',
      },
      {
        value: 'Adventure',
        label: 'Adventure',
      },
      {
        value: 'Other',
        label: 'Other',
      },
     ],
     movies: [],
    }
  },
  methods:{
    searchTitle () {
      console.log("search movie");
      request2.get("/k_gh3vr6fp").then(res => {
         console.log("success");
      })
    }
  },
  components: { HubIcon }
}





    </script>

<style>
  body {
background-color: #222231;
}
.header{
  background-color: black;

}

.LRbutton{
  width:10%;
  margin-top:25px;
  margin-left:530px;
}
.main{
  background-color: white;
  height:64px;
  
}

.posthere{
  position: absolute;
  font-weight: bold;
  font-size: x-large;
}
.movietitle{
   margin-top:50px;
   margin-left:330px;

}
.labelcolor{
   margin-top:50px;
   margin-left:330px;

}
.textinput{
  margin-left:17px;
  width:50%;
 
}
.star{
  margin-left:24px;
}

.movietitle .el-form-item__label {
  color: orange
}
.genre{
  margin-top:50px;
   margin-left:330px;
}
.genre .el-form-item__label {
  color: orange
}
.poster{
  margin-top:50px;
   margin-left:330px;
}
.poster .el-form-item__label {
  color: orange
}

.labelcolor .el-form-item__label {
  color: orange
}
.movietitleinput{
  width:50%;
}
</style>