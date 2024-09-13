<template>

<div class="common-layout">
    <el-container>
      <el-header class="header">
        <el-input
      v-model="input1"
      class="search"
      placeholder="Please Input"
      :suffix-icon="Search"
    />
    <el-select v-model="value2" class="select" placeholder="sortBy">
    <el-option
      v-for="item in optionsSort"
      :key="item.value"
      :label="item.label"
      :value="item.value"
    
    />
  </el-select>
  <el-select v-model="value" class="select" placeholder="filter">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"
      
    />
  </el-select>
  
    <el-button type="warning" round class="LRbutton" @click="$router.push('/moviehub/loginpage')">Login/Register</el-button>  
      </el-header>
      <el-main>
        <div class="recommend">Recommend movies</div>
          
      </el-main>
      
    </el-container>
    
  </div>
  <HubIcon/>
</template>
<script lang="ts" setup>
  import { ref } from 'vue'
  import { Search } from '@element-plus/icons-vue'
  import HubIcon from '@/components/HubIcon.vue';
  const input1 = ref('')
  const value = ref('')
  const value2=ref('')

const options = [
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
 ]
 const optionsSort = [
  {
    value: 'rating',
    label: 'rating',
  },
  {
    value: 'Name',
    label: 'Name',
  },
  
 ]  
 
  </script>
<style>
  .header{
  background-color: black;

  }
.search{
  width:45%;
  margin-top: 15px;
  margin-left:150px
}
.select{
  margin-left:10px;
  width:10%;
}
.LRbutton{
  position:relative;

  right:-85px
}
.recommend{
  position:absolute;
  font-size:x-large;
  font-weight:bold;
}

</style>