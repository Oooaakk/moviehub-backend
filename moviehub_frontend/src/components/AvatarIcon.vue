<template>
  <el-popover
    :width="200"
    trigger="hover"
    content=""
    
  >
  <el-button @click="$router.push('/moviehub/changepassword/1234')" class="cpass">
    <el-icon class="lock"><Lock /></el-icon>change password</el-button>
    <el-button @click="$router.push('/moviehub/dashboard/setting/1234')" class="setting">
      <el-icon class="setting"><Setting /></el-icon>SettingPage</el-button>
    <el-popconfirm
    confirm-button-text="Yes"
    cancel-button-text="No"
    :icon="InfoFilled"
    icon-color="#626AEF"
    title="Are you sure to log out?"
    @confirm="$router.push('/moviehub/loginpage')"
  >
    <template #reference>
      <el-button class="logoutbutton"><el-icon class="Sbutton"><SwitchButton /></el-icon>logout</el-button>
    </template>
  </el-popconfirm>
  
    <template #reference>
      <div class="avatar" >
        <el-avatar 
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
        @click="$router.push('/moviehub/dashboard/1234')"
          /><!--头像-->
    </div>
    </template>
  </el-popover>
  
</template>
<script lang="ts" setup>
  import { InfoFilled } from '@element-plus/icons-vue'
  import { SwitchButton } from '@element-plus/icons-vue'
  import { Setting } from '@element-plus/icons-vue'
  import { Lock } from '@element-plus/icons-vue'
  </script>
<style>
  .avatar{
  position:fixed;
  top:10px;
  left:1210px
}
.avatar:hover{
  cursor:pointer;

}
.setting{
    margin-top:10px
}
.cpass{
    margin-left:11.5px
}
.lock{
  margin-right:5px;
}
.setting{
  margin-right:5px;
  margin-bottom: 10px;
}

.plus{
  margin-right:5px;
}
.Sbutton{
  margin-right: 5px;;
}
</style>
