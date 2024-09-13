<template>

  <div class="common-layout">
      <el-container>
        <el-header class="header">
         
    <AvatarIcon/>
        </el-header>
        <el-main>
          <reviewCard/>
        </el-main>
        
      </el-container>
      
    </div>
    <HubIcon/>
  </template>
  <script lang="ts" setup>


import HubIcon from '@/components/HubIcon.vue';
import AvatarIcon from '@/components/AvatarIcon.vue';
import reviewCard from '@/components/reviewCard.vue';
  
    </script>
  <style scoped>
.demo-type {
  display: flex;
}
.demo-type > div {
  flex: 1;
  text-align: center;
}

.demo-type > div:not(:last-child) {
  border-right: 1px solid var(--el-border-color);
}
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
.recommend{
  position:absolute;
  font-size:x-large;
  font-weight:bold;
}
</style>