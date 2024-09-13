
<template>

  <div class="common-layout">
      <el-container>
        <el-header class="header" >
          
          <AvatarIcon/>
        
        </el-header>
        
        <el-form 
        >
          
    </el-form>
    
  </el-container>
      
    </div>
    
   <HubIcon/>
  </template>


  <script lang="ts" setup>
    import HubIcon from '@/components/HubIcon.vue';
    import AvatarIcon from '@/components/AvatarIcon.vue';
    </script>

<style>
 
body {
  background-color: #222231;
}
.header{
  background-color: black;

}
.main{
  background-color: white;
  height:64px;
  
}
</style>
