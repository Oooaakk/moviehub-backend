<template>
  <div id= 'building'>
      <HubIcon></HubIcon>
  <div>
    <el-card class="box-card">
      <h2 class="color">Register</h2>
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-position="left"
        label-width="150px"
        class="demo-ruleForm"
      >
        <el-form-item class= "color1" label="Email" prop="uname">
          <el-input v-model="ruleForm.uname"></el-input>
        </el-form-item>
        <el-form-item class = "color1" label="Username" prop="checkusername">
      <el-input class = "inputform" v-model="ruleForm.checkusername" maxlength=16 placeholder="Jack" />
    </el-form-item>
        <el-form-item class = "color1" label="Gender" prop="checkgender">
      <el-select v-model="ruleForm.checkgender" class="m-2" placeholder="Select" size="large">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      />
      </el-select>
    
    </el-form-item>
    <el-form-item class = "color1" label="Age" prop="checkage">
      <el-input-number v-model="ruleForm.checkage" :min="1" :max="120" @change="handleChange" />
    </el-form-item>
        <el-form-item class= "color1" label="Password" prop="pass">
          <el-input
            type="password"
            v-model="ruleForm.pass"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item class = "color1" label="confirm password" prop="confirmPass">
        <el-input  class = "inputform" v-model="ruleForm.confirmPass" type="Password" autocomplete="off"/>
      </el-form-item>
        <el-form-item class= "color1" label="Verification code" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <div class="btnGroup">
        <el-button type="primary" @click="submitForm()"
          >submit</el-button
        >
        <el-button @click="resetForm('ruleForm')">reset</el-button>
        <el-button @click="goBack">back</el-button>
        <el-button @click="submitEmail()">Get verification code</el-button>
      </div>
    </el-card>
  </div>
  </div>
</template>

<script>
import HubIcon from '@/components/HubIcon.vue';
import request from "@/utils/RequestFile.js"
export default {
  data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
        callback(new Error('Please input the password'))
      } else {
        if (value!='' && ((this.ruleForm.pass.length < 8 || this.ruleForm.pass.length > 16))){
          console.log("密码格式错误")
          callback(new Error('Please input correct form of password'))
        }
        
    }
      };
      var validatePass1 = (rule, value, callback) => {
         var reg = /^([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+$/;
          if (!value) {
            return callback(new Error('cannot input empty email!'))
          } else if (!reg.test(value)) {
            return callback(new Error('please input valid email!'))
          } else {
            callback()
          }
  
      };
      var validatePass3 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please input the password again'))
      } else if (value !== this.ruleForm.checkPass) {
        callback(new Error("Two inputs don't match!"))
      } else {
        callback()
      }
      };
      var validatePass4 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please input the username'))
        } else {
          callback()
        }
      };

      var validatePass5 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please input the age'))
        } else {
          callback()
        }
      };
      var validatePass6 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please choose the gender'))
        } else {
          callback()
        }
      }
      var validatePass7 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please input the verification code'))
        } else {
          callback()
        }
      }
      return {
        options: [
          {
          value: 'Male',
          label: 'Male',
        },
        {
          value: 'Female',
          label: 'Female',
        },
    
        ],
          
          ruleForm: {
              uname: "",
              pass: "",
              password: "",
              checkgender: "",
              checkusername: "",
              confirmPass: "",
              checkage: ""
          },
          rules: {
              uname: [
                  { required: true, validator: validatePass1, message: "用户名不能为空！", trigger: "blur" },
              ],
              pass: [{ required: true, validator: validatePass, trigger: "blur" }],
              confirmPass : [{required: true, validator: validatePass3, trigger: "blur"}],
              checkusername : [{required: true, validator: validatePass4, trigger: "blur"}],
              checkage : [{required: true, validator: validatePass5, trigger: "blur"}],
              checkgender: [{required: true, validator: validatePass6, trigger: "blur"}],
              password: [{required: true, validator: validatePass7, trigger: "blur"}],
             
          },
      };
  },
  methods: {
      submitEmail() {
    // 验证表单中的账号密码是否有效，因为在上面rules中定义为了必填 required: true
     
          console.log('submit!')
          request.post("/user/email", {email: this.ruleForm.uname}).then(res => {
          
          console.log("success");
        
      })
        
      
  },
      submitForm() {
          console.log("register!");
          request.post("/user/register", {email: this.ruleForm.uname, password: this.ruleForm.pass, verificationCode: this.ruleForm.password, age: this.ruleForm.checkage, gender: this.ruleForm.checkgender, username: this.ruleForm.checkusername}).then(res => {
              if(res.status === 200){
                this.$message({
                type: "success",
                message: "successfully registered"
                })
                  this.$router.push('/moviehub/loginpage');
              }else {
              this.$message({
                type: "error",
                message: res.message
              })
            }
          })
      },
      resetForm(formName) {
          this.$refs[formName].resetFields();
      },
      goBack() {
          this.$router.go(-1);
      },
  },
  components: { HubIcon }
  
};
</script>

<style scoped>
.box-card {
  margin: auto auto;
  width: 600px;
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
.color {
  color: orange;
}
.color1 .el-form-item__label{
  color : orange;
}
</style>