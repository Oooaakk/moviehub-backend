<template>
  <div id= 'building'>
      <HubIcon></HubIcon>
  <div >
    <el-card class="box-card">
      <h2 class = "color">Login</h2>
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-position="left"
        label-width="100px"
        class="login-from"
        hide-required-aterisk="false"
      >
        <el-form-item class = "color1" label="Email" prop="uname" >
          <el-input v-model="ruleForm.uname"></el-input>
        </el-form-item>
        <el-form-item class = "color1" label="Password" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <div>
      <el-button @click="$router.push('/moviehub/forgetpassword')" class="forgetpass">Forgot password?</el-button>
      </div>
      <div class="btnGroup">
          
        <el-button type="primary" @click="submitForm('ruleForm')"
        v-loading="loading"
          >Login
          </el-button>
        <el-button @click="resetForm('ruleForm')">Reset</el-button>
        <router-link to="/moviehub/RegisterPage">
          <el-button style="margin-left:10px">Register</el-button>
        </router-link>
      </div>
    </el-card>
  </div>
</div>
</template>

<script>
import HubIcon from '@/components/HubIcon.vue';
import request from "@/utils/RequestFile.js";
import request2 from "@/utils/Request2.js";
export default {
  data() {
      return {
          components: {
              HubIcon
          },
          ruleForm: {
              uname: "",
              password: "",
          },
          rules: {
              uname: [
                    { required: true, message: "email cannot be blank", trigger: "blur" },
                    { type: "email", message: "input correct email", trigger: "change" },
              ],
              password: [
                    { required: true, message: "password cannot be blank", trigger: "blur" },
              ],
          },
          loading: false,
      };
  },
  methods: {
      submitForm(formName) {
          console.log("submit");
      this.$refs[formName].validate((valid) => {
      // click login, login animation
      this.loading = true;
      // if (valid) {
      //   console.log("movie")
      //   request2.get("/k_gh3vr6fp").then(res => {
      //     console.log("success");
      //   })
      // }
      if (valid) {
          console.log('submit!')
          request.post("/user/login", {email: this.ruleForm.uname, password: this.ruleForm.password}).then(res => {
          if(res.status === 200){
            console.log("success");
        
            this.$router.push('/moviehub/mainpageuser/'+JSON.stringify(res.data));
          }
        
    })
      } else {  
        console.log("error submit!!");
        this.loading = false;
        return false;
      }
      });
  },
      resetForm(formName) {
          this.$refs[formName].resetFields();
      },
  },
  components: { HubIcon }
};
</script>

<style >
.color {
  color: orange;
}
.forgetpass {
  color: orange;
}
.color1 .el-form-item__label{
  color : orange;
}
.box-card {
  margin: auto auto;
  margin-top: 150px;
  width: 400px;
}
.login-from {
  margin: auto auto;
}
#building{
background:url('https://wallpapercave.com/dwp2x/wp11089675.jpg');
width:100%;
height:100%;
position:fixed;
background-size:100% 100%;
}

.btnGroup{
  margin-top: 20px;
}

</style>