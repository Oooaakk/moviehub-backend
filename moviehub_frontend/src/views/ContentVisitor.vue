<template>

  <div class="common-layout">
      <el-container>
        <el-header class="header">
          
      <el-button type="warning" round class="LRbutton" @click="$router.push('/moviehub/loginpage')">Login/Register</el-button>  
        </el-header>
        <el-main>
        </el-main>
        
      </el-container>
      
    </div>
    <HubIcon/>
  </template>
  <script lang="ts" setup>

    import HubIcon from '@/components/HubIcon.vue';
  
    </script>
  <style>
    .header{
    background-color: black;
  
    }
    
  .search{
    width:45%;
    margin-top: 15px;
  }
  .select{
    margin-left:10px;
    width:10%;
  }
  .LRbutton{
    position:fixed;
    top:12px;
    right:35px
  }
  .recommend{
    position:absolute;
    font-size:x-large;
    font-weight:bold;
  }
  
  </style>